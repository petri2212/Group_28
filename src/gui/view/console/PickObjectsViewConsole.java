package gui.view.console;

import java.util.Scanner;

import gui.view.PickObjectsView;

public class PickObjectsViewConsole extends PickObjectsView{

	@Override
	public void show() {
		
		actionPickPlayerName.actionPerformed(null);
		System.out.println("This is your turn: "+playerName);
		
		boolean isWaiting = true;
		Scanner sc = new Scanner(System.in);

		System.out.println("Insert the coordinates of the tiles that you whant to pick"
				+ " (first: col, second: row)");
		System.out.println("example(A,0)");
		System.out.println("insert enter to put the tiles in youe BookShelf");
		
		
		do {
			System.out.println("Coords: ");
			String input = sc.nextLine();
			
			if (input.isBlank()) {
				System.out.println("Il comando non può essere nullo");
				
			}else if(input.equalsIgnoreCase("enter")){
				actionPutObjects.actionPerformed(null);				
			}
		}while(isWaiting);
		
		sc.close();
		
	}

}
