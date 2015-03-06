package OCJP;

import java.util.*;

public class WrappedString {
	private String s;

	public WrappedString(String s) {
		this.s = s;
	}

	public static void main(String[] args) {
		HashSet<Object> hs = new HashSet<Object>();
		WrappedString ws1 = new WrappedString("aardvark");
		WrappedString ws2 = new WrappedString("aardvark");
		String s1 = new String("aardvark");
		String s2 = new String("aardvark");
		Integer a = new Integer(1);
		Integer b = new Integer(1);
		Integer c = new Integer(1);
		Double  d = new Double(1);
		Double  e = new Double(1);
		Double  f = new Double(1);
		
		
		hs.add(ws1);
		hs.add(ws2);
		hs.add(s1);
		hs.add(s2);
		hs.add(a);
		hs.add(b);
		hs.add(d);
		hs.add(e);
		hs.add(f);
		
		System.out.println(hs.size());
	}
}