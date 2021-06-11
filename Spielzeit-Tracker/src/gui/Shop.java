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

import sqlverbindung.DAOItems;
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
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.UIManager;

public class Shop extends JPanel implements MouseListener {
	private JPanel panel;
	private JScrollPane scrollPane;
	private JPanel panelViewport;
	private int itemcount = 6;
	private JPanel panel_1;
	private JButton buyButton;
	private JLabel labelNewLabel;
	private Gesichter[] gesichter;
	private Gesichtsbedeckung[] gesichtsbedeckung;
	private Kopfbedeckung[] kopfbedeckung;
	private Oberteil[] oberteil;
	private Rahmen[] rahmen;
	private Koerper[] koerper;
	private DAOItems ditems;
	private JLabel labelDescription;
	private JLabel labelPrice;
	private HashMap<JLabel, String> label_itembezeichnung;
	private HashMap<JLabel, Integer> label_preis;


	public Shop() {
		setBackground(UIManager.getColor("Button.disabledShadow"));
		ditems = new DAOItems();
		label_itembezeichnung= new HashMap<>();
		label_preis = new HashMap<>();
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
				panel_1 = new JPanel();
				panel_1.setBackground(Color.WHITE);
				panel_1.setBounds(21, 11, 170, 270);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					labelNewLabel = new JLabel("AVATAR");
					labelNewLabel.setBounds(10, 11, 80, 14);
					panel_1.add(labelNewLabel);
				}
			}
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
			scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
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
			itemcount = gesichter.length + gesichtsbedeckung.length + kopfbedeckung.length + oberteil.length + rahmen.length;
		} catch (DB_FehlerException e) {
			e.printStackTrace();
		}
	}
	//Bereiche für alle Items werden generiert.

	private void createItemSections() {
		JPanel[] j = new JPanel[itemcount+1];
		JLabel[] l = new JLabel[itemcount+1];
		int tabx = 0;
		int taby = 11;
		int count = 0;
		int delay;

		for(int i = 0; i < j.length; i++) {
			if(count<2) {
				count++;
				j[i] = new JPanel();
				j[i].setBounds(10 + tabx, taby, 256, 256);
				j[i].setBorder(new EtchedBorder());
				l[i] = new JLabel();
				l[i].addMouseListener(this);
				j[i].add(l[i]);
				j[i].setVisible(true);
				tabx = tabx +332;
				panelViewport.add(j[i]);
			} else {
				taby = taby + 285;
				tabx = 0;
				count = 0;
				count++;
				j[i] = new JPanel();
				j[i].setBounds(10 + tabx, taby, 256, 256);
				j[i].setBorder(new EtchedBorder());
				j[i].addMouseListener(this);
				l[i] = new JLabel();
				l[i].addMouseListener(this);
				j[i].add(l[i]);
				j[i].setVisible(true);
				tabx = tabx +332;
				panelViewport.add(j[i]);
			}
		}

		//Ermittelt anhand der Anzahl der einzelenen Elemente den Pfad der ihnen zugewiesenen Bilder und zeigt sie an.
		for(int i = 0; i < gesichter.length; i++) {
			String gesichterPath = "image/gesichter/"+gesichter[i].getBild()+".png";
			ImageIcon icon = new ImageIcon(gesichterPath);
			l[i].setIcon(icon);
			l[i].setToolTipText("Gesicht "+(i+1));
			l[i].setName("Gesicht-" +gesichter[i].getGesichterID());
			label_itembezeichnung.put(l[i], gesichter[i].getBezeichnung());
			label_preis.put(l[i], gesichter[i].getPreis());
		}
		delay = gesichter.length;
		for(int i = 0; i < gesichtsbedeckung.length; i++) {
			String gesichtsbedeckungPath = null;
			if(i<10) {
				gesichtsbedeckungPath = "image/gesichtsbedeckung/GESICHTSBEDECKUNG_00"+i+".png";
			} else if(i<100) {
				gesichtsbedeckungPath = "image/gesichtsbedeckung/GESICHTSBEDECKUNG_0"+i+".png";
			} else if (i>100) {
				gesichtsbedeckungPath = "image/gesichtsbedeckung/GESICHTSBEDECKUNG_"+i+".png";
			}
			//System.out.println(gesichtsbedeckungPath);
			ImageIcon icon = new ImageIcon(gesichtsbedeckungPath);
			l[i+delay].setIcon(icon);
			l[i+delay].setToolTipText("Gesichtsbedeckung "+(i+1));
			l[i+delay].setName("Gesichtsbedeckung-"+gesichtsbedeckung[i].getGBID());
			label_itembezeichnung.put(l[i+delay],gesichtsbedeckung[i].getBezeichnung());
			label_preis.put(l[i+delay],gesichtsbedeckung[i].getPreis());
		}
		delay = delay + gesichtsbedeckung.length;
		for(int i = 0; i < kopfbedeckung.length; i++) {
			String kopfbedeckungPath = null;
			if(i<10) {
				kopfbedeckungPath = "image/kopfbedeckung/KOPFBEDECKUNG_00"+i+".png";
			} else if(i<100) {
				kopfbedeckungPath = "image/kopfbedeckung/KOPFBEDECKUNG_0"+i+".png";
			} else if (i>100) {
				kopfbedeckungPath = "image/kopfbedeckung/KOPFBEDECKUNG_"+i+".png";
			}
			//System.out.println(kopfbedeckungPath);
			ImageIcon icon = new ImageIcon(kopfbedeckungPath);
			l[i+delay].setIcon(icon);
			l[i+delay].setToolTipText("Kopfbedeckung "+(i+1));
			l[i+delay].setName("Kopfbedeckung-"+kopfbedeckung[i].getKopfbedeckungsID());
			label_itembezeichnung.put(l[i+delay],kopfbedeckung[i].getBezeichnung());
			label_preis.put(l[i+delay],kopfbedeckung[i].getPreis());
		}
		delay = delay + kopfbedeckung.length;
		for(int i = 0; i < oberteil.length; i++) {
			String oberteilPath = null;
			if(i<10) {
				oberteilPath = "image/oberteil/OBERTEIL_00"+i+".png";
			} else if(i<100) {
				oberteilPath = "image/oberteil/OBERTEIL_0"+i+".png";
			} else if (i>100) {
				oberteilPath = "image/oberteil/OBERTEIL_"+i+".png";
			}
			//System.out.println(oberteilPath);
			ImageIcon icon = new ImageIcon(oberteilPath);
			l[i+delay].setIcon(icon);
			l[i+delay].setToolTipText("Oberteil "+(i+1));
			l[i+delay].setName("Oberteil-"+oberteil[i].getOberteilID());
			label_itembezeichnung.put(l[i+delay],oberteil[i].getBezeichnung());
			label_preis.put(l[i+delay],oberteil[i].getPreis());
		}

		delay = delay + oberteil.length;
		for(int i = 0; i < rahmen.length; i++) {
			String rahmenPath = null;
			if(i<10) {
				rahmenPath = "image/rahmen/RAHMEN_00"+i+".png";
			} else if(i<100) {
				rahmenPath = "image/rahmen/RAHMEN_0"+i+".png";
			} else if (i>100) {
				rahmenPath = "image/rahmen/RAHMEN_"+i+".png";
			}
			//System.out.println(rahmenPath);
			ImageIcon icon = new ImageIcon(rahmenPath);
			l[i+delay].setIcon(icon);
			l[i+delay].setToolTipText("Rahmen "+(i+1));
			l[i+delay].setName("Rahmen-"+rahmen[i].getRahmenID());
			label_itembezeichnung.put(l[i+delay],rahmen[i].getBezeichnung());
			label_preis.put(l[i+delay],rahmen[i].getPreis());

		}
		delay = delay + rahmen.length;
		for(int i = 0; i < koerper.length; i++) {
			String koerperPath = null;
			if(i<10) {
				koerperPath = "image/avatare/AVATAR_00"+i+".png";
			} else if(i<100) {
				koerperPath = "image/avatare/AVATAR_0"+i+".png";
			} else if (i>100) {
				koerperPath = "image/avatare/AVATAR_"+i+".png";
			}
			//System.out.println(koerperPath);
			ImageIcon icon = new ImageIcon(koerperPath);
			l[i+delay].setIcon(icon);
			l[i+delay].setToolTipText("Körper "+(i+1));
			l[i+delay].setName("Koerper-"+koerper[i].getKoerperID());
			label_itembezeichnung.put(l[i+delay],koerper[i].getBezeichnung());
			label_preis.put(l[i+delay],koerper[i].getPreis());

		}
		panelViewport.setPreferredSize(new Dimension(621, taby+285));
		panelViewport.revalidate();
		panelViewport.repaint();
	}
	public void mouseClicked(MouseEvent me) {
		System.out.println("Click recognized");
		JLabel j  = (JLabel) me.getSource();
		labelDescription.setText("Bezeichnung: "+label_itembezeichnung.get(j));
		labelPrice.setText("Preis: "+label_preis.get(j));
		System.out.println(j.getName());
		System.out.println(j.getIcon().toString());
		

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
