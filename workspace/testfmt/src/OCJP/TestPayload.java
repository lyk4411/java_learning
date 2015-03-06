package OCJP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Payload {
	private int weight;

	public Payload(int w) {
		weight = w;
	}

	public void setWeight(int w) {
		weight = w;
	}

	public String toString() {
		return Integer.toString(weight);
	}
}

public class TestPayload {
	static void changePayload(Payload p) { /* insert code */
		// p.setWeight(420);
		p = new Payload(420);
	}

	public static Iterator reverse(List list) {
		Collections.reverse(list);
		return list.iterator();
	}

	public static void main(String[] args) {
		Payload p = new Payload(200);
		p.setWeight(1024);
		changePayload(p);
		System.out.println("p is " + p);


		List list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");


	
	}
}