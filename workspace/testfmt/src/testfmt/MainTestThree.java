package testfmt;

import java.util.BitSet;

public class MainTestThree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BitSet bm = new BitSet();
		System.out.println(bm.isEmpty() + "--" + bm.size() + "--" + bm.toString());
		bm.set(0);
		System.out.println(bm.isEmpty() + "--" + bm.size() + "--" + bm.toString());
		bm.set(1);
		System.out.println(bm.isEmpty() + "--" + bm.size() + "--" + bm.toString());
		System.out.println(bm.get(65) + "--" + bm.toString());
		System.out.println(bm.isEmpty() + "--" + bm.size() + "--" + bm.toString());
		bm.set(65);
		System.out.println(bm.isEmpty() + "--" + bm.size() + "--" + bm.toString());
	}

}