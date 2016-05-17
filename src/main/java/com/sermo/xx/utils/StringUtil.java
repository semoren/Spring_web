package com.sermo.xx.utils;


/**
 * String工具类
 * 
 * @author A.shu
 *
 */
public class StringUtil {

	/**
	 * @param msg : '参数1[#0], 参数2[#1]'
	 * @param args : test1, test2
	 * @return '参数1[test1], 参数2[test2]'
	 */
	public static String format(String msg, Object... args) {
		if (msg != null && msg.length() > 0 && msg.indexOf('#') > -1) {
			StringBuilder sb = new StringBuilder();
			boolean isArg = false;
			for (int x = 0; x < msg.length(); x++) {
				char c = msg.charAt(x);
				if (isArg) {
					isArg = false;
					if (Character.isDigit(c)) {
						int val = Character.getNumericValue(c);
						if (val >= 0 && val < args.length) {
							sb.append(args[val]);
							continue;
						}
					}
					sb.append('#');
				}
				if (c == '#') {
					isArg = true;
					continue;
				}
				sb.append(c);
			}
			if (isArg) sb.append('#');
			return sb.toString();
		}
		return msg;
	}

	public static String nullToEmpty(Object...os) {
		StringBuilder sb = new StringBuilder();
		for (Object o : os) if(o != null) sb.append(o.toString());
		return sb.toString();
	}

	public static String firstToCase(String s, boolean c) {
		if (BT.STRING.isEmpty(s))
			return s;
		else
			return new StringBuffer(s.length()).append(c ? Character.toUpperCase(s.charAt(0)) : Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
	}
}