package com.molo.test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;



import com.molo.taftest.TafBaseTest;
import com.qq.jce.MAAccess.AppInfoForUpdate;
import com.qq.jce.MAAccess.GetAppUpdateReq;
import com.qq.jce.MAAccess.GetSearchSuggestReq;
import com.qq.jce.WCS.AppAssociateRequest;
import com.qq.jce.WCS.AppUpdateInfoRequest;
import com.qq.jce.WCS.AppUpdateUinRequest;
import com.qq.jce.WCS.AttrInfo;
import com.qq.jce.WCS.BaseInfoRequest;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public class TafBaseService extends TafBaseTest {
		// 获取基本信息
		public static int COMMAND_ID_BASE_INFO_REQ       = 4031;
		// 获取app更新信息请求
		public static int COMMAND_ID_APP_UPDATE_INFO_REQ = 4041;
		// 获取应用联想信息请求
		public static int COMMAND_ID_APP_ASSOCIATE_REQ   = 4043;
		// 根据UIN获取App更新(应用中心)
		public static int COMMAND_ID_APP_UPDATE_UIN_REQ  = 4045;
		
		// test  : 112.90.140.215 : 10001  
		// online: 112.64.237.239  : 8080
		public static String IP = "112.90.140.215";
		// port
		public static int PORT = 10001;
		
		
		// 抽取请求头参数
		public ArrayList<AttrInfo> getAttrInfo(String[] key,String[] value) {
			ArrayList<AttrInfo> vecAttrInfo = new ArrayList<AttrInfo>();
		
			for(int i=0;i<=key.length-1;i++){
				
				AttrInfo attr = new AttrInfo();
				attr.setSName(key[i]);
				attr.setSValue(value[i]);	
				vecAttrInfo.add(attr);
				
			}
			return vecAttrInfo;
		}
		
		
		// 基本信息
		public BaseInfoRequest requestStruct() {
			
			BaseInfoRequest res = new BaseInfoRequest();
			
			res.setSSrcIp("");
			
			return res;
		}
		
		//应用联想
		public AppAssociateRequest AssReq(String Keyword){
			AppAssociateRequest req = new AppAssociateRequest();
			GetSearchSuggestReq sugreq = new GetSearchSuggestReq();
			
			sugreq.setKeyword(Keyword);
			
			req.setStReq(sugreq);
			
			return req;
		}
		
		
		
		// 应用升级  包名，内部版本号，manifestMD5
		public AppUpdateInfoRequest UpdateReq(ArrayList<AppInfoForUpdate> applist){
			AppUpdateInfoRequest  req = new AppUpdateInfoRequest();
			GetAppUpdateReq upReq = new GetAppUpdateReq();
		
			
			upReq.setAppInfoForUpdateList(applist);
			
			req.setStReq(upReq);
						
			return req;
		}
		
		// UIN更新应用中心
		public AppUpdateUinRequest UinReq(long uin){
			AppUpdateUinRequest req = new AppUpdateUinRequest();
			
			req.setLUin(uin);
			
			return req;
		}
		
		
		// 发送taf请求
		public JceStruct executeTafReq(int command, JceStruct requestStruct, JceStruct responseStruct)
	            throws ClientProtocolException, IOException {
	        byte[] requestCommand = ByteBuffer.allocate(4)
	                .putInt(command).array();
	        byte[] requestEntity = getRequestEntity(requestStruct);

	        List<byte[]> list = new ArrayList<byte[]>();
	        list.add(requestCommand);
	        list.add(requestEntity);
	        byte[] requestBody = sysCopy(list);
	        HttpClient client = new DefaultHttpClient();
	        HttpResponse httpResponse = execute(client, IP, PORT, requestBody);

	        try {

	            byte[] responseEntity = getResponseEntity(httpResponse);
	            JceInputStream jceInputStream = new JceInputStream(responseEntity);
	            jceInputStream.setServerEncoding("utf-8");
	            responseStruct.readFrom(jceInputStream);

	        } finally {
	            if (client != null) {
	                client.getConnectionManager().shutdown();
	            }
	        }
	        return responseStruct;
	    }
		
		private byte[] getResponseEntity(HttpResponse response) throws IllegalStateException, IOException {

	        if (response != null) {

	            HttpEntity httpEntity = response.getEntity();
	            InputStream inputStream = httpEntity.getContent();

	            byte[] responseBody = IOUtils.toByteArray(inputStream);

	            byte[] responseCommand = new byte[4];// command,size=4bytes
	            byte[] responseEntity = new byte[responseBody.length - responseCommand.length];

	            System.arraycopy(responseBody, 0, responseCommand, 0, responseCommand.length);
	            System.arraycopy(responseBody, responseCommand.length, responseEntity, 0, responseEntity.length);
	            return responseEntity;

	        } else {
	            return new byte[0];
	        }

	    }
		
		
		private byte[] getRequestEntity(com.qq.taf.jce.JceStruct struct) {
	        JceOutputStream outputStream = new JceOutputStream();
	        outputStream.setServerEncoding("utf-8");
	        struct.writeTo(outputStream);
	        ByteBuffer buffer = outputStream.getByteBuffer();

	        buffer.clear();
	        byte[] requestEntity = new byte[buffer.capacity()];
	        buffer.get(requestEntity, 0, requestEntity.length);

	        return requestEntity;
	    }
		
		private byte[] sysCopy(List<byte[]> srcArrays) {
	        int len = 0;
	        for (byte[] srcArray : srcArrays) {
	            len += srcArray.length;
	        }
	        byte[] destArray = new byte[len];
	        int destLen = 0;
	        for (byte[] srcArray : srcArrays) {
	            System.arraycopy(srcArray, 0, destArray, destLen, srcArray.length);
	            destLen += srcArray.length;
	        }
	        return destArray;
	    }
}
