package OCJP;

class Thingy {
	Meter m = new Meter();
}

class Component {
	Component(){
		
	}
	void go() {
		System.out.print("c");
	}
}

class Meter extends Component {
	
	void go() {
		System.out.print("m");
	}
}

class DeluxeThingy extends Thingy {
	public static void main(String[] args) {
		DeluxeThingy dt = new DeluxeThingy();
		dt.m.go();
		Thingy t = new DeluxeThingy();
		t.m.go();
	}
}
