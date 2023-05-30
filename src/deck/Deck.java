package deck;

import java.util.Random;

import goal.Goal;
import utils.UniqueList;

/**
 * This class represents a generic deck of goals cards. It is useful to collect
 * all goals instances of a certain type in a unique place. The declaration of
 * the type of Goal to add ensures that only the same type of Goal will be added
 * to the deck, avoiding mixing the Goals.
 */
public abstract class Deck<T extends Goal> {

	private UniqueList<T> goals;
	private int uniqueRandom;

	public Deck() {
		goals = fillDeckGoals();
	}

	/**
	 * Creates a List of unique Goals instances. The returned List is automatically
	 * stored inside the goals attribute when the class is constructed.
	 *
	 * @return a List of Goals of the same type
	 */
	protected abstract UniqueList<T> fillDeckGoals();

	/**
	 * Generates a random index within the bounds of goals size.
	 *
	 * @return a random integer
	 */
	public int extractRandomIndex() {
		Random rnd = new Random();
		int maxGoalsIndex = goals.size() - 1;
		int randomIndex = rnd.nextInt(maxGoalsIndex);

		return randomIndex;
	}

	/**
	 * Extracts a single goal from the deck.
	 *
	 * @return a Goal of the specified type
	 */
	public T extractGoal() {
		int i = extractRandomIndex();
		if (i == uniqueRandom) {
			i = extractRandomIndex();
			uniqueRandom = i;
		}
		T goal = goals.get(i);
		return goal;
	}

}
