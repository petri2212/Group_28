package gui.view.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import gui.view.GameStageView;
import myshelfie.Board;
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

		System.out.println("Board");
		printBoard();
		System.out.println("\nBookshlef");
		printBookshelf();
		System.out.println("\nPersonalGoal");
		printPersonalGoals();
		System.out.println();
		printCommonGoals();
		
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

		System.out.println("Insert the column where you want to insert the tile in the BookShelf");

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
				setIsWaiting(true);
			}

		} while (isWaiting);
		
		actionEndTurn.actionPerformed(null);

		sc.close();

	}
	
	public void printCommonGoals(){
		System.out.println("CommonGoal 1:\n");
		String description = commonGoal1.getDescription();
		System.out.println(description);
		System.out.println("CommonGoal 2:\n");
		description = commonGoal2.getDescription();
		System.out.println(description);
		System.out.println();
	}
	
	public void printPersonalGoals() {
		Map<MatrixCoords, BookshelfObject> map = personalGoal.getMap();
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

		for (int r = 0; r < ROW_COUNT; r++) {
			int cont = 0;
			while (cont < numberOfPartsInCard) {
				int tmpCont = 0;

				switch (cont) {

				case upCard:
					while (tmpCont < COL_COUNT) {
						System.out.print(partOfCard_a);
						tmpCont++;
					}
					System.out.println("   |");
					break;

				case voidUpCard:
					while (tmpCont < COL_COUNT) {
						System.out.print(partOfCard_b);
						tmpCont++;
					}
					System.out.println("   |");
					break;

				case centerCard:
					while (tmpCont < COL_COUNT) {
						MatrixCoords tmpCoords = new MatrixCoords(r, tmpCont);
						BookshelfObject object = map.get(tmpCoords);
						if (object != null) {
							printBookshelfObject(object);
						} else {
							System.out.print(partOfCard_b);
						}
						tmpCont++;
					}
					System.out.println("  | " + (r + 1));
					break;

				case voidDownCard:
					while (tmpCont < COL_COUNT) {
						System.out.print(partOfCard_b);
						tmpCont++;
					}
					System.out.println("   |");
					break;

				case downCard:
					while (tmpCont < COL_COUNT) {
						System.out.print(partOfCard_a);
						tmpCont++;
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
		BookshelfObject tmpObject = null;
		
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
			if(tmpTile != null) {
				tmpObject = tmpTile.getBookshelfObject();
			}
			if (tmpObject != null && board.isObjectPickable(savedMatrixCoords, tmpCoord)) {
				setVerifier(true);
				if (!savedMatrixCoords.contains(tmpCoord)) {
					savedMatrixCoords.add(tmpCoord);
				} else {
					showAlreadySelectedCoordsWarning();
					setVerifier(false);
				}
			} else {
				showNotUsableOrNullWarning();
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
				int tmpCont = 0;

				switch (cont) {

				case upCard:
					while (tmpCont < COL_COUNT) {
						System.out.print(partOfCard_a);
						tmpCont++;
					}
					System.out.println("   |");
					break;

				case voidUpCard:
					while (tmpCont < COL_COUNT) {
						System.out.print(partOfCard_b);
						tmpCont++;
					}
					System.out.println("   |");
					break;

				case centerCard:
					while (tmpCont < COL_COUNT) {
						BookshelfObject object = checkTile(i, tmpCont);
						if (object != null) {
							printBookshelfObject(object);
						} else {
							System.out.print(partOfCard_b);
						}
						tmpCont++;
					}
					System.out.println("  | " + (arrOfRightCoords[i]));
					break;

				case voidDownCard:
					while (tmpCont < COL_COUNT) {
						System.out.print(partOfCard_b);
						tmpCont++;
					}
					System.out.println("   |");
					break;

				case downCard:
					while (tmpCont < COL_COUNT) {
						System.out.print(partOfCard_a);
						tmpCont++;
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

	public void showNotUsableOrNullWarning() {
		System.out.println("Attention!!");
		System.out.println("Not usable Tile !!");
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
				int tmpCont = 0;

				switch (cont) {

				case upCard:
					while (tmpCont < COL_COUNT) {
						System.out.print(partOfCard_a);
						tmpCont++;
					}
					System.out.println("   |");
					break;

				case voidUpCard:
					while (tmpCont < COL_COUNT) {
						System.out.print(partOfCard_b);
						tmpCont++;
					}
					System.out.println("   |");
					break;

				case centerCard:
					while (tmpCont < COL_COUNT) {
						BookshelfObject object = checkBookshelfObjects(i, tmpCont);
						if (object != null) {
							printBookshelfObject(object);
						} else {
							System.out.print(partOfCard_b);
						}
						tmpCont++;
					}
					System.out.println("  | " + (i + 1));
					break;

				case voidDownCard:
					while (tmpCont < COL_COUNT) {
						System.out.print(partOfCard_b);
						tmpCont++;
					}
					System.out.println("   |");
					break;

				case downCard:
					while (tmpCont < COL_COUNT) {
						System.out.print(partOfCard_a);
						tmpCont++;
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
