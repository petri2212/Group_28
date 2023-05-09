package myshelfie;
import java.util.ArrayList;
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
	 * This method will assign the personal card positions of the current player 
	 *
	 * @param pers	an ObjPosition[] correspond to the positions of the personal card objects
	 */
	public void assignPersonalGoalPos(ObjPosition[] pers) {
		this.personalGoalPos=pers;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Player)) {
			throw new IllegalArgumentException("You must pass a player!!");
		}
		Player player = (Player) obj;
		return name == player.getName();
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
