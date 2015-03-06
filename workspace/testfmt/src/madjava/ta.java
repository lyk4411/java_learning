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
		m1.put("NAME", "北京");
		m1.put("STATE", "1");
		Map<String, Object> m2 = new HashMap<String, Object>();
		m2.put("NAME", "上海");
		m2.put("STATE", "1");
		Map<String, Object> m3 = new HashMap<String, Object>();
		m3.put("NAME", "广州");
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
			// 如果STATE值为2的删除
			if ("2".equals(m.get("STATE"))) {
				ite.remove();
			}
		}

		/**
		 * 查看输出 结果为： 北京--1 上海--1
		 */
		for (Map<String, Object> map : list) {
			System.out.println(map.get("NAME") + "--" + map.get("STATE"));
		}
		System.out.println("--------------------");
		/**
		 * 在上面为Map赋值的时候如果写成m1.put("STATE", 1)，数字没有引号 则无法实现删除效果 如下例子
		 */
		Integer k = 10;
		String m = "10";
		System.out.println("10".equals(k)); // false
		System.out.println("10".equals(m)); // true
	}

}