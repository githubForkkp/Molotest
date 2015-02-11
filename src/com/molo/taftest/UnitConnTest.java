package com.molo.taftest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;

import com.molo.test.TafBaseService;
import com.qq.jce.WCS.QueryComponentInfoRequest;
import com.qq.jce.WCS.QueryComponentInfoResponse;
import com.qq.jce.WCS.QueryFixInfoRequest;
import com.qq.jce.WCS.QueryFixInfoResponse;
import com.qq.jce.WCS.QueryUpdateInfoRequest;
import com.qq.jce.WCS.QueryUpdateInfoResponse;

public class UnitConnTest extends TafBaseService {
		
	private static int COMMAND_ID_QUERY_UPDATE_INFO_REQUEST    = 3001; //查询全量升级信息
	private static int COMMAND_ID_QUERY_FIX_INFO_REQUEST       = 3004; //查询组件修复信息
	private static int COMMAND_ID_QUERY_COMPONENT_INFO_REQUEST = 3012; //查询组件下载信息
	
	//查询全量升级信息
	@Test(invocationCount=5)
	public void QueryUpdateInfo_isOk() throws ClientProtocolException, IOException{
		
		/*
			const string NAME_CUR_VERSION ="cv";
			const string NAME_IP_RANGE = "ipr";
			const string NAME_PROVINCE = "prov";
			const string NAME_CITY = "city";
			const string NAME_ISP = "isp";	
			const string NAME_CHANNEL = "channel";
			const string NAME_CLIENT_TYPE = "ct";
			const string NAME_MODULE = "m";
			const string NAME_UIN = "uin";
		*/
		
		String[] attr ={"cv"};
		String[] val  ={"1.0.0.291"}; 
		
		QueryUpdateInfoRequest req = new QueryUpdateInfoRequest();
		
		req.setVecAttrInfo(getAttrInfo(attr, val));
		
		QueryUpdateInfoResponse rsp = (QueryUpdateInfoResponse)executeTafReq(COMMAND_ID_QUERY_UPDATE_INFO_REQUEST, req, new QueryUpdateInfoResponse());
		
		System.out.println("当前版本："+val[0]+";" + "目标版本："+rsp.getSUpdateVersion());
		System.out.println("升级类型："+rsp.getEUpdateType());
		System.out.println("下载URL："+rsp.getSDownloadUrl());
		System.out.println("MD5："+rsp.getSMd5());
		System.out.println("安装参数："+rsp.getSInstallParam());
		
	}
	
	//查询组件修复信息
	@Test
	public void QueryFixInfo_isOk() throws ClientProtocolException, IOException{
		
		String[] attr ={"fix_cv"};
		String[] val  ={"1.0.0.365"}; 
		
		QueryFixInfoRequest req = new QueryFixInfoRequest();
		req.setVecAttrInfo(getAttrInfo(attr, val));
		
		QueryFixInfoResponse rsp = (QueryFixInfoResponse)executeTafReq(COMMAND_ID_QUERY_FIX_INFO_REQUEST, req, new QueryFixInfoResponse());
		
		System.out.println("目标版本："+rsp.getSVersion());
		System.out.println("MD5："+rsp.getSMd5());
		System.out.println("下载URL："+rsp.getSDownloadURL());
		
	}
	
	//查询组件下载信息
	@Test
	public void QueryComponentInfo_isOk() throws ClientProtocolException, IOException{
		
		String[] attr ={"comp_cv"};
		String[] val  ={"1.0.0.148"}; 
		
		QueryComponentInfoRequest req = new QueryComponentInfoRequest();
		req.setVecAttrInfo(getAttrInfo(attr, val));
		
		QueryComponentInfoResponse rsp = (QueryComponentInfoResponse)executeTafReq(COMMAND_ID_QUERY_COMPONENT_INFO_REQUEST, req, new QueryComponentInfoResponse());
		
		System.out.println("文件数："+rsp.getVecComponents().size());
		System.out.println(rsp.getVecComponents());
		
		
	}
}
