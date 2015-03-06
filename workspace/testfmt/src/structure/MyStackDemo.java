package structure;

import java.util.Date;

//BEGIN main
public class MyStackDemo {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		MyStack<String> ms1 = new MyStack<>();
		ms1.push("billg");
		ms1.push("scottm");
		while (ms1.hasNext()) {
			String name = ms1.pop();
			System.out.println(name);
		}
		// Old way of using Collections: not type safe.
		// DO NOT GENERICIZE THIS
		MyStack ms2 = new MyStack();
		ms2.push("billg"); // EXPECT WARNING
		//ms2.push("scottm"); // EXPECT WARNING
		ms2.push(new java.util.Date()); // EXPECT WARNING
		//ms2.push("bbbbb");
		// Show that it is broken
//		try {
//			Date bad = (Date) ms2.pop();
//			System.err.println("Didn't get expected exception, popped " + bad);
//		} catch (ClassCastException ex) {
//			System.out.println("Did get expected exception.");
//		}
		// Removed the brokenness, print rest of it.
		while (ms2.hasNext()) {
			String name =  ms2.pop().toString();
			System.out.println(name);
		}
	}
}
// END main