package madjava;

public class diamond {
	public static void main(String[] args) {
		int m = -2;
		for (int i = 0; i < 7; i++) {
			if (i < 4) {
				if (i % 2 == 0) {
					m = m + 3;
				} else
					m = m + 2;
			} else {
				if (i % 2 == 0) {
					m = m - 2;
				} else
					m = m - 3;
			}
			for (int j = 0; j < m; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}