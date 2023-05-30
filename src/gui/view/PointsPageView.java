package gui.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import gui.View;
import myshelfie.Player;

public abstract class PointsPageView implements View {

	protected ArrayList<Player> players;

	public ActionListener actionReturnMainPage;

	public void setPlayers(ArrayList<Player> players) {
		if (players == null) {
			throw new NullPointerException("The players array cannot be null");
		}

		this.players = players;
	}

}
