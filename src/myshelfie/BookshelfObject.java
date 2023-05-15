package myshelfie;

import java.util.Random;

public enum BookshelfObject {

	CAT(3),
	BOOK(4),
	GAME(4),
	FRAME(5),
	TROPHY(6),
	PLANT(5);

	private int lenghtOfBookshelfObject;
	public static final int MAX_INSTANCES = 22;
	private static final Random RANDOM = new Random();

	private int instancesCounter;

	private BookshelfObject(int lenghtOfBookshelfObject) {
		this.lenghtOfBookshelfObject = lenghtOfBookshelfObject;
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
		int randomIndex = RANDOM.nextInt(objects.length);
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
	
	public int getLenghtOfBookshelfObject() {
		return this.lenghtOfBookshelfObject;
	}

}
