package jdk5newfeature;

import java.util.ArrayList;
import java.util.Iterator;

public class GenericDemo {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("abc");
		al.add("hehe");
		// al.add(4);//al.add(new Integer(4));//�ᱨ��

		Iterator<String> it = al.iterator();
		while (it.hasNext()) {

			String str = it.next();
			// String str = (String)it.next();//������ǿת��
			System.out.println(str);
		}
	}
}