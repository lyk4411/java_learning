package madjava;

public class timu13 {
	public static void main(String[] args) {
		int a = 1;
		for (int i = 0; i < 100000; i++) {
			a++;
			for (int j = 1; j < a + 100; j++) {
				if (Math.sqrt(a + 100) == j) {
					for (int k = 1; k < a + 268; k++) {
						if (Math.sqrt(a + 268) == k) {
							System.out.println("这个数是：" + a);
							break;
						}
					}
				}
			}
		}
	}
}