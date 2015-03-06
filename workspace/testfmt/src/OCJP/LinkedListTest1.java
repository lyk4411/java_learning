package OCJP;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class LinkedListTest1 {
	public static void main(String... arg) {
		Employee1 jim = new Employee1("Jim", 8000);
		Employee1 bob = new Employee1("Bob", 9000);
		Manager jin = new Manager("Gin", 10000, 4000);

		/********* HashSet类测试 ************************************/
		Set<Employee1> staff = new HashSet<Employee1>();
		staff.add(jim);
		staff.add(bob);
		staff.add(jin);
		staff.add(bob);// HashCode相同，拒绝添加
		System.out.println(staff.size());// 3

		Iterator<Employee1> iter = staff.iterator();
		while (iter.hasNext()) {
			Employee1 e = iter.next();
			System.out.println(e);
		}

		/********* TreeSet类测试 ************************************/
		Set<Employee1> otherStaff = new TreeSet<Employee1>(
				new Comparator<Employee1>() {
					public int compare(Employee1 a, Employee1 b) {
						return (int) (a.getSalary() - b.getSalary()); // 根据salsay的大小排序
					}
				});
		otherStaff.add(bob);
		otherStaff.add(jim);
		otherStaff.add(jin);
		System.out.println(otherStaff);// [id:1 name:Jim salary:8000.0, id:2
										// name:Bob salary:9000.0]
	}
}

class Employee1 {
	public Employee1(String name) {
		this.name = name;
		id = nextId;
		nextId++;
	}

	public String toString() {
		return "id:" + id + " name:" + name + " salary:" + salary;
	}

	public int hashCode() {
		return id;
	}

	public boolean equals(Employee1 e) {
		if (id - e.getId() == 0)
			return true;
		return false;
	}

	public Employee1(String name, double salary) {
		this(name);// 调用另一构造器
		this.salary = salary;
	}

	// 定义访问器方法
	public final String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public final int getId() {
		return id;
	}

	// 定义更改器方法
	public final void setName(String name) {
		this.name = name;
	}

	public final void setSalary(double salary) {
		this.salary = salary;
	}

	public final void raiseSalary(double percent) {
		this.salary *= (1 + percent);
	}

	// 定义变量
	private String name = "";// 实例域初始化
	private double salary;
	private int id;
	private static int nextId = 1;

}

class Manager extends Employee1 {
	public Manager(String name, double salary, double bonus) {
		super(name, salary);// super在构造器中的使用，可以调用超类的构造器
		setBonus(bonus);
	}

	public String toString() {
		return super.toString() + ",bonus:" + bonus;
	}

	public double getBonus() {
		return bonus;
	}

	// 重写getSalary方法
	public double getSalary() {
		double baseSalary = super.getSalary();// 调用了超类的getSalary方法
		return baseSalary + bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	private double bonus;
}