package gui.view.graphic.prototype;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class InsertPlayersVIewGraphic_Prototype extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlayer;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("/home/azanetti6/projects/Group_28/resources/publisher_material/Icon 50x50px.png"));
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
		
		JPanel panelInsertPlayer = new JPanel();
		panelInsertPlayer.setOpaque(false);
		panelInsertPlayer.setBorder(new LineBorder(new Color(246, 245, 244), 3, true));
		FlowLayout flowLayout = (FlowLayout) panelInsertPlayer.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		panelInsertPlayer.setBounds(328, 550, 435, 53);
		contentPane.add(panelInsertPlayer);
		
		JLabel lblPlayerName = new JLabel("Player Name:");
		lblPlayerName.setForeground(new Color(255, 255, 255));
		panelInsertPlayer.add(lblPlayerName);
		
		txtPlayer = new JTextField();
		panelInsertPlayer.add(txtPlayer);
		txtPlayer.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		panelInsertPlayer.add(btnNewButton);
		
		JPanel panelPlayersList = new JPanel();
		panelPlayersList.setOpaque(false);
		panelPlayersList.setBorder(new LineBorder(new Color(222, 221, 218), 3, true));
		panelPlayersList.setBounds(27, 40, 357, 299);
		contentPane.add(panelPlayersList);
		panelPlayersList.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelBorder = new JPanel();
		panelBorder.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelBorder.setOpaque(false);
		panelPlayersList.add(panelBorder);
		panelBorder.setLayout(new BorderLayout(0, 20));
		
		JLabel lblPlayers = new JLabel("Players:");
		panelBorder.add(lblPlayers, BorderLayout.NORTH);
		lblPlayers.setForeground(new Color(255, 255, 255));
		lblPlayers.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayers.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JPanel panelPlayers = new JPanel();
		panelBorder.add(panelPlayers);
		panelPlayers.setOpaque(false);
		panelPlayers.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblPlayer1 = new JLabel("...");
		lblPlayer1.setForeground(new Color(255, 255, 255));
		lblPlayer1.setIconTextGap(20);
		lblPlayer1.setIcon(new ImageIcon("/home/azanetti6/projects/Group_28/resources/icon_tiles/Trofei1.2.png"));
		panelPlayers.add(lblPlayer1);
		
		JLabel lblPlayer2 = new JLabel("...");
		lblPlayer2.setForeground(new Color(255, 255, 255));
		lblPlayer2.setIconTextGap(20);
		lblPlayer2.setIcon(new ImageIcon("/home/azanetti6/projects/Group_28/resources/icon_tiles/Gatti1.1.png"));
		panelPlayers.add(lblPlayer2);
		
		JLabel lblPlayer3 = new JLabel("...");
		lblPlayer3.setForeground(new Color(255, 255, 255));
		lblPlayer3.setIconTextGap(20);
		lblPlayer3.setIcon(new ImageIcon("/home/azanetti6/projects/Group_28/resources/icon_tiles/Piante1.1.png"));
		panelPlayers.add(lblPlayer3);
		
		JLabel lblPlayer4 = new JLabel("...");
		lblPlayer4.setForeground(new Color(255, 255, 255));
		lblPlayer4.setIconTextGap(20);
		lblPlayer4.setIcon(new ImageIcon("/home/azanetti6/projects/Group_28/resources/icon_tiles/Giochi1.2.png"));
		panelPlayers.add(lblPlayer4);
	}

}
