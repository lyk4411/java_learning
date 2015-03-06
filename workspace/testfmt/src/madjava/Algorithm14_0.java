package madjava;

public class Algorithm14_0 {

	static void getSum(int[] a, int sum) {
		int length = a.length;
		int i, j;
		i = 0;
		j = length - 1;
		while (i < j) {
			if (a[i] + a[j] > sum) {
				j--;
			} else if (a[i] + a[j] < sum) {
				i++;
			} else {
				System.out.println(a[i] + "  " + a[j]);
				i++;
				j--;
			}
		}
	}

	public static void main(String args[]) {
		int a[] = { 1, 3, 4, 7, 8, 9, 9, 12 };
		int sum = 13;
		getSum(a, sum);
	}
}