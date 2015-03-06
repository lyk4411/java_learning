package io;

import java.io.*;
import java.util.*;

//本程序通过实现Externalizable接口控制对象序列化和反序列   
public class UserInfo implements Externalizable {
	public String userName;
	public String userPass;
	public int userAge;

	public UserInfo() {
	}

	public UserInfo(String username, String userpass, int userage) {
		this.userName = username;
		this.userPass = userpass;
		this.userAge = userage;
	}

	// 当序列化对象时,该方法自动调用
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("现在执行序列化方法");
		// 可以在序列化时写非自身的变量
		Date d = new Date();
		out.writeObject(d);
		// 只序列化userName,userPass变量
		out.writeObject(userName);
		out.writeObject(userPass);
	}

	// 当反序列化对象时,该方法自动调用
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		System.out.println("现在执行反序列化方法");
		Date d = (Date) in.readObject();
		System.out.println(d);
		this.userName = (String) in.readObject();
		this.userPass = (String) in.readObject();
	}

	public String toString() {
		return "用户名: " + this.userName + ";密码：" + this.userPass + ";年龄："
				+ this.userAge;
	}
}