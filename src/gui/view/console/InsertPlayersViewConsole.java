package gui.view.console;

import java.util.ArrayList;
import java.util.Scanner;

import gui.view.InsertPlayersView;
import myshelfie.Player;

public class InsertPlayersViewConsole extends InsertPlayersView {

	protected boolean isWaiting;

	@Override
	public void show() {
		Scanner sc = new Scanner(System.in);
		isWaiting = true;

		do {
			System.out.println("\n\n\n");
			System.out.println("Inserisci rm per tornare alla schermata home");
			System.out.println("Inserisci init se non vuoi inserire nessun altro giocatore");
			System.out.println("Inserisci il nome di un giocatore per crearne un altro");
			System.out.println("input : ");
			String input = sc.nextLine();

			if (input.isBlank()) {
				System.out.println("Il comando non può essere nullo");
				
			}else if(input.equalsIgnoreCase("rm")){
				actionReturnMainPage.actionPerformed(null);				
				isWaiting = false;
			}else if(input.equalsIgnoreCase("init")){
				actionInitGame.actionPerformed(null);
			}else {
				setInput(input);
				actionInsertPlayer.actionPerformed(null);
			}
		}while(isWaiting);

		sc.close();
	}

	@Override
	public void showTooFewPlayersWarning() {
		System.out.println("Attention!!");
		System.out.println("You must insert at least two players!!");
		isWaiting = true;
	}

	@Override
	public void showTooManyPlayersWarning() {
		System.out.println("Attention!!");
		System.out.println("You reached the maximum number of player. Type 'init' to start the game.");
		isWaiting = true;
	}

	@Override
	public void showDoublePlayersWarning() {
		System.out.println("Attention!!");
		System.out.println("This player name has already been taken, please choose another name.");
		isWaiting = true;
	}

	@Override
	public void showInvalidInputWarning() {
		System.out.println("Attention!!");
		System.out.println("Invalid player name, please type a name long at least one character.");
		isWaiting = true;
	}

	@Override
	public void showInseredPlayer() {
		System.out.println("Current players:");
		ArrayList<Player> players = getInseredPlayers();

		for(Player player : players) {
			System.out.print(player.getName() + "   ");
		}
	}

}
