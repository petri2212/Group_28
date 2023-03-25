package commonGoal;

import myshelfie.BookshelfObject;

public class G implements CommonGoal{

	@Override
	public int Checkcommon(BookshelfObject[][] library) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void Description() {
		// TODO Auto-generated method stub
		System.out.println("Five tiles of the same type forming a\r\n"
				+ "diagonal.");
	}

}
