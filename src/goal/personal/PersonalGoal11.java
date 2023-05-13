package goal.personal;

import java.util.HashMap;
import java.util.Map;

import goal.PersonalGoal;
import myshelfie.BookshelfObject;
import resource.Images;
import utils.MatrixCoords;

public class PersonalGoal11 extends PersonalGoal {

	@Override
	public Images getImage() {
		return Images.PERSONAL_GOAL_11;
	}

	@Override
	protected Map<MatrixCoords, BookshelfObject> initGoalObjects() {
		Map<MatrixCoords, BookshelfObject> map = new HashMap<>();
		map.put(new MatrixCoords(0, 4), BookshelfObject.TROPHY);
		map.put(new MatrixCoords(1, 1), BookshelfObject.GAME);
		map.put(new MatrixCoords(2, 0), BookshelfObject.BOOK);
		map.put(new MatrixCoords(3, 3), BookshelfObject.CAT);
		map.put(new MatrixCoords(4, 1), BookshelfObject.FRAME);
		map.put(new MatrixCoords(5, 3), BookshelfObject.PLANT);
		return map;
	}

}