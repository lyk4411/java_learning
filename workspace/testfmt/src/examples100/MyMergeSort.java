package examples100;

public class MyMergeSort {

	public static void MergeSort(int[] array) {
		sortArray(array, 0, array.length - 1);
	}

	public static void sortArray(int[] array, int start, int end) {
		if (start == end) {
			return;
		}
		int length = end - start + 1;
		int middle;
		if (length % 2 == 0) {
			middle = start + length / 2 - 1;
		} else {
			middle = start + length / 2;
		}
		sortArray(array, start, middle);
		sortArray(array, middle + 1, end);
		mergeArray(array, start, middle, end);
	}

	private static void mergeArray(int[] array, int start, int middle, int end) {
		int totalSize = end - start + 1;
		int size1 = middle - start + 1;
		int size2 = end - middle;

		int[] Array1 = new int[size1];
		int[] Array2 = new int[size2];

		for (int i = 0; i < size1; i++) {
			Array1[i] = array[start + i];
		}
		for (int i = 0; i < size2; i++) {
			Array2[i] = array[middle + 1 + i];
		}

		int mergeCount = 0;
		int mergeSize1 = 0;
		int mergeSize2 = 0;
		int value1;
		int value2;

		while (mergeCount < totalSize) {
			if (mergeSize1 == size1) {
				while (mergeSize2 < size2) {
					array[start + mergeCount] = Array2[mergeSize2];
					mergeCount++;
					mergeSize2++;
				}
			} else if (mergeSize2 == size2) {
				while (mergeSize1 < size1) {
					array[start + mergeCount] = Array1[mergeSize1];
					mergeCount++;
					mergeSize1++;
				}
			} else {
				value1 = Array1[mergeSize1];
				value2 = Array2[mergeSize2];

				if (value1 == value2) {
					array[start + mergeCount] = value1;
					array[start + mergeCount + 1] = value1;
					mergeCount++;
					mergeCount++;
					mergeSize1++;
					mergeSize2++;
				} else if (value1 < value2) {
					array[start + mergeCount] = value1;
					mergeSize1++;
					mergeCount++;
				} else {
					array[start + mergeCount] = value2;
					mergeSize2++;
					mergeCount++;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 6, 1, 0, -1, -2, -3 };

		System.out.println("Before Sort:");
		ArrayUtils.printArray(array);

		MergeSort(array);

		System.out.println("After Sort:");
		ArrayUtils.printArray(array);

	}

}
