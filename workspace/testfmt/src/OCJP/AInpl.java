package OCJP;

interface A {
	public void doSomething(String thing);
}

public class AInpl implements A {

	public void doSomething(String msg) {

	}

	public class B {
		public A doit() {
			return null;

		}

		public Object execute() {
			return null;

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class C extends B {
		public AInpl doit() {
			return null;

		}

		public Object execute() {
			return null;

		}

		public String execute1() {
			return null;

		}
	}

}
