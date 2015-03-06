package madjava;

public class Monkey {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			if (i == 0)
				sum = 5 * 1 + 1;// 定义第五个猴子最后拿走了一个，
			else
				sum = sum * 5 + 1;
		}
		System.out.println("共有桃子：" + sum);
	}
}