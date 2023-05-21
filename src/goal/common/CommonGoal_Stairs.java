package goal.common;


import java.awt.Image;

import goal.CommonGoal;
import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import resource.Images;
import utils.MatrixCoords;

public class CommonGoal_Stairs extends CommonGoal {

	@Override
	public Image getImage() {
		return Images.COMMON_GOAL_STAIRS.load();
	}

	/**
	 * This method verifies that the player has created an ascending or descending stair form with his tiles.
	 * Check that the first row is empty, if this happens the tiles are counted using a counter, 
	 * if the counter is equal to 15 it means that the player has formed a stair form with his tiles.
	 *
	 * @param bookshelf the player bookshelf under validation
	 * @return 			a number representing whether the player was first, second or third etc. to complete the goal
	 */

	@Override
	public int check(Bookshelf bookshelf) {
	
	 	int cont=0;
		
		int i=5;
		BookshelfObject objA = bookshelf.get(new MatrixCoords(0, 0));
		BookshelfObject objB = bookshelf.get(new MatrixCoords(0, 4));
		BookshelfObject objC = bookshelf.get(new MatrixCoords(1, 4));
		BookshelfObject objD = bookshelf.get(new MatrixCoords(1, 0));

		if(objA == null && objB == null) {
			if(objC == null) {
				for(int c=4;c>=0;c--) {
					int RowemptyNumber=bookshelf.getFirstFilledRow(c);
					if(RowemptyNumber==i) {
						cont=1;	
					}else {
						return 0;
					}
					i--;
				}
				
				
				
			
			}else if(objD == null) {
				for(int c=0;c<bookshelf.getCols();c++) {
					int RowemptyNumber=bookshelf.getFirstFilledRow(c);
					if(RowemptyNumber==i) {
						cont=1;	
					}else {
						return 0;
					}
					i--;
				}
			}	
		}
		return cont;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		String desc="Five columns of increasing or decreasing\r\n"
				+ "height. Starting from the first column on\r\n"
				+ "the left or on the right, each next column\r\n"
				+ "must be made of exactly one more tile.\r\n"
				+ "Tiles can be of any type. ";
		return desc;
	}
}
