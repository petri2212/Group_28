package goal;

import java.util.Map;

import gui.DrawableObject;
import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import utils.MatrixCoords;

public abstract class PersonalGoal implements Goal, DrawableObject {

	private Map<MatrixCoords, BookshelfObject> goalObjects;

	public PersonalGoal() {
		goalObjects = initGoalObjects();
	}

	/**
	 * Creates a map of coordinates and objects that represents the goal objectives
	 * to achieve in the player Bookshelf.
	 *
	 * @return
	 */
	protected abstract Map<MatrixCoords, BookshelfObject> initGoalObjects();

	@Override
	public int check(Bookshelf bookshelf) {
		int cont = 0;

		for (Map.Entry<MatrixCoords, BookshelfObject> item : this.goalObjects.entrySet()) {
			BookshelfObject bookshelfObject = bookshelf.get(item.getKey());
			BookshelfObject goalObject = item.getValue();

			if (bookshelfObject == goalObject) {
				cont++;
			}
		}

		int points = 0;
		switch (cont) {

		case 0:
			points = 0;
			break;
		case 1:
			points = cont;
			break;
		case 2:
			points = cont;
			break;
		case 3:
			points = cont + 1;
			break;
		case 4:
			points = cont + 2;
			break;
		case 5:
			points = cont + 4;
			break;
		case 6:
			points = cont + 6;
			break;
		}
		return points;
	}

}