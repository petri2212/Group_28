package board;

import java.util.ArrayList;
import java.util.List;

import myshelfie.BookshelfObject;
import utils.Matrix;
import utils.MatrixCoords;

/**
 * Creates a new Instance of the Board.
 */
public class BoardInstance extends Matrix<Tile> implements Board {
	private final int playersNumber;

	/**
	 * creates a new BoardInstance
	 * 
	 * @param playersNumber number of players who will play the game
	 */
	public BoardInstance(int playersNumber) {
		super(ROW_COUNT, COL_COUNT);
		this.playersNumber = playersNumber;
	}

	/* Helper functions */
	private Tile tile2p() {
		return new Tile(TileType.TWO_DOTS);
	}

	private Tile tile3p() {
		return new Tile(TileType.THREE_DOTS);
	}

	private Tile tile4p() {
		return new Tile(TileType.FOUR_DOTS);
	}

	/**
	 * A Map representing the game board composed with tiles. The living room
	 * indexing goes as 0,0 from top-left corner to 8,8 bottom-right corner.
	 */
	public final Tile[][] livingroomTileMap = { { null, null, null, tile3p(), tile4p(), null, null, null, null },
			{ null, null, null, tile2p(), tile2p(), tile4p(), null, null, null },
			{ null, null, tile3p(), tile2p(), tile2p(), tile2p(), tile3p(), null, null },
			{ null, tile4p(), tile2p(), tile2p(), tile2p(), tile2p(), tile2p(), tile2p(), tile3p() },
			{ tile4p(), tile2p(), tile2p(), tile2p(), tile2p(), tile2p(), tile2p(), tile2p(), tile4p() },
			{ tile3p(), tile2p(), tile2p(), tile2p(), tile2p(), tile2p(), tile2p(), tile4p(), null },
			{ null, null, tile3p(), tile2p(), tile2p(), tile2p(), tile3p(), null, null },
			{ null, null, null, tile4p(), tile2p(), tile2p(), null, null, null },
			{ null, null, null, null, tile4p(), tile3p(), null, null, null }, };

	/**
	 * method for filling the library with random bookshelf objects
	 */
	@Override
	public void fillLivingRoomWithObjects() {
		for (int r = 0; r < ROW_COUNT; r++)
			for (int c = 0; c < COL_COUNT; c++) {
				Tile livingroomTile = this.get(new MatrixCoords(r, c));

				if (livingroomTile != null && livingroomTile.isUsable(playersNumber)
						&& livingroomTile.getBookshelfObject() == null) {
					BookshelfObject randomObject = BookshelfObject.getRandomObject();
					livingroomTile.addObject(randomObject);
				}
			}
	}

	/**
	 * method to check if all the remaining objects have all 4 sides free i.e. there
	 * is no bookshelf object present
	 */
	public boolean areAllObjectsIsolated() {
		for (int r = 0; r < ROW_COUNT; r++) {
			for (int c = 0; c < COL_COUNT; c++) {
				Tile livingroomTile = this.get(new MatrixCoords(r, c));

				if ((livingroomTile != null) && (livingroomTile.getBookshelfObject() != null)) {

					List<BookshelfObject> adjacentObjects = getAjacentObjects(r, c);

					for (BookshelfObject object : adjacentObjects) {
						if (object != null) {
							return false;
						}
					}
				}
			}
		}

		return true;
	}

	/**
	 * Method that allows you to choose the tiles adjacent to the first chosen tile
	 * or if a succession of tiles has been chosen, the first will be adjacent to
	 * the second and the second to the third
	 * 
	 * @param r represents the row of the piked object
	 * @param c represents the col of the piked object
	 * @return objects represents an arraylist containing the selected objects
	 */

	private ArrayList<BookshelfObject> getAjacentObjects(int r, int c) {
		ArrayList<BookshelfObject> objects = new ArrayList<>();

		int UPPER_COORDS = r - 1;
		int LEFT_COORDS = c - 1;

		if (UPPER_COORDS == -1) {
			UPPER_COORDS = 10;
		}

		if (LEFT_COORDS == -1) {
			LEFT_COORDS = 10;
		}

		MatrixCoords[] adjacentCoords = { new MatrixCoords(r + 1, c), new MatrixCoords(UPPER_COORDS, c),
				new MatrixCoords(r, c + 1), new MatrixCoords(r, LEFT_COORDS) };

		for (MatrixCoords coords : adjacentCoords) {
			Tile tile = this.get(coords);

			if ((tile != null)) {
				objects.add(tile.getBookshelfObject());
			}
		}

		return objects;
	}

	/**
	 * method that checks that the object chosen to be taken is really takeable, use
	 * the checkEdges and checkDistance methods.
	 * 
	 * @param pickedObjButtoncoords represents the already picked objects
	 *                              coordinates
	 * @param MatrixCoords          represents the coordinate of the current object
	 *                              that is going to be taken
	 * @return true if have at least one side empty and his distance from the last
	 *         object picked is 1
	 */
	public boolean isObjectPickable(ArrayList<MatrixCoords> pickedObjButtoncoords, MatrixCoords coords) {
		checkEmptyTile(coords);
		boolean result1 = checkEdges(coords);
		boolean result2 = checkDistance(pickedObjButtoncoords, coords);
		return result1 && result2;
	}

	/**
	 * this method pick the object at the respective coordinates and remove it from
	 * the board
	 * 
	 * @return object represent the object removed
	 */
	@Override
	public BookshelfObject tryPickObject(MatrixCoords coords) {
		checkEmptyTile(coords);
		BookshelfObject object = super.get(coords).getBookshelfObject();

		super.get(coords).removeObject();
		return object;
	}

	/**
	 * this method check if the tile is empty
	 * 
	 * @param coords represent the tile coordinates
	 * @throws IllegalArgumentException if the tile bookshelf
	 */
	private void checkEmptyTile(MatrixCoords coords) {
		Tile tile = this.get(coords);
		if (tile.getBookshelfObject() == null) {
			throw new IllegalArgumentException("The coordinates passed points to an empty tile!");
		}
	}

	/**
	 * this method checks that the object to be taken has at least one free side
	 * 
	 * @param coords represents the coordinate of the current object that is going
	 *               to be checked
	 * @return true if have at least one side empty, else false
	 */
	private boolean checkEdges(MatrixCoords coords) {
		int contFull = 4;
		int r = coords.r;
		int c = coords.c;

		int UPPER_ROW = r + 1;
		int UNDER_ROW = r - 1;
		int RIGHT_COL = c + 1;
		int LEFT_COL = c - 1;

		if (LEFT_COL == -1) {
			LEFT_COL = 5;
		}

		if (UNDER_ROW == -1) {
			UNDER_ROW = 6;
		}

		Tile tile_Up = this.get(new MatrixCoords(UPPER_ROW, c));

		Tile tile_Un = this.get(new MatrixCoords(UNDER_ROW, c));

		Tile tile_Right = this.get(new MatrixCoords(r, RIGHT_COL));

		Tile tile_Left = this.get(new MatrixCoords(r, LEFT_COL));

		if (tile_Up == null || tile_Up.getBookshelfObject() == null) {
			contFull--;
		}

		if (tile_Un == null || tile_Un.getBookshelfObject() == null) {
			contFull--;
		}

		if (tile_Right == null || tile_Right.getBookshelfObject() == null) {
			contFull--;
		}

		if (tile_Left == null || tile_Left.getBookshelfObject() == null) {
			contFull--;
		}

		if (contFull != 4) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * This method checks that the distance of the object to be taken from the last
	 * object taken is 1
	 * 
	 * @param pickedObjButtoncoords represents the already picked objects
	 *                              coordinates
	 * @param objcoords             represents the coordinate of the current object
	 *                              that is going to be taken
	 * @return result true if the object respect the conditions , else false
	 */
	private boolean checkDistance(ArrayList<MatrixCoords> pickedObjButtoncoords, MatrixCoords objcoords) {
		boolean result = true;
		int cont_row = 0;
		int cont_col = 0;
		if (!(pickedObjButtoncoords.isEmpty())) {
			for (MatrixCoords coordsUsed : pickedObjButtoncoords) {
				MatrixCoords coords1 = objcoords;
				MatrixCoords coords2 = coordsUsed;

				if (coords1.c == coords2.c) {
					int absolute_difference = Math.abs(coords1.r - coords2.r);
					if (absolute_difference == 1) {
						cont_col++;
						result = true;
					} else {
						cont_col++;
						result = false;
					}

				} else if (coords1.r == coords2.r) {
					int absolute_difference = Math.abs(coords1.c - coords2.c);
					if (absolute_difference == 1) {
						cont_row++;
						result = true;
					} else {
						cont_row++;
						result = false;
					}

				} else {
					result = false;
				}
			}

			if (pickedObjButtoncoords.size() == 2) {
				if (cont_col != 0) {
					if (cont_col != 2) {
						result = false;
					} else {
						result = true;
					}

				} else if (cont_row != 0) {
					if (cont_row != 2) {
						result = false;
					} else {
						result = true;
					}
				}
			}
		}

		return result;
	}
}
