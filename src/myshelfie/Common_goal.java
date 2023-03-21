package myshelfie;

import java.util.Random;

public class Common_goal {
	
	private static final Random RANDOM = new Random();
	
	//to be used in main program 
	public int extractedCard() {
		int extracted_num=RANDOM.nextInt(12);
		return extracted_num;
	}
	
	
	public int Checkcommon(int card, BookshelfObject[][] library) {
		int cont = 0; //used to assign points to the first, second, third, fourth place
		BookshelfObject object0 = null;
		BookshelfObject object1 = null;
		BookshelfObject object2 = null;
		BookshelfObject object3 = null;
		//BookshelfObject object4 = null;
		//BookshelfObject object5 = null;
		
		switch (card) {
		case 0:
			
			
			break;
		case 1:
			//for(int row=0; row < library.length; row++){
				//for(int col = 0; col < library[0].length; col++) {
						
				//}	
				
			//}
			object0 = library[0][0];
			object1 = library[0][4];
			object2 = library[5][0];
			object3 = library[0][5];
			
			if(object0.name()!=null&&object1.name()!=null&&object2.name()!=null&&object3.name()!=null) {
				
				if(object0.name()==object1.name()&&object1.name()==object2.name()&&object2.name()==object3.name()) {
					cont++;
					
				}	
			}
			
			break;
			
		case 2:
			
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			int contCats=0;
			int contBooks=0;
			int contGames=0;
			int contFrames=0;
			int contTrophy=0;
			int contPlants=0;
			
			for(int row=0; row < library.length; row++){
				for(int col = 0; col < library[0].length; col++) {
					
					 object0 = library[row][col];
					 
					 if(object0.name()!=null) {
						 	
						 	if(object0.name()=="CAT") {
						 		contCats++;
							 
						 	}else if(object0.name()=="BOOK") {
						 		contBooks++;
						 	}else if(object0.name()=="GAMES") {
						 		contGames++;
						 	}else if(object0.name()=="FRAME") {
						 		contFrames++;
						 	}else if(object0.name()=="TROPHY") {
						 		contTrophy++;
						 	}else {
						 		contPlants++;
						 	}
						 		
						}	
								
				
				}	
			
			}
			
			if(contCats==8||contBooks==8||contGames==8||contFrames==8||contTrophy==8||contPlants==8)
				cont++;
			
			break;

		case 6:
			
			break;
		case 7:
			
			break;
		case 8:
			
			break;
		case 9:
			
			break;
		case 10:
			
			break;
		case 11:
			
			
			break;
		}
		
		
		return cont;
		
		
		
		
		
	}
	

}
