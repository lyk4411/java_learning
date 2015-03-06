package OCJP;

public class ItemTest {
	private final int id;

	public ItemTest(int id) {
		this.id = id;
	}

	public void updateId(int newId) {

	}

	public static void main(String[] args) {
		ItemTest fa = new ItemTest(42);
		fa.updateId(69);
		System.out.println(fa.id);
	}

}