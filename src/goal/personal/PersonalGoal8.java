package goal.personal;

import java.util.HashMap;
import java.util.Map;

import goal.PersonalGoal;
import myshelfie.BookshelfObject;
import resource.Images;
import utils.MatrixCoords;

public class PersonalGoal8 extends PersonalGoal {

	@Override
	public Images getImage() {
		return Images.PERSONAL_GOAL_8;
	}

	@Override
	protected Map<MatrixCoords, BookshelfObject> initGoalObjects() {
		Map<MatrixCoords, BookshelfObject> map = new HashMap<>();
		map.put(new MatrixCoords(0, 4), BookshelfObject.FRAME);
		map.put(new MatrixCoords(1, 1), BookshelfObject.CAT);
		map.put(new MatrixCoords(2, 2), BookshelfObject.TROPHY);
		map.put(new MatrixCoords(3, 0), BookshelfObject.PLANT);
		map.put(new MatrixCoords(4, 3), BookshelfObject.BOOK);
		map.put(new MatrixCoords(5, 3), BookshelfObject.GAME);
		return map;
	}

}