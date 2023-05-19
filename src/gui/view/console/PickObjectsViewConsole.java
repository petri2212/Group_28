package gui.view.console;

import java.util.ArrayList;
import java.util.Scanner;

import gui.view.PickObjectsView;
import myshelfie.CommonGoalManager;

public class PickObjectsViewConsole extends PickObjectsView{

	@Override
	public void show() {
		
		actionPickPlayerName.actionPerformed(null);
		System.out.println("This is your turn: "+playerName+"\n");
		
		inputLenght = 3;
		boolean isWaiting = true;
		Scanner sc = new Scanner(System.in);

		System.out.println("Insert the coordinates of the tiles that you whant to pick"
				+ " (first: col, second: row)");
		System.out.println("example(A,0)");
		System.out.println("insert enter to put the tiles in your BookShelf");
		
		do {
			if(savedCoords != null) {
				System.out.print("Inserted Coords: ");
				for (int i = 0; i < savedCoords.size(); i++) {
					tmpCoords = savedCoords.get(i);
					System.out.print(tmpCoords+" ");
				}
				System.out.println();

			}
			System.out.println("Coords: ");
			String input = sc.nextLine();
			
			if (input.isBlank()) {
				System.out.println("The command cannot be null");
				
			}else if(input.equalsIgnoreCase("enter")){
				actionPutObjects.actionPerformed(null);				
			}else if(input.length() == inputLenght){
				setInput(input);
				actionVerifyObject.actionPerformed(null);
				if(verifier) {
					if(savedCoords == null) {
						savedCoords = new ArrayList<>();
					}
					savedCoords.add(input);
					
				}
			}else {
				System.out.println("You must insert coords like this (A,0)!!");
			}
		}while(isWaiting);
		
		sc.close();
		
	}

}
