package OCJP;

class SuperCalc {
	
	private static int counter = 0;
	public static int getCount(){
		return counter;
	}
	protected static int multiply(int a, int b) {
		return a * b;	
	}
}

public class SubCalc extends SuperCalc {

	public static int multiply(int a, int b) {
		
		int c = SuperCalc.multiply(a, b);
		
		return c;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuperCalc sc = new SubCalc();
		System.out.println(sc.multiply(3, 4));
		System.out.println(SubCalc.multiply(2, 2));
	}

}
