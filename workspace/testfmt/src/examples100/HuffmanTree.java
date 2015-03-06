package examples100;

/**
 * 
 * the huffman tree Class
 * 
 * <p>
 * 哈夫曼树，包括当前节点数据信息，左节点，右节点信息。
 * 
 * @author boss
 * 
 * 
 * 
 *         create on : 下午10:16:23 2009-5-19
 */

public class HuffmanTree<T extends Combinable<T>> implements
		Comparable<HuffmanTree<T>> {

	/** the root of huffman tree */

	private T root;

	/** the left node of huffman tree */

	private HuffmanTree<T> left;

	/** the right node of huffman tree */

	private HuffmanTree<T> right;

	/** 哈夫曼编码字符串，如:0000110 */

	private String huffmanCodeString = "";

	/** 是否对最终生成的哈夫曼进行过编码操作 */

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
	 * 重写此方法用于递归合并节点后进行排序操作
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
	 * 对最终生成的树进行哈夫曼编码，使每个叶子节点生成01的路径编码
	 */

	private void setHuffmanCoderString() {

		HuffmanTree<T> left = this.getLeft();

		// 如果有左节点则在路径中追加"0"

		if (left != null) {

			left.huffmanCodeString = this.huffmanCodeString + "0";

			left.setHuffmanCoderString();// 递归编码

		}

		HuffmanTree<T> right = this.getRight();

		// 如果有右节点则在路径中追加"1"

		if (right != null) {

			right.huffmanCodeString = this.huffmanCodeString + "1";

			right.setHuffmanCoderString();// 递归编码

		}

	}

	public void printHuffmanCoderString() {

		// 打印最终生成树的哈夫曼编码前要进行编码操作，

		// 且此操作只执行一次，所以用全局标识变量判断

		if (!HuffmanTree.isSettedHuffmanCoderString) {

			this.setHuffmanCoderString();

			HuffmanTree.isSettedHuffmanCoderString = true;// 标识已执行过编码

		}

		// 如果是叶子节点（即要编码的单元），则打印出编码信息，如果是非叶子结点（中间临时生成的节点），则不打印

		if (this.left == null && this.right == null)

			System.out.println("the " + this.getRoot() + " huffmanCoder:"
					+ this.huffmanCodeString);

		if (this.left != null)

			this.left.printHuffmanCoderString();// 递归打印

		if (this.right != null)

			this.right.printHuffmanCoderString();// 递归打印

	}

}