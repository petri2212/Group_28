package resource;

import javax.swing.ImageIcon;

/**
 * Lists all the icons images used by the game.
 */
public enum Icons implements Resource<ImageIcon> {

	ICON_CAT("./resources/icon_tiles/icon_cat.png"),
	ICON_TROPHY("./resources/icon_tiles/icon_trophy.png"),
	ICON_GAME("./resources/icon_tiles/icon_game.png"),
	ICON_PLANT("./resources/icon_tiles/icon_plant.png"),
	BOARD("./resources/boards/livingroom_reduced.png"),
	BOARD_BLURRED("./resources/boards/livingroom_reduced_blurred.png"),
	BOOKSHELF("./resources/boards/bookshelf_orth_edited.png"),
	ICON_FIRST("./resources/scoring_tokens/resized/first_place.jpg"),
	ICON_SECOND("./resources/scoring_tokens/resized/second_place.jpg"),
	ICON_THIRD("./resources/scoring_tokens/resized/third_place.jpg"),
	LOGO_CRANIO("./resources/publisher_material/Publisher.png"),
	LOGO_UNIBG("./resources/publisher_material/unibg_logo.png");

	private String path;

	private Icons(String path) {
		this.path = path;
	}

	/**
	 * Loads an icon image from the specified path attribute.
	 *
	 * @return an ImageIcon object from the javax.swing package
	 */
	@Override
	public ImageIcon load() {
		return new ImageIcon(path);
	}

}
