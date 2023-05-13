package resource;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public enum Icons implements Resource<Icons> {

	BUTTON_NEW_GAME("./resources/buttons/btnNewGame.png"),
	BUTTON_NEW_GAME_PRESSED("./resources/buttons/btnNewGamePressed.png"),
	BUTTON_EXIT("./resources/buttons/btnExitPressed.png"), BUTTON_EXIT_PRESSED("./resources/buttons/btnExit.png");

	private String path;

	private Icons(String path) {
		this.path = path;
	}

	@Override
	public Icons load() {
		return new ImageIcon(path);
	}

}
