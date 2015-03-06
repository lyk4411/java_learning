package madjava;

public class timu9 {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 1000; i++) {
			int a = 0;
			for (int j = 1; j < i; j++) {
				if (i % j == 0) {
					a += j;
					//j--;
				}
			}
			if (a == i) {
				System.out.println(a);
				sum++;
			}
		}
		System.out.println("共有完数：" + sum);
	}
}