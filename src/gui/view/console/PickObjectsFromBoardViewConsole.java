package gui.view.console;

import java.util.ArrayList;
import java.util.Scanner;

import gui.view.PickObjectsFromBoardView;
import myshelfie.Board;

public class PickObjectsFromBoardViewConsole extends PickObjectsFromBoardView {
	
	private static  int INPUT_LENGHT = 3;
	private String input;

	@Override
	public void show() {
		
		//show board
		
		System.out.println("Welcome in MyShelife!!");
		actionPrintBoard.actionPerformed(null);
		printBoard();
		System.out.println("\n\n");
		
		//show PickObjects
		
		actionPickPlayerName.actionPerformed(null);
		System.out.println("This is your turn: " + playerName + "\n");

		boolean isWaiting = true;
		Scanner sc = new Scanner(System.in);

		System.out.println("Insert the coordinates of the tiles that you whant to pick" + " (first: col, second: row)");
		System.out.println("example(A,0)");
		System.out.println("insert enter to put the tiles in your BookShelf");

		do {
			if (savedCoords != null) {
				System.out.print("Inserted Coords: ");
				for (int i = 0; i < savedCoords.size(); i++) {
					tmpCoords = savedCoords.get(i);
					System.out.print(tmpCoords + " ");
				}
				System.out.println();

			}
			System.out.println("Coords: ");
			String input = sc.nextLine();
			this.input = input;

			if (input.isBlank()) {
				System.out.println("The command cannot be null");

			} else if (input.equalsIgnoreCase("enter")) {
				actionPutObjects.actionPerformed(null);
			} else if (commaAndLenghtVerifier()) {
				actionVerifyObject.actionPerformed(null);
				if (verifier) {
					if (savedCoords == null) {
						savedCoords = new ArrayList<>();
					}
					savedCoords.add(input);
				}
			}
		} while (isWaiting);

		sc.close();
		
	}
	
	//BoardMethods
	
	public void printBookshelfObject() {
		final int lenght3Char = 3;
		final int lenght4Char = 4;
		final int lenght5Char = 5;
		final int lenght6Char = 6;
		int lenght = bookshelfObjectToPrint.name().length();
		switch (lenght) {
		case lenght3Char:
			System.out.print("|   " + bookshelfObjectToPrint + "   |");
			break;

		case lenght4Char:
			System.out.print("|  " + bookshelfObjectToPrint + "   |");
			break;

		case lenght5Char:
			System.out.print("|  " + bookshelfObjectToPrint + "  |");
			break;

		case lenght6Char:
			System.out.print("|  " + bookshelfObjectToPrint + " |");
			break;
		}

	}

	public void printBoard() {
		final int ROW_COUNT = Board.ROW_COUNT;
		final int COL_COUNT = Board.COL_COUNT;
		final int upCard = 0;
		final int voidUpCard = 1;
		final int centerCard = 2;
		final int voidDownCard = 3;
		final int downCard = 4;

		String partOfCard_a = " --------- ";
		String partOfCard_b = "|         |";
		char[] arrOfDownCoord = Board.DOWN_COOORDS;
		char[] arrOfRightCoords = Board.RIGHT_COORDS;
		int numberOfPartsInCard = 5;
		for (int i = 0; i < ROW_COUNT; i++) {
			int cont = 0;
			while (cont < numberOfPartsInCard) {
				int tmpcont = 0;

				switch (cont) {

				case upCard:
					while (tmpcont < COL_COUNT) {
						System.out.print(partOfCard_a);
						tmpcont++;
					}
					System.out.println("   |");
					break;

				case voidUpCard:
					while (tmpcont < COL_COUNT) {
						System.out.print(partOfCard_b);
						tmpcont++;
					}
					System.out.println("   |");
					break;

				case centerCard:
					while (tmpcont < COL_COUNT) {
						if (checkTile(i, tmpcont)) {
							printBookshelfObject();
						} else {
							System.out.print(partOfCard_b);
						}
						tmpcont++;
					}
					System.out.println("  | " + (arrOfRightCoords[i]));
					break;

				case voidDownCard:
					while (tmpcont < COL_COUNT) {
						System.out.print(partOfCard_b);
						tmpcont++;
					}
					System.out.println("   |");
					break;

				case downCard:
					while (tmpcont < COL_COUNT) {
						System.out.print(partOfCard_a);
						tmpcont++;
					}
					System.out.println("   |");
					break;
				}

				cont++;
			}
		}
		for (int j = 0; j < arrOfDownCoord.length; j++) {
			System.out.print(" ----" + arrOfDownCoord[j] + "---- ");
		}
	}

	@Override
	public void showBookshelf() {
		// TODO Auto-generated method stub
	}
	
	//pickObjectsMethods
	
	public void showAlreadySelectedCoordsWarning() {
		System.out.println("Attention!!");
		System.out.println("You've already selected this coords!!");
		isWaiting = true;
	}
	
	public void showCoordsNotInTheBoardWarning() {
		System.out.println("Attention!!");
		System.out.println("Attention you insert coords that are not in the board!!");
		isWaiting = true;
	}
	
	public void showChangeStateWarning() {
		System.out.println("Attention!!");
		System.out.println("Attention you have reached the max number of tiles!!");
		System.out.println("You will put the tiles in your bookshelf soon!!");
		isWaiting = true;
	}
	
	public boolean commaAndLenghtVerifier() {
		int commaPosition = 1;
		char[] input = inputToChar(this.input);
		
		if(input.length == INPUT_LENGHT) {
			if(input[commaPosition] == ',') {
				return true;
			}
		}
		System.out.println("You must insert coords with this sintax (A,0)");
		return false;

	}

	public char[] inputToChar(String input) {
		char[] inputChar = { ' ', ' ', ' ' };
		for (int i = 0; i < input.length(); i++) {
			inputChar[i] = input.charAt(i);
		}
		this.inputArr = inputChar;
		return inputChar;
	}

}
