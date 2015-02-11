package com.molo.taftest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;

import com.molo.test.TafBaseService;
import com.qq.jce.DEVICE_DRIVER_SVR.ConnDeviceDriverRequest;
import com.qq.jce.DEVICE_DRIVER_SVR.ConnDeviceDriverResponse;
import com.qq.jce.DEVICE_DRIVER_SVR.OSBits;
import com.qq.jce.DEVICE_DRIVER_SVR.OSVersion;


/**
 * 设备驱动
 * 
 * */
public class DeviceDriverTest extends TafBaseService {
	
	private final static int COMMAND_ID_CONN_DEVICE_DRIVER_REQ = 2111;
	
	
	
	@Test
	public void ConnDeviceDriver_isOk() throws ClientProtocolException, IOException{
		ConnDeviceDriverRequest req = new ConnDeviceDriverRequest();
		
		// 入参
		String pcid       = "11111";
		String DeviceName = "22222";
		
		String vid        = "0489";
		String Pid        = "c008";
		
		
		
		req.setSPCID(pcid);
		req.setSVID(vid);
		req.setSPID(Pid);
		req.setEOSVer(OSVersion._OV_COMMON);// _OV_XP  _OV_WIN7   _OV_COMMON
		req.setEOSBits(OSBits._OB_32);// _OB_COMMON  _OB_64  _OB_32
		req.setBCommon(false);// 通用驱动标示
		
		ConnDeviceDriverResponse rsp = (ConnDeviceDriverResponse)
				executeTafReq(COMMAND_ID_CONN_DEVICE_DRIVER_REQ, req, new ConnDeviceDriverResponse());
		
		System.out.println(rsp.getSDriverUrl());
		System.out.println(rsp.getVInterfaces());
	}
}
