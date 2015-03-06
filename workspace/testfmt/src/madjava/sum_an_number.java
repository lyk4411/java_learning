package madjava;

public final class sum_an_number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getAllComp(11, 12);
	}

	static void getAllComp(int n, int m) {
		String pre = m + "=";
		if (n * (n + 1) < m) {
			System.err.println("input error number");
		} else {
			for (int i = 0; i < m / 2 && i < n; i++) {
				if (i != m - i && (m - i) < n) {
					System.out.println("here:" + pre + i + "+" + (m - i));
				}
				getTheResult(m - i, pre + i, i, n);
			}
		}
	}

	static void getTheResult(int m, String pre, int j, int n) {
		for (int i = j + 1; i < m / 2 && i < n; i++) {
			if (i != m - i && (m - i) < n) {
				System.out.println("there:" + pre + "+" + i + "+" + (m - i));
			} else {
				getTheResult(m - i, pre + "+" + i, i, n);
			}
		}
	}
}
