package OCJP;

import java.util.Iterator;
import java.util.List;

public class Hello {
	String title;
	int value;

	public Hello() {
		title += " World";
	}

	public Hello(int value) {
		this();

		this.value = value;
		title = "Hello";
		//Hello();

	}



	static void test() {
		try {
			String x = null;
			System.out.print(x.toString() + " ");
		} finally {
			System.out.print("finally ");
		}
	}

	public static int sum(List list) {
		int sum = 0;
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			int i = ((Integer) iter.next()).intValue();
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		Hello c = new Hello(5);
		System.out.println(c.title);
		System.out.println(c.value);

		String s = null;
		System.out.println(s);// null
		// System.out.println(s.toString());//NullPointerException
		System.out.println(s + "hello~~");// nullhello~~

		try {
			test();
		} catch (Exception ex) {
			System.out.print("exception ");
		}
	}
}