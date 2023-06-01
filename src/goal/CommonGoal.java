package goal;

import gui.DrawableObject;

public abstract class CommonGoal implements Goal, DrawableObject {

	/**
	 * @return the common goal description
	 */
	public abstract String getDescription();

	/**
	 * Returns true if the confronted CommonGoal has the same name.
	 */
	@Override
	public boolean equals(Object obj) {
		String name = this.getClass().getName();
		String objName = obj.getClass().getName();
		return name.equals(objName);
	}
}
