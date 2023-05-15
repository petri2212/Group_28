package commonGoal;

import java.util.ArrayList;

import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import resource.Images;
import utils.MatrixCoords;

public class CommonGoal_SixSeparateGroupsOfTwoObj extends CommonGoal {
	
	private boolean forthRowfull = false;
	private boolean isItCompleted=false;

	@Override
	public Images getImage() {
		return Images.COMMON_GOAL_SIX_SEPARATE_GROUPS_OF_TWO_OBJ;
	}

	@Override
	public int check(Bookshelf bookshelf) {
		
		if(!isItCompleted) {
		if(this.forthRowfull==false){
			this.forthRowfull=bookshelf.checkIfRowIsfull(4);
		}
		
		ArrayList<MatrixCoords> CoordsUsed = new ArrayList<>();
		if(this.forthRowfull==true) {
			
			for(int row=5; row > bookshelf.getRows()-4; row--) {
				for(int col = 0; col < bookshelf.getCols(); col++) {
					
					BookshelfObject objUnder = bookshelf.get(new MatrixCoords(row, col));
					BookshelfObject objUpper = bookshelf.get(new MatrixCoords(row--, col));
					
					if (objUnder.name()==objUpper.name()) {
						if(CoordsUsed.isEmpty()) {
						CoordsUsed.add(new MatrixCoords(row,col));
						CoordsUsed.add(new MatrixCoords(row--,col));
						}else {
							int cont=0;
							for (MatrixCoords posUsed : CoordsUsed) {
								if(!(posUsed.equals(new MatrixCoords(row, col)) || posUsed.equals(new MatrixCoords(row--, col)))){
									cont++;	
								}
							}
							
							if (cont==0) {
								CoordsUsed.add(new MatrixCoords(row,col));
								CoordsUsed.add(new MatrixCoords(row--,col));
							}
							
							cont=0;
						}		
					}
				}
			}
			for(int row=5; row > bookshelf.getRows()-5; row--) {
				for(int col = 0; col < bookshelf.getCols()-1; col++) {
					BookshelfObject objUnder = bookshelf.get(new MatrixCoords(row, col));
					BookshelfObject objUpper = bookshelf.get(new MatrixCoords(row, col++));
					
					if (objUnder.name()==objUpper.name()) {
						if(CoordsUsed.isEmpty()) {
						CoordsUsed.add(new MatrixCoords(row,col));
						CoordsUsed.add(new MatrixCoords(row,col++));
						}else {
							int cont=0;
							for (MatrixCoords posUsed : CoordsUsed) {
								if(!(posUsed.equals(new MatrixCoords(row, col)) || posUsed.equals(new MatrixCoords(row, col++)))){
									cont++;	
								}
							}
							
							if (cont==0) {
								CoordsUsed.add(new MatrixCoords(row,col));
								CoordsUsed.add(new MatrixCoords(row,col++));
							}
							
							cont=0;
						}		
					}
				}
			}
		}
		if(CoordsUsed.size()==12) {
		isItCompleted=true;
		return 1;
		}else {
		return 0;
		}
		}
		return 1;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		String desc="Six groups each containing at least\r\n"
				+ "2 tiles of the same type (not necessarily\r\n"
				+ "in the depicted shape).\r\n"
				+ "The tiles of one group can be different\r\n"
				+ "from those of another group.";
		return desc;
	}
}
