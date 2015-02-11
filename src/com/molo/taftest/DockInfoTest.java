package com.molo.taftest;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.molo.test.TafBaseService;
import com.qq.jce.WCS.AttrInfo;
import com.qq.jce.WCS.QueryDockInfoRequest;
import com.qq.jce.WCS.QueryDockInfoResponse;

public class DockInfoTest extends TafBaseService {
	
	private static Logger logger = Logger.getLogger(DockInfoTest.class);
	
	private static int COMMAND_ID_QUERY_DOCK_INFO_REQUEST = 3031; // 查询DOCK信息请求
	
	/**
	 "dock_bugreport_guid"; //  default_dock_bugreport_guid
	 "dock_info_cv";        //  second_dock_info_cv || first_dock_info_cv  || default_dock_info_cv
	 "dock_client_cv";      //  区分来自不同的渠道，如电脑管家 default_dock_client_cv
	 "dock_guid";		    //  default_dock_guid
	 "dock_ex_param";       //  是否全新安装：default_dock_ex_param  1:全新   0：非全新
	 * */
	@Test
	public void getInfo() throws ClientProtocolException, IOException{
		ArrayList<AttrInfo> vecAttrInfo = new ArrayList<AttrInfo>();
		// 请求参数
		String[] info = {"dock_bugreport_guid","dock_ex_param","dock_info_cv","dock_client_cv"};
		String[] val  = {"1111111","1","second_dock_info_cv","10.2.15395.212"};
		
		
		for(int i=0;i<=info.length-1;i++){
			
			AttrInfo attr = new AttrInfo();
			attr.setSName(info[i]);
			attr.setSValue(val[i]);	
			vecAttrInfo.add(attr);
			
		}
		
		QueryDockInfoRequest req = new QueryDockInfoRequest();
		req.setVecAttrInfo(vecAttrInfo);
		
		QueryDockInfoResponse rsp = (QueryDockInfoResponse) executeTafReq(COMMAND_ID_QUERY_DOCK_INFO_REQUEST, req, new QueryDockInfoResponse());
		
			
		System.out.println("升级文件数：" + rsp.getVecInfos().size());
		System.out.println("升级文件：" + rsp.getVecInfos());
		System.out.println("dock状态   关闭1  开启0:" + rsp.getEDockInfoStatus());
		
		System.out.println("dock文件描述:" + rsp.getSDockDesc());
		System.out.println("dock禁用类型描述:" + rsp.getSDockInvalidDesc());
		
	}
}
