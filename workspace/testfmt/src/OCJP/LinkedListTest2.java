package OCJP;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTest2 {
	public static void main(String... arg) {
		Employee2 jim = new Employee2("Jim", 8000);
		Employee2 bob = new Employee2("Bob", 9000);
		Manager2 jin = new Manager2("Gin", 10000, 4000);

		/******** List�ӿ��еķ������� ************************************************/
		List<Employee2> staffA = new LinkedList<Employee2>();
		staffA.add(jim);
		staffA.add(bob);
		staffA.add(1, jin);
		System.out.println(staffA);// [id:1 name:Jim salary:8000.0, id:3
									// name:Gin salary:10000.0,bonus:4000.0,
									// id:2 name:Bob salary:9000.0]

		List<Employee2> staffB = new LinkedList<Employee2>();
		staffB.add(jim);
		staffB.add(bob);
		System.out.println(staffB);// [id:1 name:Jim salary:8000.0, id:2
									// name:Bob salary:9000.0]

		System.out.println(staffB.remove(0));// ɾ��indexΪ0��Ԫ�ز��������Ԫ�أ�id:1
												// name:Jim salary:8000.0
		staffA.addAll(0, staffB);
		System.out.println(staffA);// [id:2 name:Bob salary:9000.0, id:1
									// name:Jim salary:8000.0, id:3 name:Gin
									// salary:10000.0,bonus:4000.0, id:2
									// name:Bob salary:9000.0]

		staffA.set(0, null);
		System.out.println(staffA);// [null, id:1 name:Jim salary:8000.0, id:3
							 		// name:Gin salary:10000.0,bonus:4000.0,
									// id:2 name:Bob salary:9000.0]

		/******** ListIterator�ӿ��еķ������� ************************************************/
		
		System.out.println("****** ListIterator�ӿ��еķ������� ***********************************");
		ListIterator<Employee2> aIter = staffA.listIterator();
		aIter.next();
		aIter.add(bob);
		System.out.println(staffA);// [null, id:2 name:Bob salary:9000.0, id:1
									// name:Jim salary:8000.0, id:3 name:Gin
									// salary:10000.0,bonus:4000.0, id:2
									// name:Bob salary:9000.0]
		aIter.previous();
		aIter.previous();// ���ڷ��ص��ǵ�һ��Ԫ��null
		aIter.set(bob);
		System.out.println(staffA);// [id:2 name:Bob salary:9000.0, id:2
									// name:Bob salary:9000.0, id:1 name:Jim
									// salary:8000.0, id:3 name:Gin
									// salary:10000.0,bonus:4000.0, id:2
									// name:Bob salary:9000.0]

		while (aIter.hasNext()) {
			aIter.next();
		}
		System.out.println(aIter.nextIndex());// 5������iter�Ѿ�������β��

		while (aIter.hasPrevious()) {
			aIter.previous();
		}
		System.out.println(aIter.previousIndex());// -1������iter�Ѿ�������ͷ��

		/******** LinkedList���еķ������� ************************************************/
		staffA.clear();
		LinkedList<Employee2> ll = (LinkedList<Employee2>) staffA;
		ll.addFirst(jin);
		ll.addLast(jim);
		System.out.println(ll);// [id:3 name:Gin salary:10000.0,bonus:4000.0,
								// id:1 name:Jim salary:8000.0]

		ll.removeLast();
		ll.removeLast();
		System.out.println(ll);// []
	}
}

class Employee2 {
	public Employee2(String name) {
		this.name = name;
		id = nextId;
		nextId++;
	}

	public String toString() {
		return "id:" + id + " name:" + name + " salary:" + salary;
	}

	public Employee2(String name, double salary) {
		this(name);// ������һ������
		this.salary = salary;
	}

	// �������������
	public final String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public final int getId() {
		return id;
	}

	// �������������
	public final void setName(String name) {
		this.name = name;
	}

	public final void setSalary(double salary) {
		this.salary = salary;
	}

	public final void raiseSalary(double percent) {
		this.salary *= (1 + percent);
	}

	// �������
	private String name = "";// ʵ�����ʼ��
	private double salary;
	private int id;
	private static int nextId = 1;

}

class Manager2 extends Employee2 {
	public Manager2(String name, double salary, double bonus) {
		super(name, salary);// super�ڹ������е�ʹ�ã����Ե��ó���Ĺ�����
		setBonus(bonus);
	}

	public String toString() {
		return super.toString() + ",bonus:" + bonus;
	}

	public double getBonus() {
		return bonus;
	}

	// ��дgetSalary����
	public double getSalary() {
		double baseSalary = super.getSalary();// �����˳����getSalary����
		return baseSalary + bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	private double bonus;
}