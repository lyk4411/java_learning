package madjava;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HuiWen {

	/**
	 * 递归方法判断一个string是否是回文 返回true表示当前字符串是一个回文字符串 返回false表示该字符串不是回文字符串
	 * 
	 * @param args
	 */

	public static void main(String[] args) throws Exception {
		String str = "";
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in), 256);
		System.out.println("请输入待检验的字符串:");
		str = br.readLine();
		if (str.length() == 0) {
			System.out.println("检查结果： " + "false");
		} else {
			System.out.println("检查结果： " + huiwen(str, 0, str.length() - 1));
		}
	}

	public static boolean huiwen(String s, int start, int end) {
		if (start == end)
			return true;
		if (start > end) {
			// System.out.println("您没有输入任何字符串！");
			return true;
		}
		if (s.charAt(start) == s.charAt(end)) {
			return huiwen(s, start + 1, end - 1);
		} else {
			return false;
		}
	}

}