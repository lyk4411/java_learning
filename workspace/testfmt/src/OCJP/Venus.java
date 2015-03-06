package OCJP;

public class Venus {
	static int[] a = new int[5];
	static {
		a[0] = 2;
	}

	public static void main(String[] args) {
		int[] x = { 1, 2, 3 };
		int y[] = { 4, 5, 6 };
		new Venus().go(x, y);

		try {
			test();
		} catch (RuntimeException ex) {
			System.out.print("runtime ");
		}
		System.out.print("end ");

		// static { a[0]=2; }
	}

	void go(int[]... z) {
		for (int[] a : z) {
			System.out.print(a[0]);

		}
	}

	static void test() throws RuntimeException {
		try {
			System.out.print("test ");
			throw new RuntimeException();
		} catch (Exception ex) {
			System.out.print("exception ");
		}
	}
}