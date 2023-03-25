package commonGoal;

import myshelfie.BookshelfObject;

public class A implements CommonGoal {

	@Override
	public int Checkcommon( BookshelfObject[][] library) {
		
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void Description() {
		// TODO Auto-generated method stub
		System.out.println("Six groups each containing at least\r\n"
				+ "2 tiles of the same type (not necessarily\r\n"
				+ "in the depicted shape).\r\n"
				+ "The tiles of one group can be different\r\n"
				+ "from those of another group.");
	}

	
	

}
