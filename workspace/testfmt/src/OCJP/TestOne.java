package OCJP;

public class TestOne {
	public static void main(String[] args) throws Exception {
		Thread.sleep(3000);
		System.out.println("sleep");

		Object obj = new int[] { 1, 2, 3 };
		int[] someArray = (int[]) obj;
		for (int i : someArray)
			System.out.print(i + " ");
	}
}