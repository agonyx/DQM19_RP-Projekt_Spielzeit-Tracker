package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import io.FileCreationError;
import io.FileManager;
import sqlverbindung.Benutzer;
import sqlverbindung.DAO;
import sqlverbindung.DB_FehlerException;

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
	private DAO d;
	private FileManager fm;
	private JPasswordField textFieldPasswort;

	/**
	 * Create the frame.
	 */
	public Anmeldung() {
		initComponents();
		if(fm.doesExist("daohifguaio.txt")) {
			try {
				String data = fm.read("daohifguaio.txt");
				String datastring [] = data.split(" ");
				String username = datastring[1];
				String passwort = datastring[3];
				System.out.println(passwort);
				textFieldEmailBenutzername.setText(username);
				textFieldPasswort.setText(passwort);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		this.repaint();
	}
	private void initComponents() {
		d = new DAO();
		fm = new FileManager();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 230);
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(null);
		
		textFieldEmailBenutzername = new JTextField();
		textFieldEmailBenutzername.setToolTipText("Email/Benutzername");
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
		checkBoxNewCheckBox.setBounds(37, 115, 145, 41);
		mainPane.add(checkBoxNewCheckBox);
		
		textFieldPasswort = new JPasswordField();
		textFieldPasswort.setToolTipText("Passwort");
		textFieldPasswort.setBounds(10, 82, 314, 25);
		mainPane.add(textFieldPasswort);
	
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
			Benutzer b = d.getIfBenutzerWithAttributeExist(("\"" +textFieldEmailBenutzername.getText() + "\""),"Username");
			if(b.getPasswort().equals(textFieldPasswort.getText())) {
				if(checkBoxNewCheckBox.isSelected()) {
					if(fm.doesExist("daohifguaio.txt")) {
						fm.delete("daohifguaio.txt");
					}
					fm.create("daohifguaio.txt");
					fm.write("daohifguaio.txt", "Username: " + textFieldEmailBenutzername.getText() + "\n " +"Passwort: " +textFieldPasswort.getText());
				}
				//Hauptseite öffnen
				dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Falsches Passwort","Fehler",JOptionPane.ERROR_MESSAGE);
			}	
		} catch (DB_FehlerException e1) {
			JOptionPane.showMessageDialog(this, "Falsches Passwort oder Nutzer existiert nicht","Fehler",JOptionPane.ERROR_MESSAGE);
		} catch (FileCreationError e2) {
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	protected void textFieldEmailBenutzername_focusGained(FocusEvent e) {
		textFieldEmailBenutzername.setText("");
	}
}