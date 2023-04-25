package personalGoals;
import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import utils.MatrixCoords;
public class personalGoals {
	BookshelfObject cat = BookshelfObject.CAT;
	BookshelfObject book = BookshelfObject.BOOK;
	BookshelfObject game = BookshelfObject.GAME;
	BookshelfObject frame = BookshelfObject.FRAME;
	BookshelfObject trophy = BookshelfObject.TROPHY;
	BookshelfObject plant = BookshelfObject.PLANT;

	public ObjPosition[] personalGoal0() {
		 ObjPosition[] arr = null;
		 
		 arr[0]= new ObjPosition(0,0, plant);
		 arr[1]= new ObjPosition(0,2, frame);
		 arr[2]= new ObjPosition(1,4, cat);
		 arr[3]= new ObjPosition(2,3, book);
		 arr[4]= new ObjPosition(3,1, game);
		 arr[6]= new ObjPosition(5,2, trophy);
		
		 return arr;
		
	}
	public ObjPosition[] personalGoal1() {
		ObjPosition[] arr = null;
		
		 arr[0]= new ObjPosition(1,1, plant);
		 arr[1]= new ObjPosition(2,0, cat);
		 arr[2]= new ObjPosition(2,2, game);
		 arr[3]= new ObjPosition(3,4, book);
		 arr[4]= new ObjPosition(4,3, trophy);
		 arr[6]= new ObjPosition(5,4, frame);
		
		return arr;
		
	}
	
	public ObjPosition[] personalGoal2() {
		ObjPosition[] arr = null;
		
		 arr[0]= new ObjPosition(1,0, frame);
		 arr[1]= new ObjPosition(1,3, game);
		 arr[2]= new ObjPosition(2,2, plant);
		 arr[3]= new ObjPosition(3,1, cat);
		 arr[4]= new ObjPosition(3,4, trophy);
		 arr[6]= new ObjPosition(5,0, book);
		
		return arr;
		
	}
	public ObjPosition[] personalGoal3() {
		ObjPosition[] arr = null;
		
		 arr[0]= new ObjPosition(0,4, game);
		 arr[1]= new ObjPosition(2,0, trophy);
		 arr[2]= new ObjPosition(2,2, frame);
		 arr[3]= new ObjPosition(3,3, plant);
		 arr[4]= new ObjPosition(4,1, book);
		 arr[6]= new ObjPosition(4,2, cat);
		
		return arr;
		
	}
	public ObjPosition[] personalGoal4() {
		ObjPosition[] arr = null;
		
		 arr[0]= new ObjPosition(1,1, trophy);
		 arr[1]= new ObjPosition(3,1, frame);
		 arr[2]= new ObjPosition(3,2, book);
		 arr[3]= new ObjPosition(4,4, plant);
		 arr[4]= new ObjPosition(5,0, game);
		 arr[6]= new ObjPosition(5,3, cat);
		
		return arr;
		
	}
	public ObjPosition[] personalGoal5() {
		ObjPosition[] arr = null;
		
		 arr[0]= new ObjPosition(0,2, trophy);
		 arr[1]= new ObjPosition(0,4, cat);
		 arr[2]= new ObjPosition(2,3, book);
		 arr[3]= new ObjPosition(4,1, game);
		 arr[4]= new ObjPosition(4,3, frame);
		 arr[6]= new ObjPosition(5,0, plant);
		
		return arr;
		
	}
	public ObjPosition[] personalGoal6() {
		ObjPosition[] arr = null;
		
		 arr[0]= new ObjPosition(0,0, cat);
		 arr[1]= new ObjPosition(1,3, frame);
		 arr[2]= new ObjPosition(2,1, plant);
		 arr[3]= new ObjPosition(3,0, trophy);
		 arr[4]= new ObjPosition(4,4, game);
		 arr[6]= new ObjPosition(5,2, book);
		
		return arr;
		
	}
	public ObjPosition[] personalGoal7() {
		ObjPosition[] arr = null;
		
		 arr[0]= new ObjPosition(0,4, frame);
		 arr[1]= new ObjPosition(1,1, cat);
		 arr[2]= new ObjPosition(2,2, trophy);
		 arr[3]= new ObjPosition(3,0, plant);
		 arr[4]= new ObjPosition(4,3, book);
		 arr[6]= new ObjPosition(5,3, game);
		
		return arr;
		
	}
	public ObjPosition[] personalGoal8() {
		ObjPosition[] arr = null;
		
		 arr[0]= new ObjPosition(0,2, game);
		 arr[1]= new ObjPosition(2,2, cat);
		 arr[2]= new ObjPosition(3,4, book);
		 arr[3]= new ObjPosition(4,1, trophy);
		 arr[4]= new ObjPosition(4,4, plant);
		 arr[6]= new ObjPosition(5,0, frame);
		
		return arr;
		
	}
	public ObjPosition[] personalGoal9() {
		ObjPosition[] arr = null;
		
		 arr[0]= new ObjPosition(0,2, plant);
		 arr[1]= new ObjPosition(1,1, book);
		 arr[2]= new ObjPosition(2,0, game);
		 arr[3]= new ObjPosition(3,2, frame);
		 arr[4]= new ObjPosition(4,4, cat);
		 arr[6]= new ObjPosition(5,3, trophy);
		
		return arr;
		
	}
	public ObjPosition[] personalGoal10() {
		ObjPosition[] arr = null;
		
		 arr[0]= new ObjPosition(0,4, trophy);
		 arr[1]= new ObjPosition(1,1, game);
		 arr[2]= new ObjPosition(2,0, book);
		 arr[3]= new ObjPosition(3,3, cat);
		 arr[4]= new ObjPosition(4,1, frame);
		 arr[6]= new ObjPosition(5,3, plant);
		
		return arr;
		
	}
	public ObjPosition[] personalGoal11() {
		ObjPosition[] arr = null;
		
		 arr[0]= new ObjPosition(1,2, book);
		 arr[1]= new ObjPosition(1,1, plant);
		 arr[2]= new ObjPosition(2,2, frame);
		 arr[3]= new ObjPosition(3,3, trophy);
		 arr[4]= new ObjPosition(4,4, game);
		 arr[6]= new ObjPosition(5,0, cat);
		
		return arr;
		
	}
	
public int checkPersonal(Bookshelf finishedLib, ObjPosition[] personalCard) {
		
		int cont=0;
		BookshelfObject object0 = null;
		BookshelfObject object1 = null;
		
		ObjPosition temp;
		
		for (int i=0; i<personalCard.length; i++){
			temp=personalCard[0];
			
			int r=temp.getCords().r;
			int c=temp.getCords().c;
			object0=finishedLib.get(new MatrixCoords(r, c));
			object1=temp.object;
			
			if(object0!=null && object1!=null) {
				
				if(object0.name()==object1.name()) {
					cont++;	
				}	
		
			}
		}
		
		
		int points=0;
		switch(cont) {
		
		case 0:
			points=0;
			break;
		case 1:
			points=cont;
			break;	
		case 2:
			points=cont;
			break;
		case 3:
			points=cont+1;
			break;
		case 4:
			points=cont+2;
			break;
		case 5:
			points=cont+4;
			break;
		case 6:
			points=cont+6;
			break;
		}		
		return points;
}
}
