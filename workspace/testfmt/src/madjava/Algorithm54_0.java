package madjava;

public class Algorithm54_0 {

	public static void main(String[] args) {
		int a[] = { 7, 8, 2, 4, 59, 6, 1, 45, 52 };
		int i = 0, j = a.length - 1;
		while (i < j) {
			if ((a[j] & 1) == 0)
				j--;// ÅÐ¶ÏÊÇ·ñÊÇÆæÊý
			if ((a[i] & 1) != 0)
				i++;
			swap(a, i, j);
			i++;
			j--;
		}
		for (int aa : a) {
			System.out.println(aa);
		}
	}

	static void swap(int a[], int i, int j) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
}
