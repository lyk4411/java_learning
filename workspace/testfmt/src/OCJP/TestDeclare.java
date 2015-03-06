package OCJP;

interface DeclareStuff {
	public static final int EASY = 3;

	void doStuff(int t);//接口默认级别是public！！！
}

public class TestDeclare implements DeclareStuff {
	public static void main(String[] args) {
		int x = 5;
		new TestDeclare().doStuff(++x);
	}

	public void doStuff(int s) {
		System.out.println("s " + s);	
		s += EASY + ++s;
		System.out.println("s " + s);
	}
 }