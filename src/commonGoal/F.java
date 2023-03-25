package commonGoal;

import myshelfie.BookshelfObject;

public class F implements CommonGoal {

	@Override
	public int Checkcommon(BookshelfObject[][] library) {
		// TODO Auto-generated method stub
		int cont=0;
		
		int contCats=0;
		int contBooks=0;
		int contGames=0;
		int contFrames=0;
		int contTrophy=0;
		int contPlants=0;
		
		BookshelfObject object0 = null;
		
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
		
		return cont;
	}

	@Override
	public void Description() {
		// TODO Auto-generated method stub
		System.out.println("Eight tiles of the same type. There’s no\r\n"
				+ "restriction about the position of these\r\n"
				+ "tiles.");
	}
	

}
