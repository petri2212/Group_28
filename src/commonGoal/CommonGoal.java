package commonGoal;

import myshelfie.Goal;

public abstract class CommonGoal implements Goal {

	protected String description;
	protected int goalReachedCounter;
	private boolean isItCompleted;

	public CommonGoal() {
		goalReachedCounter = 0;
	}

	public String getDescription() {
		return this.description;
	}

	/**
	 * This method is used to understand if the commongoal of a single player has been completed or not
	 *
	 * @return whether the state of the commongoal, true-->finisched, false -->not finisced

	 */
	public boolean getIsItCompleted() {
		return this.isItCompleted;
	}

}
