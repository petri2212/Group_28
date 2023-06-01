package goal;

import myshelfie.Bookshelf;

/**
 * Interface Goal is used because all of the Goal have the check method
 */
public interface Goal {

	public int check(Bookshelf bookshelf);
}
