package OCJP;

public class Q {
	public static void main(String[] args) {
		Animal2 Animal2 = new Dog();
		Cat cat = (Cat) Animal2;
		System.out.println(cat.noise());
	}
}

class Animal2 {
	public String noise() {
		return "peep";
	}
}

class Dog extends Animal2 {
	public String noise() {
		return "bark";
	}
}

class Cat extends Animal2 {
	public String noise() {
		return "meow";
	}
}
