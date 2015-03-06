package OCJP;

import java.util.Scanner;

class BinSearch {
	public static int binarySearch(int a[], int x, int n) {
		int left = 0;
		int right = n - 1;
		while (left <= right) {
			// int middle = (left + right)/2;
			int middle = left + (right - left) / 2;
			if (x == a[middle])
				return middle;
			if (x > a[middle])
				left = middle + 1;
			else
				right = middle - 1;
		}
		return -1;
	}
}

public class BinarySearch {
	static Scanner cin = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Please input a integer(the size of array):");
		int sizeOfArray = cin.nextInt();
		int a[] = new int[sizeOfArray];
		System.out.println("Please input " + sizeOfArray + " sorted numbers: ");
		for (int i = 0; i < sizeOfArray; i++)
			a[i] = cin.nextInt();
		System.out.println("Please input the number you want to search:   ");
		int x = cin.nextInt();
		System.out.println("Location: " + BinSearch.binarySearch(a, x,

		sizeOfArray));
	}
}