package examples100;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class FastJson {
	public static void main(String[] args) {
		String strJson = "{\"sqls\":[{\"sql\":\"INSERT INTO T_BASE_PERSON (PERSON_ID,PERSON_NAME) VALUES (?,?)\",\"values\":\"0dc11abb-967d-11e3-afc0-000c29c3253b,����\"},{\"sql\":\"UPDATE T_BASE_CLASS SET CLASS_NAME=? WHERE CLASS_ID=?\",\"values\":\"һ��һ��,538b7ee7-967d-11e3-afc0-000c29c3253b\"}]}";

		JSONObject myObj = JSONObject.parseObject(strJson);
		JSONArray myArray = myObj.getJSONArray("sqls"); // ���Ǹ��ڵ�"sql"ð�ź�Ķ���[{"sql":"INSERT INTO...",
														// "values":"0dc11abb"}]
		System.out.println("myArray:" + myArray);
		for (int i = 0; i < myArray.size(); i++) {
			JSONObject o = myArray.getJSONObject(i);
			System.out.println("11111:" + o); // o���ǵ�һ��������{}����������ж���(����"sql","value"��������ֵ)
			System.out.println("22222:" + o.get("sql")); // o.get("sql")���ǵõ�sqlð�ź�Ķ���"INSERT INTO..."
			System.out.println("33333:" + o.get("values")); // o.get("value")���ǵõ�valueð�ź�Ķ���"0dc11abb..."
		}

		String strJson1 = "[{\"sql\":\"INSERT INTO T_BASE_PERSON (PERSON_ID,PERSON_NAME) VALUES (?,?)\",\"values\":\"0dc11abb-967d-11e3-afc0-000c29c3253b,����\"},{\"sql\":\"UPDATE T_BASE_CLASS SET CLASS_NAME=? WHERE CLASS_ID=?\",\"values\":\"һ��һ��,538b7ee7-967d-11e3-afc0-000c29c3253b\"}]";

		JSONArray myArray1 = JSONArray.parseArray(strJson1);
		System.out.println("myArray1:" + myArray1);
		for (int j = 0; j < myArray1.size(); j++) {
			JSONObject o1 = myArray1.getJSONObject(j);
			System.out.println("44444:" + o1.get("sql"));
			System.out.println("55555:" + o1.get("values"));
		}
	}

}