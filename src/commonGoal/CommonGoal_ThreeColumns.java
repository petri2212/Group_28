package commonGoal;

import myshelfie.Bookshelf;

public class CommonGoal_ThreeColumns extends CommonGoal {

	public CommonGoal_ThreeColumns(int playersNumber) {
		super(playersNumber);
		description = "Three columns each formed by 6 tiles\n"
				+ "of maximum three different types. One\n"
				+ "column can show the same or a different\n"
				+ "combination of another column.";
	}

	@Override
	public int check(Bookshelf bookshelf) {
		// TODO Auto-generated method stub
		return 0;
	}
}
