package OCJP;

public class Lhist<V> {
	private V[] array;
	private int size;

	public Lhist(int capacity) {
		array = (V[]) new Object[capacity];
	}

	public void add(V value) {
		if (size == array.length)
			throw new IndexOutOfBoundsException(Integer.toString(size));
		else if (value == null)
			throw new NullPointerException();
		array[size++] = value;
	}

	public void remove(V value) {
		int removalCount = 0;
		for (int i = 0; i < size; i++) {
			if (array[i].equals(value))
				++removalCount;
			else if (removalCount > 0) {
				array[i - removalCount] = array[i];
				array[i] = null;
			}
		}
		size -= removalCount;
	}

	public int size() {
		return size;
	}

	public V get(int i) {
		if (i >= size)
			throw new IndexOutOfBoundsException(Integer.toString(i));
		return array[i];
	}
}