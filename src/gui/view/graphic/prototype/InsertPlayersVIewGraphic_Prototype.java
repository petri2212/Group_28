package gui.view.graphic.prototype;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
/**
 * ATTENTION!!
 * This Class is used only for ode generation
 */
public class InsertPlayersVIewGraphic_Prototype extends JFrame {

	private static final long serialVersionUID = -3542575343207595674L;
	private JPanel contentPane;
	private JTextField txtPlayerName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertPlayersVIewGraphic_Prototype frame = new InsertPlayersVIewGraphic_Prototype();
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
	public InsertPlayersVIewGraphic_Prototype() {
		setForeground(new Color(192, 191, 188));
		setTitle("My Shelfie");
		setBackground(new Color(0, 0, 0));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("/home/azanetti6/projects/Group_28/resources/publisher_material/Icon 50x50px.png"));
		setMaximumSize(new Dimension(1140, 760));
		setPreferredSize(new Dimension(1140, 760));
		setMinimumSize(new Dimension(1140, 760));
		setResizable(false);
		setSize(new Dimension(1140, 760));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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

		JLabel lblWarningHeader = new JLabel("Warning");
		lblWarningHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarningHeader.setBounds(0, 0, 537, 41);
		panelWarning.add(lblWarningHeader);

		JLabel lblWarning = new JLabel("");
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setBounds(10, 53, 515, 128);
		panelWarning.add(lblWarning);

		JButton btnAcknowledge = new JButton("Ok");
		btnAcknowledge.setBounds(208, 193, 117, 25);
		panelWarning.add(btnAcknowledge);

		JPanel panelPlayer1 = new JPanel();
		panelPlayer1.setOpaque(false);
		panelPlayer1.setBounds(86, 12, 440, 171);
		contentPane.add(panelPlayer1);
		panelPlayer1.setLayout(new BorderLayout(0, 0));

		JLabel lblPlayer1Header = new JLabel("Player 1");
		lblPlayer1Header.setHorizontalAlignment(SwingConstants.CENTER);
		panelPlayer1.add(lblPlayer1Header, BorderLayout.CENTER);
		lblPlayer1Header.setFont(new Font("Purisa", Font.BOLD, 18));
		lblPlayer1Header.setForeground(new Color(255, 255, 255));
		lblPlayer1Header.setIconTextGap(20);
		lblPlayer1Header.setIcon(new ImageIcon("/home/azanetti6/projects/Group_28/resources/icon_tiles/Trofei1.2.png"));

		JLabel lblPlayer1 = new JLabel("___________________");
		panelPlayer1.add(lblPlayer1, BorderLayout.SOUTH);
		lblPlayer1.setFont(new Font("Purisa", Font.BOLD, 18));
		lblPlayer1.setForeground(new Color(255, 255, 255));
		lblPlayer1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer1.setHorizontalTextPosition(SwingConstants.CENTER);

		JPanel panelPlayer2 = new JPanel();
		panelPlayer2.setOpaque(false);
		panelPlayer2.setBounds(594, 12, 440, 171);
		contentPane.add(panelPlayer2);
		panelPlayer2.setLayout(new BorderLayout(0, 0));

		JLabel lblPlayer2Header = new JLabel("Player 2");
		lblPlayer2Header.setIcon(new ImageIcon("/home/azanetti6/projects/Group_28/resources/icon_tiles/Gatti1.1.png"));
		lblPlayer2Header.setIconTextGap(20);
		lblPlayer2Header.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer2Header.setForeground(Color.WHITE);
		lblPlayer2Header.setFont(new Font("Purisa", Font.BOLD, 18));
		panelPlayer2.add(lblPlayer2Header, BorderLayout.CENTER);

		JLabel lblPlayer2 = new JLabel("___________________");
		lblPlayer2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPlayer2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer2.setForeground(Color.WHITE);
		lblPlayer2.setFont(new Font("Purisa", Font.BOLD, 18));
		panelPlayer2.add(lblPlayer2, BorderLayout.SOUTH);

		JPanel panelPlayer3 = new JPanel();
		panelPlayer3.setOpaque(false);
		panelPlayer3.setBounds(86, 247, 440, 171);
		contentPane.add(panelPlayer3);
		panelPlayer3.setLayout(new BorderLayout(0, 0));

		JLabel lblPlayer3Header = new JLabel("Player 3");
		lblPlayer3Header.setIcon(new ImageIcon("/home/azanetti6/projects/Group_28/resources/icon_tiles/Piante1.1.png"));
		lblPlayer3Header.setIconTextGap(20);
		lblPlayer3Header.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer3Header.setForeground(Color.WHITE);
		lblPlayer3Header.setFont(new Font("Purisa", Font.BOLD, 18));
		panelPlayer3.add(lblPlayer3Header, BorderLayout.CENTER);

		JLabel lblPlayer3 = new JLabel("___________________");
		lblPlayer3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPlayer3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer3.setForeground(Color.WHITE);
		lblPlayer3.setFont(new Font("Purisa", Font.BOLD, 18));
		panelPlayer3.add(lblPlayer3, BorderLayout.SOUTH);

		JPanel panelPlayer4 = new JPanel();
		panelPlayer4.setOpaque(false);
		panelPlayer4.setBounds(594, 250, 440, 171);
		contentPane.add(panelPlayer4);
		panelPlayer4.setLayout(new BorderLayout(0, 0));

		JLabel lblPlayer4Header = new JLabel("Player 4");
		lblPlayer4Header.setIcon(new ImageIcon("/home/azanetti6/projects/Group_28/resources/icon_tiles/Giochi1.2.png"));
		lblPlayer4Header.setIconTextGap(20);
		lblPlayer4Header.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer4Header.setForeground(Color.WHITE);
		lblPlayer4Header.setFont(new Font("Purisa", Font.BOLD, 18));
		panelPlayer4.add(lblPlayer4Header, BorderLayout.CENTER);

		JLabel lblPlayer4 = new JLabel("___________________");
		lblPlayer4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPlayer4.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer4.setForeground(Color.WHITE);
		lblPlayer4.setFont(new Font("Purisa", Font.BOLD, 18));
		panelPlayer4.add(lblPlayer4, BorderLayout.SOUTH);

		JLabel lblInsertNewPlayer = new JLabel("Insert New Player");
		lblInsertNewPlayer.setFont(new Font("Purisa", Font.BOLD, 18));
		lblInsertNewPlayer.setForeground(new Color(255, 255, 255));
		lblInsertNewPlayer.setBounds(469, 460, 209, 30);
		contentPane.add(lblInsertNewPlayer);

		JPanel panelInsertPlayer = new JPanel();
		panelInsertPlayer.setOpaque(false);
		panelInsertPlayer.setBorder(new LineBorder(new Color(246, 245, 244), 3, true));
		panelInsertPlayer.setBounds(333, 506, 465, 69);
		contentPane.add(panelInsertPlayer);
		panelInsertPlayer.setLayout(null);

		JLabel lblPlayerName = new JLabel("Player Name:");
		lblPlayerName.setBounds(12, 25, 121, 23);
		lblPlayerName.setFont(new Font("Purisa", Font.BOLD, 16));
		lblPlayerName.setForeground(new Color(255, 255, 255));
		panelInsertPlayer.add(lblPlayerName);

		txtPlayerName = new JTextField();
		txtPlayerName.setCaretColor(new Color(255, 255, 255));
		txtPlayerName.setFont(new Font("Purisa", Font.PLAIN, 14));
		txtPlayerName.setBounds(151, 26, 182, 19);
		panelInsertPlayer.add(txtPlayerName);
		txtPlayerName.setColumns(10);

		JButton btnAddPlayer = new JButton("Add");
		btnAddPlayer.setOpaque(false);
		btnAddPlayer.setBackground(new Color(255, 255, 255));
		btnAddPlayer.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnAddPlayer.setForeground(new Color(255, 255, 255));
		btnAddPlayer.setFont(new Font("Purisa", Font.BOLD, 16));
		btnAddPlayer.setPressedIcon(
				new ImageIcon("/home/azanetti6/projects/Group_28/resources/buttons/btnAddPlayerPressed.png"));
		btnAddPlayer.setBounds(363, 18, 79, 36);
		panelInsertPlayer.add(btnAddPlayer);
		btnAddPlayer.setIconTextGap(0);
		btnAddPlayer.setFocusPainted(false);

		JButton btnHome = new JButton("<--");
		btnHome.setBackground(new Color(255, 255, 255));
		btnHome.setOpaque(false);
		btnHome.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnHome.setFont(new Font("Purisa", Font.BOLD, 16));
		btnHome.setForeground(new Color(255, 255, 255));
		btnHome.setFocusPainted(false);
		btnHome.setHideActionText(true);
		btnHome.setBounds(38, 633, 84, 48);
		contentPane.add(btnHome);

		JButton btnInitGame = new JButton("Start Game");
		btnInitGame.setOpaque(false);
		btnInitGame.setBackground(new Color(255, 255, 255));
		btnInitGame.setFocusPainted(false);
		btnInitGame.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInitGame.setFont(new Font("Purisa", Font.BOLD, 16));
		btnInitGame.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnInitGame.setForeground(new Color(255, 255, 255));
		btnInitGame.setIconTextGap(-100);
		btnInitGame.setBounds(510, 625, 144, 64);
		contentPane.add(btnInitGame);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon("/home/azanetti6/projects/Group_28/resources/publisher_material/Display_1_Blurred.jpg"));
		lblNewLabel.setBounds(0, 0, 1140, 737);
		contentPane.add(lblNewLabel);
	}
}
