package utils;

import java.util.HashMap;

/**
 * Represents a matrix of generic entries.
 *
 * @param <T>	type of the entry objects
 */
public abstract class Matrix<T> {

	protected final int rows;
	protected final int cols;
	protected HashMap<MatrixCoords, T> items = new HashMap<MatrixCoords, T>();

	/**
	 * To be constructed, a matrix needs to know its dimensions specified by the rows count and
	 * the columns count passed as input.
	 *
	 * @param rows							is the rows count
	 * @param cols							is the columns count
	 * @throws NegativeArraySizeException	if one of the argument is negative
	 */
	protected Matrix(int rows, int cols) {
		if(rows < 0 || cols < 0) {
			throw new NegativeArraySizeException("The matrix dimensions cannot be negative.");
		}
		else {
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
}
