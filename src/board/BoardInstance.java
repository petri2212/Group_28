package board;

import java.util.ArrayList;
import java.util.List;

import myshelfie.BookshelfObject;
import utils.Matrix;
import utils.MatrixCoords;

public class BoardInstance extends Matrix<Tile> implements Board {
	private final int playersNumber;

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
	 * A Map representing the game board composed with tiles. The livingroom
	 * indexing goes as 0,0 from top-left corner to 8,8 bottom-right corner.
	 */
	public final Tile[][] livingroomTileMap = { 
			{ null, null, null, tile3p(), tile4p(), null, null, null, null },
			{ null, null, null, tile2p(), tile2p(), tile4p(), null, null, null },
			{ null, null, tile3p(), tile2p(), tile2p(), tile2p(), tile3p(), null, null },
			{ null, tile4p(), tile2p(), tile2p(), tile2p(), tile2p(), tile2p(), tile2p(), tile3p() },
			{ tile4p(), tile2p(), tile2p(), tile2p(), tile2p(), tile2p(), tile2p(), tile2p(), tile4p() },
			{ tile3p(), tile2p(), tile2p(), tile2p(), tile2p(), tile2p(), tile2p(), tile4p(), null },
			{ null, null, tile3p(), tile2p(), tile2p(), tile2p(), tile3p(), null, null },
			{ null, null, null, tile4p(), tile2p(), tile2p(), null, null, null },
			{ null, null, null, null, tile4p(), tile3p(), null, null, null }, };

	@Override
	public void fillLivingRoomWithObjects() {
		for (int r = 0; r < ROW_COUNT; r++)
			for (int c = 0; c < COL_COUNT; c++) {
				Tile livingroomTile = this.get(new MatrixCoords(r, c));

				if (livingroomTile != null && livingroomTile.isUsable(playersNumber)) {
					BookshelfObject randomObject = BookshelfObject.getRandomObject();
					livingroomTile.addObject(randomObject);
				}
			}
	}

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

	private ArrayList<BookshelfObject> getAjacentObjects(int r, int c) {
		ArrayList<BookshelfObject> objects = new ArrayList<>();
		MatrixCoords[] adjacentCoords = { new MatrixCoords(r + 1, c), new MatrixCoords(r - 1, c),
				new MatrixCoords(r, c + 1), new MatrixCoords(r, c - 1) };

		for (MatrixCoords coords : adjacentCoords) {
			Tile tile = this.get(coords);

			if ((tile != null)) {
				objects.add(tile.getBookshelfObject());
			}
		}

		return objects;
	}

	public boolean isObjectPickable(ArrayList<MatrixCoords> pickedObjButtoncoords, MatrixCoords coords) {
		checkEmptyTile(coords);
		boolean result1 = checkEdges(coords);
		boolean result2 = checkDistance(pickedObjButtoncoords, coords);
		return result1 && result2;
	}

	@Override
	public BookshelfObject tryPickObject(MatrixCoords coords) {
		checkEmptyTile(coords);
		BookshelfObject object = super.get(coords).getBookshelfObject();

		super.get(coords).removeObject();
		return object;
	}

	private void checkEmptyTile(MatrixCoords coords) {
		Tile tile = this.get(coords);
		if (tile.getBookshelfObject() == null) {
			throw new IllegalArgumentException("The coordinates passed points to an empty tile!");
		}
	}

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
						result = true;// if u dont do this u cant pick in a row of objects the middle one and then
										// both of the adjacent object because the last result set result false, because
										// the distance isnt one as compared to the last MatrixCoords
					}

				} else if (cont_row != 0) {
					if (cont_row != 2) {
						result = false;
					} else {
						result = true;//
					}
				}
			}
		}

		return result;
	}
}
