package com.explore.common.encryption;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.Sha384Hash;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.explore.common.tool.StringTool;

public class CryptoUtil {
public static final String SIMPLEHASH_MD5 ="MD5";
public static final String SIMPLEHASH_SHA256 ="sha-256";
public static final String SIMPLEHASH_SHA384 ="sha-384";
public static final String SIMPLEHASH_SHA512 ="sha-512";
public static final int HASHITERATIONS_DEFAULT=2048;
private CryptoUtil(){}
public static String md5Hash(Object source, Object salt, int iter) {
	Md5Hash md5Hash = new Md5Hash(source, salt, iter);
	return md5Hash.toHex();
}

public static String sha256Hash(Object source, Object salt, int iter) {
	Sha256Hash sha256 = new Sha256Hash(source, salt, iter);
	return sha256.toHex();
}

public static String sha384Hash(Object source, Object salt, int iter) {
	Sha384Hash sha256 = new Sha384Hash(source, salt, iter);
	return sha256.toHex();
}

public static String sha512Hash(Object source, Object salt, int iter) {
	Sha512Hash sha512 = new Sha512Hash(source, salt, iter);
	return sha512.toHex();
}
	 
/**
 * 
 * @param algorithmName  加密算法
 * @param source         文本
 * @param salt           盐
 * @param hashIterations 加密次数
 * @return
 */	
public static String simpleHash(String algorithmName, Object source, Object salt, int hashIterations) {
	SimpleHash simple = new SimpleHash(algorithmName, source, salt, hashIterations);

	return simple.toHex();

}
private static void sysUser() {
	String salt = "b326c2b2ac80413b88903f5c8438337e";
	ByteSource bytes = ByteSource.Util.bytes(salt);	
	String simpleHash = CryptoUtil.simpleHash(CryptoUtil.SIMPLEHASH_SHA512, "top@988988", bytes, CryptoUtil.HASHITERATIONS_DEFAULT);
	System.out.println("simpleHash: "+simpleHash);
}
public static void main(String[] args) {
	//test();
	sysUser();
	
}
private static void test() {
	String salt = new SecureRandomNumberGenerator().nextBytes().toString();
	 salt = StringTool.getUuid();	
	 //MD5
	String md5  = new Md5Hash("top@988988",salt,CryptoUtil.HASHITERATIONS_DEFAULT).toHex();
	System.out.println("salt: "+salt+" Md5Hash passwd: "+md5+" len: "+md5.length());
	//SHA-512
	String sha512Hash = CryptoUtil.sha512Hash("top@988988", salt, CryptoUtil.HASHITERATIONS_DEFAULT);
	System.out.println("salt: "+salt+" sha512Hash passwd: "+sha512Hash+" len: "+sha512Hash.length());
	String simpleHash = CryptoUtil.simpleHash(CryptoUtil.SIMPLEHASH_SHA512, "top@988988", salt, CryptoUtil.HASHITERATIONS_DEFAULT);
	System.out.println("salt: "+salt+" simpleHash passwd: "+simpleHash+" len: "+simpleHash.length());
}
}
