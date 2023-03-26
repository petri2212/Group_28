package myshelfie;

import java.util.Random;
import commonGoal.CommonGoal;
import commonGoal.A;
import commonGoal.B;
import commonGoal.C;
import commonGoal.D;
import commonGoal.E;
import commonGoal.F;
import commonGoal.G;
import commonGoal.H;
import commonGoal.I;
import commonGoal.L;
import commonGoal.M;
import commonGoal.N;
public class Extratcards {
	
	//private static Random RANDOM = new Random();
	
	//to be used in main program 
	public Extratcards() {
		
	};
	
	public int extractedCard() {
		Random RANDOM = new Random();
		int extracted_num=RANDOM.nextInt(12);
		return extracted_num;
	}
	
	
	public CommonGoal extractCommon() {
		int c=0; 
		c=extractedCard();
		System.out.println("card"+c);
		CommonGoal goal = null;
		switch (c) {
		case 0:
			goal=new A();
			break;
			
		case 1:
			goal=new B();
			break;
	
		case 2:
			goal=new C();
			break;
			
		case 3:
			goal=new D();
			break;
			
		case 4:
			goal=new E();
			break;
			
		case 5:
			goal=new F();
			break;

		case 6:
			goal=new G();
			break;
			
		case 7:
			goal=new H();
			break;
			
		case 8:
			goal=new I();
			break;
			
		case 9:
			goal=new L();
			break;
			
		case 10:
			goal=new M();
			break;
			
		case 11:
			goal=new N();
			break;
		}
		
		
		return goal;
		

	}
}
