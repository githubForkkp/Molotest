package com.molo.Utils;

import org.apache.commons.codec.binary.Base64;


import com.molo.Utils.StringUtil;
import com.molo.Utils.EncryptionAdapter;

/**
 * BASE64
 * @author chding
 *
 */
public class BASE64Coder extends EncryptionAdapter {
	
	@Override
	public String myEncrypt(byte[] data) throws Exception {
		return new String(Base64.encodeBase64(data));
	}
	
	@Override
	public byte[] myDecrypt(String date) throws Exception {
		return Base64.decodeBase64(StringUtil.getUTF8Bytes(date.toString()));
	}
	
}
