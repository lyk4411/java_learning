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
		 * 1.如果对象实现Serializable，但是又在自己的对象中定义了writeObject()和readObject()方法
		 * 那么编译器就会放弃Serializable接口的默认的序列化机制，但是可以在对象的writeObject()和readObject()中
		 * 调用out.defaultWriteObject()和in.defaultReadObject()方法来开启默认的序列化机制；
		 * 如果对于transient字段
		 * 我们可以调用对象的writeObject()和readObject()方法来序列化，这就实现了transient属性不能序列化的缺点，因为
		 * 有的时候需要让transient属性页得到序列化
		 * 2.在这里的readObject()方法可以只取出一个属性，因为这是在序列化对象的内部，而序列化对象的外部是
		 * 把这整个序列化对象取出来，所以这里与顺序和取多少个属性无关（其他例子有说到顺序的问题，这是一点区别）
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