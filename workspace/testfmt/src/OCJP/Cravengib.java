package OCJP;

class BaseTT {
	void amethod() {
		System.out.println("BaseTT.amethod");
	}
}

public class Cravengib extends BaseTT {
	public static void main(String arg[]) {
		BaseTT cg = new Cravengib();
		cg.amethod();
		
		Lhist<Integer> li = new Lhist<Integer>(30);
		li.add(10);
		li.add(20);
		li.add(10);
		System.out.println(li.get(0));
		System.out.println(li.get(1));
		System.out.println(li.get(2));
		
	}

	void amethod() {
		System.out.println("Cravengib.amethod");

		
	}
}