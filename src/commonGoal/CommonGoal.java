package commonGoal;

import myshelfie.Goal;

public abstract class CommonGoal implements Goal {

	protected String description;
	protected int goalReachedCounter;

	public CommonGoal() {
		goalReachedCounter = 0;
	}

	public String getDescription() {
		return this.description;
	}

	/**
	 * Returns the points gained from the achievement of the checked goal.
	 * The points vary in base of how many players have already achieved this goal.
	 *
	 * @return the number of points gained
	 */
	protected int getPoints() {
		int points = 0;
		return points;
	}

}
