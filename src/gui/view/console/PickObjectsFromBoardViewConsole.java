package gui.view.console;

import java.util.ArrayList;
import java.util.Scanner;

import gui.view.PickObjectsFromBoardView;
import myshelfie.Board;

public class PickObjectsFromBoardViewConsole extends PickObjectsFromBoardView {

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

		inputLenght = 3;
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

			if (input.isBlank()) {
				System.out.println("The command cannot be null");

			} else if (input.equalsIgnoreCase("enter")) {
				actionPutObjects.actionPerformed(null);
			} else if (input.length() == inputLenght) {
				setInput(input);
				actionVerifyObject.actionPerformed(null);
				if (verifier) {
					if (savedCoords == null) {
						savedCoords = new ArrayList<>();
					}
					savedCoords.add(input);

				}
			} else {
				System.out.println("You must insert coords like this (A,0)!!");
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
	
	//pickObjectsMethods

}