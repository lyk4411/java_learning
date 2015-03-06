package OCJP;

public class Pass {
	public static void main(String[] args) {
		int x = 5;
		Pass p = new Pass();
		p.doStuff(x);
		System.out.print(" main x = " + x);
	}

	void doStuff(int x) {
		System.out.print(" doStuff x = " + x++);
	}

}