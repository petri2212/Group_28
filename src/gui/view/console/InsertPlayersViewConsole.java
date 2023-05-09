package gui.view.console;

import java.util.Scanner;

import gui.view.InsertPlayersView;

public class InsertPlayersViewConsole extends InsertPlayersView {

	public String input = null;
	@Override
	public void show() {
		Scanner sc = new Scanner(System.in);
		boolean isWaiting = true;

		do {
			System.out.println("\033[H\033[2J");
			System.out.println("Inserisci rm per tornare alla schermata home");
			System.out.println("Inserisci init se non vuoi inserire nessun altro giocatore");
			System.out.println("Inserisci il nome di un giocatore per crearne un altro");
			System.out.println("input : ");
			String input = sc.nextLine();
			
			if (input.isBlank()) {
				throw new NullPointerException("Il comando non può essere nullo");
				
			}else if(input.equalsIgnoreCase("rm")){
				actionReturnMainPage.actionPerformed(null);
				isWaiting = false;
				
			}else if(input.equalsIgnoreCase("init")){
				actionInitGame.actionPerformed(null);
				isWaiting = false;
			}else {
				setInput(input);
				actionInsertPlayer.actionPerformed(null);
				isWaiting = false;
			}
		}while(isWaiting);

		sc.close();
	}
	
	public void setInput(String input) {
		this.input = input; 
	}
	
	public String getInput() {
		return this.input;
	}

}
