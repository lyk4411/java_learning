package examples100;

/**
 * Title: �̳�Thread��ʵ���߳� Description: ͨ���̳�Thread�࣬ʵ����run������ʵ���Լ����߳� : Filename:
 * oneThread.java
 * 
 * 
 */
public class oneThread extends Thread {
	/**
	 * ����˵����������������û��ʹ�� ��������� �������ͣ�
	 */
	public oneThread() {

	}

	/**
	 * ����˵�����̳�Thread�����ʵ�ֵķ�����������start����ʱ���б����� ��������� �������ͣ�
	 */
	public void run() {
		System.out.println("...............oneThread begining................");
		int flag = 0;
		while (true) {
			if (flag == 20) {
				System.out
						.println("\n...............oneThread end............. ");
				break;
			}
			for (int i = 0; i < flag; i++)
				System.out.print("*");
			System.out.println("");
			flag++;
			// try {
			// ˯/��0.1��
			// sleep(100);
			// } catch (Exception e) {
			// }
		}
	}

	/**
	 * ����˵�������������������߳� ��������� �������ͣ�
	 */
	public static void main(String args[]) {
		new oneThread().start();
	}
}