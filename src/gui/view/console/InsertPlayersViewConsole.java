package gui.view.console;

import java.util.Scanner;

import gui.view.InsertPlayersView;

public class InsertPlayersViewConsole extends InsertPlayersView {

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("Inserisci un giocatore");
		System.out.println("nome: ");
		Scanner nome = new Scanner(System.in);
		System.out.println("cognome");
		
		boolean isWaiting = true;
		
		do {
			System.out.println("\033[H\033[2J");
			System.out.println("Welcome!");
			System.out.println("Press n to start a new game or press e to exit");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			
			if (input.equalsIgnoreCase("n")) {
				isWaiting = false;
				actionNewGame.actionPerformed(null);
			}else if(input.equalsIgnoreCase("e")) {
				isWaiting = false;
				actionExit.actionPerformed(null);
			}
			sc.close();
		}while(isWaiting);


	}

}
