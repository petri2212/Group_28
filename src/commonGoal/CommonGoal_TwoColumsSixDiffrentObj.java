package commonGoal;

import java.util.HashSet;
import java.util.Set;

import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import myshelfie.ResourceImage;
import utils.MatrixCoords;

public class CommonGoal_TwoColumsSixDiffrentObj extends CommonGoal {

	private static final int MIN_COL_NUMBER = 2;

	@Override
	public String getDescription() {
		String desc = "Two columns each formed by 6\r\ndifferent types of tiles.";
		return desc;
	}

	@Override
	public ResourceImage getImage() {
		return ResourceImage.COMMON_GOAL_TWO_COLUMNS_SIX_DIFFERENT_OBJ;
	}

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

			colsWithDifferentObj++;
		}

		if (colsWithDifferentObj >= MIN_COL_NUMBER) {
			return 1;
		} else {
			return 0;
		}

	}

}
