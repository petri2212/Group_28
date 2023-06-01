package deck;

import goal.CommonGoal;
import goal.common.*;
import utils.UniqueList;

/**
 * This class represents the deck that contains the CommonGoal cards of the game
 */
public class DeckCommon extends Deck<CommonGoal> {
	/**
	 * This method adds all community cards to the deck
	 * 
	 * @return goals
	 */
	@Override
	protected UniqueList<CommonGoal> fillDeckGoals() {
		UniqueList<CommonGoal> goals = new UniqueList<>();

		goals.add(new CommonGoal_SixSeparateGroupsOfTwoObj());
		goals.add(new CommonGoal_TwoFourByFourSquares());
		goals.add(new CommonGoal_Corners());
		goals.add(new CommonGoal_FourVertical());
		goals.add(new CommonGoal_ThreeColumns());
		goals.add(new CommonGoal_EightEqual());
		goals.add(new CommonGoal_Diagonal());
		goals.add(new CommonGoal_FourLinesThreeDiffrentObj());
		goals.add(new CommonGoal_TwoColumsSixDiffrentObj());
		goals.add(new CommonGoal_TwoLinesDiffrentObj());
		goals.add(new CommonGoal_FiveX());
		goals.add(new CommonGoal_Stairs());

		return goals;
	}

}
