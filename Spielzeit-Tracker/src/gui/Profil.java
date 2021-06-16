package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import sqlverbindung.Benutzer;
import sqlverbindung.DAOGetandSet;
import sqlverbindung.DAOSelect;
import sqlverbindung.DAOStatistik;
import sqlverbindung.DB_FehlerException;
import sqlverbindung.Spiele;
import sqlverbindung.Statistik;
import javax.swing.SwingConstants;

public class Profil extends JPanel {
	private JLabel labelName;
	private JLabel labelEMail;
	private JLabel labelMitgliedseit;
	private JLabel labelSpielzeitgesamt;
	private JTextField textFieldSpielzeitgesamt;
	private JTextField textFieldMitgliedseit;
	private JTextField textFieldEMail;
	private JTextField textFieldName;
	private Benutzer benutzer;
	private Spiele[] games;
	public Statistik statistik;
	private DAOStatistik ds = new DAOStatistik();
	private JScrollPane scrollPane;
	private JPanel panelViewport;
	private DAOGetandSet dg;
	private HashMap<Integer, Integer> spielzeiten;
	private JLabel labelRang;
	private JTextField textFieldRang;
	private JLabel labelMeisteSpielzeit;
	private JTextField textFieldMostPlayedGame;
	private DAOSelect daoselect = new DAOSelect();

	/**
	 * Create the panel.
	 */
	public Profil(Benutzer benutzer) {
		try {
			dg = new DAOGetandSet();
			this.benutzer = benutzer;
			spielzeiten = Hauptseite.getSpielzeiten();
			getStatistik(benutzer);
			addGames();
			initGUI();
			addNameUndEmail();
			addPunkte();
			addGesamtSpielzeit();
			addMitgliedDatum();
			addRangTotal();
			addGameMostHours();
		} catch (DB_FehlerException e) {
			JOptionPane.showMessageDialog(this, "KRITISCHER FEHLER");
			e.printStackTrace();
			System.exit(0);
		}

	}
	private void initGUI() throws DB_FehlerException {
		setBounds(30, 213, 865, 725);
		setLayout(null);
		{
			{
				{
					scrollPane = new JScrollPane();
					scrollPane.setBounds(250, 10, 600, 680);
					scrollPane.setBorder(null);
					add(scrollPane);
					{
						panelViewport = new JPanel();
						scrollPane.setViewportView(panelViewport);
						panelViewport.setLayout(null);

					}
				}
				{
					//Fügt Für jedes Spiel in games ein Game Panel hinzu mit infos zum Spiel.
					int delay = 0;
					for(int i = 0; i < games.length; i++)
					{
						JPanel gamePanel = new JPanel();
						gamePanel.setBorder(new LineBorder(Color.BLUE, 3));
						gamePanel.setBounds(10, 0 + (i + delay),  580, 50);
						gamePanel.setLayout(null);
						JLabel gameTitle = new JLabel(games[i].getName());
						gameTitle.setBounds(10, 5, 300, 40);
						gamePanel.add(gameTitle);
						JLabel labelh= new JLabel("Std");
						labelh.setBounds(540, 17, 50, 20);
						gamePanel.add(labelh);
						JTextField spielzeitTextField = new JTextField();
						spielzeitTextField.setBounds(450, 17, 75, 20);
						spielzeitTextField.setEditable(false);
						JLabel labelRang = new JLabel("Rang");
						labelRang.setBounds(295, 17, 50, 20);
						gamePanel.add(labelRang);
						if(spielzeiten.get(games[i].getAppID()) != null) {
							spielzeitTextField.setText(String.valueOf(minutesToHours(spielzeiten.get(games[i].getAppID()))));
						} else {
							spielzeitTextField.setText("N/A");
						}
						JTextField textFieldRank= new JTextField();
						textFieldRank.setBounds(340, 17, 75, 20);
						textFieldRank.setEditable(false);
						if(spielzeiten.get(games[i].getAppID()) != null) {
							textFieldRank.setText(String.valueOf(ds.getRankGames(benutzer,games[i])));
						} else {
							textFieldRank.setText("N/A");
						}
						gamePanel.add(textFieldRank);
						gamePanel.add(spielzeitTextField);
						panelViewport.add(gamePanel);
						delay = delay +60;
					}

				}
			}
		}
		//Zeigt "Name:" vor dem Name Textfeld an.
		{
			labelName = new JLabel("Name:");
			labelName.setBounds(10, 10, 100, 21);
			labelName.setFont(new Font("Tahoma", Font.PLAIN, 16));
			add(labelName);
		}
		//Zeigt "E-Mail:" vor dem EMail Textfeld an.
		{
			labelEMail = new JLabel("E-Mail:");
			labelEMail.setBounds(10, 50, 100, 21);
			labelEMail.setFont(new Font("Tahoma", Font.PLAIN, 16));
			add(labelEMail);
		}
		//Zeigt "Spielzeit gesamt:" vor dem Spielzeitgesamt Textfeld an.
		{
			labelMitgliedseit = new JLabel("Mitglied seit:");
			labelMitgliedseit.setBounds(10, 90, 100, 21);
			labelMitgliedseit.setFont(new Font("Tahoma", Font.PLAIN, 16));
			add(labelMitgliedseit);
		}
		//Zeigt Spielzeit gesamt: vor dem Spielzeitgesamt Textfeld an.
		{
			labelSpielzeitgesamt = new JLabel("Gesamtspielzeit:");
			labelSpielzeitgesamt.setBounds(10, 130, 140, 21);
			labelSpielzeitgesamt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			add(labelSpielzeitgesamt);
		}

		//Textfeld für die Gesamte Spielzeit
		{
			textFieldSpielzeitgesamt = new JTextField();
			textFieldSpielzeitgesamt.setBounds(135, 130, 96, 19);
			textFieldSpielzeitgesamt.setEditable(false);
			add(textFieldSpielzeitgesamt);
			textFieldSpielzeitgesamt.setColumns(10);
		}
		//Textfeld für das beitritts Datum
		{
			textFieldMitgliedseit = new JTextField();
			textFieldMitgliedseit.setHorizontalAlignment(SwingConstants.LEFT);
			textFieldMitgliedseit.setBounds(135, 90, 96, 19);
			textFieldMitgliedseit.setEditable(false);
			add(textFieldMitgliedseit);
			textFieldMitgliedseit.setColumns(10);
		}
		//Textfeld für die E-Mail
		{
			textFieldEMail = new JTextField();
			textFieldEMail.setHorizontalAlignment(SwingConstants.LEFT);
			textFieldEMail.setBounds(135, 50, 96, 19);
			textFieldEMail.setEditable(false);
			add(textFieldEMail);
			textFieldEMail.setColumns(10);
		}
		//Textfeld für den Namen
		{
			textFieldName = new JTextField();
			textFieldName.setHorizontalAlignment(SwingConstants.LEFT);
			textFieldName.setBounds(135, 10, 96, 19);
			textFieldName.setEditable(false);
			add(textFieldName);
			textFieldName.setColumns(10);
		}
		{
			labelRang = new JLabel("Rang");
			labelRang.setFont(new Font("Tahoma", Font.PLAIN, 16));
			labelRang.setBounds(10, 170, 100, 21);
			add(labelRang);
		}
		{
			textFieldRang = new JTextField();
			textFieldRang.setText("0");
			textFieldRang.setEditable(false);
			textFieldRang.setColumns(10);
			textFieldRang.setBounds(135, 170, 96, 19);
			add(textFieldRang);
		}
		{
			labelMeisteSpielzeit = new JLabel("Meistgespielt:");
			labelMeisteSpielzeit.setFont(new Font("Tahoma", Font.PLAIN, 16));
			labelMeisteSpielzeit.setBounds(10, 210, 140, 21);
			add(labelMeisteSpielzeit);
		}
		{
			textFieldMostPlayedGame = new JTextField();
			textFieldMostPlayedGame.setHorizontalAlignment(SwingConstants.LEFT);
			textFieldMostPlayedGame.setEditable(false);
			textFieldMostPlayedGame.setColumns(10);
			textFieldMostPlayedGame.setBounds(135, 210, 96, 19);
			add(textFieldMostPlayedGame);
		}


	}
	//Fügt Name und Email des Benutzers in die Text Felder ein.
	private void addNameUndEmail() {
		textFieldName.setText(benutzer.getUsername());
		textFieldEMail.setText(benutzer.getEmail());
	}
	//Fügt Punkte des Benutzers in das Text Feld ein.
	private void addPunkte() {
	}

	private void addGesamtSpielzeit() {
		textFieldSpielzeitgesamt.setText(Double.toString(statistik.getGesamtzeit()));
	}
	private void addGameMostHours () throws DB_FehlerException {
		if(gameMaxTimeID() != null) 
		textFieldMostPlayedGame.setText(daoselect.selectGame(Integer.parseInt(gameMaxTimeID())).getName());
	}
	private String gameMaxTimeID() {
		ArrayList<Integer> appids = new ArrayList<Integer>();
		for(int i = 0; i < games.length; i++) {
			appids.add(games[i].getAppID());
		}
		double max=0;
		int appid = 0;
		for(int i=0; i<games.length; i++) {
			if(spielzeiten.get(appids.get(i)) != null) {
				if(spielzeiten.get(appids.get(i))>max) {
					max = spielzeiten.get(appids.get(i));
					appid = appids.get(i);
				}
			}
		}
		if (appid != 0) {
			return String.valueOf(appid);
		} else {	
			return null;
		}
	}
	//Fügt Spiele zum games Array hinzu.
	private void addGames() {
		try {
			games = dg.getAllGames();
		} catch (DB_FehlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//Fügt die Zeit die der Benutzer bisher in dieser App verbracht hat in das Text Felder ein.
	private void getStatistik(Benutzer b) {
		try {
			this.statistik = ds.selectStatistikforUser(b);
		} catch (DB_FehlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void addMitgliedDatum() {
		textFieldMitgliedseit.setText(statistik.getDate());
	}
	private void addRangTotal() throws DB_FehlerException {
		textFieldRang.setText(String.valueOf(ds.getRank(benutzer)));
	}
	private int minutesToHours(int integer) {
		return (integer/60);
	}
}
