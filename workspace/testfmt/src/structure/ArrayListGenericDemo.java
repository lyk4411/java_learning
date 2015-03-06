package structure;

import java.util.*;

// BEGIN main
public class ArrayListGenericDemo {
	public static void main(String[] args) {
		ArrayList<String> data = new ArrayList<>();
		data.add("hello");
		data.add("goodbye");
		// data.add(new Date()); This won't compile!

		Iterator<String> it = data.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
	}
}
// END main