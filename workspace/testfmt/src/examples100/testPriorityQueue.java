package examples100;

import java.util.PriorityQueue;

public class testPriorityQueue {

	public static void main(String[] args) {
		PriorityQueue<String> pq = new PriorityQueue<String>();
		pq.add("dog");
		pq.add("apple");
		pq.add("fox");
		pq.add("easy");
		pq.add("boy");

		while (!pq.isEmpty()) {
			System.out.print("left:");
			for (String s : pq) {
				System.out.print(s + " ");
			}
			System.out.println();
			System.out.println("poll(): " + pq.poll());
		}
	}

}
