package personalGoals;

import utils.MatrixCoords;
import myshelfie.BookshelfObject;

public class ObjPosition {
	MatrixCoords cords;
	BookshelfObject object;

	
	
	public ObjPosition(int r, int c, BookshelfObject obj){
		this.cords=new MatrixCoords(r,c);
		this.object=obj;
	};
	
	
	
	
}
