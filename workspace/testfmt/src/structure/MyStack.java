package structure;

/** A lax Stack implementation. */
@SuppressWarnings("unchecked")
// BEGIN main
public class MyStack<T> {
	private int depth = 0;
	public static final int DEFAULT_INITIAL = 10;
	private T[] stack;

	public MyStack() {
		this(DEFAULT_INITIAL);
	}

	public MyStack(int howBig) {
		if (howBig <= 0) {
			throw new IllegalArgumentException(howBig
					+ " must be positive, but was " + howBig);
		}
		stack = (T[]) new Object[howBig];
	}

	public boolean hasNext() {
		return depth > 0;
	}

	public boolean hasRoom() {
		return depth < stack.length;
	}

	public int getStackDepth() {
		return depth;
	}
	public T pop(){
		if(hasNext()){
			return stack[--depth];
		}
		throw new ArrayIndexOutOfBoundsException(-1);
	}
	public void push(T obj){
		this.stack[this.depth++] = obj;
	}
}
// END main