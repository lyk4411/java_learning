package OCJP;

public class Batman {
	Integer squares = 81;

	public static void main(String[] args) {
		new Batman().go();
		
		
	}

	void go() {
		incr(++squares);
		System.out.println(squares);
	}

	Integer incr(Integer squares) {
		squares = 10 + squares;
		//System.out.println(squares);
		return squares;
	}
}