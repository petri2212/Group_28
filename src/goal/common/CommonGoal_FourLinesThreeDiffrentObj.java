package goal.common;

import java.awt.Image;
import java.util.HashSet;

import goal.CommonGoal;
import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import resource.Images;
import utils.MatrixCoords;

public class CommonGoal_FourLinesThreeDiffrentObj extends CommonGoal {

	private static final int ROWS_NEEDED = 4;
	private static final int MAX_TAILS = 3;

	@Override
	public Image getImage() {
		return Images.COMMON_GOAL_FOUR_LINES_THREE_DIFFERENT_OBJ.load();
	}

	/**
	 * To receive the points for this goal, the player must form 4 lines of 5 tiles
	 * with up to 3 different types of objects
	 *
	 * @param bookshelf the player bookshelf under validation
	 * @return 0 not completed the Common goal, 1 completed the Common Goal
	 */

	@Override
	public int check(Bookshelf library) {

		int cont = 0;

		for (int r = 0; r < library.getRows(); r++) {
			if (library.checkIfRowIsfull(r)) {
				HashSet<BookshelfObject> tiles = new HashSet<BookshelfObject>();

				for (int i = 0; i < library.getCols(); i++) {
					BookshelfObject tmp_tile = library.get(new MatrixCoords(r, i));
					tiles.add(tmp_tile);
				}
				if (tiles.size() <= MAX_TAILS) {
					cont++;
				}
			}
			if (cont == ROWS_NEEDED) {
				return 1;
			}
		}
		return 0;
	}

	@Override
	public String getDescription() {
		String desc = "Four lines each formed by 5 tiles of\r\n" + "maximum three different types. One\r\n"
				+ "line can show the same or a different\r\n" + "combination of another line.";
		return desc;
	}
}
