package board;

import java.util.ArrayList;

import myshelfie.BookshelfObject;
import utils.MatrixCoords;

/**
 * Creates a new Board Proxy.
 */
public class BoardProxy implements Board {
	public BoardInstance instance;
	public int playersnumber;

	/**
	 * @param playersnumber number of players who will play the game
	 */
	public BoardProxy(int playersnumber) {
		this.playersnumber = playersnumber;
		instance = new BoardInstance(this.playersnumber);
		init();
		fillLivingRoomWithObjects();
	}

	/**
	 * Initialize the matrix using the tile-map. The tile-map is mirrored in order
	 * to assign the correct position to every tile, starting from the bottom-left
	 * corner with the coordinates 0, 0.
	 */
	public void init() {

		int maxRowIndex = ROW_COUNT - 1;

		for (int r = 0; r < ROW_COUNT; r++)
			for (int c = 0; c < COL_COUNT; c++) {
				int rMirrored = (maxRowIndex - r);
				Tile tile = instance.livingroomTileMap[rMirrored][c];
				instance.add(r, c, tile);
			}
	}

	@Override
	public void fillLivingRoomWithObjects() {
		instance.fillLivingRoomWithObjects();
	}

	public boolean areAllObjectsIsolated() {
		return instance.areAllObjectsIsolated();
	}

	@Override
	public Tile get(MatrixCoords coords) {
		return instance.get(coords);
	}

	@Override
	public BookshelfObject tryPickObject(MatrixCoords coords) {
		return instance.tryPickObject(coords);
	}

	@Override
	public boolean isObjectPickable(ArrayList<MatrixCoords> pickedObjButtoncoords, MatrixCoords coords) {
		return instance.isObjectPickable(pickedObjButtoncoords, coords);
	}

}
