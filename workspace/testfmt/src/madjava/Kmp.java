package madjava;

public class Kmp {

	public static void main(String[] args) {
		String S = "abcdsdf";
		String T = "a";
		int lenS = S.length();
		int lenT = T.length();
		int next[] = new int[lenT + 1];

		getNext(T, next);// next[]��������
		for (int i = 0; i < next.length; i++) {// ��ӡ��next����
			System.err.println(i + ":" + next[i]);
		}
		int kmp = K_next(S, T, lenS, lenT, next);
		System.err.println("��һ��ƥ���λ��::" + kmp);
	}

	public static void getNext(String T, int next[]) {// ������ص�
		int j = 0, k = -1;
		next[0] = -1;
		while (j < T.length()) {
			if (k == -1 || T.charAt(j) == T.charAt(k)) {
				j++;
				k++;
				next[j] = k;
			} else {
				k = next[k];
			}
		}
	}

	public static int K_next(String S, String T, int lenS, int lenT, int next[]) {
		int i = 0, j = 0;
		while (i < lenS && j < lenT) {
			if (j == -1 || S.charAt(i) == T.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		if (j == lenT) {
			return i - lenT;
		}
		return -1;
	}
}
