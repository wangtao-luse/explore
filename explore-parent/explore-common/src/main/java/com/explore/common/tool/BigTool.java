package com.explore.common.tool;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigTool {
private BigTool() {}
/**
 * 整数加法
 * @param a 加数
 * @param b 加数
 * @return  和
 */
public static BigInteger add(BigInteger a,BigInteger b) {
	return a.add(b);
}
/**
 * 整数减法
 * @param a 被减数
 * @param b 减数
 * @return  差
 */
public static BigInteger subtract(BigInteger a,BigInteger b) {
	return a.subtract(b);
}
/**
 * 整数乘法
 * @param a 因数
 * @param b 因数
 * @return  积
 */
public static BigInteger multiply (BigInteger a,BigInteger b) {
	return a.multiply (b);
}
/**
 * 整数除法
 * @param a 被除数
 * @param b 除数
 * @return  商和余数(数组里面只有两个元素,第一个元素是商,第二个元素是余数)
 */
public static BigInteger[] divideAndRemainder (BigInteger a,BigInteger b) {
	return a.divideAndRemainder (b);
}
/**
 * 浮点数加法
 * @param a 加数
 * @param b 加数
 * @return  和
 */
public static BigDecimal add(Double a, Double b) {
	if (null == a) {
		  a = 0d;
	}
	if (null == b) {
		  b = 0d;
	}
	BigDecimal a1 = BigDecimal.valueOf(a);
	BigDecimal b1 = BigDecimal.valueOf(b);
	return a1.add(b1);
}
/**
 * 浮点数减法
 * @param a 被减数
 * @param b 减数
 * @return  差
 */
public static BigDecimal subtract(Double a, Double b) {
	if (null == a) {
		  a = 0d;
	}
	if (null == b) {
		  b = 0d;
	}
	BigDecimal a1 = BigDecimal.valueOf(a);
	BigDecimal b1 = BigDecimal.valueOf(b);
	return a1.subtract(b1);
}
/**
 * 浮点数乘法
 * @param a 因数
 * @param b 因数
 * @return  积
 */
public static BigDecimal multiply (Double a,Double b) {
	if (null == a) {
		  a = 0d;
	}
	if (null == b) {
		  b = 0d;
	}
	BigDecimal a1 = BigDecimal.valueOf(a);
	BigDecimal b1 = BigDecimal.valueOf(b);
	return a1.multiply(b1);
}
/**
 * 浮点数除法
 * @param a 被除数
 * @param b 除数
 * @param scale 小数点后保留位数
 * @return  商(四舍五入)
 */
public static BigDecimal divide (Double a,Double b,int scale) {
	if (null == a) {
		  a = 0d;
	}
	if (null == b) {
		  b = 1d;
	}	
	BigDecimal a1 = BigDecimal.valueOf(a);
	BigDecimal b1 = BigDecimal.valueOf(b);
	return a1.divide(b1, scale, BigDecimal.ROUND_HALF_UP);
}
/**
 * 浮点数除法
 * @param a 被除数
 * @param b 除数
 * @param scale 小数点后保留位数
 * @param roundingMode 舍入模式
 * @return  商
 */
public static BigDecimal divide (Double a,Double b,int scale,int roundingMode) {
	if (null == a) {
		  a = 0d;
	}
	if (null == b) {
		  b = 1d;
	}
	BigDecimal a1 = BigDecimal.valueOf(a);
	BigDecimal b1 = BigDecimal.valueOf(b);
	return a1.divide(b1, scale, roundingMode);
}
/**
 * 利用BigDecimall中的除法运算实现准确的四舍五入
 * @param num  数字
 * @param scale  小数点后保留位数
 * @return 返回四舍五入后的结果
 */
public double round(double num,int scale) {
	BigDecimal a1 = BigDecimal.valueOf(num);
	BigDecimal b1 = BigDecimal.valueOf(1);
	double round = a1.divide(b1, scale,  BigDecimal.ROUND_HALF_UP).doubleValue();
	return round;
}
}
