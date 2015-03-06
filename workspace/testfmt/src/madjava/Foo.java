package madjava;

import java.util.Arrays;

public class Foo {
	private int x = 100;

	public synchronized int getX() {
		//System.out.println(Thread.currentThread().getName()
			//	+ " :当前foo对象的x值= " + x);
		return x;
	}

	public synchronized int fix(int y) {
		x = x - y;
		return x;
	}
}