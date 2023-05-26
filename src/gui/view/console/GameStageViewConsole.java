package gui.view.console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import gui.view.GameStageView;
import myshelfie.Board;
import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import myshelfie.Tile;
import utils.MatrixCoords;
import utils.UniqueList;

public class GameStageViewConsole extends GameStageView {

	private static int INPUT_LENGHT = 3;
	private String input;
	private int intInput;
	private boolean isWaiting;
	protected char[] inputArr;
	protected char[] downCoords;
	protected char[] rightCoords;
	protected ArrayList<Character> downCoordsList = new ArrayList<>();
	protected ArrayList<Character> rightCoordsList = new ArrayList<>();
	protected List<String> savedCoords = new UniqueList<>();
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
		System.out.println("Remembre that the tiles will be inserted in the order that you pick them!!");
		System.out.println("example(A,0)");
		System.out.println("insert enter to put the tiles in your BookShelf");

		do {
			if (!savedCoords.isEmpty()) {
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
				enterVerifier();
			} else if (commaAndLenghtVerifier()) {
				verifyObject();
				if (verifier) {
					savedCoords.add(input);
				}
			}
			if (savedCoords.size() == INPUT_LENGHT) {
				System.out.println("Max number of coords reached!!");
				setIsWaiting(false);
			}

		} while (isWaiting);

		// show PutObjects

		isWaiting = true;
		printBookshelf();

		System.out.println("Insert the column where you want to insert the tile");

		do {
			System.out.println("Column :");
			String input = sc.nextLine();
			this.input = input;
			intInput = inputToInt(input);

			if (input.isBlank()) {
				System.out.println("The command cannot be null");

			} else if (intInput != 0) {
				System.out.println("those are your coords!!");
				for (int i = 0; i < savedCoords.size(); i++) {
					tmpCoords = savedCoords.get(i);
					System.out.print("|" + (i + 1) + ": " + tmpCoords + "|" + " ");
				}
			}

		} while (isWaiting);

		sc.close();

	}

	private void verifyObject() {
		int downCoordsPosition = 0;
		int rightCoordsPosition = 2;
		char column = 0;
		char row = 0;
		char letterToSubtract = 'A';
		int numberToSubtract = 49;
		int indexOfRow;
		int indexOfColumn;
		char[] input = getInputArr();

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
			Tile tmpTile = board.get(tmpCoord);
			if (tmpTile != null) {
				setVerifier(true);
				if (!savedMatrixCoords.contains(tmpCoord)) {
					savedMatrixCoords.add(tmpCoord);
				} else {
					showAlreadySelectedCoordsWarning();
					setVerifier(false);
				}
			} else {
				showNullTileSelectedWarning();
				setVerifier(false);
			}

		} else {
			showCoordsNotInTheBoardWarning();
			setVerifier(false);
		}

	}

	private void enterVerifier() {
		if (savedCoords != null && savedCoords.size() <= MAX_PICKED_OBJECTS) {
			setIsWaiting(false);
		}
	}

	private boolean setIsWaiting(boolean value) {
		return this.isWaiting = value;
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

	void showNullTileSelectedWarning() {
		System.out.println("Attention!!");
		System.out.println("This Tile is null!!");
		isWaiting = true;
	}

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

	public BookshelfObject checkTile(int r, int c) {
		Tile tile = board.get(new MatrixCoords(r, c));
		BookshelfObject object = null;

		if (tile != null) {
			object = tile.getBookshelfObject();
		}

		return object;
	}

	// put objects methods

	public int inputToInt(String input) {
		int inputLenght = 1;
		int maxColumnNumber = 5;
		int minColumnNumber = 1;
		int intInput = 0;

		if (input.length() == inputLenght) {
			try {
				intInput = Integer.parseInt(input);

				if (intInput >= minColumnNumber && intInput <= maxColumnNumber) {
					return intInput;
				} else {
					System.out.println("You inserted a wrong input!!");
				}

			} catch (Exception e) {
				System.out.println("You inserted a wrong input!!");
			}

		}
		return 0;
	}

	public int[] arrInputToInt(String input) {
		int zeroAsciiValue = 48;
		int[] inputToInt = { 0, 0, 0 };

		for (int i = 0; i < input.length(); i++) {
			try {
				inputToInt[i] = input.charAt(i);
				inputToInt[i] -= zeroAsciiValue;
			} catch (Exception e) {
				System.out.println("You insert something wrong!!");
			}
		}

		return inputToInt;
	}

	public BookshelfObject checkBookshelfObjects(int r, int c) {
		BookshelfObject obj = bookshelf.get(new MatrixCoords(r, c));
		BookshelfObject object = null;

		if (obj != null) {
			return obj;
		}

		return object;
	}

	public void printBookshelf() {
		final int ROW_COUNT = bookshelf.getRows();
		final int COL_COUNT = bookshelf.getCols();
		final int upCard = 0;
		final int voidUpCard = 1;
		final int centerCard = 2;
		final int voidDownCard = 3;
		final int downCard = 4;

		String partOfCard_a = " --------- ";
		String partOfCard_b = "|         |";
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
						BookshelfObject object = checkBookshelfObjects(i, tmpcont);
						if (object != null) {
							printBookshelfObject(object);
						} else {
							System.out.print(partOfCard_b);
						}
						tmpcont++;
					}
					System.out.println("  | " + (i + 1));
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
		for (int j = 0; j < COL_COUNT; j++) {
			System.out.print(" ----" + (j + 1) + "---- ");
		}
		System.out.println("\n");
	}

}
