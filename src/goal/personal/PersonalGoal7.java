package goal.personal;

import java.util.HashMap;
import java.util.Map;

import goal.PersonalGoal;
import myshelfie.BookshelfObject;
import myshelfie.ResourceImage;
import utils.MatrixCoords;

public class PersonalGoal7 extends PersonalGoal {

	@Override
	public ResourceImage getImage() {
		return ResourceImage.PERSONAL_GOAL_7;
	}

	@Override
	protected Map<MatrixCoords, BookshelfObject> initGoalObjects() {
		Map<MatrixCoords, BookshelfObject> map = new HashMap<>();
		map.put(new MatrixCoords(0, 0), BookshelfObject.CAT);
		map.put(new MatrixCoords(1, 3), BookshelfObject.FRAME);
		map.put(new MatrixCoords(2, 1), BookshelfObject.PLANT);
		map.put(new MatrixCoords(3, 0), BookshelfObject.TROPHY);
		map.put(new MatrixCoords(4, 4), BookshelfObject.GAME);
		map.put(new MatrixCoords(5, 2), BookshelfObject.BOOK);
		return map;
	}

}