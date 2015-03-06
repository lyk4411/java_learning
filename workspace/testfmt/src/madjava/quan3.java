package madjava;

import java.util.Arrays;
import java.util.Scanner;

public class quan3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("please input the number of people:");

		int person = input.nextInt();

		boolean persons[] = new boolean[person];

		for (int i = 0; i < person; i++) {
			persons[i] = true;
		}

		int t = 0;
		int length = persons.length;
		while (length > 1) {
			for (int i = 0; i < persons.length; i++) {
				if (persons[i]) {
					t++;
					if (t % 3 == 0) {
						persons[i] = false;
						t = 0;
						length--;
					}
				}
			}
		}

		System.out.println(persons.toString());
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
