package goal.common;

import java.awt.Image;
import java.util.HashSet;
import java.util.Set;

import goal.CommonGoal;
import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import resource.Images;
import utils.MatrixCoords;

public class CommonGoal_TwoColumsSixDiffrentObj extends CommonGoal {

	private static final int MIN_COL_NUMBER = 2;

	@Override
	public Image getImage() {
		return Images.COMMON_GOAL_TWO_COLUMNS_SIX_DIFFERENT_OBJ.load();
	}

	/**
	 * The player completes the Common goal if he creates two columns with the rule
	 * that all objects in a column must be different from each other.
	 *
	 * @param bookshelf the player bookshelf under validation
	 * @return 0 not completed the Common goal, 1 completed the Common Goal
	 */

	@Override
	public int check(Bookshelf library) {
		int colsWithDifferentObj = 0;
		for (int c = 0; c < library.getCols(); c++) {
			Set<BookshelfObject> columnObjects = new HashSet<>();
			for (int r = 0; r < library.getRows(); r++) {
				BookshelfObject obj = library.get(new MatrixCoords(r, c));

				if (!columnObjects.add(obj)) {
					break;
				}
			}
			if (columnObjects.size() == 6) {
				colsWithDifferentObj++;
			}
		}
		if (colsWithDifferentObj >= MIN_COL_NUMBER) {
			return 1;
		} else {
			return 0;
		}

	}

	@Override
	public String getDescription() {
		String desc = "Two columns each formed by 6\r\ndifferent types of tiles.";
		return desc;
	}

}
