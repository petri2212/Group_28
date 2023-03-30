package commonGoal;

import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;

public class CommonGoals_threeColumns extends CommonGoal {

	@Override
	public int checkCommon(Bookshelf library) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		String desc="Three columns each formed by 6 tiles Five tiles of the same type forming an X.\r\n"
				+ "of maximum three different types. One\r\n"
				+ "column can show the same or a different\r\n"
				+ "combination of another column.";
		return desc;
	}
}
