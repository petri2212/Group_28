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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;

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
		panelWarning.setVisible(false);
		panelWarning.setBounds(288, 285, 537, 246);
		contentPane.add(panelWarning);
		panelWarning.setLayout(null);

		JLabel lblWarningHeader = new JLabel("");
		lblWarningHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarningHeader.setBounds(0, 0, 537, 41);
		panelWarning.add(lblWarningHeader);

		JLabel lblWarning = new JLabel("");
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setBounds(10, 53, 515, 128);
		panelWarning.add(lblWarning);

		JButton btnAcknowledge = new JButton("Ok");
		btnAcknowledge.setBounds(208, 193, 117, 25);
		btnAcknowledge.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelWarning.setVisible(false);
			}
		});
		panelWarning.add(btnAcknowledge);

		JPanel panelBookshelf = new JPanel();
		panelBookshelf.setVisible(false);
		panelBookshelf.setBounds(310, 104, 500, 500);
		contentPane.add(panelBookshelf);

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
