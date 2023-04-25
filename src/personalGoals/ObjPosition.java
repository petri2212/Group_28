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
	
	public MatrixCoords getCords() {
		return this.cords;
	}
	
	public BookshelfObject getObj() {
		return this.object;
	}
	
	
}
