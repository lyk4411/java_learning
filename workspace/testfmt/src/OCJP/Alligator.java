package OCJP;

class Alligator {
	public static void main(String[] args) {
		int[] x[] = { { 1, 2 }, { 3, 4, 5 }, { 6, 7, 8, 9 } };
		int[][] y = x;
		System.out.println(y[2][1]);
	}

}