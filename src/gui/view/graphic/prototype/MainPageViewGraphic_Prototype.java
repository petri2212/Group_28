package gui.view.graphic.prototype;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.Canvas;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Frame;
import javax.swing.JLabel;
import java.awt.Cursor;

public class MainPageViewGraphic_Prototype extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPageViewGraphic_Prototype frame = new MainPageViewGraphic_Prototype();
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
	public MainPageViewGraphic_Prototype() {
		setMaximumSize(new Dimension(1140, 760));
		setMinimumSize(new Dimension(1140, 760));
		setPreferredSize(new Dimension(1140, 760));
		setSize(new Dimension(1140, 760));
		setIconImage(Toolkit.getDefaultToolkit().getImage("/home/azanetti6/projects/Group_28/resources/publisher_material/Icon 50x50px.png"));
		setTitle("MY SHELFIE");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 338);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setForeground(new Color(255, 255, 255));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
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
		btnNewGame.setSelectedIcon(new ImageIcon("/home/azanetti6/projects/Group_28/resources/buttons/btnNewGamePressed.png"));
		btnNewGame.setPressedIcon(new ImageIcon("/home/azanetti6/projects/Group_28/resources/buttons/btnNewGamePressed.png"));
		btnNewGame.setMargin(new Insets(0, 0, 0, 0));
		btnNewGame.setBorderPainted(false);
		btnNewGame.setContentAreaFilled(false);
		btnNewGame.setHideActionText(true);
		btnNewGame.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewGame.setIcon(new ImageIcon("/home/azanetti6/projects/Group_28/resources/buttons/btnNewGame.png"));
		btnNewGame.setBackground(new Color(255, 255, 255));
		btnNewGame.setForeground(new Color(255, 255, 255));
		
		JPanel panelExit = new JPanel();
		panelExit.setOpaque(false);
		panelMain.add(panelExit);
		
		JButton btnExit = new JButton("");
		panelExit.add(btnExit);
		btnExit.setMinimumSize(new Dimension(174, 62));
		btnExit.setMaximumSize(new Dimension(174, 62));
		btnExit.setPreferredSize(new Dimension(174, 62));
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.setPressedIcon(new ImageIcon("/home/azanetti6/projects/Group_28/resources/buttons/btnExitPressed.png"));
		btnExit.setSelectedIcon(new ImageIcon("/home/azanetti6/projects/Group_28/resources/buttons/btnExitPressed.png"));
		btnExit.setIcon(new ImageIcon("/home/azanetti6/projects/Group_28/resources/buttons/btnExit.png"));
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
	}
}
