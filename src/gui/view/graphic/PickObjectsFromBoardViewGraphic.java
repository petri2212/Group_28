package gui.view.graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import gui.component.BackgroundPanel;
import gui.component.BookshelfObjectButton;
import gui.view.PickObjectsFromBoardView;
import myshelfie.Board;
import myshelfie.BookshelfObject;
import myshelfie.Tile;
import resource.Icons;
import resource.Images;
import utils.MatrixCoords;

public class PickObjectsFromBoardViewGraphic extends PickObjectsFromBoardView {

	private static final int TILE_ORIGIN_X = 221;
	private static final int TILE_ORIGIN_Y = 646;
	private static final int TILE_OFFSET = 10;
	private JFrame mainFrame;
	private JLabel lblWarningHeader;
	private JLabel lblWarning;
	private JLabel lblBoard;
	private JLabel lblPlayerTurn;
	private JPanel panelCommonGoal1;
	private JPanel panelCommonGoal2;
	private JPanel panelPersonalGoal;
	private JPanel panelBookshelf;
	private JButton btnShowBookshelf;
	private JButton btnHideBookshelf;
	private JPanel contentPane;
	private JPanel panelObjects;

	public PickObjectsFromBoardViewGraphic(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void show() {
		actionPrintBoard.actionPerformed(null);
		actionPickPlayerName.actionPerformed(null);

		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		panelObjects = new JPanel();
		panelObjects.setOpaque(false);
		panelObjects.setBounds(0, 0, 1140, 745);
		panelObjects.setLayout(null);
		panelObjects.setVisible(false);
		panelObjects.setEnabled(false);
		printAllBookshelfObjects();
		contentPane.add(panelObjects);

		JPanel panelWarning = new JPanel();
		panelWarning.setVisible(true);
		panelWarning.setEnabled(true);
		panelWarning.setBounds(288, 285, 537, 246);
		contentPane.add(panelWarning);
		panelWarning.setLayout(null);

		lblWarningHeader = new JLabel("Get Ready!");
		lblWarningHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarningHeader.setBounds(0, 0, 537, 41);
		panelWarning.add(lblWarningHeader);

		lblWarning = new JLabel("Its " + playerName + "'s turn.");
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setBounds(10, 53, 515, 128);
		panelWarning.add(lblWarning);

		JButton btnAcknowledge = new JButton("Ok");
		btnAcknowledge.setBounds(208, 193, 117, 25);
		btnAcknowledge.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelWarning.setVisible(false);
				panelWarning.setEnabled(false);
				panelObjects.setVisible(true);
				panelObjects.setEnabled(true);
			}
		});
		panelWarning.add(btnAcknowledge);

		panelBookshelf = new BackgroundPanel(Images.BOOKSHELF.load());
		panelBookshelf.setVisible(false);
		panelBookshelf.setEnabled(false);
		panelBookshelf.setOpaque(false);
		panelBookshelf.setBounds(310, 104, 500, 500);
		contentPane.add(panelBookshelf);

		panelPersonalGoal = new BackgroundPanel(personalGoal.getImage());
		panelPersonalGoal.setBounds(10, 113, 165, 250);
		contentPane.add(panelPersonalGoal);

		panelCommonGoal1 = new BackgroundPanel(commonGoal1.getImage());
		panelCommonGoal1.setBounds(954, 62, 167, 109);
		contentPane.add(panelCommonGoal1);

		panelCommonGoal2 = new BackgroundPanel(commonGoal2.getImage());
		panelCommonGoal2.setBounds(954, 180, 167, 109);
		contentPane.add(panelCommonGoal2);

		JLabel lblCommonGoalsHeader = new JLabel("Common Goals");
		lblCommonGoalsHeader.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCommonGoalsHeader.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCommonGoalsHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblCommonGoalsHeader.setForeground(Color.WHITE);
		lblCommonGoalsHeader.setFont(new Font("Purisa", Font.BOLD, 16));
		lblCommonGoalsHeader.setBounds(942, 0, 188, 46);
		contentPane.add(lblCommonGoalsHeader);

		JLabel lblPlayerTurnHeader = new JLabel("Player's Turn:");
		lblPlayerTurnHeader.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPlayerTurnHeader.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPlayerTurnHeader.setFont(new Font("Purisa", Font.BOLD, 16));
		lblPlayerTurnHeader.setForeground(new Color(255, 255, 255));
		lblPlayerTurnHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerTurnHeader.setBounds(0, 0, 188, 46);
		contentPane.add(lblPlayerTurnHeader);

		lblPlayerTurn = new JLabel(playerName);
		lblPlayerTurn.setFont(new Font("Purisa", Font.BOLD, 16));
		lblPlayerTurn.setForeground(new Color(255, 255, 255));
		lblPlayerTurn.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPlayerTurn.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPlayerTurn.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerTurn.setBounds(0, 47, 189, 42);
		contentPane.add(lblPlayerTurn);

		JButton btnEndTurn = new JButton("End Turn");
		btnEndTurn.setVisible(false);
		btnEndTurn.setBackground(new Color(255, 255, 255));
		btnEndTurn.setOpaque(false);
		btnEndTurn.setFocusPainted(false);
		btnEndTurn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEndTurn.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnEndTurn.setForeground(new Color(255, 255, 255));
		btnEndTurn.setFont(new Font("Purisa", Font.BOLD, 16));
		btnEndTurn.setBounds(965, 645, 142, 57);
		contentPane.add(btnEndTurn);

		JButton btnPickObjects = new JButton("Pick Objects");
		btnPickObjects.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPickObjects.setOpaque(false);
		btnPickObjects.setForeground(Color.WHITE);
		btnPickObjects.setFont(new Font("Purisa", Font.BOLD, 16));
		btnPickObjects.setFocusPainted(false);
		btnPickObjects.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnPickObjects.setBackground(Color.WHITE);
		btnPickObjects.setBounds(965, 645, 142, 57);
		contentPane.add(btnPickObjects);

		btnShowBookshelf = new JButton("Show Shelf");
		btnShowBookshelf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnShowBookshelf.setOpaque(false);
		btnShowBookshelf.setForeground(Color.WHITE);
		btnShowBookshelf.setFont(new Font("Purisa", Font.BOLD, 16));
		btnShowBookshelf.setFocusPainted(false);
		btnShowBookshelf.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnShowBookshelf.setBackground(Color.WHITE);
		btnShowBookshelf.setBounds(20, 385, 142, 57);
		btnShowBookshelf.addActionListener(actionShowBookshelf);
		contentPane.add(btnShowBookshelf);

		btnHideBookshelf = new JButton("Hide Shelf");
		btnShowBookshelf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHideBookshelf.setVisible(false);
		btnHideBookshelf.setEnabled(false);
		btnHideBookshelf.setOpaque(false);
		btnHideBookshelf.setForeground(Color.WHITE);
		btnHideBookshelf.setFont(new Font("Purisa", Font.BOLD, 16));
		btnHideBookshelf.setFocusPainted(false);
		btnHideBookshelf.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnHideBookshelf.setBackground(Color.WHITE);
		btnHideBookshelf.setBounds(20, 385, 142, 57);
		btnHideBookshelf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hideBookshelf();
			}
		});
		contentPane.add(btnHideBookshelf);

		JPanel panelBoard = new JPanel();
		panelBoard.setOpaque(false);
		panelBoard.setBounds(0, 0, 1130, 745);
		contentPane.add(panelBoard);
		panelBoard.setLayout(new BorderLayout(0, 0));

		lblBoard = new JLabel("");
		lblBoard.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoard.setIcon(Icons.BOARD.load());
		panelBoard.add(lblBoard, BorderLayout.CENTER);

		mainFrame.setBackground(new Color(36, 31, 49));
		mainFrame.setContentPane(contentPane);
		mainFrame.pack();
		mainFrame.revalidate();
		mainFrame.repaint();
	}

	private void printAllBookshelfObjects() {
		for (int r = 0; r < Board.ROW_COUNT; r++) {
			for (int c = 0; c < Board.COL_COUNT; c++) {
				Tile tile = board.get(new MatrixCoords(r, c));

				if (tile != null) {
					BookshelfObject object = tile.getBookshelfObject();

					if (object != null) {
						BookshelfObjectButton objectButton = new BookshelfObjectButton(object, new MatrixCoords(r, c));

						// calculate the absolute position of the object from the relative coordinates
						int w = BookshelfObjectButton.WIDTH;
						int h = BookshelfObjectButton.HEIGHT;
						int x = TILE_ORIGIN_X + c * (BookshelfObjectButton.WIDTH + TILE_OFFSET);
						int y = TILE_ORIGIN_Y - r * (BookshelfObjectButton.HEIGHT + TILE_OFFSET);
						objectButton.setBounds(x, y, w, h);
						objectButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								if (!objectButton.isSelected) {
									board.pickObject(objectButton.getCoords());
									objectButton.setBorder(new LineBorder(new Color(87, 227, 137), 5));
									objectButton.isSelected = true;
								}
							}
						});

						panelObjects.add(objectButton);
					}
				}
			}
		}
	}

	@Override
	public void showBookshelf() {
		panelBookshelf.setVisible(true);
		lblBoard.setIcon(Icons.BOARD_BLURRED.load());
		panelObjects.setVisible(false);
		panelObjects.setEnabled(false);
		btnShowBookshelf.setVisible(false);
		btnShowBookshelf.setEnabled(false);
		btnHideBookshelf.setVisible(true);
		btnHideBookshelf.setEnabled(true);
	}

	private void hideBookshelf() {
		panelBookshelf.setVisible(false);
		lblBoard.setIcon(Icons.BOARD.load());
		panelObjects.setVisible(true);
		panelObjects.setEnabled(true);
		btnShowBookshelf.setVisible(true);
		btnShowBookshelf.setEnabled(true);
		btnHideBookshelf.setVisible(false);
		btnHideBookshelf.setEnabled(false);
	}

	@Override
	public void showAlreadySelectedCoordsWarning() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showCoordsNotInTheBoardWarning() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showChangeStateWarning() {
		// TODO Auto-generated method stub

	}

}
