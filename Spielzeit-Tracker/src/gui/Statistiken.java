package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.FlowLayout;

public class Statistiken extends JPanel {
	private JLabel labelSpiel;
	private JLabel labelSpielstunden;
	private JLabel labelSpielzeittrackerRang;
	private JLabel labelNewLabel_1;
	private JLabel labelCSGOStunden;
	private JLabel labelNewLabel_3;
	private JLabel labelCSGORang;
	private JLabel labelNewLabel_2;
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
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_zeile1;
	private JPanel panel_4;
	private JLabel labelMostHours_2;
	private JLabel labelMostHours_3;
	private JPanel panel_5;
	private JLabel labelMostHours;
	private JLabel labelMostHours_1;
	private JLabel labelNewLabel;
	private JLabel labelMeistegespieltesSpiel;

	/**
	 * Create the panel.
	 */
	public Statistiken() {

		initComponents();
	}
	private void initComponents() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		JPanel panel = new JPanel();

		{
			panel_1 = new JPanel();
			panel_1.setBorder(null);
			panel_1.setBackground(Color.DARK_GRAY);
			panel_1.setBounds(30, 35, 476, 125);
			add(panel_1);
			panel_1.setLayout(null);
			{
				panel_5 = new JPanel();
				panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				panel_5.setBackground(Color.GRAY);
				panel_5.setBounds(20, 64, 356, 24);
				panel_1.add(panel_5);
				panel_5.setLayout(null);
				{
					labelMostHours = new JLabel("nummer");
					labelMostHours.setBounds(275, 5, 38, 14);
					panel_5.add(labelMostHours);
				}
				{
					labelMostHours_1 = new JLabel("h");
					labelMostHours_1.setBounds(323, 5, 16, 14);
					panel_5.add(labelMostHours_1);
				}
				{
					labelMeistegespieltesSpiel = new JLabel("Meiste Spielstunden");
					labelMeistegespieltesSpiel.setBounds(10, 5, 266, 14);
					panel_5.add(labelMeistegespieltesSpiel);
				}
			}
			{
				panel_4 = new JPanel();
				panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				panel_4.setBounds(20, 23, 356, 24);
				panel_1.add(panel_4);
				panel_4.setBackground(Color.GRAY);
				panel_4.setLayout(null);
				{
					labelMostHours_2 = new JLabel("nummer");
					labelMostHours_2.setBounds(276, 4, 38, 14);
					panel_4.add(labelMostHours_2);
				}
				{
					labelMostHours_3 = new JLabel("h");
					labelMostHours_3.setBounds(324, 4, 6, 14);
					panel_4.add(labelMostHours_3);
				}
				{
					labelNewLabel = new JLabel("Gesamtspielzeit");
					labelNewLabel.setBounds(10, 4, 266, 14);
					panel_4.add(labelNewLabel);
				}
			}
		}
		{
			panel_2 = new JPanel();
			panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel_2.setBackground(Color.LIGHT_GRAY);
			panel_2.setBounds(30, 213, 476, 497);
			add(panel_2);
			panel_2.setLayout(null);
			{
				labelNewLabel_1 = new JLabel("CS:GO");
				labelNewLabel_1.setBounds(43, 78, 46, 14);
				panel_2.add(labelNewLabel_1);
			}
			{
				labelCSGOStunden = new JLabel("New label");
				labelCSGOStunden.setBounds(188, 78, 46, 14);
				panel_2.add(labelCSGOStunden);
			}
			{
				labelNewLabel_3 = new JLabel("h");
				labelNewLabel_3.setBounds(244, 78, 25, 14);
				panel_2.add(labelNewLabel_3);
			}
			{
				labelCSGORang = new JLabel("New label");
				labelCSGORang.setBounds(347, 78, 46, 14);
				panel_2.add(labelCSGORang);
			}
			{
				labelNewLabel_2 = new JLabel("#");
				labelNewLabel_2.setBounds(333, 78, 25, 14);
				panel_2.add(labelNewLabel_2);
			}
			{
				separator_2 = new JSeparator();
				separator_2.setBounds(10, 111, 458, 2);
				panel_2.add(separator_2);
			}
			{
				separator_3 = new JSeparator();
				separator_3.setBounds(10, 174, 456, 2);
				panel_2.add(separator_3);
			}
			{
				labelNewLabel_4 = new JLabel("CS:GO");
				labelNewLabel_4.setBounds(43, 141, 46, 14);
				panel_2.add(labelNewLabel_4);
			}
			{
				labelCSGOStunden_1 = new JLabel("New label");
				labelCSGOStunden_1.setBounds(188, 141, 46, 14);
				panel_2.add(labelCSGOStunden_1);
			}
			{
				labelNewLabel_5 = new JLabel("h");
				labelNewLabel_5.setBounds(244, 141, 25, 14);
				panel_2.add(labelNewLabel_5);
			}
			{
				labelNewLabel_6 = new JLabel("#");
				labelNewLabel_6.setBounds(333, 141, 25, 14);
				panel_2.add(labelNewLabel_6);
			}
			{
				labelCSGORang_1 = new JLabel("New label");
				labelCSGORang_1.setBounds(347, 141, 46, 14);
				panel_2.add(labelCSGORang_1);
			}
			{
				separator_4 = new JSeparator();
				separator_4.setBounds(10, 111, 456, 2);
				panel_2.add(separator_4);
			}
			{
				separator_5 = new JSeparator();
				separator_5.setBounds(10, 237, 456, 2);
				panel_2.add(separator_5);
			}
			{
				labelNewLabel_7 = new JLabel("CS:GO");
				labelNewLabel_7.setBounds(43, 204, 46, 14);
				panel_2.add(labelNewLabel_7);
			}
			{
				labelCSGOStunden_2 = new JLabel("New label");
				labelCSGOStunden_2.setBounds(188, 204, 46, 14);
				panel_2.add(labelCSGOStunden_2);
			}
			{
				labelNewLabel_8 = new JLabel("h");
				labelNewLabel_8.setBounds(244, 204, 25, 14);
				panel_2.add(labelNewLabel_8);
			}
			{
				labelNewLabel_9 = new JLabel("#");
				labelNewLabel_9.setBounds(333, 204, 25, 14);
				panel_2.add(labelNewLabel_9);
			}
			{
				labelCSGORang_2 = new JLabel("New label");
				labelCSGORang_2.setBounds(347, 204, 46, 14);
				panel_2.add(labelCSGORang_2);
			}
			{
				separator_6 = new JSeparator();
				separator_6.setBounds(10, 174, 458, 2);
				panel_2.add(separator_6);
			}
			{
				separator_7 = new JSeparator();
				separator_7.setBounds(10, 300, 458, 2);
				panel_2.add(separator_7);
			}
			{
				labelNewLabel_10 = new JLabel("CS:GO");
				labelNewLabel_10.setBounds(43, 267, 46, 14);
				panel_2.add(labelNewLabel_10);
			}
			{
				labelCSGOStunden_3 = new JLabel("New label");
				labelCSGOStunden_3.setBounds(188, 267, 46, 14);
				panel_2.add(labelCSGOStunden_3);
			}
			{
				labelNewLabel_11 = new JLabel("h");
				labelNewLabel_11.setBounds(244, 267, 25, 14);
				panel_2.add(labelNewLabel_11);
			}
			{
				labelNewLabel_12 = new JLabel("#");
				labelNewLabel_12.setBounds(333, 267, 25, 14);
				panel_2.add(labelNewLabel_12);
			}
			{
				labelCSGORang_3 = new JLabel("New label");
				labelCSGORang_3.setBounds(347, 267, 46, 14);
				panel_2.add(labelCSGORang_3);
			}
			{
				separator_8 = new JSeparator();
				separator_8.setBounds(10, 237, 456, 2);
				panel_2.add(separator_8);
			}
			{
				separator_9 = new JSeparator();
				separator_9.setBounds(10, 363, 456, 2);
				panel_2.add(separator_9);
			}
			{
				labelNewLabel_13 = new JLabel("CS:GO");
				labelNewLabel_13.setBounds(43, 330, 46, 14);
				panel_2.add(labelNewLabel_13);
			}
			{
				labelCSGOStunden_4 = new JLabel("New label");
				labelCSGOStunden_4.setBounds(188, 330, 46, 14);
				panel_2.add(labelCSGOStunden_4);
			}
			{
				labelNewLabel_14 = new JLabel("h");
				labelNewLabel_14.setBounds(244, 330, 25, 14);
				panel_2.add(labelNewLabel_14);
			}
			{
				labelNewLabel_15 = new JLabel("#");
				labelNewLabel_15.setBounds(333, 330, 25, 14);
				panel_2.add(labelNewLabel_15);
			}
			{
				labelCSGORang_4 = new JLabel("New label");
				labelCSGORang_4.setBounds(347, 330, 46, 14);
				panel_2.add(labelCSGORang_4);
			}
			{
				separator_10 = new JSeparator();
				separator_10.setBounds(10, 300, 456, 2);
				panel_2.add(separator_10);
			}
			{
				separator_11 = new JSeparator();
				separator_11.setBounds(10, 425, 458, 2);
				panel_2.add(separator_11);
			}
			{
				labelNewLabel_16 = new JLabel("CS:GO");
				labelNewLabel_16.setBounds(43, 392, 46, 14);
				panel_2.add(labelNewLabel_16);
			}
			{
				labelCSGOStunden_5 = new JLabel("New label");
				labelCSGOStunden_5.setBounds(188, 392, 46, 14);
				panel_2.add(labelCSGOStunden_5);
			}
			{
				labelNewLabel_17 = new JLabel("h");
				labelNewLabel_17.setBounds(244, 392, 25, 14);
				panel_2.add(labelNewLabel_17);
			}
			{
				labelNewLabel_18 = new JLabel("#");
				labelNewLabel_18.setBounds(333, 392, 25, 14);
				panel_2.add(labelNewLabel_18);
			}
			{
				labelCSGORang_5 = new JLabel("New label");
				labelCSGORang_5.setBounds(347, 392, 46, 14);
				panel_2.add(labelCSGORang_5);
			}
			{
				separator_13 = new JSeparator();
				separator_13.setBounds(10, 488, 458, 2);
				panel_2.add(separator_13);
			}
			{
				labelNewLabel_19 = new JLabel("CS:GO");
				labelNewLabel_19.setBounds(43, 455, 46, 14);
				panel_2.add(labelNewLabel_19);
			}
			{
				labelCSGOStunden_6 = new JLabel("New label");
				labelCSGOStunden_6.setBounds(188, 455, 46, 14);
				panel_2.add(labelCSGOStunden_6);
			}
			{
				labelNewLabel_20 = new JLabel("h");
				labelNewLabel_20.setBounds(244, 455, 25, 14);
				panel_2.add(labelNewLabel_20);
			}
			{
				labelNewLabel_21 = new JLabel("#");
				labelNewLabel_21.setBounds(333, 455, 25, 14);
				panel_2.add(labelNewLabel_21);
			}
			{
				labelCSGORang_6 = new JLabel("New label");
				labelCSGORang_6.setBounds(347, 455, 46, 14);
				panel_2.add(labelCSGORang_6);
			}
			{
				separator_14 = new JSeparator();
				separator_14.setBounds(10, 425, 458, 2);
				panel_2.add(separator_14);
			}
			{
				panel_zeile1 = new JPanel();
				panel_zeile1.setBackground(Color.GRAY);
				panel_zeile1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				panel_zeile1.setBounds(0, 0, 476, 50);
				panel_2.add(panel_zeile1);
				panel_zeile1.setLayout(null);
				{
					labelSpiel = new JLabel("Spiel");
					labelSpiel.setBounds(41, 25, 135, 14);
					panel_zeile1.add(labelSpiel);
				}
				{
					labelSpielstunden = new JLabel("Spielstunden");
					labelSpielstunden.setBounds(186, 25, 135, 14);
					panel_zeile1.add(labelSpielstunden);
				}
				{
					labelSpielzeittrackerRang = new JLabel("Spielzeit-Tracker Rang");
					labelSpielzeittrackerRang.setBounds(331, 25, 135, 14);
					panel_zeile1.add(labelSpielzeittrackerRang);
				}
			}
		}
	}
}
