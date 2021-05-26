import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTable;

public class Shop extends JPanel {
	private JPanel panel;
	private JScrollPane scrollPane;
	private JPanel panelViewport;
	private int itemcount = 10;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton buttonNewButton;
	private JLabel labelNewLabel;
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public Shop() {
		setBackground(Color.DARK_GRAY);
		initComponents();
		createItemSections();
	}
	private void initComponents() {
		setLayout(null);
		setBounds(30, 213, 865, 725);
		{
			panel = new JPanel();
			panel.setBackground(Color.DARK_GRAY);
			panel.setBounds(10, 11, 215, 701);
			add(panel);
			panel.setLayout(null);
			{
				panel_1 = new JPanel();
				panel_1.setBounds(21, 11, 170, 270);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					labelNewLabel = new JLabel("New label");
					labelNewLabel.setBounds(10, 11, 46, 14);
					panel_1.add(labelNewLabel);
				}
			}
			{
				panel_2 = new JPanel();
				panel_2.setBounds(21, 348, 170, 270);
				panel.add(panel_2);
				panel_2.setLayout(null);
				{
					textArea = new JTextArea();
					textArea.setEditable(false);
					textArea.setBounds(0, 0, 170, 270);
					panel_2.add(textArea);
				}
			}
			{
				buttonNewButton = new JButton("New button");
				buttonNewButton.setBounds(10, 667, 89, 23);
				panel.add(buttonNewButton);
			}
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(228, 11, 621, 701);
			add(scrollPane);
			{
				panelViewport = new JPanel();
				panelViewport.setPreferredSize(new Dimension(621, itemcount * 60));
				panelViewport.setBorder(new LineBorder(new Color(0, 0, 0)));
				scrollPane.setViewportView(panelViewport);
				panelViewport.setLayout(null);
			}
		}
	}
	private void createItemSections() {
		JPanel[] j = new JPanel[itemcount];
		int tabx = 0;
		int taby = 11;
		int count = 0;
			for(int i = 1; i == j.length; i++) {
				if(count<2) {
				j[i].setBounds(10 + tabx, taby, 256, 256);
				tabx = tabx +332;
				count++;
				} else {
				taby = taby + 285;
				tabx = 0;
				count = 0;
				}
		}
		panelViewport.repaint();
	}
}