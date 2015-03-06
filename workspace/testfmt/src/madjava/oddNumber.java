package madjava;

public class oddNumber {
	public static void main(String[] args) {
		int sum = 0;
		int age[] = new int[8];
		for (int i = 0; i < 8; i++) {// 初始化数组
			age[i] = i;
		}
		for (int i = 1; i < 8; i++) {
			if (age[i] % 2 != 0)
				sum++;
			for (int j = 0; j < 8; j++) {
				int a = 0;
				a = age[i] * 10 + age[j];
				if (a % 2 != 0)
					sum++;
				for (int k = 0; k < 8; k++) {
					int b;
					b = age[i] * 100 + age[j] * 10 + age[k];
					if (b % 2 != 0)
						sum++;
					for (int l = 0; l < 8; l++) {
						int c;
						c = age[i] * 1000 + age[j] * 100 + age[k] * 10 + age[l];
						if (c % 2 != 0)
							sum++;
						for (int m = 0; m < 8; m++) {
							int d;
							d = age[i] * 10000 + age[j] * 1000 + age[k] * 100
									+ age[l] * 10 + age[m];
							if (d % 2 != 0)
								sum++;
							for (int n = 0; n < 8; n++) {
								int e;
								e = age[i] * 100000 + age[j] * 10000 + age[k]
										* 1000 + age[l] * 100 + age[m] * 10
										+ age[n];
								if (e % 2 != 0)
									sum++;
								for (int o = 0; o < 8; o++) {
									int f;
									f = age[i] * 1000000 + age[j] * 100000
											+ age[k] * 10000 + age[l] * 1000
											+ age[m] * 100 + age[n] * 10
											+ age[o];
									if (f % 2 != 0)
										sum++;
								}
							}
						}
					}
				}
			}
		}
		System.out.println("0—7所能组成的奇数个数为：" + sum);
	}
}