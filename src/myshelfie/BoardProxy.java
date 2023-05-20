package myshelfie;

import java.util.ArrayList;

import utils.MatrixCoords;

public class BoardProxy implements Board {
	public BoardInstance instance;

	public BoardProxy(int playersnumber) {
		instance=new BoardInstance(playersnumber);
		init();
		fillLivingRoomWithObjects();
	}
	
	/**
	 * Initialize the matrix using the tile-map.
	 * The tile-map is mirrored in order to assign the correct position to every tile,
	 * starting from the bottom-left corner with the coordinates 0, 0.
	 */
	public void init() {
		
		int maxRowIndex = ROW_COUNT - 1;
		int macColIndex = COL_COUNT - 1;

		for(int r = 0; r < ROW_COUNT; r++)
			for(int c = 0; c < COL_COUNT; c++) {
				int rMirrored = (maxRowIndex - r);
				int cMirrored = (macColIndex - c);
				Tile tile = instance.livingroomTileMap[rMirrored][cMirrored];
				instance.add(r, c, tile);
			}
	}
	@Override
	public void fillLivingRoomWithObjects() {
		instance.fillLivingRoomWithObjects();
	}

	@Override
	public Tile get(MatrixCoords coords) {
		return instance.get(coords);
	}

	@Override
	public ArrayList<BookshelfObject> pickObjects(ArrayList<MatrixCoords> coordsList) {
		return instance.pickObjects(coordsList);
	}

}
