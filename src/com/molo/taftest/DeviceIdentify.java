package com.molo.taftest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;

import com.molo.test.TafBaseService;
import com.qq.jce.DEVICE_IDENTIFY_SVR.DeviceDetailsRequest;
import com.qq.jce.DEVICE_IDENTIFY_SVR.DeviceDetailsResponse;
import com.qq.jce.DEVICE_IDENTIFY_SVR.DeviceIdentifyRequest;
import com.qq.jce.DEVICE_IDENTIFY_SVR.DeviceIdentifyResponse;

/**
 * 设备识别
 * 
 * */
public class DeviceIdentify extends TafBaseService {
	

	private final static int COMMAND_ID_DEVICE_IDENTIFY_REQ = 2201;
	private final static int COMMAND_ID_DEVICE_DETAILS_REQ  = 2207;
	
	
	/**
	 * 
	ALL_KEY = "all_key";

    VID = "vid";

    BRAND_MODAL = "brand_model";

    MODAL = "model";

    DEVICE_DESC = "device_desc";

    DEVICE_NAME = "device_name";

    PID = "pid";
	 * */
	@Test
	public void DeviceIdentify_isOk() throws ClientProtocolException, IOException{
		DeviceIdentifyRequest req = new DeviceIdentifyRequest();
		
		Map<String,String> map = new HashMap<String, String>();
		ArrayList<Map<String,String>> list = new ArrayList<Map<String,String>>();
		String sPCID = "22";
		
		
		map.put("all_key", "");
		map.put("vid", "0BDC");
		map.put("pid", "0001");
		map.put("brand_model", "");
		map.put("model", "");
		
		map.put("device_desc", "");
		map.put("device_name", "");
		
		
		
		list.add(map);
		req.setSPCID(sPCID);
		req.setVDeviceInfos(list);
		
		DeviceIdentifyResponse rsp = (DeviceIdentifyResponse)
				executeTafReq(COMMAND_ID_DEVICE_IDENTIFY_REQ, req, new DeviceIdentifyResponse());
		
		System.out.println(rsp);
		
	}
	
	@Test
	public void DeviceDetails_isOk() throws ClientProtocolException, IOException{
		Map<String,String> map = new HashMap<String, String>();
		String sPCID = "22";
		
		
		map.put("all_key", "9BB5\\2008\\dsad");
		map.put("vid", "18D1");
		map.put("brand_model", "");
		map.put("model", "");
		map.put("pid", "4E22");
		map.put("device_desc", "");
		map.put("device_name", "DELLVENUE8");
		
		
		DeviceDetailsRequest req = new DeviceDetailsRequest();
		
		
		req.setSPCID(sPCID);
		req.setMDeviceInfos(map);
		DeviceDetailsResponse rsp = (DeviceDetailsResponse)
				executeTafReq(COMMAND_ID_DEVICE_DETAILS_REQ, req, new DeviceDetailsResponse());
		
		System.out.println(rsp);
		
	}
}
