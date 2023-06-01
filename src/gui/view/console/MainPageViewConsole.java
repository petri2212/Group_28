package gui.view.console;

import java.util.Scanner;

import gui.view.MainPageView;
/**
 * This is the view console for the main page and it extends the abstract
 * view.
 */
public class MainPageViewConsole extends MainPageView {

	/**
	 * This is the override of the show method.
	 * In this method we let the user to start a new game or to exit the program
	 */
	public void show() {

		boolean isWaiting = true;
		Scanner sc = new Scanner(System.in);

		
		do {
			System.out.println("Welcome!");
			System.out.println("Press n to start a new game or press e to exit");
			String input = sc.nextLine();
			
			if (input.equalsIgnoreCase("n")) {
				isWaiting = false;
				actionNewGame.actionPerformed(null);
			}else if(input.equalsIgnoreCase("e")) {
				isWaiting = false;
				actionExit.actionPerformed(null);
			}
		}while(isWaiting);
		
		sc.close();

	}

}
