package commonGoal;

import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import utils.MatrixCoords;

public class CommonGoal_EightEqual extends CommonGoal {

	protected CommonGoal_EightEqual(int playersNumber) {
		super(playersNumber);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int check(Bookshelf bookshelf) {
		// TODO Auto-generated method stub
		int cont=0;
		
		int contCats=0;
		int contBooks=0;
		int contGames=0;
		int contFrames=0;
		int contTrophy=0;
		int contPlants=0;
		
		BookshelfObject object0 = null;
		
		for(int row=0; row < bookshelf.getRows(); row++){
			for(int col = 0; col < bookshelf.getCols(); col++) {
				
				 object0 = bookshelf.get(new MatrixCoords(row, col));
				 
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
	public String getDescription() {
		// TODO Auto-generated method stub
		String desc="Eight tiles of the same type. There’s no\r\n"
				+ "restriction about the position of these\r\n"
				+ "tiles.";
		return desc;
	}
}