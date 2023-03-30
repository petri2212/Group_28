package commonGoal;

import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;

public class N extends CommonGoal {

	@Override
	public int checkCommon(Bookshelf library) {
		// TODO Auto-generated method stub
		int result=0;
		
		int cont=0;
		BookshelfObject object0 = null;
		BookshelfObject object1 = null;
		int i=1;
		int j=3;
		if(library[0][0]==null && library[0][4]==null) {
			if(library[1][4]==null) {
				for(int row = 1; row < 6; row++) {
					for(int col = 0; col < i; col++)
					{	
						object0 = library[row][col];
						if (i<5) {
						object1 = library[row][i];
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
				
			}else if(library[1][0]==null) {
				for(int row = 1; row < 6; row++) {
					for(int col = 4; col > j; col--)
					{	
						object0 = library[row][col];
						
						if (j>=0) {
							object1 = library[row][j];
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
