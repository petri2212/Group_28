package myshelfie;

import java.util.List;

import utils.Matrix;
import utils.MatrixCoords;

public class Bookshelf extends Matrix<BookshelfObject> {

	private static final int ROWS_NUMBER = 6;
	private static final int COLS_NUMBER = 5;
	private final int noEmptyRow = -1;

	/**
	 * Creates a new bookshelf.
	 */
	public Bookshelf() {
		super(ROWS_NUMBER, COLS_NUMBER);
	}

	/**
	 * Try to add the passed object into the specified column. This function returns
	 * false in case of operation failure, true in case of success.
	 * 
	 * @param c   is the column
	 * @param obj is the object to add to the bookshelf
	 * @return a boolean value that specifies if the operation was successful
	 */
	public boolean tryAdd(int c, BookshelfObject obj) {
		int r = getFirstEmptyRow(c);
		boolean result = false;

		if (r != noEmptyRow) {
			this.add(r, c, obj);
			result = true;
		}

		return result;
	}

	/**
	 * Try to add a group of objects into the specified column. This function
	 * returns false in case of operation failure, true in case of success.
	 * 
	 * @param c    is the column
	 * @param objs a list that holding the objects to add to the bookshelf
	 * @return a boolean value that specifies if the operation was successful
	 */
	public boolean tryAdd(int c, List<BookshelfObject> objs) {
		int lenght = objs.size();
		int r = getFirstEmptyRow(c);
		boolean result = false;

		if (r != noEmptyRow && isThereEnoughSpace(c, lenght)) {
			for (BookshelfObject obj : objs) {
				this.add(r, c, obj);
				r++;
			}

			result = true;
		}

		return result;
	}

	/**
	 * Returns true if there is enough space inside the bookshelf to add a certain
	 * amount of objects. This method checks all column of the bookshelf.
	 * 
	 * @param lenght the number of objects that needs to be added
	 * @return true if there is enough space, else false
	 */
	public boolean isThereEnoughSpace(int lenght) {
		for (int c = 0; c < COLS_NUMBER; c++) {
			int rMaxObjects = ROWS_NUMBER;
			int firstRow = getFirstEmptyRow(c);
			int rIndex = firstRow + lenght;

			if ((rIndex < rMaxObjects) && (firstRow != noEmptyRow)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Returns true if there is enough space for the specified object in the
	 * specified colum.
	 * 
	 * @param c      is the column
	 * @param lenght the number of objects that needs to be added
	 * @return true if there is enough space, else false
	 */
	public boolean isThereEnoughSpace(int c, int lenght) {
		int rMaxObjects = ROWS_NUMBER;
		int firstRow = getFirstEmptyRow(c);
		int rIndex = firstRow + lenght;

		return ((rIndex <= rMaxObjects) && (firstRow != noEmptyRow)) ? true : false;
	}

	public int getFirstEmptyRow(int c) {
		for (int r = 0; r < ROWS_NUMBER; r++) {
			if (this.get(new MatrixCoords(r, c)) == null) {
				return r;
			}
		}
		return noEmptyRow;
	}

	public int getFirstFilledRow(int c) {
		for (int r = 0; r < ROWS_NUMBER; r++) {
			if (this.get(new MatrixCoords(r, c)) != null) {
				return r;
			}
		}
		return noEmptyRow;
	}

	public boolean fullCol(int r) {
		for (int c = 0; c < COLS_NUMBER; c++) {
			if (this.get(new MatrixCoords(r, c)) == null) {
				return false;
			}
		}
		return true;
	}

	public boolean checkIfRowIsfull(int row) {

		for (int c = 0; c < 4; c++) {
			if (this.get(new MatrixCoords(row, c)) == null) {
				return false;
			}
		}
		return true;
	}

	public void add(int row, int col, BookshelfObject object) {
		super.add(row, col, object);
	}

	public boolean isFull() {
		for (int r = 0; r < ROWS_NUMBER; r++) {
			for (int c = 0; c < COLS_NUMBER; c++) {
				BookshelfObject object = get(new MatrixCoords(r, c));

				if (object == null) {
					return false;
				}
			}
		}

		return true;
	}

}
