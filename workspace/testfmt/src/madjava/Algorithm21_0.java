package madjava;

public class Algorithm21_0 {
	static void getAllComp(int n, int m) {
		String pre = m + "=";
		int theMax = (1 + n) * n / 2;
		if (theMax < m) {
			System.out.println("�����ڸ�����");
		} else {
			for (int i = 1; i < n && i <= m / 2; i++) {
				// ��1��ʼ��������ӡ������������ϣ��������������
				if (i != m - i && ((m - i) <= n)) {
					System.out.println("here:" + pre + i + "+" + (m - i));
					// continue;
				}
				// ���õݹ飬������ô���2���������
				getTheResult(m - i, pre + i, i, n);
			}
		}
	}

	// ���õݹ飬������ô���2���������,jΪ��������ù�����������ȡ���ڸ����ġ�
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