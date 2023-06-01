package utils;

import java.util.HashMap;

/**
 * Represents a matrix of generic entries.
 *
 * @param <T> type of the entry objects
 */
public abstract class Matrix<T> {

	private final int rows;
	private final int cols;
	private HashMap<MatrixCoords, T> items = new HashMap<MatrixCoords, T>();

	/**
	 * Creates a new matrix with the given number of rows and columns.
	 *
	 * @param rows is the rows count
	 * @param cols is the columns count
	 * @throws NegativeArraySizeException if one of the argument is negative
	 */
	protected Matrix(int rows, int cols) {
		if (rows < 0 || cols < 0) {
			throw new NegativeArraySizeException("The matrix dimensions cannot be negative.");
		}

		this.rows = rows;
		this.cols = cols;
	}

	/**
	 * Returns the object stored at the given coordinates.
	 *
	 * @param coords is the object representing row-column coordinates
	 * @return a generic object T that is the item inside the matrix at the given
	 *         coordinates
	 */
	public T get(MatrixCoords coords) {
		return items.get(coords);
	}

	/**
	 * @return the number of columns in the matrix
	 */
	public int getCols() {
		return cols;
	}

	/**
	 * @return the number of rows in the matrix
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * Adds the specified item to the matrix at the given coordinates.
	 *
	 * @param row  is the row coordinate
	 * @param col  is the column coordinate
	 * @param item is the object that needs to be added to the matrix
	 * @throws IllegalArgumentException If the coordinates are outside the bounds of
	 *                                  the matrix
	 */
	public void add(int row, int col, T item) {
		if (row >= rows && col >= cols) {
			throw new IllegalArgumentException("Invalid coordinates");
		}

		items.put(new MatrixCoords(row, col), item);
	}

	/**
	 * Removes the item at the given coordinates without altering the matrix
	 * dimensions. The item at the given position is substituted by null.
	 *
	 * @param r is the row coordinate
	 * @param c is the column coordinate
	 * @throws IllegalArgumentException if the coordinates are outside the matrix
	 *                                  boundaries
	 */
	public void remove(int r, int c) {
		if (r >= rows || c >= cols) {
			throw new IllegalArgumentException(
					"The coordinates row: " + r + ", column: " + c + " are outside the matrix boundaries.");
		}

		items.put(new MatrixCoords(r, c), null);
	}

	/**
	 * Removes the item at the given coordinates without altering the matrix
	 * dimensions. The item at the given position is substituted by null.
	 *
	 * @param coords is the object representing the item coordinates
	 * @throws IllegalArgumentException if the coordinates are outside the matrix
	 *                                  boundaries
	 */
	public void remove(MatrixCoords coords) {
		if (coords.r >= rows || coords.c >= cols) {
			throw new IllegalArgumentException("The coordinates row: " + coords.r + ", column: " + coords.c
					+ " are outside the matrix boundaries.");
		}

		items.put(coords, null);
	}
}
