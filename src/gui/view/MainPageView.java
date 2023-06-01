package gui.view;

import gui.View;
import java.awt.event.ActionListener;
/**
 * This is an abstract class that implements the view interface.
 * it is the splitter for the graphic and the console for the main page.
 */
public abstract class MainPageView implements View {

	/**
	 * Those are all the actions declaration.
	 */
	public ActionListener actionNewGame;
	
	public ActionListener actionExit;
}
