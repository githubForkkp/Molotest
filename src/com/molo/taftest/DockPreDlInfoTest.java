package com.molo.taftest;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;

import com.molo.test.TafBaseService;
import com.qq.jce.WCS.AttrInfo;
import com.qq.jce.WCS.QueryDockPreDlInfoRequest;
import com.qq.jce.WCS.QueryDockPreDlInfoResponse;

public class DockPreDlInfoTest extends TafBaseService {
	
	private static int COMMAND_ID_QUERY_DOCK_PRE_DL_INFO_REQUEST         = 3051; // 查询DOCK预下载信息请求
	
	/**
	   "dock_pre_dl_cv";         //  dock大版本
	   "dock_pre_dl_com_cv";     //  dock组件版本
       "dock_pre_dl_cli_cv";     //  dock管家版本
       "dock_pre_dl_oper";       //  dock预下载请求操作(启动请求<1>或者手动请求<2>)
       "dock_pre_dl_guid";       //  客户端guid(pcid)
       "dock_pre_dl_ip";         //  客户端IP
       "dock_pre_dl_app_m_ver";  //  应用宝版本(当没有应用宝版本时，用字段'none_version'代替)
    */
	
		@Test
		public void queryInfo() throws ClientProtocolException, IOException{
			ArrayList<AttrInfo> vecAttrInfo = new ArrayList<AttrInfo>();
			// 请求参数
			String[] info = {"dock_pre_dl_cv","dock_pre_dl_com_cv","dock_pre_dl_cli_cv","dock_pre_dl_oper","dock_pre_dl_app_m_ver"};
			String[] val  = {"2.0","2.0.0.1","10.2.15385.208","2","none_version"};
			
			for(int i=0;i<=info.length-1;i++){
				
				AttrInfo attr = new AttrInfo();
				attr.setSName(info[i]);
				attr.setSValue(val[i]);	
				vecAttrInfo.add(attr);
				
			}
			QueryDockPreDlInfoRequest req = new QueryDockPreDlInfoRequest();
		
			req.setVecAttrInfo(vecAttrInfo);
			
			QueryDockPreDlInfoResponse rsp = (QueryDockPreDlInfoResponse) executeTafReq(COMMAND_ID_QUERY_DOCK_PRE_DL_INFO_REQUEST, req, new QueryDockPreDlInfoResponse());
			
			System.out.println("应用宝下载地址："+rsp.getStInfo().getSUrl());
			System.out.println("应用宝安装包MD5："+rsp.getStInfo().getSMd5());
			System.out.println("应用宝版本号："+rsp.getStInfo().getSVersion());
			// 启动请求<1>或者手动请求<2>
			System.out.println("预下载请求类型(启动请求<1>或者手动请求<2>)："+rsp.getStInfo().getSClientOper());
			// 是否强制下载(0--false；1--true)
			System.out.println("是否强制下载(0--false；1--true)："+rsp.getStInfo().getNForceDownload());
			// (0--None;1--预下载;3--预下载＆预安装) 
			System.out.println("是否支持预下载(0--None;1--预下载;3--预下载＆预安装)："+rsp.getStInfo().getNSupportType());
			// 下载流量控制
			System.out.println("下载流量控制："+rsp.getStInfo().getVThreshold());
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
			System.out.println("上一次开启该规则的时间："+rsp.getLReleaseTime());
			System.out.println("升级数量限制, <=0 为无限制："+rsp.getLQueryLimit());
			System.out.println("规则开启时长，单位s, <=0为无限制："+rsp.getNEnablePeriod());
			
		}
}
