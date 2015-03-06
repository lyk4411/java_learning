package OCJP;

class Foo5 {
	private int x;

	public Foo5(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

}


public class Gamma {
	
	static Foo5 fooBar(Foo5 foo){
		foo = new Foo5(100);
		return foo;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Foo5 foo = new Foo5(300);
		System.out.println(foo.getX() + "-");
		
		Foo5 fooFoo = fooBar(foo);
		System.out.println(foo.getX() + "-");
		System.out.println(fooFoo.getX() + "-");
		
		foo = fooBar(fooFoo);
		System.out.println(foo.getX() + "-");
		System.out.println(fooFoo.getX());
	}

}
