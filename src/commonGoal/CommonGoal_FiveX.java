package commonGoal;

import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import utils.MatrixCoords;

public class CommonGoal_FiveX extends CommonGoal{
	
	private final int MAX_ROWS = 5;
	private final int MAX_COLS = 4;
	private final int MIN_ROWS_AND_COLS = 1;
	
	protected CommonGoal_FiveX(int playersNumber) {
		super(playersNumber);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int check(Bookshelf library) {
		// TODO Auto-generated method stub
		/*the difficulties is related to the bookshelfobjects in the bookshelf because
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
							return getPoints();
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