package examples100;

/**
 * Title: ��ʶ�� Description: ��ʾ��ʶ������ķ��ʿ��� Filename:
 */
public class classDemo1 {
	// ���з���
	public void mechod1() {
		System.out.println("����һ�����еķ������κ��඼���Է��ʡ�");
	}

	// �ڱ����ķ���
	protected void mechod2() {
		System.out.println("����һ���ܵ������ķ�����ֻ��������Է��ʡ�");
	}

	// ˽�еķ���
	private void mechod3() {
		System.out.println("����һ��˽�еķ�����ֻ���౾��ſ��Է��ʡ�");
	}

	public static void main(String[] args) {
		classDemo1 d = new classDemo1();
		d.mechod1();
		d.mechod2();
		d.mechod3();
	}
}