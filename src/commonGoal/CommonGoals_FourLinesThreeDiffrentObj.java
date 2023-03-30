package commonGoal;

import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;

public class CommonGoals_FourLinesThreeDiffrentObj extends CommonGoal {

	@Override
	public int checkCommon(Bookshelf library) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		String desc="Four lines each formed by 5 tiles of\r\n"
				+ "maximum three different types. One\r\n"
				+ "line can show the same or a different\r\n"
				+ "combination of another line.";
		return desc;
	}

}
