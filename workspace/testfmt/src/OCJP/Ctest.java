package OCJP;

abstract class C1 {
	public C1() {
		System.out.println(1);
	}
}

class C2 extends C1 {
	public C2() {
		System.out.println(2);
	}
}

class C3 extends C2 {
	public C3() {
		System.out.println(3);
	}
}

abstract class Vehicle {
	public int speed() {
		return 0;
	}
}

class Car extends Vehicle {
	public int speed() {
		return 60;
	}
}

class RaceCar extends Car {
	public int speed() {
		return 150;
	}
}

public class Ctest {
	public static void main(String[] a) {
		new C3();

		RaceCar racer = new RaceCar();
		Car car = new RaceCar();
		Vehicle vehicle = new RaceCar();
		System.out.println(racer.speed() + ", " + car.speed() + ", "
				+ vehicle.speed());

		for (int x = 0; x <= 100 / 5; x++) {
			for (int y = 0; y <= 100 / 3; y++) {
				for (int z = 0; z <= 100; z++) {
					if ((5 * x + 3 * y + z / 3 == 100) && (x + y + z == 100)
							&& z % 3 == 0) {
						System.out.println("x:" + x + " y:" + y + " z:" + z);
						break;
					}
				}
			}
		}
	}
}