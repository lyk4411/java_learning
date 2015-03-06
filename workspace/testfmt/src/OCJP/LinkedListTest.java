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

		/************ SortedMap�ӿ� *******************************************/
		SortedMap<String, Employee> sm = new TreeMap<String, Employee>();
		sm.put("123", jim);
		sm.put("234", bob);
		sm.put("345", gin);
		System.out.println(sm);// {123=Name:Jim, 234=Name:Bob, 345=Name:Gin}

		SortedMap<String, Employee> smSub = sm.subMap("123", "345");// ����123��������345
		System.out.println(smSub);// {123=Name:Jim, 234=Name:Bob}
		smSub = sm.headMap("234");// ���ر�234С�ģ�������234
		System.out.println(smSub);// {123=Name:Jim}
		smSub = sm.tailMap("234");// ���ر�234��ģ�������234
		System.out.println(smSub);// {345=Name:Gin}
		System.out.println("==========================");
		smSub = sm.tailMap("233");// ���ر�234��ģ�������234
		System.out.println(smSub);// {345=Name:Gin}
		System.out.println("==========================");

		/************ NavigableMap�ӿ� *******************************************/
		NavigableMap<String, Employee> nm = new TreeMap<String, Employee>();
		nm.put("123", jim);
		nm.put("234", bob);
		nm.put("345", gin);
		System.out.println(nm);// {123=Name:Jim, 234=Name:Bob, 345=Name:Gin}

		NavigableMap<String, Employee> nmSub = nm.subMap("123", true, "345",
				false);// ����123��������345
		System.out.println(nmSub);// {123=Name:Jim, 234=Name:Bob}
		nmSub = nm.headMap("234", true);// ���ر�234С�ģ�true��ʾ����234
		System.out.println(nmSub);// {123=Name:Jim, 234=Name:Bob}
		nmSub = nm.tailMap("234", true);// ���ر�234��ģ�true��ʾ����234
		System.out.println(nmSub);// {234=Name:Bob, 345=Name:Gin}
		System.out.println("=========SortedSet================");

		/************ SortedSet�ӿ� *******************************************/
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

		// ���µ��ص��ǣ�����from��������to
		SortedSet<Employee> ssSub = ss.subSet(gin, jim);// ���ر�gin�󣬱�jimС�ģ�������jim
		System.out.println(ssSub);// [Name:Gin]
		ssSub = ss.headSet(gin);// ���ر�ginС�ģ�������gin
		System.out.println(ssSub);// [Name:Bob]
		ssSub = ss.tailSet(gin);// ���ر�gin��ģ�����gin
		System.out.println(ssSub);// [Name:Gin, Name:Jim]

		/************ NavigableSet�ӿ� *******************************************/
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

		// ���µ��ص��ǣ�����inclusive���������Ƿ����from��to
		NavigableSet<Employee> nsSub = ns.subSet(gin, true, jim, true);// ���ر�gin�󣬱�jimС�ģ�true��ʾ����gin��jim
		System.out.println(nsSub);// [Name:Gin, Name:Jim]
		nsSub = ns.headSet(gin, true);// ���ر�ginС�ģ�true��ʾ����gin
		System.out.println(nsSub);// [Name:Bob, Name:Gin]
		nsSub = ns.tailSet(gin, true);// ���ر�gin��ģ�����gin
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

	private String name = "";// ʵ�����ʼ��
}