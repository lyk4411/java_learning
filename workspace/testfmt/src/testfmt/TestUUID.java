package testfmt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class TestUUID {

	public static void main(String[] args) {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid.length());
		System.out.println(uuid.replace("-", ""));
		System.out.println(uuid.toString());


		//int num = str2Num("10000");
		//System.out.println(num);

		String date = transferToFormat("huangbia");
		System.out.println(date);

		//String nowDate = getCurrentDateStr(SDF_YYYY_MM_DD_HH_MM_SS_SS);
		//System.out.println(nowDate);
	}

	/**
	 * �ַ���תΪ���֣���ȡǰ���0
	 * 
	 * @param str
	 * @return
	 */
	public static int str2Num(String str) {
		char[] array = str.toCharArray();
		System.out.println(array);
		System.out.println(array.length);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
			if (array[i] != '0') {
				str = str.substring(i);
				break;
			}
		}
		return Integer.parseInt(str);
	}

	/**
	 * ���ַ���ת����2010-12-21��ʽ��
	 * 
	 * @param propName
	 * @return
	 */
	public static String transferToFormat(String trDate) {
		StringBuffer busiDate = new StringBuffer();
		busiDate.append(trDate.substring(0, 4));
		busiDate.append("-");
		busiDate.append(trDate.substring(4, 6));
		busiDate.append("-");
		busiDate.append(trDate.substring(6, 8));
		return busiDate.toString();

	}

	/**
	 * SDF_YYYY_MM_DD_HH_MM_SS_SS��ʽ
	 */
	public static final SimpleDateFormat SDF_YYYY_MM_DD_HH_MM_SS_SS = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss:SS");

	/**
	 * ��ȡ��ǰ���ڵ��ַ�����ʽ
	 * 
	 * @param sdf
	 *            ��ʽ����
	 * @return
	 */
	public static String getCurrentDateStr(SimpleDateFormat sdf) {
		return sdf.format(new Date());
	}
}