package myshelfie;

import utils.MatrixCoords;

public interface Board {
	public static final char[] DOWN_COOORDS = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I' };
	public static final char[] RIGHT_COORDS = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	public static final int ROW_COUNT = 9;
	public static final int COL_COUNT = 9;

	public void fillLivingRoomWithObjects();

	public boolean tryPickObject(MatrixCoords coords);

	public Tile get(MatrixCoords coords);

}
