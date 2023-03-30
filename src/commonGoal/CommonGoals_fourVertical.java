package commonGoal;

import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;

public class CommonGoals_fourVertical extends CommonGoal {

	@Override
	public int checkCommon(Bookshelf library) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		String desc="Two groups each containing 4 tiles of\r\n"
				+ "the same type in a 2x2 square. The tiles\r\n"
				+ "of one square can be different from\r\n"
				+ "those of the other square.";
		return desc;
	}
}
