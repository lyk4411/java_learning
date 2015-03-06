package OCJP;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class Drink implements Comparable {
	public String name;

	public int compareTo(Object o) {
		return 0;
	}
	 public String toString() {
	        return "myname: " + name;
	    }

	final static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> pascal = new ArrayList<List<Integer>>();

		for (int i = 0; i < numRows; i++) {
			int nCk = 1;
			for (int a = 0; a <= i; a++) {
				System.out.print(nCk + " ");
				nCk = nCk * (i - a) / (a + 1);
			}
			System.out.println();
		}
		return pascal;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<List<Integer>> a = generate(10);
		for (int i = 0; i < a.size(); i++) {
			List<Integer> b = a.get(i);
			for (int j = 0; j < b.size(); j++) {
				System.out.print(b.get(j));
			}
			//System.out.println("");
		}

		Drink one = new Drink();
		Drink two = new Drink();
		one.name = "Coffee";
		two.name = "Tea";
		TreeSet set = new TreeSet();
		set.add(one);
		set.add(two);
		
		Iterator it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
	}
}
