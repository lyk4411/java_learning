package madjava;

public class Palindrome {

	/**
	 * use recursive
	 * 
	 * @param str
	 * @return
	 */
	static boolean isPalindrome(String str) {
		int length = str.length();
		if (length <= 1)
			return true;
		else if (str.charAt(length - 1) == str.charAt(0))
			return isPalindrome(str.substring(1, length - 1));
		else
			return false;

	}

	/**
	 * use for loop
	 * 
	 * @param str
	 * @return
	 */
	static boolean isPalindrome2(String str) {
		char[] ch = str.toCharArray();
		int length = ch.length;
		boolean flag = true;
		for (int i = 0; i < length / 2; i++) {
			if (ch[i] != ch[length - 1 - i]) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aabbyuuybbaa";
		System.out.println(isPalindrome(str));
		System.out.println(isPalindrome2(str));

	}

}