package testfmt;

import java.util.BitSet;

public class MianTestFour {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BitSet bm1 = new BitSet(7);
		System.out.println(bm1.isEmpty() + "--" + bm1.size() + "--" + bm1.toString());

		BitSet bm2 = new BitSet(63);
		System.out.println(bm2.isEmpty() + "--" + bm2.size() + "--" + bm2.toString());

		BitSet bm3 = new BitSet(65);
		System.out.println(bm3.isEmpty() + "--" + bm3.size() + "--" + bm3.toString());

		BitSet bm4 = new BitSet(111);
		System.out.println(bm4.isEmpty() + "--" + bm4.size() + "--" + bm4.toString());
	}

}