package commonGoal;

import java.util.ArrayList;

import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import utils.MatrixCoords;

public class CommonGoal_Diagonal extends CommonGoal{
	
	private static final int FRIST_COL_OR_ROW = 0;
	private static final int SECOND_COL = 4;
	private static final int SECOND_ROW = 1;
	private static final int DIAGONAL_LENGHT = 5;

	public CommonGoal_Diagonal(int playersNumber) {
		super(playersNumber);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int check(Bookshelf library) {
		// TODO Auto-generated method stub
		/*This CommonGoal has only four possible tile to start from, because
		 *two of them start form bottom left and end top right and the other two
		 *start from bottom right and end top left. 
		 * */		
		if(!library.notFullCol(FRIST_COL_OR_ROW) || !library.notFullCol(SECOND_ROW)) {
			BookshelfObject downLeft = library.get(new MatrixCoords(FRIST_COL_OR_ROW, FRIST_COL_OR_ROW));
			BookshelfObject upLeft = library.get(new MatrixCoords(SECOND_ROW, FRIST_COL_OR_ROW));
			BookshelfObject downRight = library.get(new MatrixCoords(FRIST_COL_OR_ROW, SECOND_COL));
			BookshelfObject upRight = library.get(new MatrixCoords(SECOND_ROW, SECOND_COL));
			
			ArrayList<BookshelfObject> tiles = new ArrayList<BookshelfObject>();
			tiles.add(downLeft);
			tiles.add(upLeft);
			tiles.add(downRight);
			tiles.add(upRight);
			
			int r = FRIST_COL_OR_ROW;
			int c = FRIST_COL_OR_ROW;
			boolean value = false;
			
			for(int y = 0; y < 4; y++) {
				if(y < 2) {
					if(y == 1) {
						r = SECOND_ROW;
					}
					BookshelfObject start = tiles.get(y);
					for(int i = 1; i < DIAGONAL_LENGHT+1; i++) {
						BookshelfObject next = library.get(new MatrixCoords(r+i, c+i));
						if(start == next) {
							value = true;
						}else {
							value = false;
							break;
						}
					}
				}else {
					r = FRIST_COL_OR_ROW;
					c = SECOND_COL;
					if(y == 3) {
						r = SECOND_ROW;
					}
					BookshelfObject start = tiles.get(y);
					for(int i = 1; i < DIAGONAL_LENGHT+1; i++) {
						BookshelfObject next = library.get(new MatrixCoords(r+i, c-i));
						if(start == next) {
							value = true;
						}else {
							value = false;
							break;
						}
					}
				}
				if(value)
					return getPoints();
			}			
		}
		return 0;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		String desc="Five tiles of the same type forming a\r\n"
				+ "diagonal.";
		return desc;
	}

}
