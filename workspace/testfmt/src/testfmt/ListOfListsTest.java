package testfmt;

import java.util.ArrayList;
import java.util.List;

public class ListOfListsTest {
	public static void main(String[] args) {
		List<String> listOfStrings = new ArrayList<String>();
		listOfStrings.add("Hello again");
		List<List<String>> listOfLists = new ArrayList<List<String>>();
		listOfLists.add(listOfStrings);
		String s = listOfLists.get(0).get(0);
		System.out.println(s); // prints "Hello again"
	}
}