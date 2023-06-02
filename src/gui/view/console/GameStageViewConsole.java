package gui.view.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import board.Board;
import board.Tile;
import gui.view.GameStageView;
import myshelfie.BookshelfObject;
import utils.MatrixCoords;
import utils.UniqueList;

/**
 * This is the view console for the game stage page and it extends the abstract
 * view.
 */
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
	protected ArrayList<BookshelfObject> savedObjects = new ArrayList<>();
	protected String tmpCoords;
	protected boolean verifier;
	
	final static String Pink="\u001b[35m";  
	final static String White="\u001b[37m";
	final static String Green="\u001b[32m";
	final static String Blue="\u001b[34m";
	final static String Cyan="\u001b[36m";
	final static String Orange="\u001b[33m";
	final static String Red="\u001b[31m"; 
	


	/**
	 * This is the override of the show method. In the first part of the show method we print all the
	 * tools to play that are board, bookshelf, personal goal and common goals.
	 * In the second part of the show method we check let the user to insert the coordinates
	 * and we verify them.
	 * In the last part of the show method we let the user to insert the objects in his bookshelf
	 * with all the checks needed.
	 */
	public void show() {

		// show board, bookshelf, personal goal and common goals

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
		System.out.println("insert "+Green+"enter"+White+" to put the tiles in your BookShelf");

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
				System.out.println(Red+"The command cannot be null"+White);

			} else if (input.equalsIgnoreCase("enter")) {
				enterVerifier();
			} else if (commaAndLenghtVerifier()) {
				verifyObject();
				if (verifier) {
					savedCoords.add(input);
				}
			}
			if (savedCoords.size() == INPUT_LENGHT) {
				System.out.println(Red+"Max number of coords reached!!"+White);
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
				if (bookshelf.isThereEnoughSpace((intInput - 1), savedCoords.size())) {
					setIsWaiting(false);
				} else {
					showNotEnoughSpaceWarning();
				}
			}

		} while (isWaiting);

		putInBookshelf(intInput);
		actionEndTurn.actionPerformed(null);

		sc.close();

	}

	private boolean setIsWaiting(boolean value) {
		return this.isWaiting = value;
	}

	// Board bookshelf, personal goal and common goals methods.

	private void printBoard() {
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

		for (int i = ROW_COUNT; i > 0; i--) {
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
						BookshelfObject object = checkTile(i - 1, tmpCont);
						if (object != null) {
							printBookshelfObject(object);
						} else {
							System.out.print(partOfCard_b);
						}
						tmpCont++;
					}
					System.out.println("  | " + (arrOfRightCoords[i - 1]));
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

	private void printBookshelfObject(BookshelfObject object) {
		final int lenght3Char = 3;
		final int lenght4Char = 4;
		final int lenght5Char = 5;
		final int lenght6Char = 6;
		
		String bookshelfObjectToPrint=object.name();
		/*if(object.name()=="CAT") {
			 bookshelfObjectToPrint=Green+object.name();
		}else {
			bookshelfObjectToPrint=object;
		}
			*/
		
		
		
		
		int lenght = bookshelfObjectToPrint.length();
		switch (lenght) {
		case lenght3Char:
			
			System.out.print("|   " + Green+bookshelfObjectToPrint +White+ "   |");
			break;

		case lenght4Char:
			
			if(bookshelfObjectToPrint.equals("BOOK")) {
				System.out.print("|  " + White+bookshelfObjectToPrint +White+ "   |");
			}else {
			System.out.print("|  " + Orange+bookshelfObjectToPrint +White+ "   |");
			}
			break;
			
		case lenght5Char:
			
			if(bookshelfObjectToPrint.equals("PLANT")) {
				System.out.print("|  "+ Pink+bookshelfObjectToPrint +White+ "  |");
			}else {
			System.out.print("|  " + Blue+bookshelfObjectToPrint +White+ "  |");
			}
			
			break;

		case lenght6Char:
			System.out.print("|  " + Cyan+bookshelfObjectToPrint +White+ " |");
			break;
		}

	}
	
	private BookshelfObject checkBookshelfObjects(int r, int c) {
		BookshelfObject obj = bookshelf.get(new MatrixCoords(r, c));
		BookshelfObject object = null;

		if (obj != null) {
			return obj;
		}

		return object;
	}

	private void printBookshelf() {
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

		for (int i = ROW_COUNT; i > 0; i--) {
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
						BookshelfObject object = checkBookshelfObjects(i - 1, tmpCont);
						if (object != null) {
							printBookshelfObject(object);
						} else {
							System.out.print(partOfCard_b);
						}
						tmpCont++;
					}
					System.out.println("  | " + i);
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

	private void printPersonalGoals() {
		Map<MatrixCoords, BookshelfObject> map = personalGoal.getMap();
		final int ROW_COUNT = bookshelf.getRows();
		final int COL_COUNT = bookshelf.getCols();
		final int upCard = 0;
		final int voidUpCard = 1;
		final int centerCard = 2;
		final int voidDownCard = 3;
		final int downCard = 4;

		int rowNumber = 6;
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
					System.out.println("  | " + rowNumber);
					rowNumber--;
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

	private void printCommonGoals() {
		System.out.println("CommonGoal 1:\n");
		String description = commonGoal1.getDescription();
		System.out.println(description + "\n");
		System.out.println("CommonGoal 2:\n");
		description = commonGoal2.getDescription();
		System.out.println(description);
		System.out.println();
	}

	// Warnings

	public void showNotEnoughSpaceWarning() {
		System.out.println(Red+"Attention!!"+White);
		System.out.println("There is not enough space in this column!!");
		isWaiting = true;
	}

	public void showNotUsableOrNullWarning() {
		System.out.println(Red+"Attention!!"+White);
		System.out.println("Not usable Tile !!");
		isWaiting = true;
	}

	public void showAlreadySelectedCoordsWarning() {
		System.out.println(Red+"Attention!!"+White);
		System.out.println("You've already selected this coords!!");
		isWaiting = true;
	}

	public void showCoordsNotInTheBoardWarning() {
		System.out.println(Red+"Attention!!"+White);
		System.out.println("Attention you insert coords that are not in the board!!");
		isWaiting = true;
	}
	
	// pickObjectsMethods

	private boolean commaAndLenghtVerifier() {
		int commaPosition = 1;
		char[] input = inputToChar(this.input);

		if (input.length == INPUT_LENGHT) {
			if (input[commaPosition] == ',') {
				return true;
			}
		}
		System.out.println("You must insert coords with this sintax (A,0) or "+Green+"enter"+White+" to put objects in your bookshelf");
		return false;

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
				if (tmpTile.getBookshelfObject() != null) {
					if (board.isObjectPickable(savedMatrixCoords, tmpCoord)) {
						setVerifier(true);
						if (!savedMatrixCoords.contains(tmpCoord)) {
							savedMatrixCoords.add(tmpCoord);
							savedObjects.add(board.tryPickObject(tmpCoord));

						} else {
							showAlreadySelectedCoordsWarning();
							setVerifier(false);
						}
					} else {
						showNotUsableOrNullWarning();
						setVerifier(false);
					}

				} else {
					showNotUsableOrNullWarning();
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

	private char[] inputToChar(String input) {
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
	
	private void enterVerifier() {
		if (savedCoords != null && savedCoords.size() <= MAX_PICKED_OBJECTS) {
			setIsWaiting(false);
		}
	}

	private char[] getInputArr() {
		return this.inputArr;
	}

	private BookshelfObject checkTile(int r, int c) {
		Tile tile = board.get(new MatrixCoords(r, c));
		BookshelfObject object = null;

		if (tile != null) {
			object = tile.getBookshelfObject();
		}

		return object;
	}

	// put objects methods

	private int inputToInt(String input) {
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
					System.out.println(Red+"You inserted a wrong input!!"+White);
				}

			} catch (Exception e) {
				System.out.println(Red+"You inserted a wrong input!!"+White);
			}

		}
		return 0;
	}

	private void putInBookshelf(int input) {
		System.out.println("those are your coords!!");
		for (int i = 0; i < savedCoords.size(); i++) {
			tmpCoords = savedCoords.get(i);
			System.out.print("|" + (i + 1) + ": " + tmpCoords + "|" + " ");
		}

		input--;
		boolean value = bookshelf.tryAdd(input, savedObjects);
		if (value) {
			System.out.println(Green+"Objects placed correctly!!"+White);
		}

	}

}
