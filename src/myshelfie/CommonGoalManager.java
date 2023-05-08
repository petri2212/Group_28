package myshelfie;

import java.util.ArrayList;
import commonGoal.*;

public class CommonGoalManager {

	ArrayList<Player> players;
	ArrayList<Player> playersGoal1Placement;
	ArrayList<Player> playersGoal2Placement;

	CommonGoal commonGoal1;
	CommonGoal commonGoal2;

	public CommonGoalManager(ArrayList<Player> players, CommonGoal commonGoal1, CommonGoal commonGoal2) {
		if (players == null) {
			throw new NullPointerException("You must pass a list of players ...");
		}

		this.players = players;
		this.commonGoal1 = commonGoal1;
		this.commonGoal2 = commonGoal2;
	}

	/**
	 * this method checks each common goal and if the respective player has
	 * completed it then it will be inserted in an arrayList which in the end will
	 * be used to understand who has completed the common goal and in which
	 * position, the position will be used to assign points to each palyer.
	 * 
	 * @return the arrayList that contains The players , every player have a
	 *         position on the array this will help with the assign
	 */
	public void CheckPlacementPlayer() {
		for (Player player : players) {
			addPlayerToPlacement(playersGoal1Placement, player, commonGoal1);
			addPlayerToPlacement(playersGoal2Placement, player, commonGoal2);
		}
	}

	public void addPlayerToPlacement(ArrayList<Player> playersPlacement, Player player, CommonGoal commonGoal) {
		if (!playersPlacement.contains(player)) {
			if (commonGoal.check(player.bookshelf) == 1) {
				playersPlacement.add(player);
			}
		}
	}
}
