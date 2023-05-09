package commonGoal;

import gui.DrawableObject;
import myshelfie.Goal;

public abstract class CommonGoal implements Goal, DrawableObject {

	protected int goalReachedCounter;
	
	public CommonGoal() {
		goalReachedCounter = 0;
	}

	/**
	 * @return the common goal description
	 */
	public abstract String getDescription();
}
