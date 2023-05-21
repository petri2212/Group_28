package resource;

import javax.swing.ImageIcon;

public enum Icons implements Resource<ImageIcon> {

	ICON_CAT("./resources/icon_tiles/icon_cat.png"),
	ICON_TROPHY("./resources/icon_tiles/icon_trophy.png"),
	ICON_GAME("./resources/icon_tiles/icon_game.png"),
	ICON_PLANT("./resources/icon_tiles/icon_plant.png"),
	BOARD("./resources/boards/livingroom_reduced.png"),
	BOARD_BLURRED("./resources/boards/livingroom_reduced_blurred.png");

	private String path;

	private Icons(String path) {
		this.path = path;
	}

	@Override
	public ImageIcon load() {
		return new ImageIcon(path);
	}

}
