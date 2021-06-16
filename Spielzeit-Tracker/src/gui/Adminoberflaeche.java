package gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import sqlverbindung.Benutzer;
import sqlverbindung.DAOGetandSet;
import sqlverbindung.DAOSelect;
import sqlverbindung.DB_FehlerException;

public class Adminoberflaeche extends JPanel implements ActionListener {
	private JLabel labelGegenstandHinzufügen;
	private JLabel labelAdminHinzufügen;
	private JLabel labelBenutzerID;
	private JTextField textFieldBenutzerID;
	private JLabel labelTypAuswahl;
	private JComboBox comboBoxTypAuswahl;
	private Button buttonDurchsuchen;
	private JButton btnHinzufuegen;
	private JButton btnEntfernen;
	private DAOGetandSet bigpp = new DAOGetandSet();
	/**
	 * Create the panel.
	 */
	public Adminoberflaeche() {

		initGUI();
	}
	private void initGUI() {
		setBounds(new Rectangle(100, 100, 865, 725));
		setForeground(Color.BLACK);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(367, 11, 279, 151);
		add(panel);
		panel.setLayout(null);
		{
			labelAdminHinzufügen = new JLabel("Admin hinzuf\u00FCgen");
			labelAdminHinzufügen.setBounds(58, 16, 159, 25);
			panel.add(labelAdminHinzufügen);
			labelAdminHinzufügen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		{
			textFieldBenutzerID = new JTextField();
			textFieldBenutzerID.setBounds(32, 66, 217, 27);
			panel.add(textFieldBenutzerID);
			textFieldBenutzerID.setColumns(10);
		}
		{
			labelBenutzerID = new JLabel("BenutzerID");
			labelBenutzerID.setBounds(32, 52, 84, 14);
			panel.add(labelBenutzerID);
		}

		btnHinzufuegen = new JButton("Hinzuf\u00FCgen");
		btnHinzufuegen.addActionListener(this);
		btnHinzufuegen.setBounds(32, 104, 96, 23);
		panel.add(btnHinzufuegen);

		btnEntfernen = new JButton("Entfernen");
		btnEntfernen.addActionListener(this);
		btnEntfernen.setBounds(153, 104, 96, 23);
		panel.add(btnEntfernen);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 11, 347, 151);
		add(panel_1);
		panel_1.setLayout(null);
		{
			labelGegenstandHinzufügen = new JLabel("Gegenstand hinzuf\u00FCgen");
			labelGegenstandHinzufügen.setBounds(58, 11, 216, 35);
			panel_1.add(labelGegenstandHinzufügen);
			labelGegenstandHinzufügen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		{
			labelTypAuswahl = new JLabel("Typ ausw\u00E4hlen");
			labelTypAuswahl.setBounds(10, 57, 110, 14);
			panel_1.add(labelTypAuswahl);
		}
		{
			comboBoxTypAuswahl = new JComboBox();
			comboBoxTypAuswahl.setBounds(10, 72, 327, 25);
			panel_1.add(comboBoxTypAuswahl);
			comboBoxTypAuswahl.setModel(new DefaultComboBoxModel(new String[] {"Gesichter", "Gesichtsbedeckung", "Kopfbedeckung", "Koerper", "Oberteil", "Rahmen"}));
		}
		{
			buttonDurchsuchen = new Button("Hinzuf\u00FCgen");
			buttonDurchsuchen.setFont(new Font("Dialog", Font.PLAIN, 13));
			buttonDurchsuchen.setBounds(10, 103, 327, 38);
			panel_1.add(buttonDurchsuchen);
			buttonDurchsuchen.addActionListener(this);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEntfernen) {
			btnEntfernenActionPerformed(e);
		}
		if (e.getSource() == btnHinzufuegen) {
			btnHinzufuegenActionPerformed(e);
		}
		if (e.getSource() == buttonDurchsuchen) {
			try {
				buttonDurchsuchenActionPerformed(e);
			} catch (DB_FehlerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}


	protected void buttonDurchsuchenActionPerformed(ActionEvent e) throws DB_FehlerException{
		try{
			String typ = comboBoxTypAuswahl.getSelectedItem().toString();
			String bezeichnung = JOptionPane.showInputDialog("Geben sie eine Bezeichnung ein!");
			int preis = 0;
			
			if(!bezeichnung.isBlank()) {
				String preiswert = JOptionPane.showInputDialog("Geben sie einen Preis ein!");
				preis = Integer.parseInt(preiswert);
				
				if(!preiswert.isBlank()) {
					JFileChooser chooser = new JFileChooser();
					int choice = chooser.showOpenDialog(this);
					chooser.setDialogTitle("Dateiauswahl");
					
					if(choice == JFileChooser.APPROVE_OPTION) {
						String path = "image/" + typ + "/" + chooser.getSelectedFile().getName();
						Files.copy(Path.of(chooser.getSelectedFile().getAbsolutePath()), Path.of(path), StandardCopyOption.REPLACE_EXISTING );
						String Bild = chooser.getSelectedFile().getName();
						bigpp.hinzufuegenItem(typ, Bild, bezeichnung, preis);
					}
					
					if(choice == JFileChooser.CANCEL_OPTION) {
						System.out.println("Cancel");
					}

				}
				else {
					JOptionPane.showMessageDialog(this, "Bitte geben sie ein Preis ein!","Fehler",JOptionPane.ERROR_MESSAGE);
					buttonDurchsuchenActionPerformed(e);
				}

			}else{
				JOptionPane.showMessageDialog(this, "Bitte geben sie eine Bezeichnung ein!","Fehler",JOptionPane.ERROR_MESSAGE);
				buttonDurchsuchenActionPerformed(e);
			}
			
		}
		catch(IOException E) {
			E.printStackTrace();
		}
	}
	protected void btnHinzufuegenActionPerformed(ActionEvent e) {
		try {
			if (textFieldBenutzerID.getText().isBlank()){
				JOptionPane.showMessageDialog(this, "Bitte geben sie eine BenutzerID ein!","Fehler",JOptionPane.ERROR_MESSAGE);
			}
			else 
			{
				System.out.println("swag");
				if(bigpp.getIfBenutzerWithAttributeExistWahr(textFieldBenutzerID.getText(), "BenutzerID")){
					bigpp.updateAdminStatus(Integer.parseInt(textFieldBenutzerID.getText()), 1);
				}
			}
		} 
		catch (DB_FehlerException e1) {
			e1.printStackTrace();
		}
	}

	protected void btnEntfernenActionPerformed(ActionEvent e) {
		try {
			if (textFieldBenutzerID.getText().isBlank()){
				JOptionPane.showMessageDialog(this, "Bitte geben sie eine BenutzerID ein!","Fehler",JOptionPane.ERROR_MESSAGE);
			}
			else 
			{
				if(bigpp.getIfBenutzerWithAttributeExistWahr(textFieldBenutzerID.getText(), "BenutzerID")){
					bigpp.updateAdminStatus(Integer.parseInt(textFieldBenutzerID.getText()), 0);
				}
			}
		} 
		catch (DB_FehlerException e1) {
			e1.printStackTrace();
		}
	}
}
