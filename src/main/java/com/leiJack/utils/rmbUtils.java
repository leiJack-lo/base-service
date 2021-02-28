package com.leiJack.utils;

public class rmbUtils {
	
	private static final char[] capital = new char[] {
			'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'
	};
	
	private static final char[] units = new char[] {
			'元','拾','佰','仟','万','拾','佰','仟','亿'
	};
	
	
	public static String convert(int money) {
		StringBuffer sb = new StringBuffer();
		while(money!=0) {
			int number = money%10;
			sb.insert(0, capital[number]);
			money = money/10;
		}
		
		return sb.toString();
	}
	
	
	/**
	 * @param money
	 * @return  带单位转换只支持到亿
	 */
	public static String convertWithUnit(int money) {
		StringBuffer sb = new StringBuffer();
		int unit = 0;
		while(money!=0) {
			sb.insert(0, units[unit++]);
			int number = money%10;
			sb.insert(0, capital[number]);
			money = money/10;
			
		}
		return sb.toString();
	}
	
	

}
