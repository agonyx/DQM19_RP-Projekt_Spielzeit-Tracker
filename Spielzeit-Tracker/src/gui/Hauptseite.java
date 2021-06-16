package gui;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lukaspradel.steamapi.core.exception.SteamApiException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import sqlverbindung.Avatar;
import sqlverbindung.Benutzer;
import sqlverbindung.DAOGetandSet;
import sqlverbindung.DAOSelect;
import sqlverbindung.DAOStatistik;
import sqlverbindung.DB_FehlerException;
import sqlverbindung.Spiele;
import sqlverbindung.Spielzeit;
import sqlverbindung.Statistik;
import sqlverbindung.SteamAPI;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import java.text.SimpleDateFormat;  
import java.util.Date;

public class Hauptseite extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel taskbar;
	private JPanel avatarGesamt;
	private JLabel lblGesichtsbedeckung;
	private JLabel lblKopfbedeckung;
	private JLabel lblOberteil;
	private JLabel lblGesicht;
	private JLabel lblAvatar;
	private JButton btnProfil;
	private JButton btnShop;
	private JButton btnStatistiken;
	private JButton btnAbmelden;
	private JPanel panel;
	private HashMap<Views,JPanel> panels;
	private JButton buttonAdmin;
	private static Benutzer benutzer;
	private DAOGetandSet d = new DAOGetandSet();
	private SteamAPI steam = new SteamAPI();
	private Shop shop;
	private Adminoberflaeche ao;
	private DAOStatistik ds = new DAOStatistik();
	private DAOSelect dsel = new DAOSelect();
	private Profil p;
	private JLabel labelPunkte;
	private static Avatar avatar;
	private static HashMap<Integer, Integer> spielzeiten = new HashMap<Integer,Integer>();
	private static int totalPlaytime;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private Date date = new Date();
	private Avatar avatarBackup;
	public Hauptseite(Benutzer bb) {
		setResizable(false);
		benutzer = bb;
		try {
			addPlaytime(bb);
			calcPoints(bb);
			dayBonus(bb);
			setPlaytimeDB(bb);
			avatar = d.getAvatar(bb);
			panels = new HashMap();
			initGUI();
			avatarBackup = avatar;
			p = new Profil(benutzer);
			panels.put(Views.PROFIl, p);
			switchTo(Views.PROFIl);
		} catch (DB_FehlerException e) {
			try {
				d.createDefaultAvatar(bb);
			} catch (DB_FehlerException e1) {
				e1.printStackTrace();
			}
		} catch (SteamApiException e) {			
			JOptionPane.showMessageDialog(this, "Es gibt einen Fehler mit der SteamAPI oder deiner SteamID :c", "Fehler",JOptionPane.ERROR_MESSAGE);
			dispose();
		}
	}
	//Panel wechseln
	public void switchTo(Views v) {
		contentPane.remove(panel);
		panel = panels.get(v);
		panel.setBounds(302, 0, 865, 725);
		contentPane.add(panel);
		try {
			updateAvatarPicture(avatarBackup);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "KRITISCHER FEHLER", "Fehler",JOptionPane.ERROR_MESSAGE);
			dispose();
		}

		this.validate();
		this.repaint();
	}
	public void setBenutzer(Benutzer ben) {
		benutzer = ben;

	}
	public static Benutzer getBenutzer() {
		return benutzer;
	}
	public static Avatar getAvatar() { 
		return avatar;
	}
	private double minutesToHours(int doouble) {
		return (doouble/60);
	}
	private void initGUI() {
		setTitle("Spielzeitracker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1180, 753);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		taskbar = new JPanel();
		taskbar.setBackground(Color.WHITE);
		taskbar.setLayout(null);
		taskbar.setBounds(0, 0, 292, 725);
		contentPane.add(taskbar);

		avatarGesamt = new JPanel();
		avatarGesamt.setLayout(null);
		avatarGesamt.setBounds(10, 0, 256, 256);
		taskbar.add(avatarGesamt);

		lblGesichtsbedeckung = new JLabel("");
		lblGesichtsbedeckung.setBounds(0, 0, 256, 256);
		avatarGesamt.add(lblGesichtsbedeckung);

		lblKopfbedeckung = new JLabel("");
		lblKopfbedeckung.setBounds(0, 0, 256, 256);
		avatarGesamt.add(lblKopfbedeckung);

		lblOberteil = new JLabel("");
		lblOberteil.setBounds(0, 0, 256, 256);
		avatarGesamt.add(lblOberteil);

		lblGesicht = new JLabel("");
		lblGesicht.setBounds(0, 0, 256, 256);
		avatarGesamt.add(lblGesicht);

		lblAvatar = new JLabel("");
		lblAvatar.setBounds(0, 0, 256, 256);
		avatarGesamt.add(lblAvatar);

		btnProfil = new JButton("Profil");
		btnProfil.addActionListener(this);
		btnProfil.setBounds(10, 600, 270, 66);
		taskbar.add(btnProfil);

		btnShop = new JButton("Shop");
		btnShop.addActionListener(this);
		btnShop.setBounds(10, 523, 270, 66);
		taskbar.add(btnShop);

		if(benutzer.isAdmin()) {
			btnAbmelden = new JButton("Abmelden");
			btnAbmelden.addActionListener(this);
			btnAbmelden.setBounds(10, 677, 137, 23);
			taskbar.add(btnAbmelden);

			buttonAdmin = new JButton("Admin");
			buttonAdmin.addActionListener(this);
			buttonAdmin.setBounds(157, 677, 123, 23);
			taskbar.add(buttonAdmin);
		} else {
			btnAbmelden = new JButton("Abmelden");
			btnAbmelden.addActionListener(this);
			btnAbmelden.setBounds(10, 677, 270, 23);
			taskbar.add(btnAbmelden);
		}
		labelPunkte = new JLabel("Punkte: " + benutzer.getPunkte());
		labelPunkte.setBounds(20, 302, 260, 14);
		taskbar.add(labelPunkte);

		panel = new JPanel();
		panel.setBounds(302, 0, 865, 725);
		contentPane.add(panel);
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProfil) {
			BtnProfilActionPerformed(e);
		}
		if (e.getSource() == btnAbmelden) {
			BtnAbmeldenActionPerformed(e);
		}
		if (e.getSource() == buttonAdmin) {
			ButtonAdminActionPerformed(e);
		}
		if (e.getSource() == btnShop) {
			BtnShopActionPerformed(e);
		}
	}
	protected void BtnShopActionPerformed(ActionEvent e) {
		shop = new Shop(this);
		panels.put(Views.SHOP, shop);
		switchTo(Views.SHOP);
	}
	protected void ButtonAdminActionPerformed(ActionEvent e) {
		ao = new Adminoberflaeche();
		panels.put(Views.ADMIN, ao);
		switchTo(Views.ADMIN);
	}
	protected void BtnAbmeldenActionPerformed(ActionEvent e) {
		Anmeldung a = new Anmeldung();
		a.setVisible(true);
		dispose();
	}

	public void updateAvatarPicture(String koerperbez, String gesichterbez, String gesichtsbedeckungbez, String kopfbedeckungbez, String oberteilbez) {
		lblAvatar.setIcon(new ImageIcon("image/avatare/" + koerperbez + ".png"));
		lblGesicht.setIcon(new ImageIcon("image/gesichter/" + gesichterbez + ".png"));
		lblGesichtsbedeckung.setIcon(new ImageIcon("image/gesichtsbedeckung/" + gesichtsbedeckungbez + ".png"));
		lblKopfbedeckung.setIcon(new ImageIcon("image/kopfbedeckung/" + kopfbedeckungbez + ".png"));
		lblOberteil.setIcon(new ImageIcon("image/oberteil/" + oberteilbez + ".png"));
	}

	public void updateAvatarPicture (Avatar a) throws DB_FehlerException {
		if(String.valueOf(a.getKoerperid()) != null && a.getKoerperid() != 0) {
			lblAvatar.setIcon(new ImageIcon("image/avatare/" + dsel.selectKoerper(a.getKoerperid()).getBild() + ".png"));
		} else {
			lblAvatar.setIcon(null);
		}
		if(String.valueOf(a.getGesichterid()) != null && a.getGesichterid() != 0) {
			lblGesicht.setIcon(new ImageIcon("image/gesichter/" + dsel.selectGesicht(a.getGesichterid()).getBild()+ ".png"));
		} else {
			lblGesicht.setIcon(null);
		}
		if(String.valueOf(a.getGbid()) != null && a.getGbid() != 0) {
			lblGesichtsbedeckung.setIcon(new ImageIcon("image/gesichtsbedeckung/" + dsel.selectGesichtsbedeckung(a.getGbid()).getBild()+ ".png"));
		}else {
			lblGesichtsbedeckung.setIcon(null);
		}
		if(String.valueOf(a.getKopfbedeckungid()) != null && a.getGbid() != 0) {
			lblKopfbedeckung.setIcon(new ImageIcon("image/kopfbedeckung/" + dsel.selectKopfbedeckung(a.getKopfbedeckungid()).getBild()+ ".png"));
		} else {
			lblKopfbedeckung.setIcon(null);
		}
		if(String.valueOf(a.getOberteilid()) != null && a.getOberteilid() != 0) {
			lblOberteil.setIcon(new ImageIcon("image/oberteil/" +dsel.selectOberteil(a.getOberteilid()).getBild()+ ".png"));
		} else {
			lblOberteil.setIcon(null);
		}
	}
	protected void BtnProfilActionPerformed(ActionEvent e) {
		p = new Profil(benutzer);
		panels.put(Views.PROFIl, p);
		switchTo(Views.PROFIl);
	}
	public void addPlaytime(Benutzer bb) throws SteamApiException, DB_FehlerException {
		Spiele[] spiele = d.getAllGames();
		ArrayList<Integer> appids = new ArrayList<Integer>();
		for(int i = 0; i<spiele.length; i++) {
			appids.add(spiele[i].getAppID());
		}
		spielzeiten = steam.getPlaytimeForGamesIfOwned(bb.getSteamid(), appids.toArray(new Integer[0]));
		totalPlaytime = steam.getTotalPlaytimeHours(bb.getSteamid(), appids.toArray(new Integer[0]));
	}
	private void setPlaytimeDB(Benutzer bb) throws DB_FehlerException {
		Spiele[] games = d.getAllGames();
		for(int i = 0; i < games.length; i++) {
			if (spielzeiten.get(games[i].getAppID()) != null) {
				d.setSpielzeit(bb, games[i], minutesToHours(spielzeiten.get(games[i].getAppID())));
			}
		}
		ds.setTotalPlaytime(bb, minutesToHours(totalPlaytime));

	}
	private void calcPoints(Benutzer bb) throws DB_FehlerException {
		int punkteOLD = bb.getPunkte();
		int punkte = 0;
		if (bb.getPunkte() == -1) {
			punkte = (int) (minutesToHours(getTotalPlaytime()))* 5;
		} else {
			Statistik s = ds.selectStatistikforUser(bb);
			double lastKnownHoursvsNew = getTotalPlaytime() - (s.getGesamtzeit()*60);
			if (lastKnownHoursvsNew != 0)  {
				punkte = (int) (bb.getPunkte() + (minutesToHours((int) lastKnownHoursvsNew) * 5));
			}
		}
		if (!(punkte == punkteOLD)) {
			d.setPoints(bb, punkte);
			bb.setPunkte(punkte);
		}
	}
	public static HashMap<Integer, Integer> getSpielzeiten() {
		return spielzeiten;
	}
	public static int getTotalPlaytime() {
		return totalPlaytime;
	}
	public void dayBonus (Benutzer bb) throws DB_FehlerException {
		if(bb.getDate() != null) {
		if (!bb.getDate().equalsIgnoreCase(formatter.format(date))) {
			d.updateDaybonustime(bb, formatter.format(date));
			int daybonus = 24*5;
			d.setPoints(bb, (bb.getPunkte()+daybonus));
		} 

	}
	}

}

