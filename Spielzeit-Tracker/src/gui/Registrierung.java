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
import java.awt.event.ActionListener;
import java.sql.SQLException;
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


	/**
	 * Create the frame.
	 */
	public Registrierung() {
		initGUI();
		setVisible(true);
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 260);
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
			buttonNewButton.setBounds(25, 184, 148, 29);
			contentPane.add(buttonNewButton);
		}
		{
			buttonRegistrierung = new JButton("Registrierung");
			buttonRegistrierung.addActionListener(this);
			buttonRegistrierung.setBounds(238, 184, 140, 29);
			contentPane.add(buttonRegistrierung);
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
			
		//	if()
		//	{
		//		
		//	} else 
		//		{
		//			
		//		}		
			Anmeldung a = new Anmeldung();
			dispose();
		} catch(NumberFormatException e)
		{
			e.getMessage();
		}
	}
}
