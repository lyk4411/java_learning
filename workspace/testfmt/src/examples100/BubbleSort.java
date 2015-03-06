package examples100;

public class BubbleSort {

	public static void main(String[] args) {
		int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3 };

		System.out.println("Before sort:");
		ArrayUtils.printArray(array);

		bubbleSort(array);

		System.out.println("After sort:");
		ArrayUtils.printArray(array);
	}

	public static void bubbleSort(int[] array) {
		if (array.length <= 1) {
			return;
		}

		int size = array.length;
		for (int i = size - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					ArrayUtils.exchangeElements(array, j, j + 1);
				}
			}
		}
	}
}