package madjava;

public class binarySearch {

	public static String binarySearch(int[] a, int num) {
		if (a.length == 0)
			return "Eroor";
		int startPos = 0;
		int endPos = a.length - 1;
		int m = (startPos + endPos) / 2;
		while (startPos <= endPos) {
			if (num == a[m]) {
				return "所查数在数组的下标为" + m;
			} else if (num > a[m]) {
				System.out.println("binarySearch" + (m + 1));
				startPos = m + 1;
			} else if (num < a[m]) {
				System.out.println("binarySearch" + (m - 1));
				endPos = m - 1;
			}
			m = (startPos + endPos) / 2;
		}
		return "数组中无该数值";
	}

	public static int binarySearch(int[] args, int i, int startPos, int endPos) {

		if (args == null || startPos > endPos)
			return -1;

		int midPos = (startPos + endPos) / 2;
		if (i == args[midPos]) {
			return midPos;
		} else if (i < args[midPos]) {
			System.out.println("binarySearch" + startPos + "" + (midPos - 1));
			return binarySearch(args, i, startPos, midPos - 1);
		} else {
			System.out.println("binarySearch" + (midPos + 1) + "" + endPos);
			return binarySearch(args, i, midPos + 1, endPos);
		}
	}

	public static void main(String args[]) {
		int[] aa = new int[10000000];
		for (int i = 0; i < aa.length; i++) {
			aa[i] = i;
		}
		System.out.println(binarySearch(aa, -6789));
		System.out.println(binarySearch(aa, -6789, 0, aa.length));
	}

}
