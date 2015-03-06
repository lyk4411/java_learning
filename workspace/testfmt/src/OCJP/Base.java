package OCJP;

public class Base {
	public static final String FOO = "foo";

	public static void main(String[] args) {
		Base b = new Base();
		Sub38 s = new Sub38();
		System.out.println(Base.FOO);
		System.out.println(Sub38.FOO);
		System.out.println(b.FOO);
		System.out.println(s.FOO);
		System.out.println(((Base) s).FOO);
	}
}

class Sub38 extends Base {
	public static final String FOO = "bar";
}