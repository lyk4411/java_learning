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
 * 用Externalizable实现对象的序列化 1.需要在readObject中对需要恢复的对象进行读取，否则数据都是取自默认构造器中
 * 2.如果readObject中读取了需要的数据，那么即使默认构造器对该数据进行了改变， 也是无效的，保存什么数据，就输出什么数据,
 * 3.如果在构造器（非默认）中某个属性未初始化，那么这个属性会赋值为0或者null序列化，
 * 当读取数据的时候即使默认构造器对这个数据进行了初始化，也是没用的，属性的值依旧是 读取出来的0或者null
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
		 * 1.如果把in.readInt()注释掉，那么程序运行时将报错java.io.OptionalDataException
		 * 而去掉注释，那么又是可以的，说明序列化后的对象属性必须按顺序读取，第一个属性取完了
		 * 才能取第二个属性，而且如果第一个属性未被读取，第二个属性也是不可以被读取的
		 * 2.如果i的值需要使用默认构造器来重新初始化，那么可以用in.readInt()来去除第一个值，但是不赋值给i
		 * 这样既可以取得序列化对象中得下一个属性值，又可以用默认构造器来重新给i赋值
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
			 * String ss = (String)in.readObject();这行代码必须存在，如果我注释 或者放到Blip3 b =
			 * (Blip3)in.readObject();之后，那么都将报错，由此可以判断
			 * 序列化到文件是有顺序的，必须什么顺序存入，就什么顺序取出，如果之前那个不取出， 下一个也不能被取出
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