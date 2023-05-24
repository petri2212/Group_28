package board;

public enum TileType {

	TWO_DOTS(2),
	THREE_DOTS(3),
	FOUR_DOTS(4);

	private int playersNumber;

	private TileType(int playersNumber) {
		this.playersNumber = playersNumber;
	}

	public int getPlayersNumber() {
		return playersNumber;
	}

}
