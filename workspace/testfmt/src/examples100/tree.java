package examples100;

/**
 * Title: ������ Description: ʹ�ü̳��࣬���������� Filename: osier.java
 */
class tree {
	/**
	 * <br>
	 * ����˵������������
	 */
	public void root() {
		String sSite = "������";
		String sFunction = "��������";
		print("λ�ã�" + sSite);
		print("���ܣ�" + sFunction);
	}

	/**
	 * ����˵������������
	 */
	public void bolo() {
		String sSite = "����";
		String sFunction = "��������";
		print("λ�ã�" + sSite);
		print("���ܣ�" + sFunction);
	}

	/**
	 * ����˵����������֦
	 */
	public void branch() {
		String sSite = "������";
		String sFunction = "��������";
		print("λ�ã�" + sSite);
		print("���ܣ�" + sFunction);
	}

	/**
	 * ����˵��������Ҷ��
	 */
	public void leaf() {
		String sSite = "����";
		String sFunction = "�������";
		String sColor = "��ɫ";
		print("λ�ã�" + sSite);
		print("���ܣ�" + sFunction);
		print("��ɫ��" + sColor);
	}

	/**
	 * ����˵������ʾ��Ϣ ���������Object oPara ��ʾ����Ϣ
	 */
	public void print(Object oPara) {
		System.out.println(oPara);
	}

	/**
	 * ����˵������������
	 */
	public static void main(String[] arges) {
		tree t = new tree();
		t.print("����һ������");
		t.print("������");
		t.root();
		t.print("���ɣ�");
		t.bolo();
		t.print("��֦��");
		t.branch();
		t.print("��Ҷ��");
		t.leaf();
	}
}

/**
 * Title: �������� Description: ���������Ĳ���
 */
class osier extends tree {
	/**
	 * ����˵��������������Ҷ
	 */
	public void leaf() {
		super.leaf();
		String sShape = "����";
		super.print("��״��" + sShape);
	}

	/**
	 * ����˵������չ���Ļ�
	 */
	public void flower() {
		print("����������û�л�����");
	}

	/**
	 * ����˵����������
	 */
	public static void main(String[] args) {
		osier o = new osier();
		o.print("����������");
		o.root();
		o.print("�������ɣ�");
		o.bolo();
		o.print("������֦��");
		o.branch();
		o.print("������Ҷ��");
		o.leaf();
		o.print("��������");
		o.flower();
	}
}