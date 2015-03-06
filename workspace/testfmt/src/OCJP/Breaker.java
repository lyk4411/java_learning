package OCJP;

public class Breaker {
	static String o = "";

	public static void main(String[] args) {
		o = o + 2;
		z: for (int x = 3; x < 8; x++) {
			if (x == 4)
				//continue;
				break;
			if (x == 6)
				break z;
			o = o + x;
		}
		System.out.println(o);
	}
}