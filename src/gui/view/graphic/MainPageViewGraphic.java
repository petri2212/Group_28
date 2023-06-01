package gui.view.graphic;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import gui.component.BackgroundPanel;
import gui.view.MainPageView;
import resource.Images;
/**
 * This is the view graphic for the home page and it extends the abstract
 * view.
 */
public class MainPageViewGraphic extends MainPageView {

	private JFrame mainFrame;

	public MainPageViewGraphic(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	/**
	 * This is the override of the show method.
	 * This method show the home page with two buttons:
	 * the new game button and the exit button.
	 */
	public void show() {
		Image image = Images.PUBLISHER_MATERIAL_MAIN_PAGE.load();
		BackgroundPanel contentPane = new BackgroundPanel(image);
		contentPane.setLayout(null);

		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setOpaque(false);
		btnNewGame.setFocusPainted(false);
		btnNewGame.setFont(new Font("Purisa", Font.BOLD, 18));
		btnNewGame.setBounds(37, 232, 185, 62);
		btnNewGame.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewGame.setMaximumSize(new Dimension(174, 62));
		btnNewGame.setMinimumSize(new Dimension(174, 62));
		btnNewGame.setPreferredSize(new Dimension(174, 62));
		btnNewGame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewGame.setMargin(new Insets(0, 0, 0, 0));
		btnNewGame.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewGame.setBackground(new Color(255, 255, 255));
		btnNewGame.setForeground(new Color(255, 255, 255));
		btnNewGame.addActionListener(actionNewGame);
		contentPane.add(btnNewGame);

		JButton btnExit = new JButton("Exit");
		btnExit.setPreferredSize(new Dimension(174, 62));
		btnExit.setOpaque(false);
		btnExit.setMinimumSize(new Dimension(174, 62));
		btnExit.setMaximumSize(new Dimension(174, 62));
		btnExit.setMargin(new Insets(0, 0, 0, 0));
		btnExit.setHorizontalTextPosition(SwingConstants.CENTER);
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Purisa", Font.BOLD, 18));
		btnExit.setFocusPainted(false);
		btnExit.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnExit.setBackground(Color.WHITE);
		btnExit.setAlignmentX(0.5f);
		btnExit.setBounds(37, 365, 185, 62);
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.addActionListener(actionExit);
		contentPane.add(btnExit);

		mainFrame.setContentPane(contentPane);
		mainFrame.pack();
		mainFrame.revalidate();
		mainFrame.repaint();
	}

}
