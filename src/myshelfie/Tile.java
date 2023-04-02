package myshelfie;

public class Tile {

	private TileType type;
	private BookshelfObject object;

	public Tile(TileType type) {
		this.type = type;
	}

	public boolean isUsable(int playersNumber) {
		int allowedPlayers = type.getPlayersNumber();
		return (playersNumber >= allowedPlayers) ? true : false;
	}

	public void addObject(BookshelfObject object) {
		this.object = object;
	}

	public void removeObject() {
		object = null;
	}

	public boolean isEmpty() {
		return (object == null) ? true : false;
	}

	public BookshelfObject getBookshelfObject() {
		return object;
	}

}
