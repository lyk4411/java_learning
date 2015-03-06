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
 * ��Externalizableʵ�ֶ�������л� 1.��Ҫ��readObject�ж���Ҫ�ָ��Ķ�����ж�ȡ���������ݶ���ȡ��Ĭ�Ϲ�������
 * 2.���readObject�ж�ȡ����Ҫ�����ݣ���ô��ʹĬ�Ϲ������Ը����ݽ����˸ı䣬 Ҳ����Ч�ģ�����ʲô���ݣ������ʲô����,
 * 3.����ڹ���������Ĭ�ϣ���ĳ������δ��ʼ������ô������ԻḳֵΪ0����null���л���
 * ����ȡ���ݵ�ʱ��ʹĬ�Ϲ�������������ݽ����˳�ʼ����Ҳ��û�õģ����Ե�ֵ������ ��ȡ������0����null
 * 
 * @author froest
 * 
 */
public class Blip3 implements Externalizable {
	private int i;
	private String s;

	public Blip3() {
		this.i = 3;
		System.out.println("Blip3 constructor");
	}

	public Blip3(int i, String s) {
		System.out.println("Blip3(int ,String)");
		this.i = i + 1;
		this.s = s;
	}

	public String toString() {
		return s + " " + i;
	}

	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		System.out.println("readExternal");
		/**
		 * 1.�����in.readInt()ע�͵�����ô��������ʱ������java.io.OptionalDataException
		 * ��ȥ��ע�ͣ���ô���ǿ��Եģ�˵�����л���Ķ������Ա��밴˳���ȡ����һ������ȡ����
		 * ����ȡ�ڶ������ԣ����������һ������δ����ȡ���ڶ�������Ҳ�ǲ����Ա���ȡ��
		 * 2.���i��ֵ��Ҫʹ��Ĭ�Ϲ����������³�ʼ������ô������in.readInt()��ȥ����һ��ֵ�����ǲ���ֵ��i
		 * �����ȿ���ȡ�����л������е���һ������ֵ���ֿ�����Ĭ�Ϲ����������¸�i��ֵ
		 */
		i = in.readInt();
		s = (String) in.readObject();
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("writeExternal");
		out.writeInt(i);
		out.writeObject(s);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("constructor objects");
		Blip3 blip3 = new Blip3(47, "A string");
		System.out.println(blip3);
		try {
			System.out.println("save object");
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("Blip3.out"));
			out.writeObject("save blip3");
			out.writeObject(blip3);
			out.close();
			System.out.println("read object");
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					"Blip3.out"));
			/**
			 * String ss = (String)in.readObject();���д��������ڣ������ע�� ���߷ŵ�Blip3 b =
			 * (Blip3)in.readObject();֮����ô���������ɴ˿����ж�
			 * ���л����ļ�����˳��ģ�����ʲô˳����룬��ʲô˳��ȡ�������֮ǰ�Ǹ���ȡ���� ��һ��Ҳ���ܱ�ȡ��
			 */
			String ss = (String) in.readObject();
			Blip3 b = (Blip3) in.readObject();
			System.out.println(ss + " ss");
			System.out.println(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}