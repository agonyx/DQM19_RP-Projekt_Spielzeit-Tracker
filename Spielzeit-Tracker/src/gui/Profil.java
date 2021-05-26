package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

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
	private String[] games = {"Rainbow Six Siege", "", "", "", "", ""};

	/**
	 * Create the panel.
	 */
	public Profil() {
		
		initGUI();
	}
	private void initGUI() {
		setLayout(null);
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(314, 10, 476, 740);
			add(scrollPane);
			{
				panelViewport = new JPanel();
				scrollPane.setViewportView(panelViewport);
				{
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
					panelViewport.repaint();
					
				}
			}
		}
		{
			labelName = new JLabel("Name:");
			labelName.setBounds(10, 10, 100, 21);
			labelName.setFont(new Font("Tahoma", Font.PLAIN, 16));
			add(labelName);
		}
		{
			labelEMail = new JLabel("E-Mail:");
			labelEMail.setBounds(10, 50, 100, 21);
			labelEMail.setFont(new Font("Tahoma", Font.PLAIN, 16));
			add(labelEMail);
		}
		{
			labelMitgliedseit = new JLabel("Mitglied seit:");
			labelMitgliedseit.setBounds(10, 90, 100, 21);
			labelMitgliedseit.setFont(new Font("Tahoma", Font.PLAIN, 16));
			add(labelMitgliedseit);
		}
		{
			labelSpielzeitgesamt = new JLabel("Spielzeit gesamt:");
			labelSpielzeitgesamt.setBounds(10, 130, 140, 21);
			labelSpielzeitgesamt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			add(labelSpielzeitgesamt);
		}
		{
			labelPunkte = new JLabel("Punkte:");
			labelPunkte.setBounds(10, 170, 100, 21);
			labelPunkte.setFont(new Font("Tahoma", Font.PLAIN, 16));
			add(labelPunkte);
		}
		{
			labelRang = new JLabel("Rang:");
			labelRang.setBounds(10, 210, 100, 21);
			labelRang.setFont(new Font("Tahoma", Font.PLAIN, 16));
			add(labelRang);
		}
		{
			textFieldSpielzeitgesamt = new JTextField();
			textFieldSpielzeitgesamt.setBounds(135, 133, 96, 19);
			textFieldSpielzeitgesamt.setEditable(false);
			add(textFieldSpielzeitgesamt);
			textFieldSpielzeitgesamt.setColumns(10);
		}
		{
			textFieldPunkte = new JTextField();
			textFieldPunkte.setBounds(135, 173, 96, 19);
			textFieldPunkte.setEditable(false);
			add(textFieldPunkte);
			textFieldPunkte.setColumns(10);
		}
		{
			textFieldRang = new JTextField();
			textFieldRang.setBounds(135, 213, 96, 19);
			textFieldRang.setEditable(false);
			add(textFieldRang);
			textFieldRang.setColumns(10);
		}
		{
			textFieldMitgliedseit = new JTextField();
			textFieldMitgliedseit.setBounds(135, 93, 96, 19);
			textFieldMitgliedseit.setEditable(false);
			add(textFieldMitgliedseit);
			textFieldMitgliedseit.setColumns(10);
		}
		{
			textFieldEMail = new JTextField();
			textFieldEMail.setBounds(135, 53, 96, 19);
			textFieldEMail.setEditable(false);
			add(textFieldEMail);
			textFieldEMail.setColumns(10);
		}
		{
			textFieldName = new JTextField();
			textFieldName.setBounds(135, 13, 96, 19);
			textFieldName.setEditable(false);
			add(textFieldName);
			textFieldName.setColumns(10);
		}
	}
}