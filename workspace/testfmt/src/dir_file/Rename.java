package dir_file;

import java.io.*;

/**
 * Rename a file in Java
 * 
 * @author Ian F. Darwin, http://www.darwinsys.com/
 */
// BEGIN main
public class Rename {
	public static void main(String[] argv)  {
		// Construct the file object. Does NOT create a file on disk!
		File f = new File("d.txt"); // backup of this source file.
		// Rename the backup file to "junk.dat"
		// Renaming requires a File object for the target.
		f.renameTo(new File("junk3.dat"));
	}
}
// END main