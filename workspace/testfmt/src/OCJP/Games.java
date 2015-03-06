package OCJP;

class Game {
	protected void play() {
		System.out.println("play game");
	}
}

// Football.java
class Football extends Game {
	protected void play() {
		System.out.println("play football");
		super.play();
	}

	void f() {
		play();
	}
}

// Basketball.java
class Basketball extends Game {
	protected void play() {
		System.out.println("play basketball");
	}
}

// Popolong.java
class Popolong extends Game {
	protected void play() {
		System.out.println("play popolong");
	}
}

// Games.java
public class Games {
	public static void main(String[] args) {
		Game[] games = new Game[10];
		games[0] = new Basketball();
		games[1] = new Football();
		games[2] = new Popolong();

		for (int i = 0; i < games.length; i++) {
			if (games[i] != null)
				games[i].play();
		}
	}
}
