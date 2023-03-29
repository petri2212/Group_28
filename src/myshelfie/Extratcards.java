package myshelfie;

import java.util.Random;
import commonGoal.CommonGoal;
import commonGoal.A;
import commonGoal.B;
import commonGoal.C;
import commonGoal.CommonGoals_fourVertical;
import commonGoal.CommonGoals_threeColumns;
import commonGoal.F;
import commonGoal.G;
import commonGoal.H;
import commonGoal.I;
import commonGoal.L;
import commonGoal.M;
import commonGoal.N;
public class Extratcards {
	
	//private static Random RANDOM = new Random();
	
	//to be used in main program 
	public Extratcards() {
		
	};
	
	public int extractedCard() {
		Random RANDOM = new Random();
		int extracted_num=RANDOM.nextInt(12);
		return extracted_num;
	}
	
	
	public CommonGoal extractCommon() {
		int c=0; 
		c=extractedCard();
		System.out.println("card"+c);
		CommonGoal goal = null;
		switch (c) {
		case 0:
			goal=new A();
			break;
			
		case 1:
			goal=new B();
			break;
	
		case 2:
			goal=new C();
			break;
			
		case 3:
			goal=new CommonGoals_fourVertical();
			break;
			
		case 4:
			goal=new CommonGoals_threeColumns();
			break;
			
		case 5:
			goal=new F();
			break;

		case 6:
			goal=new G();
			break;
			
		case 7:
			goal=new H();
			break;
			
		case 8:
			goal=new I();
			break;
			
		case 9:
			goal=new L();
			break;
			
		case 10:
			goal=new M();
			break;
			
		case 11:
			goal=new N();
			break;
		}
		
		
		return goal;
		

	}
	
	public BookshelfObject[][] extractPersonalcard() {
		int b=0; 
		b=extractedCard();
		System.out.println("card"+b);
		BookshelfObject[][] library = {
			{null,	null,	null,	null,	null},
			{null,	null,	null,	null,	null},
			{null,	null,	null,	null,	null},
			{null,	null,	null,	null,	null},
			{null,	null,	null,	null,	null},
			{null,	null,	null,	null,	null},
		};
		
		BookshelfObject cat = BookshelfObject.CAT;
		BookshelfObject book = BookshelfObject.BOOK;
		BookshelfObject game = BookshelfObject.GAME;
		BookshelfObject frame = BookshelfObject.FRAME;
		BookshelfObject trophy = BookshelfObject.TROPHY;
		BookshelfObject plant = BookshelfObject.PLANT;
		
		
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
		}
		
		
		return library;
		

	}
	
	
	
	
	
	
	
	
	
	

	
	
	
}
