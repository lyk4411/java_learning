package io;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.lang.management.*;

public class Test {

	// 序列化对象到文件
	public static void serialize(String fileName) {
		try {
			// 创建一个对象输出流，讲对象输出到文件
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(fileName));

			UserInfo user = new UserInfo("renyanwei", "888888", 20);
			out.writeObject(user); // 序列化一个会员对象
			System.out.println(user.toString());
			out.close();
		} catch (Exception x) {
			System.out.println(x.toString());
		}

	}

	// 从文件反序列化到对象
	public static void deserialize(String fileName) {
		try {
			// 创建一个对象输入流，从文件读取对象
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					fileName));

			// 读取UserInfo对象并调用它的toString()方法
			UserInfo user = (UserInfo) (in.readObject());
			System.out.println(user.toString());

			in.close();
		} catch (Exception x) {
			System.out.println(x.toString());
		}

	}

	public static void main(String[] args) {

		serialize("D:\\Users\\liu.yongkai\\workspace\\testfmt\\myPerson2.txt");
		System.out.println("序列化完毕");

		deserialize("D:\\Users\\liu.yongkai\\workspace\\testfmt\\myPerson2.txt");
		System.out.println("反序列化完毕");
	}

}