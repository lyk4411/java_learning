package OCJP;

public class testMain {
	public static void main(String[] args) {



		if (Boolean.valueOf("TRuE")) {
			System.out.println("True");
		}

		for (int i = 0; i <= 10; i++) {
			if (i > 6)
				break;
		}
		System.out.println("aaa");

		try {
			args = null;
			args[0] = "test";
			System.out.println(args[0]);
		} catch (NullPointerException ex) {
			System.out.println("Exception");
		} catch (Exception npe) {
			System.out.println("NullPointerException");
		}
	}
}
