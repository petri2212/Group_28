package goal.personal;

import java.util.HashMap;
import java.util.Map;

import goal.PersonalGoal;
import myshelfie.BookshelfObject;
import resource.Images;
import utils.MatrixCoords;

public class PersonalGoal1 extends PersonalGoal {

	@Override
	public Images getImage() {
		return Images.PERSONAL_GOAL_1;
	}

	@Override
	protected Map<MatrixCoords, BookshelfObject> initGoalObjects() {
		Map<MatrixCoords, BookshelfObject> map = new HashMap<>();
		map.put(new MatrixCoords(0, 0), BookshelfObject.PLANT);
		map.put(new MatrixCoords(0, 2), BookshelfObject.FRAME);
		map.put(new MatrixCoords(1, 4), BookshelfObject.CAT);
		map.put(new MatrixCoords(2, 3), BookshelfObject.BOOK);
		map.put(new MatrixCoords(3, 1), BookshelfObject.GAME);
		map.put(new MatrixCoords(5, 2), BookshelfObject.TROPHY);
		return map;
	}

}