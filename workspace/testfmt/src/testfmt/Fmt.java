package testfmt;
import java.io.*;
import java.util.*;

public class Fmt {
	public static final int COLWIDTH=72;
	BufferedReader in;
	
	public static void main (String[] av) throws IOException {
		if(av.length == 0){
			new Fmt(System.in).format();
		}
		else for(int i = 0; i < av.length; i ++)
		{
			new Fmt(av[i]).format();
		}
	}
	
	public Fmt(String fname) throws IOException {
		in = new BufferedReader(new FileReader(fname));
	}
	
	public Fmt(InputStream file) throws IOException {
		in = new BufferedReader(new InputStreamReader(file));
	}
	
	public void format() throws IOException {
		String w,f;
		int col = 0;
		while ((w = in.readLine()) != null) {
			if (w.length() == 0) {
				System.out.print("\n");
				if (col>0) {
					System.out.print("\n");
					col = 0;
				}
				continue;
			}
			StringTokenizer st = new StringTokenizer(w);
			while (st.hasMoreElements()){
				f = st.nextToken();
				
				if(col + f.length() > COLWIDTH) {
					System.out.print("\n");
					col = 0;
				}
				System.out.print(f + " ");
				col += f.length() + 1;
			}
			if (col > 0) {
				System.out.print("\n");
			}
		}
		in.close();
	}
}