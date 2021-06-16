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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;

import io.FileCreationError;
import io.FileManager;

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
	private JTextField textField_Bezeichnung;
	private JLabel labelBezeichnung;
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
		panel_1.setBounds(10, 11, 347, 213);
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
			comboBoxTypAuswahl.setBounds(10, 72, 316, 25);
			panel_1.add(comboBoxTypAuswahl);
			comboBoxTypAuswahl.setModel(
					new DefaultComboBoxModel(new String[] { "Gesichtsbedeckung", "Kopfbedeckung", "Avatar" }));
		}
		{
			labelBezeichnung = new JLabel("Bezeichnung");
			labelBezeichnung.setBounds(10, 108, 96, 14);
			panel_1.add(labelBezeichnung);
		}
		{
			textField_Bezeichnung = new JTextField();
			textField_Bezeichnung.setBounds(10, 122, 316, 25);
			panel_1.add(textField_Bezeichnung);
			textField_Bezeichnung.setColumns(10);
		}
		{
			buttonDurchsuchen = new Button("Durchsuchen");
			buttonDurchsuchen.setBounds(10, 153, 70, 22);
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
			buttonDurchsuchenActionPerformed(e);
		}
	}

	protected void buttonDurchsuchenActionPerformed(ActionEvent e) {

		JFileChooser chooser = new JFileChooser();
		// Erzeugung eines neuen Frames mit dem Titel "Dateiauswahl"

		/*
		 * JFrame meinJFrame = new JFrame("Dateiauswahl"); // Wir setzen die Breite auf
		 * 450 und die Höhe 300 pixel meinJFrame.setSize(450,300); // Hole den
		 * ContentPane und füge diesem unseren JFileChooser hinzu
		 * meinJFrame.getContentPane().add(chooser); // Wir lassen unseren Frame
		 * anzeigen meinJFrame.setVisible(true);
		 */
		int answer = chooser.showOpenDialog(this);
		if (answer == JFileChooser.APPROVE_OPTION) {
			String dateiendung = chooser.getSelectedFile().getName();
			dateiendung = dateiendung.substring(dateiendung.length() - 4);
			if (dateiendung.equals(".png")) {
				String typauswahl = comboBoxTypAuswahl.getSelectedItem().toString();
				FileManager fm = new FileManager();
				switch (typauswahl) {
				case "Gesichtsbedeckung":
					try {
						int namensID = bigpp.getAllGesichtsbedeckung().length;
						File fileChooser = chooser.getSelectedFile();
						String fileChooserPath = fileChooser.getAbsolutePath();
						String ziel = "image/gesichtsbedeckungen/GESICHTSBEDECKUNG_00" + namensID + ".png";
						File fileZiel = new File(ziel);
						fileZiel.mkdirs();
						
						
						InputStream is = null;
					    OutputStream os = null;
					    
					    is = new FileInputStream(fileChooserPath);
					    os = new FileOutputStream(ziel);

					    byte[] buf = new byte[1024];

					    int bytesRead;
					    	while ((bytesRead = is.read(buf)) > 0) {
					    		os.write(buf, 0, bytesRead);
					    	}

						
							
						//f.renameTo(image/gesichtsbedeckungen/GESICHTSBEDECKUNG_00 + namensID);

					} catch (DB_FehlerException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				
					break;

				case "Kopfbedeckung":
					break;
				}
				String dateiname = chooser.getSelectedFile().getName();
			}
			else {
				JOptionPane.showMessageDialog(this, "Die Datei ist keine verwendbare png-Datei", "Dateifehler", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	protected void btnHinzufuegenActionPerformed(ActionEvent e) {
		try {
			if (textFieldBenutzerID.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "Bitte geben sie eine BenutzerID ein!", "Fehler",
						JOptionPane.ERROR_MESSAGE);
			} else {
				System.out.println("swag");
				if (bigpp.getIfBenutzerWithAttributeExistWahr(textFieldBenutzerID.getText(), "BenutzerID")) {
					bigpp.updateAdminStatus(Integer.parseInt(textFieldBenutzerID.getText()), 1);
				}
			}
		} catch (DB_FehlerException e1) {
			e1.printStackTrace();
		}
	}

	protected void btnEntfernenActionPerformed(ActionEvent e) {
		try {
			if (textFieldBenutzerID.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "Bitte geben sie eine BenutzerID ein!", "Fehler",
						JOptionPane.ERROR_MESSAGE);
			} else {
				if (bigpp.getIfBenutzerWithAttributeExistWahr(textFieldBenutzerID.getText(), "BenutzerID")) {
					bigpp.updateAdminStatus(Integer.parseInt(textFieldBenutzerID.getText()), 0);
				}
			}
		} catch (DB_FehlerException e1) {
			e1.printStackTrace();
		}
	}
}
