package commonGoal;

import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;

public class CommonGoals_Diagonal extends CommonGoal{

	@Override
	public int checkCommon(Bookshelf library) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		String desc="Five tiles of the same type forming a\r\n"
				+ "diagonal.";
		return desc;
	}

}
