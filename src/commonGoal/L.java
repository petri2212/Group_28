package commonGoal;

import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;

public class L extends CommonGoal{

	@Override
	public int checkCommon(Bookshelf library) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		String desc="Two lines each formed by 5 different\r\n"
				+ "types of tiles. One line can show the\r\n"
				+ "same or a different combination of the\r\n"
				+ "other line.";
		return desc;
	}

}
