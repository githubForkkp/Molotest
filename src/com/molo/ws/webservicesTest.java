package com.molo.ws;


import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.molo.taftest.TafBaseTest;
import com.qq.jce.ws.AppDetail;
import com.qq.jce.ws.AppRecommand;
import com.qq.jce.ws.DockMedicalTip;
import com.qq.jce.ws.DockRecommand;
import com.qq.jce.ws.DockRecommands;
import com.qq.jce.ws.DockSearchBox;
import com.qq.jce.ws.DockSearchFacePlateInfor;
import com.qq.jce.ws.DockSearchHotWord;
import com.qq.jce.ws.DockSearchHotWordGroup;
import com.qq.jce.ws.DockShowQuantity;
import com.qq.jce.ws.GetAppRecommandReq;
import com.qq.jce.ws.GetAppRecommandRsp;
import com.qq.jce.ws.GetDockFacePlateMsgReq;
import com.qq.jce.ws.GetDockFacePlateMsgRsq;
import com.qq.jce.ws.GetDockFacePlateRuleReq;
import com.qq.jce.ws.GetDockFacePlateRuleRsq;
import com.qq.jce.ws.GetDockSearchFacePlateMsgReq;
import com.qq.jce.ws.GetDockSearchFacePlateMsgRsq;

/**
 * 
 * dock抱管家大腿
 * 
 * */

public class webservicesTest extends TafBaseTest {
	
	// DockFacePlateMsg
	@Test
	public void DockFacePlateMsg_isOk(){
		String cmd = "getDockFacePlateMsg";
		GetDockFacePlateMsgReq req = new GetDockFacePlateMsgReq();
		req.setDockVersion("second_dock_info_cv");
		req.setPcid("11");
//		req.setYybPcVersion("222");
		GetDockFacePlateMsgRsq rsp = new GetDockFacePlateMsgRsq();
		getWsService(cmd, req, rsp);
		if(rsp.getRet() != 0) {
			System.out.println("Ret : " + rsp.getRet());
			System.out.println("Msg : " + rsp.getMsg());
		} else {
			System.out.println("========== dockRecommands ============");
			DockRecommands dockRecommands = rsp.getDockRecommands();
			System.out.println("Title : " + dockRecommands.getTitle());
			List<DockRecommand> dockRecommandList = dockRecommands.getDockRecommandList();
			for (DockRecommand dockRecommand : dockRecommandList) {
				System.out.println("Desc : " + dockRecommand.getDesc() + " , JumpUrl : " + dockRecommand.getJumpUrl() + " , Recommand : " + dockRecommand.getPicUrl());
			}
			
		}
	}
	
	// DockFacePlateRule
	@Test
	public void DockFacePlateRule_isOk(){
		String cmd = "getDockFacePlateRule";
		GetDockFacePlateRuleReq req = new GetDockFacePlateRuleReq();
		req.setDockVersion("1");
		req.setPcid("11");
//		req.setYybPcVersion("222");
		GetDockFacePlateRuleRsq rsp = new GetDockFacePlateRuleRsq();
		getWsService(cmd, req, rsp);
		if(rsp.getRet() != 0) {
			System.out.println("Ret : " + rsp.getRet());
			System.out.println("Msg : " + rsp.getMsg());	
		} else {
			System.out.println("========== 1:可升级    3:装机必备    7:体检   8:猜你喜欢 ============");
			List<DockShowQuantity> dockShowQuantities = rsp.getDockShowQuantityList();
			for (DockShowQuantity dockShowQuantity : dockShowQuantities) {
				System.out.println("Business : " + dockShowQuantity.getBusiness() + " , Quantity : " + dockShowQuantity.getQuantity());
			}
			System.out.println();
			System.out.println("========== 优先级 ============");
			List<String> priorityList = rsp.getPriority();
			for (String priority : priorityList) {
				System.out.println("priority : " + priority);
			}
			System.out.println();
			System.out.println("========== 间隔时间，即每次连接的间隔时间 ============");
			String intervalTime = rsp.getIntervalTime();
			System.out.println("intervalTime : " + intervalTime);
			System.out.println();
			System.out.println("========== 次数，即每天最多弹几次 ============");
			String showTimes = rsp.getShowTimes();
			System.out.println("showTimes : " + showTimes);
			System.out.println("========== 面板显示时间限制  ============");
			System.out.println("面板显示时间限制:"+rsp.getReserved1());
			System.out.println("========== tip弹出次数  ============");
			System.out.println("tip弹出次数:"+rsp.getReserved2());
			System.out.println("========== 用户选择'仅在有可优化项是提醒'时面板弹出次数  ============");
			System.out.println("仅在有可优化项是提醒 弹出次数:"+rsp.getReserved3());
			System.out.println();
			System.out.println("========== 可升级应用个数 >= upgradeQuantity 时，可升级面板生效 ============");
			String upgradeQuantity = rsp.getUpgradeQuantity();
			System.out.println("upgradeQuantity : " + upgradeQuantity);
			
			System.out.println();
			System.out.println("========== 手机内应用个数 < mobileAppTotal 时，装机必备面板生效 ============");
			String mobileAppTotal = rsp.getMobileAppTotal();
			System.out.println("mobileAppTotal : " + mobileAppTotal);
			
			System.out.println();
			System.out.println("========== 手机内存百分比 > mobileRAM 时，体检面板生效 ============");
			String mobileRAM = rsp.getMobileRAM();
			System.out.println("mobileRAM : " + mobileRAM);
			
			System.out.println();
			System.out.println("========== 场景  1：场景1   2：场景2    3：场景3 ============");
			DockMedicalTip dockMedicalTip = rsp.getDockMedicalTip();
			
			System.out.println("0:点击tip跳转到PC功能页        1:点击tip跳转到web资源页 : " + dockMedicalTip.getType());
			System.out.println("文案描述 : " + dockMedicalTip.getDescription());
			System.out.println("跳转地址 : " + dockMedicalTip.getJumpAddress());
			
			System.out.println();
			System.out.println("========== 礼包属性 ============");
			
			System.out.println(rsp.giftBag);
		}
	}
	
	// 猜你喜欢
	@Test
	public  void  AppRecommand_isOk(){
		String cmd = "getAppRecommand";
		GetAppRecommandReq req = new GetAppRecommandReq();
		
		// 联想 990000723659076
		
		req.setImei("863777026842491");
		req.setUin("41947921");
		
		GetAppRecommandRsp rsp = new GetAppRecommandRsp();
		
		getWsService(cmd, req, rsp);
		
		System.out.println("AppRecommand个数："+rsp.getAppRecommandList().size());
		
		// 产品策略：总数 = 配置个数 * 6
		Assert.assertEquals(rsp.getAppRecommandList().size(), getRecommandNum() * 6);
		
		for(AppRecommand rec : rsp.getAppRecommandList()){
			System.out.println("推荐理由："+rec.getRecommandinfo());
			AppDetail app = rec.getAppDetail();
			System.out.println("应用名："+ app.getAppName());
			System.out.println("下载链接："+ app.getApkUrl());
		}
		
	}
	
	// dock搜索需求
	@Test
	public void getDockSearchFacePlateMsg_isOk(){
		String cmd = "getDockSearchFacePlateMsg";
		GetDockSearchFacePlateMsgReq req = new GetDockSearchFacePlateMsgReq();
		req.setDockVersion("1");
		// D4BED9DBF3820000_5056928A   0
		// D067E50A4C53_20ED7FDB	   1
		req.setPcid("D4BED9DBF3820000_5056928A");
		//req.setYybPcVersion("222");
		GetDockSearchFacePlateMsgRsq rsp = new GetDockSearchFacePlateMsgRsq();
		
		getWsService(cmd, req, rsp);
		
		if(rsp.getRet() != 0) {
				System.out.println("Ret : " + rsp.getRet());
				System.out.println("Msg : " + rsp.getMsg());
			} else {
				System.out.println("========== dockSearchFacePlateMsg ============");
				DockSearchFacePlateInfor dockSearchFacePlateInfor = rsp.getDockSearchFacePlateInfor();
				DockSearchBox dockSearchBox = dockSearchFacePlateInfor.getDockSearchBox();
				System.out.println("Copywriting show : " + dockSearchBox.getShow());
				System.out.println("Copywriting : " + dockSearchBox.getCopywriting());
				System.out.println("SearchUrl : " + dockSearchBox.getSearchUrl());
				
				List<DockSearchHotWordGroup> dockSearchHotWordGroups = dockSearchFacePlateInfor.getDockSearchHotWordGroups();
				for (DockSearchHotWordGroup dockSearchHotWordGroup : dockSearchHotWordGroups) {
					System.out.println(dockSearchHotWordGroup.groupName);
					List<DockSearchHotWord> dockSearchHotWords = dockSearchHotWordGroup.getDockSearchHotWords();
					for (DockSearchHotWord dockSearchHotWord : dockSearchHotWords) {
						System.out.println(dockSearchHotWord.getSearchHotWord() + " , " + dockSearchHotWord.getColour() + " , " + dockSearchHotWord.getJumpUrl());
					}
				}
			}
		
	}
	
	// 获取已配置猜你喜欢个数
	private int getRecommandNum(){
		String cmd = "getDockFacePlateRule";
		int num = 0;
		GetDockFacePlateRuleReq req = new GetDockFacePlateRuleReq();
		req.setDockVersion("1");
		req.setPcid("11");
//		req.setYybPcVersion("222");
		GetDockFacePlateRuleRsq rsp = new GetDockFacePlateRuleRsq();
		getWsService(cmd, req, rsp);
		if(rsp.getRet() != 0) {
			System.out.println("Ret : " + rsp.getRet());
			System.out.println("Msg : " + rsp.getMsg());	
		} else {
			List<DockShowQuantity> dockShowQuantities = rsp.getDockShowQuantityList();
			for (DockShowQuantity dockShowQuantity : dockShowQuantities) {
				if(dockShowQuantity.getBusiness().equals("8")){
					num =  Integer.parseInt(dockShowQuantity.getQuantity());
				}

			}
		}
		return num;
	}
}
