package OCJP;

public class Q37 {
	public static void main(String[] args) {

	}
}

class Super {
	private int a;

	protected Super(int a) {
		this.a = a;
	}
}

class Sub extends Super {
	public Sub(int a) {
		super(a);
	}

	public Sub() {
		super(5);
	}
	public Sub(int i,int j){
		this(5);

	}
}