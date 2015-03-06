package structure;

public class MediaDemo {
	public static void main(String[] args) {
		Media m = Media.values()[3];
		System.out.println(m);
		
		System.out.println(m.getMedia(2));
		System.out.println(m.getMedia("MOVIE_DVd"));
	}
}