package madjava;

public class Mnokey {
	public static void main(String[] args) {
		int number = 1;
		for (int i = 0; i < 9; i++) {
			number = (number + 1) * 2;
		}
		System.out.println("第一天共摘了" + number + "个桃子");
	}
}