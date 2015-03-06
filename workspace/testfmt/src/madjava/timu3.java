package madjava;

public class timu3 {
	public static void main(String[] args) {
		int i, j = 0, k;
		int bai, shi, ge;
		for (i = 100; i < 1000; i++) {
			bai = i / 100;// 求百位数
			shi = (i / 10) % 10;// 求十位数
			ge = (i % 100) % 10;// 求个位数
			k = bai * bai * bai + shi * shi * shi + ge * ge * ge;
			if (i == k) {
				System.out.println(i);
				j++;
			}
		}
		System.out.println("符合条件的水仙花数为：" + j);
	}
}
