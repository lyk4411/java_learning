package examples100;

import java.util.Collections;

import java.util.LinkedList;

import java.util.List;

/**
 * 
 * 用类用于生成一个哈夫曼树
 * 
 * @author boss
 * 
 * 
 * 
 *         create on : 下午10:51:39 2009-5-19
 */

public class HuffmanTreeFactory<T extends Combinable<T>> {

	/** 初始时一个list列表当作要编码的单元类的容器 */

	private List<HuffmanTree<T>> HuffmanTreeCollection;

	// public HuffmanTreeFactory(){}

	/**
	 * 
	 * @param unitClasses
	 *            待编码的单元类集合
	 */

	public HuffmanTreeFactory(List<T> unitClasses) {

		if (unitClasses == null || unitClasses.size() == 0)

			throw new IllegalArgumentException(
					"the unit classes collection can't be empty");

		HuffmanTreeCollection = new LinkedList<HuffmanTree<T>>();

		// 初始化哈夫曼集合容器

		for (T unitClass : unitClasses) {

			HuffmanTree<T> huffmanTree = new HuffmanTree<T>();

			huffmanTree.setRoot(unitClass);

			huffmanTree.setLeft(null);

			huffmanTree.setLeft(null);

			HuffmanTreeCollection.add(huffmanTree);

		}

		Collections.sort(HuffmanTreeCollection);

	}

	/**
	 * 
	 * 将待编码的哈夫曼集合处理成只含有一个元素的集合，则这最后一个元素
	 * 
	 * 即为最终生成的哈夫曼树
	 */

	private void generateHuffmanTree() {

		while (true) {

			if (HuffmanTreeCollection == null
					|| HuffmanTreeCollection.size() <= 1)

				break;

			// 处理之前一定要重新排序，这是哈夫曼编码的关键原理

			Collections.sort(HuffmanTreeCollection);

			HuffmanTree<T> huffmanTreeOne = HuffmanTreeCollection.remove(0);

			HuffmanTree<T> huffmanTreeTwo = HuffmanTreeCollection.remove(0);

			HuffmanTree<T> huffmanTreeNew = new HuffmanTree<T>();

			// 将集合中前面两个元素合并成一个元素插到集合中去

			// 并将第一个元素和第二个元素分别作为新元素的左，右节点

			huffmanTreeNew.setRoot(huffmanTreeOne.getRoot().combinate(
					huffmanTreeOne.getRoot(), huffmanTreeTwo.getRoot()));

			huffmanTreeNew.setLeft(huffmanTreeOne);

			huffmanTreeNew.setRight(huffmanTreeTwo);

			HuffmanTreeCollection.add(huffmanTreeNew);

		}

	}

	/**
	 * 
	 * 
	 * 
	 * @return 生成最终的哈夫曼树
	 */

	public HuffmanTree<T> getHuffmanTree() {

		generateHuffmanTree();

		return this.HuffmanTreeCollection.get(0);

	}

}