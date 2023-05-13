package goal.personal;

import java.util.HashMap;
import java.util.Map;

import goal.PersonalGoal;
import myshelfie.BookshelfObject;
import resource.Images;
import utils.MatrixCoords;

public class PersonalGoal5 extends PersonalGoal {

	@Override
	public Images getImage() {
		return Images.PERSONAL_GOAL_5;
	}

	@Override
	protected Map<MatrixCoords, BookshelfObject> initGoalObjects() {
		Map<MatrixCoords, BookshelfObject> map = new HashMap<>();
		map.put(new MatrixCoords(1, 1), BookshelfObject.TROPHY);
		map.put(new MatrixCoords(3, 1), BookshelfObject.FRAME);
		map.put(new MatrixCoords(3, 2), BookshelfObject.BOOK);
		map.put(new MatrixCoords(4, 4), BookshelfObject.PLANT);
		map.put(new MatrixCoords(5, 0), BookshelfObject.GAME);
		map.put(new MatrixCoords(5, 3), BookshelfObject.CAT);
		return map;
	}

}