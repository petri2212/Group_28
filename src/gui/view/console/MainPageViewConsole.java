package gui.view.console;

import java.util.Scanner;

import gui.view.MainPageView;
/**
 * This is the view console for the main page and it extends the abstract
 * view.
 */
public class MainPageViewConsole extends MainPageView {
	
	final static String Green="\u001b[32m";
	final static String White="\u001b[37m";
	final static String Red="\u001b[31m"; 

	/**
	 * This is the override of the show method.
	 * In this method we let the user to start a new game or to exit the program
	 */
	public void show() {

		boolean isWaiting = true;
		Scanner sc = new Scanner(System.in);

		
		do {
			System.out.println("Welcome!");
			System.out.println("Press "+Green+"n"+White+" to start a new game or press"+Red+" e"+White+" to exit");
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
