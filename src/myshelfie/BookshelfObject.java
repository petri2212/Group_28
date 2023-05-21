package myshelfie;

import java.util.Random;

public enum BookshelfObject {

	CAT(),
	BOOK(),
	GAME(),
	FRAME(),
	TROPHY(),
	PLANT();

	public static final int MAX_INSTANCES = 22;
	private static final Random RANDOM = new Random();

	private int instancesCounter;

	private BookshelfObject() {
		instancesCounter = 0;
	}

	private boolean reachedMaxInstances() {
		return (this.instancesCounter >= MAX_INSTANCES) ? true : false;
	}

	/**
	 * Returns a random ShelfObject if its instances number is less than the max limit.
	 * If this method returns null it means that there are no more ShelfObject available.
	 *
	 * @return	a random available ShelfObject
	 */
	public static BookshelfObject getRandomObject() {
		BookshelfObject object = null;
		BookshelfObject[] objects = values();
		int randomIndex = RANDOM.nextInt(objects.length - 1);
		int indexCounter = 0;

		do {
			object = objects[randomIndex];
			randomIndex++;
			indexCounter++;

			if(randomIndex >= objects.length) {
				randomIndex = 0;
			}
		} while(object.reachedMaxInstances() && indexCounter < objects.length);

		object.instancesCounter++;
		return object;
	}

}
