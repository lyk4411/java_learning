package io;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Person implements Serializable {
	private String name;
	private int age;

	public Person() {

	}

	public Person(String str, int n) {
		System.out.println("Inside Person's Constructor");
		name = str;
		age = n;
	}

	String getName() {
		return name;
	}

	int getAge() {
		return age;
	}
}