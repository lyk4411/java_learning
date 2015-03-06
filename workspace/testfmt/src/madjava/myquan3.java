package madjava;

import java.util.Arrays;
import java.util.Scanner;

public class myquan3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("please input the number of persons:");
		int person_number = input.nextInt();

		boolean persons[] = new boolean[person_number];
		for (int i = 0; i < person_number; i++) {
			persons[i] = true;
		}

		int temp = 0;
		int length = persons.length;

		while (length > 1) {
			for (int i = 0; i < persons.length; i++) {
				if (persons[i]) {
					temp++;
					if (temp % 3 == 0) {
						persons[i] = false;
						temp = 0;
						length--;
					}
				}
			}
		}

		System.out.println(Arrays.toString(persons));
		for (int i = 0; i < persons.length; i++) {
			System.out.println(persons[i]);
		}
		for (int i = 0; i < persons.length; i++) {
			if (persons[i]) {
				System.out.println(i + 1);
				System.out.println((i + 1) % 3);
			}
		}
	}
}
