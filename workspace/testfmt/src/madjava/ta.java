package madjava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ta {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> m1 = new HashMap<String, Object>();
		m1.put("NAME", "����");
		m1.put("STATE", "1");
		Map<String, Object> m2 = new HashMap<String, Object>();
		m2.put("NAME", "�Ϻ�");
		m2.put("STATE", "1");
		Map<String, Object> m3 = new HashMap<String, Object>();
		m3.put("NAME", "����");
		m3.put("STATE", "2");

		list.add(m1);
		list.add(m2);
		list.add(m3);

		for (Map<String, Object> map : list) {
			System.out.println(map.get("NAME") + "--" + map.get("STATE"));
		}
		System.out.println("--------------------");

		Iterator<Map<String, Object>> ite = list.iterator();
		while (ite.hasNext()) {
			Map<String, Object> m = ite.next();
			// ���STATEֵΪ2��ɾ��
			if ("2".equals(m.get("STATE"))) {
				ite.remove();
			}
		}

		/**
		 * �鿴��� ���Ϊ�� ����--1 �Ϻ�--1
		 */
		for (Map<String, Object> map : list) {
			System.out.println(map.get("NAME") + "--" + map.get("STATE"));
		}
		System.out.println("--------------------");
		/**
		 * ������ΪMap��ֵ��ʱ�����д��m1.put("STATE", 1)������û������ ���޷�ʵ��ɾ��Ч�� ��������
		 */
		Integer k = 10;
		String m = "10";
		System.out.println("10".equals(k)); // false
		System.out.println("10".equals(m)); // true
	}

}