package examples100;

/**
 * Title: �ӿںͳ����� Description: ��ʾ�̳г�������ʵ�ֽӿ� Filename: newPlay.java
 */

// �ӿ�
interface player {
	int flag = 1;

	void play();// ����

	void pause();// ��ͣ

	void stop();// ֹͣ
}// end :)

// ������
abstract class playing {
	public void display(Object oPara) {
		System.out.println(oPara);
	}

	abstract void winRun();
}// end :)

// �̳���playing�������ʵ����player�ӿ�
public class newPlay extends playing implements player {
	public void play() {
		display("newPlay.play()");// ����ֻ����ʾ��ȥ���˴��롣
	}

	public void pause() {
		display("newPlay.pause()");// ����ֻ����ʾ��ȥ���˴��롣
	}

	public void stop() {
		display("newPlay.stop()");// ����ֻ����ʾ��ȥ���˴��롣
	}

	void winRun() {
		display("newPlay.winRun()");// ����ֻ����ʾ��ȥ���˴��롣
	}

	public static void main(String[] args) {
		newPlay p = new newPlay();
		p.play();
		p.pause();
		p.stop();
		p.winRun();
	}
}