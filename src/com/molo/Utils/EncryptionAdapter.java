package com.molo.Utils;

import java.util.Map;

/**
 * 
 * @author chengxian.dc
 * the Adapter of IEncryption
 */
public class EncryptionAdapter implements IEncryption {

	@Override
	public byte[] decryptByMyPrivateKey(byte[] data, byte[] key) throws Exception {
		return null;
	}

	@Override
	public byte[] decryptByMyPublicKey(byte[] data, byte[] key)
			throws Exception {
		return null;
	}

	@Override
	public byte[] encryptByMyPrivateKey(byte[] data, byte[] key)
			throws Exception {
		return null;
	}

	@Override
	public byte[] encryptByMyPublicKey(byte[] data, byte[] key)
			throws Exception {
		return null;
	}

	@Override
	public byte[] getMyPrivateKey(Map<String, Object> keyMap) throws Exception {
		return null;
	}

	@Override
	public byte[] getMyPublicKey(Map<String, Object> keyMap) throws Exception {
		return null;
	}

	@Override
	public Map<String, Object> initKeyForAsymmetric() throws Exception {
		return null;
	}

	@Override
	public byte[] initKeyForSymmetric() throws Exception {
		return null;
	}

	@Override
	public byte[] myDecrypt() throws Exception {
		return null;
	}

	@Override
	public byte[] myDecrypt(String date) throws Exception {
		return null;
	}

	@Override
	public byte[] myDecrypt(byte[] data, byte[] key) throws Exception {
		return null;
	}

	@Override
	public byte[] myDecrypt(byte[] data, String password, byte[] salt)
			throws Exception {
		return null;
	}

	@Override
	public byte[] myEncrypt() throws Exception {
		return null;
	}

	@Override
	public String myEncrypt(byte[] data) throws Exception {
		return null;
	}

	@Override
	public byte[] myEncrypt(byte[] data, byte[] key) throws Exception {
		return null;
	}

	@Override
	public byte[] myEncrypt(byte[] data, String password, byte[] salt)
			throws Exception {
		return null;
	}

	@Override
	public byte[] mySign(byte[] data, byte[] privateKey) throws Exception {
		return null;
	}

	@Override
	public boolean myVerify(byte[] data, byte[] publicKey, byte[] sign)
			throws Exception {
		return false;
	}

	@Override
	public String MD5(String context) throws Exception {
		return null;
	}

	
}
