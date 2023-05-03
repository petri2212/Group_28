package commonGoal;

import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import utils.MatrixCoords;

public class CommonGoal_SixSeparateGroupsOfTwoObj extends CommonGoal {
	
	private boolean forthRowfull = false;

	public CommonGoal_SixSeparateGroupsOfTwoObj() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int check(Bookshelf bookshelf) {
		// TODO Auto-generated method stub
		if(this.forthRowfull==false){
			this.forthRowfull=bookshelf.checkIfRowIsfull(4);
		}
		
		
		
		if(this.forthRowfull==true) {
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
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
