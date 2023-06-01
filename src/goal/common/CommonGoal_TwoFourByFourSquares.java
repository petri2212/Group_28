package goal.common;

import myshelfie.Bookshelf;

import java.awt.Image;
import java.util.ArrayList;

import goal.CommonGoal;
import myshelfie.BookshelfObject;
import resource.Images;
import utils.*;

public class CommonGoal_TwoFourByFourSquares extends CommonGoal {

	@Override
	public Image getImage() {
		return Images.COMMON_GOAL_TWO_FOUR_BY_FOUR_SQUARES.load();
	}

	/**
	 * The player completes the common goal if the created bookshelf contains two
	 * groups of 4 equal tiles forming a square, the method saves the positions of
	 * the current square, if the array contains 8 or more elements then it means it
	 * has at least 2 squares .
	 *
	 * @param bookshelf the player bookshelf under validation
	 * @return 0 not completed the Common goal, 1 completed the Common Goal
	 */

	@Override
	public int check(Bookshelf bookshelf) {
		int cont = 0;
		ArrayList<MatrixCoords> CoordsUsed = new ArrayList<>();
		for (int row = 5; row > bookshelf.getRows() - 6; row--) {
			for (int col = 0; col < bookshelf.getCols() - 2; col++) {
				int CURRENT_COLLUMN = col;
				int UPPER_ROW = row - 1;
				int ADIACENT_COLLUMN_RIGHT = col + 1;
				int CURRENT_ROW = row;

				BookshelfObject objCornerLeftDown = bookshelf.get(new MatrixCoords(CURRENT_ROW, CURRENT_COLLUMN));
				BookshelfObject objCornerLefttUp = bookshelf.get(new MatrixCoords(UPPER_ROW, CURRENT_COLLUMN));
				BookshelfObject objCornerRightDown = bookshelf
						.get(new MatrixCoords(CURRENT_ROW, ADIACENT_COLLUMN_RIGHT));
				BookshelfObject objCornerRightUp = bookshelf.get(new MatrixCoords(UPPER_ROW, ADIACENT_COLLUMN_RIGHT));

				if (objCornerLeftDown != null && objCornerLefttUp != null && objCornerRightDown != null
						&& objCornerRightUp != null) {

					if (objCornerLeftDown.name() == objCornerLefttUp.name()
							&& objCornerRightDown.name() == objCornerRightUp.name()
							&& objCornerLeftDown.name() == objCornerRightUp.name()) {
						if (CoordsUsed.isEmpty()) {
							CoordsUsed.add(new MatrixCoords(CURRENT_ROW, CURRENT_COLLUMN));
							CoordsUsed.add(new MatrixCoords(UPPER_ROW, CURRENT_COLLUMN));
							CoordsUsed.add(new MatrixCoords(CURRENT_ROW, ADIACENT_COLLUMN_RIGHT));
							CoordsUsed.add(new MatrixCoords(UPPER_ROW, ADIACENT_COLLUMN_RIGHT));
						} else {
							for (MatrixCoords posUsed : CoordsUsed) {
								if (posUsed.equals(new MatrixCoords(CURRENT_ROW, CURRENT_COLLUMN)) != true
										&& posUsed.equals(new MatrixCoords(UPPER_ROW, CURRENT_COLLUMN)) != true
										&& posUsed.equals(new MatrixCoords(CURRENT_ROW, ADIACENT_COLLUMN_RIGHT)) != true
										&& posUsed
												.equals(new MatrixCoords(UPPER_ROW, ADIACENT_COLLUMN_RIGHT)) != true) {
									cont = 1;
								} else {
									cont = 0;
									;
								}
							}
							if (cont == 1) {
								CoordsUsed.add(new MatrixCoords(CURRENT_ROW, CURRENT_COLLUMN));
								CoordsUsed.add(new MatrixCoords(UPPER_ROW, CURRENT_COLLUMN));
								CoordsUsed.add(new MatrixCoords(CURRENT_ROW, ADIACENT_COLLUMN_RIGHT));
								CoordsUsed.add(new MatrixCoords(UPPER_ROW, ADIACENT_COLLUMN_RIGHT));
							}
							cont = 0;
						}
					}
				}
			}
		}
		if (CoordsUsed.size() >= 8) {
			return 1;

		} else {
			return 0;
		}
	}

	@Override
	public String getDescription() {
		String desc = "Two groups each containing 4 tiles of\n" + "the same type in a 2x2 square. The tiles\n"
				+ "of one square can be different from\n" + "those of the other square.";

		return desc;
	}
}
