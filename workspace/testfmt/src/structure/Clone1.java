package structure;

/** Demonstration of cloning. */
// BEGIN main
public class Clone1 implements Cloneable {
	/** Clone this object. Call super.clone() to do the work */
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException ex) {
			System.out.println("Now that's a surprise!!");
			throw new InternalError(ex.toString());
		}
	}

	int x;
	transient int y; // will be cloned, but not serialized

	/** Display the current object as a string */
	public String toString() {
		return "Clone1[" + x + "," + y + "]";
	}

	public static void main(String[] args) {
		Clone1 c = new Clone1();
		c.x = 100;
		c.y = 200;
		try {
			Object d = c.clone();
			System.out.println("c=" + c);
			c.x = 300;
			c.y = 400;
			System.out.println("d=" + d);
			System.out.println("c=" + c);

		} catch (Exception ex) {
			System.out.println("hello world£¡");
			System.out.println(ex.toString());
		}
	}
}
// END main