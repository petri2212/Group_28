package gui.view.console;

import java.util.Scanner;

import javax.lang.model.type.TypeMirror;

import gui.view.BoardView;
import myshelfie.Tile;
import myshelfie.TileType;
import utils.MatrixCoords;

public class BoardViewConsole extends BoardView{

	private static final int ROW_COUNT = 9;
	private static final int COL_COUNT = 9;

	@Override
	public void show() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("benvenuto in MyShelife!!");
		System.out.println("primi s per stampare la board");
		String input = sc.nextLine();

		if(input.equalsIgnoreCase("s")){
			actionPrintBoard.actionPerformed(null);
		}
		printBoard();
		
		sc.close();

	}
	
	public void printBoard() {
		String a = "------ ";
		String b = "|     |";
		String c = "|  t  |";
		int numberofacard = 5;
		for (int i = 0; i < ROW_COUNT; i++) {
			int cont = 0;
			while(cont < numberofacard) {
				int tmpcont = 0;
				switch (cont) {
				case 0:
					while(tmpcont < COL_COUNT) {
						System.out.print(a);
						tmpcont++;
					}
					System.out.println("   |");
					break;
					
				case 1:
					while(tmpcont < COL_COUNT) {
						System.out.print(b);
						tmpcont++;
					}
					System.out.println("   |");
					break;
					
				case 2:
					while(tmpcont < COL_COUNT) {
						if(checkTile(i, tmpcont)) {
							System.out.print(c);
						}else {
							System.out.print(b);
						}
						tmpcont++;
					}
					System.out.println("  | "+(i+1));
					break;
					
				case 3:
					while(tmpcont < COL_COUNT) {
						System.out.print(b);
						tmpcont++;
					}
					System.out.println("   |");
					break;
					
				case 4:
					while(tmpcont < COL_COUNT) {
						System.out.print(a);
						tmpcont++;
					}
					System.out.println("   |");
					break;
				}
				
				cont++;
			}
		}
	}

}
