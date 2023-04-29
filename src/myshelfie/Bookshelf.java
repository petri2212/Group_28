package myshelfie;

import utils.Matrix;
import utils.MatrixCoords;

public class Bookshelf extends Matrix<BookshelfObject> {

	private static final int ROWS_NUMBER = 6;
	private static final int COLS_NUMBER = 5;
	private final int noEmptyRow=-1;
	
	public Bookshelf() {
		super(ROWS_NUMBER, COLS_NUMBER);
	}
	
	public void add (int c, BookshelfObject obj) {
		int r = getFirstEmptyRow(c);
		
		if(r != noEmptyRow) {
			items.put(new MatrixCoords(r, c), obj);
		}else {
			System.out.println("invalid cols!");
		}
	}
	
	public void add (int c, BookshelfObject[] objs) {
		int lenght = objs.length;
		int r = getFirstEmptyRow(c);
		
		if(r != noEmptyRow && isThereEnoughSpace(r,lenght)) {
			for (BookshelfObject obj : objs) {
				items.put(new MatrixCoords(r, c), obj);
				r++;
			}
		}else {
			System.out.println("invalid cols!");
		}
		
	}
	
	private boolean isThereEnoughSpace(int r, int lenght) {
		int rMaxIndex = ROWS_NUMBER-1;
		int rIndex = r + lenght;
		
		return (rIndex <= rMaxIndex) ? true : false;
	}

	private int getFirstEmptyRow(int c) {
		for(int r=0; r<ROWS_NUMBER; r++) {
			if(items.get(new MatrixCoords(r, c)) == null) {
				return r;
			}
		}
		return noEmptyRow;
	}
	
	public boolean fullCol(int r) {
		for(int c=0; c<ROWS_NUMBER; c++) {
			if(items.get(new MatrixCoords(r, c)) == null) {
				return false;
			}
		}
		return true;
	}
	
}
