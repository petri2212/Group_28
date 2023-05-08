package commonGoal;

import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import myshelfie.ResourceImage;

public class CommonGoal_TwoColumsSixDiffrentObj extends CommonGoal {
	
	@Override
	public ResourceImage getImage() {
		return ResourceImage.COMMON_GOAL_TWO_COLUMNS_SIX_DIFFERENT_OBJ;
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
