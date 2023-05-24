package gui.view.console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import gui.view.PickObjectsFromBoardView;
import myshelfie.Board;
import myshelfie.BookshelfObject;
import myshelfie.Tile;
import utils.MatrixCoords;

public class PickObjectsFromBoardViewConsole extends PickObjectsFromBoardView {

	private static int INPUT_LENGHT = 3;
	private String input;
	private boolean isWaiting;
	protected char[] inputArr;
	protected char[] downCoords;
	protected char[] rightCoords;
	protected ArrayList<String> savedCoords;
	protected String tmpCoords;
	protected boolean verifier;

	@Override
	public void show() {

		// show board

		System.out.println("Welcome in MyShelife!!");
		printBoard();
		System.out.println("\n\n");

		// show PickObjects

		System.out.println("This is your turn: " + playerName + "\n");

		isWaiting = true;
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
				if(savedCoords.size() == INPUT_LENGHT) {
					System.out.println("Max number of coords reached!!");
					actionPutObjects.actionPerformed(null);
				}

			}
			System.out.println("Coords: ");
			String input = sc.nextLine();
			this.input = input;

			if (input.isBlank()) {
				System.out.println("The command cannot be null");

			} else if (input.equalsIgnoreCase("enter")) {
				putObjects();
				actionPutObjects.actionPerformed(null);
			} else if (commaAndLenghtVerifier()) {
				verifyObject();
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

	private void verifyObject() {
		int downCoordsPosition = 0;
		int rightCoordsPosition = 2;
		int maxCoords = 3;
		char column = 0;
		char row = 0;
		char letterToSubtract = 'A';
		int numberToSubtract = 49;
		int indexOfRow;
		int indexOfColumn;
		char[] input = getInputArr();
		ArrayList<Character> downCoordsList = new ArrayList<>();
		ArrayList<Character> rightCoordsList = new ArrayList<>();
		HashSet<MatrixCoords> coords = new HashSet<>();

		if (coords.size() == maxCoords) {
			showChangeStateWarning();
		}

		if (downCoordsList.isEmpty()) {
			for (int i = 0; i < Board.DOWN_COOORDS.length; i++) {
				downCoordsList.add(Board.DOWN_COOORDS[i]);
				rightCoordsList.add(Board.RIGHT_COORDS[i]);
			}
		}

		column = input[downCoordsPosition];
		row = input[rightCoordsPosition];

		if (downCoordsList.contains(column) && rightCoordsList.contains(row)) {
			indexOfColumn = column - letterToSubtract;
			indexOfRow = (int) row - numberToSubtract;
			MatrixCoords tmpCoord = new MatrixCoords(indexOfRow, indexOfColumn);
			setVerifier(true);
			if (coords.add(tmpCoord)) {
				setVerifier(true);
			} else {
				showAlreadySelectedCoordsWarning();
				setVerifier(false);
			}

		} else {
			showCoordsNotInTheBoardWarning();
			setVerifier(false);
		}

	}

	private void putObjects() {
		setDownCoords(Board.DOWN_COOORDS);
		setRightCoords(Board.RIGHT_COORDS);
	}

	// BoardMethods

	public void printBookshelfObject(BookshelfObject object) {
		final int lenght3Char = 3;
		final int lenght4Char = 4;
		final int lenght5Char = 5;
		final int lenght6Char = 6;
		String bookshelfObjectToPrint = object.name();
		int lenght = bookshelfObjectToPrint.length();
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
						BookshelfObject object = checkTile(i, tmpcont);
						if (object != null) {
							printBookshelfObject(object);
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

	// pickObjectsMethods

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

		if (input.length == INPUT_LENGHT) {
			if (input[commaPosition] == ',') {
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

	private void setVerifier(Boolean verifier) {
		this.verifier = verifier;
	}

	private char[] getInputArr() {
		return this.inputArr;
	}

	private void setDownCoords(char[] downCoords) {
		this.downCoords = downCoords;
	}

	private void setRightCoords(char[] rightCoords) {
		this.rightCoords = rightCoords;
	}

	public BookshelfObject checkTile(int r, int c) {
		Tile tile = board.get(new MatrixCoords(r, c));
		BookshelfObject object = null;

		if (tile != null) {
			object = tile.getBookshelfObject();
		}

		return object;
	}

}
