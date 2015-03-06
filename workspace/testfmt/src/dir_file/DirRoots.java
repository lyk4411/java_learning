package dir_file;

import java.io.File;

public class DirRoots {
	public static void main(String argh_my_aching_fingers[]) {
		File[] drivers=File.listRoots();
		for(int i = 0; i<drivers.length; i++){
			System.out.println(drivers[i]);
		}
	}
}
