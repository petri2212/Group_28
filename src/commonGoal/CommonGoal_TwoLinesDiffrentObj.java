package commonGoal;

import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import resource.Images;
import utils.MatrixCoords;

public class CommonGoal_TwoLinesDiffrentObj extends CommonGoal{
	
	private static final int ROWS_NUMBER = 6;
	private static final int COLS_NUMBER = 5;
	private static final int ROWS_DIFERRENT = 2;

	@Override
	public Images getImage() {
		return Images.COMMON_GOAL_TWO_LINES_DIFFERENT_OBJ;
	}

	@Override
	public int check(Bookshelf library) {
		int cont = 0;
		int tmpCols = 0;
		
		for(int r = 0; r < ROWS_NUMBER; r++) {
			if(library.fullCol(r)) {
				for(int c = 0; c < COLS_NUMBER; c++) {
					BookshelfObject tmpVar = library.get(new MatrixCoords(r, c));
					do {
						if(tmpCols != c) {
							if(tmpVar == library.get(new MatrixCoords(r, tmpCols))) {
								break;
							}
						}
						tmpCols++;
					}while(tmpCols < COLS_NUMBER);
					if(tmpCols == COLS_NUMBER) {
						cont++;
					}
				}
			}
			if(cont == ROWS_DIFERRENT) {
				return 1;
			}
		}
		return 0;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		String desc="Two lines each formed by 5 different\r\n"
				+ "types of tiles. One line can show the\r\n"
				+ "same or a different combination of the\r\n"
				+ "other line.";
		return desc;
	}
}
