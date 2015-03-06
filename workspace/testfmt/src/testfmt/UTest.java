package testfmt;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class UTest {
	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid);
		System.out.println(new java.util.Date());
		System.out.println(Calendar.getInstance().getTime());
		System.out.println(Calendar.getInstance().getTime().toString());
		System.out.println(new java.util.Date().toString());
		
		Date today = new Date();
		
		DateFormat df = DateFormat.getInstance();
		System.out.println(df.format(today));
		
		DateFormat df_fr = DateFormat.getDateInstance(DateFormat.FULL,Locale.FRENCH);
		System.out.println(df_fr.format(today));
	}
}