package gui.view.console;

import gui.view.PickObjectsView;

public class PickObjectsViewConsole extends PickObjectsView{

	@Override
	public void show() {
		
		actionPickNameTag.actionPerformed(null);
		System.out.println("This is your turn: "+playerName);
		
	}

}
