package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Data implements Serializable {
	/**
     *
     */
	private static final long serialVersionUID = 2018026507498303285L;
	private int i;

	Data(int x) {
		i = x;
	}

	public String toString() {
		return Integer.toString(i);
	}
}

public class SerializableTest implements Serializable {
	/**
     *
     */
	private static final long serialVersionUID = 1303931195327594338L;

	/**
	 * 产生随机整数
	 * 
	 * @return
	 */
	private static int r() {
		return (int) (Math.random() * 10);
	}

	/**
	 * 设置随机数数组，保证每次生成的数都是不相同的
	 */
	private Data[] d = { new Data(r()), new Data(r()), new Data(r()), new Data(r()) };
	/**
	 * 用于连接到下一个SerializableTest
	 */
	private SerializableTest next;
	private char c;

	/**
	 * 用于设置一个链表，把多个SerializableTest连接起来
	 * 
	 * @param i
	 *            需要生成i个SerializableTest对象
	 * @param x
	 *            用于表现每个SerializableTest对象的属性的区别
	 */
	SerializableTest(int i, char x) {
		System.out.println("SerializableTest.Constructor:" + i);
		c = x;
		if (--i > 0) {
			next = new SerializableTest(i, (char) (x + 1));
		}
	}

	SerializableTest() {
		System.out.println("Default constructor");
	}

	/**
	 * 把SerializableTest中的Data数组组织成String字符串，用于打印输出
	 */
	public String toString() {
		String s = ":" + c + "(";
		for (int i = 0; i < d.length; i++) {
			s += d[i].toString();
		}
		s += ")";
		if (null != next) {
			s += next.toString();
		}
		return s;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SerializableTest st = new SerializableTest(6, 'a');
		System.out.println("st = " + st);
		System.out.println("====================================");
		/**
		 * 用文件的方式实现序列化
		 */
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("SerializableTestFile.out"));
			out.writeObject("st");
			out.writeObject(st);
			out.close();
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					"SerializableTestFile.out"));
			String name1 = (String) in.readObject();
			SerializableTest st1 = (SerializableTest) in.readObject();
			System.out.println("name = " + name1 + ",st1 = " + st1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("===================================");
		/**
		 * 用字节流的方式实现序列化
		 */
		try {
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bout);
			out.writeObject("st");
			out.writeObject(st);
			out.flush();
			ObjectInputStream in = new ObjectInputStream(
					new ByteArrayInputStream(bout.toByteArray()));
			String name1 = (String) in.readObject();
			SerializableTest st1 = (SerializableTest) in.readObject();
			System.out.println("name = " + name1 + ",st = " + st1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/**
		 * 获得的结果都是一样的，说明档对象序列化之后，可以通过文件或者字节流再次得到对象的状态信息
		 * 因为此对象的Data数组是用随机数创建的，结果相同说明没有调用对象的构建器，连默认构建器都不会调用
		 */
	}
}