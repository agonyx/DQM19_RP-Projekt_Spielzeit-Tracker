package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import sqlverbindung.DAOItems;
import sqlverbindung.DB_FehlerException;
import sqlverbindung.Gesichter;
import sqlverbindung.Gesichtsbedeckung;
import sqlverbindung.Kopfbedeckung;
import sqlverbindung.Oberteil;
import sqlverbindung.Rahmen;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;

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
	private Gesichter[] gesichter;
	private Gesichtsbedeckung[] gesichtsbedeckung;
	private Kopfbedeckung[] kopfbedeckung;
	private Oberteil[] oberteil;
	private Rahmen[] rahmen;
	private DAOItems ditems;

	
	public Shop() {
		setBackground(Color.DARK_GRAY);
		initComponents();
		initItems();
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
					labelNewLabel = new JLabel("AVATAR");
					labelNewLabel.setBounds(10, 11, 80, 14);
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
			}
		}
		
	}
	private void initItems() {
		try {
			gesichter = ditems.getAllGesichter();
			gesichtsbedeckung = ditems.getAllGesichtsbedeckung();
			kopfbedeckung = ditems.getAllKopfbedeckung();
			oberteil = ditems.getAllOberteil();
			rahmen = ditems.getAllRahmen();
			itemcount = gesichter.length + gesichtsbedeckung.length + kopfbedeckung.length + oberteil.length + rahmen.length;
		} catch (DB_FehlerException e) {
			e.printStackTrace();
		}
	}
	//Bereiche für alle Items werden generiert und Bilder werden abgerufen

	private void createItemSections() {
		JPanel[] j = new JPanel[itemcount];
		JLabel[] l = new JLabel[itemcount];
		int tabx = 0;
		int taby = 11;
		int count = 0;
		int delay;
		
			for(int i = 0; i < j.length; i++) {
				if(count<2) {
				count++;
				j[i] = new JPanel();
				j[i].setBounds(10 + tabx, taby, 256, 256);
				j[i].setBorder(new EtchedBorder());
				l[i] = new JLabel();
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
				j[i].add(l[i]);
				j[i].setVisible(true);
				tabx = tabx +332;
				panelViewport.add(j[i]);
				}
		}
			
			for(int i = 0; i < gesichter.length; i++) {
				String gesichterPath;
				if(i<10) {
					gesichterPath = "resources/GESICHT_00"+i;
				} else if(i<100) {
					gesichterPath = "resources/GESICHT_0"+i;
				} else if (i>100) {
					gesichterPath = "resources/GESICHT"+i;
				}
				
				ImageIcon icon = new ImageIcon(gesichterPath);
				l[i].setIcon(icon);
			}
			delay = gesichter.length;
			for(int i = 0; i < gesichtsbedeckung.length; i++) {
				l[i+delay]
			}
			delay = delay + gesichtsbedeckung.length;
			for(int i = 0; i < kopfbedeckung.length; i++) {
				l[i+delay]
			}
			delay = delay + kopfbedeckung.length;
			for(int i = 0; i < oberteil.length; i++) {
				l[i+delay]
			}
			delay = delay + oberteil.length;
			for(int i = 0; i < rahmen.length; i++) {
				l[i+delay]
			}
		panelViewport.setPreferredSize(new Dimension(621, taby+285));
		panelViewport.revalidate();
		panelViewport.repaint();
	}
}