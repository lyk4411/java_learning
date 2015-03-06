package madjava;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GoogleInterview {

	// 这个index决定当前那个线程可以写文件,每往文件里写一个数字，该数字则自增1.
	private static volatile int index_A = 1;
	private static volatile int index_B = 1;
	private static volatile int index_C = 1;
	private static volatile int index_D = 1;
	private static final int NUM = 4;
	private static String[] fileNames = { "A", "B", "C", "D" };
	private static BufferedWriter[] writers = new BufferedWriter[4];

	static {
		for (int i = 0; i < NUM; i++) {
			try {
				writers[i] = new BufferedWriter(new FileWriter(new File("D:"
						+ File.separator + fileNames[i] + ".txt"), true));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	static class WriterThread1 extends Thread {
		private static final int file_a = 1;
		private static final int file_b = 0;
		private static final int file_c = 3;
		private static final int file_d = 2;
		private static final String content = "1";

		public void run() {
			while (true) {
				writeFiles(file_a, file_b, file_c, file_d, content);
			}
		}
	}

	static class WriterThread2 extends Thread {
		private static final int file_a = 2;
		private static final int file_b = 1;
		private static final int file_c = 0;
		private static final int file_d = 3;
		private static final String content = "2";

		public void run() {
			while (true) {
				writeFiles(file_a, file_b, file_c, file_d, content);
			}
		}
	}

	static class WriterThread3 extends Thread {
		private static final int file_a = 3;
		private static final int file_b = 2;
		private static final int file_c = 1;
		private static final int file_d = 0;
		private static final String content = "3";

		public void run() {
			while (true) {
				writeFiles(file_a, file_b, file_c, file_d, content);
			}
		}
	}

	static class WriterThread4 extends Thread {
		private static final int file_a = 0;
		private static final int file_b = 3;
		private static final int file_c = 2;
		private static final int file_d = 1;
		private static final String content = "4";

		public void run() {
			while (true) {
				writeFiles(file_a, file_b, file_c, file_d, content);
			}
		}
	}

	static void flush() {
		try {
			writers[0].flush();
			writers[1].flush();
			writers[2].flush();
			writers[3].flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void writeFiles(int a, int b, int c, int d, String content) {
		if (index_A % 4 == a) {
			try {
				writers[0].write(content);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			index_A++;
			flush();
		}
		if (index_B % 4 == b) {
			try {
				writers[1].write(content);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			index_B++;
			flush();
		}
		if (index_C % 4 == c) {
			try {
				writers[2].write(content);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			index_C++;
			flush();
		}
		if (index_D % 4 == d) {
			try {
				writers[3].write(content);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			index_D++;
			flush();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WriterThread1 wt1 = new WriterThread1();
		WriterThread2 wt2 = new WriterThread2();
		WriterThread3 wt3 = new WriterThread3();
		WriterThread4 wt4 = new WriterThread4();

		wt1.start();
		wt2.start();
		wt3.start();
		wt4.start();
	}

}