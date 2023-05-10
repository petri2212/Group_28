package goal.personal;

import java.util.HashMap;
import java.util.Map;

import goal.PersonalGoal;
import myshelfie.BookshelfObject;
import myshelfie.ResourceImage;
import utils.MatrixCoords;

public class PersonalGoal3 extends PersonalGoal {

	@Override
	public ResourceImage getImage() {
		return ResourceImage.PERSONAL_GOAL_3;
	}

	@Override
	protected Map<MatrixCoords, BookshelfObject> initGoalObjects() {
		Map<MatrixCoords, BookshelfObject> map = new HashMap<>();
		map.put(new MatrixCoords(1, 0), BookshelfObject.FRAME);
		map.put(new MatrixCoords(1, 3), BookshelfObject.GAME);
		map.put(new MatrixCoords(2, 2), BookshelfObject.PLANT);
		map.put(new MatrixCoords(3, 1), BookshelfObject.CAT);
		map.put(new MatrixCoords(3, 4), BookshelfObject.TROPHY);
		map.put(new MatrixCoords(5, 0), BookshelfObject.BOOK);
		return map;
	}

}