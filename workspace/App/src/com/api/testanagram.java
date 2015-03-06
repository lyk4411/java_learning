package com.api;

import java.util.Hashtable;

public class testanagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(anagram("adfa", "afda"));
		System.out.println(anagram("adfa", "afds"));
		System.out.println(anagram("2341", "1234"));

		char[] test_char = { ' ', 'c', ' ', ' ', ' ', 'c', 'a', 'b', 'c', 'z' };
		// System.out.println(test_char);
		ReplaceFun(test_char, 2);
		// System.out.println(test_char);

		// Dint[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] matrix = { { 1, 2 }, { 3, 4 } };
		System.out.println(String.valueOf(matrix[0][0]) + matrix[0][1]
				+ matrix[1][0] + matrix[1][1]);
		rotate(matrix, 2);
		System.out.println(String.valueOf(matrix[0][0]) + matrix[0][1]
				+ matrix[1][0] + matrix[1][1]);
		rotate(matrix, 2);
		System.out.println(String.valueOf(matrix[0][0]) + matrix[0][1]
				+ matrix[1][0] + matrix[1][1]);

		int[][] matrix2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(String.valueOf(matrix2[0][0]) + matrix2[0][1]
				+ matrix2[1][0] + matrix2[1][1]);
		rotate(matrix2, 3);
		System.out.println(String.valueOf(matrix2[0][0]) + matrix2[0][1]
				+ matrix2[1][0] + matrix2[1][1]);

		int[][] matrix3 = { { 1, 2, 0 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(String.valueOf(matrix3[0][0]) + matrix3[0][1]
				+ matrix3[0][2] + matrix3[1][0] + matrix3[1][1] + matrix3[1][2]
				+ matrix3[2][0] + matrix3[2][1] + matrix3[2][2]);
		setZeros(matrix3);
		System.out.println(String.valueOf(matrix3[0][0]) + matrix3[0][1]
				+ matrix3[0][2] + matrix3[1][0] + matrix3[1][1] + matrix3[1][2]
				+ matrix3[2][0] + matrix3[2][1] + matrix3[2][2]);

		System.out.println(isRotation("apple", "pplea"));
		System.out.println(isRotation("apple", "ppla"));
		System.out.println(isRotation("apple", "pleap"));
		// LinkedListNode end = new LinkedListNode("aaa",null,null);
	}

	class Node {
		Node next = null;
		int data;

		public Node(int d) {
			data = d;
		}

		void appendToTail(int d) {
			Node end = new Node(d);
			Node n = this;
			while (n.next != null) {
				n = n.next;
			}
			n.next = end;
		}
	}

	Node deleteNode(Node head, int d) {
		Node n = head;
		if (n.data == d) {
			return head.next; /* moved head */
		}
		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				return head; /* head didn¡¯t change */
			}
			n = n.next;
		}
		return head;
	}

	public static void deleteDups(LinkedListNode n) {
		Hashtable table = new Hashtable();
		LinkedListNode previous = null;
		while (n != null) {
			if (table.containsKey(n.object))
				previous.next = n.next;
			else {
				table.put(n.object, true);
				previous = n;
			}
			n = n.next;
		}
	}

	public static void deleteDups2(LinkedListNode head) {
		if (head == null)
			return;
		LinkedListNode previous = head;
		LinkedListNode current = previous.next;
		while (current != null) {
			LinkedListNode runner = head;
			while (runner != current) { // Check for earlier dups
				if (runner.object == current.object) {
					LinkedListNode tmp = current.next; // remove current
					previous.next = tmp;
					current = tmp; // update current to next node
					break; // all other dups have already been removed
				}
				runner = runner.next;
			}
			if (runner == current) { // current not updated - update now
				previous = current;
				current = current.next;
			}
		}
	}

	LinkedListNode nthToLast(LinkedListNode head, int n) {
		if (head == null || n < 1) {
			return null;
		}
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		for (int j = 0; j < n - 1; ++j) { // skip n-1 steps ahead
			if (p2 == null) {
				return null; // not found since list size < n
			}
			p2 = p2.next;
		}
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}

	public static boolean deleteNode(LinkedListNode n) {
		if (n == null || n.next == null) {
			return false; // Failure
		}
		LinkedListNode next = n.next;
		n.object = next.object;
		n.next = next.next;
		return true;
	}

	

	private class LinkedListNode {

		public LinkedListNode previous;
		public LinkedListNode next;
		public Object object;

		/**
		 * This class is further customized for the CoolServlets cache system.
		 * It maintains a timestamp of when a Cacheable object was first added
		 * to cache. Timestamps are stored as long values and represent the
		 * number of milleseconds passed since January 1, 1970 00:00:00.000 GMT.
		 * <p>
		 * <p/>
		 * The creation timestamp is used in the case that the cache has a
		 * maximum lifetime set. In that case, when [current time] - [creation
		 * time] > [max lifetime], the object will be deleted from cache.
		 */
		public long timestamp;

		/**
		 * Constructs a new linked list node.
		 * 
		 * @param object
		 *            the Object that the node represents.
		 * @param next
		 *            a reference to the next LinkedListNode in the list.
		 * @param previous
		 *            a reference to the previous LinkedListNode in the list.
		 */
		public LinkedListNode(String object, LinkedListNode next,
				LinkedListNode previous) {
			this.object = object;
			this.next = next;
			this.previous = previous;
		}

		/**
		 * Removes this node from the linked list that it is a part of.
		 */
		public void remove() {
			previous.next = next;
			next.previous = previous;
		}

		public void add(LinkedListNode newcreated) {
			if (object == null) {
				object = newcreated.object;
				next = null;
				previous = null;
			} else {
				this.next = newcreated;
				newcreated.previous = this;
			}
		}

		/**
		 * Returns a String representation of the linked list node by calling
		 * the toString method of the node's object.
		 * 
		 * @return a String representation of the LinkedListNode.
		 */
		public String toString() {
			return object == null ? "null" : object.toString();
		}
	}

	public static boolean anagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] letters = new int[256];
		int num_unique_chars = 0;
		int num_completed_t = 0;
		char[] s_array = s.toCharArray();
		for (char c : s_array) { // count number of each char in s.
			if (letters[c] == 0)
				++num_unique_chars;
			++letters[c];
		}
		for (int i = 0; i < t.length(); ++i) {
			int c = (int) t.charAt(i);
			if (letters[c] == 0) { // Found more of char c in t than in s.
				return false;
			}
			--letters[c];
			if (letters[c] == 0) {
				++num_completed_t;
				if (num_completed_t == num_unique_chars) {
					// it¡¯s a match if t has been processed completely
					return i == t.length() - 1;
				}
			}
		}
		return false;
	}

	public static void ReplaceFun(char[] str, int length) {
		int spaceCount = 0, newLength, i = 0;
		for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		newLength = length + spaceCount * 2;
		str[newLength] = '\0';
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				str[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
	}

	public static void rotate(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;

			for (int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i]; // save top
				// left -> top
				matrix[first][i] = matrix[last - offset][first];

				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];

				// top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}
	}

	public static void setZeros(int[][] matrix) {
		int[] row = new int[matrix.length];
		int[] column = new int[matrix[0].length];
		// Store the row and column index with value 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = 1;
					column[j] = 1;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if ((row[i] == 1 || column[j] == 1)) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	public static boolean isRotation(String s1, String s2) {
		int len = s1.length();
		/* check that s1 and s2 are equal length and not empty */
		if (len == s2.length() && len > 0) {
			/* concatenate s1 and s1 within new buffer */
			String s1s1 = s1 + s1;
			return s1s1.contains(s2);
		}
		return false;
	}
}
