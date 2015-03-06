package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestTransient {

	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		A a = new A(25, "ÕÅÈý");
		System.out.println(a);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				"d://mm.txt"));
		oos.writeObject(a);
		oos.close();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				"d://mm.txt"));
		a = (A) ois.readObject();
		System.out.println(a);

	}

}

class A implements Serializable {
	int a;
	transient String b;

	public A(int a, String b) {
		this.a = a;
		this.b = b;
	}

	public String toString() {
		return "a = " + a + ",b = " + b;
	}
}