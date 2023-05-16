package gui.view.console;

import gui.view.PickObjectsView;

public class PickObjectsViewConsole extends PickObjectsView{

	@Override
	public void show() {
		
		actionPickPlayerName.actionPerformed(null);
		System.out.println("This is your turn: "+playerName);
		
	}

}
