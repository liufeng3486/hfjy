package forward.chuwa.hfjy.utility;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;

import com.google.common.collect.Lists;

public class Utility {
	public static String bitStringAnd(String str1, String str2) {
		if (str1 == null || str2 == null) {
			return null;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str1.length(); ++i) {
			if (i < str2.length()) {
				sb.append(str1.charAt(i));
			} else {
				sb.append('0');
			}
		}

		for (int i = 0; i < str2.length(); ++i) {
			if (i < sb.length()) {
				if (str2.charAt(i) == '0') {
					sb.setCharAt(i, '0');
				}
			} else {
				sb.append('0');
			}
		}

		return sb.toString();
	}

	public static String bitStringOr(String str1, String str2) {
		if (str1 == null || str2 == null) {
			return str1 != null ? str1 : str2;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str1.length(); ++i) {
			sb.append(str1.charAt(i));
		}

		for (int i = 0; i < str2.length(); ++i) {
			if (i < sb.length()) {
				if (str2.charAt(i) == '1') {
					sb.setCharAt(i, '1');
				}
			} else {
				sb.append(str1.charAt(i));
			}
		}

		return sb.toString();
	}

	public static Long random() {
		return System.currentTimeMillis() * 10000 + RandomUtils.nextInt(9999);
	}

	public static boolean validId(Long id) {
		return id != null && id > 0;
	}

	
	public static List<Long> split(String str, String separator) {
		List<Long> result = Lists.newArrayList();

		if (!StringUtils.isEmpty(str)) {
			for (String value : StringUtils.split(str, separator)) {
				try {
					result.add(Long.parseLong(value));
				} catch (NumberFormatException e) {
					// TODO: handle exception
				}
			}
		}

		return result;
	}

	public static List<Integer> splitToInt(String str, String separator) {
		List<Integer> result = Lists.newArrayList();

		if (!StringUtils.isEmpty(str)) {
			for (String value : StringUtils.split(str, separator)) {
				try {
					result.add(Integer.parseInt(value));
				} catch (NumberFormatException e) {
					// TODO: handle exception
				}
			}
		}

		return result;
	}
	
	public static List<String> splitToString(String str, String separator) {
		List<String> result = Lists.newArrayList();

		if (!StringUtils.isEmpty(str)) {
			for (String value : StringUtils.split(str, separator)) {
				if(!StringUtils.isEmpty(value)) {
					result.add(value);
				}
			}
		}

		return result;
	}
	
	public static boolean equals(String s1, String... params) {
		for (String s2 : params) {
			if (StringUtils.equals(s1, s2)) {
				return true;
			}
		}

		return false;
	}
}
