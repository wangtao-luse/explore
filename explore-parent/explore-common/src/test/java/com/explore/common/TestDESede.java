package com.explore.common;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.junit.jupiter.api.Test;

public class TestDESede {
/**
 * DES3加密算法即DESede,
 * 1.SecretKeySpec类是KeySpec接口的实现类，用于构建秘密密钥规范。
 * 2.Cipher类提供了加密和解密的功能,Cipher类完成aes，des，des3和rsa加密;
 * Cipher cipher = Cipher.getInstance(transformation);
 * Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding"); * 
 *  transformation按"算法/模式/填充模式"
 *  加密算法有：AES，DES，DESede(DES3)和RSA 四种;
 *  模式有CBC(有向量模式)和ECB(无向量模式)，向量模式可以简单理解为偏移量，使用CBC模式需要定义一个IvParameterSpec对象;
 *  填充模式:
* NoPadding: 加密内容不足8位用0补足8位, Cipher类不提供补位功能，需自己实现代码给加密内容添加0, 如{65,65,65,0,0,0,0,0}
* PKCS5Padding: 加密内容不足8位用余位数补足8位, 如{65,65,65,5,5,5,5,5}或{97,97,97,97,97,97,2,2}; 刚好8位补8位8

 * 3.Cipher对象需要初始化	
 *    init(int opmode, Key key, AlgorithmParameterSpec params)
 *    opmode:
 *      Cipher.ENCRYPT_MODE(加密模式)和 Cipher.DECRYPT_MODE(解密模式)
 *    key:
 *    密匙，使用传入的盐构造出一个密匙，可以使用SecretKeySpec、KeyGenerator和KeyPairGenerator创建密匙，其中
 *    SecretKeySpec和KeyGenerator支持AES，DES，DESede三种加密算法创建密,
 *    KeyPairGenerator支持RSA加密算法创建密匙。
 *    params：
 *    使用CBC模式时必须传入该参数，该项目使用IvParameterSpec创建iv 对象
 * 4.加密或解密:
 *   byte[] b = cipher.doFinal(content);
 *   返回结果为byte数组，如果直接使用 new String(b) 封装成字符串，则会出现乱码;
 *   一般对byte数组进行处理,有两种处理方式：转换为base64的字符串或转换为16进制的字符串
 * 5.创建密钥
 *   创建密匙主要使用SecretKeySpec、KeyGenerator和KeyPairGenerator三个类来创建密匙
 *   SecretKeySpec类支持创建密匙的加密算法(ASE,DES,DES3)；
 *   需要注意的是不同的加密算法的byte数组的长度是不同的，创建密匙前最好先检测下byte数组的长度
 *   加密算法   密钥长度 向量长度
 *   AES      16     16
 *   DES       8      8
 *   DES3     24      8
 *   KeyGenerator类支持创建密匙的加密算法(ASE,DES,DES3)
 * @throws NoSuchAlgorithmException
 * @throws NoSuchPaddingException
 * @throws BadPaddingException 
 * @throws IllegalBlockSizeException 
 * @throws InvalidKeyException 
 * @throws UnsupportedEncodingException 
 */
	@Test
public void TestSecretKeySpec() throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, UnsupportedEncodingException {
		
	String salt = "012345678901234567890123";	
	//生成密钥
	SecretKey secretKey = new SecretKeySpec(salt.getBytes(), "DESede");
	//根据密钥对数据进行加密
	Cipher cipher = Cipher.getInstance("DESede");
	cipher.init(Cipher.ENCRYPT_MODE,secretKey);
	byte[] doFinal = cipher.doFinal("top@988988".getBytes());
	System.out.println("salt len: "+salt.getBytes().length );
	
}
}
