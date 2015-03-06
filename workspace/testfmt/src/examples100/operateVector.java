package examples100;

import java.util.*;

/**
 * Title: ʸ������< Description: ��ʾһ��ʸ����Vector���Ļ������� Filename: operateVector.java
 */
public class operateVector {
	/*
	 * <br>����˵��������һ��4*4�Ķ�άVector����ʹ�á�<br>���������<br>���������Vector<br>����˵����
	 */
	public Vector<Object> buildVector() {
		Vector<Object> vTemps = new Vector<Object>();
		for (int i = 0; i < 4; i++) {
			Vector<Object> vTemp = new Vector<Object>();
			for (int j = 0; j < 4; j++) {
				vTemp.addElement("Vector(" + i + ")(" + j + ")");
			}
			vTemps.addElement(vTemp);
		}
		return vTemps;
	}

	/*
	 * <br>����˵������������<br>���������Vector vTemp ����������ݶ���<br>���������int iTemp �������ݵ�λ��
	 * <br>���������Object oTemp ��������ֵ<br>���������Vector ���
	 * <br>����˵�����������λ�ó���ʵ��ʵ�ʵ�λ�ý�����null
	 */
	public Vector<Object> insert(Vector<Object> vTemp, int iTemp, Object oTemp) {
		if (iTemp > vTemp.size()) {
			print("���ݳ���!");
			return null;
		} else {
			vTemp.insertElementAt(oTemp, iTemp);
		}
		return vTemp;
	}

	/*
	 * <br>����˵�����Ƴ�����<br>���������Vector vTemp ��ɾ��ʸ������<br>���������int iTemp ɾ�����ݵ�λ��
	 * <br>���������Vector<br>����˵�������ɾ����������ݣ�������null
	 */
	public Vector<Object> delete(Vector<Object> vTemp, int iTemp) {
		if (iTemp > vTemp.size()) {
			print("���ݳ���!");
			return null;
		} else {
			vTemp.removeElementAt(iTemp);
		}
		return vTemp;
	}

	/*
	 * <br>����˵�����޸�����<br>���������Vector vTemp ���޸�ʸ������<br>���������int iTemp �޸����ݵ�λ��
	 * <br>���������Object oTemp �޸�����ֵ<br>���������Vector<br>����˵��������޸�λ�ó�������ݣ�������null
	 */
	public Vector<Object> updata(Vector<Object> vTemp, int iTemp, Object oTemp) {
		if (iTemp > vTemp.size()) {
			print("���ݳ���!");
			return null;
		} else {
			vTemp.setElementAt(oTemp, iTemp);
		}
		return vTemp;
	}

	/*
	 * <br>����˵���������Ϣ<br>���������String sTemp �����Ϣ����<br>���������Object oTemp �����Ϣֵ
	 * <br>���ر�������
	 */
	public void print(String sTemp, Vector<Object> oTemp) {
		System.out.println(sTemp + "���ݣ�");
		this.print(oTemp);
	}

	/**
	 * <br>
	 * ����˵������ӡ��������أ� <br>
	 * ���������Object oPara ����Ķ��� <br>
	 * �������ͣ���
	 */
	public void print(Object oPara) {
		System.out.println(oPara);
	}

	/**
	 * <br>
	 * ����˵������ӡ��������أ� <br>
	 * ���������Vector vPara ��ʾ���ʸ������ <br>
	 * �������ͣ���
	 */
	public void print(Vector<Object> vPara) {
		for (int i = 0; i < vPara.size(); i++) {
			System.out.println(vPara.elementAt(i));
		}
	}

	/**
	 * <br>
	 * ����˵������������������� <br>
	 * ���������String[] args <br>
	 * �������ͣ���
	 */
	public static void main(String[] args) {
		operateVector ov = new operateVector();
		Vector<Object> vTemp = ov.buildVector();
		ov.print("vTemp0", vTemp);
		System.out.println("====================================");
		Vector<Object> vResult = ov.insert(vTemp, 2, "��ӵ�����");
		ov.print("vResult", vResult);
		System.out.println("====================================");
		Vector<Object> vResultup = ov.updata(vResult, 3, "�޸ĵ�����");
		ov.print("vResultmp", vResultup);
		System.out.println("====================================");
		Vector<Object> vResultnow = ov.delete(vResultup, 4);
		ov.print("vResultnow", vResultnow);
	}
}