package com.leiJack.utils;

import java.math.BigDecimal;

public class bigDecimalMathUtils {
	
	
	
	/**   金额计算安全加法
	 * @param a1
	 * @param an
	 * @return
	 */
	public static BigDecimal safeAdd (BigDecimal a1,BigDecimal... an) {
		if(null == a1) {
			a1=BigDecimal.ZERO;
		}
		if (null != a1) {
			for(BigDecimal a : an) {
				a1 = a1.add(null == a ? BigDecimal.ZERO : a);
			}
		}
		return a1;
		
	}
	
	
	
	/**
	 * 金额计算安全减法
	 * @param b1
	 * @param bn
	 * @return
	 */
	public static BigDecimal safeSubtract(BigDecimal b1,BigDecimal... bn) {
		return safeSubtract(false,b1,bn);
	}
	
	
	/**
	 * @param isZero  true时结果负数为0，false时可以返回负数
	 * @param b1
	 * @param bn
	 * @return
	 */
	public static BigDecimal safeSubtract(boolean isZero , BigDecimal b1 , BigDecimal...bn) {
		if(null == b1) {
			b1 = BigDecimal.ZERO;
		}
		BigDecimal r = b1;
		if(null != b1) {
			for(BigDecimal b : bn) {
				r = r.subtract((null == b ? BigDecimal.ZERO : b)); 
			}
		}
		return isZero ? (r.compareTo(BigDecimal.ZERO) == -1 ? BigDecimal.ZERO : r) : r;
	}
	
	
	/**
	 * 四舍五入，向上近似
	 * @param <T>
	 * @param c1 除数
	 * @param c2 被除数
	 * @param bit  保留小数点位数
	 * @return
	 */
	public static <T extends Number>  BigDecimal safeDivide(T c1,T c2,int bit) {
		if (null == c1 || null == c2) {
			return BigDecimal.ZERO;
		}
		try {
			return BigDecimal.valueOf(c1.doubleValue()).divide(BigDecimal.valueOf(c2.doubleValue()),bit,BigDecimal.ROUND_HALF_UP);
		} catch (Exception e) {
			return BigDecimal.ZERO;
		}
	}
	
	
	
	/**
	 *     四舍五入，向上近似
	 * @param <T>
	 * @param d1
	 * @param d2
	 * @param bit  保留小数点位数
	 * @return
	 */
	public static <T extends Number> BigDecimal safeMultiply(T d1,T d2,int bit) {
		if (null == d1 || null == d2) {
			return BigDecimal.ZERO;
		}
		return BigDecimal.valueOf(d1.doubleValue()).multiply(BigDecimal.valueOf(d2.doubleValue())).setScale(bit, BigDecimal
				.ROUND_HALF_UP);
	}

}
