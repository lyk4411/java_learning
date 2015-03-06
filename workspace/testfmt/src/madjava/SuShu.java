package madjava;

public class SuShu {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 2; i <= 100; i++)
			for (int j = 2; j <= i; j++) {
				if (i % j == 0 && i == j) {
					sum++;
					System.out.println(i);
				} else if (i % j == 0 && i != j)
					break;
			}
		System.out.println("100之内的素数共有：" + sum + "个");
	}
}
