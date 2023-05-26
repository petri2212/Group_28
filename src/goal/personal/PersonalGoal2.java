package goal.personal;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import goal.PersonalGoal;
import myshelfie.BookshelfObject;
import resource.Images;
import utils.MatrixCoords;

public class PersonalGoal2 extends PersonalGoal {

	@Override
	public Image getImage() {
		return Images.PERSONAL_GOAL_2.load();
	}
	
	public Map<MatrixCoords, BookshelfObject> getMap(){
		return initGoalObjects();
	}

	@Override
	protected Map<MatrixCoords, BookshelfObject> initGoalObjects() {
		Map<MatrixCoords, BookshelfObject> map = new HashMap<>();
		map.put(new MatrixCoords(1, 1), BookshelfObject.PLANT);
		map.put(new MatrixCoords(2, 0), BookshelfObject.CAT);
		map.put(new MatrixCoords(2, 2), BookshelfObject.GAME);
		map.put(new MatrixCoords(3, 4), BookshelfObject.BOOK);
		map.put(new MatrixCoords(4, 3), BookshelfObject.TROPHY);
		map.put(new MatrixCoords(5, 4), BookshelfObject.FRAME);
		return map;
	}

}