package myshelfie;

public class Board
{
	private final int playersNumber;

	public Board(int playerNumber)
	{
		this.playersNumber = playerNumber;
	}

	/* Helper functions */
	private Tile tile2p() { return new Tile(TileType.TWO_DOTS); }
	private Tile tile3p() { return new Tile(TileType.THREE_DOTS); }
	private Tile tile4p() { return new Tile(TileType.FOUR_DOTS); }

	private final Tile[][] livingroom =
    {
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

	public void FillLivingroomWithObjects()
	{
		for(int row = 0; row < livingroom.length; row++)
			for(int col = 0; col < livingroom[0].length; col++)
			{
				Tile livingroomTile = livingroom[row][col];

				if (livingroomTile != null && livingroomTile.isUsable(playersNumber))
				{
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
	public int rowCount()
	{
		return livingroom.length;
	}

	/**
	 * Returns the number of columns of the Board.
	 *
	 * @return the number of columns as an integer
	 */
	public int colCount()
	{
		return livingroom[0].length;
	}
}
