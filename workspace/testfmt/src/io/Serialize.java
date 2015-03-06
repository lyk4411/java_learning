package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Serialize {
	public static void main(String[] args) {
		Serialize ser = new Serialize();
		ser.serializeToXml();
		ser.deSerializeFromXml();
	}

	public void serializeToXml() {
		Person[] myPerson = new Person[2];
		myPerson[0] = new Person("Jay", 24);
		myPerson[1] = new Person("Tom", 23);

		XStream xstream = new XStream();
		try {
			FileOutputStream fos = new FileOutputStream(
					"D:\\Users\\liu.yongkai\\workspace\\testfmt\\myPerson1.txt");
			xstream.toXML(myPerson, fos);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		System.out.println(xstream.toXML(myPerson));
	}

	public void deSerializeFromXml() {
		XStream xs = new XStream(new DomDriver());
		Person[] myPerson = null;

		try {
			FileInputStream fis = new FileInputStream(
					"D:\\Users\\liu.yongkai\\workspace\\testfmt\\myPerson1.txt");
			myPerson = (Person[]) xs.fromXML(fis);
			if (myPerson != null) {
				int len = myPerson.length;
				for (int i = 0; i < len; i++) {
					//System.out.println(myPerson[i].getName());
					//System.out.println(myPerson[i].getAge());
					System.out.println("aaaaaa");
				}

			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}
}