package commonGoal;

import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;

public class CommonGoal_TwoLinesDiffrentObj extends CommonGoal{

	protected CommonGoal_TwoLinesDiffrentObj(int playersNumber) {
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
		String desc="Two lines each formed by 5 different\r\n"
				+ "types of tiles. One line can show the\r\n"
				+ "same or a different combination of the\r\n"
				+ "other line.";
		return desc;
	}

}
