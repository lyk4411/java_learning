package OCJP;

interface TestA {
	String toString();
}



public class TestTT {
	public static void main(String[] args) {
		System.out.println(new TestA() {
			public String toString() {
				return "test";
			}
		});
	}
}