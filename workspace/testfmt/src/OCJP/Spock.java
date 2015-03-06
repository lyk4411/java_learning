package OCJP;

public class Spock {
	public static void main(String[] args) {
		Long tail = 2000L;
		Long distance = 1999L;
		Long story = 1000L;
		if ((tail > distance) ^ ((story * 2) == tail))
			System.out.print("1");
		if ((distance + 1 != tail) ^ ((story * 2) == distance))
			System.out.print("2");
	}
 }