package goal.common;

import java.util.ArrayList;

import java.util.HashSet;

import goal.CommonGoal;
import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import resource.Images;
import utils.MatrixCoords;

public class CommonGoal_SixSeparateGroupsOfTwoObj extends CommonGoal {
	
	@Override
	public Images getImage() {
		return Images.COMMON_GOAL_SIX_SEPARATE_GROUPS_OF_TWO_OBJ;
	}

	@Override
	public int check(Bookshelf bookshelf) {
		
		boolean isISOLATED=true;
		int isPresentInBlackList=0;
		ArrayList<MatrixCoords> CoordsUsed = new ArrayList<>();
		HashSet<MatrixCoords> CoordsBlackList = new HashSet<>();
	
		for(int row=5; row > bookshelf.getRows()-6; row--) {
			for(int col = 0; col < bookshelf.getCols(); col++) {
				
				
			    int CURRENT_COL=col;
			    int CURRENT_ROW=row;
			    int UPPER_ROW=row-1;
			    
			    //adjacent vertical right
			    int adjacent_col=col+1;
			    int adjacent1_ROW=row;
			    int adjacent2_ROW=row-1;
			    
			    //right horizontal down
			    int Horizontal1_COL=col+1;
			    int Horizontal_ROW=row;
			    int Horizontal2_COL=col+2;
			   
			    
			    //right horizontal up
			    int HorizontalUP1_COL=col+1;
			    int HorizontalUP_ROW=row-1;
			    int HorizontalUP2_COL=col+2;
			    
			    // horizontal upper 
			    int HorizontalUpper1_COL=col;
			    int HorizontalUpper_ROW=row-2;
			    int HorizontalUpper2_COL=col+1;
			 
			    
			    //vertical
			    int VerticalUpper_COL=col;
			    int VerticalUpper1_ROW=row-2;
			    int VerticalUpper2_ROW=row-3;
			    
			    
				BookshelfObject RefobjUnder = bookshelf.get(new MatrixCoords(CURRENT_ROW, CURRENT_COL));
				BookshelfObject RefobjUpper = bookshelf.get(new MatrixCoords(UPPER_ROW, CURRENT_COL));
				if( RefobjUnder!=null && RefobjUpper!=null) {
				   if(RefobjUnder.name()==RefobjUpper.name()) {
					   
					   
					   if(!(CoordsBlackList.isEmpty())) {
					   for(MatrixCoords black: CoordsBlackList) {
						   if(black.equals(new MatrixCoords(CURRENT_ROW, CURRENT_COL))==true ||  black.equals(new MatrixCoords(UPPER_ROW, CURRENT_COL))==true  ) {
							   isPresentInBlackList=1;
						   }
					   }
					   }
					   
					   if(isPresentInBlackList==0) {
						   if(!(IsIsolated(new MatrixCoords(adjacent1_ROW, adjacent_col), new MatrixCoords(adjacent2_ROW, adjacent_col), bookshelf))){
						   	CoordsBlackList.add(new MatrixCoords(CURRENT_ROW, CURRENT_COL));
						   	CoordsBlackList.add(new MatrixCoords(UPPER_ROW, CURRENT_COL));
						   
						   
						   	CoordsBlackList.add(new MatrixCoords(adjacent1_ROW, adjacent_col));
						   	CoordsBlackList.add(new MatrixCoords(adjacent2_ROW, adjacent_col));
						   	isISOLATED=false;
					   	}
					   
					   	if(!(IsIsolated(new MatrixCoords(Horizontal_ROW, Horizontal1_COL), new MatrixCoords(Horizontal_ROW, Horizontal2_COL), bookshelf))){
						   	CoordsBlackList.add(new MatrixCoords(CURRENT_ROW, CURRENT_COL));
						   	CoordsBlackList.add(new MatrixCoords(UPPER_ROW, CURRENT_COL));
						   
						   	CoordsBlackList.add(new MatrixCoords(Horizontal_ROW, Horizontal1_COL));
						   	CoordsBlackList.add(new MatrixCoords(Horizontal_ROW, Horizontal2_COL));
						   	isISOLATED=false;
					   	}
					   
					   	if(!(IsIsolated(new MatrixCoords(HorizontalUP_ROW, HorizontalUP1_COL), new MatrixCoords(HorizontalUP_ROW, HorizontalUP2_COL), bookshelf))){
						   	CoordsBlackList.add(new MatrixCoords(CURRENT_ROW, CURRENT_COL));
						   	CoordsBlackList.add(new MatrixCoords(UPPER_ROW, CURRENT_COL));
						 
						   	CoordsBlackList.add(new MatrixCoords(HorizontalUP_ROW, HorizontalUP1_COL));
						   	CoordsBlackList.add(new MatrixCoords(HorizontalUP_ROW, HorizontalUP2_COL));
						   	isISOLATED=false;
					   	}
					   if(row>=2) {
					   	if(!(IsIsolated(new MatrixCoords(HorizontalUpper_ROW, HorizontalUpper1_COL), new MatrixCoords(HorizontalUpper_ROW, HorizontalUpper2_COL), bookshelf))){
						   	CoordsBlackList.add(new MatrixCoords(CURRENT_ROW, CURRENT_COL));
						   	CoordsBlackList.add(new MatrixCoords(UPPER_ROW, CURRENT_COL));
						 
						   	CoordsBlackList.add(new MatrixCoords(HorizontalUpper_ROW, HorizontalUpper1_COL));
						   	CoordsBlackList.add(new MatrixCoords(HorizontalUpper_ROW, HorizontalUpper2_COL));
						   	isISOLATED=false;
					   	}
					   }
					   if(row>=3) {
					   	if(!(IsIsolated(new MatrixCoords(VerticalUpper1_ROW, VerticalUpper_COL), new MatrixCoords(VerticalUpper2_ROW, VerticalUpper_COL), bookshelf))){
						   	CoordsBlackList.add(new MatrixCoords(CURRENT_ROW, CURRENT_COL));
						   	CoordsBlackList.add(new MatrixCoords(UPPER_ROW, CURRENT_COL));
						 
						   	CoordsBlackList.add(new MatrixCoords(VerticalUpper1_ROW, VerticalUpper_COL));
						   	CoordsBlackList.add(new MatrixCoords(VerticalUpper2_ROW, VerticalUpper_COL));
						   	isISOLATED=false;
					   	}
					   }
					   if(col==4 && row>=3) {
						   if(!(IsIsolated(new MatrixCoords(HorizontalUpper_ROW, HorizontalUpper1_COL), new MatrixCoords(HorizontalUpper_ROW, HorizontalUpper2_COL-2), bookshelf))){
							   	CoordsBlackList.add(new MatrixCoords(CURRENT_ROW, CURRENT_COL));
							   	CoordsBlackList.add(new MatrixCoords(UPPER_ROW, CURRENT_COL));
							 
							   	CoordsBlackList.add(new MatrixCoords(HorizontalUpper_ROW, HorizontalUpper1_COL));
							   	CoordsBlackList.add(new MatrixCoords(HorizontalUpper_ROW, HorizontalUpper2_COL-2));
							   	isISOLATED=false;
						   	}
						   
					   }
					   
					   
					   
					   
					   	if(isISOLATED==true) {
						   	CoordsUsed.add(new MatrixCoords(CURRENT_ROW, CURRENT_COL));
						   	CoordsUsed.add(new MatrixCoords(UPPER_ROW, CURRENT_COL)); 
						   	
					   	}
					   
					   }
					   isPresentInBlackList=0;
					   isISOLATED=true;
				   }
				}	
			}

		}
		
		for(int row=5; row > bookshelf.getRows()-6; row--) {
			for(int col = 0; col < bookshelf.getCols()-1; col++) {
				
				
			    int CURRENT_R_COL=col+1;
			    int CURRENT_L_COL=col;
			    int CURRENT_ROW=row;
			    
			    
			    //adjacent vertical right
			    int adjacent_col=col+1;
			    int adjacent1_ROW=row;
			    int adjacent2_ROW=row-1;
			    
			    
			    
			    //right horizontal down
			    int Horizontal1_COL=col+1;
			    int Horizontal_ROW=row;
			    int Horizontal2_COL=col+2;
			   
			    // horizontal upper 
			    int HorizontalUpper1_COL=col;
			    int HorizontalUpper_ROW=row-1;
			    int HorizontalUpper2_COL=col+1;
			    
			    // vertical up left
			    int VerticalUpper_L_COL=col;
			    int VerticalUpper1_L_ROW=row-1;
			    int VerticalUpper2_L_ROW=row-2;
			    
			    //vertical up right
			    int VerticalUpper_R_COL=col+1;
			    int VerticalUpper1_R_ROW=row-1;
			    int VerticalUpper2_R_ROW=row-2;
			    
			    
				BookshelfObject RefobjUnder = bookshelf.get(new MatrixCoords(CURRENT_ROW, CURRENT_L_COL));
				BookshelfObject RefobjUpper = bookshelf.get(new MatrixCoords(CURRENT_ROW, CURRENT_R_COL));
				if( RefobjUnder!=null && RefobjUpper!=null) {
				   if(RefobjUnder.name()==RefobjUpper.name()) {
					   
					   
					   if(!(CoordsBlackList.isEmpty())) {
					   for(MatrixCoords black: CoordsBlackList) {
						   if(black.equals(new MatrixCoords(CURRENT_ROW, CURRENT_L_COL))==true ||  black.equals(new MatrixCoords(CURRENT_ROW, CURRENT_R_COL))==true  ) {
							   isPresentInBlackList=1;
						   }
					   }
					   }
					   
					   if(isPresentInBlackList==0) {
						   if(!(IsIsolated(new MatrixCoords(adjacent1_ROW, adjacent_col), new MatrixCoords(adjacent2_ROW, adjacent_col), bookshelf))){
						   	CoordsBlackList.add(new MatrixCoords(CURRENT_ROW, CURRENT_L_COL));
						   	CoordsBlackList.add(new MatrixCoords(CURRENT_ROW, CURRENT_R_COL));
						   
						   
						   	CoordsBlackList.add(new MatrixCoords(adjacent1_ROW, adjacent_col));
						   	CoordsBlackList.add(new MatrixCoords(adjacent2_ROW, adjacent_col));
						   	isISOLATED=false;
					   	}
					   
					   	if(!(IsIsolated(new MatrixCoords(Horizontal_ROW, Horizontal1_COL), new MatrixCoords(Horizontal_ROW, Horizontal2_COL), bookshelf))){
						   	CoordsBlackList.add(new MatrixCoords(CURRENT_ROW, CURRENT_L_COL));
						   	CoordsBlackList.add(new MatrixCoords(CURRENT_ROW, CURRENT_R_COL));
						   
						   	CoordsBlackList.add(new MatrixCoords(Horizontal_ROW, Horizontal1_COL));
						   	CoordsBlackList.add(new MatrixCoords(Horizontal_ROW, Horizontal2_COL));
						   	isISOLATED=false;
					   	}
					 	if(!(IsIsolated(new MatrixCoords(HorizontalUpper_ROW, HorizontalUpper1_COL), new MatrixCoords(HorizontalUpper_ROW, HorizontalUpper2_COL), bookshelf))){
						   	CoordsBlackList.add(new MatrixCoords(CURRENT_ROW, CURRENT_L_COL));
						   	CoordsBlackList.add(new MatrixCoords(CURRENT_ROW, CURRENT_R_COL));
						 
						   	CoordsBlackList.add(new MatrixCoords(HorizontalUpper_ROW, HorizontalUpper1_COL));
						   	CoordsBlackList.add(new MatrixCoords(HorizontalUpper_ROW, HorizontalUpper2_COL));
						   	isISOLATED=false;
					   	}
					   	
					   	
					   if(row>=3) {
					   	if(!(IsIsolated(new MatrixCoords(VerticalUpper1_L_ROW, VerticalUpper_L_COL), new MatrixCoords(VerticalUpper2_L_ROW, VerticalUpper_L_COL), bookshelf))){
						   	CoordsBlackList.add(new MatrixCoords(CURRENT_ROW, CURRENT_L_COL));
						   	CoordsBlackList.add(new MatrixCoords(CURRENT_ROW, CURRENT_R_COL));
						 
						   	CoordsBlackList.add(new MatrixCoords(VerticalUpper1_L_ROW, VerticalUpper_L_COL));
						   	CoordsBlackList.add(new MatrixCoords(VerticalUpper2_L_ROW, VerticalUpper_L_COL));
						   	isISOLATED=false;
					   	}
					   }
			
					   
					   if(row>=3) {
					   	if(!(IsIsolated(new MatrixCoords(VerticalUpper1_R_ROW, VerticalUpper_R_COL), new MatrixCoords(VerticalUpper2_R_ROW, VerticalUpper_R_COL), bookshelf))){
						   	CoordsBlackList.add(new MatrixCoords(CURRENT_ROW, CURRENT_L_COL));
						   	CoordsBlackList.add(new MatrixCoords(CURRENT_ROW, CURRENT_R_COL));
						 
						   	CoordsBlackList.add(new MatrixCoords(VerticalUpper1_R_ROW, VerticalUpper_R_COL));
						   	CoordsBlackList.add(new MatrixCoords(VerticalUpper2_R_ROW, VerticalUpper_R_COL));
						   	isISOLATED=false;
					   	}
					   }
					   
					   	if(isISOLATED==true) {
						   	CoordsUsed.add(new MatrixCoords(CURRENT_ROW, CURRENT_L_COL));
						   	CoordsUsed.add(new MatrixCoords(CURRENT_ROW, CURRENT_R_COL)); 
						   	
					   	}
					   
					   }
					   isPresentInBlackList=0;
					   isISOLATED=true;
				   }
				}	
			}

		}
	if(CoordsUsed.size()>=12) {
		return 1;
	}else {
		return 0;
	}
	}
	
	public static boolean IsIsolated(MatrixCoords cords1,MatrixCoords cords2, Bookshelf bookshelf) {
		BookshelfObject OBJ1 = bookshelf.get(new MatrixCoords(cords1.r, cords1.c));
		BookshelfObject OBJ2 = bookshelf.get(new MatrixCoords(cords2.r, cords2.c));
		
		if(OBJ1!=null &&OBJ2!=null ) {
			if(OBJ1.name()==OBJ2.name()) {
				return false;
			}
			return true;	
		}
		return true;
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
