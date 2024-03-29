package goal.common;

import java.awt.Image;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import goal.CommonGoal;
import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import resource.Images;
import utils.MatrixCoords;

public class CommonGoal_FourVertical extends CommonGoal {

	private final int MAX_SAME_ADJACENT_OBJECTS = 4;
	private final int MAX_VALID_GROUPS = 4;

	@Override
	public Image getImage() {
		return Images.COMMON_GOAL_FOUR_VERTICAL.load();
	}

	/**
	 * This method runs trough each bookshelf cell that holds an object and it has
	 * not been checked before. It takes the object from that cell and start to
	 * check the adjacent cells. If these cells contains the same object, their
	 * coordinates are added to a queue list and the process repeated until the
	 * queue is empty. This means that no more adjacent cells with the same object
	 * have been found. If the number of same objects that are adjacent one to
	 * another is 4 then a counter is increased. Once the entire bookshelf is
	 * parsed, if the number of valid groups of adjacent objects is 4 than the point
	 * is given.
	 *
	 * @param bookshelf the player bookshelf under validation
	 * @return 0 not completed the Common goal, 1 completed the Common Goal
	 */
	@Override
	public int check(Bookshelf bookshelf) {
		int rows = bookshelf.getRows();
		int cols = bookshelf.getCols();
		Queue<MatrixCoords> queue = new LinkedList<>();
		boolean[][] visited = new boolean[rows][cols];
		int objectsCount = 0;
		int groupsCount = 0;

		for (int r = 0; r < rows; r++)
			for (int c = 0; c < cols; c++) {
				BookshelfObject refObject = bookshelf.get(new MatrixCoords(r, c));
				objectsCount = 0;

				if ((refObject != null) && (!visited[r][c])) {
					queueAdjacentObjectsPosition(r, c, refObject, bookshelf, queue);
					objectsCount++;

					while (!queue.isEmpty()) {
						MatrixCoords objPos = queue.poll();
						queueAdjacentObjectsPosition(objPos.r, objPos.c, refObject, bookshelf, queue);
						objectsCount++;
						visited[objPos.r][objPos.c] = true;
					}

					if (objectsCount == MAX_SAME_ADJACENT_OBJECTS) {
						groupsCount++;
					}
				}
			}
		if (groupsCount == MAX_VALID_GROUPS) {
			return 1;
		}
		return 0;
	}

	/**
	 * Adds the position of the adjacent objects equal to the reference object to
	 * the queue. This method only checks objects to the right and below the
	 * reference object, avoiding useless double coordinates in the queue. This is
	 * possible because the reference object moves always from top to bottom and
	 * from left to right.
	 *
	 * @param r         the row coordinate
	 * @param c         the column coordinate
	 * @param refObject the reference BookeshlefObject
	 * @param bookshelf the player Bookshelf that is in validation
	 * @param queue     the queue of MatrixCoords holding the adjacent
	 *                  BookeshlefObject(s) position
	 */
	private void queueAdjacentObjectsPosition(int r, int c, BookshelfObject refObject, Bookshelf bookshelf,
			Queue<MatrixCoords> queue) {
		ArrayList<MatrixCoords> adjacentObjectsPos = new ArrayList<>();
		adjacentObjectsPos.add(new MatrixCoords(r, c + 1));
		adjacentObjectsPos.add(new MatrixCoords(r + 1, c));

		for (MatrixCoords pos : adjacentObjectsPos) {
			BookshelfObject object = bookshelf.get(pos);
			if ((object == refObject) && (!queue.contains(pos))) {
				queue.add(pos);
			}
		}
	}

	@Override
	public String getDescription() {
		return "Four groups each containing at least\n" + "4 tiles of the same type (not necessarily\n"
				+ "in the depicted shape).\n" + "The tiles of one group can be different\n"
				+ "from those of another group.";
	}
}
