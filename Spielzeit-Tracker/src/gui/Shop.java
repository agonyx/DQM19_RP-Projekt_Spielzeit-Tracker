package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

public class Shop extends JPanel implements MouseListener {

	private JPanel panel;
	private JScrollPane scrollPane;
	private JPanel panelViewport;
	private int itemcount = 6;
	private JButton buyButton;
	private Gesichter[] gesichter;
	private Gesichtsbedeckung[] gesichtsbedeckung;
	private Kopfbedeckung[] kopfbedeckung;
	private Oberteil[] oberteil;
	private Rahmen[] rahmen;
	private Koerper[] koerper;
	private DAOGetandSet ditems;
	private DAOSelect ds;
	private Avatar avatar;
	private Benutzer benutzer;
	private Hauptseite hs;
	private JLabel labelDescription;
	private JLabel labelPrice;
	private HashMap<JLabel, String> label_itembezeichnung;
	private HashMap<JLabel, Integer> label_preis;

	public Shop(Hauptseite hs) {
		setBackground(UIManager.getColor("Button.disabledShadow"));
		ditems = new DAOGetandSet();
		ds = new DAOSelect();
		label_itembezeichnung = new HashMap<>();
		label_preis = new HashMap<>();
		this.hs = hs;
		benutzer = hs.getBenutzer();
		initComponents();
		initItems();
		createItemSections();
	}

	private void initComponents() {
		setLayout(null);
		setBounds(30, 213, 865, 725);
		{
			panel = new JPanel();
			panel.setBackground(UIManager.getColor("Button.background"));
			panel.setBounds(10, 11, 215, 701);
			add(panel);
			panel.setLayout(null);
			{
				buyButton = new JButton("Buy");
				buyButton.setBounds(10, 667, 181, 23);
				panel.add(buyButton);
			}
			{
				labelDescription = new JLabel("");
				labelDescription.setBounds(21, 561, 170, 14);
				panel.add(labelDescription);
			}
			{
				labelPrice = new JLabel("");
				labelPrice.setBounds(21, 586, 170, 14);
				panel.add(labelPrice);
			}
		}
		{
			scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(228, 11, 621, 701);
			add(scrollPane);
			{
				panelViewport = new JPanel();
				panelViewport.setPreferredSize(new Dimension(621, 701));
				panelViewport.setBorder(new LineBorder(new Color(0, 0, 0)));
				scrollPane.setViewportView(panelViewport);
				panelViewport.setLayout(null);
			}
		}

	}

	private void init() {
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

	private void createItemSections() {
		JPanel[] j = new JPanel[itemcount + 1];
		JLabel[] l = new JLabel[itemcount + 1];
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
		for (int i = 0; i < gesichter.length; i++) {
			String gesichterPath = "image/gesichter/" + gesichter[i].getBild() + ".png";
			ImageIcon icon = new ImageIcon(gesichterPath);
			l[i].setIcon(icon);
			l[i].setToolTipText("Gesicht " + (i + 1));
			l[i].setName("Gesicht-" + gesichter[i].getGesichterID());
			label_itembezeichnung.put(l[i], gesichter[i].getBezeichnung());
			label_preis.put(l[i], gesichter[i].getPreis());
		}
		delay = gesichter.length;
		for (int i = 0; i < gesichtsbedeckung.length; i++) {
			String gesichtsbedeckungPath = "image/gesichtsbedeckung/" + gesichtsbedeckung[i].getBild() + ".png";
			ImageIcon icon = new ImageIcon(gesichtsbedeckungPath);
			l[i + delay].setIcon(icon);
			l[i + delay].setToolTipText("Gesichtsbedeckung " + (i + 1));
			l[i + delay].setName("Gesichtsbedeckung-" + gesichtsbedeckung[i].getGBID());
			label_itembezeichnung.put(l[i + delay], gesichtsbedeckung[i].getBezeichnung());
			label_preis.put(l[i + delay], gesichtsbedeckung[i].getPreis());
		}
		delay = delay + gesichtsbedeckung.length;
		for (int i = 0; i < kopfbedeckung.length; i++) {
			String kopfbedeckungPath = "image/kopfbedeckung/" + kopfbedeckung[i].getBild() + ".png";
			ImageIcon icon = new ImageIcon(kopfbedeckungPath);
			l[i + delay].setIcon(icon);
			l[i + delay].setToolTipText("Kopfbedeckung " + (i + 1));
			l[i + delay].setName("Kopfbedeckung-" + kopfbedeckung[i].getKopfbedeckungsID());
			label_itembezeichnung.put(l[i + delay], kopfbedeckung[i].getBezeichnung());
			label_preis.put(l[i + delay], kopfbedeckung[i].getPreis());
		}
		delay = delay + kopfbedeckung.length;
		for (int i = 0; i < oberteil.length; i++) {
			String oberteilPath = "image/oberteil/" + oberteil[i].getBild() + ".png";
			ImageIcon icon = new ImageIcon(oberteilPath);
			l[i + delay].setIcon(icon);
			l[i + delay].setToolTipText("Oberteil " + (i + 1));
			l[i + delay].setName("Oberteil-" + oberteil[i].getOberteilID());
			label_itembezeichnung.put(l[i + delay], oberteil[i].getBezeichnung());
			label_preis.put(l[i + delay], oberteil[i].getPreis());
		}

		delay = delay + oberteil.length;
		for (int i = 0; i < rahmen.length; i++) {
			String rahmenPath = "image/rahmen/" + rahmen[i].getBild() + ".png";
			ImageIcon icon = new ImageIcon(rahmenPath);
			l[i + delay].setIcon(icon);
			l[i + delay].setToolTipText("Rahmen " + (i + 1));
			l[i + delay].setName("Rahmen-" + (i + 1));
			label_itembezeichnung.put(l[i + delay], rahmen[i].getBezeichnung());
			label_preis.put(l[i + delay], rahmen[i].getPreis());

		}
		delay = delay + rahmen.length;
		for (int i = 0; i < koerper.length; i++) {
			String koerperPath = "image/avatare/" + koerper[i].getBild() + ".png";
			ImageIcon icon = new ImageIcon(koerperPath);
			l[i + delay].setIcon(icon);
			l[i + delay].setToolTipText("Körper " + (i + 1));
			l[i + delay].setName("Koerper-" + koerper[i].getKoerperID());
			label_itembezeichnung.put(l[i + delay], koerper[i].getBezeichnung());
			label_preis.put(l[i + delay], koerper[i].getPreis());
		}
		panelViewport.setPreferredSize(new Dimension(621, taby + 285));
		panelViewport.revalidate();
		panelViewport.repaint();
	}

	public void mouseClicked(MouseEvent me) {
		avatar = initAvatar(benutzer);
		try {
		String StandardKoerper = ds.selectKoerper(avatar.getKoerperid()).getBild();
		String StandardGesicht = ds.selectGesicht(avatar.getGesichterid()).getBild();
		String StandardGesichtsbedeckung = ds.selectGesichtsbedeckung(avatar.getGbid()).getBild();
		String StandardKopfbedeckung = ds.selectKopfbedeckung(avatar.getKopfbedeckungid()).getBild();
		String StandardOberteil = ds.selectOberteil(avatar.getOberteilid()).getBild();
		
		JLabel j  = (JLabel) me.getSource();
		String jName = j.getName();
		int jID = Integer.parseInt(jName.substring(jName.length() -1));
		jName = jName.substring(0, jName.length()-2);
		
		switch (jName) {
		case "Koerper":
			hs.updateAvatarPicture(ds.selectKoerper(jID).getBild(), StandardGesicht , StandardGesichtsbedeckung, ds.selectKopfbedeckung(jID).getBild() , StandardOberteil);
			break;
		case "Gesicht":
			hs.updateAvatarPicture(StandardKoerper, ds.selectGesicht(jID).getBild(), StandardGesichtsbedeckung, StandardKopfbedeckung , StandardOberteil);
			break;
		case "Gesichtsbedeckung":
			hs.updateAvatarPicture(StandardKoerper, StandardGesicht , ds.selectGesichtsbedeckung(jID).getBild(), StandardKopfbedeckung , StandardOberteil);
			break;
		case "Kopfbedeckung":
			hs.updateAvatarPicture(StandardKoerper, StandardGesicht , StandardGesichtsbedeckung, ds.selectKopfbedeckung(jID).getBild() , StandardOberteil);
			break;
		case "Oberteil":
			hs.updateAvatarPicture(StandardKoerper, StandardGesicht , StandardGesichtsbedeckung, StandardKopfbedeckung , ds.selectOberteil(jID).getBild());
			break;
		}
		labelDescription.setText(label_itembezeichnung.get(j));
		labelPrice.setText("Preis: "+label_preis.get(j));
		
		} 
		catch(DB_FehlerException e) {
			e.printStackTrace();
		}
	}

	public Avatar initAvatar(Benutzer b) {
		try {
			avatar = ds.selectUserAvatar(b.getID());
		} catch (DB_FehlerException e) {
			e.printStackTrace();
		}
		return avatar;
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
