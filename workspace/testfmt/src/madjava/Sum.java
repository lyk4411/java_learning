package madjava;

public class Sum {
	public static void main(String[] args) {
		int sum = 0, tmp = 1;
		for (int i = 1; i <= 20; i++) {
			for (int j = 1; j <= i; j++) {
				tmp *= j;
			}
			sum += tmp;
		}
		System.out.println("前20项和为：" + sum);
	}
}