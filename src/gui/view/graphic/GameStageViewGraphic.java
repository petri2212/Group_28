package gui.view.graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
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
import gui.component.ColumnButton;
import gui.view.GameStageView;
import myshelfie.Board;
import myshelfie.BookshelfObject;
import myshelfie.Tile;
import resource.Icons;
import utils.MatrixCoords;

public class GameStageViewGraphic extends GameStageView {

	private static final int PICKED_OBJECT_1_INDEX = 0;
	private static final int PICKED_OBJECT_2_INDEX = 1;
	private static final int PICKED_OBJECT_3_INDEX = 2;

	private static final int TILE_HEIGHT = 67;
	private static final int TILE_WIDTH = 67;
	private static final int TILE_ORIGIN_X = 221;
	private static final int TILE_ORIGIN_Y = 646;
	private static final int TILE_OFFSET = 10;

	private static final int BOOKSHELF_SQUARE_SIZE = 67;

	private static final int BOOKSHELF_ORIGIN_X = 57;
	private static final int BOOKSHELF_ORIGIN_Y = 377;
	private static final int BOOKSHELF_OFFSET_X = 13;
	private static final int BOOKSHELF_OFFSET_Y = 2;

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
	private JPanel panelWarning;
	private JPanel panelGuide;
	private JButton btnHelp;
	private JButton btnEndTurn;
	private JButton btnAcknowledge;
	private JButton btnAccept;
	private JButton btnCancel;
	private BackgroundPanel[] panelPickedObjects = new BackgroundPanel[3];

	/* private action listeners */
	private MouseListener actionMouseOnBookshelf;

	private ActionListener actionHideGuidePanel;

	private ActionListener actionHideWarningPanel;

	private ActionListener actionShowHelpDialog;

	private ActionListener actionShowReturnHomeDialog;

	private ActionListener actionHideReturnMainPage;

	public ActionListener actionShowBookshelf;

	private ActionListener actionHideBookshelf;

	/**
	 * 
	 *
	 * @param mainFrame
	 */
	public GameStageViewGraphic(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		actionMouseOnBookshelf = initActionMouseOnBookshelf();
		actionHideGuidePanel = initActionHideGuidePanel();
		actionHideWarningPanel = initActionHideWarningPanel();
		actionShowHelpDialog = initActionShowHelpDialog();
		actionShowReturnHomeDialog = initActionShowReturnHomeDialog();
		actionHideReturnMainPage = initActionHideReturnMainPage();
		actionShowBookshelf = initActionShowBookshelf();
		actionHideBookshelf = initActionHideBookshelf();
	}

	@Override
	public void show() {
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
		printBoardObjects();
		contentPane.add(panelObjects);

		/* ********************* GUIDE DIALOG ************************ */
		panelGuide = new JPanel();
		panelGuide.setVisible(false);
		panelGuide.setEnabled(false);
		panelGuide.setBounds(288, 185, 537, 346);
		contentPane.add(panelGuide);
		panelGuide.setLayout(null);

		JLabel lblGuideHeader = new JLabel("Quick Guide");
		lblGuideHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuideHeader.setBounds(0, 0, 537, 41);
		panelGuide.add(lblGuideHeader);

		JLabel lblGuide = new JLabel("<html>You can pick up to three objects from the board.<br><br>"
				+ "Every object you pick must have at least one edge not connected to other objects.<br>"
				+ "Once you have choosen your objects, click them in the order you want to put them in the shelf.<br>"
				+ "Be aware! Once you have picked an object you can't put it back, so choose wisely.<br><br>"
				+ "After that you can click on the 'show shelf' button and select the column where you want to put all your objects.<br>"
				+ "You cannot divide the objects in more than one column.</html>");
		lblGuide.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuide.setBounds(10, 40, 515, 230);
		panelGuide.add(lblGuide);

		JButton btnGuideAcknowledge = new JButton("Ok");
		btnGuideAcknowledge.setBounds(208, 293, 117, 25);
		btnGuideAcknowledge.addActionListener(actionHideGuidePanel);
		panelGuide.add(btnGuideAcknowledge);

		/* ********************* WARNING DIALOG ************************ */
		panelWarning = new JPanel();
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

		btnAcknowledge = new JButton("Ok");
		btnAcknowledge.setBounds(208, 193, 117, 25);
		btnAcknowledge.addActionListener(actionHideWarningPanel);
		panelWarning.add(btnAcknowledge);

		btnAccept = new JButton("Ok");
		btnAccept.setVisible(false);
		btnAccept.setEnabled(false);
		btnAccept.setBounds(300, 193, 117, 25);
		btnAccept.addActionListener(actionReturnMainPage);
		panelWarning.add(btnAccept);

		btnCancel = new JButton("Cancel");
		btnCancel.setVisible(false);
		btnCancel.setEnabled(false);
		btnCancel.setBounds(100, 193, 117, 25);
		btnCancel.addActionListener(actionHideReturnMainPage);
		panelWarning.add(btnCancel);

		/* ********************* BOOKSHELF PANEL ************************ */
		panelBookshelf = new JPanel();
		panelBookshelf.setLayout(null);
		panelBookshelf.setVisible(false);
		panelBookshelf.setEnabled(false);
		panelBookshelf.setOpaque(false);
		panelBookshelf.setBounds(310, 104, 500, 500);
		contentPane.add(panelBookshelf);

		ColumnButton btnCol0 = new ColumnButton(0);
		btnCol0.setBorder(null);
		btnCol0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCol0.setContentAreaFilled(false);
		btnCol0.setBounds(57, 34, 65, 412);
		btnCol0.addMouseListener(actionMouseOnBookshelf);
		panelBookshelf.add(btnCol0);

		ColumnButton btnCol1 = new ColumnButton(1);
		btnCol1.setBorder(null);
		btnCol1.setContentAreaFilled(false);
		btnCol1.setBounds(137, 34, 65, 412);
		btnCol1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCol1.addMouseListener(actionMouseOnBookshelf);
		panelBookshelf.add(btnCol1);

		ColumnButton btnCol2 = new ColumnButton(2);
		btnCol2.setBorder(null);
		btnCol2.setContentAreaFilled(false);
		btnCol2.setBounds(217, 34, 65, 412);
		btnCol2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCol2.addMouseListener(actionMouseOnBookshelf);
		panelBookshelf.add(btnCol2);

		ColumnButton btnCol3 = new ColumnButton(3);
		btnCol3.setBorder(null);
		btnCol3.setContentAreaFilled(false);
		btnCol3.setBounds(297, 34, 65, 412);
		btnCol3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCol3.addMouseListener(actionMouseOnBookshelf);
		panelBookshelf.add(btnCol3);

		ColumnButton btnCol4 = new ColumnButton(4);
		btnCol4.setBorder(null);
		btnCol4.setContentAreaFilled(false);
		btnCol4.setBounds(378, 34, 65, 412);
		btnCol4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCol4.addMouseListener(actionMouseOnBookshelf);
		panelBookshelf.add(btnCol4);

		JLabel lblBookshelf = new JLabel("");
		lblBookshelf.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblBookshelf.setBounds(0, 5, 500, 500);
		lblBookshelf.setIcon(Icons.BOOKSHELF.load());
		panelBookshelf.add(lblBookshelf);

		printBookshelfObjects();

		/* ********************* GOALS PANEL ************************ */
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

		JLabel lblPickedObjects = new JLabel("Picked Objects");
		lblPickedObjects.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPickedObjects.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPickedObjects.setHorizontalAlignment(SwingConstants.CENTER);
		lblPickedObjects.setForeground(Color.WHITE);
		lblPickedObjects.setFont(new Font("Purisa", Font.BOLD, 16));
		lblPickedObjects.setBounds(954, 345, 167, 46);
		contentPane.add(lblPickedObjects);

		/* ********************* PICKED OBJECTS ************************ */
		panelPickedObjects[PICKED_OBJECT_1_INDEX] = new BackgroundPanel();
		BackgroundPanel panelObject1 = panelPickedObjects[PICKED_OBJECT_1_INDEX];
		panelObject1.setBounds(953, 399, 67, 67);
		panelObject1.setVisible(false);
		panelObject1.setLayout(new BorderLayout(0, 0));
		contentPane.add(panelObject1);

		JLabel lblObject1 = new JLabel("1");
		lblObject1.setFont(new Font("Purisa", Font.BOLD, 60));
		lblObject1.setForeground(new Color(237, 51, 59));
		lblObject1.setHorizontalAlignment(SwingConstants.CENTER);
		lblObject1.setHorizontalTextPosition(SwingConstants.CENTER);
		panelObject1.add(lblObject1);

		panelPickedObjects[PICKED_OBJECT_2_INDEX] = new BackgroundPanel();
		BackgroundPanel panelObject2 = panelPickedObjects[PICKED_OBJECT_2_INDEX];
		panelObject2.setBounds(1050, 399, 67, 67);
		panelObject2.setVisible(false);
		panelObject2.setLayout(new BorderLayout(0, 0));
		contentPane.add(panelObject2);

		JLabel lblObject2 = new JLabel("2");
		lblObject2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblObject2.setHorizontalAlignment(SwingConstants.CENTER);
		lblObject2.setFont(new Font("Purisa", Font.BOLD, 60));
		lblObject2.setForeground(new Color(237, 51, 59));
		panelObject2.add(lblObject2);

		panelPickedObjects[PICKED_OBJECT_3_INDEX] = new BackgroundPanel();
		BackgroundPanel panelObject3 = panelPickedObjects[PICKED_OBJECT_3_INDEX];
		panelObject3.setBounds(1000, 481, 67, 67);
		panelObject3.setVisible(false);
		panelObject3.setLayout(new BorderLayout(0, 0));
		contentPane.add(panelObject3);

		JLabel lblObject3 = new JLabel("3");
		lblObject3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblObject3.setHorizontalAlignment(SwingConstants.CENTER);
		lblObject3.setFont(new Font("Purisa", Font.BOLD, 60));
		lblObject3.setForeground(new Color(237, 51, 59));
		panelObject3.add(lblObject3);

		btnHelp = new JButton("Help");
		btnHelp.setBackground(new Color(255, 255, 255));
		btnHelp.setOpaque(false);
		btnHelp.setFocusPainted(false);
		btnHelp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHelp.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnHelp.setForeground(new Color(255, 255, 255));
		btnHelp.setFont(new Font("Purisa", Font.BOLD, 16));
		btnHelp.setBounds(965, 645, 142, 57);
		btnHelp.addActionListener(actionShowHelpDialog);

		contentPane.add(btnHelp);

		btnEndTurn = new JButton("End Turn");
		btnEndTurn.setEnabled(false);
		btnEndTurn.setVisible(false);
		btnEndTurn.setBackground(new Color(255, 255, 255));
		btnEndTurn.setOpaque(false);
		btnEndTurn.setFocusPainted(false);
		btnEndTurn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEndTurn.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnEndTurn.setForeground(new Color(255, 255, 255));
		btnEndTurn.setFont(new Font("Purisa", Font.BOLD, 16));
		btnEndTurn.setBounds(965, 645, 142, 57);
		btnEndTurn.addActionListener(actionEndTurn);
		contentPane.add(btnEndTurn);

		JButton btnHome = new JButton("<--");
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setOpaque(false);
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Purisa", Font.BOLD, 16));
		btnHome.setFocusPainted(false);
		btnHome.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnHome.setBackground(Color.WHITE);
		btnHome.setBounds(20, 645, 142, 57);
		btnHome.addActionListener(actionShowReturnHomeDialog);
		contentPane.add(btnHome);

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
		btnHideBookshelf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHideBookshelf.setVisible(false);
		btnHideBookshelf.setEnabled(false);
		btnHideBookshelf.setOpaque(false);
		btnHideBookshelf.setForeground(Color.WHITE);
		btnHideBookshelf.setFont(new Font("Purisa", Font.BOLD, 16));
		btnHideBookshelf.setFocusPainted(false);
		btnHideBookshelf.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnHideBookshelf.setBackground(Color.WHITE);
		btnHideBookshelf.setBounds(20, 385, 142, 57);
		btnHideBookshelf.addActionListener(actionHideBookshelf);
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

	/**
	 * 
	 */
	private void printBoardObjects() {

		for (int r = 0; r < Board.ROW_COUNT; r++) {
			for (int c = 0; c < Board.COL_COUNT; c++) {
				Tile tile = board.get(new MatrixCoords(r, c));

				if (tile != null) {
					BookshelfObject object = tile.getBookshelfObject();

					if (object != null) {
						BookshelfObjectButton objectButton = new BookshelfObjectButton(object, new MatrixCoords(r, c));
						objectButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

						// calculate the absolute position of the object from the relative coordinates
						int w = TILE_WIDTH;
						int h = TILE_HEIGHT;
						int x = TILE_ORIGIN_X + c * (w + TILE_OFFSET);
						int y = TILE_ORIGIN_Y - r * (h + TILE_OFFSET);
						objectButton.setBounds(x, y, w, h);
						objectButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								if (pickedObjButtoncoords.size() < MAX_PICKED_OBJECTS) {
									boolean objectPicked = board.isObjectPickable(pickedObjButtoncoords,
											objectButton.getCoords());

									if (objectPicked) {
										pickedObjButtoncoords.add(objectButton.getCoords());
										int objectIndex = pickedObjButtoncoords.size() - 1;
										panelPickedObjects[objectIndex].setBackground(object.getImage());
										panelPickedObjects[objectIndex].setVisible(true);
										panelObjects.remove(objectButton);
										panelObjects.revalidate();
										panelObjects.repaint();
									}
								}
							}
						});

						panelObjects.add(objectButton);
					}
				}
			}
		}
	}

	private void printBookshelfObjects() {
		for (int r = 0; r < Board.ROW_COUNT; r++) {
			for (int c = 0; c < Board.COL_COUNT; c++) {
				BookshelfObject object = bookshelf.get(new MatrixCoords(r, c));

				if (object != null) {
					BackgroundPanel objectPanel = new BackgroundPanel(object.getImage());
					int s = BOOKSHELF_SQUARE_SIZE;
					int x = BOOKSHELF_ORIGIN_X + c * (s + BOOKSHELF_OFFSET_X);
					int y = BOOKSHELF_ORIGIN_Y - r * (s + BOOKSHELF_OFFSET_Y);
					objectPanel.setBounds(x, y, s, s);
					panelBookshelf.add(objectPanel);
					panelBookshelf.revalidate();
					panelBookshelf.repaint();
				}
			}
		}
	}

	private void showBookshelf() {
		panelBookshelf.setVisible(true);
		lblBoard.setIcon(Icons.BOARD_BLURRED.load());
		panelObjects.setVisible(false);
		panelObjects.setEnabled(false);
		btnShowBookshelf.setVisible(false);
		btnShowBookshelf.setEnabled(false);
		btnHideBookshelf.setVisible(true);
		btnHideBookshelf.setEnabled(true);
		btnHelp.setEnabled(false);
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
		btnHelp.setEnabled(true);
	}

	private void showHelpDialog() {
		panelGuide.setVisible(true);
		panelObjects.setVisible(false);
		panelObjects.setEnabled(false);
	}

	private void showColWarning() {
		panelWarning.setVisible(true);
		panelWarning.setEnabled(true);
		lblWarningHeader.setText("Warning");
		lblWarning.setText("Invalid column, please choose another one.");
	}

	private void showEndTurnButton() {
		btnHideBookshelf.setVisible(false);
		btnHideBookshelf.setEnabled(false);
		btnHelp.setVisible(false);
		btnEndTurn.setVisible(true);
		btnEndTurn.setEnabled(true);
	}

	private void hidePickedObjectsPanel() {
		for (BackgroundPanel panel : panelPickedObjects) {
			panel.setVisible(false);
		}
	}

	private void hideWarningPanel() {
		panelWarning.setVisible(false);
		panelWarning.setEnabled(false);

		if (!panelBookshelf.isVisible()) {
			panelObjects.setVisible(true);
			panelObjects.setEnabled(true);
		}
	}

	private void hideGuidePanel() {
		panelGuide.setVisible(false);
		panelGuide.setEnabled(false);
		panelObjects.setVisible(true);
		panelObjects.setEnabled(true);
	}

	private void showReturnHomeDialog() {
		panelWarning.setVisible(true);
		panelWarning.setEnabled(true);
		lblWarningHeader.setText("Warning");
		lblWarning.setText("<html>Are you sure you want to exit to the main menu?<br>All progress will be lost.");
		btnAcknowledge.setVisible(false);
		btnAcknowledge.setEnabled(false);
		btnAccept.setVisible(true);
		btnAccept.setEnabled(true);
		btnCancel.setVisible(true);
		btnCancel.setEnabled(true);
		panelObjects.setVisible(false);
		panelObjects.setEnabled(false);
	}

	private void hideReturnHomeDialog() {
		panelWarning.setVisible(false);
		panelWarning.setEnabled(false);
		btnAcknowledge.setVisible(true);
		btnAcknowledge.setEnabled(true);
		btnAccept.setVisible(false);
		btnAccept.setEnabled(false);
		btnCancel.setVisible(false);
		btnCancel.setEnabled(false);

		if (!panelBookshelf.isVisible()) {
			panelObjects.setVisible(true);
			panelObjects.setEnabled(true);
		}
	}

	/* Private action listeners initialization */

	/**
	 * 
	 * @return
	 */
	private MouseListener initActionMouseOnBookshelf() {
		return new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				ColumnButton button = (ColumnButton) e.getSource();
				button.setBorder(null);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (pickedObjButtoncoords.size() > 0) {
					ColumnButton button = (ColumnButton) e.getSource();
					button.setBorder(new LineBorder(new Color(87, 227, 137), 4));
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<BookshelfObject> obj = new ArrayList<>();

				if (pickedObjButtoncoords.size() > 0) {
					ColumnButton button = (ColumnButton) e.getSource();

					for (MatrixCoords coords : pickedObjButtoncoords) {
						obj.add(board.tryPickObject(coords));
					}

					boolean success = bookshelf.tryAdd(button.getColIndex(), obj);

					if (!success) {
						showColWarning();
					} else {
						pickedObjButtoncoords = new ArrayList<>();
						hidePickedObjectsPanel();
						printBookshelfObjects();
						showEndTurnButton();
					}
				}
			}
		};
	}

	/**
	 * 
	 * @return
	 */
	private ActionListener initActionHideGuidePanel() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hideGuidePanel();
			}
		};
	}

	/**
	 * 
	 * @return
	 */
	private ActionListener initActionHideWarningPanel() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hideWarningPanel();
			}
		};
	}

	/**
	 * 
	 * @return
	 */
	private ActionListener initActionShowReturnHomeDialog() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showReturnHomeDialog();
			}
		};
	}

	/**
	 * 
	 * @return
	 */
	private ActionListener initActionShowHelpDialog() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showHelpDialog();
			}
		};
	}

	/**
	 * 
	 * @return
	 */
	private ActionListener initActionHideReturnMainPage() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hideReturnHomeDialog();
			}
		};
	}

	/**
	 * 
	 * @return
	 */
	private ActionListener initActionShowBookshelf() {
		return actionShowBookshelf = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showBookshelf();
			}
		};
	}

	/**
	 * 
	 * @return
	 */
	private ActionListener initActionHideBookshelf() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hideBookshelf();
			}
		};
	}

}
