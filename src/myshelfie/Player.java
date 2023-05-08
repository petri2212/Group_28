package myshelfie;
import java.util.ArrayList;
import commonGoal.*;
import personalGoals.ObjPosition;
import utils.MatrixCoords;
/**
 * Represents a physical player of the game
 */
public class Player {

	private String name;
	private int points;
	protected Bookshelf bookshelf;
	private ObjPosition[] personalGoalPos;
	protected CommonGoal commonGoal1;
	protected CommonGoal commonGoal2;
	/**
	 * To construct a player, the name is needed as identifier to allow the user understanding when
	 * it is his/her turn. A player also holds a bookshelf and has a counter for the game points.
	 *
	 * @param name	a String that is the player identifier
	 */
	public Player(String name) {
		this.name = name;
		bookshelf = new Bookshelf();
		points = 0;
	}

	/**
	 * Returns the name of the player.
	 *
	 * @return	a String containing the player name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Retuns the player bookshelf.
	 *
	 * @return	a reference of type Bookshelf pointing to the bookshelf of the player
	 */
	public Bookshelf getBookshelf() {
		return bookshelf;
	}

	/**
	 * Returns the points of the player
	 *
	 * @return	the points as integer
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Sum the input points to the player's points.
	 *
	 * @param points	an integer corresponding to the amount of points to add
	 */
	public void addPoints(int points) {
		this.points += points;
	}
	/**
	 * This method will assign the personal card positions of the current player in the personalGoalPos attribute and the correspondent commonGoals
	 *
	 * @param pers	an ObjPosition[] correspond to the positions of the personal card objects
	 * @param commonGoal1 assign to the attribute commonGoal1 the first commonGoal extracted
	 * @param commonGoal2 assign to the attribute commonGoal2 the second commonGoal extracted
	 */
	public void assignPersonalGoalPos(ObjPosition[] pers, CommonGoal commonGoal1, CommonGoal commonGoal2 ) {
		this.personalGoalPos=pers;
		this.commonGoal1=commonGoal1;
		this.commonGoal1=commonGoal2;
	}
}
