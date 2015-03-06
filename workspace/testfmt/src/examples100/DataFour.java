package examples100;

import java.io.File;
import java.io.IOException;
//import java.util.Iterator;  
//import java.util.LinkedHashMap;  
import org.apache.commons.io.FileUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class DataFour {
	public static void main(String[] args) throws IOException {
		DataFour d = new DataFour();
		String json = FileUtils.readFileToString(new File("d:/json4.txt"));
		JSONObject jsono = JSONObject.parseObject(json);
		JSONObject b = jsono.getJSONObject("aggregations"); // "预处理",得到"aggregation"下的所有字段
		// d.buildResult(b); //------原始样例函数buildResult(b)-------//
		d.Function(b, 0); // ------(新建)逐层解析函数Function(b)-----//
	}

	public void Function(JSONObject b, int level) {
		String levelstr = level + "";
		for (int i = 0; i < level; i++) {
			levelstr += "\t";
		}
		for (String key : b.keySet()) {
			if (key.startsWith("bb_")) {
				JSONObject buckets = b.getJSONObject(key);
				JSONArray bArray = buckets.getJSONArray("buckets");
				for (int i = 0; i < bArray.size(); i++) {
					JSONObject o = bArray.getJSONObject(i);
					System.out.println("level" + level + "key:" + o.get("key")); // key:UZ6958037483314
					System.out.println("level" + level + "doc_count:"
							+ o.get("doc_count")); // doc_count:361

					JSONObject vcod_buckets = o.getJSONObject("bb_versionCode");
					JSONArray vcod_Array = vcod_buckets.getJSONArray("buckets");
					System.out.println("level" + level + "bb_versionCode:");
					for (int j = 0; j < vcod_Array.size(); j++) {
						JSONObject o1 = vcod_Array.getJSONObject(j);
						System.out.println("level" + (level + 1) + "\t"
								+ "key:" + o1.get("key"));
						System.out.println("level" + (level + 1) + "\t"
								+ "doc_count:" + o1.get("doc_count"));

						JSONObject isNewVersion_buckets = o1
								.getJSONObject("bb_isNewVersion");
						JSONArray isNewVersion_Array = isNewVersion_buckets
								.getJSONArray("buckets");
						System.out.println("level" + (level + 1) + "\t"
								+ "bb_isNewVersion:");
						for (int k = 0; k < isNewVersion_Array.size(); k++) {
							JSONObject o2 = isNewVersion_Array.getJSONObject(k);
							System.out.println("level" + (level + 2) + "\t"
									+ "\t" + "key:" + o2.get("key"));
							System.out
									.println("level" + (level + 2) + "\t"
											+ "\t" + "doc_count:"
											+ o2.get("doc_count"));
						}

						JSONObject isNew_buckets = o1.getJSONObject("bb_isNew");
						JSONArray isNew_Array = isNew_buckets
								.getJSONArray("buckets");
						System.out.println("level" + (level + 1) + "\t"
								+ "bb_isNew:");
						for (int k = 0; k < isNew_Array.size(); k++) {
							JSONObject o2 = isNew_Array.getJSONObject(k);
							System.out.println("level" + (level + 2) + "\t"
									+ "\t" + "key:" + o2.get("key"));
							System.out
									.println("level" + (level + 2) + "\t"
											+ "\t" + "doc_count:"
											+ o2.get("doc_count"));
						}

						System.out.println("level"
								+ (level + 1)
								+ "\t"
								+ "ss_usercount/value:"
								+ o1.getJSONObject("ss_usercount").getString(
										"value"));
					}
				}
			}
		}
	}
}