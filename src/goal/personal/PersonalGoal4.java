package goal.personal;

import java.util.HashMap;
import java.util.Map;

import goal.PersonalGoal;
import myshelfie.BookshelfObject;
import myshelfie.ResourceImage;
import utils.MatrixCoords;

public class PersonalGoal4 extends PersonalGoal {

	@Override
	public ResourceImage getImage() {
		return ResourceImage.PERSONAL_GOAL_4;
	}

	@Override
	protected Map<MatrixCoords, BookshelfObject> initGoalObjects() {
		Map<MatrixCoords, BookshelfObject> map = new HashMap<>();
		map.put(new MatrixCoords(0, 4), BookshelfObject.GAME);
		map.put(new MatrixCoords(2, 0), BookshelfObject.TROPHY);
		map.put(new MatrixCoords(2, 2), BookshelfObject.FRAME);
		map.put(new MatrixCoords(3, 3), BookshelfObject.PLANT);
		map.put(new MatrixCoords(4, 1), BookshelfObject.BOOK);
		map.put(new MatrixCoords(4, 2), BookshelfObject.CAT);
		return map;
	}

}