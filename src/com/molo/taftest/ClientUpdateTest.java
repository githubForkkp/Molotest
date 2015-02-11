package com.molo.taftest;

import java.io.IOException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.molo.Utils.AppUtils;
import com.qq.jce.WCS.QueryClientUpdateInfoResponse;

public class ClientUpdateTest extends PcUpdateService {
	
	 /*******************测试用例注意：有几条升级策略，需对应几个测试方法**********************/
	@BeforeTest
	public void initDB(){
		//new PostDataTool();
	}
	
	@Test(dataProvider = "dp")
	public void RuleDemo1(Map<String,String> data) throws ClientProtocolException, IOException{
		QueryClientUpdateInfoResponse res = getUpdateInfo(data,true);
		
		System.out.println("状态码：" + res.eResultCode);
		System.out.println("目标版本：" + res.sUpdateVersion);
		System.out.println("下载地址：" + res.sDownloadUrl);
		// 包类型		1：绿色包  2：安装包  3:绿色安装包
		System.out.println("包类型（1：绿色包  2：安装包  3:绿色安装包）：" + res.ePackType);
		// 升级方式 	1：强制升级 2：非强制升级 3：静默升级
		System.out.println("升级方式（1：强制升级 2：非强制升级 3：静默升级）：" + res.eUpdateType);
		System.out.println("看下lReleaseTime：" + res.lReleaseTime);
		System.out.println("规则别名：" + res.sAlias);
		System.out.println("安装参数：" + res.sInstallParam);
		System.out.println("MD5：" + res.sMd5);
		System.out.println("注册表值：" + res.sRegKey);
		System.out.println("提示URL：" + res.sReleaseNoteUrl);
		
	}
	
	
	/**
	 * 
	 * 升级绿色包    本地IP：101.71.243.68
	 * 
	 * */
	
	// 4.2.0.3805 to 4.2.1.1234
	@Test(dataProvider = "dp" )
	public void GreenTest420_3805to421_1234(Map<String,String> data) throws ClientProtocolException, IOException{
		
		QueryClientUpdateInfoResponse res = getUpdateInfo(data,true);
		
		if(res.eResultCode == 0 ){
			
			// 包类型		1：绿色包  2：安装包
			Assert.assertEquals(res.ePackType, 1, "非绿色包！！");
			Assert.assertEquals(res.sUpdateVersion, "4.2.1.1234", "升级版本不对！！");
			// 升级方式 	1：强制升级 2：非强制升级 3：静默升级
			Assert.assertEquals(res.eUpdateType, 3, "非静默升级！！");
			
			AppUtils.UrlCheck(res.sDownloadUrl);

			System.out.println("看下lReleaseTime：" + res.lReleaseTime);
			System.out.println("看下sAlias：" + res.sAlias);
			System.out.println("看下sInstallParam：" + res.sInstallParam);
			System.out.println("看下sMd5：" + res.sMd5);
			System.out.println("看下sRegKey：" + res.sRegKey);
			System.out.println("看下sReleaseNoteUrl：" + res.sReleaseNoteUrl);
			System.out.println("看下sUpdateVersion：" + res.sUpdateVersion);
			
		}else{
			
			if(!data.get("cu_cv").equals("4.2.0.3805")){
				Assert.assertEquals(res.eResultCode, 1, "客户端版本不在升级范围内！！");
			}
			
		}
				
	} 
	
}
