package com.api;

public class testisUnique {
	public static void main(String[] args) {
		System.out.println(isUniqueChars2("STRINGS"));
		System.out.println(isUniqueChars("STRINGS"));
		System.out.println(reverse("ABCDEFGHIJK"));
		char[] test_char = { 'a', 'b', 'c', 'a', 'b', 'c', 'a', 'b', 'c', 'z' };
		System.out.println(test_char);
		removeDuplicates(test_char);
		System.out.println(test_char);
		char[] test_char2 = { 'a', 'b', 'c', 'a', 'b', 'c', 'a', 'b', 'c', 'z' };
		System.out.println(test_char2);
		removeDuplicatesEff(test_char2);
		System.out.println(test_char2);

	}

	public static boolean isUniqueChars2(String str) {
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val])
				return false;
			char_set[val] = true;
		}
		return true;
	}

	public static boolean isUniqueChars(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); ++i) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0)
				return false;
			checker |= (1 << val);
		}
		return true;
	}

	static String reverse(String str) {
		char[] s_str = str.toCharArray();
		char tmp;
		int length = s_str.length;
		char[] result_char = new char[length];
		// System.out.println(length);
		for (int i = 0; i < length; i++) {
			result_char[i] = s_str[length - i - 1];
		}
		System.out.println(result_char);

		return String.valueOf(result_char);
	}

	public static void removeDuplicates(char[] str) {
		if (str == null)
			return;
		int len = str.length;
		if (len < 2)
			return;

		int tail = 1;

		for (int i = 1; i < len; ++i) {
			int j;
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j])
					break;
			}
			if (j == tail) {
				// str[tail] = str[i];
				++tail;
			} else {
				str[tail] = 0;
				++tail;
			}
		}
	}

	public static void removeDuplicatesEff(char[] str) {
		if (str == null)
			return;
		int len = str.length;
		if (len < 2)
			return;
		boolean[] hit = new boolean[256];
		for (int i = 0; i < 256; ++i) {
			hit[i] = false;
		}
		hit[str[0]] = true;
		int tail = 1;
		for (int i = 1; i < len; ++i) {
			if (!hit[str[i]]) {
				str[tail] = str[i];
				++tail;
				hit[str[i]] = true;
			}
		}
		str[tail] = 0;
	}
}
