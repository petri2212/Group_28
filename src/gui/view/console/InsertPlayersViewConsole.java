package gui.view.console;

import java.util.Scanner;

import gui.view.InsertPlayersView;

public class InsertPlayersViewConsole extends InsertPlayersView {

	@Override
	public void show() {
		Scanner sc = new Scanner(System.in);
		isWaiting = true;

		do {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("Inserisci rm per tornare alla schermata home");
			System.out.println("Inserisci init se non vuoi inserire nessun altro giocatore");
			System.out.println("Inserisci il nome di un giocatore per crearne un altro");
			System.out.println("input : ");
			String input = sc.nextLine();
			
			if (input.isBlank()) {
				System.out.println("Il comando non può essere nullo");
				
			}else if(input.equalsIgnoreCase("rm")){
				actionReturnMainPage.actionPerformed(null);				
			}else if(input.equalsIgnoreCase("init")){
				actionInitGame.actionPerformed(null);
			}else {
				setInput(input);
				actionInsertPlayer.actionPerformed(null);
			}
		}while(isWaiting);

		sc.close();
	}

}
