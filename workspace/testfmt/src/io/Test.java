package io;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.lang.management.*;

public class Test {

	// ���л������ļ�
	public static void serialize(String fileName) {
		try {
			// ����һ�������������������������ļ�
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(fileName));

			UserInfo user = new UserInfo("renyanwei", "888888", 20);
			out.writeObject(user); // ���л�һ����Ա����
			System.out.println(user.toString());
			out.close();
		} catch (Exception x) {
			System.out.println(x.toString());
		}

	}

	// ���ļ������л�������
	public static void deserialize(String fileName) {
		try {
			// ����һ�����������������ļ���ȡ����
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					fileName));

			// ��ȡUserInfo���󲢵�������toString()����
			UserInfo user = (UserInfo) (in.readObject());
			System.out.println(user.toString());

			in.close();
		} catch (Exception x) {
			System.out.println(x.toString());
		}

	}

	public static void main(String[] args) {

		serialize("D:\\Users\\liu.yongkai\\workspace\\testfmt\\myPerson2.txt");
		System.out.println("���л����");

		deserialize("D:\\Users\\liu.yongkai\\workspace\\testfmt\\myPerson2.txt");
		System.out.println("�����л����");
	}

}