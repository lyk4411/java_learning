package madjava;

public class Algorithm21_0 {
	static void getAllComp(int n, int m) {
		String pre = m + "=";
		int theMax = (1 + n) * n / 2;
		if (theMax < m) {
			System.out.println("不存在该数！");
		} else {
			for (int i = 1; i < n && i <= m / 2; i++) {
				// 从1开始计数，打印出两个数的组合，并且两数不相等
				if (i != m - i && ((m - i) <= n)) {
					System.out.println("here:" + pre + i + "+" + (m - i));
					// continue;
				}
				// 调用递归，继续求得大于2个数的组合
				getTheResult(m - i, pre + i, i, n);
			}
		}
	}

	// 调用递归，继续求得大于2个数的组合,j为组合中已用过的数，所以取大于该数的。
	static void getTheResult(int m, String pre, int j, int n) {
		for (int i = j + 1; i < n && i <= m / 2; i++) {
			if (i != m - i && ((m - i) <= n))
				System.out.println("there:" + pre + "+" + i + "+" + (m - i));
			getTheResult(m - i, pre + "+" + i, i, n);
		}
	}

	public static void main(String[] args) {
		getAllComp(11, 12);
	}
}