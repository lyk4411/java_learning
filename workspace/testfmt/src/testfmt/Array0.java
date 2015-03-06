package testfmt;

import java.util.Calendar;

/**
 * Simple array example
 * 
 * @author Ian Darwin
 */
public class Array0 {
	// Use this initializer form when the data are fixed:
	
	public static void main(String[] argv) throws InterruptedException {
		int nDates = 0;
		final int MAX = 10;
		Calendar[] dates = new Calendar[MAX];
		Calendar c;
		while ((c = getDate()) != null){
            Thread.sleep(1000);
			System.out.println(c.getTime());
			if(nDates >= dates.length){
				Calendar[] tmp = new Calendar[dates.length + 10];
				System.arraycopy(dates, 0, tmp, 0, dates.length);
				dates = tmp;
			}
			dates[nDates++] = c;
		}
		System.out.println("Array size = " + dates.length);
	}
	
	static int n;
	
	public static Calendar getDate() {
		if(n++ > 21){
			return null;
		}
		//System.out.println(Calendar.getInstance());
		return Calendar.getInstance();
	}
}