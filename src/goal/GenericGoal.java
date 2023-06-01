package goal;

import java.util.HashSet;
import java.util.ArrayList;

import myshelfie.Bookshelf;
import myshelfie.BookshelfObject;
import utils.MatrixCoords;

/**
 * This class represents the Generic Goal
 */
public class GenericGoal implements Goal {
	/**
	 * This method checks how many points a player has made respecting the condition
	 * of having from 3 to more adjacent cards of the same type
	 * 
	 * @param bookshelf the player bookshelf under validation
	 */
	@Override
	public int check(Bookshelf bookshelf) {
		int points = 0;

		BookshelfObject[] items_to_check = { BookshelfObject.CAT, BookshelfObject.BOOK, BookshelfObject.GAME,
				BookshelfObject.FRAME, BookshelfObject.TROPHY, BookshelfObject.PLANT };
		ArrayList<MatrixCoords> Coordinates_Array = new ArrayList<>();
		ArrayList<Integer> Num_obj_for_tipe = new ArrayList<>();

		for (int i = 0; i < items_to_check.length; i++) {
			BookshelfObject actualObj = items_to_check[i];
			for (int r = 0; r < bookshelf.getRows(); r++) {
				for (int c = 0; c < bookshelf.getCols(); c++) {
					BookshelfObject acutal = bookshelf.get(new MatrixCoords(r, c));
					if (acutal != null && actualObj.name() == acutal.name()) {
						ricorsive(new MatrixCoords(r, c), Coordinates_Array, bookshelf, actualObj);

					}
				}
			}

			if (Coordinates_Array.size() != 0) {

				ArrayList<MatrixCoords> CoordsCopied = new ArrayList<>(Coordinates_Array);
				int pos = 0;
				int cont = 1;

				for (MatrixCoords next : Coordinates_Array) {

					boolean isEnd = false;
					CoordsCopied.remove(pos);
					if (!CoordsCopied.isEmpty()) {
						for (MatrixCoords cop : CoordsCopied) {

							if (next.r != cop.r || next.c != cop.c) {

								if (next.r == cop.r && next.c == cop.c + 1) {
									cont++;
									break;
								} else if (next.r == cop.r && next.c == cop.c - 1) {
									cont++;
									break;
								} else if (next.r == cop.r + 1 && next.c == cop.c) {
									cont++;
									break;
								} else if (next.r == cop.r - 1 && next.c == cop.c) {
									cont++;
									break;
								} else {
									isEnd = true;
									break;
								}
							}
						}

					} else {
						isEnd = true;
					}

					if (isEnd == true) {
						if (cont >= 3) {
							Num_obj_for_tipe.add(cont);
							cont = 1;
						}
						cont = 1;

					}

				}
			}
			Coordinates_Array.clear();

		}

		for (Integer cont : Num_obj_for_tipe) {
			if (cont == 3) {
				points += 2;
			} else if (cont == 4) {
				points += 3;
			} else if (cont == 5) {
				points += 5;
			} else if (cont >= 6) {
				points += 8;
			}
		}

		return points;
	}

	/**
	 * This recursive function will check how many adjacent cards of the same type
	 * you have
	 *
	 * @param actualCoords the coordinates of the card in considered
	 * @param Coordinate   the array containing the coordinates of the previously
	 *                     checked cards, if empty it means that no adjacent cards
	 *                     were found for the specific type of object
	 * @param bookshelf    the player bookshelf under validation
	 * @param actualObj    the object to check among the 6 types: book, cat etc.
	 */
	public static void ricorsive(MatrixCoords actualCoords, ArrayList<MatrixCoords> Coordinate, Bookshelf bookshelf,
			BookshelfObject actualObj) {
		int flag = 0;
		int flag2 = 0;
		int flag3 = 0;
		int flag4 = 0;
		int jump_already_present = 0;
		int jump_already_present2 = 0;
		int jump_already_present3 = 0;
		int jump_already_present4 = 0;

		int Right_col = actualCoords.c + 1;
		BookshelfObject obj_d = bookshelf.get(new MatrixCoords(actualCoords.r, actualCoords.c + 1));
		if (obj_d != null && obj_d.name() == actualObj.name()) {

			for (MatrixCoords mat_coords : Coordinate) {
				if (mat_coords.r == actualCoords.r && mat_coords.c == actualCoords.c + 1) {
					flag = 1;
				}

			}
			for (MatrixCoords mat_coords : Coordinate) {
				if (mat_coords.r == actualCoords.r && mat_coords.c == actualCoords.c) {
					jump_already_present = 1;
				}

			}
			if (jump_already_present == 0) {
				Coordinate.add(new MatrixCoords(actualCoords.r, actualCoords.c));
			}
			if (flag != 1) {

				Coordinate.add(new MatrixCoords(actualCoords.r, Right_col));
				ricorsive(new MatrixCoords(actualCoords.r, Right_col), Coordinate, bookshelf, actualObj);
			}
		}

		int Up_row = actualCoords.r + 1;
		BookshelfObject obj_su = bookshelf.get(new MatrixCoords(Up_row, actualCoords.c));
		if (obj_su != null && obj_su.name() == actualObj.name()) {
			for (MatrixCoords mat_coords : Coordinate) {
				if (mat_coords.r == Up_row && mat_coords.c == actualCoords.c) {
					flag2 = 1;
				}

			}
			for (MatrixCoords mat_coords : Coordinate) {
				if (mat_coords.r == actualCoords.r && mat_coords.c == actualCoords.c) {
					jump_already_present2 = 1;
				}

			}
			if (jump_already_present2 == 0) {
				Coordinate.add(new MatrixCoords(actualCoords.r, actualCoords.c));
			}
			if (flag2 != 1) {
				Coordinate.add(new MatrixCoords(Up_row, actualCoords.c));
				ricorsive(new MatrixCoords(Up_row, actualCoords.c), Coordinate, bookshelf, actualObj);
			}

		}

		int R_giu = actualCoords.r - 1;
		if (R_giu < 0) {
			R_giu = 10;
		}
		BookshelfObject obj_giu = bookshelf.get(new MatrixCoords(R_giu, actualCoords.c));
		if (obj_giu != null && obj_giu.name() == actualObj.name()) {
			for (MatrixCoords mat_coords : Coordinate) {

				if (mat_coords.r == R_giu && mat_coords.c == actualCoords.c) {
					flag3 = 1;
				}

			}
			for (MatrixCoords mat_coords : Coordinate) {
				if (mat_coords.r == actualCoords.r && mat_coords.c == actualCoords.c) {
					jump_already_present3 = 1;
				}

			}
			if (jump_already_present3 == 0) {
				Coordinate.add(new MatrixCoords(actualCoords.r, actualCoords.c));
			}

			if (flag3 != 1) {
				Coordinate.add(new MatrixCoords(R_giu, actualCoords.c));
				ricorsive(new MatrixCoords(R_giu, actualCoords.c), Coordinate, bookshelf, actualObj);
			}
		}

		int Left = actualCoords.c - 1;
		if (Left < 0) {
			Left = 10;
		}
		BookshelfObject obj_left = bookshelf.get(new MatrixCoords(actualCoords.r, Left));
		if (obj_left != null && obj_left.name() == actualObj.name()) {
			for (MatrixCoords mat_coords : Coordinate) {

				if (mat_coords.r == actualCoords.r && mat_coords.c == Left) {
					flag4 = 1;
				}
			}
			for (MatrixCoords mat_coords : Coordinate) {
				if (mat_coords.r == actualCoords.r && mat_coords.c == actualCoords.c) {
					jump_already_present4 = 1;
				}

			}
			if (jump_already_present4 == 0) {
				Coordinate.add(new MatrixCoords(actualCoords.r, actualCoords.c));
			}

			if (flag4 != 1) {
				Coordinate.add(new MatrixCoords(actualCoords.r, Left));
				ricorsive(new MatrixCoords(actualCoords.r, Left), Coordinate, bookshelf, actualObj);
			}
		}
	}

	public String getDescription() {
		String desc = "Groups of adjacent item tiles of the\r\n" + "same type on your bookshelf grant\r\n"
				+ "points depending on how many\r\n" + "tiles are connected (with one side\r\n" + "touching).\r\n"
				+ "Note: Item tiles with the same\r\n" + "background color are considered to be\r\n"
				+ "of the same type";
		return desc;
	}
}
