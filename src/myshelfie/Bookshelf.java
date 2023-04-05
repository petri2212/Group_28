package myshelfie;

public class Bookshelf {

	public static final int COLS_NUMBER = 5;
	public static final int ROWS_NUMBER = 6;
	private BookshelfObject[][] bookshelfObjects;
	private final int noEmptyRow=-1;
	
	public Bookshelf() {
		bookshelfObjects = new BookshelfObject[ROWS_NUMBER][COLS_NUMBER];
	}
	
	public void add (int c, BookshelfObject obj) {
		int r = getFirstEmptyRow(c);
		
		if(r != noEmptyRow) {
			bookshelfObjects[r][c] = obj;
		}else {
			System.out.println("invalid cols!");
		}
	}
	
	public void add (int c, BookshelfObject[] objs) {
		int lenght = objs.length;
		int r = getFirstEmptyRow(c);
		
		if(r != noEmptyRow && isThereEnoughSpace(r,lenght)) {
			for (BookshelfObject obj : objs) {
				bookshelfObjects[r][c] = obj;
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
			if(bookshelfObjects[r][c] == null) {
				return r;
			}
		}
		return noEmptyRow;
	}

	public BookshelfObject get(int r, int c) {
		return bookshelfObjects[r][c];
	}
	
}
