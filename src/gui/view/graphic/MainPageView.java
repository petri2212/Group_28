package gui.view.graphic;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.View;
import gui.component.BackgroundPanel;
import gui.controller.MainPageController;

import myshelfie.ResourceImage;

public class MainPageView extends View <MainPageController> {

	private JFrame mainFrame;

	public MainPageView(JFrame mainFrame, MainPageController controller) {
		super(controller);
		this.mainFrame = mainFrame;
	}

	@Override
	public void show() {
		JButton button = new JButton("New Game");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.actionNewGame();
			}
		});

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
