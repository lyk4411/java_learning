package OCJP;

import java.util.Collection;
import java.util.Iterator;

public class Collections {
	public static <E> Collection<E> checkedCollection(Collection<E> c,
			Class<E> type) {
		return new CheckedCollection<E>(c, type);
	}

	private static class CheckedCollection<E> implements Collection<E> {
		private final Collection<E> c;
		private final Class<E> type;

		CheckedCollection(Collection<E> c, Class<E> type) {
			this.c = c;
			this.type = type;
		}

		public boolean add(E o) {
			if (!type.isInstance(o))
				throw new ClassCastException();
			else
				return c.add(o);
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean contains(Object o) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterator<E> iterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T[] toArray(T[] a) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean remove(Object o) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean addAll(Collection<? extends E> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}
	}
}