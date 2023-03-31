package commonGoal;

import myshelfie.Bookshelf;

public abstract class CommonGoal {
	
	protected String description;
	
	public abstract int checkCommon(Bookshelf library);
	
	public String getDescription() {
		
		return this.description;
	}
}
