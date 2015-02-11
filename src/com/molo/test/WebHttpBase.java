package com.molo.test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.List;

import javax.net.ssl.SSLException;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
//import org.apache.commons.httpclient.methods.RequestEntity;
//import org.apache.commons.httpclient.methods.StringRequestEntity;
//import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
//import org.apache.tools.ant.filters.StringInputStream;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;






public class WebHttpBase {
	
	private static Logger logger = Logger.getLogger(WebHttpBase.class);
	
	public static String M4_URL     = "http://m4.qq.com";
	
	public static String DAILY4_URL = "http://m4.cs0309.3g.qq.com/m4";
	
	public static String PRE4_URL   = "http://androidpc.cs0309.3g.qq.com/m4";
	
	public static String M5_URL     = "http://m5.qq.com";
	
	public static String DAILY5_URL = "http://m5.cs0309.3g.qq.com/m5";
	
	public static String PRE5_URL   = "http://androidpc.cs0309.3g.qq.com/m5";
	
	public static String WS_URL     = "http://ws.sj.qq.com/webservices";
	
	public static String DAILY_WS_URL = "http://ty.cs0309.3g.qq.com/webservices";
	
	public static String PRE_WS_URL   = "http://ws.cs0309.3g.qq.com/webservices";
	
	public static String BOLELI = "http://boleli.kf0309.wcd.qq.com/m5";
	
	
	
	public  String getHttpResponse4Get(String url){
		
		HttpClient httpClient = new HttpClient();
		
		GetMethod httpGet = new GetMethod(url);
		httpGet.addRequestHeader("content-type", "text/html; charset=gbk");

		httpGet.getParams().setCookiePolicy(CookiePolicy.RFC_2109);
		
		//GET超时
		httpGet.getParams().setSoTimeout(10000);
		
		httpGet.setRequestHeader("cookie", "RK=bLGigPi0SF; pgv_pvi=670274560; pgv_si=s8715596800; qqmusic_uin=; qqmusic_key=; qqmusic_fromtag=; c_sub_id3=3; qqB_short=1; pt2gguin=o0041947921; uin=o0041947921; ptisp=cnc; ptcz=abd47cb58c1b3b4d0cdafa5b7c08ee5f487de73e30102d8c7fa1b081e81096de; pgv_info=ssid=s9825338592; pgv_pvid=6032489968; o_cookie=41947921;isVideo_DC=0");
		
		
		try {
			// 连接读取超时
			httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(10000);
			httpClient.getHttpConnectionManager().getParams().setSoTimeout(10000);
			
			// 设置成了默认的恢复策略，在发生异常时候将自动重试3次，在这里你也可以设置成自定义的恢复策略
			httpGet.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler());
			
			
			if (httpClient.executeMethod(httpGet) != HttpStatus.SC_OK) {
				
				logger.info("httpGet(\"" + url + "\") failed: \n"+ httpGet.getStatusLine());
				
				return "";
			}
			
//			Header[] header = httpGet.getRequestHeaders();
//			for(int i=0;i<=header.length-1;i++){
//				logger.info("responseHeader:"+header[i]);
//			}
			getClassName();
			
			return convertStreamToString(httpGet.getResponseBodyAsStream());

		} catch (Exception e) {
			
			logger.info("httpGet(\"" + url + "\") failed: \n" + e.getMessage());
			return "";

		} finally{
			
			httpGet.releaseConnection();
			
			httpClient = null;
		}
		
	}
	/*
	 * post：name-value形式
	 */
	public  String getHttpResponse4Post(String url,List<NameValuePair> postParameters){
		// 设置 重试
				HttpRequestRetryHandler retryHandler = new HttpRequestRetryHandler(){
					
					 @Override
					 public boolean retryRequest(IOException exception,  
					            int executionCount, HttpContext context) {  
					        if (executionCount >= 3) {  
					            // Do not retry if over max retry count  
					            return false;  
					        }  
					        if (exception instanceof InterruptedIOException) {  
					            // Timeout  
					            return false;  
					        }  
					        if (exception instanceof UnknownHostException) {  
					            // Unknown host  
					            return false;  
					        }  
					        if (exception instanceof ConnectTimeoutException) {  
					              // Connection refused  
					            return false;  
					        }  
					        if (exception instanceof SSLException) {  
					            // SSL handshake exception  
					            return false;  
					        }  
					        HttpClientContext clientContext = HttpClientContext.adapt(context);  
					        HttpRequest request = clientContext.getRequest();  
					        boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);  
					        if (idempotent) {  
					            // Retry if the request is considered idempotent
					            return true;  
					        }  
					        return false;  
					    }  
					
				};
		
	    	CloseableHttpClient client = HttpClients.custom().setRetryHandler(retryHandler).build();

	    	
	        HttpPost request = new HttpPost(url); 
	        
	        try {
	        	
	        	//自定义参数
	        	//使用NameValuePair来保存要传递的Post参数 
	        	
//	        	List<NameValuePair> postParameters = new ArrayList<NameValuePair>(); 
	 
	        	//添加要传递的参数   
	 
//	        	postParameters.add(new BasicNameValuePair("id", "12345")); 
//	 
//	        	postParameters.add(new BasicNameValuePair("username", "dave"));
	        
	         
	        	//实例化UrlEncodedFormEntity对象 
	 
	        	UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity( 
	 
	                postParameters); 
	        	
	 
	        	//使用HttpPost对象来设置UrlEncodedFormEntity的Entity 
	        	
	        	
	        	request.setEntity(formEntity);
	 
	        	CloseableHttpResponse response = client.execute(request); 
	   
		   
	        	if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
	 
	        		String s = EntityUtils.toString(response.getEntity(), "utf-8");
	 
	        		//logger.info(s);
	 
	        		logger.info("请求ok.");
	 
	        		return s;
	 
	        	}
	 
	        	} catch (Exception e) {
	 
	        		logger.info("请求发生异常，异常信息抛出");
	 
	        		e.printStackTrace();
	 
	        	} finally{
	    	   
	        		request.releaseConnection();
	        		client = null;
	        	}
	        	return "";
	   
	        	
	}
	
	/*
	 * post：取body形式
	 * 
	 */	
	public static String httpPost(String url, String params) {
		        HttpClient client = null;
		        PostMethod post = null;
		        
		        try {
		            client = new HttpClient();
		            post = new PostMethod(url);
		            
		            RequestEntity requestEntity = new StringRequestEntity(params,"text/xml","utf-8");
		            
		            post.setRequestEntity(requestEntity);  
		           
		            int code = client.executeMethod(post);
		            
		            
		            if (code != 200) {
		                return null;
		            }
		            
		            //logger.info(post.getParameters().length);
		            
		            return post.getResponseBodyAsString();
		        } catch (HttpException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        } finally {
		            if (post != null) {
		            	post.abort();
		            }
		        }

		        return null;
		    }
	
	
	/**
	 * 字符串转json
	 *
	 * **/
	
	public JSONObject toJson(String result) throws JSONException{
		JSONObject JSON =  new JSONObject(result);
		return JSON;
			
	}
	
	/**
	 * Urlencode
	 * @throws UnsupportedEncodingException 
	 * 
	 * **/
	public String urlencode(String str) throws UnsupportedEncodingException{
		return URLEncoder.encode(str,"UTF-8");
	}
	
	/**
	 * json异常处理
	 *
	 * **/
	public void PrintFail(String re,Exception e){
		e.printStackTrace();
		String error = "<font  color=\"red\" size=\"2\"><strong>异常为:"+e.getMessage()+"</strong></font><br>";
		Assert.fail(error+"响应的结果:" + re +"<br>");
	}
	
	/**
	 * 打印当前调用者
	 * 
	 * */
	public void getClassName(){
		StackTraceElement stack[] = Thread.currentThread().getStackTrace();
		
		logger.info("Current running:" + stack[3].getMethodName());
	}
	
	
	/**
	 * StreamtoString
	 * @throws UnsupportedEncodingException 
	 * */
	public String convertStreamToString(InputStream is) throws UnsupportedEncodingException {   

		   BufferedReader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));   

		   StringBuilder sb = new StringBuilder();   

		   String line = null;   

		   try {   
			   	while ((line = reader.readLine()) != null) {   
			   		sb.append(line);   
		        }   

		   } catch (IOException e) {   

		            e.printStackTrace();   

		   } finally {   

		          try {   

		               is.close();   

		            } catch (IOException e) {   

		                e.printStackTrace();   

		            }}
		   
		   return sb.toString();  
		   
	}

}