package goal.common;

import java.awt.Image;

import goal.CommonGoal;
import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import resource.Images;
import utils.MatrixCoords;

public class CommonGoal_Diagonal extends CommonGoal {

	private static final int FRIST_COL_OR_ROW = 0;
	private static final int SECOND_COL = 4;
	private static final int SECOND_ROW = 1;
	private static final int DIAGONAL_LENGHT = 5;

	@Override
	public Image getImage() {
		return Images.COMMON_GOAL_DIAGOONAL.load();
	}

	/**
	 * This method checks that the player has formed a diagonal in any direction
	 * with identical cards
	 *
	 * @param library the player bookshelf under validation
	 * @return 0 not completed the Common goal, 1 completed the Common Goal
	 */

	@Override
	public int check(Bookshelf library) {

		/*
		 * This CommonGoal has only four possible tile to start from, because two of
		 * them start form bottom left and end top right and the other two start from
		 * bottom right and end top left.
		 */

		boolean value = false;
		BookshelfObject next;
		int r = 0;
		int c = 0;

		BookshelfObject downLeft = library.get(new MatrixCoords(FRIST_COL_OR_ROW, FRIST_COL_OR_ROW));
		BookshelfObject upLeft = library.get(new MatrixCoords(SECOND_ROW, FRIST_COL_OR_ROW));
		BookshelfObject downRight = library.get(new MatrixCoords(FRIST_COL_OR_ROW, SECOND_COL));
		BookshelfObject upRight = library.get(new MatrixCoords(SECOND_ROW, SECOND_COL));

		if (downLeft != null) {
			r = FRIST_COL_OR_ROW;
			c = FRIST_COL_OR_ROW;
			for (int i = 1; i < DIAGONAL_LENGHT; i++) {

				next = library.get(new MatrixCoords(r + i, c + i));
				if (next != null) {
					if (downLeft.name() != next.name()) {
						value = false;
						break;
					} else {
						value = true;
					}
				} else {
					value = false;
					break;
				}
			}
			if (value) {
				return 1;
			}

		}

		if (upLeft != null) {
			r = SECOND_ROW;
			c = FRIST_COL_OR_ROW;
			for (int i = 1; i < DIAGONAL_LENGHT; i++) {

				next = library.get(new MatrixCoords(r + i, c + i));

				if (next != null) {
					if (upLeft.name() != next.name()) {
						value = false;
						break;
					} else {
						value = true;
					}
				} else {
					value = false;
					break;
				}
			}

			if (value) {
				return 1;
			}

		}

		if (downRight != null) {
			r = FRIST_COL_OR_ROW;
			c = SECOND_COL;
			for (int i = 1; i < DIAGONAL_LENGHT; i++) {

				next = library.get(new MatrixCoords(r + i, c - i));

				if (next != null) {
					if (downRight.name() != next.name()) {
						value = false;
						break;
					} else {
						value = true;
					}
				} else {
					value = false;
					break;
				}
			}
			if (value) {
				return 1;
			}

		}

		if (upRight != null) {
			r = SECOND_ROW;
			c = SECOND_COL;
			for (int i = 1; i < DIAGONAL_LENGHT; i++) {

				next = library.get(new MatrixCoords(r + i, c - i));

				if (next != null) {
					if (upRight.name() != next.name()) {
						value = false;
						break;
					} else {
						value = true;
					}
				} else {
					value = false;
					break;
				}
			}
			if (value) {
				return 1;
			}

		}

		return 0;
	}

	@Override
	public String getDescription() {
		String desc = "Five tiles of the same type forming a\r\n" + "diagonal.";
		return desc;
	}
}
