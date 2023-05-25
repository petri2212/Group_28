package goal;

import java.awt.Image;

import myshelfie.Bookshelf;

public class Adjacent_object_tiles extends CommonGoal {

	@Override
	public int check(Bookshelf bookshelf) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		String desc="Groups of adjacent object tiles of the same type in\r\n"
				+ "your Library score points depending on how many tiles are connected.";
		return desc;
	}

}
