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
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
/**
 * ATTENTION!!
 * This Class is used only for ode generation
 */
public class PointsPageViewGraphic_Prototype extends JFrame {

	private static final long serialVersionUID = 9171068620469065779L;
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
		contentPane.setBackground(new Color(24, 22, 22));
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
		btnReturnHome.setBounds(498, 625, 144, 64);
		btnReturnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnReturnHome);

		JPanel panelFirst = new JPanel();
		panelFirst.setOpaque(false);
		panelFirst.setBounds(415, 12, 300, 260);
		contentPane.add(panelFirst);
		panelFirst.setLayout(null);

		JLabel lblFirstImage = new JLabel("");
		lblFirstImage.setIcon(
				new ImageIcon("/home/azanetti6/projects/Group_28/resources/scoring_tokens/resized/first_place.jpg"));
		lblFirstImage.setBounds(new Rectangle(0, 0, 150, 150));
		lblFirstImage.setBounds(75, 11, 150, 150);
		panelFirst.add(lblFirstImage);

		JLabel lblFirst = new JLabel("________________");
		lblFirst.setForeground(new Color(255, 255, 255));
		lblFirst.setFont(new Font("Purisa", Font.BOLD, 16));
		lblFirst.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFirst.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirst.setBounds(25, 182, 250, 24);
		panelFirst.add(lblFirst);

		JLabel lblPointsFirstHeader = new JLabel("Points :");
		lblPointsFirstHeader.setFont(new Font("Purisa", Font.BOLD, 16));
		lblPointsFirstHeader.setForeground(new Color(255, 255, 255));
		lblPointsFirstHeader.setBounds(44, 237, 90, 14);
		panelFirst.add(lblPointsFirstHeader);

		JLabel lblPointsFirst = new JLabel("0");
		lblPointsFirst.setFont(new Font("Purisa", Font.BOLD, 16));
		lblPointsFirst.setForeground(new Color(255, 255, 255));
		lblPointsFirst.setHorizontalAlignment(SwingConstants.CENTER);
		lblPointsFirst.setBounds(170, 237, 59, 14);
		panelFirst.add(lblPointsFirst);

		JPanel panelSecond = new JPanel();
		panelSecond.setOpaque(false);
		panelSecond.setLayout(null);
		panelSecond.setBounds(120, 300, 300, 260);
		contentPane.add(panelSecond);

		JLabel lblSecondImage = new JLabel("");
		lblSecondImage.setBounds(new Rectangle(0, 0, 150, 150));
		lblSecondImage.setBounds(75, 11, 150, 150);
		panelSecond.add(lblSecondImage);

		JLabel lblSecond = new JLabel("________________");
		lblSecond.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSecond.setHorizontalAlignment(SwingConstants.CENTER);
		lblSecond.setBounds(25, 173, 250, 24);
		panelSecond.add(lblSecond);

		JLabel lblPointsSecondHeader = new JLabel("Points :");
		lblPointsSecondHeader.setBounds(75, 237, 59, 14);
		panelSecond.add(lblPointsSecondHeader);

		JLabel lblPointsSecond = new JLabel("0");
		lblPointsSecond.setHorizontalAlignment(SwingConstants.CENTER);
		lblPointsSecond.setBounds(170, 237, 59, 14);
		panelSecond.add(lblPointsSecond);

		JPanel panelThird = new JPanel();
		panelThird.setOpaque(false);
		panelThird.setLayout(null);
		panelThird.setBounds(720, 300, 300, 260);
		contentPane.add(panelThird);

		JLabel lblThirdImage = new JLabel("");
		lblThirdImage.setBounds(new Rectangle(0, 0, 150, 150));
		lblThirdImage.setBounds(75, 11, 150, 150);
		panelThird.add(lblThirdImage);

		JLabel lblThird = new JLabel("________________");
		lblThird.setVerticalAlignment(SwingConstants.BOTTOM);
		lblThird.setHorizontalAlignment(SwingConstants.CENTER);
		lblThird.setBounds(25, 173, 250, 24);
		panelThird.add(lblThird);

		JLabel lblPointsThirdHeader = new JLabel("Points :");
		lblPointsThirdHeader.setBounds(75, 237, 59, 14);
		panelThird.add(lblPointsThirdHeader);

		JLabel lblPointsThird = new JLabel("0");
		lblPointsThird.setHorizontalAlignment(SwingConstants.CENTER);
		lblPointsThird.setBounds(170, 237, 59, 14);
		panelThird.add(lblPointsThird);

	}
}
