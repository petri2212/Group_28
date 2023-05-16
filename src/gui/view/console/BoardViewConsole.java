package gui.view.console;

import java.util.Scanner;

import javax.lang.model.type.TypeMirror;

import gui.view.BoardView;
import myshelfie.Tile;
import myshelfie.TileType;
import utils.MatrixCoords;

public class BoardViewConsole extends BoardView{

	@Override
	public void show() {
		
		System.out.println("Welcome in MyShelife!!");
		actionPrintBoard.actionPerformed(null);
		printBoard();
		System.out.println("\n\n");
		actionPickObjects.actionPerformed(null);
		
	}
	
	public void printBookshelfObject() {
		final int lenght3Char = 3;
		final int lenght4Char = 4;
		final int lenght5Char = 5;
		final int lenght6Char = 6;
		int lenght = bookshelfObjectToPrint.name().length();
		switch (lenght) {
		case lenght3Char:
			System.out.print("|   "+bookshelfObjectToPrint+"   |");
			break;
			
		case lenght4Char:
			System.out.print("|  "+bookshelfObjectToPrint+"   |");
			break;
			
		case lenght5Char:
			System.out.print("|  "+bookshelfObjectToPrint+"  |");
			break;
			
		case lenght6Char:
			System.out.print("|  "+bookshelfObjectToPrint+" |");
			break;
		}
		
	}
	
	public void printBoard() {
		final int ROW_COUNT = board.getRows();
		final int COL_COUNT = board.getCols();
		final int upCard = 0;
		final int voidUpCard = 1;
		final int centerCard = 2;
		final int voidDownCard = 3;
		final int downCard = 4;

		String partOfCard_a = " --------- ";
		String partOfCard_b = "|         |";
		String[] arrOfDownCoords = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
		int numberOfPartsInCard = 5;
		for (int i = 0; i < ROW_COUNT; i++) {
			int cont = 0;
			while(cont < numberOfPartsInCard) {
				int tmpcont = 0;
				
				switch (cont) {
				
				case upCard:
					while(tmpcont < COL_COUNT) {
						System.out.print(partOfCard_a);
						tmpcont++;
					}
					System.out.println("   |");
					break;
					
				case voidUpCard:
					while(tmpcont < COL_COUNT) {
						System.out.print(partOfCard_b);
						tmpcont++;
					}
					System.out.println("   |");
					break;
					
				case centerCard:
					while(tmpcont < COL_COUNT) {
						if(checkTile(i, tmpcont)) {
							printBookshelfObject();
						}else {
							System.out.print(partOfCard_b);
						}
						tmpcont++;
					}
					System.out.println("  | "+(i+1));
					break;
					
				case voidDownCard:
					while(tmpcont < COL_COUNT) {
						System.out.print(partOfCard_b);
						tmpcont++;
					}
					System.out.println("   |");
					break;
					
				case downCard:
					while(tmpcont < COL_COUNT) {
						System.out.print(partOfCard_a);
						tmpcont++;
					}
					System.out.println("   |");
					break;
				}
				
				cont++;
			}
		}
		for (int j = 0; j < arrOfDownCoords.length; j++) {
			System.out.print(" ----"+arrOfDownCoords[j]+"---- ");
		}
	}

}
