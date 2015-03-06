package jdk5newfeature;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i1 = 137;// 自动装箱成整形对象

		Integer i2 = 137;// 自动装箱成整形对象

		System.out.println(i1 == i2);// 打印出false
		/* 137大于127，所以i1和i2指向了两个不同的堆内存对象。地址不相等，打印false */

		i1 = 13;

		i2 = 13;

		System.out.println(i1 == i2); // 打印出true

		int arr[] = { 1, 2, 3 };
		for (int i : arr) {
			i = 10;// 只是修改其指向。并没有改变数组或集合中的数据。

		}

		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
	}

}
