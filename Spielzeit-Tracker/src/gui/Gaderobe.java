package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import sqlverbindung.Avatar;
import sqlverbindung.Benutzer;
import sqlverbindung.DAOGetandSet;
import sqlverbindung.DAOSelect;
import sqlverbindung.DB_FehlerException;
import sqlverbindung.Gesichter;
import sqlverbindung.Gesichtsbedeckung;
import sqlverbindung.Koerper;
import sqlverbindung.Kopfbedeckung;
import sqlverbindung.Oberteil;
import sqlverbindung.Rahmen;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class Gaderobe extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JPanel panelViewport;
	private JButton buttonAnziehen;
	private JFrame parent;
	private Gesichter[] gesichter;
	private Gesichtsbedeckung[] gesichtsbedeckung;
	private Kopfbedeckung[] kopfbedeckung;
	private Oberteil[] oberteil;
	private Rahmen[]  rahmen;
	private Koerper[] koerper;
	private DAOGetandSet ditems = new DAOGetandSet();
	private DAOSelect ds = new DAOSelect();
	private int itemcount = 0;
	private HashMap<JLabel, String> label_itembezeichnung = new HashMap<JLabel, String>();
	private HashMap<JLabel, Integer> label_id = new HashMap<JLabel, Integer>();
	private HashMap<JLabel, String> label_type = new HashMap<JLabel, String>();
	private Benutzer benutzer;
	private JLabel mEventLabel;
	private Avatar avatar;
	private JLabel labelDescription;
	private JLabel labelType;

	public Gaderobe() {
		setResizable(false);
		this.setAlwaysOnTop(true);
		try {
			benutzer = Hauptseite.getBenutzer();
			initComponents();
			initItems();
			createItemSections();
		} catch (DB_FehlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void initComponents() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 631, 792);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(0, 0, 621, 701);
			contentPane.add(scrollPane);
		}
		{
			panelViewport = new JPanel();
			panelViewport.setPreferredSize(new Dimension(621, 701));
			panelViewport.setBorder(new LineBorder(new Color(0, 0, 0)));
			scrollPane.setViewportView(panelViewport);
			panelViewport.setLayout(null);
		}
		{
			buttonAnziehen = new JButton("Anziehen");
			buttonAnziehen.addActionListener(this);
			buttonAnziehen.setBounds(516, 719, 89, 23);
			contentPane.add(buttonAnziehen);
		}
		{
			labelDescription = new JLabel("New label");
			labelDescription.setVisible(false);
			labelDescription.setBounds(10, 723, 170, 14);
			contentPane.add(labelDescription);
		}
		{
			labelType = new JLabel("New label");
			labelType.setDisplayedMnemonic(' ');
			labelType.setVisible(false);
			labelType.setBounds(190, 723, 170, 14);
			contentPane.add(labelType);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonAnziehen) {
			ButtonNewButtonActionPerformed(e);
		}
	}
	private void initItems() {
		try {
			gesichter = ditems.getAllGesichter();
			gesichtsbedeckung = ditems.getAllGesichtsbedeckung();
			kopfbedeckung = ditems.getAllKopfbedeckung();
			koerper = ditems.getAllKoerper();
			oberteil = ditems.getAllOberteil();
			rahmen = ditems.getAllRahmen();
			itemcount = gesichter.length + gesichtsbedeckung.length + kopfbedeckung.length + oberteil.length
					+ rahmen.length;
		} catch (DB_FehlerException e) {
			e.printStackTrace();
		}
	}
	// Bereiche für alle Items werden generiert.

	private void createItemSections() throws DB_FehlerException {
		itemcount = ditems.getOwnedItemcount(benutzer);
		JPanel[] j = new JPanel[itemcount];
		JLabel[] l = new JLabel[itemcount];
		int tabx = 0;
		int taby = 11;
		int count = 0;
		int delay;

		// JPanel und Label werden generiert
		for (int i = 0; i < j.length; i++) {
			if (count < 2) {
				count++;
				j[i] = new JPanel();
				j[i].setBounds(10 + tabx, taby, 256, 256);
				j[i].setBorder(new EtchedBorder());
				l[i] = new JLabel();
				l[i].addMouseListener(this);
				j[i].add(l[i]);
				j[i].setVisible(true);
				tabx = tabx + 332;
				panelViewport.add(j[i]);
			} else {
				taby = taby + 285;
				tabx = 0;
				count = 0;
				count++;
				j[i] = new JPanel();
				j[i].setBounds(10 + tabx, taby, 256, 256);
				j[i].setBorder(new EtchedBorder());
				l[i] = new JLabel();
				l[i].addMouseListener(this);
				j[i].add(l[i]);
				j[i].setVisible(true);
				tabx = tabx + 332;
				panelViewport.add(j[i]);
			}
		}

		// Ermittelt anhand der Anzahl der einzelenen Elemente den Pfad der ihnen
		// zugewiesenen Bilder und zeigt sie an.
		int length = 0;
		for (int i = 0; i < gesichter.length; i++) {
			if(ditems.itemOwnership(benutzer, gesichter[i].getGesichterID(), gesichter[i].getType())) {
				String gesichterPath = "image/gesichter/" + gesichter[i].getBild() + ".png";
				ImageIcon icon = new ImageIcon(gesichterPath);
				l[length].setIcon(icon);
				l[length].setToolTipText("Gesicht " + (i + 1));
				l[length].setName("Gesicht-" + gesichter[i].getGesichterID());
				label_itembezeichnung.put(l[length], gesichter[i].getBezeichnung());
				label_id.put(l[length], gesichter[i].getGesichterID());
				label_type.put(l[length], gesichter[i].getType());
				length++;
			}
		}

		delay = length;
		length = 0;
		for (int i = 0; i < gesichtsbedeckung.length; i++) {
			if(ditems.itemOwnership(benutzer, gesichtsbedeckung[i].getGBID(), gesichtsbedeckung[i].getType())) {
				String gesichtsbedeckungPath = "image/gesichtsbedeckung/" + gesichtsbedeckung[i].getBild() + ".png";
				ImageIcon icon = new ImageIcon(gesichtsbedeckungPath);
				l[length + delay].setIcon(icon);
				l[length + delay].setToolTipText("Gesichtsbedeckung " + (i + 1));
				l[length + delay].setName("Gesichtsbedeckung-" + gesichtsbedeckung[i].getGBID());
				label_itembezeichnung.put(l[length + delay], gesichtsbedeckung[i].getBezeichnung());
				label_id.put(l[length+delay],gesichtsbedeckung[i].getGBID());
				label_type.put(l[length+delay], gesichtsbedeckung[i].getType());
				length++;
			}
		}
		delay = delay + length;
		length = 0;
		for (int i = 0; i < kopfbedeckung.length; i++) {
			if(ditems.itemOwnership(benutzer, kopfbedeckung[i].getKopfbedeckungsID(), kopfbedeckung[i].getType())) {
				String kopfbedeckungPath = "image/kopfbedeckung/" + kopfbedeckung[i].getBild() + ".png";
				ImageIcon icon = new ImageIcon(kopfbedeckungPath);
				l[length + delay].setIcon(icon);
				l[length + delay].setToolTipText("Kopfbedeckung " + (i + 1));
				l[length + delay].setName("Kopfbedeckung-" + kopfbedeckung[i].getKopfbedeckungsID());
				label_itembezeichnung.put(l[length + delay], kopfbedeckung[i].getBezeichnung());
				label_id.put(l[length+delay],kopfbedeckung[i].getKopfbedeckungsID());
				label_type.put(l[length+delay], kopfbedeckung[i].getType());
				length++;
			}
		}
		delay = delay + length;
		length = 0;
		for (int i = 0; i < oberteil.length; i++) {
			if(ditems.itemOwnership(benutzer, oberteil[i].getOberteilID(), oberteil[i].getType())) {
				String oberteilPath = "image/oberteil/" + oberteil[i].getBild() + ".png";
				ImageIcon icon = new ImageIcon(oberteilPath);
				l[length + delay].setIcon(icon);
				l[length + delay].setToolTipText("Oberteil " + (i + 1));
				l[length + delay].setName("Oberteil-" + oberteil[i].getOberteilID());
				label_itembezeichnung.put(l[length + delay], oberteil[i].getBezeichnung());
				label_id.put(l[length+delay],oberteil[i].getOberteilID());
				label_type.put(l[length+delay], oberteil[i].getType());
				length++;
			}
		}
		delay = delay + length;
		length = 0;
		for (int i = 0; i < rahmen.length; i++) {
			if(ditems.itemOwnership(benutzer, rahmen[i].getRahmenID(), rahmen[i].getType())) {
				String rahmenPath = "image/rahmen/" + rahmen[i].getBild() + ".png";
				ImageIcon icon = new ImageIcon(rahmenPath);
				l[length + delay].setIcon(icon);
				l[length + delay].setToolTipText("Rahmen " + (i + 1));
				l[length + delay].setName("Rahmen-" + (i + 1));
				label_itembezeichnung.put(l[i + delay], rahmen[i].getBezeichnung());
				label_id.put(l[length+delay],rahmen[i].getRahmenID());
				label_type.put(l[length+delay], rahmen[i].getType());
				length++;
			}
		}
		delay = delay + length;
		length = 0;
		for (int i = 0; i < koerper.length; i++) {
			if(ditems.itemOwnership(benutzer, koerper[i].getKoerperID(), koerper[i].getType())) {
				String koerperPath = "image/avatare/" + koerper[i].getBild() + ".png";
				ImageIcon icon = new ImageIcon(koerperPath);
				l[length + delay].setIcon(icon);
				l[length + delay].setToolTipText("Koerper " + (i + 1));
				l[length + delay].setName("Koerper-" + koerper[i].getKoerperID());
				label_itembezeichnung.put(l[i + delay], koerper[i].getBezeichnung());
				label_id.put(l[length+delay],koerper[i].getKoerperID());
				label_type.put(l[length+delay], koerper[i].getType());
			}
		}
		panelViewport.setPreferredSize(new Dimension(621, taby + 285));
		panelViewport.revalidate();
		panelViewport.repaint();
	}
	protected void ButtonNewButtonActionPerformed(ActionEvent e) {
		String standardKoerper = "";
		String standardGesicht = "";
		String standardGesichtsbedeckung = "";
		String standardKopfbedeckung = "";
		String standardOberteil = "";
		try {
			if(String.valueOf(avatar.getKoerperid())!= null&& avatar.getKoerperid() != 0)  {
				standardKoerper = ds.selectKoerper(avatar.getKoerperid()).getBild();
			}
			if(String.valueOf(avatar.getGesichterid())!= null && avatar.getGesichterid() != 0)  {
				standardGesicht = ds.selectGesicht(avatar.getGesichterid()).getBild();
			}
			if(String.valueOf(avatar.getGbid())!= null&& avatar.getGbid() != 0)  {
				standardGesichtsbedeckung = ds.selectGesichtsbedeckung(avatar.getGbid()).getBild();
			} if(String.valueOf(avatar.getKopfbedeckungid())!= null&& avatar.getKopfbedeckungid() != 0)  {
				standardKopfbedeckung = ds.selectKopfbedeckung(avatar.getKopfbedeckungid()).getBild();
			} if(String.valueOf(avatar.getOberteilid())!= null&& avatar.getOberteilid() != 0)  {
				standardOberteil = ds.selectOberteil(avatar.getOberteilid()).getBild();
			}
			String jName = mEventLabel.getName();
			int jID = Integer.parseInt(jName.substring(jName.length() -1));
			jName = jName.substring(0, jName.length()-2);

			switch (jName) {

			case "Koerper":
				Hauptseite.updateAvatarPicture(ds.selectKoerper(jID).getBild(), standardGesicht , standardGesichtsbedeckung, ds.selectKopfbedeckung(jID).getBild() , standardOberteil);
				avatar.setKoerperid(ds.selectKoerper(jID).getKoerperID());
				break;
			case "Gesicht":
				Hauptseite.updateAvatarPicture(standardKoerper, ds.selectGesicht(jID).getBild(), standardGesichtsbedeckung, standardKopfbedeckung , standardOberteil);
				avatar.setGesichterid(ds.selectGesicht(jID).getGesichterID());
				break;
			case "Gesichtsbedeckung":
				Hauptseite.updateAvatarPicture(standardKoerper, standardGesicht , ds.selectGesichtsbedeckung(jID).getBild(), standardKopfbedeckung , standardOberteil);
				avatar.setGbid(ds.selectGesichtsbedeckung(jID).getGBID());
				break;
			case "Kopfbedeckung":
				Hauptseite.updateAvatarPicture(standardKoerper, standardGesicht , standardGesichtsbedeckung, ds.selectKopfbedeckung(jID).getBild() , standardOberteil);
				avatar.setKopfbedeckungid(ds.selectKopfbedeckung(jID).getKopfbedeckungsID());
				break;
			case "Oberteil":
				Hauptseite.updateAvatarPicture(standardKoerper, standardGesicht , standardGesichtsbedeckung, standardKopfbedeckung , ds.selectOberteil(jID).getBild());
				avatar.setOberteilid(ds.selectOberteil(jID).getOberteilID());
				break;
			}
			ditems.setAvatar(benutzer, avatar);
			Hauptseite.setAvatarBackup(avatar);
			dispose();
		}catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Fehler!");
			dispose();
		}
	}
	@Override
	public void mouseClicked(MouseEvent me) {
		avatar = Hauptseite.getAvatar();

		if(mEventLabel != null) {
			if(mEventLabel != (JLabel) me.getSource()) {

				JPanel d = (JPanel) mEventLabel.getParent();
				d.setBorder(new EtchedBorder());
				mEventLabel  = (JLabel) me.getSource();
				JPanel dd = (JPanel) mEventLabel.getParent();
				dd.setBorder(new LineBorder(Color.BLUE, 3));
			} 
		}else {
			mEventLabel  = (JLabel) me.getSource();
			JPanel dd = (JPanel) mEventLabel.getParent();
			dd.setBorder(new LineBorder(Color.BLUE, 3));
		}
		labelDescription.setVisible(true);
		labelType.setVisible(true);
		labelDescription.setText(label_itembezeichnung.get(mEventLabel));
		labelType.setText(label_type.get(mEventLabel));

	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
