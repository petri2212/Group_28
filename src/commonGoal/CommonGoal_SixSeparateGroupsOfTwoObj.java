package commonGoal;

import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;

public class CommonGoal_SixSeparateGroupsOfTwoObj extends CommonGoal {

	public CommonGoal_SixSeparateGroupsOfTwoObj() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int check( Bookshelf library) {
		
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		String desc="Six groups each containing at least\r\n"
				+ "2 tiles of the same type (not necessarily\r\n"
				+ "in the depicted shape).\r\n"
				+ "The tiles of one group can be different\r\n"
				+ "from those of another group.";
		return desc;
	}

	
	

}
