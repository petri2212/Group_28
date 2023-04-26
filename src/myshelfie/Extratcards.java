package myshelfie;

import java.util.ArrayList;

import java.util.Random;
import commonGoal.*;

import personalGoals.personalGoals;
import personalGoals.ObjPosition;

public class Extratcards {
	
	//private static Random RANDOM = new Random();
	
	//to be used in main program
	ArrayList<CommonGoal> deckcommon = new ArrayList<>();
	ArrayList<ObjPosition[]> deckpersonal = new ArrayList<>();
	
	public Extratcards() {
		fillDeckCardsP();
	};
	
	//this will extract common
	public Extratcards(int c) {
		fillDeckCardsC();
	};
	
	public int extractedRandomIndex() {
		Random RANDOM = new Random();
		int extracted_num=RANDOM.nextInt(12);
		return extracted_num;
	}
	
	private void fillDeckCardsP() {
		
		int playernum=2;
		deckcommon.add(new CommonGoal_SixSeparateGroupsOfTwoObj(playernum));
		deckcommon.add(new CommonGoal_TwoFourByFourSquares(playernum));
		deckcommon.add(new CommonGoal_Corners(playernum));
		deckcommon.add(new CommonGoal_FourVertical(playernum));
		deckcommon.add(new CommonGoal_ThreeColumns(playernum));
		deckcommon.add(new CommonGoal_EightEqual(playernum));
		deckcommon.add(new CommonGoal_Diagonal(playernum));
		deckcommon.add(new CommonGoal_FourLinesThreeDiffrentObj(playernum));
		deckcommon.add(new CommonGoal_TwoColumsSixDiffrentObj(playernum));
		deckcommon.add(new CommonGoal_TwoLinesDiffrentObj(playernum));
		deckcommon.add(new CommonGoal_FiveX(playernum));
		deckcommon.add(new CommonGoal_Stairs(playernum));
	}
	
	private void fillDeckCardsC() {
		personalGoals c=new personalGoals();
		deckpersonal.add(c.personalGoal0());
		deckpersonal.add(c.personalGoal1());
		deckpersonal.add(c.personalGoal2());
		deckpersonal.add(c.personalGoal3());
		deckpersonal.add(c.personalGoal4());
		deckpersonal.add(c.personalGoal5());
		deckpersonal.add(c.personalGoal6());
		deckpersonal.add(c.personalGoal7());
		deckpersonal.add(c.personalGoal8());
		deckpersonal.add(c.personalGoal9());
		deckpersonal.add(c.personalGoal10());
		deckpersonal.add(c.personalGoal11());
	}
	
	
	public CommonGoal extractCommonGoal() {
		
		int c=extractedRandomIndex(); 
		
		System.out.println("card"+c);
		CommonGoal goal = deckcommon.get(c);
		
		return goal;
	}
	
	public ObjPosition[] extractPersonalGoal() {
		
		int p=extractedRandomIndex(); 
		
		System.out.println("card"+p);
		ObjPosition[] objpos = deckpersonal.get(p);
		
		return objpos;
	}

}