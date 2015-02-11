package com.molo.taftest;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;

import com.molo.test.TafBaseService;
import com.qq.jce.WCS.AttrInfo;
import com.qq.jce.WCS.QueryVirtualVersionRequest;
import com.qq.jce.WCS.QueryVirtualVersionResponse;

public class WirelessConnTest extends TafBaseService {
	
	private static int COMMAND_ID_QUERY_CONN_CHECK_VIRTUAL_VERSION_REQUEST = 3154;// 查询虚拟版本号请求
	
	@Test
	public void getVersion() throws ClientProtocolException, IOException{
		
		// 请求头
		String[] info = {"cc_cv"};
		String[] val  = {"4500129"};
		
		ArrayList<AttrInfo> vecAttrInfo = getAttrInfo(info,val);
		QueryVirtualVersionRequest req = new QueryVirtualVersionRequest();
	
		req.setVecAttrInfo(vecAttrInfo);
		
		QueryVirtualVersionResponse rsp = (QueryVirtualVersionResponse) executeTafReq(COMMAND_ID_QUERY_CONN_CHECK_VIRTUAL_VERSION_REQUEST, req, new QueryVirtualVersionResponse());
		
		System.out.println("虚拟版本号："+rsp.getNVirtualVersion());
		
	}

	
	
}
