package myshelfie;

import java.util.Stack;

public class Points {
	
	private int[] points_values= {2,4,6,8};
    private Stack<Integer> stackCommon1;
    private Stack<Integer> stackCommon2;
	
    /**
     * this class will simulate the pile of cards with the commongoal scores
     * 
     * @param n_players based on the players the score stack changes 
     */
    
	public Points(int n_players) {
		if(n_players == 0 ||n_players == 1) {
			throw new IllegalArgumentException("The players number can't be less than 2");
		}
		
		stackCommon1=new Stack<>();
		stackCommon2=new Stack<>();
		
		if(n_players==2){
			stackCommon1.push(points_values[1]);
			stackCommon1.push(points_values[3]);
			stackCommon2.push(points_values[1]);
			stackCommon2.push(points_values[3]);
		}else if(n_players==3){
			for(int i=1 ; i<n_players+1; i++ ) {
				stackCommon1.push(points_values[i]);
				stackCommon2.push(points_values[i]);
			}
		}else {
			for(int i=0 ; i<n_players; i++ ) {
				stackCommon1.push(points_values[i]);
				stackCommon2.push(points_values[i]);
			}
		}
	}
	/**
	 * this class assigns a certain score from one of the two stacks, 
	 * this score will be added to the player based on the placement array 
	 * provided by the CommonGoalManager
	 * 
	 * @param common_num  it is the parameter that choose from which stack the score will be attributed to the player
	 * @return the score at the top of the stack
	 */
	public int getPoint(int common_num) {

		if(common_num==1) {
			if(stackCommon1.empty()) {
				throw new IllegalStateException("The stack is empty, you can't take points");
			}
			return stackCommon1.pop();
		
			}else {
				if(stackCommon2.empty()) {
					throw new IllegalStateException("The stack is empty, you can't take points");
				}
				return stackCommon2.pop();
			
			}
		
		
	}
}
