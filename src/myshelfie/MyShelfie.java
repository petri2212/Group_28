package myshelfie;

import gui.*;

public class MyShelfie {

	public static void main(String[] args) {

		UI ui = new ConsoleUI();
		//UI ui = new GraphicUI();

		GameManager gm = new GameManager(ui);
		gm.start();
	}

}
