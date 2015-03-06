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
	 * �����������
	 * 
	 * @return
	 */
	private static int r() {
		return (int) (Math.random() * 10);
	}

	/**
	 * ������������飬��֤ÿ�����ɵ������ǲ���ͬ��
	 */
	private Data[] d = { new Data(r()), new Data(r()), new Data(r()), new Data(r()) };
	/**
	 * �������ӵ���һ��SerializableTest
	 */
	private SerializableTest next;
	private char c;

	/**
	 * ��������һ�������Ѷ��SerializableTest��������
	 * 
	 * @param i
	 *            ��Ҫ����i��SerializableTest����
	 * @param x
	 *            ���ڱ���ÿ��SerializableTest��������Ե�����
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
	 * ��SerializableTest�е�Data������֯��String�ַ��������ڴ�ӡ���
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
		 * ���ļ��ķ�ʽʵ�����л�
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
		 * ���ֽ����ķ�ʽʵ�����л�
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
		 * ��õĽ������һ���ģ�˵�����������л�֮�󣬿���ͨ���ļ������ֽ����ٴεõ������״̬��Ϣ
		 * ��Ϊ�˶����Data������������������ģ������ͬ˵��û�е��ö���Ĺ���������Ĭ�Ϲ��������������
		 */
	}
}