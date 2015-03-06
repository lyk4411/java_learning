package testfmt;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Demonstrate the Set interface
 * 
 * @author Ian F. Darwin, http://www.darwinsys.com/
 */
public class SetDemo {
	public static void main(String[] argv) {
		// BEGIN main
		Set<String> hashSet = new HashSet<>();
		hashSet.add("One");
		hashSet.add("Two");
		hashSet.add("One"); // DUPLICATE
		hashSet.add("Three");

		Iterator it = hashSet.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());// END main
		}
	}
}