package OCJP;

import java.util.*;

public class Explorer3 {
	public static void main(String[] args) {
		TreeSet<Integer> s = new TreeSet<Integer>();
		TreeSet<Integer> subs = new TreeSet<Integer>();
		for (int i = 606; i < 613; i++)
			if (i % 2 == 0)
				s.add(i);
		subs = (TreeSet) s.subSet(608, true, 610, false);
		subs.add(608);
		System.out.println(s + " " + subs);
		Explorer3 a = new Explorer3();
		a.go();
		
		new B().process();
		
	}
	
	 public void go() {
		String o = "";
		z: for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 2; y++) {
				if (x == 1)
					break;
				if (x == 2 && y == 1)
					break z;
				o = o + x + y;
			}
		}
		System.out.println(o);
	}
	 
	 static class A {
		  void process() throws Exception { throw new Exception(); }
		  }
	 static class B extends A {
		  void process() { System.out.println("B"); }
		  }
}