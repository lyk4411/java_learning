package OCJP;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {
	public static void main(String... arg) {
		Map<String, Employee3> staff = new HashMap<String, Employee3>();
		Employee3 lily = new Employee3("Lily", 4000);
		Employee3 john = new Employee3("John", 6000);
		staff.put("1234-9876", lily);
		staff.put("345-8765", john);

		Employee3 e = staff.get("345-8765");
		System.out.println(e.getName());// John

		System.out.println(staff.containsKey("1234-9876"));// true
		System.out.println(staff.containsValue(lily));// true
		System.out.println(staff.size());// 2

		// ����
		Set<String> myKeySet = staff.keySet();
		for (String myKey : myKeySet) {
			System.out.println(myKey);
		}
		/*
		 * ����� 345-8765 1234-9876
		 */

		// ֵ���ϣ����Ǽ�set��
		// staff.values()��������ΪCollection<Employee3>
		for (Employee3 myEmployee3 : staff.values()) {
			System.out.println(myEmployee3);
		}
		/*
		 * ����� id:2,name:John,salary:6000.0 id:1,name:Lily,salary:4000.0
		 */

		// ��ֵ�Լ�
		// staff.entrySet()��������ΪSet<Entry<String, Employee3>>
		for (Map.Entry<String, Employee3> entry : staff.entrySet()) {
			String key = entry.getKey();
			Employee3 value = entry.getValue();
			System.out.println("key:  " + key + "\nvalue:  " + value);
		}
		/*
		 * ����� key: 345-8765 value: id:2,name:John,salary:6000.0 key: 1234-9876
		 * value: id:1,name:Lily,salary:4000.0
		 */

		staff.remove("345-8765");
		System.out.println(staff.size());// 1

		// putAll������
		Map<String, Manager3> otherStaff = new HashMap<String, Manager3>();
		Manager3 jim = new Manager3("Jim", 6000, 1000);
		Manager3 gin = new Manager3("Gin", 8000, 2000);
		otherStaff.put("1111-2222", jim);
		otherStaff.put("2222-3333", gin);

		staff.putAll(otherStaff);
		for (Map.Entry<String, Employee3> entry : staff.entrySet()) {
			String key = entry.getKey();
			Employee3 value = entry.getValue();
			System.out.println("key:  " + key + "\nvalue:  " + value);
		}
		/*
		 * ����� key: 1111-2222 value: id:3,name:Jim,salary:6000.0,bonus:1000.0
		 * key: 2222-3333 value: id:4,name:Gin,salary:8000.0,bonus:2000.0 key:
		 * 1234-9876 value: id:1,name:Lily,salary:4000.0
		 */
	}
}

class Employee3 {
	public Employee3(String name) {
		this.name = name;
		id = nextId;
		nextId++;
	}

	public String toString() {
		return "id:" + id + ",name:" + name + ",salary:" + salary;
	}

	public Employee3(String name, double salary) {
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

class Manager3 extends Employee3 {
	public Manager3(String name, double salary, double bonus) {
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