package goal.common;

import java.awt.Image;

import goal.CommonGoal;
import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import resource.Images;
import utils.MatrixCoords;

public class CommonGoal_TwoLinesDiffrentObj extends CommonGoal {

	private static final int ROWS_NUMBER = 6;
	private static final int COLS_NUMBER = 5;
	private static final int ROWS_DIFERRENT = 2;

	@Override
	public Image getImage() {
		return Images.COMMON_GOAL_TWO_LINES_DIFFERENT_OBJ.load();
	}

	/**
	 * The player completes the Common goal if he creates two rows with the rule
	 * that all objects in a row must be different from each other.
	 *
	 * @param bookshelf the player bookshelf under validation
	 * @return 0 not completed the Common goal, 1 completed the Common Goal
	 */

	@Override
	public int check(Bookshelf library) {
		int cont = 0;
		int tmpCols = 1;
		int col = 0;

		for (int r = 0; r < ROWS_NUMBER; r++) {
			if (library.checkIfRowIsfull(r)) {
				for (int c = 0; c < COLS_NUMBER - 1; c++) {
					BookshelfObject tmpVar = library.get(new MatrixCoords(r, col));
					BookshelfObject next = library.get(new MatrixCoords(r, tmpCols));
					if (tmpVar != null && next != null) {
						if (tmpVar.name() != next.name()) {
							tmpCols++;
						} else {
							break;
						}
					}
				}
				if (tmpCols == COLS_NUMBER) {
					cont++;
				}
				tmpCols = 1;
			}
			if (cont >= ROWS_DIFERRENT) {
				return 1;
			}
		}
		return 0;
	}

	@Override
	public String getDescription() {
		String desc = "Two lines each formed by 5 different\r\n" + "types of tiles. One line can show the\r\n"
				+ "same or a different combination of the\r\n" + "other line.";
		return desc;
	}
}
