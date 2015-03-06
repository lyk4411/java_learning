package OCJP;

import java.util.Arrays;

public class Boxer1 {
	Integer i = 0;
	int x;

	public Boxer1(int y) {
		// i = 0;
		x = i + y;
		System.out.println(x);
	}

	 static int[] a = { 7, 6, 5, 4 };
	 static {
	 a[1] = 8;
	 a[3] = 3;
	 }

	public static void main(String[] args) {
		new Boxer1(new Integer(4));
		
		Object[] myObjects = {
				new Integer(12),
				new String("ffff"),
				new Integer(5),
				new Boolean(true)
		};
		
		//Arrays.sort(myObjects);
		
		
		 try {
		 test();
		 } catch (RuntimeException ex) {
		 System.out.print("runtime ");
		 }
		 System.out.print("end ");
	}

	 static void test() throws RuntimeException {
	 System.out.print("test ");
	 throw new RuntimeException();
	
	 // try {
	 // System.out.print("test ");
	 // throw new RuntimeException();
	 // } catch (Exception ex) {
	 // System.out.print("exception ");
	 // }
	 }

}