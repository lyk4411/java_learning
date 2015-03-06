package threads;

import java.io.IOException;
import java.util.LinkedList;

/** Producer-Consumer in Java. Version 1. */
// BEGIN main
public class ProdCons1 {
	protected LinkedList<Object> list = new LinkedList<>();

	protected void produce() {
		int len = 0;
		synchronized (list) {
			Object justProduced = new Object();
			list.addFirst(justProduced);
			len = list.size();
			list.notifyAll();
		}
		System.out.println("List size now " + len);
	}

	protected void consume() {
		Object obj = null;
		int len = 0;
		synchronized (list) {
			while (list.size() == 0) {
				try {
					list.wait();
				} catch (InterruptedException ex) {
					return;
				}
			}
			obj = list.removeLast();
			len = list.size();
		}
		System.out.println("Consuming object " + obj);
		System.out.println("List size now " + len);
	}

	public static void main(String[] args) throws IOException {
		ProdCons1 pc = new ProdCons1();
		System.out.println("Ready (p to produce, c to consume):");
		int i;
		while ((i = System.in.read()) != -1) {
			char ch = (char) i;
			switch (ch) {
			case 'p':
				pc.produce();
				break;
			case 'c':
				pc.consume();
				break;
			}
		}
	}
}
// END main