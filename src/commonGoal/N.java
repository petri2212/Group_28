package commonGoal;

import myshelfie.BookshelfObject;

public class N implements CommonGoal {

	@Override
	public int Checkcommon(BookshelfObject[][] library) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void Description() {
		// TODO Auto-generated method stub
		System.out.println("Five columns of increasing or decreasing\r\n"
				+ "height. Starting from the first column on\r\n"
				+ "the left or on the right, each next column\r\n"
				+ "must be made of exactly one more tile.\r\n"
				+ "Tiles can be of any type. ");
	}

}
