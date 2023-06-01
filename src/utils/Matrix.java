package utils;

import java.util.HashMap;

/**
 * Represents a matrix of generic entries.
 *
 * @param <T>	type of the entry objects
 */
public abstract class Matrix<T> {

	private final int rows;
	private final int cols;
	private HashMap<MatrixCoords, T> items = new HashMap<MatrixCoords, T>();

	/**
	 * To be constructed, a matrix needs to know its dimensions specified by the rows count and
	 * the columns count passed as input.
	 *
	 * @param rows							is the rows count
	 * @param cols							is the columns count
	 * @throws NegativeArraySizeException	if one of the argument is negative
	 */
	protected Matrix(int rows, int cols) {
		if (rows < 0 || cols < 0) {
			throw new NegativeArraySizeException("The matrix dimensions cannot be negative.");
		} else {
			this.rows = rows;
			this.cols = cols;
		}
	}

	/**
	 * Returns the object stored at the given coordinates.
	 *
	 * @param coords	is the object representing row-column coordinates
	 * @return
	 */
	public T get(MatrixCoords coords) {
		return items.get(coords);
	}

	/**
	 * Getter method for the number of columns in the matrix.
	 *
	 * @return the number of columns as an integer
	 */
	public int getCols() {
		return cols;
	}

	/**
	 * Getter method for the number of rows in the matrix.
	 *
	 * @return the number of rows as an integer
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * Adds the specified item to the matrix at the given coordinates. If the
	 * coordinates are outside the bounds of the matrix, an IllegalArgumentException
	 * is thrown.
	 *
	 * @param row  is the row coordinate
	 * @param col  is the column coordinate
	 * @param item is the object that needs to be added to the matrix
	 */
	public void add(int row, int col, T item) {
		if (row < rows && col < cols) {
			items.put(new MatrixCoords(row, col), item);
		} else {
			throw new IllegalArgumentException("Invalid coordinates");
		}
	}

	public void remove(int r, int c) {
		if (r >= rows || c >= cols) {
			throw new IllegalArgumentException(
					"The coordinates row: " + r + ", column: " + c + " are outside the matrix boundaries.");
		}
		items.remove(new MatrixCoords(r, c));
	}

	public void remove(MatrixCoords coords) {
		if (coords.r >= rows || coords.c >= cols) {
			throw new IllegalArgumentException("The coordinates row: " + coords.r + ", column: " + coords.c
					+ " are outside the matrix boundaries.");
		}
		items.remove(coords);
	}
}
