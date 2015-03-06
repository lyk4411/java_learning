package examples100;

import java.util.TreeSet;

class TreeSetDemo2 {
	public static void main(String[] args) {
		TreeSet ts = new TreeSet();

		ts.add(new Student1("lisi0", 30));
		ts.add(new Student1("lisixx", 29));
		ts.add(new Student1("lisi9", 29));
		ts.add(new Student1("lisi8", 38));
		ts.add(new Student1("lisixx", 29));
		ts.add(new Student1("lisi4", 14));
		// ts.add(new Student1(39));
		ts.add(new Student1("lisi7", 27));

		System.out.println(ts);
	}
}

// 同姓名同年龄的学生视为同一个学生。按照学生的年龄排序。

class Student1 implements Comparable {
	private int age;
	private String name;

	Student1(String name, int age) {
		this.age = age;
		this.name = name;
	}

	public int compareTo(Object obj) {

		Student1 stu = (Student1) obj;

		int num = new Integer(this.age).compareTo(new Integer(stu.age));

		return num == 0 ? this.name.compareTo(stu.name) : num;

		/*
		 * if(this.age>stu.age) return 1; if(this.age==stu.age) return
		 * this.name.compareTo(stu.name); return -1;
		 */
		/**/
	}

	public int getAge() {
		return age;
	}

	public String toString() {
		return name + "::" + age;
	}
}
