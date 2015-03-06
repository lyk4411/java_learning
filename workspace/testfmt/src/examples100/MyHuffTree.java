package examples100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

import examples100.HuffTree.Node;
import examples100.HuffTree.Tree;

public class MyHuffTree {

	public MyHuffTree() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[]) {

	}

	public static String decode(String binaryStr,
			Map<Character, Integer> statistics) {
		if (binaryStr == null || binaryStr.equals("")) {
			return "";
		}
		
		char[] charArray = binaryStr.toCharArray(); 
		LinkedList<Character> bufferlist = new LinkedList<Character>();
		for(char c: charArray){
			bufferlist.addLast(new Character(c));
		}
		
		return binaryStr;

	}

	public Map<Character, Integer> statistics(char[] charArrays) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : charArrays) {
			Character character = new Character(c);
			if (map.containsKey(character)) {
				map.put(character, map.get(character) + 1);
			} else {
				map.put(character, 1);
			}
		}
		return map;
	}

	public String encode(String originalStr, Map<Character, Integer> statistics) {
		if (originalStr == null || originalStr == "") {
			return "";
		}
		char[] charArray = originalStr.toCharArray();
		Map<Character, String> codeinfo = new HashMap<Character, String>();
		List<MyNode> mynodes = new ArrayList<MyNode>();

		buildTree(statistics, mynodes);
		codeinfo = buildEncodingInfo(mynodes);

		StringBuffer strbuff = new StringBuffer();
		for (char c : charArray) {
			Character buffer = new Character(c);
			strbuff.append(codeinfo.get(buffer));
			System.out.println(strbuff);
		}

		return strbuff.toString();

	}

	private Map<Character, String> buildEncodingInfo(List<MyNode> leafNodes) {
		Map<Character, String> map = new HashMap<Character, String>();

		for (MyNode nodes : leafNodes) {
			Character charcter = nodes.getChars().charAt(0);
			MyNode currmynode = nodes;
			String codeword = "";

			do {
				if (currmynode.isLeftChild()) {
					codeword = "0" + codeword;
				} else {
					codeword = "1" + codeword;
				}
				currmynode = currmynode.parent;
			} while (currmynode.parent != null);
			map.put(charcter, codeword);
		}

		return map;
	}

	private MyTree buildTree(Map<Character, Integer> statistics,
			List<MyNode> leafs) {
		Character[] keys = statistics.keySet().toArray(new Character[0]);

		PriorityQueue<MyNode> priorityqueue = new PriorityQueue<MyNode>();
		for (Character c : keys) {
			MyNode mynode = new MyNode();
			mynode.chars = c.toString();
			mynode.frequence = statistics.get(c);

			leafs.add(mynode);
			priorityqueue.add(mynode);
		}

		int size = priorityqueue.size();

		for (int i = 0; i <= size - 1; i++) {
			MyNode mynode1 = priorityqueue.poll();
			MyNode mynode2 = priorityqueue.poll();

			MyNode sumnode = new MyNode();
			sumnode.frequence = mynode1.frequence + mynode2.frequence;
			sumnode.chars = mynode1.chars + mynode1.chars;

			sumnode.leftNode = mynode1;
			sumnode.rightNode = mynode2;

			mynode1.parent = sumnode;
			mynode2.parent = sumnode;

			priorityqueue.add(sumnode);
		}

		MyTree mytree = new MyTree();
		mytree.root = priorityqueue.poll();
		return mytree;

	}

	static class MyNode implements Comparable<MyNode> {
		private String chars = "";
		private int frequence = 0;
		private MyNode parent;
		private MyNode leftNode;
		private MyNode rightNode;

		@Override
		public int compareTo(MyNode otherMyNode) {
			// TODO Auto-generated method stub
			return this.frequence - otherMyNode.frequence;
		}

		public String getChars() {
			return chars;
		}

		public void setChars(String chars) {
			this.chars = chars;
		}

		public int getFrequence() {
			return frequence;
		}

		public void setFrequence(int frequence) {
			this.frequence = frequence;
		}

		public MyNode getParent() {
			return parent;
		}

		public void setParent(MyNode parent) {
			this.parent = parent;
		}

		public MyNode getLeftNode() {
			return leftNode;
		}

		public void setLeftNode(MyNode leftNode) {
			this.leftNode = leftNode;
		}

		public MyNode getRightNode() {
			return rightNode;
		}

		public void setRightNode(MyNode rightNode) {
			this.rightNode = rightNode;
		}

		public boolean isLeaf() {
			return chars.length() == 1;
		}

		public boolean isRoot() {
			return parent == null;
		}

		public boolean isLeftChild() {
			return parent != null && this == parent.leftNode;
		}

	}

	static class MyTree {
		private MyNode root;

		public MyNode getRoot() {
			return root;
		}

		public void MyNode(MyNode root) {
			this.root = root;
		}
	}
}
