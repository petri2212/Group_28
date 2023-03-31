package myshelfie;

import java.util.ArrayList;

public class Board {

	private final int playersNumber;

	public Board(int playerNumber) {
		this.playersNumber = playerNumber;
	}

	/* Helper functions */
	private Tile tile2p() { return new Tile(TileType.TWO_DOTS); }
	private Tile tile3p() { return new Tile(TileType.THREE_DOTS); }
	private Tile tile4p() { return new Tile(TileType.FOUR_DOTS); }

	/**
	 * A Map representing the game board composed with tiles.
	 * The livingroom indexing goes as 0,0 from top-left corner to 8,8 bottom-right corner.
	 */
	private final Tile[][] livingroom = {
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

	/**
	 * Randomly fill the livingroom with objects picked from the pool.
	 */
	public void FillLivingroomWithObjects() {
		for(int row = 0; row < livingroom.length; row++)
			for(int col = 0; col < livingroom[0].length; col++) {
				Tile livingroomTile = livingroom[row][col];

				if (livingroomTile != null && livingroomTile.isUsable(playersNumber)) {
					BookshelfObject randomObject = BookshelfObject.getRandomObject();
					livingroomTile.addObject(randomObject);
				}
			}
	}

	/**
	 * Returns the number of rows of the Board.
	 *
	 * @return the number of rows as an integer
	 */
	public int rowCount() {
		return livingroom.length;
	}

	/**
	 * Returns the number of columns of the Board.
	 *
	 * @return the number of columns as an integer
	 */
	public int colCount() {
		return livingroom[0].length;
	}

    /**
     * Returns the Tile at coordinates row and col in the livingroom 2D array.
     *
     * @param row the row index
     * @param col the column index
     * @return    the Tile at the given coordinates
     */
	public Tile getTile(int row, int col) {
		return livingroom[row][col];
	}

	/**
	 * Returns a list of BookshelfObject representing the objects selected by the user.
	 * The coordinates are the indices row and col of the livingroom 2D array.
	 *
	 * @param coords a list of two integers representing row and col indices
	 * @return 		 a list of the selected BookshelfObject
	 */
	public ArrayList<BookshelfObject> pickObjects(ArrayList<int[]> coords) {
		final int rowIndex = 0;
		final int colIndex = 1;
		ArrayList<BookshelfObject> objects = new ArrayList<>();

		for(int[] coord : coords) {
			int row = coord[rowIndex];
			int col = coord[colIndex];
			try {
				Tile tile = livingroom[row][col];

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
