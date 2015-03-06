package com.api;

public class TestStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	class Queue {
		Node first, last;

		void enqueue(int item) {
			if (first == null) {
				last = new Node(item);
				first = last;
			} else {
				last.next = new Node(item);
				last = last.next;
			}
		}

		Node dequeue(Node n) {
			if (first != null) {
				Node item = first;
				first = first.next;
				return item;
			}
			return null;
		}
	}

	class Stack {
		Node top;
		int stackSize = 300;
		int[] buffer = new int[stackSize * 3];
		int[] stackPointer = { 0, 0, 0 }; // stack pointers to track top elem


		Node pop() {
			if (top != null) {
				Object item = top.data;
				top = top.next;
				return (Node) item;
			}
			return null;
		}

		void push(int item) {
			Node t = new Node(item);
			t.next = top;
			top = t;
		}

		void push(int stackNum, int value) {
			/*
			 * Find the index of the top element in the array + 1, and increment
			 * the stack pointer
			 */
			int index = stackNum * stackSize + stackPointer[stackNum] + 1;
			stackPointer[stackNum]++;
			buffer[index] = value;
		}

		int pop(int stackNum) {
			int index = stackNum * stackSize + stackPointer[stackNum];
			stackPointer[stackNum]--;
			int value = buffer[index];
			buffer[index] = 0;
			return value;
		}

		int peek(int stackNum) {
			int index = stackNum * stackSize + stackPointer[stackNum];
			return buffer[index];
		}

		boolean isEmpty(int stackNum) {
			return stackPointer[stackNum] == stackNum * stackSize;
		}
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
}
