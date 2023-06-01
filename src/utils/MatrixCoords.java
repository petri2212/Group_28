package utils;

/**
 * Represents the coordinates of a matrix entry
 */
public class MatrixCoords {
	public int r;
	public int c;

	/**
	 * Creates new matrix coordinates taking the row index as first parameter and
	 * column index as second parameter. Ii is important to keep this in mind when
	 * passing this arguments to the constructor, otherwise the column will be used
	 * as row and vice versa.
	 *
	 * @param r is the row index
	 * @param c is the column index
	 * @throws NegativeMatrixCoordsException if one of the arguments is negative
	 */
	public MatrixCoords(int r, int c) {
		if (r < 0 || c < 0) {
			throw new NegativeMatrixCoordsException(
					"One of the arguments used to create a matrix" + "coordinate is negative: " + r + ", " + c);
		} else {
			this.r = r;
			this.c = c;
		}
	}

	/**
	 * Returns the hash code of this coordinates calculating the sum between the row
	 * index and the column index.
	 */
	@Override
	public int hashCode() {
		return r + c;
	}

	/**
	 * Returns true if the MatrixCoords object passed as parameter has the same row
	 * index and column index.
	 */
	@Override
	public boolean equals(Object obj) {
		MatrixCoords matrixCoords = (MatrixCoords) obj;

		if (this.r == matrixCoords.r && this.c == matrixCoords.c) {
			return true;
		}
		return false;
	}
}
