package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Statistiken extends JPanel {
	private JLabel labelSpiel;
	private JLabel labelSpielstunden;
	private JLabel labelSpielzeittrackerRang;
	private JLabel labelGame1;
	private JLabel labelGame1Stunden;
	private JLabel labelGame1h;
	private JLabel labelGame1Rang;
	private JLabel labelGame1Hashtag;
	private JLabel labelGame2;
	private JLabel labelGame2Stunden;
	private JLabel labelGame2h;
	private JLabel labelGame2Hashtag;
	private JLabel labelGame2Rang;
	private JSeparator separator_4;
	private JLabel labelGame3;
	private JLabel labelGame3Stunden;
	private JLabel labelGame3h;
	private JLabel labelGame3Hashtag;
	private JLabel labelGame3Rang;
	private JSeparator separator_6;
	private JLabel labelGame4;
	private JLabel labelGame4Stunden;
	private JLabel labelGame4h;
	private JLabel labelGame4Hashtag;
	private JLabel labelGame4Rang;
	private JSeparator separator_8;
	private JSeparator separator_9;
	private JLabel labelGame5;
	private JLabel labelGame5Stunden;
	private JLabel labelGame5h;
	private JLabel labelGame5Hashtag;
	private JLabel labelGame5Rang;
	private JSeparator separator_10;
	private JLabel labelGame6;
	private JLabel labelGame6Stunden;
	private JLabel labelGame6h;
	private JLabel labelGame6Hashtag;
	private JLabel labelGame6Rang;
	private JLabel labelGame7;
	private JLabel labelGame7Stunden;
	private JLabel labelGame7h;
	private JLabel labelGame7Hashtag;
	private JLabel labelGame7Rang;
	private JSeparator separator_14;
	private JPanel panel_2;
	private JPanel panel_zeile1;
	private JPanel panel_4;
	private JLabel labelMostHours_2;
	private JLabel labelMostHours_3;
	private JLabel labelNewLabel;
	private JPanel panel_3;
	private JPanel panel_6;
	private JLabel labelMostHours;
	private JLabel labelMostHours_1;
	private JPanel panel_7;
	private JLabel labelMeisteSpielstunden;

	/**
	 * Create the panel.
	 */
	public Statistiken() {

		initComponents();
	}
	private void initComponents() {
		setBackground(UIManager.getColor("Button.background"));
		setLayout(null);
		JPanel panel = new JPanel();
		{
			panel_2 = new JPanel();
			panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel_2.setBounds(30, 213, 800, 486);
			add(panel_2);
			panel_2.setLayout(null);
			{
				labelGame1 = new JLabel("Apex Legends");
				labelGame1.setBounds(43, 78, 93, 14);
				panel_2.add(labelGame1);
			}
			{
				labelGame1Stunden = new JLabel("New label");
				labelGame1Stunden.setHorizontalAlignment(SwingConstants.RIGHT);
				labelGame1Stunden.setBounds(230, 78, 93, 14);
				panel_2.add(labelGame1Stunden);
			}
			{
				labelGame1h = new JLabel("h");
				labelGame1h.setBounds(333, 78, 25, 14);
				panel_2.add(labelGame1h);
			}
			{
				labelGame1Rang = new JLabel("New label");
				labelGame1Rang.setHorizontalAlignment(SwingConstants.RIGHT);
				labelGame1Rang.setBounds(471, 78, 71, 14);
				panel_2.add(labelGame1Rang);
			}
			{
				labelGame1Hashtag = new JLabel("#");
				labelGame1Hashtag.setBounds(461, 78, 25, 14);
				panel_2.add(labelGame1Hashtag);
			}
			{
				labelGame2 = new JLabel("VALORANT");
				labelGame2.setBounds(43, 141, 93, 14);
				panel_2.add(labelGame2);
			}
			{
				labelGame2Stunden = new JLabel("New label");
				labelGame2Stunden.setHorizontalAlignment(SwingConstants.RIGHT);
				labelGame2Stunden.setBounds(230, 141, 93, 14);
				panel_2.add(labelGame2Stunden);
			}
			{
				labelGame2h = new JLabel("h");
				labelGame2h.setBounds(333, 141, 25, 14);
				panel_2.add(labelGame2h);
			}
			{
				labelGame2Hashtag = new JLabel("#");
				labelGame2Hashtag.setBounds(461, 141, 25, 14);
				panel_2.add(labelGame2Hashtag);
			}
			{
				labelGame2Rang = new JLabel("New label");
				labelGame2Rang.setHorizontalAlignment(SwingConstants.RIGHT);
				labelGame2Rang.setBounds(471, 141, 71, 14);
				panel_2.add(labelGame2Rang);
			}
			{
				separator_4 = new JSeparator();
				separator_4.setBounds(10, 111, 780, 2);
				panel_2.add(separator_4);
			}
			{
				labelGame3 = new JLabel("Rainbow Six Siege");
				labelGame3.setBounds(43, 204, 93, 14);
				panel_2.add(labelGame3);
			}
			{
				labelGame3Stunden = new JLabel("New label");
				labelGame3Stunden.setHorizontalAlignment(SwingConstants.RIGHT);
				labelGame3Stunden.setBounds(230, 204, 93, 14);
				panel_2.add(labelGame3Stunden);
			}
			{
				labelGame3h = new JLabel("h");
				labelGame3h.setBounds(333, 204, 25, 14);
				panel_2.add(labelGame3h);
			}
			{
				labelGame3Hashtag = new JLabel("#");
				labelGame3Hashtag.setBounds(461, 204, 25, 14);
				panel_2.add(labelGame3Hashtag);
			}
			{
				labelGame3Rang = new JLabel("New label");
				labelGame3Rang.setHorizontalAlignment(SwingConstants.RIGHT);
				labelGame3Rang.setBounds(471, 204, 71, 14);
				panel_2.add(labelGame3Rang);
			}
			{
				separator_6 = new JSeparator();
				separator_6.setBounds(10, 174, 780, 2);
				panel_2.add(separator_6);
			}
			{
				labelGame4 = new JLabel("CS:GO");
				labelGame4.setBounds(43, 267, 93, 14);
				panel_2.add(labelGame4);
			}
			{
				labelGame4Stunden = new JLabel("New label");
				labelGame4Stunden.setHorizontalAlignment(SwingConstants.RIGHT);
				labelGame4Stunden.setBounds(230, 267, 93, 14);
				panel_2.add(labelGame4Stunden);
			}
			{
				labelGame4h = new JLabel("h");
				labelGame4h.setBounds(333, 267, 25, 14);
				panel_2.add(labelGame4h);
			}
			{
				labelGame4Hashtag = new JLabel("#");
				labelGame4Hashtag.setBounds(461, 267, 25, 14);
				panel_2.add(labelGame4Hashtag);
			}
			{
				labelGame4Rang = new JLabel("New label");
				labelGame4Rang.setHorizontalAlignment(SwingConstants.RIGHT);
				labelGame4Rang.setBounds(471, 267, 71, 14);
				panel_2.add(labelGame4Rang);
			}
			{
				separator_8 = new JSeparator();
				separator_8.setBounds(10, 237, 780, 2);
				panel_2.add(separator_8);
			}
			{
				separator_9 = new JSeparator();
				separator_9.setBounds(10, 363, 780, 2);
				panel_2.add(separator_9);
			}
			{
				labelGame5 = new JLabel("GAME 5");
				labelGame5.setBounds(43, 330, 93, 14);
				panel_2.add(labelGame5);
			}
			{
				labelGame5Stunden = new JLabel("New label");
				labelGame5Stunden.setHorizontalAlignment(SwingConstants.RIGHT);
				labelGame5Stunden.setBounds(230, 330, 93, 14);
				panel_2.add(labelGame5Stunden);
			}
			{
				labelGame5h = new JLabel("h");
				labelGame5h.setBounds(333, 330, 25, 14);
				panel_2.add(labelGame5h);
			}
			{
				labelGame5Hashtag = new JLabel("#");
				labelGame5Hashtag.setBounds(461, 330, 25, 14);
				panel_2.add(labelGame5Hashtag);
			}
			{
				labelGame5Rang = new JLabel("New label");
				labelGame5Rang.setHorizontalAlignment(SwingConstants.RIGHT);
				labelGame5Rang.setBounds(471, 330, 71, 14);
				panel_2.add(labelGame5Rang);
			}
			{
				separator_10 = new JSeparator();
				separator_10.setBounds(10, 300, 780, 2);
				panel_2.add(separator_10);
			}
			{
				labelGame6 = new JLabel("GAME 6");
				labelGame6.setBounds(43, 392, 93, 14);
				panel_2.add(labelGame6);
			}
			{
				labelGame6Stunden = new JLabel("New label");
				labelGame6Stunden.setHorizontalAlignment(SwingConstants.RIGHT);
				labelGame6Stunden.setBounds(230, 392, 93, 14);
				panel_2.add(labelGame6Stunden);
			}
			{
				labelGame6h = new JLabel("h");
				labelGame6h.setBounds(333, 392, 25, 14);
				panel_2.add(labelGame6h);
			}
			{
				labelGame6Hashtag = new JLabel("#");
				labelGame6Hashtag.setBounds(461, 392, 25, 14);
				panel_2.add(labelGame6Hashtag);
			}
			{
				labelGame6Rang = new JLabel("New label");
				labelGame6Rang.setHorizontalAlignment(SwingConstants.RIGHT);
				labelGame6Rang.setBounds(471, 392, 71, 14);
				panel_2.add(labelGame6Rang);
			}
			{
				labelGame7 = new JLabel("GAME 7");
				labelGame7.setBounds(43, 455, 93, 14);
				panel_2.add(labelGame7);
			}
			{
				labelGame7Stunden = new JLabel("New label");
				labelGame7Stunden.setHorizontalAlignment(SwingConstants.RIGHT);
				labelGame7Stunden.setBounds(230, 455, 93, 14);
				panel_2.add(labelGame7Stunden);
			}
			{
				labelGame7h = new JLabel("h");
				labelGame7h.setBounds(333, 455, 25, 14);
				panel_2.add(labelGame7h);
			}
			{
				labelGame7Hashtag = new JLabel("#");
				labelGame7Hashtag.setBounds(461, 455, 25, 14);
				panel_2.add(labelGame7Hashtag);
			}
			{
				labelGame7Rang = new JLabel("New label");
				labelGame7Rang.setHorizontalAlignment(SwingConstants.RIGHT);
				labelGame7Rang.setBounds(471, 455, 71, 14);
				panel_2.add(labelGame7Rang);
			}
			{
				separator_14 = new JSeparator();
				separator_14.setBounds(10, 425, 780, 2);
				panel_2.add(separator_14);
			}
			{
				panel_zeile1 = new JPanel();
				panel_zeile1.setBackground(Color.GRAY);
				panel_zeile1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				panel_zeile1.setBounds(0, 0, 800, 50);
				panel_2.add(panel_zeile1);
				panel_zeile1.setLayout(null);
				{
					labelSpiel = new JLabel("Spiel");
					labelSpiel.setBounds(41, 25, 135, 14);
					panel_zeile1.add(labelSpiel);
				}
				{
					labelSpielstunden = new JLabel("Spielstunden");
					labelSpielstunden.setBounds(274, 25, 135, 14);
					panel_zeile1.add(labelSpielstunden);
				}
				{
					labelSpielzeittrackerRang = new JLabel("Spielzeit-Tracker Rang");
					labelSpielzeittrackerRang.setBounds(457, 25, 135, 14);
					panel_zeile1.add(labelSpielzeittrackerRang);
				}
			}
		}
		{
			panel_6 = new JPanel();
			panel_6.setLayout(null);
			panel_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel_6.setBackground(UIManager.getColor("Button.background"));
			panel_6.setBounds(448, 35, 382, 123);
			add(panel_6);
			{
				labelMostHours = new JLabel("nummer");
				labelMostHours.setBounds(30, 58, 38, 14);
				panel_6.add(labelMostHours);
			}
			{
				labelMostHours_1 = new JLabel("h");
				labelMostHours_1.setBounds(78, 58, 6, 14);
				panel_6.add(labelMostHours_1);
			}
			{
				panel_7 = new JPanel();
				panel_7.setLayout(null);
				panel_7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				panel_7.setBackground(Color.GRAY);
				panel_7.setBounds(20, 23, 114, 24);
				panel_6.add(panel_7);
				{
					labelMeisteSpielstunden = new JLabel("Meiste Spielstunden");
					labelMeisteSpielstunden.setBounds(10, 4, 266, 14);
					panel_7.add(labelMeisteSpielstunden);
				}
			}
		}
		{
			panel_3 = new JPanel();
			panel_3.setBounds(30, 35, 382, 123);
			add(panel_3);
			panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel_3.setBackground(UIManager.getColor("Button.background"));
			panel_3.setLayout(null);
			{
				labelMostHours_2 = new JLabel("nummer");
				labelMostHours_2.setBounds(30, 58, 38, 14);
				panel_3.add(labelMostHours_2);
			}
			{
				labelMostHours_3 = new JLabel("h");
				labelMostHours_3.setBounds(78, 58, 6, 14);
				panel_3.add(labelMostHours_3);
			}
			{
				panel_4 = new JPanel();
				panel_4.setBounds(20, 23, 101, 24);
				panel_3.add(panel_4);
				panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				panel_4.setBackground(Color.GRAY);
				panel_4.setLayout(null);
				{
					labelNewLabel = new JLabel("Gesamtspielzeit");
					labelNewLabel.setBounds(10, 4, 266, 14);
					panel_4.add(labelNewLabel);
				}
			}
		}
	}
}
