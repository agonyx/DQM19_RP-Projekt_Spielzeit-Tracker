package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class Anmeldung extends JFrame {

	private JPanel mainPane;
	private JTextField textFieldEmailBenutzername;
	private JTextField textFieldPasswort;
	private JButton exitButton;
	private JButton loginButton;
	private JCheckBox checkBoxNewCheckBox;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 340);
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(null);
		
		textFieldEmailBenutzername = new JTextField();
		textFieldEmailBenutzername.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldEmailBenutzername.setText("Email / Benutzername");
		textFieldEmailBenutzername.setBounds(10, 47, 343, 25);
		mainPane.add(textFieldEmailBenutzername);
		textFieldEmailBenutzername.setColumns(10);
		
		textFieldPasswort = new JTextField();
		textFieldPasswort.setText("Passwort");
		textFieldPasswort.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldPasswort.setColumns(10);
		textFieldPasswort.setBounds(10, 83, 343, 25);
		mainPane.add(textFieldPasswort);
		
		JLabel loginLabel = new JLabel("Anmeldung");
		loginLabel.setBounds(178, 11, 162, 25);
		mainPane.add(loginLabel);
		loginLabel.setFont (loginLabel.getFont ().deriveFont (18.0f));
		
		exitButton = new JButton("Exit");
		exitButton.setBounds(10, 163, 109, 31);
		mainPane.add(exitButton);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(251, 163, 109, 31);
		mainPane.add(loginButton);
		
		checkBoxNewCheckBox = new JCheckBox("Passwort speichern");
		checkBoxNewCheckBox.setBounds(49, 115, 145, 41);
		mainPane.add(checkBoxNewCheckBox);
	}
}
