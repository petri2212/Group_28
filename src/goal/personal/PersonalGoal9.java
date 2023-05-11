package goal.personal;

import java.util.HashMap;
import java.util.Map;

import goal.PersonalGoal;
import myshelfie.BookshelfObject;
import myshelfie.ResourceImage;
import utils.MatrixCoords;

public class PersonalGoal9 extends PersonalGoal {

	@Override
	public ResourceImage getImage() {
		return ResourceImage.PERSONAL_GOAL_9;
	}

	@Override
	protected Map<MatrixCoords, BookshelfObject> initGoalObjects() {
		Map<MatrixCoords, BookshelfObject> map = new HashMap<>();
		map.put(new MatrixCoords(0, 2), BookshelfObject.GAME);
		map.put(new MatrixCoords(2, 2), BookshelfObject.CAT);
		map.put(new MatrixCoords(3, 4), BookshelfObject.BOOK);
		map.put(new MatrixCoords(4, 1), BookshelfObject.TROPHY);
		map.put(new MatrixCoords(4, 4), BookshelfObject.PLANT);
		map.put(new MatrixCoords(5, 0), BookshelfObject.FRAME);
		return map;
	}

}