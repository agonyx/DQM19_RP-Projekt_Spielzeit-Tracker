package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sqlverbindung.DAO;
import sqlverbindung.DB_FehlerException;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Anmeldung extends JFrame implements ActionListener {

	private JPanel mainPane;
	private JTextField textFieldEmailBenutzername;
	private JTextField textFieldPasswort;
	private JButton exitButton;
	private JButton loginButton;
	private JCheckBox checkBoxNewCheckBox;
	private DAO d;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Anmeldung frame = new Anmeldung();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Anmeldung() {
		d = new DAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 230);
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(null);
		
		textFieldEmailBenutzername = new JTextField();
		textFieldEmailBenutzername.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldEmailBenutzername.setText("Email / Benutzername");
		textFieldEmailBenutzername.setBounds(10, 47, 314, 25);
		mainPane.add(textFieldEmailBenutzername);
		textFieldEmailBenutzername.setColumns(10);
		
		textFieldPasswort = new JTextField();
		textFieldPasswort.setText("Passwort");
		textFieldPasswort.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldPasswort.setColumns(10);
		textFieldPasswort.setBounds(10, 83, 314, 25);
		mainPane.add(textFieldPasswort);
		
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
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitButton) {
			ExitButtonActionPerformed(e);
		}
	}
	protected void ExitButtonActionPerformed(ActionEvent e) {
		dispose();
	}
	
	protected void loginButton_actionPerformed(ActionEvent e) {
		try {
			if (d.doesBenutzerAttributeExist(textFieldEmailBenutzername.getText(), "Username") ||
					d.doesBenutzerAttributeExist(textFieldEmailBenutzername.getText(), "Email")) {
				
			}
		} catch (DB_FehlerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}