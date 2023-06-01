package board;

import myshelfie.BookshelfObject;

public class Tile {

	private TileType type;
	private BookshelfObject object;

	public Tile(TileType type) {
		this.type = type;
	}

	/**
	 * @param playersNumber number of players who will play the game
	 * @return true if the tile is usable for the number of players playing
	 */
	public boolean isUsable(int playersNumber) {
		int allowedPlayers = type.getPlayersNumber();
		return (playersNumber >= allowedPlayers) ? true : false;
	}

	/**
	 * 
	 * @param object add the relative object to the tile
	 */
	public void addObject(BookshelfObject object) {
		this.object = object;
	}

	/**
	 * Remove the object from the tile
	 */
	public void removeObject() {
		object = null;
	}

	/**
	 * Check if the tile is Empty
	 * 
	 * @return true if have no object in it, else false
	 */
	public boolean isEmpty() {
		return (object == null) ? true : false;
	}

	/**
	 * Get the object contained by the tile object
	 * 
	 * @return the object contained by the tile object
	 */
	public BookshelfObject getBookshelfObject() {
		return object;
	}

}
