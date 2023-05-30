package gui.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import gui.View;
import myshelfie.Player;

public abstract class PointsPageView implements View {

	protected ArrayList<Player> players;
	protected ArrayList<String> playersName;

	public ActionListener actionReturnMainPage;

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public void setNames() {
		for (int i = 0; i < players.size(); i++) {
			playersName.add(players.get(i).getName());
		}
	}

}
