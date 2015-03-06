package testfmt;

import java.io.*;

public class Undent {

	protected int nSpaces;

	Undent(int n) {
		nSpaces = n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Undent c = new Undent(5);
		switch (args.length) {
		case 0:
			c.process(new BufferedReader(new InputStreamReader(System.in)));
			break;
		default:
			for (int i = 0; i < args.length; i++) {
				try {
					c.process(new BufferedReader(new FileReader(args[i])));
				} catch (FileNotFoundException e) {
					System.err.println(e);
				}
			}
		}
	}

	public void process(BufferedReader is) {
		try {
			String inputLine;

			while ((inputLine = is.readLine()) != null) {
				int toRemove = 0;
				for (int i = 0; i < nSpaces && i < inputLine.length(); i++) {
					if (Character.isSpace(inputLine.charAt(i))) {
						++toRemove;
					}
				}
				System.out.println(inputLine.substring(toRemove));
			}
			is.close();
		} catch (IOException e) {
			System.out.println("IOException" + e);
		}
	}
}
