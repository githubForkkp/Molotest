package com.molo.taftest;

import com.molo.datadriver.ExcelDataProvider;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qq.jce.WCS.AttrInfo;
import com.qq.jce.WCS.QueryClientUpdateInfoRequest;
import com.qq.jce.WCS.QueryClientUpdateInfoResponse;

public class PcUpdateService extends TafBaseTest{
	
	// command
	private static int QUERY_CLIENT_UPDATE_INFO_REQ = 3201;
	// test  : 112.90.140.215 : 10001  
	// online: 112.64.237.239  : 8080
	private static String IP = "112.64.237.239";
	// port
	private static int PORT = 8080;
	
	
	/**
	 * 
	 * TAF测试数据仓库
	 * 入参：XLS文件名		sheet名对应测试的方法名
	 * 
	 * */
	@DataProvider(name = "dp")
	public Iterator<Object[]> dataFortestMethod(Method method) throws IOException{
	      return new ExcelDataProvider("ClientUpdate",method.getName()); 
	}
	
	
	// 配置update request
	public QueryClientUpdateInfoRequest  adminRequest(Map<String,String> data,Boolean UseDataProvider){
		
		QueryClientUpdateInfoRequest queryClientUpdateInfoRequest = new QueryClientUpdateInfoRequest();
		ArrayList<AttrInfo>  vecAttrInfo = new ArrayList<AttrInfo>();
		
		
		if(UseDataProvider){
			for(String o : data.keySet()){
				
				String value = data.get(o);
				if(!value.equals("")){
					AttrInfo e = new AttrInfo();
					e.setSName(o);
					e.setSValue(value);
					e.setNDefault(0);
					vecAttrInfo.add(e);
				}
			}
		}
		else
		{
		
		//getProperties
		
		Properties  pro = getProperties("ClientUpdate");
		
//		// 客户端版本号
//		String cu_cv = pro.getProperty("cu_cv", "");
//		// 升级网段
//		String cu_ipr = pro.getProperty("cu_ipr", "");
//		// 升级省份
//		String cu_prov = pro.getProperty("cu_prov", "");
//		// 城市
//		String cu_city = pro.getProperty("cu_city", "");
//		// ISP服务提供商
//		String cu_isp = pro.getProperty("cu_isp", "");
//		// 
//		String cu_channel = pro.getProperty("cu_channel", "");
//		// 客户端类型    0: 完整版本  1: Mini版本
//		String cu_ct = pro.getProperty("cu_ct", "");
//		// 升级QQ
//		String cu_uin = pro.getProperty("cu_uin", "");
//		// 升级方式   1: 自动升级 0:手动升级
//		String cu_ut = pro.getProperty("cu_ut", "");
		
		Set<String> keys = pro.stringPropertyNames();
		
		for(String o : keys){
			
			String value = pro.getProperty(o);
			
			if(!value.equals("")){
				AttrInfo e = new AttrInfo();
				e.setSName(o);
				e.setSValue(value);
				e.setNDefault(0);
				vecAttrInfo.add(e);
			}
			
		}
	}
		
		queryClientUpdateInfoRequest.setVecAttrInfo(vecAttrInfo);
			
		return queryClientUpdateInfoRequest;
	} 
	
	
	
	// 发送update
	public QueryClientUpdateInfoResponse getUpdateInfo(Map<String,String> data,Boolean UseDataProvider) throws ClientProtocolException, IOException{
		
		byte[] requestCommand = ByteBuffer.allocate(4)
                .putInt(this.QUERY_CLIENT_UPDATE_INFO_REQ).array();
			
		byte[] requestEntity = getRequestEntity(adminRequest(data,UseDataProvider));
		
		List<byte[]> list = new ArrayList<byte[]>();
        list.add(requestCommand);
        list.add(requestEntity);

        byte[] requestBody = sysCopy(list);
        HttpClient client = new DefaultHttpClient();
        HttpResponse  httpResponse = execute(client, IP, PORT, requestBody);
        
        QueryClientUpdateInfoResponse result = processAddUpdateInfoResponseBatch(client,httpResponse);
		
		return result;
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
	
	
	private QueryClientUpdateInfoResponse processAddUpdateInfoResponseBatch(HttpClient client,
            HttpResponse response)
            throws IllegalStateException,
            IOException {
		QueryClientUpdateInfoResponse res = new QueryClientUpdateInfoResponse();
        try {

            byte[] responseEntity = getResponseEntity(response);
            if (responseEntity.length != 0) {

                JceInputStream jceInputStream = new JceInputStream(responseEntity);
                jceInputStream.setServerEncoding("utf-8");
                res.readFrom(jceInputStream);
               
            }

        } finally {
            if (client != null) {
                client.getConnectionManager().shutdown();
            }
        }

        return res;

    }
	
	private byte[] getResponseEntity(HttpResponse response) throws IllegalStateException, IOException {

        if (response != null) {
            // int statusCode = response.getStatusLine().getStatusCode();
            // Header[] headers = response.getAllHeaders();

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
}
