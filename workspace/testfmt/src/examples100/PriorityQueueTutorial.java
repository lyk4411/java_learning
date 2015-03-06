package examples100;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueTutorial {

	public static void main(String args[]) {
		PriorityQueue<Student> queue = new PriorityQueue<Student>(11,
				new Comparator<Student>() {
					public int compare(Student s1, Student s2) {
						return s1.grade - s2.grade;
					}
				});

		for (int i = 1; i <= 100; i++) {
			queue.add(new Student("s" + i, (new Random().nextInt(1000))));
		}
		while (!queue.isEmpty()) {
			System.out.println(queue.poll().toString());
		}
	}
}

class Student {
	String name;
	int grade;

	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}

	public String toString() {
		return name + " " + grade;
	}
}