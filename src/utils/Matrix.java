package utils;

import java.util.HashMap;

public abstract class Matrix<T> {

	protected final int rows;
	protected final int cols;
	protected HashMap<MatrixCoords, T> items = new HashMap<MatrixCoords, T>();

	protected Matrix(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
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
