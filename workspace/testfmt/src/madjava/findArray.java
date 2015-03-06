package madjava;

public class findArray {

	public static void main(String[] args) {
		int a = 23, b = 53, N = 160;
		int arr[] = new int[N];
		getArray(a, b, N, arr);
		for (int ar : arr) {
			System.out.print(" " + ar);
		}
	}

	private static void getArray(int a, int b, int n, int[] arr) {

		int i = 0;
		int aMin = a;
		int bMin = b;
		while (i < n) {
			if (i == 0) {
				arr[i] = a;
				i++;
				continue;
			}

			aMin += a;
			if (aMin < bMin) {
				arr[i] = aMin;
			} else {
				arr[i] = bMin;
				bMin += b;
				aMin -= a;
			}
			i++;
		}
	}
}