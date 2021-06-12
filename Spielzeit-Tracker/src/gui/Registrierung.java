package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class Registrierung extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel labelEmail;
	private JTextField textFieldEmail;
	private JLabel labelBenutzername;
	private JTextField textFieldBenutzername;
	private JLabel labelPasswort;
	private JTextField textFieldPasswort;
	private JLabel labelPasswortbestaetigen;
	private JTextField textFieldPasswortbestaetigen;
	private JButton buttonNewButton;
	private JButton buttonRegistrierung;
	private JTextField textFieldSteamID;
	private JLabel labelSteamID;

	
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
			textFieldEmail.setText("E-Mail");
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
			textFieldBenutzername.setText("Benutzername");
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
			textFieldPasswort = new JTextField();
			textFieldPasswort.setText("Passwort");
			textFieldPasswort.setBounds(166, 97, 212, 19);
			contentPane.add(textFieldPasswort);
			textFieldPasswort.setColumns(10);
		}
		{
			labelPasswortbestaetigen = new JLabel("Passwort best\u00E4tigen:");
			labelPasswortbestaetigen.setHorizontalAlignment(SwingConstants.RIGHT);
			labelPasswortbestaetigen.setBounds(10, 140, 120, 13);
			contentPane.add(labelPasswortbestaetigen);
		}
		{
			textFieldPasswortbestaetigen = new JTextField();
			textFieldPasswortbestaetigen.setText("Passwort best\u00E4tigen");
			textFieldPasswortbestaetigen.setBounds(166, 137, 212, 19);
			contentPane.add(textFieldPasswortbestaetigen);
			textFieldPasswortbestaetigen.setColumns(10);
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
			textFieldSteamID.setText("SteamID");
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
	protected void do_buttonNewButton_actionPerformed(ActionEvent e) {
		Anmeldung a = new Anmeldung();
		dispose();
	}
	
	protected void do_buttonRegistrierung_actionPerformed(ActionEvent argo) {
		try {
			DAOGetandSet d = new DAOGetandSet();
			String falsche = "Flasche eingabe.";
			Pattern p = Pattern.compile("@");
			Matcher m = p.matcher(textFieldEmail.getText());
			if(textFieldPasswort.getText().equals(textFieldPasswortbestaetigen.getText()))
			{
				if(m.find()) {
					if(d.getIfBenutzerWithAttributeExistWahr(textFieldEmail.getText(), "Email") == false)
					{
						if(d.getIfBenutzerWithAttributeExistWahr(textFieldSteamID.getText(), "SteamID") == false) {
							Benutzer b = new Benutzer(textFieldBenutzername.getText(), textFieldPasswort.getText(), textFieldSteamID.getText(), textFieldEmail.getText(), 0, 0);
							d.insertBenutzer(b);
							d.createAvatar(b);
							Anmeldung a = new Anmeldung();
							dispose();
						} else {
							JOptionPane.showMessageDialog(this, falsche,"Steam API wird bereits genutz.", JOptionPane.ERROR_MESSAGE);
						}
						
					} else {
							JOptionPane.showMessageDialog(this, falsche,"Email existiert bereits.", JOptionPane.ERROR_MESSAGE);
						}
				} else
					{
						JOptionPane.showMessageDialog(this, falsche,"Keine gültige Email.", JOptionPane.ERROR_MESSAGE);
					}
					
			} else 
				{
					JOptionPane.showMessageDialog(this, falsche,"Passwörter Stimmen nicht über ein.", JOptionPane.ERROR_MESSAGE);
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
