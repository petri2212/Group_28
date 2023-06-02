package myshelfie;

import java.awt.Image;
import java.util.Random;

import gui.DrawableObject;
import resource.Images;

public enum BookshelfObject implements DrawableObject {

	CAT(new Images[] { Images.BOOKSHELF_OBJECT_CAT_1, Images.BOOKSHELF_OBJECT_CAT_2,
			Images.BOOKSHELF_OBJECT_CAT_3 }),
	BOOK(new Images[] { Images.BOOKSHELF_OBJECT_BOOK_1, Images.BOOKSHELF_OBJECT_BOOK_2,
			Images.BOOKSHELF_OBJECT_BOOK_3 }),
	GAME(new Images[] { Images.BOOKSHELF_OBJECT_GAME_1, Images.BOOKSHELF_OBJECT_GAME_2,
			Images.BOOKSHELF_OBJECT_GAME_3 }),
	FRAME(new Images[] { Images.BOOKSHELF_OBJECT_FRAME_1, Images.BOOKSHELF_OBJECT_FRAME_2,
			Images.BOOKSHELF_OBJECT_FRAME_3 }),
	TROPHY(new Images[] { Images.BOOKSHELF_OBJECT_TROPHY_1, Images.BOOKSHELF_OBJECT_TROPHY_2,
			Images.BOOKSHELF_OBJECT_TROPHY_3 }),
	PLANT(new Images[] { Images.BOOKSHELF_OBJECT_PLANT_1, Images.BOOKSHELF_OBJECT_PLANT_2,
			Images.BOOKSHELF_OBJECT_PLANT_3 });

	public static final int MAX_INSTANCES = 22;
	private static final Random RANDOM = new Random();

	private int instancesCounter;
	private Images[] images;

	private BookshelfObject(Images[] images) {
		instancesCounter = 0;
		this.images = images;
	}

	private boolean reachedMaxInstances() {
		return (this.instancesCounter >= MAX_INSTANCES) ? true : false;
	}

	/**
	 * Returns a random ShelfObject if its instances number is less than the max
	 * limit. If this method returns null it means that there are no more
	 * ShelfObject available.
	 *
	 * @return a random available ShelfObject
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

			if (randomIndex >= objects.length) {
				randomIndex = 0;
			}
		} while (object.reachedMaxInstances() && indexCounter < objects.length);

		object.instancesCounter++;
		return object;
	}
	
	/**
	 * @return a random image between the object images
	 */
	@Override
	public Image getImage() {
		int randomIndex = RANDOM.nextInt(images.length - 1);
		return images[randomIndex].load();
	}

}
