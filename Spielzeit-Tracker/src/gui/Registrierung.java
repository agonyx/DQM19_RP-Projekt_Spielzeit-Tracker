package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import sqlverbindung.Benutzer;
import sqlverbindung.DAOGetandSet;
import sqlverbindung.DAOSelect;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

public class Registrierung extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel labelEmail;
	private JTextField textFieldEmail;
	private JLabel labelBenutzername;
	private JTextField textFieldBenutzername;
	private JLabel labelPasswort;
	private JPasswordField passwortField;
	private JLabel labelPasswortbestaetigen;
	private JPasswordField passwortBestaetigenField;
	private JButton buttonNewButton;
	private JButton buttonRegistrierung;
	private JTextField textFieldSteamID;
	private JLabel labelSteamID;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private Date date = new Date();
	private DAOSelect ds = new DAOSelect();

	public Registrierung() {
		initGUI();
		setVisible(true);
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "Registrierung", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			labelEmail = new JLabel("E-Mail:");
			labelEmail.setHorizontalAlignment(SwingConstants.RIGHT);
			labelEmail.setBounds(38, 20, 91, 21);
			contentPane.add(labelEmail);
		}
		{
			textFieldEmail = new JTextField();
			textFieldEmail.setText("");
			textFieldEmail.setBounds(166, 21, 212, 19);
			contentPane.add(textFieldEmail);
			textFieldEmail.setColumns(10);
		}
		{
			labelBenutzername = new JLabel("Benutzername:");
			labelBenutzername.setHorizontalAlignment(SwingConstants.RIGHT);
			labelBenutzername.setBounds(38, 64, 91, 13);
			contentPane.add(labelBenutzername);
		}
		{
			textFieldBenutzername = new JTextField();
			textFieldBenutzername.setText("");
			textFieldBenutzername.setBounds(166, 61, 212, 19);
			contentPane.add(textFieldBenutzername);
			textFieldBenutzername.setColumns(10);
		}
		{
			labelPasswort = new JLabel("Passwort:");
			labelPasswort.setHorizontalAlignment(SwingConstants.RIGHT);
			labelPasswort.setBounds(59, 100, 71, 13);
			contentPane.add(labelPasswort);
		}
		{
			passwortField = new JPasswordField();
			passwortField.setBounds(166, 97, 212, 19);
			contentPane.add(passwortField);
			passwortField.setColumns(10);
		}
		{
			labelPasswortbestaetigen = new JLabel("Passwort best\u00E4tigen:");
			labelPasswortbestaetigen.setHorizontalAlignment(SwingConstants.CENTER);
			labelPasswortbestaetigen.setBounds(9, 140, 140, 13);
			contentPane.add(labelPasswortbestaetigen);
		}
		{
			passwortBestaetigenField = new JPasswordField();
			passwortBestaetigenField.setBounds(166, 137, 212, 19);
			contentPane.add(passwortBestaetigenField);
			passwortBestaetigenField.setColumns(10);
		}
		{
			buttonNewButton = new JButton("Abbruch");
			buttonNewButton.addActionListener(this);
			buttonNewButton.setBounds(25, 220, 148, 29);
			contentPane.add(buttonNewButton);
		}
		{
			buttonRegistrierung = new JButton("Registrierung");
			buttonRegistrierung.addActionListener(this);
			buttonRegistrierung.setBounds(238, 220, 140, 29);
			contentPane.add(buttonRegistrierung);
		}
		{
			textFieldSteamID = new JTextField();
			textFieldSteamID.setText("");
			textFieldSteamID.setBounds(166, 174, 212, 19);
			contentPane.add(textFieldSteamID);
			textFieldSteamID.setColumns(10);
		}
		{
			labelSteamID = new JLabel("SteamID:");
			labelSteamID.setHorizontalAlignment(SwingConstants.RIGHT);
			labelSteamID.setBounds(10, 177, 120, 13);
			contentPane.add(labelSteamID);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonRegistrierung) {
			do_buttonRegistrierung_actionPerformed(e);
		}
		if (e.getSource() == buttonNewButton) {
			do_buttonNewButton_actionPerformed(e);
		}
	}
	// �ffnet Anmeldung und schlie�t diese Fenster.
	protected void do_buttonNewButton_actionPerformed(ActionEvent e) {
		Anmeldung a = new Anmeldung();
		dispose();
	}
	
	/*
	 * Pr�ft ob die Felder leer sind, bereits in der Datenbank existieren und ob die Passwort Felder �berein stimmen. 
	 * Gibt eine Fehler Meldung aus, sollte etwas nicht stimmen.
	 * Wenn alles richtig sein, wird der Benutzer angelegt, die Anmeldung ge�ffnet und dieses Fenster geschlossen. 
	 */
	protected void do_buttonRegistrierung_actionPerformed(ActionEvent argo) {
		try {
			DAOGetandSet d = new DAOGetandSet();
			String falsche = "Falsche Eingabe.";
			Pattern p = Pattern.compile("@");
			Matcher m = p.matcher(textFieldEmail.getText());
			if(textFieldBenutzername.getText() == null || passwortField.getText() == null || passwortBestaetigenField.getText() == null || textFieldSteamID.getText() == null || textFieldEmail.getText() == null) {
				JOptionPane.showMessageDialog(this, "Alle Felder M�ssen Ausgef�hlt sein.", falsche, ABORT);
			} else {

				if(passwortField.getText().equals(passwortBestaetigenField.getText()))
				{
					if(m.find()) {
						if(!d.getIfBenutzerWithAttributeExistWahr(textFieldEmail.getText(), "Email"))
						{
							//Test
							try {
							Long.parseLong(textFieldSteamID.getText());
							}catch (NumberFormatException e) {
								JOptionPane.showMessageDialog(this, falsche,"Keine g�ltige SteamID", JOptionPane.ERROR_MESSAGE);
							}
							if(!d.getIfBenutzerWithAttributeExistWahr(textFieldSteamID.getText(), "SteamID")) {
								if(!d.getIfBenutzerWithAttributeExistWahr(textFieldBenutzername.getText(), "Username")) {
									Benutzer b = new Benutzer(textFieldBenutzername.getText(), passwortField.getText(), textFieldSteamID.getText(), textFieldEmail.getText(), 0, 0, formatter.format(date));
									int bId = d.insertBenutzer(b);
									b = ds.selectBenutzer(bId);
									d.createDefaultAvatar(b);
									d.createBuyEntry(b, 1, "Gesichter");
									d.createBuyEntry(b, 1, "Gesichtsbedeckungen");
									d.createBuyEntry(b, 1, "Koerper");
									d.createBuyEntry(b, 1, "Kopfbedeckungen");
									d.createBuyEntry(b, 1, "Oberteil");
									Anmeldung a = new Anmeldung();
									dispose();
								} else {
									JOptionPane.showMessageDialog(this, "Benutzername wird bereits genutzt.",falsche, JOptionPane.ERROR_MESSAGE);
								}

							} else {
								JOptionPane.showMessageDialog(this, "Steam API wird bereits genutzt.",falsche, JOptionPane.ERROR_MESSAGE);
							}

						} else {
							JOptionPane.showMessageDialog(this, "Email existiert bereits.",falsche, JOptionPane.ERROR_MESSAGE);
						}
					} else
					{
						JOptionPane.showMessageDialog(this, "Keine g�ltige Email.",falsche, JOptionPane.ERROR_MESSAGE);
					}

				} else 
				{
					JOptionPane.showMessageDialog(this, "Passw�rter Stimmen nicht �ber ein.",falsche, JOptionPane.ERROR_MESSAGE);
				}		
			}
		} catch(NumberFormatException e)
		{
			e.getMessage();
		} catch (sqlverbindung.DB_FehlerException e) 
		{
			e.printStackTrace();
		}
	}
	
}
