package goal;

import gui.DrawableObject;

public abstract class CommonGoal implements Goal, DrawableObject {

	/**
	 * @return the common goal description
	 */
	public abstract String getDescription();
}
