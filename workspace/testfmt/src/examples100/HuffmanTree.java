package examples100;

/**
 * 
 * the huffman tree Class
 * 
 * <p>
 * ����������������ǰ�ڵ�������Ϣ����ڵ㣬�ҽڵ���Ϣ��
 * 
 * @author boss
 * 
 * 
 * 
 *         create on : ����10:16:23 2009-5-19
 */

public class HuffmanTree<T extends Combinable<T>> implements
		Comparable<HuffmanTree<T>> {

	/** the root of huffman tree */

	private T root;

	/** the left node of huffman tree */

	private HuffmanTree<T> left;

	/** the right node of huffman tree */

	private HuffmanTree<T> right;

	/** �����������ַ�������:0000110 */

	private String huffmanCodeString = "";

	/** �Ƿ���������ɵĹ��������й�������� */

	private static boolean isSettedHuffmanCoderString = false;

	public T getRoot() {

		return root;

	}

	public void setRoot(T root) {

		this.root = root;

	}

	public HuffmanTree<T> getLeft() {

		return left;

	}

	public void setLeft(HuffmanTree<T> left) {

		this.left = left;

	}

	public HuffmanTree<T> getRight() {

		return right;

	}

	public void setRight(HuffmanTree<T> right) {

		this.right = right;

	}

	/**
	 * 
	 * ��д�˷������ڵݹ�ϲ��ڵ������������
	 */

	@Override
	public int compareTo(HuffmanTree<T> o) {

		// TODO Auto-generated method stub

		return o.getRoot().compareTo(this.getRoot());

	}

	@Override
	public String toString() {

		return "the root:" + this.getRoot()

		+ "\r\nthe left:" + this.getLeft()

		+ "\r\nthe right:" + this.getRight();

	}

	/**
	 * 
	 * ���������ɵ������й��������룬ʹÿ��Ҷ�ӽڵ�����01��·������
	 */

	private void setHuffmanCoderString() {

		HuffmanTree<T> left = this.getLeft();

		// �������ڵ�����·����׷��"0"

		if (left != null) {

			left.huffmanCodeString = this.huffmanCodeString + "0";

			left.setHuffmanCoderString();// �ݹ����

		}

		HuffmanTree<T> right = this.getRight();

		// ������ҽڵ�����·����׷��"1"

		if (right != null) {

			right.huffmanCodeString = this.huffmanCodeString + "1";

			right.setHuffmanCoderString();// �ݹ����

		}

	}

	public void printHuffmanCoderString() {

		// ��ӡ�����������Ĺ���������ǰҪ���б��������

		// �Ҵ˲���ִֻ��һ�Σ�������ȫ�ֱ�ʶ�����ж�

		if (!HuffmanTree.isSettedHuffmanCoderString) {

			this.setHuffmanCoderString();

			HuffmanTree.isSettedHuffmanCoderString = true;// ��ʶ��ִ�й�����

		}

		// �����Ҷ�ӽڵ㣨��Ҫ����ĵ�Ԫ�������ӡ��������Ϣ������Ƿ�Ҷ�ӽ�㣨�м���ʱ���ɵĽڵ㣩���򲻴�ӡ

		if (this.left == null && this.right == null)

			System.out.println("the " + this.getRoot() + " huffmanCoder:"
					+ this.huffmanCodeString);

		if (this.left != null)

			this.left.printHuffmanCoderString();// �ݹ��ӡ

		if (this.right != null)

			this.right.printHuffmanCoderString();// �ݹ��ӡ

	}

}