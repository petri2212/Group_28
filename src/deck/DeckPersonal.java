package deck;

import goal.PersonalGoal;
import goal.personal.*;
import utils.UniqueList;

/**
 * This class represents the deck that contains the PersonalGoal cards of the
 * game
 */
public class DeckPersonal extends Deck<PersonalGoal> {
	/**
	 * This method adds all PersonalGoal cards to the deck
	 * 
	 * @return goals a unique list of PersonalGoal
	 */
	@Override
	protected UniqueList<PersonalGoal> fillDeckGoals() {
		UniqueList<PersonalGoal> goals = new UniqueList<>();

		goals.add(new PersonalGoal1());
		goals.add(new PersonalGoal2());
		goals.add(new PersonalGoal3());
		goals.add(new PersonalGoal4());
		goals.add(new PersonalGoal5());
		goals.add(new PersonalGoal6());
		goals.add(new PersonalGoal7());
		goals.add(new PersonalGoal8());
		goals.add(new PersonalGoal9());
		goals.add(new PersonalGoal10());
		goals.add(new PersonalGoal11());
		goals.add(new PersonalGoal12());

		return goals;
	}

}
