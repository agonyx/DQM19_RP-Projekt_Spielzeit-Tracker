
package gui;


import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;




public class Shop extends JPanel {
	private JPanel panel;
	private JScrollPane scrollPane;
	private JPanel panelViewport;
	private int itemcount = 6;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton buyButton;
	private JLabel labelNewLabel;
	private JTextArea textArea;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JButton buttonNewButton;

	/**
	 * Create the panel.
	 */
	public Shop() {
		setBackground(Color.DARK_GRAY);
		initComponents();
		createItemSections();
	}

	private JLabel lblNewLabel;
	
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
					labelNewLabel.setBounds(10, 245, 46, 14);
					labelNewLabel = new JLabel("AVATAR");
					labelNewLabel.setBounds(10, 11, 80, 14);
					panel_1.add(labelNewLabel);
				}
			}
			{
				panel_2 = new JPanel();
				panel_2.setBounds(10, 348, 195, 270);
				panel_2.setBounds(21, 348, 170, 270);
				panel.add(panel_2);
				panel_2.setLayout(null);
				{
					textArea = new JTextArea();
					textArea.setEditable(false);
					textArea.setBounds(0, 0, 195, 270);
					textArea.setBounds(0, 0, 174, 270);
					textArea.setBounds(0, 0, 170, 270);
					panel_2.add(textArea);
				}
			}
			{
				buttonNewButton = new JButton("New button");
				buttonNewButton.setBounds(10, 667, 89, 23);
				buttonNewButton.setBounds(21, 667, 89, 23);
				panel.add(buttonNewButton);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane = new JScrollPane();
			scrollPane.setBounds(228, 11, 621, 701);
			add(scrollPane);
			{
				JPanel panelViewport = new JPanel();
				panelViewport.setPreferredSize(new Dimension(621, itemcount * 60));
				buyButton = new JButton("Buy");
				buyButton.setBounds(10, 667, 89, 23);
				panel.add(buyButton);
			}
		}
		{
			scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(228, 11, 621, 701);
			add(scrollPane);
			{
				panelViewport = new JPanel();
				panelViewport.setPreferredSize(new Dimension(621, 701));
				panelViewport.setBorder(new LineBorder(new Color(0, 0, 0)));
				scrollPane.setViewportView(panelViewport);
				panelViewport.setLayout(null);
				{
					panel_3 = new JPanel();
					panel_3.setBounds(10, 11, 256, 256);
					panelViewport.add(panel_3);
				}
				{
					panel_4 = new JPanel();
					panel_4.setBounds(342, 11, 256, 256);
					panelViewport.add(panel_4);
				}
				{
					panel_5 = new JPanel();
					panel_5.setBounds(10, 296, 256, 256);
					panelViewport.add(panel_5);
				}
			}
		}
	}
	private void createItemSections() {
		JPanel[] j = new JPanel[itemcount];
		JLabel[] l = new JLabel[itemcount];
		int tabx = 0;
		int taby = 11;
		int count = 0;
			for(int i = 0; i < j.length; i++) {
				if(count<2) {
				j[i].setBounds(10 + tabx, 11, 256, 256);
				tabx = tabx +332;
				} else {
					j[i].setBounds(10 + tabx, 11+taby, 207, 215);
					tabx = tabx +332;
					taby = taby +285;
					count = 0;
				}
		}
		panelViewport.repaint();
	}
	{
		JPanel[] j = new JPanel[itemcount];
		JLabel[] l = new JLabel[itemcount];
		int tabx = 0;
		int taby = 11;
		int count = 0;
			for(int i = 1; i == j.length; i++) {
				if(count<2) {
				count++;
				j[i] = new JPanel();
				j[i].setBounds(10 + tabx, taby, 256, 256);
				j[i].setBorder(new EtchedBorder());
				l[i] = new JLabel();
				l[i].setText("test" + (i+1));
				j[i].add(l[i]);
				j[i].setVisible(true);
				tabx = tabx +332;
				panelViewport.add(j[i]);
				} else {
				taby = taby + 285;
				tabx = 0;
				count = 0;
				count++;
				j[i] = new JPanel();
				j[i].setBounds(10 + tabx, taby, 256, 256);
				j[i].setBorder(new EtchedBorder());;
				l[i] = new JLabel();
				l[i].setText("test" + i);
				j[i].add(l[i]);
				j[i].setVisible(true);
				tabx = tabx +332;
				panelViewport.add(j[i]);
				}
		}
		panelViewport.setPreferredSize(new Dimension(621, taby+285));
		panelViewport.revalidate();
		panelViewport.repaint();
	}
		
		{
			panel_1 = new JPanel();
			panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			panel_1.setBounds(10, 166, 92, 84);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			{
				lblNewLabel = new JLabel("New label");
				lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
				lblNewLabel.setBounds(0, 0, 92, 84);
				panel_1.add(lblNewLabel);
			}
		}
	
 }
