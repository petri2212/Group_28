package commonGoal;

import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import resource.Images;
import utils.MatrixCoords;

public class CommonGoal_FiveX extends CommonGoal{
	
	private static final int MAX_ROWS = 5;
	private static final int MAX_COLS = 4;
	private static final int MIN_ROWS_AND_COLS = 1;

	@Override
	public Images getImage() {
		return Images.COMMON_GOAL_FIVE_X;

	}

	@Override
	public int check(Bookshelf library) {
	
		/*the difficulties is related to the BookshelfObject in the bookshelf because
		 * there could be some empty columns and aint't the rows.
		 */
		for(int r = MIN_ROWS_AND_COLS; r < MAX_ROWS; r++)
			for(int c = MIN_ROWS_AND_COLS; c < MAX_COLS; c++) {
				BookshelfObject center = library.get(new MatrixCoords(r, c));
				BookshelfObject upLeft = library.get(new MatrixCoords(r+1, c-1));
				BookshelfObject upRight = library.get(new MatrixCoords(r+1, c+1));
				BookshelfObject downLeft = library.get(new MatrixCoords(r-1, c-1));
				BookshelfObject downRight = library.get(new MatrixCoords(r-1, c+1));
				
				if(center != null) {
					if(center == upLeft && center == upRight && center == downLeft && center == downRight) {
							return 1;
						}
				}
			}
		
		return 0;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		String desc="Five tiles of the same type forming an X.\r\n"
				+ "";
		return desc;
	}
}