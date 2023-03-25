package commonGoal;

import myshelfie.BookshelfObject;

public class E implements CommonGoal{

	@Override
	public int Checkcommon(BookshelfObject[][] library) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void Description() {
		// TODO Auto-generated method stub
		System.out.println("Three columns each formed by 6 tiles Five tiles of the same type forming an X.\r\n"
				+ "of maximum three different types. One\r\n"
				+ "column can show the same or a different\r\n"
				+ "combination of another column.");
	}

}
