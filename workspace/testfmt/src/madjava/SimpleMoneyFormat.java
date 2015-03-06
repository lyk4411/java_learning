package madjava;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Scanner;

public class SimpleMoneyFormat {
	public static final String EMPTY = "";
	public static final String ZERO = "��";
	public static final String ONE = "Ҽ";
	public static final String TWO = "��";
	public static final String THREE = "��";
	public static final String FOUR = "��";
	public static final String FIVE = "��";
	public static final String SIX = "½";
	public static final String SEVEN = "��";
	public static final String EIGHT = "��";
	public static final String NINE = "��";
	public static final String TEN = "ʰ";
	public static final String HUNDRED = "��";
	public static final String THOUSAND = "Ǫ";
	public static final String TEN_THOUSAND = "��";
	public static final String HUNDRED_MILLION = "��";
	public static final String YUAN = "Ԫ";
	public static final String JIAO = "��";
	public static final String FEN = "��";
	public static final String DOT = ".";

	private static SimpleMoneyFormat formatter = null;
	private HashMap<String, String> chineseNumberMap = new HashMap<String, String>();
	private HashMap<String, String> chineseMoneyPatternMap = new HashMap<String, String>();
	private NumberFormat numberFormat = NumberFormat.getInstance();

	private SimpleMoneyFormat() {
		numberFormat.setMaximumFractionDigits(4);
		numberFormat.setMinimumFractionDigits(2);
		numberFormat.setGroupingUsed(false);

		chineseNumberMap.put("0", ZERO);
		chineseNumberMap.put("1", ONE);
		chineseNumberMap.put("2", TWO);
		chineseNumberMap.put("3", THREE);
		chineseNumberMap.put("4", FOUR);
		chineseNumberMap.put("5", FIVE);
		chineseNumberMap.put("6", SIX);
		chineseNumberMap.put("7", SEVEN);
		chineseNumberMap.put("8", EIGHT);
		chineseNumberMap.put("9", NINE);
		chineseNumberMap.put(DOT, DOT);

		chineseMoneyPatternMap.put("1", TEN);
		chineseMoneyPatternMap.put("2", HUNDRED);
		chineseMoneyPatternMap.put("3", THOUSAND);
		chineseMoneyPatternMap.put("4", TEN_THOUSAND);
		chineseMoneyPatternMap.put("5", TEN);
		chineseMoneyPatternMap.put("6", HUNDRED);
		chineseMoneyPatternMap.put("7", THOUSAND);
		chineseMoneyPatternMap.put("8", HUNDRED_MILLION);
	}

	public static SimpleMoneyFormat getInstance() {
		if (formatter == null)
			formatter = new SimpleMoneyFormat();
		return formatter;
	}

	public String format(String moneyStr) {
		checkPrecision(moneyStr);
		String result;
		result = convertToChineseNumber(moneyStr);
		result = addUnitsToChineseMoneyString(result);
		return result;
	}

	public String format(double moneyDouble) {
		return format(numberFormat.format(moneyDouble));
	}

	public String format(int moneyInt) {
		return format(numberFormat.format(moneyInt));
	}

	public String format(long moneyLong) {
		return format(numberFormat.format(moneyLong));
	}

	public String format(Number moneyNum) {
		return format(numberFormat.format(moneyNum));
	}

	private String convertToChineseNumber(String moneyStr) {
		String result;
		StringBuffer cMoneyStringBuffer = new StringBuffer();
		for (int i = 0; i < moneyStr.length(); i++) {
			cMoneyStringBuffer.append(chineseNumberMap.get(moneyStr.substring(
					i, i + 1)));
			System.out.println(cMoneyStringBuffer);
		}
		// ʰ��Ǫ���ڵȶ��Ǻ���������еĵ�λ����������
		int indexOfDot = cMoneyStringBuffer.indexOf(DOT);
		int moneyPatternCursor = 1;
		for (int i = indexOfDot - 1; i > 0; i--) {
			cMoneyStringBuffer.insert(i,
					chineseMoneyPatternMap.get(EMPTY + moneyPatternCursor));
			moneyPatternCursor = moneyPatternCursor == 8 ? 1
					: moneyPatternCursor + 1;
		}

		String fractionPart = cMoneyStringBuffer.substring(cMoneyStringBuffer
				.indexOf("."));
		cMoneyStringBuffer.delete(cMoneyStringBuffer.indexOf("."),
				cMoneyStringBuffer.length());
		while (cMoneyStringBuffer.indexOf("��ʰ") != -1) {
			cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("��ʰ"),
					cMoneyStringBuffer.indexOf("��ʰ") + 2, ZERO);
		}
		while (cMoneyStringBuffer.indexOf("���") != -1) {
			cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("���"),
					cMoneyStringBuffer.indexOf("���") + 2, ZERO);
		}
		while (cMoneyStringBuffer.indexOf("��Ǫ") != -1) {
			cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("��Ǫ"),
					cMoneyStringBuffer.indexOf("��Ǫ") + 2, ZERO);
		}
		while (cMoneyStringBuffer.indexOf("����") != -1) {
			cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("����"),
					cMoneyStringBuffer.indexOf("����") + 2, TEN_THOUSAND);
		}
		while (cMoneyStringBuffer.indexOf("����") != -1) {
			cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("����"),
					cMoneyStringBuffer.indexOf("����") + 2, HUNDRED_MILLION);
		}
		while (cMoneyStringBuffer.indexOf("����") != -1) {
			cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("����"),
					cMoneyStringBuffer.indexOf("����") + 2, ZERO);
		}
		if (cMoneyStringBuffer.lastIndexOf(ZERO) == cMoneyStringBuffer.length() - 1)
			cMoneyStringBuffer.delete(cMoneyStringBuffer.length() - 1,
					cMoneyStringBuffer.length());
		cMoneyStringBuffer.append(fractionPart);

		result = cMoneyStringBuffer.toString();
		return result;
	}

	private String addUnitsToChineseMoneyString(String moneyStr) {
		String result;
		StringBuffer cMoneyStringBuffer = new StringBuffer(moneyStr);
		int indexOfDot = cMoneyStringBuffer.indexOf(DOT);
		cMoneyStringBuffer.replace(indexOfDot, indexOfDot + 1, YUAN);
		cMoneyStringBuffer.insert(cMoneyStringBuffer.length() - 1, JIAO);
		cMoneyStringBuffer.insert(cMoneyStringBuffer.length(), FEN);
		if (cMoneyStringBuffer.indexOf("������") != -1)// û����ͷ������
			cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("������"),
					cMoneyStringBuffer.length(), "��");
		else if (cMoneyStringBuffer.indexOf("���") != -1)// û����֣�����
			cMoneyStringBuffer.replace(cMoneyStringBuffer.indexOf("���"),
					cMoneyStringBuffer.length(), "��");
		else {
			if (cMoneyStringBuffer.indexOf("���") != -1)
				cMoneyStringBuffer.delete(cMoneyStringBuffer.indexOf("���"),
						cMoneyStringBuffer.indexOf("���") + 2);
			// tmpBuffer.append("��");
		}
		result = cMoneyStringBuffer.toString();
		return result;
	}

	private void checkPrecision(String moneyStr) {
		int fractionDigits = moneyStr.length() - moneyStr.indexOf(DOT) - 1;
		if (fractionDigits > 2)
			throw new RuntimeException("���" + moneyStr + "��С��λ������λ��"); // ���Ȳ��ܱȷֵ�
	}

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.print("�������");
		Double jine =  input.nextDouble();
		System.out.println(getInstance().format(new Double(jine)));
	}
}