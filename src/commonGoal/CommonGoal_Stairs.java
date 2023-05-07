package commonGoal;


import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import utils.MatrixCoords;

public class CommonGoal_Stairs extends CommonGoal {
	
	private boolean isItCompleted=false;

	public CommonGoal_Stairs() {
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		if(!isItCompleted) {
			int cont=0;
			BookshelfObject object0 = null;
			BookshelfObject object1 = null;
			int i=1;
			int j=3;
			BookshelfObject objA = bookshelf.get(new MatrixCoords(0, 0));
			BookshelfObject objB = bookshelf.get(new MatrixCoords(0, 4));
			BookshelfObject objC = bookshelf.get(new MatrixCoords(1, 4));
			BookshelfObject objD = bookshelf.get(new MatrixCoords(1, 0));

			if(objA == null && objB == null) {
				if(objC == null) {
					for(int row = 1; row < bookshelf.getRows(); row++) {
						for(int col = 0; col < i; col++) {
							object0 = bookshelf.get(new MatrixCoords(row, col));
							if (i<5) {
							object1 = bookshelf.get(new MatrixCoords(row, i));
							}else {
								object1=null;
							}
								if(object0!=null && object1==null) {
									cont++;
									}else {
										return 0;
									}
							}
						i++;
				
						}
				
				}else if(objD == null) {
					for(int row = 1; row < 6; row++) {
						for(int col = 4; col > j; col--) {
							object0 = bookshelf.get(new MatrixCoords(row, col));
						
							if (j>=0) {
								object1 = bookshelf.get(new MatrixCoords(row, j));
							}else {
								object1=null;
							}
								
							if(object0!=null && object1==null) {
								cont++;
							}else {
								return 0;
								}
						
						}
						j--;
				
						}
				}	
			
			}
		
			if(cont==15) {
				isItCompleted=true;
				return 1;
			}
		}
		
		return 0;
		
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
	
	@Override
	public boolean getIsItCompleted() {
		// TODO Auto-generated method stub
		return isItCompleted;
	}

}
