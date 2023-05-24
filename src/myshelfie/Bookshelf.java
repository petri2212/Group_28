package myshelfie;

import java.util.List;

import board.Board;
import utils.Matrix;
import utils.MatrixCoords;

public class Bookshelf extends Matrix<BookshelfObject> {

	private static final int ROWS_NUMBER = 6;
	private static final int COLS_NUMBER = 5;
	private final int noEmptyRow=-1;
	
	public Bookshelf() {
		super(ROWS_NUMBER, COLS_NUMBER);
	}
	
	public boolean tryAdd (int c, BookshelfObject obj) {
		int r = getFirstEmptyRow(c);
		boolean result = false;

		if(r != noEmptyRow) {
			this.add(r, c, obj);
			result  =true;
		}

		return result;
	}
	
	public boolean tryAdd (int c, List<BookshelfObject> objs) {
		int lenght = objs.size();
		int r = getFirstEmptyRow(c);
		boolean result = false;

		if(r != noEmptyRow && isThereEnoughSpace(r,lenght)) {
			for (BookshelfObject obj : objs) {
				this.add(r, c, obj);
				r++;
			}

			result = true;
		}

		return result;
	}
	
	private boolean isThereEnoughSpace(int r, int lenght) {
		int rMaxObjects = ROWS_NUMBER;
		int rIndex = r + lenght;

		return (rIndex <= rMaxObjects) ? true : false;
	}

	public int getFirstEmptyRow(int c) {
		for(int r=0; r<ROWS_NUMBER; r++) {
			if(this.get(new MatrixCoords(r, c)) == null) {
				return r;
			}
		}
		return noEmptyRow;
	}
	
	public int getFirstFilledRow(int c) {
		for(int r=0; r<ROWS_NUMBER; r++) {
			if(this.get(new MatrixCoords(r, c)) != null) {
				return r;
			}
		}
		return noEmptyRow;
	}

	public boolean fullCol(int r) {
		for(int c=0; c<COLS_NUMBER; c++) {
			if(this.get(new MatrixCoords(r, c)) == null) {
				return false;
			}
		}
		return true;
	}
	public boolean checkIfRowIsfull(int row) {
		
		for(int c=0; c<4; c++) {
			if(this.get(new MatrixCoords(row, c)) == null) {
				return false;
			}
		}
		return true;
	}

	public void add(int row, int col, BookshelfObject object) {
		super.add(row, col, object);
	}

	public boolean isFull() {
		for (int r = 0; r < Board.ROW_COUNT; r++) {
			for (int c = 0; c < Board.COL_COUNT; c++) {
				BookshelfObject object = get(new MatrixCoords(r, c));

				if (object == null) {
					return false;
				}
			}
		}

		return true;
	}

}
