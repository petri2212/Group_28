package gui.view.graphic;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import gui.component.BackgroundPanel;
import gui.view.PointsPageView;
import resource.Icons;
import resource.Images;

public class PointsPageViewGraphic extends PointsPageView {

	private static final int PODIO_SIZE = 3;
	private static final int FIRST_PLACE_INDEX = 0;
	private static final int SECOND_PLACE_INDEX = 1;
	private static final int THIRD_PLACE_INDEX = 2;

	private JFrame mainFrame;
	private JLabel[] lblNames = new JLabel[PODIO_SIZE];
	private JLabel[] lblPoints = new JLabel[PODIO_SIZE];

	public PointsPageViewGraphic(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void show() {

		Image image = Images.PUBLISHER_MATERIAL_SCORE_PAGE.load();
		BackgroundPanel contentPane = new BackgroundPanel(image);
		contentPane.setLayout(null);

		JButton btnReturnHome = new JButton("Return Home");
		btnReturnHome.setOpaque(false);
		btnReturnHome.setBackground(new Color(255, 255, 255));
		btnReturnHome.setFocusPainted(false);
		btnReturnHome.setHorizontalTextPosition(SwingConstants.CENTER);
		btnReturnHome.setFont(new Font("Purisa", Font.BOLD, 16));
		btnReturnHome.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnReturnHome.setForeground(new Color(255, 255, 255));
		btnReturnHome.setIconTextGap(-100);
		btnReturnHome.setBounds(498, 625, 144, 64);
		btnReturnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReturnHome.addActionListener(actionReturnMainPage);
		contentPane.add(btnReturnHome);

		JPanel panelFirst = new JPanel();
		panelFirst.setOpaque(false);
		panelFirst.setBounds(415, 50, 300, 260);
		contentPane.add(panelFirst);
		panelFirst.setLayout(null);

		JLabel lblFirstImage = new JLabel("");
		lblFirstImage.setIcon(Icons.ICON_FIRST.load());
		lblFirstImage.setBounds(new Rectangle(0, 0, 150, 150));
		lblFirstImage.setBounds(75, 11, 150, 150);
		panelFirst.add(lblFirstImage);

		lblNames[FIRST_PLACE_INDEX] = new JLabel("___________________");
		JLabel lblFirst = lblNames[FIRST_PLACE_INDEX];
		lblFirst.setForeground(new Color(255, 255, 255));
		lblFirst.setFont(new Font("Purisa", Font.BOLD, 18));
		lblFirst.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFirst.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirst.setBounds(25, 182, 250, 24);
		panelFirst.add(lblFirst);

		JLabel lblPointsFirstHeader = new JLabel("Points :");
		lblPointsFirstHeader.setFont(new Font("Purisa", Font.BOLD, 18));
		lblPointsFirstHeader.setForeground(new Color(255, 255, 255));
		lblPointsFirstHeader.setBounds(44, 237, 90, 24);
		panelFirst.add(lblPointsFirstHeader);

		lblPoints[FIRST_PLACE_INDEX] = new JLabel("0");
		JLabel lblPointsFirst = lblPoints[FIRST_PLACE_INDEX];
		lblPointsFirst.setFont(new Font("Purisa", Font.BOLD, 18));
		lblPointsFirst.setForeground(new Color(255, 255, 255));
		lblPointsFirst.setHorizontalAlignment(SwingConstants.CENTER);
		lblPointsFirst.setBounds(170, 237, 59, 24);
		panelFirst.add(lblPointsFirst);

		JPanel panelSecond = new JPanel();
		panelSecond.setOpaque(false);
		panelSecond.setLayout(null);
		panelSecond.setBounds(120, 300, 300, 260);
		contentPane.add(panelSecond);

		JLabel lblSecondImage = new JLabel("");
		lblSecondImage.setIcon(Icons.ICON_SECOND.load());
		lblSecondImage.setBounds(new Rectangle(0, 0, 150, 150));
		lblSecondImage.setBounds(75, 11, 150, 150);
		panelSecond.add(lblSecondImage);

		lblNames[SECOND_PLACE_INDEX] = new JLabel("___________________");
		JLabel lblSecond = lblNames[SECOND_PLACE_INDEX];
		lblSecond.setForeground(new Color(255, 255, 255));
		lblSecond.setFont(new Font("Purisa", Font.BOLD, 18));
		lblSecond.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSecond.setHorizontalAlignment(SwingConstants.CENTER);
		lblSecond.setBounds(25, 173, 250, 24);
		panelSecond.add(lblSecond);

		JLabel lblPointsSecondHeader = new JLabel("Points :");
		lblPointsSecondHeader.setForeground(new Color(255, 255, 255));
		lblPointsSecondHeader.setFont(new Font("Purisa", Font.BOLD, 18));
		lblPointsSecondHeader.setBounds(44, 237, 90, 24);
		panelSecond.add(lblPointsSecondHeader);

		lblPoints[SECOND_PLACE_INDEX] = new JLabel("0");
		JLabel lblPointsSecond = lblPoints[SECOND_PLACE_INDEX];
		lblPointsSecond.setForeground(new Color(255, 255, 255));
		lblPointsSecond.setFont(new Font("Purisa", Font.BOLD, 18));
		lblPointsSecond.setHorizontalAlignment(SwingConstants.CENTER);
		lblPointsSecond.setBounds(170, 237, 59, 24);
		panelSecond.add(lblPointsSecond);

		JPanel panelThird = new JPanel();
		panelThird.setOpaque(false);
		panelThird.setLayout(null);
		panelThird.setBounds(720, 300, 300, 260);
		contentPane.add(panelThird);

		JLabel lblThirdImage = new JLabel("");
		lblThirdImage.setIcon(Icons.ICON_THIRD.load());
		lblThirdImage.setBounds(new Rectangle(0, 0, 150, 150));
		lblThirdImage.setBounds(75, 11, 150, 150);
		panelThird.add(lblThirdImage);

		lblNames[THIRD_PLACE_INDEX] = new JLabel("___________________");
		JLabel lblThird = lblNames[THIRD_PLACE_INDEX];
		lblThird.setForeground(new Color(255, 255, 255));
		lblThird.setFont(new Font("Purisa", Font.BOLD, 18));
		lblThird.setVerticalAlignment(SwingConstants.BOTTOM);
		lblThird.setHorizontalAlignment(SwingConstants.CENTER);
		lblThird.setBounds(25, 173, 250, 24);
		panelThird.add(lblThird);

		JLabel lblPointsThirdHeader = new JLabel("Points :");
		lblPointsThirdHeader.setForeground(new Color(255, 255, 255));
		lblPointsThirdHeader.setFont(new Font("Purisa", Font.BOLD, 18));
		lblPointsThirdHeader.setBounds(44, 237, 90, 24);
		panelThird.add(lblPointsThirdHeader);

		lblPoints[THIRD_PLACE_INDEX] = new JLabel("0");
		JLabel lblPointsThird = lblPoints[THIRD_PLACE_INDEX];
		lblPointsThird.setForeground(new Color(255, 255, 255));
		lblPointsThird.setFont(new Font("Purisa", Font.BOLD, 18));
		lblPointsThird.setHorizontalAlignment(SwingConstants.CENTER);
		lblPointsThird.setBounds(170, 237, 59, 24);
		panelThird.add(lblPointsThird);

		updatePlayersNameAndPoints();

		mainFrame.setContentPane(contentPane);
		mainFrame.pack();
		mainFrame.revalidate();
		mainFrame.repaint();
	}

	private void updatePlayersNameAndPoints() {
		for (int i = 0; (i < players.size() && i < PODIO_SIZE); i++) {
			String name = players.get(i).getName();
			int points = players.get(i).getPoints();

			lblNames[i].setText(name);
			lblPoints[i].setText("" + points);
		}
	}
}
