package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import sqlverbindung.Benutzer;
import sqlverbindung.DAO;
import sqlverbindung.DAOStatistik;
import sqlverbindung.DB_FehlerException;
import sqlverbindung.Spiele;
import sqlverbindung.Statistik;

public class Profil extends JPanel {
	private JScrollPane scrollPane;
	private JLabel labelName;
	private JLabel labelEMail;
	private JLabel labelMitgliedseit;
	private JLabel labelSpielzeitgesamt;
	private JLabel labelPunkte;
	private JLabel labelRang;
	private JTextField textFieldSpielzeitgesamt;
	private JTextField textFieldPunkte;
	private JTextField textFieldRang;
	private JTextField textFieldMitgliedseit;
	private JTextField textFieldEMail;
	private JTextField textFieldName;
	private JPanel panelViewport;
	private Benutzer benutzer;
	private String[] games = new String[7];
	public Statistik statistik;
	private JLabel labelAppZeit;
	private JTextField textFieldAppZeit;
	private DAO d = new DAO();;
	private DAOStatistik ds = new DAOStatistik();

	/**
	 * Create the panel.
	 */
	public Profil(Benutzer benutzer) {
		this.benutzer = benutzer;
		getStatistik(benutzer);
		addGames();
		initGUI();
		addNameUndEmail();
		addPunkte();
		addGesamtSpielzeit();
		addAppZeit();
	}
	private void initGUI() {
		setLayout(null);
		{
			//Erstellt ein scroll Panel.
			scrollPane = new JScrollPane();
			scrollPane.setBounds(250, 10, 600, 680);
			add(scrollPane);
			{
				//Fügt die oberfläche des Scroll Panels hinzu.
				panelViewport = new JPanel();
				scrollPane.setViewportView(panelViewport);
				{
					//Fügt Für jedes Spiel in games ein Game Panel hinzu mit infos zum Spiel.
					for(int i = 0; i < games.length; i++)
					{
						JPanel gamePanel = new JPanel();
						gamePanel.setBorder(new LineBorder(Color.BLUE, 3));
						gamePanel.setBounds(10, 10 + (i + 60),  460, 50);
						gamePanel.setLayout(null);
						panelViewport.add(gamePanel);
						JLabel gameTitle = new JLabel(games[i]);
						gameTitle.setBounds(10, 5, 300, 40);
						gamePanel.add(gameTitle);
						JLabel spiellabel = new JLabel(games[i]);
						spiellabel.setBounds(350, 5, 50, 20);
						gamePanel.add(spiellabel);
						JLabel spielzeitlabel = new JLabel(games[i]);
						spielzeitlabel.setBounds(350, 30, 50, 20);
						gamePanel.add(spielzeitlabel);
						JTextField spielTextField = new JTextField();
						spielTextField.setBounds(400, 5, 50, 20);
						spielTextField.setEditable(false);
						gamePanel.add(spielTextField);
						JTextField spielzeitTextField = new JTextField();
						spielzeitTextField.setBounds(400, 30, 50, 20);
						spielzeitTextField.setEditable(false);
						gamePanel.add(spielzeitTextField);
					}
					//Zeichnet das Scroll Panel neu.
					panelViewport.repaint();
					
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
			labelSpielzeitgesamt = new JLabel("Spielzeit gesamt:");
			labelSpielzeitgesamt.setBounds(10, 130, 140, 21);
			labelSpielzeitgesamt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			add(labelSpielzeitgesamt);
		}
		//Zeigt "Punkte:" vor dem Punkte Textfeld an.
		{
			labelPunkte = new JLabel("Punkte:");
			labelPunkte.setBounds(10, 170, 100, 21);
			labelPunkte.setFont(new Font("Tahoma", Font.PLAIN, 16));
			add(labelPunkte);
		}
		
		//Textfeld für die Gesamte Spielzeit
		{
			textFieldSpielzeitgesamt = new JTextField();
			textFieldSpielzeitgesamt.setBounds(135, 133, 96, 19);
			textFieldSpielzeitgesamt.setEditable(false);
			add(textFieldSpielzeitgesamt);
			textFieldSpielzeitgesamt.setColumns(10);
		}
		//Textfeld für die Punkte
		{
			textFieldPunkte = new JTextField();
			textFieldPunkte.setBounds(135, 173, 96, 19);
			textFieldPunkte.setEditable(false);
			add(textFieldPunkte);
			textFieldPunkte.setColumns(10);
		}
		//Textfeld für das beitritts Datum
		{
			textFieldMitgliedseit = new JTextField();
			textFieldMitgliedseit.setBounds(135, 93, 96, 19);
			textFieldMitgliedseit.setEditable(false);
			add(textFieldMitgliedseit);
			textFieldMitgliedseit.setColumns(10);
		}
		//Textfeld für die E-Mail
		{
			textFieldEMail = new JTextField();
			textFieldEMail.setBounds(135, 53, 96, 19);
			textFieldEMail.setEditable(false);
			add(textFieldEMail);
			textFieldEMail.setColumns(10);
		}
		//Textfeld für den Namen
		{
			textFieldName = new JTextField();
			textFieldName.setBounds(135, 13, 96, 19);
			textFieldName.setEditable(false);
			add(textFieldName);
			textFieldName.setColumns(10);
		}
		// 
		{
			labelAppZeit = new JLabel("Zeit in der App:");
			labelAppZeit.setFont(new Font("Tahoma", Font.PLAIN, 16));
			labelAppZeit.setBounds(10, 210, 140, 21);
			add(labelAppZeit);
		}
		// 
		{
			textFieldAppZeit = new JTextField();
			textFieldAppZeit.setEditable(false);
			textFieldAppZeit.setBounds(135, 213, 96, 19);
			add(textFieldAppZeit);
			textFieldAppZeit.setColumns(10);
		}
	}
	//Fügt Name und Email des Benutzers in die Text Felder ein.
	public void addNameUndEmail() {
		textFieldName.setText(benutzer.getUsername());
		textFieldEMail.setText(benutzer.getEmail());
	}
	//Fügt Punkte des Benutzers in das Text Feld ein.
	public void addPunkte() {
		textFieldPunkte.setText(Integer.toString(benutzer.getPunkte()));
	}
	
	public void addGesamtSpielzeit() {
		textFieldSpielzeitgesamt.setText(Double.toString(statistik.getGesamtzeit()));
	}
	
	//Fügt Spiele zum games Array hinzu.
	public void addGames() {
		
		Spiele s;
		for(int i = 2; i <=8; i++)
		{
			
			try {
				s = d.selectSpiele(i);
				games[i-2] = s.getName();
			} catch (DB_FehlerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	//Fügt die Zeit die der Benutzer bisher in dieser App verbracht hat in das Text Felder ein.
	public void addAppZeit() {
		textFieldAppZeit.setText(benutzer.getAppzeit());
	}
	private void getStatistik(Benutzer b) {
		try {
			this.statistik = ds.selectStatistikforUser(b);
		} catch (DB_FehlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
