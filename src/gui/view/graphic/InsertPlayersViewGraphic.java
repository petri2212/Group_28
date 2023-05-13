package gui.view.graphic;

import java.awt.Image;

import javax.swing.JFrame;

import gui.component.BackgroundPanel;
import gui.view.InsertPlayersView;
import resource.Images;

public class InsertPlayersViewGraphic extends InsertPlayersView {

	private JFrame mainFrame;

	public InsertPlayersViewGraphic(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void show() {
		Image image = Images.PUBLISHER_MATERIAL_DISPLAY_1_BLURRED.load();
		BackgroundPanel contentPane = new BackgroundPanel(image);

		mainFrame.setContentPane(contentPane);
		mainFrame.pack();
		mainFrame.revalidate();
		mainFrame.repaint();
	}

}
