package io;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * 此例说明了实现Externalizable方法后，当恢复对象的时候会调用相应类的构造器，所以如果在构造器中没有初始化， 那么会得到0或者null
 * 
 * @author froest
 * 
 */
class Blip1 implements Externalizable {
	private int i;

	public Blip1() {
		System.out.println("Blip1 constructor");
	}

	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		System.out.println("Blip1.readExternal");
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip1.writeExternal");
	}

	public void setI(int i) {
		this.i = i;
	}

	public int get() {
		return i;
	}
}

class Blip2 implements Externalizable {

	public Blip2() {
		System.out.println("Blip2.constructor");
	}

	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		System.out.println("Blip2.readExternal");
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip2.writeExternal");
	}
}

public class Blips {
	public static void main(String[] args) {
		System.out.println("constructor Object");
		Blip1 b1 = new Blip1();
		b1.setI(100);
		Blip2 b2 = new Blip2();
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("Blip.x"));
			System.out.println("saving object");
			out.writeObject(b1);
			out.writeObject(b2);
			out.close();
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					"Blip.x"));
			System.out.println("getting object");
			System.out.println("recovering b1");
			b1 = (Blip1) in.readObject();
			System.out.println(b1.get());
			System.out.println("recovering b2");
			b2 = (Blip2) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}