package myshelfie;


import java.util.ArrayList;
import utils.MatrixCoords;

/* TODO: use proxy pattern.
 * This class should became an interface with an a proxy implementation*/

public class Board extends Matrix<Tile> {

	private static final int ROW_COUNT = 9;
	private static final int COL_COUNT = 9;
	private static final char[] DOWN_COOORDS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
	private static final char[] RIGHT_COORDS = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
	
	private final int playersNumber;

	public Board(int playerNumber) {
		super(ROW_COUNT, COL_COUNT);
		this.playersNumber = playerNumber;
		init();
		fillLivingroomWithObjects();
	}

	/* Helper functions */
	private Tile tile2p() { return new Tile(TileType.TWO_DOTS); }
	private Tile tile3p() { return new Tile(TileType.THREE_DOTS); }
	private Tile tile4p() { return new Tile(TileType.FOUR_DOTS); }

	/**
	 * A Map representing the game board composed with tiles.
	 * The livingroom indexing goes as 0,0 from top-left corner to 8,8 bottom-right corner.
	 */
	private final Tile[][] livingroomTileMap = {
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
	 * Initialize the matrix using the above tile-map.
	 * The tile-map must be mirrored in order to assign the correct position to every tile,
	 * starting from the bottom-left corner with the coordinates 0, 0.
	 */
	private void init() {
		int maxRowIndex = ROW_COUNT - 1;
		int macColIndex = COL_COUNT - 1;

		for(int r = 0; r < ROW_COUNT; r++)
			for(int c = 0; c < COL_COUNT; c++) {
				int rMirrored = (maxRowIndex - r);
				int cMirrored = (macColIndex - c);
				Tile tile = livingroomTileMap[rMirrored][cMirrored];
				this.add(r, c, tile);
			}
	}

	/**
	 * Randomly fill the livingroom with objects picked from the pool.
	 */
	public void fillLivingroomWithObjects() {
		for(int r = 0; r < ROW_COUNT; r++)
			for(int c = 0; c < COL_COUNT; c++) {
				Tile livingroomTile = this.get(new MatrixCoords(r, c));

				if (livingroomTile != null && livingroomTile.isUsable(playersNumber)) {
					BookshelfObject randomObject = BookshelfObject.getRandomObject();
					livingroomTile.addObject(randomObject);
				}
			}
	}

	/**
	 * Returns a list of BookshelfObject representing the objects selected by the user.
	 * The coordinates are the indices row and col of the livingroom 2D array.
	 *
	 * @param coords a list of two integers representing row and col indices
	 * @return 		 a list of the selected BookshelfObject
	 */
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
	
	public char[] getDownCoords() {
		return DOWN_COOORDS;
	}
	
	public char[] getRightCoords() {
		return RIGHT_COORDS;
	}
	
public interface Board {
	public static final String[] DOWN_COOORDS = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
	public static final int[] RIGHT_COORDS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	public static final int ROW_COUNT = 9;
	public static final int COL_COUNT = 9;
	void fillLivingRoomWithObjects();
	ArrayList<BookshelfObject> pickObjects(ArrayList<MatrixCoords> coordsList);
	public Tile get(MatrixCoords coords);
public interface Board {
	public static final String[] DOWN_COOORDS = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
	public static final int[] RIGHT_COORDS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	public static final int ROW_COUNT = 9;
	public static final int COL_COUNT = 9;
	void fillLivingRoomWithObjects();
	ArrayList<BookshelfObject> pickObjects(ArrayList<MatrixCoords> coordsList);
	public Tile get(MatrixCoords coords);
public interface Board {
	public static final String[] DOWN_COOORDS = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
	public static final int[] RIGHT_COORDS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	public static final int ROW_COUNT = 9;
	public static final int COL_COUNT = 9;
	void fillLivingRoomWithObjects();
	ArrayList<BookshelfObject> pickObjects(ArrayList<MatrixCoords> coordsList);
	public Tile get(MatrixCoords coords);
public interface Board {
	public static final String[] DOWN_COOORDS = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
	public static final int[] RIGHT_COORDS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	public static final int ROW_COUNT = 9;
	public static final int COL_COUNT = 9;
	void fillLivingRoomWithObjects();
	ArrayList<BookshelfObject> pickObjects(ArrayList<MatrixCoords> coordsList);
	public Tile get(MatrixCoords coords);
public interface Board {
	public static final String[] DOWN_COOORDS = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
	public static final int[] RIGHT_COORDS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	public static final int ROW_COUNT = 9;
	public static final int COL_COUNT = 9;
	void fillLivingRoomWithObjects();
	ArrayList<BookshelfObject> pickObjects(ArrayList<MatrixCoords> coordsList);
	public Tile get(MatrixCoords coords);
public interface Board {
	public static final String[] DOWN_COOORDS = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
	public static final int[] RIGHT_COORDS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	public static final int ROW_COUNT = 9;
	public static final int COL_COUNT = 9;
	void fillLivingRoomWithObjects();
	ArrayList<BookshelfObject> pickObjects(ArrayList<MatrixCoords> coordsList);
	public Tile get(MatrixCoords coords);
public interface Board {
	public static final String[] DOWN_COOORDS = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
	public static final int[] RIGHT_COORDS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	public static final int ROW_COUNT = 9;
	public static final int COL_COUNT = 9;
	void fillLivingRoomWithObjects();
	ArrayList<BookshelfObject> pickObjects(ArrayList<MatrixCoords> coordsList);
	public Tile get(MatrixCoords coords);
public interface Board {
	public static final String[] DOWN_COOORDS = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
	public static final int[] RIGHT_COORDS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	public static final int ROW_COUNT = 9;
	public static final int COL_COUNT = 9;
	void fillLivingRoomWithObjects();
	ArrayList<BookshelfObject> pickObjects(ArrayList<MatrixCoords> coordsList);
	public Tile get(MatrixCoords coords);
public interface Board {
	public static final String[] DOWN_COOORDS = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
	public static final int[] RIGHT_COORDS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	public static final int ROW_COUNT = 9;
	public static final int COL_COUNT = 9;
	void fillLivingRoomWithObjects();
	ArrayList<BookshelfObject> pickObjects(ArrayList<MatrixCoords> coordsList);
	public Tile get(MatrixCoords coords);
public interface Board {
	public static final String[] DOWN_COOORDS = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
	public static final int[] RIGHT_COORDS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	public static final int ROW_COUNT = 9;
	public static final int COL_COUNT = 9;
	void fillLivingRoomWithObjects();
	ArrayList<BookshelfObject> pickObjects(ArrayList<MatrixCoords> coordsList);
	public Tile get(MatrixCoords coords);
public interface Board {
	public static final String[] DOWN_COOORDS = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
	public static final int[] RIGHT_COORDS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	public static final int ROW_COUNT = 9;
	public static final int COL_COUNT = 9;
	void fillLivingRoomWithObjects();
	ArrayList<BookshelfObject> pickObjects(ArrayList<MatrixCoords> coordsList);
	public Tile get(MatrixCoords coords);
public interface Board {
	public static final String[] DOWN_COOORDS = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
	public static final int[] RIGHT_COORDS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	public static final int ROW_COUNT = 9;
	public static final int COL_COUNT = 9;
	void fillLivingRoomWithObjects();
	ArrayList<BookshelfObject> pickObjects(ArrayList<MatrixCoords> coordsList);
	public Tile get(MatrixCoords coords);
public interface Board {
	public static final String[] DOWN_COOORDS = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
	public static final int[] RIGHT_COORDS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	public static final int ROW_COUNT = 9;
	public static final int COL_COUNT = 9;
	void fillLivingRoomWithObjects();
	ArrayList<BookshelfObject> pickObjects(ArrayList<MatrixCoords> coordsList);
	public Tile get(MatrixCoords coords);
public interface Board {
	public static final String[] DOWN_COOORDS = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
	public static final int[] RIGHT_COORDS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	public static final int ROW_COUNT = 9;
	public static final int COL_COUNT = 9;
	void fillLivingRoomWithObjects();
	ArrayList<BookshelfObject> pickObjects(ArrayList<MatrixCoords> coordsList);
	public Tile get(MatrixCoords coords);
public interface Board {
	public static final String[] DOWN_COOORDS = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
	public static final int[] RIGHT_COORDS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	public static final int ROW_COUNT = 9;
	public static final int COL_COUNT = 9;
	void fillLivingRoomWithObjects();
	ArrayList<BookshelfObject> pickObjects(ArrayList<MatrixCoords> coordsList);
	public Tile get(MatrixCoords coords);
public interface Board {
	public static final String[] DOWN_COOORDS = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
	public static final int[] RIGHT_COORDS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	public static final int ROW_COUNT = 9;
	public static final int COL_COUNT = 9;
	void fillLivingRoomWithObjects();
	ArrayList<BookshelfObject> pickObjects(ArrayList<MatrixCoords> coordsList);
	public Tile get(MatrixCoords coords);
public interface Board {
	public static final String[] DOWN_COOORDS = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
	public static final int[] RIGHT_COORDS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	public static final int ROW_COUNT = 9;
	public static final int COL_COUNT = 9;
	void fillLivingRoomWithObjects();
	ArrayList<BookshelfObject> pickObjects(ArrayList<MatrixCoords> coordsList);
	public Tile get(MatrixCoords coords);
public interface Board {
	public static final String[] DOWN_COOORDS = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
	public static final int[] RIGHT_COORDS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	public static final int ROW_COUNT = 9;
	public static final int COL_COUNT = 9;
	void fillLivingRoomWithObjects();
	ArrayList<BookshelfObject> pickObjects(ArrayList<MatrixCoords> coordsList);
	public Tile get(MatrixCoords coords);
}
