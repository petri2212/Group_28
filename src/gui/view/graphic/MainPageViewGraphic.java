package gui.view.graphic;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.component.BackgroundPanel;
import gui.view.MainPageView;
import myshelfie.ResourceImage;

public class MainPageViewGraphic extends MainPageView {

	private JFrame mainFrame;

	public MainPageViewGraphic(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void show() {
		JButton button = new JButton("New Game");
		button.addActionListener(actionNewGame);

		Image image = ResourceImage.PUBLISHER_MATERIAL_DISPLAY_1.load();
		BackgroundPanel panel = new BackgroundPanel(image);

		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.black);

		GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel buttons = new JPanel(new GridBagLayout());
        buttons.add(button, gbc);
        gbc.weighty = 1;

        panel.add(buttons, gbc);

		mainFrame.setContentPane(panel);
		mainFrame.pack();
		mainFrame.revalidate();
		mainFrame.repaint();
	}

}
