package commonGoal;

import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;

public class CommonGoal_TwoFourByFourSquares extends CommonGoal {
	
	private boolean isItCompleted=false;

	public CommonGoal_TwoFourByFourSquares() {
	}

	@Override
	public int check( Bookshelf library) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		String desc="Four groups each containing at least\r\n"
				+ "4 tiles of the same type (not necessarily\r\n"
				+ "in the depicted shape).\r\n"
				+ "The tiles of one group can be different\r\n"
				+ "from those of another group.";
		return desc;
	}
	@Override
	public boolean getIsItCompleted() {
		// TODO Auto-generated method stub
		return isItCompleted;
	}
	

}
