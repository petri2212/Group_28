package commonGoal;

import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import utils.MatrixCoords;

public class CommonGoal_Corners extends CommonGoal {

	protected CommonGoal_Corners(int playersNumber) {
		super(playersNumber);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int check(Bookshelf bookshelf) {
		// TODO Auto-generated method stub
		int cont=0;
		BookshelfObject object0 = bookshelf.get(new MatrixCoords(0, 0));
		BookshelfObject object1 = bookshelf.get(new MatrixCoords(0, 4));
		BookshelfObject object2 = bookshelf.get(new MatrixCoords(5, 0));
		BookshelfObject object3 = bookshelf.get(new MatrixCoords(0, 5));
		
		if(object0!=null && object1!=null && object2!=null && object3!=null) {
			
			if(object0.name()==object1.name()&&object1.name()==object2.name()&&object2.name()==object3.name()) {
				cont++;
				
			}	
		}
		return cont;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		String desc="Four tiles of the same type in the four\r\n"
				+ "corners of the bookshelf.";
		return desc;
	}
}