package goal.personal;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import goal.PersonalGoal;
import myshelfie.BookshelfObject;
import resource.Images;
import utils.MatrixCoords;

public class PersonalGoal6 extends PersonalGoal {

	@Override
	public Image getImage() {
		return Images.PERSONAL_GOAL_6.load();
	}

	@Override
	protected Map<MatrixCoords, BookshelfObject> initGoalObjects() {
		Map<MatrixCoords, BookshelfObject> map = new HashMap<>();
		map.put(new MatrixCoords(0, 2), BookshelfObject.TROPHY);
		map.put(new MatrixCoords(0, 4), BookshelfObject.CAT);
		map.put(new MatrixCoords(2, 3), BookshelfObject.BOOK);
		map.put(new MatrixCoords(4, 1), BookshelfObject.GAME);
		map.put(new MatrixCoords(4, 3), BookshelfObject.FRAME);
		map.put(new MatrixCoords(5, 0), BookshelfObject.PLANT);
		return map;
	}

}