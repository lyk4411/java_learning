package OCJP;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class LinkedListTest {
	public static void main(String... arg) {
		Employee jim = new Employee("Jim");
		Employee bob = new Employee("Bob");
		Employee gin = new Employee("Gin");

		Employee[] staff = new Employee[3];
		staff[0] = jim;
		staff[1] = bob;
		staff[2] = gin;
		List<Employee> staffList = Arrays.asList(staff);

		System.out.println(staffList);// [Name:Jim, Name:Bob, Name:Gin]
		System.out.println(staffList.get(2));// Name:Gin

		/************ SortedMap接口 *******************************************/
		SortedMap<String, Employee> sm = new TreeMap<String, Employee>();
		sm.put("123", jim);
		sm.put("234", bob);
		sm.put("345", gin);
		System.out.println(sm);// {123=Name:Jim, 234=Name:Bob, 345=Name:Gin}

		SortedMap<String, Employee> smSub = sm.subMap("123", "345");// 包括123，不包括345
		System.out.println(smSub);// {123=Name:Jim, 234=Name:Bob}
		smSub = sm.headMap("234");// 返回比234小的，不包括234
		System.out.println(smSub);// {123=Name:Jim}
		smSub = sm.tailMap("234");// 返回比234大的，不包括234
		System.out.println(smSub);// {345=Name:Gin}
		System.out.println("==========================");
		smSub = sm.tailMap("233");// 返回比234大的，不包括234
		System.out.println(smSub);// {345=Name:Gin}
		System.out.println("==========================");

		/************ NavigableMap接口 *******************************************/
		NavigableMap<String, Employee> nm = new TreeMap<String, Employee>();
		nm.put("123", jim);
		nm.put("234", bob);
		nm.put("345", gin);
		System.out.println(nm);// {123=Name:Jim, 234=Name:Bob, 345=Name:Gin}

		NavigableMap<String, Employee> nmSub = nm.subMap("123", true, "345",
				false);// 包括123，不包括345
		System.out.println(nmSub);// {123=Name:Jim, 234=Name:Bob}
		nmSub = nm.headMap("234", true);// 返回比234小的，true表示包括234
		System.out.println(nmSub);// {123=Name:Jim, 234=Name:Bob}
		nmSub = nm.tailMap("234", true);// 返回比234大的，true表示包括234
		System.out.println(nmSub);// {234=Name:Bob, 345=Name:Gin}
		System.out.println("=========SortedSet================");

		/************ SortedSet接口 *******************************************/
		SortedSet<Employee> ss = new TreeSet<Employee>(
				new Comparator<Employee>() {
					public int compare(Employee a, Employee b) {
						return a.getName().compareTo(b.getName());
					}
				});
		ss.add(jim);
		ss.add(bob);
		ss.add(gin);
		System.out.println(ss);// [Name:Bob, Name:Gin, Name:Jim]

		// 以下的特点是，包括from，不包括to
		SortedSet<Employee> ssSub = ss.subSet(gin, jim);// 返回比gin大，比jim小的，不包括jim
		System.out.println(ssSub);// [Name:Gin]
		ssSub = ss.headSet(gin);// 返回比gin小的，不包括gin
		System.out.println(ssSub);// [Name:Bob]
		ssSub = ss.tailSet(gin);// 返回比gin大的，包括gin
		System.out.println(ssSub);// [Name:Gin, Name:Jim]

		/************ NavigableSet接口 *******************************************/
		NavigableSet<Employee> ns = new TreeSet<Employee>(
				new Comparator<Employee>() {
					public int compare(Employee a, Employee b) {
						return a.getName().compareTo(b.getName());
					}
				});
		ns.add(jim);
		ns.add(bob);
		ns.add(gin);
		System.out.println(ns);// [Name:Bob, Name:Gin, Name:Jim]

		// 以下的特点是，根据inclusive参数决定是否包括from，to
		NavigableSet<Employee> nsSub = ns.subSet(gin, true, jim, true);// 返回比gin大，比jim小的，true表示包括gin和jim
		System.out.println(nsSub);// [Name:Gin, Name:Jim]
		nsSub = ns.headSet(gin, true);// 返回比gin小的，true表示包括gin
		System.out.println(nsSub);// [Name:Bob, Name:Gin]
		nsSub = ns.tailSet(gin, true);// 返回比gin大的，包括gin
		System.out.println(nsSub);// [Name:Gin, Name:Jim]
	}
}

class Employee {
	public Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		return "Name:" + name;
	}

	private String name = "";// 实例域初始化
}