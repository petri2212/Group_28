package gui.view.graphic.prototype;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import javax.swing.border.LineBorder;

public class PickObjectsFromBoardViewGraphic_Prototype extends JFrame {

	private static final long serialVersionUID = -444958510016942089L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PickObjectsFromBoardViewGraphic_Prototype frame = new PickObjectsFromBoardViewGraphic_Prototype();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PickObjectsFromBoardViewGraphic_Prototype() {
		setBackground(new Color(36, 31, 49));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1130, 760);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelWarning = new JPanel();
		panelWarning.setVisible(true);
		panelWarning.setEnabled(true);
		panelWarning.setBounds(288, 285, 537, 246);
		contentPane.add(panelWarning);
		panelWarning.setLayout(null);

		JLabel lblWarningHeader = new JLabel("Warning");
		lblWarningHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarningHeader.setBounds(0, 0, 537, 41);
		panelWarning.add(lblWarningHeader);

		JLabel lblWarning = new JLabel("Warning message.");
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setBounds(10, 53, 515, 128);
		panelWarning.add(lblWarning);

		JButton btnAcknowledge = new JButton("Ok");
		btnAcknowledge.setBounds(208, 193, 117, 25);
		panelWarning.add(btnAcknowledge);

		JButton btnAccept = new JButton("Ok");
		btnAccept.setVisible(false);
		btnAccept.setBounds(300, 193, 117, 25);
		panelWarning.add(btnAccept);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setVisible(false);
		btnCancel.setBounds(100, 193, 117, 25);
		panelWarning.add(btnCancel);

		JPanel panelBookshelf = new JPanel();
		panelBookshelf.setOpaque(false);
		panelBookshelf.setBounds(310, 104, 500, 500);
		contentPane.add(panelBookshelf);
		panelBookshelf.setLayout(null);

		JButton btnCol0 = new JButton("");
		btnCol0.setBorder(null);
		btnCol0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCol0.setContentAreaFilled(false);
		btnCol0.setBounds(70, 34, 65, 412);
		btnCol0.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCol0.setBorder(null);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnCol0.setBorder(new LineBorder(new Color(87, 227, 137), 4));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panelBookshelf.add(btnCol0);

		JButton btnCol1 = new JButton("");
		btnCol1.setBorder(null);
		btnCol1.setContentAreaFilled(false);
		btnCol1.setBounds(137, 34, 65, 412);
		btnCol0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelBookshelf.add(btnCol1);

		JButton btnCol2 = new JButton("");
		btnCol2.setBorder(null);
		btnCol2.setContentAreaFilled(false);
		btnCol2.setBounds(217, 34, 65, 412);
		btnCol0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelBookshelf.add(btnCol2);

		JButton btnCol3 = new JButton("");
		btnCol3.setBorder(null);
		btnCol3.setContentAreaFilled(false);
		btnCol3.setBounds(297, 34, 65, 412);
		btnCol0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelBookshelf.add(btnCol3);

		JButton btnCol4 = new JButton("");
		btnCol4.setBorder(null);
		btnCol4.setContentAreaFilled(false);
		btnCol4.setBounds(378, 34, 65, 412);
		btnCol0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelBookshelf.add(btnCol4);

		JLabel lblBookshelf = new JLabel("");
		lblBookshelf.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblBookshelf.setBounds(0, 5, 500, 500);
		lblBookshelf
				.setIcon(new ImageIcon("/home/azanetti6/projects/Group_28/resources/boards/bookshelf_orth_edited.png"));
		panelBookshelf.add(lblBookshelf);

		JPanel panelPersonalGoal = new JPanel();
		panelPersonalGoal.setBounds(10, 113, 165, 250);
		contentPane.add(panelPersonalGoal);

		JPanel panelCommonGoal1 = new JPanel();
		panelCommonGoal1.setBounds(954, 62, 167, 109);
		contentPane.add(panelCommonGoal1);

		JPanel panelCommonGoal2 = new JPanel();
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

		JLabel lblPlayerTurn = new JLabel("New label");
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

		JPanel panelObject1 = new JPanel();
		panelObject1.setBounds(953, 399, 67, 67);
		contentPane.add(panelObject1);
		panelObject1.setLayout(null);

		JLabel lblObject1 = new JLabel("1");
		lblObject1.setBounds(0, 0, 67, 67);
		lblObject1.setFont(new Font("Purisa", Font.BOLD, 60));
		lblObject1.setForeground(new Color(237, 51, 59));
		lblObject1.setHorizontalAlignment(SwingConstants.CENTER);
		lblObject1.setHorizontalTextPosition(SwingConstants.CENTER);
		panelObject1.add(lblObject1);

		JLabel lblIconTest = new JLabel("");
		lblIconTest.setBounds(0, 0, 67, 67);
		lblIconTest
				.setIcon(new ImageIcon("/home/azanetti6/projects/Group_28/resources/item_tiles/resized/Giochi1.2.png"));
		panelObject1.add(lblIconTest);

		JPanel panelObject2 = new JPanel();
		panelObject2.setBounds(1050, 399, 67, 67);
		contentPane.add(panelObject2);
		panelObject2.setLayout(new BorderLayout(0, 0));

		JLabel lblObject2 = new JLabel("2");
		lblObject2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblObject2.setHorizontalAlignment(SwingConstants.CENTER);
		lblObject2.setForeground(Color.WHITE);
		lblObject2.setFont(new Font("Purisa", Font.BOLD, 20));
		panelObject2.add(lblObject2);

		JPanel panelObject3 = new JPanel();
		panelObject3.setBounds(1000, 481, 67, 67);
		contentPane.add(panelObject3);
		panelObject3.setLayout(new BorderLayout(0, 0));

		JLabel lblObject3 = new JLabel("3");
		lblObject3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblObject3.setHorizontalAlignment(SwingConstants.CENTER);
		lblObject3.setForeground(Color.WHITE);
		lblObject3.setFont(new Font("Purisa", Font.BOLD, 20));
		panelObject3.add(lblObject3);

		JButton btnEndTurn = new JButton("End Turn");
		btnEndTurn.setEnabled(false);
		btnEndTurn.setBackground(new Color(255, 255, 255));
		btnEndTurn.setOpaque(false);
		btnEndTurn.setFocusPainted(false);
		btnEndTurn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEndTurn.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnEndTurn.setForeground(new Color(255, 255, 255));
		btnEndTurn.setFont(new Font("Purisa", Font.BOLD, 16));
		btnEndTurn.setBounds(965, 645, 142, 57);
		contentPane.add(btnEndTurn);

		JButton btnShowBookshelf = new JButton("Show Shelf");
		btnShowBookshelf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnShowBookshelf.setOpaque(false);
		btnShowBookshelf.setForeground(Color.WHITE);
		btnShowBookshelf.setFont(new Font("Purisa", Font.BOLD, 16));
		btnShowBookshelf.setFocusPainted(false);
		btnShowBookshelf.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnShowBookshelf.setBackground(Color.WHITE);
		btnShowBookshelf.setBounds(20, 385, 142, 57);
		contentPane.add(btnShowBookshelf);

		JButton btnHideBookshelf = new JButton("Hide Shelf");
		btnHideBookshelf.setVisible(false);
		btnHideBookshelf.setOpaque(false);
		btnHideBookshelf.setForeground(Color.WHITE);
		btnHideBookshelf.setFont(new Font("Purisa", Font.BOLD, 16));
		btnHideBookshelf.setFocusPainted(false);
		btnHideBookshelf.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnHideBookshelf.setBackground(Color.WHITE);
		btnHideBookshelf.setBounds(20, 385, 142, 57);
		contentPane.add(btnHideBookshelf);

		JButton btnHome = new JButton("<--");
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setOpaque(false);
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Purisa", Font.BOLD, 16));
		btnHome.setFocusPainted(false);
		btnHome.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnHome.setBackground(Color.WHITE);
		btnHome.setBounds(20, 645, 142, 57);
		contentPane.add(btnHome);

		JPanel panelBoard = new JPanel();
		panelBoard.setOpaque(false);
		panelBoard.setBounds(0, 0, 1130, 745);
		contentPane.add(panelBoard);
		panelBoard.setLayout(new BorderLayout(0, 0));

		JLabel lblBoard = new JLabel("");
		lblBoard.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoard.setIcon(new ImageIcon("/home/azanetti6/projects/Group_28/resources/boards/livingroom_reduced.png"));
		panelBoard.add(lblBoard, BorderLayout.CENTER);
	}
}
