package com.molo.taftest;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.molo.test.TafBaseService;
import com.qq.jce.WCS.AttrInfo;
import com.qq.jce.WCS.QueryDockUnitConnInfoRequest;
import com.qq.jce.WCS.QueryDockUnitConnInfoResponse;


/**
 * Dock后台配置统一连接服务接入
 * 
 * */
public class DockUnitConnInfoTest extends TafBaseService {
	
	private static Logger logger = Logger.getLogger(DockUnitConnInfoTest.class);
	
	private static final int COMMAND_ID_QUERY_DOCK_UNIT_CONN_INFO_REQUEST     	= 3061;
	
	/**
	 * dock版本号：dock_conn_dock_ver
	 * 管家版本号：dock_conn_cleint_ver
	 * 统一连接服务版本号：dock_conn_service_ver
	 * 
	 * */
	@Test
	public void DockConnInfo() throws ClientProtocolException, IOException{
		ArrayList<AttrInfo> vecAttrInfo = new ArrayList<AttrInfo>();
		
		// 对大小写敏感
		String[] info = {"dock_conn_dock_ver","dock_conn_cleint_ver","dock_conn_service_ver"};
		String[] val  = {"1.2","2.2","3.2.2"};
		
		QueryDockUnitConnInfoRequest req = new QueryDockUnitConnInfoRequest();
		
		
		for(int i=0;i<=info.length-1;i++){
			
			AttrInfo attr = new AttrInfo();
			attr.setSName(info[i]);
			attr.setSValue(val[i]);	
			vecAttrInfo.add(attr);
			
		}
		
		req.setVecAttrInfo(vecAttrInfo);
		
		QueryDockUnitConnInfoResponse rsp = (QueryDockUnitConnInfoResponse)executeTafReq(COMMAND_ID_QUERY_DOCK_UNIT_CONN_INFO_REQUEST, req, 
				new QueryDockUnitConnInfoResponse());
		
		if(rsp.getEResultCode() == 0){
			logger.info(rsp);
		}else{
			logger.info("查找失败！");
		}
	}
}
