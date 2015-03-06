package madjava;

public class Timu11 {
	public static void main(String[] args) {
		int aa[] = { 1, 2, 3, 4 };
		int sum, number = 0;
		int a = 0, b = 0;
		for (int i = 0; i < 4; i++) {
			sum = 0;
			sum = aa[i] * 100;
			b = sum;
			for (int j = 0; j < 4; j++) {
				sum += aa[j] * 10;
				a = sum;
				for (int k = 0; k < 4; k++) {
					sum += aa[k];
					if (aa[i] != aa[j] && aa[i] != aa[k] && aa[j] != aa[k]) {
						number++;
						System.out.println(sum);
					}
					sum = a;
				}
				sum = b;
			}
		}
		System.out.println("共有" + number + "个数");
	}
}
