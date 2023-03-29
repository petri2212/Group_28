package commonGoal;

import javafx.print.Printer.MarginType;
import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import utils.MatrixCoords;

public class CommonGoal_Stairs extends CommonGoal {

	protected CommonGoal_Stairs(int playersNumber) {
		super(playersNumber);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int check(Bookshelf bookshelf) {
		// TODO Auto-generated method stub
		int result=0;
		
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
			result++;
		}
		
		return result;
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
