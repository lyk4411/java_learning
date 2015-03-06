package examples100;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class test10 {

	public test10() {
		// TODO Auto-generated constructor stub
		long[] var = new long[10];
		long count = 0;
		Set<String> set = new HashSet<String>();
		String a = "00000000";
		for (int i = 0; i <= 255; i++) {
			a = Long.toBinaryString(count);
			if (a.length() < 8) {
				switch (a.length()) {
				case 1:
					a = "0000000" + a;
					break;
				case 2:
					a = "000000" + a;
					break;
				case 3:
					a = "00000" + a;
					break;
				case 4:
					a = "0000" + a;
					break;
				case 5:
					a = "000" + a;
					break;
				case 6:
					a = "00" + a;
					break;
				case 7:
					a = "0" + a;
					break;
				}

			}
			count++;

			int a1 = Integer.valueOf(a.substring(7, 8)).intValue();
			int a2 = Integer.valueOf(a.substring(6, 7)).intValue();
			int a3 = Integer.valueOf(a.substring(5, 6)).intValue();
			int a4 = Integer.valueOf(a.substring(4, 5)).intValue();
			int a5 = Integer.valueOf(a.substring(3, 4)).intValue();
			int a6 = Integer.valueOf(a.substring(2, 3)).intValue();
			int a7 = Integer.valueOf(a.substring(1, 2)).intValue();
			int a8 = Integer.valueOf(a.substring(0, 1)).intValue();
			if ((a1 + a2 + a3 + a4 + a5 + a6 + a7 + a8) == 4) {
				System.out.println(a);
				set.add(a);
			}
		}
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String str = it.next();
			System.out.println("str:" + str);
		}
		System.out.println("set size:" + set.size());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test10 aa = new test10();
	}

}
