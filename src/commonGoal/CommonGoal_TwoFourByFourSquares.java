package commonGoal;

import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import myshelfie.ResourceImage;

public class CommonGoal_TwoFourByFourSquares extends CommonGoal {
	
	@Override
	public ResourceImage getImage() {
		return ResourceImage.COMMON_GOAL_TWO_FOUR_BY_FOUR_SQUARES;
	}

	@Override
	public int check( Bookshelf library) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getDescription() {
		String desc="Two groups each containing 4 tiles of\n"
				+ "the same type in a 2x2 square. The tiles\n"
				+ "of one square can be different from\n"
				+ "those of the other square.";

		return desc;
	}
}
