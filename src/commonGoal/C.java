package commonGoal;

import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;

public class C extends CommonGoal {

	@Override
	public int checkCommon(Bookshelf library) {
		// TODO Auto-generated method stub
		int cont=0;
		BookshelfObject object0 = null;
		BookshelfObject object1 = null;
		BookshelfObject object2 = null;
		BookshelfObject object3 = null;
		object0 = library[0][0];
		object1 = library[0][4];
		object2 = library[5][0];
		object3 = library[0][5];
		
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
