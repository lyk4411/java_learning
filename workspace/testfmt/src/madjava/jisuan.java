package madjava;

public class jisuan {
	public static void main(String[] args) {
		double mu = 1.0, zi = 2.0, tmp;
		double sum = 0;
		for (int i = 1; i <= 20; i++) {
			sum += zi / mu;
			tmp = zi + mu;
			mu = zi;
			zi = tmp;
		}
		System.out.println("½á¹ûÊÇ£º" + sum);
	}
}