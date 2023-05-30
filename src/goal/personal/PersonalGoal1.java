package goal.personal;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import goal.PersonalGoal;
import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import myshelfie.Player;
import resource.Images;
import utils.MatrixCoords;

public class PersonalGoal1 extends PersonalGoal {

	@Override
	public Image getImage() {
		return Images.PERSONAL_GOAL_1.load();
	}
	
	public Map<MatrixCoords, BookshelfObject> getMap(){
		return initGoalObjects();
	}

	@Override
	protected Map<MatrixCoords, BookshelfObject> initGoalObjects() {
		Map<MatrixCoords, BookshelfObject> map = new HashMap<>();
		map.put(new MatrixCoords(5, 0), BookshelfObject.PLANT);
		map.put(new MatrixCoords(5, 2), BookshelfObject.FRAME);
		map.put(new MatrixCoords(4, 4), BookshelfObject.CAT);
		map.put(new MatrixCoords(3, 3), BookshelfObject.BOOK);
		map.put(new MatrixCoords(2, 1), BookshelfObject.GAME);
		map.put(new MatrixCoords(0, 2), BookshelfObject.TROPHY);
		return map;
	}

}