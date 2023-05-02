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
		fillDeckCardsC();
	};
	
	public int extractedRandomIndex() {
		Random RANDOM = new Random();
		int extracted_num=RANDOM.nextInt(12);
		return extracted_num;
	}
	
	private void fillDeckCardsP() {
		deckcommon.add(new CommonGoal_SixSeparateGroupsOfTwoObj());
		deckcommon.add(new CommonGoal_TwoFourByFourSquares());
		deckcommon.add(new CommonGoal_Corners());
		deckcommon.add(new CommonGoal_FourVertical());
		deckcommon.add(new CommonGoal_ThreeColumns());
		deckcommon.add(new CommonGoal_EightEqual());
		deckcommon.add(new CommonGoal_Diagonal());
		deckcommon.add(new CommonGoal_FourLinesThreeDiffrentObj());
		deckcommon.add(new CommonGoal_TwoColumsSixDiffrentObj());
		deckcommon.add(new CommonGoal_TwoLinesDiffrentObj());
		deckcommon.add(new CommonGoal_FiveX());
		deckcommon.add(new CommonGoal_Stairs());
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