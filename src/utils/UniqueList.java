package utils;

import java.util.ArrayList;

/**
 * Equivalent of a Set that allows the use of all list methods.
 */
public class UniqueList<E> extends ArrayList<E> {

	private static final long serialVersionUID = 4343593597081020435L;

	/**
	 * Appends the specified element to the end of this list only if it is not
	 * already present. The object E can override its equals() method to specify how
	 * an object that need to be added should be considered unique.
	 *
	 * @throws IllegalArgumentException in case the element is already present in
	 *                                  the list
	 */
	@Override
	public boolean add(E e) {
		boolean result = false;

		if (this.contains(e)) {
			throw new IllegalArgumentException(
					"The element " + e + " is already present in the list. " + "Only unique elements can be added.");
		} else {
			result = super.add(e);
		}

		return result;
	}

}
