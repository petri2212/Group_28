package gui.view.graphic.prototype;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
/**
 * ATTENTION!!
 * This Class is used only for ode generation
 */
public class MainPageViewGraphic_Prototype extends JFrame {

	private static final long serialVersionUID = 1567108229753700100L;
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
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("/home/azanetti6/projects/Group_28/resources/publisher_material/Icon 50x50px.png"));
		setTitle("MY SHELFIE");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 338);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setForeground(new Color(255, 255, 255));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setOpaque(false);
		btnNewGame.setFocusPainted(false);
		btnNewGame.setFont(new Font("Purisa", Font.BOLD, 18));
		btnNewGame.setBounds(37, 232, 185, 62);
		contentPane.add(btnNewGame);
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
		contentPane.add(btnExit);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon("/media/sf_Unibg_Shared/resources/publisher_material/Display_1_Main_Page_4.png"));
		lblNewLabel.setBounds(0, 0, 1140, 737);
		contentPane.add(lblNewLabel);
	}
}
