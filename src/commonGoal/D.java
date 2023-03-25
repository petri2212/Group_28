package commonGoal;

import myshelfie.BookshelfObject;

public class D implements CommonGoal {

	@Override
	public int Checkcommon(BookshelfObject[][] library) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void Description() {
		// TODO Auto-generated method stub
		System.out.println("Two groups each containing 4 tiles of\r\n"
				+ "the same type in a 2x2 square. The tiles\r\n"
				+ "of one square can be different from\r\n"
				+ "those of the other square.");
	}

}
