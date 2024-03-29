package goal.common;

import java.awt.Image;

import goal.CommonGoal;
import myshelfie.Bookshelf;

import myshelfie.BookshelfObject;
import resource.Images;
import utils.MatrixCoords;

public class CommonGoal_Corners extends CommonGoal {

	@Override
	public Image getImage() {
		return Images.COMMON_GOAL_CORNERS.load();
	}

	/**
	 * This method takes the four objects in the corners of the library and checks
	 * that they are all the same.
	 *
	 * @param bookshelf the player bookshelf under validation
	 * @return 0 not completed the Common goal, 1 completed the Common Goal
	 */

	@Override
	public int check(Bookshelf bookshelf) {
		BookshelfObject object0 = bookshelf.get(new MatrixCoords(0, 0));
		BookshelfObject object1 = bookshelf.get(new MatrixCoords(0, 4));
		BookshelfObject object2 = bookshelf.get(new MatrixCoords(5, 0));
		BookshelfObject object3 = bookshelf.get(new MatrixCoords(5, 4));

		if (object0 != null && object1 != null && object2 != null && object3 != null) {

			if (object0.name() == object1.name() && object1.name() == object2.name()
					&& object2.name() == object3.name()) {
				return 1;
			}
		}
		return 0;
	}

	@Override
	public String getDescription() {
		String desc = "Four tiles of the same type in the four\r\n" + "corners of the bookshelf.";
		return desc;
	}
}
