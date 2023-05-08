package commonGoal;

import gui.DrawableObject;
import myshelfie.Goal;

public abstract class CommonGoal implements Goal, DrawableObject {

	protected int goalReachedCounter;
	private boolean isItCompleted;

	public CommonGoal() {
		goalReachedCounter = 0;
	}

	/**
	 * @return the common goal description
	 */
	public abstract String getDescription();

	/**
	 * This method is used to understand if the commongoal of a single player has been completed or not
	 *
	 * @return whether the state of the commongoal, true-->finisched, false -->not finisced

	 */
	public boolean getIsItCompleted() {
		return this.isItCompleted;
	}

}
