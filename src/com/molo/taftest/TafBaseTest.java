package com.molo.taftest;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;

import com.qq.jce.vmarket.wmarket.MAccessReqHead;
import com.qq.jce.vmarket.wmarket.MAccessRequest;
import com.qq.jce.vmarket.wmarket.MAccessResponse;
import com.qq.jce.vmarket.wmarket.MAccessRspHead;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceStruct;


public class TafBaseTest {
	
	// 调ws服务
	public JceStruct getWsService(String cmd,JceStruct requestStruct,JceStruct responseStruct){
		 HttpClient client = new DefaultHttpClient();
	        // http://ty.3gqq.com/webservices/ws.do
		 	// http://ws.cs0309.3g.qq.com/wmarket/data.htm
		 	// http://ws.sj.qq.com/webservices/ws.do
		 
	        HttpPost httpPost = new HttpPost("http://ws.sj.qq.com/webservices/ws.do");
	        httpPost.setHeader(HTTP.CONTENT_TYPE, "application/octet-stream");

	        // HttpHost host = new HttpHost("10.148.144.231", 80);

	        MAccessRequest req = new MAccessRequest();

	        MAccessReqHead head = new MAccessReqHead();
	        head.setBusinessId("");
	        head.setCmd(cmd);

	        req.setMAccessReqHead(head);

	        //GetBannerReq getBannerReq = new GetBannerReq();

	        req.setBody(requestStruct.toByteArray("utf-8"));

	        byte[] reqBody = req.toByteArray("utf-8");
	        HttpEntity byteArrayEntity = new ByteArrayEntity(reqBody);
	        httpPost.setEntity(byteArrayEntity);

	        try {
	            HttpResponse httpResponse = client.execute(httpPost);

	            if (httpResponse != null) {
	                HttpEntity httpEntity = httpResponse.getEntity();
	                InputStream inputStream = httpEntity.getContent();
	                byte[] responseBody = IOUtils.toByteArray(inputStream);
	                JceInputStream jceInputStream = new JceInputStream(responseBody);
	                jceInputStream.setServerEncoding("utf-8");

	                MAccessResponse mResponse = new MAccessResponse();
	                mResponse.readFrom(jceInputStream);
	                //MAccessRspHead resHead = mResponse.getMAccessRspHead();
	                byte[] resBody = mResponse.getBody();
	                JceInputStream resInput = new JceInputStream(resBody);
	                resInput.setServerEncoding("utf-8");
	                //GetBannerRsp getBannerRsp = new GetBannerRsp();
	                responseStruct.readFrom(resInput);
	                
	            }

	        } catch (ClientProtocolException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            client.getConnectionManager().shutdown();
	        }
			return responseStruct;
}
	// 调tas服务
	public JceStruct getTaservice(String cmd,JceStruct requestStruct,JceStruct responseStruct){
		 HttpClient client = new DefaultHttpClient();
	        // http://cofeni.kf0309.3g.qq.com/wmarket/test.htm
		 	// http://ws.cs0309.3g.qq.com/wmarket/data.htm
		 	// http://hdm.qq.com/data.htm
	        HttpPost httpPost = new HttpPost("http://hdm.qq.com/data.htm");
	        httpPost.setHeader(HTTP.CONTENT_TYPE, "application/octet-stream");

	        // HttpHost host = new HttpHost("10.148.144.231", 80);

	        MAccessRequest req = new MAccessRequest();

	        MAccessReqHead head = new MAccessReqHead();
	        head.setBusinessId("");
	        head.setCmd(cmd);

	        req.setMAccessReqHead(head);

	        //GetBannerReq getBannerReq = new GetBannerReq();

	        req.setBody(requestStruct.toByteArray("utf-8"));

	        byte[] reqBody = req.toByteArray("utf-8");
	        HttpEntity byteArrayEntity = new ByteArrayEntity(reqBody);
	        httpPost.setEntity(byteArrayEntity);

	        try {
	            HttpResponse httpResponse = client.execute(httpPost);

	            if (httpResponse != null) {
	                HttpEntity httpEntity = httpResponse.getEntity();
	                InputStream inputStream = httpEntity.getContent();
	                byte[] responseBody = IOUtils.toByteArray(inputStream);
	                JceInputStream jceInputStream = new JceInputStream(responseBody);
	                jceInputStream.setServerEncoding("utf-8");

	                MAccessResponse mResponse = new MAccessResponse();
	                mResponse.readFrom(jceInputStream);
	                //MAccessRspHead resHead = mResponse.getMAccessRspHead();
	                byte[] resBody = mResponse.getBody();
	                JceInputStream resInput = new JceInputStream(resBody);
	                resInput.setServerEncoding("utf-8");
	                //GetBannerRsp getBannerRsp = new GetBannerRsp();
	                responseStruct.readFrom(resInput);
	                
	            }

	        } catch (ClientProtocolException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            client.getConnectionManager().shutdown();
	        }
			return responseStruct;
}
	
	// 调taf服务
	public HttpResponse execute(HttpClient client, String ip, int port,
			byte[] data) throws ClientProtocolException, IOException {
		HttpEntity byteArrayEntity = new ByteArrayEntity(data);

		HttpPost httpPost = getHttpPost();
		
		httpPost.setEntity(byteArrayEntity);
		

		HttpResponse response = client.execute(getHttpHost(ip, port), httpPost);
		return response;
	}
	
	public HttpPost getHttpPost() {
        HttpPost httpPost = new HttpPost("/");
        httpPost.setHeader("Content-Type", "application/octet-stream");
        return httpPost;
    }
	
	public HttpHost getHttpHost(String ip, int port) {
	        HttpHost host = new HttpHost(ip, port);
	        return host;
	    }
	
	/**
	 * 
	 * 测试数据
	 * path: /data/items.properties
	 * 
	 * */
	public static Properties getProperties(String filename) {
		Properties prop = new Properties();
		try {
			FileInputStream file = new FileInputStream("./data/"+filename+".properties");
			prop.load(file);
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
}
