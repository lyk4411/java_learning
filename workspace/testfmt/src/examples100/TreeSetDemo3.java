package examples100;

import java.util.Comparator;
import java.util.TreeSet;

class TreeSetDemo3 {
	public static void main(String[] args) {
		TreeSet ts = new TreeSet(new Student3ComparatorByName());

		ts.add(new Student3("lisi0", 30));
		ts.add(new Student3("lisixx", 29));
		ts.add(new Student3("lisi9", 29));
		ts.add(new Student3("lisi8", 38));
		ts.add(new Student3("lisixx", 29));
		ts.add(new Student3("lisi4", 14));
		// ts.add(new Student3(39));
		ts.add(new Student3("lisi7", 27));

		System.out.println(ts);
	}
}

class Student3ComparatorByName implements Comparator {
	public int compare(Object o1, Object o2) {
		Student3 s1 = (Student3) o1;
		Student3 s2 = (Student3) o2;

		int num = s1.getName().compareTo(s2.getName());
		return num == 0 ? new Integer(s1.getAge()).compareTo(new Integer(s2
				.getAge())) : num;
	}
}

// 同姓名同年龄的学生视为同一个学生。按照学生的年龄排序。
class Student3 /* implements Comparable */{
	private int age;
	private String name;

	Student3(String name, int age) {
		this.age = age;
		this.name = name;
	}

	/*
	 * public int compareTo(Object obj) {
	 * 
	 * Student3 stu = (Student3) obj;
	 * 
	 * int num = new Integer(this.age).compareTo(new Integer(stu.age));
	 * 
	 * return num == 0 ? this.name.compareTo(stu.name) : num; }
	 */
	/*
	 * if(this.age>stu.age) return 1; if(this.age==stu.age) return
	 * this.name.compareTo(stu.name); return -1;
	 */
	/**/

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return name + "::" + age;
	}
}
