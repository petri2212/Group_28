package gui.view.graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import gui.component.BackgroundPanel;
import gui.view.MainPageView;
import resource.Icons;
import resource.Images;

public class MainPageViewGraphic extends MainPageView {

	private JFrame mainFrame;

	public MainPageViewGraphic(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void show() {
		Image image = Images.PUBLISHER_MATERIAL_DISPLAY_1.load();
		BackgroundPanel contentPane = new BackgroundPanel(image);

		JPanel panelMain = new JPanel();
		panelMain.setBorder(new EmptyBorder(20, 20, 50, 20));
		panelMain.setOpaque(false);
		contentPane.add(panelMain, BorderLayout.SOUTH);
		panelMain.setLayout(new GridLayout(2, 1, 0, 50));

		JPanel panelNewGame = new JPanel();
		panelNewGame.setOpaque(false);
		panelMain.add(panelNewGame);

		JButton btnNewGame = new JButton("");
		panelNewGame.add(btnNewGame);
		btnNewGame.setBorder(null);
		btnNewGame.setMaximumSize(new Dimension(174, 62));
		btnNewGame.setMinimumSize(new Dimension(174, 62));
		btnNewGame.setPreferredSize(new Dimension(174, 62));
		btnNewGame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewGame.setOpaque(false);
		btnNewGame.setFocusPainted(false);
		btnNewGame.setSelectedIcon(Icons.BUTTON_NEW_GAME_PRESSED.load());
		btnNewGame.setPressedIcon(Icons.BUTTON_NEW_GAME_PRESSED.load());
		btnNewGame.setMargin(new Insets(0, 0, 0, 0));
		btnNewGame.setBorderPainted(false);
		btnNewGame.setContentAreaFilled(false);
		btnNewGame.setHideActionText(true);
		btnNewGame.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewGame.setIcon(Icons.BUTTON_NEW_GAME.load());
		btnNewGame.setBackground(new Color(255, 255, 255));
		btnNewGame.setForeground(new Color(255, 255, 255));
		btnNewGame.addActionListener(actionNewGame);

		JPanel panelExit = new JPanel();
		panelExit.setOpaque(false);
		panelMain.add(panelExit);

		JButton btnExit = new JButton("");
		panelExit.add(btnExit);
		btnExit.setMinimumSize(new Dimension(174, 62));
		btnExit.setMaximumSize(new Dimension(174, 62));
		btnExit.setPreferredSize(new Dimension(174, 62));
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.setPressedIcon(Icons.BUTTON_EXIT_PRESSED.load());
		btnExit.setSelectedIcon(Icons.BUTTON_EXIT_PRESSED.load());
		btnExit.setIcon(Icons.BUTTON_EXIT.load());
		btnExit.setOpaque(false);
		btnExit.setMargin(new Insets(0, 0, 0, 0));
		btnExit.setHorizontalTextPosition(SwingConstants.CENTER);
		btnExit.setHideActionText(true);
		btnExit.setForeground(Color.WHITE);
		btnExit.setFocusPainted(false);
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.setBorder(null);
		btnExit.setBackground(new Color(255, 255, 255));
		btnExit.addActionListener(actionExit);

		mainFrame.setContentPane(contentPane);
		mainFrame.pack();
		mainFrame.revalidate();
		mainFrame.repaint();
	}

}
