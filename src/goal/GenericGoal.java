package goal;

import java.util.HashSet;
import java.util.Iterator;

import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;

public class GenericGoal implements Goal {

	@Override
	public int check(Bookshelf bookshelf) {
		
		
		for (int r = 0; r < bookshelf.getRows(); r++) {
			HashSet<BookshelfObject> tmpRow = new HashSet<>();

			for (int c = 0; c < bookshelf.getCols(); c++) {
				
			}
			
		}
		
		

		return 0;
	}

}
