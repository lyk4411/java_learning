package examples100;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class testPQ {
	private String name;
	private int population;

	public testPQ(String name, int population) {
		this.name = name;
		this.population = population;
	}

	public String getName() {
		return this.name;
	}

	public int getPopulation() {
		return this.population;
	}

	public String toString() {
		return getName() + " - " + getPopulation();
	}

	public static void main(String args[]) {
		Comparator<testPQ> OrderIsdn = new Comparator<testPQ>() {
			public int compare(testPQ o1, testPQ o2) {
				// TODO Auto-generated method stub
				int numbera = o1.getPopulation();
				int numberb = o2.getPopulation();
				if (numberb > numbera) {
					return 1;
				} else if (numberb < numbera) {
					return -1;
				} else {
					return 0;
				}
			}
		};
		Queue<testPQ> priorityQueue = new PriorityQueue<testPQ>(11, OrderIsdn);

		testPQ t1 = new testPQ("t1", 1);
		testPQ t3 = new testPQ("t3", 3);
		testPQ t2 = new testPQ("t2", 2);
		testPQ t4 = new testPQ("t4", 0);
		priorityQueue.add(t1);
		priorityQueue.add(t3);
		priorityQueue.add(t2);
		priorityQueue.add(t4);
		// System.out.println(priorityQueue.poll().toString());

		while (!priorityQueue.isEmpty()) {
			System.out.print("left:");
			System.out.println(priorityQueue.toString());

			System.out.println("poll(): " + priorityQueue.poll());
		}
	}

}