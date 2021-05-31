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
	private String[] games = {"Rainbow Six Siege", "", "", "", "", ""};

	/**
	 * Create the panel.
	 */
	public Profil(Benutzer benutzer) {
		this.benutzer = benutzer;
		initGUI();
		addNameUndEmail();
	}
	private void initGUI() {
		setLayout(null);
		{
			//Erstellt ein scroll Panel.
			scrollPane = new JScrollPane();
			scrollPane.setBounds(314, 10, 476, 740);
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
		//Zeigt "Rang:" vor dem Rang Textfeld an.
		{
			labelRang = new JLabel("Rang:");
			labelRang.setBounds(10, 210, 100, 21);
			labelRang.setFont(new Font("Tahoma", Font.PLAIN, 16));
			add(labelRang);
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
		//Textfeld für den Rang
		{
			textFieldRang = new JTextField();
			textFieldRang.setBounds(135, 213, 96, 19);
			textFieldRang.setEditable(false);
			add(textFieldRang);
			textFieldRang.setColumns(10);
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
	}
	//Fügt Name und Email in die Text Felder ein.
	public void addNameUndEmail() {
		textFieldName.setText(benutzer.getUsername());
		textFieldEMail.setText(benutzer.getEmail());
	}
	//Fügt Punkte in das Text Feld ein.
	public void addPunkte() {
		textFieldPunkte.setText(Integer.toString(benutzer.getPunkte()));
	}
}
