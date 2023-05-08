package commonGoal;

import java.util.HashSet;
import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import myshelfie.ResourceImage;
import utils.MatrixCoords;

public class CommonGoal_FourLinesThreeDiffrentObj extends CommonGoal {
	
	private static final int ROWS_NEEDED = 4;
	private static final int MAX_TAILS = 3;

	private boolean isItCompleted=false; 
	
	public CommonGoal_FourLinesThreeDiffrentObj() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResourceImage getImage() {
		return ResourceImage.COMMON_GOAL_FOUR_LINES_THREE_DIFFERENT_OBJ;
	}

	@Override
	public int check(Bookshelf library) {
		// TODO Auto-generated method stub
		/*In this method i used the HasSet and tried this version
		 * of the algorithm.
		 * */
		int cont = 0;
		
		for(int r = 0; r < library.getRows(); r++) {
			if(library.fullCol(r)) {
				HashSet<BookshelfObject> tiles = new HashSet<BookshelfObject>();
				
				for(int i = 0; i < library.getCols(); i++) {
					BookshelfObject tmp_tile = library.get(new MatrixCoords(r, i));
					tiles.add(tmp_tile);
				}
				if(tiles.size() <= MAX_TAILS) {
					cont++;
				}
			}
			if(cont == ROWS_NEEDED) {
				isItCompleted=true;
				return 1;
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
	
	@Override
	public boolean getIsItCompleted() {
		// TODO Auto-generated method stub
		return isItCompleted;
	}

}
