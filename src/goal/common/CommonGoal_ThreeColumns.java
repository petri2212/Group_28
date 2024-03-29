package goal.common;

import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import resource.Images;
import utils.MatrixCoords;

import java.awt.Image;
import java.util.ArrayList;

import goal.CommonGoal;

public class CommonGoal_ThreeColumns extends CommonGoal {

	private final int MAX_DIFFERENT_OBJECTS = 3;
	private final int MAX_VALID_COLUMNS = 3;

	@Override
	public Image getImage() {
		return Images.COMMON_GOAL_THREE_COLUMNS.load();
	}

	/**
	 * This method runs trough every column and parse all the rows. If the cell in
	 * validation contains an object that has never been stored, it is saved in a
	 * list. After the last row is validated, the algorithm checks if the number of
	 * object stored is maximum 3. If this is the case a counter is increased and
	 * the algorithm clears the list of saved objects and proceeds to the next
	 * column. Once the entire bookshelf is parsed, if the number of valid columns
	 * of maximum three different objects is 3 than the point is given.
	 *
	 * @param bookshelf the player bookshelf under validation
	 * @return 0 not completed the Common goal, 1 completed the Common Goal
	 */
	@Override
	public int check(Bookshelf bookshelf) {
		int validColsCount = 0;
		ArrayList<BookshelfObject> objects = new ArrayList<BookshelfObject>();

		for (int c = 0; c < bookshelf.getCols(); c++) {
			for (int r = 0; r < bookshelf.getRows(); r++) {
				BookshelfObject object = bookshelf.get(new MatrixCoords(r, c));

				if (!objects.contains(object)) {
					objects.add(object);
				}
			}

			if (objects.size() <= MAX_DIFFERENT_OBJECTS) {
				validColsCount++;
			}

			objects.clear();
		}

		if (validColsCount == MAX_VALID_COLUMNS) {
			return 1;
		}
		return 0;
	}

	@Override
	public String getDescription() {
		return "Three columns each formed by 6 tiles\n" + "of maximum three different types. One\n"
				+ "column can show the same or a different\n" + "combination of another column.";
	}
}
