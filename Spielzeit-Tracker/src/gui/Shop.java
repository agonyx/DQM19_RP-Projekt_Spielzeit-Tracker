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
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Shop extends JPanel implements MouseListener, ActionListener {

	private JPanel panel;
	private JScrollPane scrollPane;
	private JPanel panelViewport;
	private int itemcount = 6;
	private JButton buyButton;
	private Gesichter[] gesichter;
	private Gesichtsbedeckung[] gesichtsbedeckung;
	private Kopfbedeckung[] kopfbedeckung;
	private Oberteil[] oberteil;
	private Rahmen[]  rahmen;
	private Koerper[] koerper;
	private DAOGetandSet ditems;
	private DAOSelect ds;
	private Avatar avatar;
	private Benutzer benutzer;
	private Hauptseite hs;
	private JLabel labelDescription;
	private JLabel labelPrice;
	private JLabel mEventLabel;
	private HashMap<JLabel, String> label_itembezeichnung;
	private HashMap<JLabel, Integer> label_preis;
	private HashMap<JLabel, Integer> label_id;
	private HashMap<JLabel, String> label_type;

	public Shop(Hauptseite hs) {
		this.hs = hs;
		benutzer = hs.getBenutzer();
		setBackground(UIManager.getColor("Button.disabledShadow"));
		ditems = new DAOGetandSet();
		ds = new DAOSelect();
		label_itembezeichnung = new HashMap<>();
		label_preis = new HashMap<>();
		label_id = new HashMap<>();
		label_type = new HashMap<>();
		initComponents();
		initItems();
		try {
			createItemSections();
		} catch (DB_FehlerException e) {
			e.printStackTrace();
		}
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
				buyButton.addActionListener(this);
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
		System.out.println(itemcount);
		itemcount = itemcount - ditems.getOwnedItemcount(benutzer);
		System.out.println(itemcount);
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
		int length = 0;
		for (int i = 0; i < gesichter.length; i++) {
			if(!ditems.itemOwnership(benutzer, gesichter[i].getGesichterID(), gesichter[i].getType())) {
				String gesichterPath = "image/gesichter/" + gesichter[i].getBild() + ".png";
				ImageIcon icon = new ImageIcon(gesichterPath);
				l[length].setIcon(icon);
				l[length].setToolTipText("Gesicht " + (i + 1));
				l[length].setName("Gesicht-" + gesichter[i].getGesichterID());
				label_itembezeichnung.put(l[length], gesichter[i].getBezeichnung());
				label_preis.put(l[length], gesichter[i].getPreis());
				label_id.put(l[length], gesichter[i].getGesichterID());
				label_type.put(l[length], gesichter[i].getType());
				length++;
			}
		}

		delay = length;
		length = 0;
		for (int i = 0; i < gesichtsbedeckung.length; i++) {
			if(!ditems.itemOwnership(benutzer, gesichtsbedeckung[i].getGBID(), gesichtsbedeckung[i].getType())) {
				String gesichtsbedeckungPath = "image/gesichtsbedeckung/" + gesichtsbedeckung[i].getBild() + ".png";
				ImageIcon icon = new ImageIcon(gesichtsbedeckungPath);
				l[length + delay].setIcon(icon);
				l[length + delay].setToolTipText("Gesichtsbedeckung " + (i + 1));
				l[length + delay].setName("Gesichtsbedeckung-" + gesichtsbedeckung[i].getGBID());
				label_itembezeichnung.put(l[length + delay], gesichtsbedeckung[i].getBezeichnung());
				label_preis.put(l[length + delay], gesichtsbedeckung[i].getPreis());
				label_id.put(l[length+delay],gesichtsbedeckung[i].getGBID());
				label_type.put(l[length+delay], gesichtsbedeckung[i].getType());
				length++;
			}
		}
		delay = delay + length;
		length = 0;
		for (int i = 0; i < kopfbedeckung.length; i++) {
			if(!ditems.itemOwnership(benutzer, kopfbedeckung[i].getKopfbedeckungsID(), kopfbedeckung[i].getType())) {
				String kopfbedeckungPath = "image/kopfbedeckung/" + kopfbedeckung[i].getBild() + ".png";
				ImageIcon icon = new ImageIcon(kopfbedeckungPath);
				l[length + delay].setIcon(icon);
				l[length + delay].setToolTipText("Kopfbedeckung " + (i + 1));
				l[length + delay].setName("Kopfbedeckung-" + kopfbedeckung[i].getKopfbedeckungsID());
				label_itembezeichnung.put(l[length + delay], kopfbedeckung[i].getBezeichnung());
				label_preis.put(l[length + delay], kopfbedeckung[i].getPreis());
				label_id.put(l[length+delay],kopfbedeckung[i].getKopfbedeckungsID());
				label_type.put(l[length+delay], kopfbedeckung[i].getType());
				length++;
			}
		}
		delay = delay + length;
		length = 0;
		for (int i = 0; i < oberteil.length; i++) {
			if(!ditems.itemOwnership(benutzer, oberteil[i].getOberteilID(), oberteil[i].getType())) {
				String oberteilPath = "image/oberteil/" + oberteil[i].getBild() + ".png";
				ImageIcon icon = new ImageIcon(oberteilPath);
				l[length + delay].setIcon(icon);
				l[length + delay].setToolTipText("Oberteil " + (i + 1));
				l[length + delay].setName("Oberteil-" + oberteil[i].getOberteilID());
				label_itembezeichnung.put(l[length + delay], oberteil[i].getBezeichnung());
				label_preis.put(l[length + delay], oberteil[i].getPreis());
				label_id.put(l[length+delay],oberteil[i].getOberteilID());
				label_type.put(l[length+delay], oberteil[i].getType());
				length++;
			}
		}
		delay = delay + length;
		length = 0;
		for (int i = 0; i < rahmen.length; i++) {
			if(!ditems.itemOwnership(benutzer, rahmen[i].getRahmenID(), rahmen[i].getType())) {
				String rahmenPath = "image/rahmen/" + rahmen[i].getBild() + ".png";
				ImageIcon icon = new ImageIcon(rahmenPath);
				l[length + delay].setIcon(icon);
				l[length + delay].setToolTipText("Rahmen " + (i + 1));
				l[length + delay].setName("Rahmen-" + (i + 1));
				label_itembezeichnung.put(l[i + delay], rahmen[i].getBezeichnung());
				label_preis.put(l[length + delay], rahmen[i].getPreis());
				label_id.put(l[length+delay],rahmen[i].getRahmenID());
				label_type.put(l[length+delay], rahmen[i].getType());
				length++;
			}
		}
		delay = delay + length;
		length = 0;
		for (int i = 0; i < koerper.length; i++) {
			if(!ditems.itemOwnership(benutzer, koerper[i].getKoerperID(), koerper[i].getType())) {
				String koerperPath = "image/avatare/" + koerper[i].getBild() + ".png";
				ImageIcon icon = new ImageIcon(koerperPath);
				l[length + delay].setIcon(icon);
				l[length + delay].setToolTipText("Koerper " + (i + 1));
				l[length + delay].setName("Koerper-" + koerper[i].getKoerperID());
				label_itembezeichnung.put(l[i + delay], koerper[i].getBezeichnung());
				label_preis.put(l[length + delay], koerper[i].getPreis());
				label_id.put(l[length+delay],koerper[i].getKoerperID());
				label_type.put(l[length+delay], koerper[i].getType());
			}
		}
		panelViewport.setPreferredSize(new Dimension(621, taby + 285));
		panelViewport.revalidate();
		panelViewport.repaint();
	}

	public void mouseClicked(MouseEvent me) {
		avatar = hs.getAvatar();
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
			String jName = mEventLabel.getName();
			int jID = Integer.parseInt(jName.substring(jName.length() -1));
			jName = jName.substring(0, jName.length()-2);

			switch (jName) {
			case "Koerper":
				hs.updateAvatarPicture(ds.selectKoerper(jID).getBild(), standardGesicht , standardGesichtsbedeckung, ds.selectKopfbedeckung(jID).getBild() , standardOberteil);
				break;
			case "Gesicht":
				hs.updateAvatarPicture(standardKoerper, ds.selectGesicht(jID).getBild(), standardGesichtsbedeckung, standardKopfbedeckung , standardOberteil);
				break;
			case "Gesichtsbedeckung":
				hs.updateAvatarPicture(standardKoerper, standardGesicht , ds.selectGesichtsbedeckung(jID).getBild(), standardKopfbedeckung , standardOberteil);
				break;
			case "Kopfbedeckung":
				hs.updateAvatarPicture(standardKoerper, standardGesicht , standardGesichtsbedeckung, ds.selectKopfbedeckung(jID).getBild() , standardOberteil);
				break;
			case "Oberteil":
				hs.updateAvatarPicture(standardKoerper, standardGesicht , standardGesichtsbedeckung, standardKopfbedeckung , ds.selectOberteil(jID).getBild());
				break;
			}
			labelDescription.setText(label_itembezeichnung.get(mEventLabel));
			
			labelPrice.setText("Preis: "+String.valueOf(label_preis.get(mEventLabel)));

		} 
		catch(DB_FehlerException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buyButton) {
			BuyButtonActionPerformed(e);
		}
	}
	protected void BuyButtonActionPerformed(ActionEvent e) {
		try {
			if (mEventLabel != null) {
				if(ditems.doesItemExist(label_type.get(mEventLabel), label_id.get(mEventLabel))) {
					if(!ditems.itemOwnership(benutzer, label_id.get(mEventLabel),label_type.get(mEventLabel))) {
						if (benutzer.getPunkte() >= label_preis.get(mEventLabel)) {
							System.out.println("[System] Kauf erfolgreich!");
							ditems.createBuyEntry(benutzer, label_id.get(mEventLabel), label_type.get(mEventLabel));
							benutzer.setPunkte(benutzer.getPunkte()-label_preis.get(mEventLabel));
							ditems.setPoints(benutzer, benutzer.getPunkte());
							createItemSections();
							this.repaint();
							this.validate();
						}else {
							JOptionPane.showMessageDialog(this, "Unzureichender Punktestand","Fehler",JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		} catch (DB_FehlerException e1) {
			e1.printStackTrace();
		}
	}
}
