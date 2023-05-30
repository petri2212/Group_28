package gui.view.graphic;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import gui.component.BackgroundPanel;
import gui.view.PointsPageView;
import resource.Images;

public class PointsPageViewGraphic extends PointsPageView {
	
	private JFrame mainFrame;
	private JTable table;
	private JScrollPane scrollPane;



	public PointsPageViewGraphic(JFrame mainFrame) {
		this.mainFrame = mainFrame;

	}

	@Override
	public void show() {
		
		Image image = Images.PUBLISHER_MATERIAL_DISPLAY_1_BLURRED.load();
		BackgroundPanel contentPane = new BackgroundPanel(image);
		contentPane.setLayout(null);
				
		scrollPane = new JScrollPane();
		scrollPane.setBounds(308, 109, 556, 563);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Name", playersName.get(0), playersName.get(1)
			}
		));
		table.setBackground(new Color(255, 255, 255));
		table.setSelectionForeground(new Color(255, 255, 255));
		table.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		table.setForeground(new Color(0, 0, 0));
		
		JButton btnReturnHome = new JButton("RETURN HOME");
		btnReturnHome.setOpaque(false);
		btnReturnHome.setBackground(new Color(255, 255, 255));
		btnReturnHome.setFocusPainted(false);
		btnReturnHome.setHorizontalTextPosition(SwingConstants.CENTER);
		btnReturnHome.setFont(new Font("Purisa", Font.BOLD, 16));
		btnReturnHome.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnReturnHome.setForeground(new Color(255, 255, 255));
		btnReturnHome.setIconTextGap(-100);
		btnReturnHome.setBounds(870, 570, 160, 75);
		btnReturnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReturnHome.addActionListener(actionReturnMainPage);
		contentPane.add(btnReturnHome);
		
		mainFrame.setContentPane(contentPane);
		mainFrame.pack();
		mainFrame.revalidate();
		mainFrame.repaint();

	}

}
