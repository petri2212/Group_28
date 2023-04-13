package myshelfie;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public enum ResourceImage implements Resource<Image> {
	PUBLISHER_MATERIAL_DISPLAY_1("resources/publisher_material/Display_1.jpg");

	private String path;

	private ResourceImage(String path) {
		this.path = path;
	}

	@Override
	public Image load() {
		URL url = getClass().getClassLoader().getResource(path);

		try {
			return ImageIO.read(url);
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
