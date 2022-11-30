package com.explore.common.encryption;



public class CryptoUtil {
public static final String SIMPLEHASH_MD5 ="MD5";
public static final String SIMPLEHASH_SHA256 ="sha256";
public static final String SIMPLEHASH_SHA384 ="sha384";
public static final String SIMPLEHASH_SHA512 ="sha512";
public static final String HASHITERATIONS_DEFAULT="2048";
private CryptoUtil(){}

	/*
	 * public static String md5Hash(String source,String salt,int iter) { Md5Hash
	 * md5Hash = new Md5Hash(source,salt,iter); return md5Hash.toHex(); }
	 * 
	 * public static String sha256Hash(String source,String salt,int iter) {
	 * Sha256Hash sha256 = new Sha256Hash(source,salt,iter); return sha256.toHex();
	 * }
	 * 
	 * public static String sha384Hash(String source,String salt,int iter) {
	 * Sha384Hash sha256 = new Sha384Hash(source,salt,iter); return sha256.toHex();
	 * }
	 * 
	 * public static String sha512Hash(String source,String salt,int iter) {
	 * Sha512Hash sha512 = new Sha512Hash(source,salt,iter); return sha512.toHex();
	 * }
	 */
/**
 * 
 * @param algorithmName  加密算法
 * @param source         文本
 * @param salt           盐
 * @param hashIterations 加密次数
 * @return
 */
	/*
	 * public static String simpleHash(String algorithmName,String source,String
	 * salt,int hashIterations) { SimpleHash simple = new SimpleHash(algorithmName,
	 * source, salt, hashIterations);
	 * 
	 * return simple.toHex();
	 * 
	 * }
	 */
public static void main(String[] args) {
	//String salt = new SecureRandomNumberGenerator().nextBytes().toString();
	//String sha512Hash = CryptoUtil.sha512Hash("Taotao@988988", salt, 8192);
  // String md5  = new Md5Hash("Taotao@988988",salt,2048).toHex();
	//System.out.println("salt: "+salt+" passwd: "+md5+" len: "+md5.length());
	
}
}
