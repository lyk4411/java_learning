package OCJP;

interface AA {
	public void aMethod();
}

interface BB {
	public void bMethod();
}

interface CC extends AA, BB {
	public void cMethod();
}

class DD implements BB {

	public void bMethod() {
		System.out.println("bbbbbbbbbbb");

	}

}

class EE extends DD implements CC {

	public void aMethod() {
	}

	public void bMethod() {
		System.out.println("aaaaaaaaaaa");
	}

	public void cMethod() {
	}

}

public class E {
	public static void main(String[] args){
		 DD e = (DD)(new EE());
		 e.bMethod();
	 }
}