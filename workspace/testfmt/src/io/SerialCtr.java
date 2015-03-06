package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerialCtr implements Serializable {
	private static final long serialVersionUID = 5442274055003105383L;
	private String name;
	private transient String password;

	public SerialCtr(String a, String b) {
		this.name = a;
		this.password = b;
	}

	public String toString() {
		return "Not transient : " + name + "\n transient : " + password;
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		/**
		 * 1.�������ʵ��Serializable�����������Լ��Ķ����ж�����writeObject()��readObject()����
		 * ��ô�������ͻ����Serializable�ӿڵ�Ĭ�ϵ����л����ƣ����ǿ����ڶ����writeObject()��readObject()��
		 * ����out.defaultWriteObject()��in.defaultReadObject()����������Ĭ�ϵ����л����ƣ�
		 * �������transient�ֶ�
		 * ���ǿ��Ե��ö����writeObject()��readObject()���������л������ʵ����transient���Բ������л���ȱ�㣬��Ϊ
		 * �е�ʱ����Ҫ��transient����ҳ�õ����л�
		 * 2.�������readObject()��������ֻȡ��һ�����ԣ���Ϊ���������л�������ڲ��������л�������ⲿ��
		 * �����������л�����ȡ����������������˳���ȡ���ٸ������޹أ�����������˵��˳������⣬����һ������
		 */
		out.defaultWriteObject();
		out.writeObject(password);
	}

	private void readObject(ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		in.defaultReadObject();
		password = (String) in.readObject();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SerialCtr s = new SerialCtr("LH", "1qaz");
		System.out.println("Before Serial: \n" + s);
		// ByteArrayOutputStream buf = new ByteArrayOutputStream();
		try {
			// ObjectOutputStream out = new ObjectOutputStream(buf);
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("SerialExternal.out"));
			out.writeObject(s);
			out.close();
			// ObjectInputStream in = new ObjectInputStream(new
			// ByteArrayInputStream(buf.toByteArray()));
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					"SerialExternal.out"));
			SerialCtr s1 = (SerialCtr) in.readObject();
			System.out.println("After Serial: \n" + s1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}