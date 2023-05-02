package commonGoal;

import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import utils.MatrixCoords;

import java.util.ArrayList;

public class CommonGoal_ThreeColumns extends CommonGoal {

	private final int MAX_DIFFERENT_OBJECTS = 3;
	private final int MAX_VALID_COLUMNS = 3;

	public CommonGoal_ThreeColumns() {
		description = "Three columns each formed by 6 tiles\n"
				+ "of maximum three different types. One\n"
				+ "column can show the same or a different\n"
				+ "combination of another column.";
	}

	/**
	 * Returns the points for this common goal if the player has successfully achieved it.
	 * This method runs trough every column and parse all the rows. If the cell in validation
	 * contains an object that has never been stored, it is saved in a list.
	 * After the last row is validated, the algorithm checks if the number of object stored
	 * is maximum 3. If this is the case a counter is increased and the algorithm clears the
	 * list of saved objects and proceeds to the next column.
	 * Once the entire bookshelf is parsed, if the number of valid columns of maximum three
	 * different objects is 3 than the point is given.
	 *
	 * @param bookshelf the player bookshelf under validation
	 * @return 	  		the number of points gained from the goal check
	 */
	@Override
	public int check(Bookshelf bookshelf) {
		int validColsCount = 0;
		ArrayList<BookshelfObject> objects = new ArrayList<BookshelfObject>();

		for(int c = 0; c < bookshelf.getCols(); c++) {
			for(int r = 0; r < bookshelf.getRows(); r++) {
				BookshelfObject object = bookshelf.get(new MatrixCoords(r, c));

				if(!objects.contains(object)) {
					objects.add(object);
				}
			}

			if(objects.size() <= MAX_DIFFERENT_OBJECTS) {
				validColsCount++;
			}

			objects.clear();
		}

		return (validColsCount == MAX_VALID_COLUMNS) ? getPoints() : 0;
	}
}
