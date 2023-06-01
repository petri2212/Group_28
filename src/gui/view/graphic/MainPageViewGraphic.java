package gui.view.graphic;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import gui.component.BackgroundPanel;
import gui.view.MainPageView;
import myshelfie.MyShelfie;
import resource.Icons;
import resource.Images;

public class MainPageViewGraphic extends MainPageView {

	private JFrame mainFrame;

	public MainPageViewGraphic(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
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

		JLabel lblVersionHeader = new JLabel("Version");
		lblVersionHeader.setForeground(Color.WHITE);
		lblVersionHeader.setFont(new Font("Purisa", Font.BOLD, 14));
		lblVersionHeader.setBounds(37, 696, 70, 15);
		contentPane.add(lblVersionHeader);

		JLabel lblVersion = new JLabel(MyShelfie.VERSION);
		lblVersion.setForeground(Color.WHITE);
		lblVersion.setFont(new Font("Purisa", Font.BOLD, 14));
		lblVersion.setBounds(114, 696, 70, 15);
		contentPane.add(lblVersion);

		JLabel lblLogoCranioCreations = new JLabel("");
		lblLogoCranioCreations.setIcon(Icons.LOGO_CRANIO.load());
		lblLogoCranioCreations.setBounds(978, 561, 150, 150);
		contentPane.add(lblLogoCranioCreations);

		JLabel lblLogoUnibg = new JLabel("");
		lblLogoUnibg.setIcon(Icons.LOGO_UNIBG.load());
		lblLogoUnibg.setBounds(793, 561, 150, 150);
		contentPane.add(lblLogoUnibg);

		mainFrame.setContentPane(contentPane);
		mainFrame.pack();
		mainFrame.revalidate();
		mainFrame.repaint();
	}

}
