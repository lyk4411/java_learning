package madjava;

public class Ball {
	public static void main(String[] args) {
		double sum;
		double high = 100.0;
		sum = high;
		for (int i = 1; i <= 10; i++) {// 第i次落地；
			high = high / 2.0;
			sum += high;// 第i次返回时的高度
			if (i == 10)
				sum -= high;// 第十次落地不返回
		}
		System.out.println("第10次落地时，共经过" + sum + "米");
		high = high / 2;
		System.out.println("第10次反弹" + high + "米");
	}
}