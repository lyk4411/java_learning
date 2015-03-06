package examples100;

import java.io.*;
import java.text.ParseException;

import org.json.*;

/**
 * ��json�ļ���ȡ���ݣ��γ�JSon���󣬶�ȡ�������ݲ���ӡ
 */
public class JSonParser {

	public static void main(String[] args) {
		// ��JSon�ļ���ȡ����
		StringBuffer stringBuffer = new StringBuffer();
		String line = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(
					"d:/json.txt")));
			while ((line = br.readLine()) != null) {
				stringBuffer.append(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			// ��Json�ļ������γ�JSONObject����
			JSONObject jsonObject = new JSONObject(stringBuffer.toString());
			// ��ȡJSONObject�������ݲ���ӡ
			JSONArray provinces = jsonObject.getJSONArray("provinces");
			String name = null;
			StringBuffer jsonFileInfo = new StringBuffer();
			JSONArray citys = null;
			for (int i = 0; i < provinces.length(); i++) {
				name = provinces.getJSONObject(i).getString("name");
				jsonFileInfo.append("/nname:" + name + "/n" + "citys:");
				citys = provinces.getJSONObject(i).getJSONArray("citys");
				for (int j = 0; j < citys.length(); j++) {
					jsonFileInfo.append(citys.getString(j) + "/t");
				}
			}

			System.out.println(jsonFileInfo);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}