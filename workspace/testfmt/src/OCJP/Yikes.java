package OCJP;

public class Yikes {

	public static void go(Long n){
		System.out.println("long");
	}
	
	public static void go(int n){
		System.out.println("int");
	}
	
	public static void go(Short n){
		System.out.println("short");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		short y = 6;
		long z = 7;
		go(y);
		go(z);
		go((Short)y);
	}
}
