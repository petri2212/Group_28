package commonGoal;

import java.util.HashSet;
import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import utils.MatrixCoords;

public class CommonGoal_FourLinesThreeDiffrentObj extends CommonGoal {
	
	private static final int ROWS_NUMBER = 6;
	private static final int COLS_NUMBER = 5;
	private static final int ROWS_NEEDED = 4;
	private static final int MAX_TAILS = 3;

	public CommonGoal_FourLinesThreeDiffrentObj(int playersNumber) {
		super(playersNumber);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int check(Bookshelf library) {
		// TODO Auto-generated method stub
		/*In this method i used the HasSet and tried this version
		 * of the algorithm.
		 * */
		int cont = 0;
		
		for(int r = 0; r < ROWS_NUMBER; r++) {
			if(library.fullCol(r)) {
				BookshelfObject first = library.get(new MatrixCoords(r, COLS_NUMBER-5));
				BookshelfObject second = library.get(new MatrixCoords(r, COLS_NUMBER-4));
				BookshelfObject third = library.get(new MatrixCoords(r, COLS_NUMBER-3));
				BookshelfObject fourth = library.get(new MatrixCoords(r, COLS_NUMBER-2));
				BookshelfObject fifth = library.get(new MatrixCoords(r, COLS_NUMBER-1));
				
				HashSet<BookshelfObject> tiles = new HashSet<BookshelfObject>();
				tiles.add(first);
				tiles.add(second);
				tiles.add(third);
				tiles.add(fourth);
				tiles.add(fifth);
				
				if(tiles.size() <= MAX_TAILS) {
					cont++;
				}
			}
			if(cont == ROWS_NEEDED) {
				return getPoints();
			}
		}
		return 0;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		String desc="Four lines each formed by 5 tiles of\r\n"
				+ "maximum three different types. One\r\n"
				+ "line can show the same or a different\r\n"
				+ "combination of another line.";
		return desc;
	}

}
