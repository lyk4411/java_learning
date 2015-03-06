package testfmt;

import java.util.ArrayList;
import java.util.List;

public class BoundedWildcardTest {
	public static double getAverage(List<? extends Number> numberList) {
		double total = 0.0;
		for (Number number : numberList)
			total += number.doubleValue();
		return total / numberList.size();
	}

	public static void main(String[] args) {
		List<Integer> integerList = new ArrayList<Integer>();
		integerList.add(3);
		integerList.add(30);
		integerList.add(300);
		System.out.println(getAverage(integerList)); // 111.0
		List<Double> doubleList = new ArrayList<Double>();
		doubleList.add(3.0);
		doubleList.add(33.0);
		System.out.println(getAverage(doubleList)); // 18.0
	}
}