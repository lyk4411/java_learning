package examples100;

import java.util.TreeSet;

public class Explorer1 {
	public static void main(String[] args) {
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		TreeSet<Integer> subSet = new TreeSet<Integer>();
		for (int i = 10; i <= 20; i++)
			treeSet.add(i);
		subSet = (TreeSet<Integer>) treeSet.subSet(13, true, 16, true);
		System.out.println(subSet);// [13, 14, 15, 16]
		subSet.remove(15);
		System.out.println(subSet);// [13, 14, 16]
		System.out.println(treeSet);// [10, 11, 12, 13, 14, 16, 17, 18, 19, 20]
		treeSet.add(15);
		System.out.println(subSet);// [13, 14, 15, 16]
		System.out.println(treeSet);// [10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
									// 20]
	}
}