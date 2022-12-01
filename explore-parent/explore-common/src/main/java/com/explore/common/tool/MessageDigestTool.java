package com.explore.common.tool;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@Deprecated
public class MessageDigestTool {
private MessageDigestTool() {}
private static final String SHA_1 = "SHA-1";
private static final String SHA_224 = "SHA-224";
private static final String SHA_256 = "SHA-256";
private static final String SHA_384 = "SHA-384";
private static final String SHA_512 = "SHA-512";
private static final String MD5 = "MD5";
public static String getSHA1(String painText, boolean uppercase) {
    return getSha(painText, SHA_1, uppercase);
}

public static String getSHA224(String painText, boolean uppercase) {
    return getSha(painText, SHA_224, uppercase);
}

public static String getSHA256(String painText, boolean uppercase) {
    return getSha(painText, SHA_256, uppercase);
}

public static String getSHA384(String painText, boolean uppercase) {
    return getSha(painText, SHA_384, uppercase);
}

public static String getSHA512(String painText, boolean uppercase) {
    return getSha(painText, SHA_512, uppercase);
}
public static String getMD5(String painText, boolean uppercase) {
	return getSha(painText, MD5, uppercase);
}

/**
 * 
 * @param algorithm 加密算法
 * @param plainText 加密数据
 * @param uppercase 是否大写
 * @return
 */
private static String getSha(String algorithm,String plainText, boolean uppercase) {
	String hexString = "";
	try {
		byte[] bytes = plainText.getBytes(StandardCharsets.UTF_8);
		MessageDigest digest = MessageDigest.getInstance(algorithm);
		byte[] result = digest.digest(bytes);
		 hexString = toHexString(result);		
	} catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return uppercase?hexString.toUpperCase():hexString;
}
/**
 * 将字节数组转为16进制字符串
 * @param bytes
 * @return
 */
private static String toHexString(byte[] bytes) {
    StringBuilder builder = new StringBuilder();
    for (byte b : bytes) {
        //java.lang.Integer.toHexString() 方法的参数是int(32位)类型，
    	
        String temp = Integer.toHexString(b & 0xFF);
        if (temp.length() == 1) {
            builder.append("0");
        }
        builder.append(temp);
    }
    return builder.toString();
}
private  static String byteArrayToHexString(byte[] bytes) {
	  StringBuilder stringBuilder = new StringBuilder();
	    for (int i = 0; i < bytes.length; i++) {
	        //0x表示十六进制，使用&0xff是在byte转int时，做补码处理，保证二进制数据一致性，计算机存储的是补码
	        //整数转十六进制使用Integer的toHexString方法
	        String tempStr = Integer.toHexString(bytes[i] & 0xff);
	        if (tempStr.length() == 1)
	            //如果长度为1补0
	            stringBuilder.append("0").append(tempStr);
	        else {
	            stringBuilder.append(tempStr);
	        }
	        //分割符如：0c:c1:75:b9:c0:f1:b6:a8:31:c3:99:e2:69:77:26:61
	        if (i < bytes.length - 1)
	            stringBuilder.append(":");
	    }
	    return stringBuilder.toString();
}
private  static String byteArrayToHexStr(byte[] bytes) {
	StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < bytes.length; i++) {
        int chartIndex = bytes[i] & 0xff;
        //整数转十六进制，小于16的为0~F，要补0输出
        if (chartIndex < 16) {
            stringBuilder.append("0");
        }
        stringBuilder.append(Integer.toHexString(chartIndex));
        if (i < bytes.length - 1)
            stringBuilder.append(":");
    }
	return stringBuilder.toString();
}
}
