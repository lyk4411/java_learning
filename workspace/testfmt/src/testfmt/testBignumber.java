package testfmt;

public class testBignumber {
	public static final double THRESHOLD = 0.6;

	public static void main(String args[]) {
		double d = 123;
		double e = 0;
		if (d / e == Double.POSITIVE_INFINITY) {
			System.out.println("POSITIVE_INFINITY");
			System.out.println(d / e);
			System.out.println(-d / e);
		}
		double s = Math.sqrt(-1);
		if (s == Double.NaN) {
			System.out.println("nan");
		}
		if (Double.isNaN(s)) {
			System.out.println("hhhhhhhh");
		}

		System.out.println(round(5.444));
		System.out.println(round(5.5554));
		System.out.println(round(5.644));

	}

	static int round(double d) {
		if (d < 0) {
			throw new IllegalArgumentException("aa");
		}
		int di = (int) Math.floor(d);
		if ((d - di) > THRESHOLD) {
			return di + 1;
		} else {
			return di;
		}
	}

}
