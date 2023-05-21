package goal.common;

import java.awt.Image;

import goal.CommonGoal;
import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import resource.Images;
import utils.MatrixCoords;

public class CommonGoal_EightEqual extends CommonGoal {
	
	@Override
	public Image getImage() {
		return Images.COMMON_GOAL_EIGHT_EQUAL.load();
	}

	/**
	 * This method checks that a library has at least 8 tiles of the same type, it works by checking each cell of the library, 
	 * each time a tile is found it increases a counter 
	 *
	 * @param bookshelf the player bookshelf under validation
	 * @return 			a number representing whether the player was first, second or third etc. to complete the goal
	 */

	@Override
	public int check(Bookshelf bookshelf) {
		
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
			
			if(contCats>=8||contBooks>=8||contGames>=8||contFrames>=8||contTrophy>=8||contPlants>=8) {
				return 1;
			}
		return 0;
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
