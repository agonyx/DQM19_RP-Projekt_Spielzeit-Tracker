package gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JList;
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
import java.awt.event.ActionEvent;

public class Adminoberfläche extends JPanel implements ActionListener {
	private JLabel labelGegenstandHinzufügen;
	private JLabel labelAdminHinzufügen;
	private JLabel labelBenutzerID;
	private JTextField textFieldBenutzerID;
	private JLabel labelTypAuswahl;
	private JTextField textField_Bezeichnung;
	private JLabel labelBezeichnung;
	private JComboBox comboBoxTypAuswahl;
	private Button buttonDurchsuchen;

	/**
	 * Create the panel.
	 */
	public Adminoberfläche() {

		initGUI();
	}
	private void initGUI() {
		setBounds(new Rectangle(100, 100, 865, 725));
		setForeground(Color.BLACK);
		setLayout(null);
		{
			labelGegenstandHinzufügen = new JLabel("Gegenstand hinzuf\u00FCgen");
			labelGegenstandHinzufügen.setFont(new Font("Tahoma", Font.PLAIN, 20));
			labelGegenstandHinzufügen.setBounds(10, 11, 316, 35);
			add(labelGegenstandHinzufügen);
		}
		{
			labelAdminHinzufügen = new JLabel("Admin hinzuf\u00FCgen");
			labelAdminHinzufügen.setFont(new Font("Tahoma", Font.PLAIN, 20));
			labelAdminHinzufügen.setBounds(383, 16, 212, 25);
			add(labelAdminHinzufügen);
		}
		{
			labelBenutzerID = new JLabel("BenutzerID");
			labelBenutzerID.setBounds(383, 46, 84, 14);
			add(labelBenutzerID);
		}
		{
			textFieldBenutzerID = new JTextField();
			textFieldBenutzerID.setBounds(381, 60, 212, 27);
			add(textFieldBenutzerID);
			textFieldBenutzerID.setColumns(10);
		}
		{
			labelTypAuswahl = new JLabel("Typ ausw\u00E4hlen");
			labelTypAuswahl.setBounds(10, 46, 110, 14);
			add(labelTypAuswahl);
		}
		{
			textField_Bezeichnung = new JTextField();
			textField_Bezeichnung.setBounds(10, 109, 316, 25);
			add(textField_Bezeichnung);
			textField_Bezeichnung.setColumns(10);
		}
		{
			labelBezeichnung = new JLabel("Bezeichnung");
			labelBezeichnung.setBounds(10, 96, 96, 14);
			add(labelBezeichnung);
		}
		{
			comboBoxTypAuswahl = new JComboBox();
			comboBoxTypAuswahl.setModel(new DefaultComboBoxModel(new String[] {"Gesichtsbedeckung", "Kopfbedeckung", "Avatar"}));
			comboBoxTypAuswahl.setBounds(10, 62, 316, 25);
			add(comboBoxTypAuswahl);
		}
		{
			buttonDurchsuchen = new Button("Durchsuchen");
			buttonDurchsuchen.addActionListener(this);
			buttonDurchsuchen.setBounds(10, 140, 70, 22);
			add(buttonDurchsuchen);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonDurchsuchen) {
			buttonDurchsuchenActionPerformed(e);
		}
	}
	protected void buttonDurchsuchenActionPerformed(ActionEvent e) {

		JFileChooser chooser = new JFileChooser();
        // Erzeugung eines neuen Frames mit dem Titel "Dateiauswahl"
        JFrame meinJFrame = new JFrame("Dateiauswahl");
        // Wir setzen die Breite auf 450 und die Höhe 300 pixel
        meinJFrame.setSize(450,300);
        // Hole den ContentPane und füge diesem unseren JFileChooser hinzu      
        meinJFrame.getContentPane().add(chooser);
        // Wir lassen unseren Frame anzeigen
        meinJFrame.setVisible(true);
	}
}
