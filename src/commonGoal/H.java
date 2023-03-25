package commonGoal;

import myshelfie.BookshelfObject;

public class H implements CommonGoal {

	@Override
	public int Checkcommon(BookshelfObject[][] library) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void Description() {
		// TODO Auto-generated method stub
		System.out.println("Four lines each formed by 5 tiles of\r\n"
				+ "maximum three different types. One\r\n"
				+ "line can show the same or a different\r\n"
				+ "combination of another line.");
	}

}
