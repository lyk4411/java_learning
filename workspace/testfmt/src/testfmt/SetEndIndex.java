package testfmt;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SetEndIndex {
	public static void main(String args[]) throws Exception {
		NumberFormat numForm = NumberFormat.getInstance();
		StringBuffer dest1 = new StringBuffer();
		FieldPosition pos = new FieldPosition(NumberFormat.INTEGER_FIELD);
		BigDecimal bd1 = new BigDecimal(2.342323232323D);
		dest1 = numForm.format(bd1, dest1, pos);
		System.out.println("dest1 = " + dest1);
		System.out.println("INTEGER portion is at: " + pos.getBeginIndex()
				+ ", " + pos.getEndIndex());
		pos = new FieldPosition(NumberFormat.FRACTION_FIELD);
		StringBuffer dest2 = new StringBuffer();
		dest2 = numForm.format(bd1, dest2, pos);
		System.out.println("dest2 = " + dest2);
		System.out.println("FRACTION portion is at: " + pos.getBeginIndex()
				+ ", " + pos.getEndIndex());

		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG);
		StringBuffer dest3 = new StringBuffer();
		// 关注的是几号
		pos = new FieldPosition(DateFormat.DATE_FIELD);
		dest3 = df.format(new Date(), dest3, pos);
		System.out.println("dest3 = " + dest3);
		// 结果当前时间为2012年6月27日 下午04时06分56秒 则beginIndex为7 endIndex为9
		System.out.println("FRACTION portion is at: " + pos.getBeginIndex()
				+ ", " + pos.getEndIndex());

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String input[] = { "abc 2013-10-01 Vancouver, B.C.",
				"1248-03-01 Ottawa, ON", "1323-06-06 Toronto, ON" };
		for (int i = 0; i < input.length; i++) {
			ParsePosition pp = new ParsePosition(4);// 从第四位开始处理
			Date d = formatter.parse(input[i], pp);
			if (d == null) {
				// 结果只处理了"abc 2013-10-01 Vancouver, B.C."
				// "1248-03-01 Ottawa, ON"从第四位开始是"8-03-01 Ottawa, ON"无法转换
				System.err.println("Invalid date in " + input[i]);
				continue;
			}
			// 成功转换后ParsePosition.getIndex()就是匹配的字符串结尾的索引
			String location = input[i].substring(pp.getIndex());
			System.out.println(" on " + d + " in " + location);

		}
	}
}