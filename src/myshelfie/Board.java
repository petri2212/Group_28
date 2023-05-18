package myshelfie;


import java.util.ArrayList;
import utils.MatrixCoords;

public interface Board<T> {
	public static final String[] DOWN_COOORDS = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
	public static final int[] RIGHT_COORDS = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	public static final int ROW_COUNT = 9;
	public static final int COL_COUNT = 9;
	void fillLivingRoomWithObjects();
	ArrayList<BookshelfObject> pickObjects(ArrayList<MatrixCoords> coordsList);
	public String[] getDownCoords();
	public int[] getRightCoords();
	public T get(MatrixCoords coords);
}
