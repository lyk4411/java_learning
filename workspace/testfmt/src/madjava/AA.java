package madjava;

public class AA {

	public AA() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		AA aa = new AA();
		// TODO Auto-generated method stub
		System.out.println(aa.mi(5, 6));
		System.out.println(aa.mi(5, 57));
		System.out.println(aa.mi(5, 5));
		System.out.println(aa.mi(5, 71));
		System.out.println(aa.mi(0.5, 41));
		System.out.println(aa.mi(5, 3));
		System.out.println(aa.mi(5, 4));
	}

	double mi(double a, int b) {
		if (b == 1) {
			return a;
		} else if (b / 2 * 2 == b) {
			return mi(a * a, b / 2);
		} else {
			return a * mi(a, b - 1);
		}
	}
}
