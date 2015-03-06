package testfmt;

import java.util.List;
import java.util.ArrayList;

public class GenericListTest {
	public static void main(String[] args) {
		// in JDK 1.4
		List stringList1 = new ArrayList();
		stringList1.add("Java 1.0 - 5.0");
		stringList1.add("without generics");
		// cast to java.lang.String
		String s1 = (String) stringList1.get(0);
		System.out.println(s1.toUpperCase());

		// now with generics in JDK 5
		List<String> stringList2 = new ArrayList<String>();
		stringList2.add("Java 5.0");
		stringList2.add("with generics");
		// no need for type casting
		String s2 = stringList2.get(0);
		System.out.println(s2.toUpperCase());
	}
}