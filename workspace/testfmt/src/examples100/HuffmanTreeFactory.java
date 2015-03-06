package examples100;

import java.util.Collections;

import java.util.LinkedList;

import java.util.List;

/**
 * 
 * ������������һ����������
 * 
 * @author boss
 * 
 * 
 * 
 *         create on : ����10:51:39 2009-5-19
 */

public class HuffmanTreeFactory<T extends Combinable<T>> {

	/** ��ʼʱһ��list�б���Ҫ����ĵ�Ԫ������� */

	private List<HuffmanTree<T>> HuffmanTreeCollection;

	// public HuffmanTreeFactory(){}

	/**
	 * 
	 * @param unitClasses
	 *            ������ĵ�Ԫ�༯��
	 */

	public HuffmanTreeFactory(List<T> unitClasses) {

		if (unitClasses == null || unitClasses.size() == 0)

			throw new IllegalArgumentException(
					"the unit classes collection can't be empty");

		HuffmanTreeCollection = new LinkedList<HuffmanTree<T>>();

		// ��ʼ����������������

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
	 * ��������Ĺ��������ϴ����ֻ����һ��Ԫ�صļ��ϣ��������һ��Ԫ��
	 * 
	 * ��Ϊ�������ɵĹ�������
	 */

	private void generateHuffmanTree() {

		while (true) {

			if (HuffmanTreeCollection == null
					|| HuffmanTreeCollection.size() <= 1)

				break;

			// ����֮ǰһ��Ҫ�����������ǹ���������Ĺؼ�ԭ��

			Collections.sort(HuffmanTreeCollection);

			HuffmanTree<T> huffmanTreeOne = HuffmanTreeCollection.remove(0);

			HuffmanTree<T> huffmanTreeTwo = HuffmanTreeCollection.remove(0);

			HuffmanTree<T> huffmanTreeNew = new HuffmanTree<T>();

			// ��������ǰ������Ԫ�غϲ���һ��Ԫ�ز嵽������ȥ

			// ������һ��Ԫ�غ͵ڶ���Ԫ�طֱ���Ϊ��Ԫ�ص����ҽڵ�

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
	 * @return �������յĹ�������
	 */

	public HuffmanTree<T> getHuffmanTree() {

		generateHuffmanTree();

		return this.HuffmanTreeCollection.get(0);

	}

}