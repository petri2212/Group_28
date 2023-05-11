package utils;

import java.util.ArrayList;

/**
 * Equivalent of a Set that allows the use of all list methods.
 */
public class UniqueList<E> extends ArrayList<E> {

	private static final long serialVersionUID = 4343593597081020435L;

	/**
	 * Appends the specified element to the end of this list only if it is not
	 * already present. In case the element already exists throws an
	 * IllegalArgumentException.
	 */
	@Override
	public boolean add(E e) {
		boolean result = false;

		if (this.contains(e)) {
			throw new IllegalArgumentException("Only unique elements can be added to the list.");
		} else {
			result = this.add(e);
		}

		return result;
	}

}
