package myshelfie;

import java.util.ArrayList;
import java.util.Random;
import commonGoal.CommonGoal;
import commonGoal.CommonGoals_SixSeparateGroupsOfTwoObj;
import commonGoal.CommonGoals_FourGroupsFourObjSameObj;
import commonGoal.CommonGoals_Corners;
import commonGoal.CommonGoals_fourVertical;
import commonGoal.CommonGoals_threeColumns;
import commonGoal.CommonGoals_eightEqual;
import commonGoal.CommonGoals_Diagonal;
import commonGoal.CommonGoals_FourLinesThreeDiffrentObj;
import commonGoal.CommonGoals_TwoColumsSixDiffrentObj;
import commonGoal.CommonGoals_TwoLinesDiffrentObj;
import commonGoal.CommonGoals_fiveX;
import commonGoal.CommonGoals_Stairs;
public class Extratcards {
	
	//private static Random RANDOM = new Random();
	
	//to be used in main program
	
	ArrayList<CommonGoal> deck = new ArrayList<>();
	
	public Extratcards() {
		fillDeckCards();
	};
	
	public int extractedRandomIndex() {
		Random RANDOM = new Random();
		int extracted_num=RANDOM.nextInt(12);
		return extracted_num;
	}
	
	private void fillDeckCards() {
		deck.add(new CommonGoals_SixSeparateGroupsOfTwoObj());
		deck.add(new CommonGoals_FourGroupsFourObjSameObj());
		deck.add(new CommonGoals_Corners());
		deck.add(new CommonGoals_fourVertical());
		deck.add(new CommonGoals_threeColumns());
		deck.add(new CommonGoals_eightEqual());
		deck.add(new CommonGoals_Diagonal());
		deck.add(new CommonGoals_FourLinesThreeDiffrentObj());
		deck.add(new CommonGoals_TwoColumsSixDiffrentObj());
		deck.add(new CommonGoals_TwoLinesDiffrentObj());
		deck.add(new CommonGoals_threeColumns());
		deck.add(new CommonGoals_fourVertical());
	}
	
	public CommonGoal extractCommonGoal() {
		
		int c=extractedRandomIndex(); 
		
		System.out.println("card"+c);
		CommonGoal goal = deck.get(c);
		
		return goal;
	}
	
	public BookshelfObject[][] extractPersonalcard() {
		int b=extractedRandomIndex(); 
		
		System.out.println("card"+b);
		BookshelfObject[][] library=null;
		
		BookshelfObject cat = BookshelfObject.CAT;
		BookshelfObject book = BookshelfObject.BOOK;
		BookshelfObject game = BookshelfObject.GAME;
		BookshelfObject frame = BookshelfObject.FRAME;
		BookshelfObject trophy = BookshelfObject.TROPHY;
		BookshelfObject plant = BookshelfObject.PLANT;
		
		/*
		switch (b) {
		case 0:
			library [0][0]=plant;
			library [0][2]=frame;
			library [1][4]=cat;
			library [2][3]=book;
			library [3][1]=game;
			library [5][2]=trophy;
			break;
			
		case 1:
			library [1][1]=plant;
			library [2][0]=cat;
			library [2][2]=game;
			library [3][4]=book;
			library [4][3]=trophy;
			library [5][4]=frame;
			break;
	
		case 2:
			library [1][0]=frame;
			library [1][3]=game;
			library [2][2]=plant;
			library [3][1]=cat;
			library [3][4]=trophy;
			library [5][0]=book;
			break;
			
		case 3:
			library [0][4]=game;
			library [2][0]=trophy;
			library [2][2]=frame;
			library [3][3]=plant;
			library [4][1]=book;
			library [4][2]=cat;
			break;
			
		case 4:
			library [1][1]=trophy;
			library [3][1]=frame;
			library [3][2]=book;
			library [4][4]=plant;
			library [5][0]=game;
			library [5][3]=cat;
			break;
			
		case 5:
			library [0][2]=trophy;
			library [0][4]=cat;
			library [2][3]=book;
			library [4][1]=game;
			library [4][3]=frame;
			library [5][0]=plant;
			break;

		case 6:
			library [0][0]=cat;
			library [1][3]=frame;
			library [2][1]=plant;
			library [3][0]=trophy;
			library [4][4]=game;
			library [5][2]=book;
			break;
			
		case 7:
			library [0][4]=frame;
			library [1][1]=cat;
			library [2][2]=trophy;
			library [3][0]=plant;
			library [4][3]=book;
			library [5][3]=game;
			break;
			
		case 8:
			library [0][2]=game;
			library [2][2]=cat;
			library [3][4]=book;
			library [4][1]=trophy;
			library [4][4]=plant;
			library [5][0]=frame;
			break;
			
		case 9:
			library [0][2]=plant;
			library [1][1]=book;
			library [2][0]=game;
			library [3][2]=frame;
			library [4][4]=cat;
			library [5][3]=trophy;
			break;
			
		case 10:
			library [0][4]=trophy;
			library [1][1]=game;
			library [2][0]=book;
			library [3][3]=cat;
			library [4][1]=frame;
			library [5][3]=plant;
			break;
			
		case 11:
			library [1][2]=book;
			library [1][1]=plant;
			library [2][2]=frame;
			library [3][3]=trophy;
			library [4][4]=game;
			library [5][0]=cat;
			break;
		}*/
		return library;
	}
	
	
public int checkPersonal(BookshelfObject[][] finishedLib,BookshelfObject[][] extractedLib) {
		
		int cont=0;
		BookshelfObject object0 = null;
		BookshelfObject object1 = null;
		for(int row = 0; row < finishedLib.length; row++)
			for(int col = 0; col < finishedLib.length; col++)
			{	
				object0 = finishedLib[row][col];
				object1 = extractedLib[row][col];
				
				if(object0!=null && object1!=null) {
					
					if(object0.name()==object1.name()) {
						cont++;	
					}	
				}	
			}	
		int points=0;
		switch(cont) {
		
		case 0:
			points=0;
			break;
		case 1:
			points=cont;
			break;	
		case 2:
			points=cont;
			break;
		case 3:
			points=cont+1;
			break;
		case 4:
			points=cont+2;
			break;
		case 5:
			points=cont+4;
			break;
		case 6:
			points=cont+6;
			break;
		}		
		return points;
	}
}