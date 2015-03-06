package io;

import java.io.*;
import java.util.*;

//������ͨ��ʵ��Externalizable�ӿڿ��ƶ������л��ͷ�����   
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

	// �����л�����ʱ,�÷����Զ�����
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("����ִ�����л�����");
		// ���������л�ʱд������ı���
		Date d = new Date();
		out.writeObject(d);
		// ֻ���л�userName,userPass����
		out.writeObject(userName);
		out.writeObject(userPass);
	}

	// �������л�����ʱ,�÷����Զ�����
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		System.out.println("����ִ�з����л�����");
		Date d = (Date) in.readObject();
		System.out.println(d);
		this.userName = (String) in.readObject();
		this.userPass = (String) in.readObject();
	}

	public String toString() {
		return "�û���: " + this.userName + ";���룺" + this.userPass + ";���䣺"
				+ this.userAge;
	}
}