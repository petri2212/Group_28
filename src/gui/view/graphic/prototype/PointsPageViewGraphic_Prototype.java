package gui.view.graphic.prototype;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class PointsPageViewGraphic_Prototype extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PointsPageViewGraphic_Prototype frame = new PointsPageViewGraphic_Prototype();
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
	public PointsPageViewGraphic_Prototype() {
		setPreferredSize(new Dimension(1140, 760));
		setMinimumSize(new Dimension(1140, 760));
		setMaximumSize(new Dimension(1140, 760));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
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
		btnReturnHome.setBounds(490, 625, 144, 64);
		btnReturnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnReturnHome);
		
		JPanel panelSecond = new JPanel();
		panelSecond.setBounds(87, 319, 250, 300);
		contentPane.add(panelSecond);
		panelSecond.setLayout(null);
		
		JLabel lblSecondImage = new JLabel("");
		lblSecondImage.setIcon(new ImageIcon("C:\\Users\\yumst\\OneDrive\\Desktop\\UNIVERSITA'\\scoring.jpg"));
		lblSecondImage.setBounds(new Rectangle(45, 11, 150, 150));
		panelSecond.add(lblSecondImage);
		
		JLabel lblSecond = new JLabel("New label");
		lblSecond.setBounds(114, 186, 46, 14);
		panelSecond.add(lblSecond);
		
		JLabel lblPoints_2 = new JLabel("Points :");
		lblPoints_2.setBounds(45, 205, 46, 14);
		panelSecond.add(lblPoints_2);
		
		JLabel lblPointsSecond = new JLabel("");
		lblPointsSecond.setBounds(124, 211, 46, 14);
		panelSecond.add(lblPointsSecond);
		
		JPanel panelFirst = new JPanel();
		panelFirst.setBounds(477, 117, 250, 300);
		contentPane.add(panelFirst);
		panelFirst.setLayout(null);
		
		JLabel lblFirstImage = new JLabel("");
		lblFirstImage.setIcon(new ImageIcon("C:\\Users\\yumst\\OneDrive\\Desktop\\UNIVERSITA'\\scoring.jpg"));
		lblFirstImage.setBounds(new Rectangle(0, 0, 150, 150));
		lblFirstImage.setBounds(37, 11, 150, 150);
		panelFirst.add(lblFirstImage);
		
		JLabel lblFirst = new JLabel("New label");
		lblFirst.setBounds(91, 172, 250, 14);
		panelFirst.add(lblFirst);
		
		JLabel lblPoints_1 = new JLabel("Points :");
		lblPoints_1.setBounds(37, 218, 46, 14);
		panelFirst.add(lblPoints_1);
		
		JLabel lblPointsFirst = new JLabel("");
		lblPointsFirst.setBounds(141, 207, 46, 14);
		panelFirst.add(lblPointsFirst);
		
		JPanel panelThird = new JPanel();
		panelThird.setBounds(846, 337, 212, 324);
		contentPane.add(panelThird);
		panelThird.setLayout(null);
		
		JLabel lblThirdImage = new JLabel("");
		lblThirdImage.setIcon(new ImageIcon("C:\\Users\\yumst\\OneDrive\\Desktop\\UNIVERSITA'\\scoring.jpg"));
		lblThirdImage.setBounds(new Rectangle(0, 0, 150, 150));
		lblThirdImage.setBounds(10, 88, 150, 150);
		panelThird.add(lblThirdImage);
		
		JLabel lblThird = new JLabel("New label");
		lblThird.setBounds(108, 5, 46, 14);
		panelThird.add(lblThird);
		
		JLabel lblPoints_3 = new JLabel("Points :");
		lblPoints_3.setBounds(37, 265, 46, 14);
		panelThird.add(lblPoints_3);
		
		JLabel lblPointsThird = new JLabel("");
		lblPointsThird.setBounds(108, 265, 46, 14);
		panelThird.add(lblPointsThird);
		
		
	}
}
