package testfmt;

public class ArrayTest {
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5 }; // 初始化一个数组，长度是5（定死了）
		int[] arr2 = new int[10];// 重新初始化数组，长度是10;
		// 将老数组复制到新数组
		for (int i = 0; i < arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		// 将老数组对象arr1指向新数组
		arr1 = arr2;

		// 如果不要复制，最简单的就是直接实例化
		int[] arr1_1 = new int[5];// 初始化一个数组，长度是5（定死了）
		arr1_1 = new int[10]; // 再实例化一次，就是一个新数组，以前数组里的东西就不存在类
	}
}