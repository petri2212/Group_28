package gui.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import gui.View;
import myshelfie.Player;
/**
 * This is an abstract class that implements the view interface.
 * it is the splitter for the graphic and the console for the points page.
 */
public abstract class PointsPageView implements View {

	protected ArrayList<Player> players;

	/**
	 * This is the action declaration.
	 */
	public ActionListener actionReturnMainPage;

	/**
	 * This is the setter for the players and it checks is the player is null
	 * @param players
	 */
	public void setPlayers(ArrayList<Player> players) {
		if (players == null) {
			throw new NullPointerException("The players array cannot be null");
		}

		this.players = players;
	}

}
