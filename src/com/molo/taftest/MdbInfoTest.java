package com.molo.taftest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;

import com.molo.test.TafBaseService;
import com.qq.jce.WCS.QueryMdbInfoRequest;
import com.qq.jce.WCS.QueryMdbInfoResponse;

public class MdbInfoTest extends TafBaseService {
	
	private static int COMMAND_ID_QUERY_MDB_REQUEST = 3451;
	
	/**
	 * 
	const string NAME_MDB_VERSION = "mdb_ver";
    const string NAME_MDB_CHN = "mdb_chn";
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * */
	
	@Test
	public void QueryMdbInfo_isOk() throws ClientProtocolException, IOException{
		String[] attr ={"mdb_ver","mdb_chn"};
		String[] val  ={"1.0.0.406","0X8E74DCD2"};
		
		QueryMdbInfoRequest req = new QueryMdbInfoRequest();
		req.setVecAttrInfo(getAttrInfo(attr, val));
		
		QueryMdbInfoResponse rsp = (QueryMdbInfoResponse) executeTafReq(COMMAND_ID_QUERY_MDB_REQUEST,req,new QueryMdbInfoResponse());
		
		
		if(rsp.getEResultCode() != 1){
			System.out.println("MDB开启信息(0开启  1关闭)：" + rsp.getEMdbResult());
		}else{
			System.out.println("关闭中！");
		}
	
	}
}
