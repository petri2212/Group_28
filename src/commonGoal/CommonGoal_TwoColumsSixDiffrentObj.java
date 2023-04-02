package commonGoal;

import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;

public class CommonGoal_TwoColumsSixDiffrentObj extends CommonGoal {

	protected CommonGoal_TwoColumsSixDiffrentObj(int playersNumber) {
		super(playersNumber);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int check(Bookshelf library) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		String desc="Two columns each formed by 6\r\n"
				+ "different types of tiles.";
		return desc;
	}

}
