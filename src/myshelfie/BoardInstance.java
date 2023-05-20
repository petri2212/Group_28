package myshelfie;

import java.util.ArrayList;

import utils.Matrix;
import utils.MatrixCoords;

public class BoardInstance extends Matrix<Tile> implements Board {
	private final int playersNumber;
	
	public BoardInstance(int playersNumber) {
		super(ROW_COUNT, COL_COUNT);
		this.playersNumber = playersNumber;
	}

	/* Helper functions */
	private Tile tile2p() { return new Tile(TileType.TWO_DOTS); }
	private Tile tile3p() { return new Tile(TileType.THREE_DOTS); }
	private Tile tile4p() { return new Tile(TileType.FOUR_DOTS); }

	/**
	 * A Map representing the game board composed with tiles.
	 * The livingroom indexing goes as 0,0 from top-left corner to 8,8 bottom-right corner.
	 */
	public final Tile[][] livingroomTileMap = {
		{null,	   null,	 null,	   tile3p(), tile4p(), null,     null,     null,     null    },
		{null, 	   null,     null,     tile2p(), tile2p(), tile4p(), null,     null,     null    },
		{null, 	   null,     tile3p(), tile2p(), tile2p(), tile2p(), tile3p(), null,     null    },
		{null, 	   tile4p(), tile2p(), tile2p(), tile2p(), tile2p(), tile2p(), tile2p(), tile3p()},
		{tile4p(), tile2p(), tile2p(), tile2p(), tile2p(), tile2p(), tile2p(), tile2p(), tile4p()},
		{tile3p(), tile2p(), tile2p(), tile2p(), tile2p(), tile2p(), tile2p(), tile4p(), null    },
		{null,     null,     tile3p(), tile2p(), tile2p(), tile2p(), tile3p(), null,     null    },
		{null,     null,     null,     tile4p(), tile2p(), tile2p(), null,     null,     null    },
		{null,     null,     null,     null,     tile4p(), tile3p(), null,     null,     null    },
	};

	@Override
	public void fillLivingRoomWithObjects() {
		for(int r = 0; r < ROW_COUNT; r++)
			for(int c = 0; c < COL_COUNT; c++) {
				Tile livingroomTile = this.get(new MatrixCoords(r, c));

				if (livingroomTile != null && livingroomTile.isUsable(playersNumber)) {
					BookshelfObject randomObject = BookshelfObject.getRandomObject();
					livingroomTile.addObject(randomObject);
				}
			}
	}

	@Override
	public ArrayList<BookshelfObject> pickObjects(ArrayList<MatrixCoords> coordsList) {
			ArrayList<BookshelfObject> objects = new ArrayList<>();
			for(MatrixCoords coords : coordsList) {
				try {
					Tile tile = this.get(coords);

					// TODO: adds valid pick check; rule of one-empty-space before picking an object

					objects.add(tile.getBookshelfObject());
				}
				catch(ArrayIndexOutOfBoundsException e) {
					System.out.println(e);
				}
			}

			return objects;
	}

}
