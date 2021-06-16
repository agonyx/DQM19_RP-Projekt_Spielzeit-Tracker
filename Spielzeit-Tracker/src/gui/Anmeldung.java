package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import io.FileCreationError;
import io.FileManager;
import sqlverbindung.Benutzer;
import sqlverbindung.DAOGetandSet;
import sqlverbindung.DAOSelect;
import sqlverbindung.DAOStatistik;
import sqlverbindung.DB_FehlerException;
import sqlverbindung.Spiele;
import threads.ThreadAnmeldung;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Anmeldung extends JFrame implements ActionListener {

	private JPanel mainPane;
	private JTextField textFieldEmailBenutzername;
	private JButton exitButton;
	private JButton loginButton;
	private JCheckBox checkBoxNewCheckBox;
	private DAOGetandSet d;
	private DAOStatistik ds;
	private FileManager fm;
	private JPasswordField textFieldPasswort;
	private JButton registrierungButton;

	public Anmeldung() {
		initComponents();
		if(fm.doesExist("Userdata.txt")) {
			try {
				String data = fm.read("Userdata.txt");
				String datastring [] = data.split(" ");
				String username = datastring[1];
				String passwort = datastring[3];
				textFieldEmailBenutzername.setText(username);
				textFieldPasswort.setText(passwort);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		this.repaint();
	}
	private void initComponents() {
		d = new DAOGetandSet();
		ds = new DAOStatistik();
		fm = new FileManager();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 230);
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(null);

		textFieldEmailBenutzername = new JTextField();
		textFieldEmailBenutzername.setToolTipText("Email / Benutzername");
		textFieldEmailBenutzername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldEmailBenutzername_focusGained(e);
			}
		});
		textFieldEmailBenutzername.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldEmailBenutzername.setText("Email / Benutzername");
		textFieldEmailBenutzername.setBounds(10, 47, 314, 25);
		mainPane.add(textFieldEmailBenutzername);
		textFieldEmailBenutzername.setColumns(10);

		JLabel loginLabel = new JLabel("Anmeldung");
		loginLabel.setBounds(118, 11, 162, 25);
		mainPane.add(loginLabel);
		loginLabel.setFont (loginLabel.getFont ().deriveFont (18.0f));

		exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		exitButton.setBounds(10, 163, 103, 25);
		mainPane.add(exitButton);

		loginButton = new JButton("Login");
		loginButton.addActionListener(this);
		loginButton.setBounds(215, 163, 109, 25);
		mainPane.add(loginButton);

		checkBoxNewCheckBox = new JCheckBox("Passwort speichern");
		checkBoxNewCheckBox.setBounds(10, 113, 145, 41);
		mainPane.add(checkBoxNewCheckBox);

		textFieldPasswort = new JPasswordField();
		textFieldPasswort.setToolTipText("Passwort");
		textFieldPasswort.setBounds(10, 82, 314, 25);
		mainPane.add(textFieldPasswort);
		{
			registrierungButton = new JButton("Registrierung");
			registrierungButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					registrierungButton_actionPerformed(e);
				}
			});
			registrierungButton.setBounds(215, 125, 109, 25);
			mainPane.add(registrierungButton);
		}

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitButton) {
			ExitButtonActionPerformed(e);
		}
		if (e.getSource() == loginButton) {
			loginButton_actionPerformed(e);
		}
	}
	protected void ExitButtonActionPerformed(ActionEvent e) {
		dispose();
	}

	protected void loginButton_actionPerformed(ActionEvent e) {
		try {
			if (textFieldEmailBenutzername.getText().isBlank()||textFieldPasswort.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "Die leeren Felder m�ssen gef�llt werden!","Fehler",JOptionPane.ERROR_MESSAGE);
			} else {
				//Sucht nach Benutzer mit Attribut in Datenbank
				Benutzer ben = d.getIfBenutzerWithAttributeExist(("\"" +textFieldEmailBenutzername.getText() + "\""),"Username");

				if(ben.getPasswort().equals(textFieldPasswort.getText())) {
					//checkt ob bereits ein Dokument existiert
					if(checkBoxNewCheckBox.isSelected()) {
						if(fm.doesExist("Userdata.txt")) {
							fm.delete("Userdata.txt");
						}
						fm.create("Userdata.txt");
						fm.write("Userdata.txt", "Username: " + textFieldEmailBenutzername.getText() + "\n " +"Passwort: " +textFieldPasswort.getText());
					}
					//Kreiert eine Statistik f�r den Benutzer falls dieser nicht bereits eine hat
					ThreadAnmeldung ta = new ThreadAnmeldung(ben);
					ta.start();
					System.out.println("[System] Login successfull");
					Hauptseite hs = new Hauptseite(ben);
					hs.setBenutzer(ben);
					dispose();
				} else {
					JOptionPane.showMessageDialog(this, "Falsches Passwort","Fehler",JOptionPane.ERROR_MESSAGE);
				}	
			}
			} catch (DB_FehlerException e1) {
				JOptionPane.showMessageDialog(this, "Falsches Passwort oder Nutzer existiert nicht","Fehler",JOptionPane.ERROR_MESSAGE);
			} catch (FileCreationError e2) {
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		protected void textFieldEmailBenutzername_focusGained(FocusEvent e) {
			if(textFieldEmailBenutzername.getText().equals("Email / Benutzername")) {
				textFieldEmailBenutzername.setText("");
			}
		}
		protected void registrierungButton_actionPerformed(ActionEvent e) {
			Registrierung rg = new Registrierung();
			dispose();
		}
	}