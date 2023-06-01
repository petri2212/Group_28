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
			super.add(r, c, obj);
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
				super.add(r, c, obj);
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
	 * specified column.
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

	/**
	 * Checks all rows in a given column and returns the number of the first row
	 * that results null
	 * 
	 * @param c is the column
	 * @return r if the column have at least 1 row empty
	 * @return noEmptyRow if all rows of the column are full
	 */
	public int getFirstEmptyRow(int c) {
		for (int r = 0; r < ROWS_NUMBER; r++) {
			if (this.get(new MatrixCoords(r, c)) == null) {
				return r;
			}
		}
		return noEmptyRow;
	}

	/**
	 * Checks all rows in a given column and returns the number of the first row
	 * that results full
	 * 
	 * @param c is the column
	 * @return r if the column have at least 1 row empty
	 * @return noEmptyRow if all rows of the column are empty
	 */
	public int getFirstFilledRow(int c) {
		for (int r = 0; r < ROWS_NUMBER; r++) {
			if (this.get(new MatrixCoords(r, c)) != null) {
				return r;
			}
		}
		return noEmptyRow;
	}

	/**
	 * Checks all cols in a given row and returns true if there are no empty cols
	 * 
	 * @param row is the column
	 * @return true if the if there are no empty cols, else false
	 */
	public boolean checkIfRowIsfull(int row) {

		for (int c = 0; c < 4; c++) {
			if (this.get(new MatrixCoords(row, c)) == null) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Method to check if the bookshelf is full or empty
	 * 
	 * @return true if there are at least one empty coordinate, else false
	 */
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
