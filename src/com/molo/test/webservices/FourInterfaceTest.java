package com.molo.test.webservices;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.molo.test.TafBaseService;
import com.qq.jce.MAAccess.AppDetail;
import com.qq.jce.MAAccess.AppInfoForUpdate;
import com.qq.jce.WCS.AppAssociateResponse;
import com.qq.jce.WCS.AppUpdateInfoResponse;
import com.qq.jce.WCS.AppUpdateUinResponse;
import com.qq.jce.WCS.BaseInfoResponse;

public class FourInterfaceTest extends TafBaseService {
	
	
	@Test
	public void BaseInfo_isOk() throws ClientProtocolException, IOException{
		BaseInfoResponse resp = (BaseInfoResponse) executeTafReq(COMMAND_ID_BASE_INFO_REQ,requestStruct(),new BaseInfoResponse());
		
		Assert.assertTrue("" != resp.getSSrcIp());
		Assert.assertTrue(resp.getLCurTime()>0);
		
		System.out.println("时长："+resp.getLCurTime()/60/60);
		
		
	}
	@Test
	public void AppSearch_isOk() throws ClientProtocolException, IOException{
		
		String keyword = "qq";
		
		AppAssociateResponse resp = (AppAssociateResponse) executeTafReq(COMMAND_ID_APP_ASSOCIATE_REQ,AssReq(keyword),new AppAssociateResponse());
		
		for(AppDetail d : resp.getVItems()){
			System.out.println(d.getAppName());
		}
		
		Assert.assertTrue(!resp.getVItems().isEmpty(),"搜索已安装qq无结果！！");
		
		Assert.assertEquals(resp.getVItems().get(0).getAppName(), "QQ");
		
		Assert.assertTrue(!resp.getVKeywordsList().isEmpty(),"更多应用下载为空！！");
		
		System.out.println(resp.getVKeywordsList());
	}
	
	@Test
	public void UpdateUin_isOk() throws ClientProtocolException, IOException{	
		
		AppUpdateUinResponse resp = (AppUpdateUinResponse) executeTafReq(COMMAND_ID_APP_UPDATE_UIN_REQ,UinReq(41947921),new AppUpdateUinResponse());
		
		Assert.assertTrue(resp.getVApps().size() > 0,"appUpdateUin是空的！！");
		
		Assert.assertTrue("" != resp.getSDeviceName(),"设备名是空的！！");
		
	}
	
	@Test
	public void AppUpdateInfo_isOk() throws ClientProtocolException, IOException{
		// 包名
		String[] packageName = {"com.tencent.mobileqq","com.tencent.mtt"};
		// 内部版本号
		int[] versionCode = {131,521879};
		// manifestMD5
		String manifestMd5 = "";
		
		AppInfoForUpdate  appinfo1 = new AppInfoForUpdate();
		AppInfoForUpdate  appinfo2 = new AppInfoForUpdate();
		ArrayList<AppInfoForUpdate> applist = new ArrayList<AppInfoForUpdate>();
		
		appinfo1.setPackageName(packageName[0]);
		appinfo2.setPackageName(packageName[1]);
		
		appinfo1.setVersionCode(versionCode[0]);
		appinfo2.setVersionCode(versionCode[1]);
		
		appinfo1.setManifestMd5(manifestMd5);
		appinfo2.setManifestMd5(manifestMd5);
		
		applist.add(appinfo1);
		applist.add(appinfo2);
		
		AppUpdateInfoResponse resp =(AppUpdateInfoResponse) executeTafReq(COMMAND_ID_APP_UPDATE_INFO_REQ,UpdateReq(applist),new AppUpdateInfoResponse());

		
		Assert.assertTrue(null != resp.getMStatisticsInfo(),"app升级静态信息为空！！");
		Assert.assertEquals(resp.getStRsp().getAppUpdateInfoList().size(), packageName.length,"app升级个数错误！！"+resp);
		
		//System.out.println(resp.getStRsp().getAppUpdateInfoList());
	}
}
