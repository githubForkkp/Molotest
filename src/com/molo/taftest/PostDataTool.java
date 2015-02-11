package com.molo.taftest;


import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class PostDataTool {
	
	public String currentEdition    ="-1";
	public String upgradeEdition;
	public String upgradeWay;
	public String autoOrManual;
	public String city       		= "default_cu_city";
	public String province 			= "default_cu_prov" ;
	public String operators			= "default_cu_isp";
	public String clientType;
	public String downloadUrl;
	public String md5;
	public String packageType;
	public String installParam		= "/S /NODESKLINK /NOQUICKLINK /NOAPKASS /FROMUPDATE";
	public String editionAlias;
	public String upgradeAlertUrl;
	public String registry			= "HKLM\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{365ADADE-814B-400C-877C-95E9F684BBEB}|MainExecutable";
	public String qq;
	public String ip;
	
	
	
	/**
	 * 
	 * 转换postdata
	 * 
	 * */
	public List<NameValuePair> getAllPostdata(){
		
		List<NameValuePair> postParameters = new ArrayList<NameValuePair>(); 
		
		postParameters.add(new BasicNameValuePair("currentEdition",getCurrentEdition()));
		postParameters.add(new BasicNameValuePair("upgradeEdition",getUpgradeEdition()));
		postParameters.add(new BasicNameValuePair("upgradeWay",getUpgradeWay()));
		postParameters.add(new BasicNameValuePair("autoOrManual",getAutoOrManual()));
		postParameters.add(new BasicNameValuePair("city",getCity()));
		postParameters.add(new BasicNameValuePair("province",getProvince()));
		postParameters.add(new BasicNameValuePair("operators",getOperators()));
		postParameters.add(new BasicNameValuePair("clientType",getClientType()));
		postParameters.add(new BasicNameValuePair("downloadUrl",getDownloadUrl()));
		postParameters.add(new BasicNameValuePair("md5",getMd5()));
		postParameters.add(new BasicNameValuePair("packageType",getPackageType()));
		postParameters.add(new BasicNameValuePair("installParam",getInstallParam()));
		postParameters.add(new BasicNameValuePair("editionAlias",getEditionAlias()));
		postParameters.add(new BasicNameValuePair("upgradeAlertUrl",getUpgradeAlertUrl()));
		postParameters.add(new BasicNameValuePair("registry",getRegistry()));
		postParameters.add(new BasicNameValuePair("qq",getQq()));
		postParameters.add(new BasicNameValuePair("ip",getIp()));
		
		return postParameters;
	} 
	
	
	public String getCurrentEdition() {
		return currentEdition;
	}
	public void setCurrentEdition(String currentEdition) {
		this.currentEdition = currentEdition;
	}
	public String getUpgradeEdition() {
		return upgradeEdition;
	}
	public void setUpgradeEdition(String upgradeEdition) {
		this.upgradeEdition = upgradeEdition;
	}
	public String getUpgradeWay() {
		return upgradeWay;
	}
	public void setUpgradeWay(String upgradeWay) {
		this.upgradeWay = upgradeWay;
	}
	public String getAutoOrManual() {
		return autoOrManual;
	}
	public void setAutoOrManual(String autoOrManual) {
		this.autoOrManual = autoOrManual;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getOperators() {
		return operators;
	}
	public void setOperators(String operators) {
		this.operators = operators;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public String getDownloadUrl() {
		return downloadUrl;
	}
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public String getPackageType() {
		return packageType;
	}
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	public String getInstallParam() {
		return installParam;
	}
	public void setInstallParam(String installParam) {
		this.installParam = installParam;
	}
	public String getEditionAlias() {
		return editionAlias;
	}
	public void setEditionAlias(String editionAlias) {
		this.editionAlias = editionAlias;
	}
	public String getUpgradeAlertUrl() {
		return upgradeAlertUrl;
	}
	public void setUpgradeAlertUrl(String upgradeAlertUrl) {
		this.upgradeAlertUrl = upgradeAlertUrl;
	}
	public String getRegistry() {
		return registry;
	}
	public void setRegistry(String registry) {
		this.registry = registry;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}
