package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class Statistiken extends JPanel {
	private JLabel labelNewLabel;
	private JLabel labelMeistegespieltesSpiel;
	private JLabel labelSpiel;
	private JLabel labelSpielstunden;
	private JLabel labelSpielzeittrackerRang;
	private JLabel labelNewLabel_1;
	private JLabel labelCSGOStunden;
	private JLabel labelNewLabel_3;
	private JLabel labelCSGORang;
	private JLabel labelNewLabel_2;
	private JLabel labelTotalHours;
	private JLabel labelMostHours;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JLabel labelNewLabel_4;
	private JLabel labelCSGOStunden_1;
	private JLabel labelNewLabel_5;
	private JLabel labelNewLabel_6;
	private JLabel labelCSGORang_1;
	private JSeparator separator_4;
	private JSeparator separator_5;
	private JLabel labelNewLabel_7;
	private JLabel labelCSGOStunden_2;
	private JLabel labelNewLabel_8;
	private JLabel labelNewLabel_9;
	private JLabel labelCSGORang_2;
	private JSeparator separator_6;
	private JSeparator separator_7;
	private JLabel labelNewLabel_10;
	private JLabel labelCSGOStunden_3;
	private JLabel labelNewLabel_11;
	private JLabel labelNewLabel_12;
	private JLabel labelCSGORang_3;
	private JSeparator separator_8;
	private JSeparator separator_9;
	private JLabel labelNewLabel_13;
	private JLabel labelCSGOStunden_4;
	private JLabel labelNewLabel_14;
	private JLabel labelNewLabel_15;
	private JLabel labelCSGORang_4;
	private JSeparator separator_10;
	private JSeparator separator_11;
	private JLabel labelNewLabel_16;
	private JLabel labelCSGOStunden_5;
	private JLabel labelNewLabel_17;
	private JLabel labelNewLabel_18;
	private JLabel labelCSGORang_5;
	private JSeparator separator_13;
	private JLabel labelNewLabel_19;
	private JLabel labelCSGOStunden_6;
	private JLabel labelNewLabel_20;
	private JLabel labelNewLabel_21;
	private JLabel labelCSGORang_6;
	private JSeparator separator_14;

	/**
	 * Create the panel.
	 */
	public Statistiken() {

		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		JScrollPane scrollPane = new JScrollPane (this, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		{
			labelNewLabel = new JLabel("Gesamtspielzeit");
			labelNewLabel.setBounds(68, 71, 266, 14);
			add(labelNewLabel);
		}
		{
			labelMeistegespieltesSpiel = new JLabel("Meiste Spielstunden");
			labelMeistegespieltesSpiel.setBounds(68, 114, 266, 14);
			add(labelMeistegespieltesSpiel);
		}
		{
			labelSpiel = new JLabel("Spiel");
			labelSpiel.setBounds(43, 245, 135, 14);
			add(labelSpiel);
		}
		{
			labelSpielstunden = new JLabel("Spielstunden");
			labelSpielstunden.setBounds(188, 245, 135, 14);
			add(labelSpielstunden);
		}
		{
			labelSpielzeittrackerRang = new JLabel("Spielzeit-Tracker Rang");
			labelSpielzeittrackerRang.setBounds(333, 245, 135, 14);
			add(labelSpielzeittrackerRang);
		}
		{
			labelNewLabel_1 = new JLabel("CS:GO");
			labelNewLabel_1.setBounds(43, 300, 46, 14);
			add(labelNewLabel_1);
		}
		{
			labelCSGOStunden = new JLabel("New label");
			labelCSGOStunden.setBounds(188, 300, 46, 14);
			add(labelCSGOStunden);
		}
		{
			labelNewLabel_3 = new JLabel("h");
			labelNewLabel_3.setBounds(244, 300, 25, 14);
			add(labelNewLabel_3);
		}
		{
			labelCSGORang = new JLabel("New label");
			labelCSGORang.setBounds(347, 300, 46, 14);
			add(labelCSGORang);
		}
		{
			labelNewLabel_2 = new JLabel("#");
			labelNewLabel_2.setBounds(333, 300, 25, 14);
			add(labelNewLabel_2);
		}
		{
			labelTotalHours = new JLabel("New label");
			labelTotalHours.setBounds(344, 71, 46, 14);
			add(labelTotalHours);
		}
		{
			labelMostHours = new JLabel("h");
			labelMostHours.setBounds(344, 114, 46, 14);
			add(labelMostHours);
		}
		{
			separator = new JSeparator();
			separator.setBounds(10, 233, 828, 2);
			add(separator);
		}
		{
			separator_1 = new JSeparator();
			separator_1.setBounds(10, 270, 828, 2);
			add(separator_1);
		}
		{
			separator_2 = new JSeparator();
			separator_2.setBounds(10, 333, 828, 2);
			add(separator_2);
		}
		{
			separator_3 = new JSeparator();
			separator_3.setBounds(10, 396, 828, 2);
			add(separator_3);
		}
		{
			labelNewLabel_4 = new JLabel("CS:GO");
			labelNewLabel_4.setBounds(43, 363, 46, 14);
			add(labelNewLabel_4);
		}
		{
			labelCSGOStunden_1 = new JLabel("New label");
			labelCSGOStunden_1.setBounds(188, 363, 46, 14);
			add(labelCSGOStunden_1);
		}
		{
			labelNewLabel_5 = new JLabel("h");
			labelNewLabel_5.setBounds(244, 363, 25, 14);
			add(labelNewLabel_5);
		}
		{
			labelNewLabel_6 = new JLabel("#");
			labelNewLabel_6.setBounds(333, 363, 25, 14);
			add(labelNewLabel_6);
		}
		{
			labelCSGORang_1 = new JLabel("New label");
			labelCSGORang_1.setBounds(347, 363, 46, 14);
			add(labelCSGORang_1);
		}
		{
			separator_4 = new JSeparator();
			separator_4.setBounds(10, 333, 828, 2);
			add(separator_4);
		}
		{
			separator_5 = new JSeparator();
			separator_5.setBounds(10, 459, 828, 2);
			add(separator_5);
		}
		{
			labelNewLabel_7 = new JLabel("CS:GO");
			labelNewLabel_7.setBounds(43, 426, 46, 14);
			add(labelNewLabel_7);
		}
		{
			labelCSGOStunden_2 = new JLabel("New label");
			labelCSGOStunden_2.setBounds(188, 426, 46, 14);
			add(labelCSGOStunden_2);
		}
		{
			labelNewLabel_8 = new JLabel("h");
			labelNewLabel_8.setBounds(244, 426, 25, 14);
			add(labelNewLabel_8);
		}
		{
			labelNewLabel_9 = new JLabel("#");
			labelNewLabel_9.setBounds(333, 426, 25, 14);
			add(labelNewLabel_9);
		}
		{
			labelCSGORang_2 = new JLabel("New label");
			labelCSGORang_2.setBounds(347, 426, 46, 14);
			add(labelCSGORang_2);
		}
		{
			separator_6 = new JSeparator();
			separator_6.setBounds(10, 396, 828, 2);
			add(separator_6);
		}
		{
			separator_7 = new JSeparator();
			separator_7.setBounds(10, 522, 828, 2);
			add(separator_7);
		}
		{
			labelNewLabel_10 = new JLabel("CS:GO");
			labelNewLabel_10.setBounds(43, 489, 46, 14);
			add(labelNewLabel_10);
		}
		{
			labelCSGOStunden_3 = new JLabel("New label");
			labelCSGOStunden_3.setBounds(188, 489, 46, 14);
			add(labelCSGOStunden_3);
		}
		{
			labelNewLabel_11 = new JLabel("h");
			labelNewLabel_11.setBounds(244, 489, 25, 14);
			add(labelNewLabel_11);
		}
		{
			labelNewLabel_12 = new JLabel("#");
			labelNewLabel_12.setBounds(333, 489, 25, 14);
			add(labelNewLabel_12);
		}
		{
			labelCSGORang_3 = new JLabel("New label");
			labelCSGORang_3.setBounds(347, 489, 46, 14);
			add(labelCSGORang_3);
		}
		{
			separator_8 = new JSeparator();
			separator_8.setBounds(10, 459, 828, 2);
			add(separator_8);
		}
		{
			separator_9 = new JSeparator();
			separator_9.setBounds(10, 585, 828, 2);
			add(separator_9);
		}
		{
			labelNewLabel_13 = new JLabel("CS:GO");
			labelNewLabel_13.setBounds(43, 552, 46, 14);
			add(labelNewLabel_13);
		}
		{
			labelCSGOStunden_4 = new JLabel("New label");
			labelCSGOStunden_4.setBounds(188, 552, 46, 14);
			add(labelCSGOStunden_4);
		}
		{
			labelNewLabel_14 = new JLabel("h");
			labelNewLabel_14.setBounds(244, 552, 25, 14);
			add(labelNewLabel_14);
		}
		{
			labelNewLabel_15 = new JLabel("#");
			labelNewLabel_15.setBounds(333, 552, 25, 14);
			add(labelNewLabel_15);
		}
		{
			labelCSGORang_4 = new JLabel("New label");
			labelCSGORang_4.setBounds(347, 552, 46, 14);
			add(labelCSGORang_4);
		}
		{
			separator_10 = new JSeparator();
			separator_10.setBounds(10, 522, 828, 2);
			add(separator_10);
		}
		{
			separator_11 = new JSeparator();
			separator_11.setBounds(10, 647, 828, 2);
			add(separator_11);
		}
		{
			labelNewLabel_16 = new JLabel("CS:GO");
			labelNewLabel_16.setBounds(43, 614, 46, 14);
			add(labelNewLabel_16);
		}
		{
			labelCSGOStunden_5 = new JLabel("New label");
			labelCSGOStunden_5.setBounds(188, 614, 46, 14);
			add(labelCSGOStunden_5);
		}
		{
			labelNewLabel_17 = new JLabel("h");
			labelNewLabel_17.setBounds(244, 614, 25, 14);
			add(labelNewLabel_17);
		}
		{
			labelNewLabel_18 = new JLabel("#");
			labelNewLabel_18.setBounds(333, 614, 25, 14);
			add(labelNewLabel_18);
		}
		{
			labelCSGORang_5 = new JLabel("New label");
			labelCSGORang_5.setBounds(347, 614, 46, 14);
			add(labelCSGORang_5);
		}
		{
			separator_13 = new JSeparator();
			separator_13.setBounds(10, 710, 828, 2);
			add(separator_13);
		}
		{
			labelNewLabel_19 = new JLabel("CS:GO");
			labelNewLabel_19.setBounds(43, 677, 46, 14);
			add(labelNewLabel_19);
		}
		{
			labelCSGOStunden_6 = new JLabel("New label");
			labelCSGOStunden_6.setBounds(188, 677, 46, 14);
			add(labelCSGOStunden_6);
		}
		{
			labelNewLabel_20 = new JLabel("h");
			labelNewLabel_20.setBounds(244, 677, 25, 14);
			add(labelNewLabel_20);
		}
		{
			labelNewLabel_21 = new JLabel("#");
			labelNewLabel_21.setBounds(333, 677, 25, 14);
			add(labelNewLabel_21);
		}
		{
			labelCSGORang_6 = new JLabel("New label");
			labelCSGORang_6.setBounds(347, 677, 46, 14);
			add(labelCSGORang_6);
		}
		{
			separator_14 = new JSeparator();
			separator_14.setBounds(10, 647, 828, 2);
			add(separator_14);
		}

	}
}
