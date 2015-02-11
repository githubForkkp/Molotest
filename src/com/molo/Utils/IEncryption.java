package com.molo.Utils;

import java.util.Map;

/**
 * 
 * @author chding
 * 提供常用加密接口
 */
public interface IEncryption {
	
	public byte[] initKeyForSymmetric()throws Exception;
	
	public Map<String, Object> initKeyForAsymmetric()throws Exception;

	public byte[] myEncrypt()throws Exception;
	
	//Base64
	public String myEncrypt(byte[] data)throws Exception;
	
	public byte[] myEncrypt(byte[] data, byte[] key)throws Exception;
	
	//PBE
	public byte[] myEncrypt(byte[] data,String password, byte[] salt)throws Exception;
	
	public byte[] myDecrypt()throws Exception;
	
	//Base64
	public byte[] myDecrypt(String date)throws Exception;
	
	public byte[] myDecrypt(byte[] data, byte[] key)throws Exception;
	
	public byte[] myDecrypt(byte[] data,String password, byte[] salt)throws Exception;
	
	public byte[] getMyPrivateKey(Map<String, Object> keyMap)throws Exception;
	
	public byte[] encryptByMyPrivateKey(byte[] data, byte[] key)throws Exception;
	
	public byte[] decryptByMyPublicKey(byte[] data, byte[] key)throws Exception;
	
	public byte[] encryptByMyPublicKey(byte[] data, byte[] key)throws Exception;
	
	public byte[] decryptByMyPrivateKey(byte[] data, byte[] key)throws Exception;
	
	public byte[] getMyPublicKey(Map<String, Object> keyMap)throws Exception;
	
	public byte[] mySign(byte[] data,byte[] privateKey)throws Exception;
	
	public boolean myVerify(byte[] data,byte[] publicKey, byte[] sign)throws Exception;
	
	/**
	 * 
	 * @param context
	 * @return
	 * @throws Exception
	 */
	public String MD5(String context)throws Exception;

}
