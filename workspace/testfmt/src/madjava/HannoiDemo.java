package madjava;

public class HannoiDemo {
	private static void show(int n, String strFrom, String strTo) {
		System.out.println("把" + n + "号盘子从：" + strFrom + " 移动到：" + strTo);
	}

	private static void move(int n, String strFrom, String strTemp, String strTo) {
		if (n == 1) {
			show(1, strFrom, strTo);
		} else {
			move(n - 1, strFrom, strTo, strTemp);
			show(n, strFrom, strTo);
			move(n - 1, strTemp, strFrom, strTo);
		}
	}

	public static void main(String[] args) {
		move(3, "A", "B", "C");
	}
}