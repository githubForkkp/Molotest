package com.molo.taftest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;

import com.molo.test.TafBaseService;
import com.qq.jce.WCS.QueryConnServiceInvalidRequest;
import com.qq.jce.WCS.QueryConnServiceInvalidResponse;

public class ConnServiceInvalid extends TafBaseService {
	
	private static int COMMAND_ID_QUERY_CONN_SERVICE_INVALID_REQUEST = 3025;// 查询连接服务不可用信息
	
	/**查询连接服务不可用信息
	 * 
	const string NAME_CONN_SERVICE_INVALID_GUID             = "csi_guid";  			  // default_csi_guid
	const string NAME_CONN_SERVICE_INVALID_PCID             = "csi_pcid";             // default_csi_pcid
	const string NAME_CONN_SERVICE_INVALID_CRASH_SIGNATURE  = "csi_crash_signature";  // default_csi_crash_signature
	const string NAME_CONN_SERVICE_INVALID_IP_RANGE         = "csi_ipr";
	const string NAME_CONN_SERVICE_INVALID_PROVINCE         = "csi_prov";
	const string NAME_CONN_SERVICE_INVALID_CITY             = "csi_city";
	const string NAME_CONN_SERVICE_INVALID_ISP              = "csi_isp";
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * */
	@Test
	public void QueryConnServiceInvalid_isOk() throws ClientProtocolException, IOException{
		
		String[] attr ={"csi_guid","csi_pcid","csi_crash_signature"};
		String[] val  ={"1111","D4BED9B9D848_4450E7C9","333"}; 
		
		QueryConnServiceInvalidRequest req = new QueryConnServiceInvalidRequest();
		req.setVecAttrInfo(getAttrInfo(attr, val));
		
		QueryConnServiceInvalidResponse rsp = (QueryConnServiceInvalidResponse) 
				executeTafReq(COMMAND_ID_QUERY_CONN_SERVICE_INVALID_REQUEST,req,new QueryConnServiceInvalidResponse());
		
		if(rsp.getEResultCode() != 1){
			System.out.println(rsp.getEResultCode());
			System.out.println("采用何种停用方案(0 停用  1 升级后启用)："+rsp.getEInvalidStatus());
			System.out.println("若连接服务停用方案为先升级后启动时，此结构放置升级所需信息："+rsp.getStUpgradeInfo());
			System.out.println("流量控制："+rsp.getLUpdateLimit());
		}else{
			System.out.println("关闭状态："+rsp.getEResultCode());
		}
	}
	
	
}

