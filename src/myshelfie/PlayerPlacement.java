package myshelfie;

import java.util.ArrayList;

public class PlayerPlacement {

	ArrayList<Player> players;
	ArrayList<Player> playersPlacement;
	
	public PlayerPlacement(Player player) {
		if (players.isEmpty()) {
		players=new ArrayList<Player>();
		}
		players.add(player);
	}
	/**
	 * this method checks each common goal and if the respective player has completed it then it will be inserted
	 * in an arrayList which in the end will be used to understand who has completed the common goal and in which position,
	 * the position will be used to assign points to each palyer.
	 * 
	 * @return the arrayList that contains The players , every player have a position on the array this will help with the assign 
	 */
	public ArrayList<Player> CheckPlacementPlayerCommonGoal1() {
		if(playersPlacement.isEmpty()) {
		playersPlacement = new ArrayList<>();
			}
		for (Player player : players) {
			if(!player.commonGoal1.getIsItCompleted()) {
				if(player.commonGoal1.check(player.bookshelf)==1) {
					playersPlacement.add(player);
				}
			}
			
		}
		
		
		return playersPlacement;
	}
	/**
	 * this method checks each common goal and if the respective player has completed it then it will be inserted
	 * in an arrayList which in the end will be used to understand who has completed the common goal and in which position,
	 * the position will be used to assign points to each palyer.
	 * 
	 * @return the arrayList that contains The players , every player have a position on the array this will help with the assign 
	 */
	public ArrayList<Player> CheckPlacementPlayerCommonGoal2() {
		if(playersPlacement.isEmpty()) {
			playersPlacement = new ArrayList<>();
			}
		for (Player player : players) {
			if(!player.commonGoal2.getIsItCompleted()) {
				if(player.commonGoal2.check(player.bookshelf)==1) {
					playersPlacement.add(player);
				}
			}
			
		}
		return playersPlacement;
	}
}
