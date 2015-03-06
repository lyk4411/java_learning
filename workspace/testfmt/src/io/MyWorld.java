package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

class House implements Serializable {
	private static final long serialVersionUID = 7726379233155420025L;
}

class Animal implements Serializable {
	private static final long serialVersionUID = 8278386775550453403L;
	private String name;
	private House house;

	public Animal(String name, House house) {
		this.name = name;
		this.house = house;
	}

	public String toString() {
		return name + "[" + super.getClass() + "], " + house + "\n";
	}
}

@SuppressWarnings("unchecked")
public class MyWorld {
	public static void main(String[] args) {
		House house = new House();

		Vector animals = new Vector();
		animals.add(new Animal("dog", house));
		animals.add(new Animal("cat", house));
		animals.add(new Animal("mouse", house));
		System.out.println(animals + " aaa");
		try {
			ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
			ObjectOutputStream out1 = new ObjectOutputStream(buf1);
			out1.writeObject(animals);
			out1.writeObject(animals);
			ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
			ObjectOutputStream out2 = new ObjectOutputStream(buf2);
			out2.writeObject(animals);
			out1.close();
			out2.close();

			ObjectInputStream in1 = new ObjectInputStream(
					new ByteArrayInputStream(buf1.toByteArray()));
			ObjectInputStream in2 = new ObjectInputStream(
					new ByteArrayInputStream(buf2.toByteArray()));
			Vector animal1 = (Vector) in1.readObject();
			Vector animal2 = (Vector) in1.readObject();
			Vector animal3 = (Vector) in2.readObject();
			/**
			 * 1.animal1和animal2是同一个数据流中的对象，animal3是另一个数据流的对象，当对象的被恢复的时候可以看到
			 * house地址的区别：animal1和animal2中是相同的，而他们跟animal3是不同的，所以在同一个数据流中，相同的
			 * 对象不会重复出现。 2.当数据流不同的时候，所生成的对象网也会不同
			 */
			System.out.println(animal1 + " bbbb");
			System.out.println(animal2 + " cccc");
			System.out.println(animal3 + " dddd");

			System.out.println(animals + " eeee");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}