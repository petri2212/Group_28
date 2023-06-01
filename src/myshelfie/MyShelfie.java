package myshelfie;

import gui.*;

public class MyShelfie {

	public static final String VERSION = "0.0";
	public static final int MIN_PLAYERS = 2;
	public static final int MAX_PLAYERS = 4;

	public static void main(String[] args) {

		//UI ui = new ConsoleUI();
		UI ui = new GraphicUI();

		GameManager gm = new GameManager(ui);
		gm.start();
	}

}
