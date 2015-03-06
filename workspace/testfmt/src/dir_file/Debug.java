package dir_file;

public class Debug {
	public static boolean isEnabled(String category) {
		return System.getProperty("debug." + category) != null;
	}
	
	public static void println(String category, String msg) {
		if (isEnabled(category)) {
			System.out.println(msg);
		}
	}
	
	public static void println(String category, Object stuff) {
		println(category, stuff.toString());
	}
}
