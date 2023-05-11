package deck;

import commonGoal.*;
import utils.UniqueList;

public class DeckCommon extends Deck<CommonGoal> {

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
