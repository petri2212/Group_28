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
		
		switch (card) {
		case 0:
			
			
			break;
		case 1:
			//for(int row=0; row < library.length; row++){
				//for(int col = 0; col < library[0].length; col++) {
						
				//}	
				
			//}
			BookshelfObject object0 = library[0][0];
			BookshelfObject object1 = library[0][4];
			BookshelfObject object2 = library[5][0];
			BookshelfObject object3 = library[0][5];
			
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
