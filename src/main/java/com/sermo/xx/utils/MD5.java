package com.sermo.xx.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName: MD5
 * @Description: TODO
 * @author renqingqing
 * @date 2016年5月10日 下午4:34:37
 * 
 */
public class MD5 {

	// 加密
	public static String encrypt(String inputText, String algorithmName) {

		if (inputText == null || "".equals(inputText.trim())) {

			throw new IllegalArgumentException("请输入要加密的内容");

		}

		if (algorithmName == null || "".equals(algorithmName.trim())) {

			algorithmName = "md5";

		}
		String encryptText = null;

		try {

			MessageDigest m = MessageDigest.getInstance(algorithmName);

			m.update(inputText.getBytes("UTF8"));

			byte s[] = m.digest();

			return hex(s);

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();

		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();

		}

		return encryptText;

	}

	// 返回十六进制字符串
	private static String hex(byte[] arr) {

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < arr.length; ++i) {

			sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1,
					3));

		}

		return sb.toString();

	}

}
