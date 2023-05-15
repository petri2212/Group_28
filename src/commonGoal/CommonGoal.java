package commonGoal;

import gui.DrawableObject;
import goal.Goal;

public abstract class CommonGoal implements Goal, DrawableObject {

	public CommonGoal() {
		
	}

	/**
	 * @return the common goal description
	 */
	public abstract String getDescription();
}
