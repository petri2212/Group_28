package utils;

/**
 * Represents the coordinates of a matrix entry
 */
public class MatrixCoords {
	public int r;
	public int c;

	/**
	 * The Coordinates takes the row index as first parameter and column index as second parameter.
	 * Ii is important to keep this in mind when passing this arguments to the constructor,
	 * otherwise the column will be used as row and vice versa.
	 * @param r									is the row index
	 * @param c									is the column index
	 * @throws NegativeMatrixCoordsException 	if one of the arguments is negative
	 */
	public MatrixCoords(int r, int c) {
		if (r < 0 || c < 0) {
			throw new NegativeMatrixCoordsException("One of the arguments used to create a matrix"
					                              + "coordinate is negative: " + r + ", " + c);
		}
		else {
			this.r = r;
			this.c = c;
		}
	}
	
	public boolean equalsMatCoords(MatrixCoords matrix) {
		if(this.r==matrix.r && this.c==matrix.c) {
			return true;
		}
		return false;
	}
}
