package testfmt;

import java.util.ArrayList;
import java.util.List;

public class WildCardTest {

	public static void printList(List<?> list2) {
		for (Object element : list2) {
			System.out.println(element);
		}
	}
	
	
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		list1.add("Hello");
		list1.add("World");
		printList(list1);

		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(100);
		list2.add(200);
		printList(list2);
	}
}