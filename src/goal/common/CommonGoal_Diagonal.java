package goal.common;

import java.awt.Image;
import java.util.ArrayList;

import goal.CommonGoal;
import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import resource.Images;
import utils.MatrixCoords;

public class CommonGoal_Diagonal extends CommonGoal{

	private static final int FRIST_COL_OR_ROW = 0;
	private static final int SECOND_COL = 4;
	private static final int SECOND_ROW = 1;
	private static final int DIAGONAL_LENGHT = 5;

	@Override
	public Image getImage() {
		return Images.COMMON_GOAL_DIAGOONAL.load();
	}

	@Override
	public int check(Bookshelf library) {
		
		/*This CommonGoal has only four possible tile to start from, because
		 *two of them start form bottom left and end top right and the other two
		 *start from bottom right and end top left. 
		 * */		
		if(library.fullCol(FRIST_COL_OR_ROW) || library.fullCol(SECOND_ROW)) {
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
			int donwleft_diagonal_position = 1;
			int upLeft_diagonal_position = 2;
			int donwright_diagonal_position = 3;
			boolean value = false;
			
			for(int y = 0; y < tiles.size(); y++) {
				if(y < upLeft_diagonal_position) {
					if(y == donwleft_diagonal_position) {
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
					if(y == donwright_diagonal_position) {
						r = SECOND_ROW;
					}
					BookshelfObject start = tiles.get(y);
					/*in he for down below we initialize the i at 1 because
					 * we need use that as the number to add from rows and to subtract from columns 
					 * */
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
					return 1;
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
