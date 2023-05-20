package gui;

import myshelfie.GameManager;

/**
 * Interface to handle the user interaction with the program both input and output.
 */
public interface UI {

	/**
	 * Visualize the main page.
	 *
	 * @param manager	is the reference to the game manager component. It is used to link the
	 * 					controller to the game manager to allow state changes.
	 */
	void showMainPage(GameManager model);
	
	void showInsertPlayersPage(GameManager model);
	
	void showPickObjectsFromBoardPage(GameManager model);
	
}
