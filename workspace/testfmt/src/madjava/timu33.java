package madjava;

public class timu33 {
	public static void main(String[] args) {
		int[] age1 = new int[20];
		int[] age2 = new int[20];
		age1[1] = 1;
		age2[1] = 1;
		for (int i = 1; i <= 12; i++) {
			for (int j = 1; j <= i; j++)
				age2[j] = age1[j] + age1[j - 1];
			for (int j = 1; j <= i; j++) {
				System.out.print(age2[j] + " ");
			}
			System.out.println();
			for (int j = 1; j <= i; j++) {
				age1[j] = age2[j];
			}
		}
	}
}