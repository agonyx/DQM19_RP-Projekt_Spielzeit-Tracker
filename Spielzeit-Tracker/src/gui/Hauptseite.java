package gui;


import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import sqlverbindung.Benutzer;
import sqlverbindung.DAO;
import sqlverbindung.DB_FehlerException;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

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
	private DAO d = new DAO();
	private Statistiken statistiken;
	private Shop shop;
	private Adminoberflaeche ao;
	private Profil p;
	private JLabel labelNewLabel;

	
	public Hauptseite(Benutzer bb) {
		setResizable(false);
		benutzer = bb;
		panels = new HashMap();
		initGUI();
		
	}
	//Panel wechseln
	public void switchTo(Views v) {
		contentPane.remove(panel);
		panel = panels.get(v);
		panel.setBounds(302, 0, 865, 725);
		contentPane.add(panel);
		this.validate();
		this.repaint();
	}
	public void setBenutzer(Benutzer ben) {
		benutzer = ben;
		
	}
	public static Benutzer getBenutzer() {
		return benutzer;
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
		avatarGesamt.setBounds(10, 0, 270, 291);
		taskbar.add(avatarGesamt);

		lblGesichtsbedeckung = new JLabel("");
		lblGesichtsbedeckung.setIcon(new ImageIcon("image/avatare/AVATAR_000.png"));
		lblGesichtsbedeckung.setBounds(7, 33, 256, 256);
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

		btnStatistiken = new JButton("Statistiken");
		btnStatistiken.addActionListener(this);
		btnStatistiken.setBounds(10, 446, 270, 66);
		taskbar.add(btnStatistiken);

		btnAbmelden = new JButton("Abmelden");
		btnAbmelden.addActionListener(this);
		btnAbmelden.setBounds(10, 677, 137, 23);
		taskbar.add(btnAbmelden);
		{
			buttonAdmin = new JButton("Admin");
			buttonAdmin.addActionListener(this);
			buttonAdmin.setBounds(157, 677, 123, 23);
			taskbar.add(buttonAdmin);
		}
		
		labelNewLabel = new JLabel("New label");
		labelNewLabel.setBounds(20, 302, 260, 14);
		taskbar.add(labelNewLabel);

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
		if (e.getSource() == btnStatistiken) {
			BtnStatistikenActionPerformed(e);
		}
	}
	protected void BtnStatistikenActionPerformed(ActionEvent e) {
		statistiken = new Statistiken();
		panels.put(Views.STATISTIKEN, statistiken);
		switchTo(Views.STATISTIKEN);
	}
	protected void BtnShopActionPerformed(ActionEvent e) {
		shop = new Shop();
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
		lblAvatar.setIcon(new ImageIcon(Hauptseite.class.getResource("image/avatare/" + koerperbez)));
		lblGesicht.setIcon(new ImageIcon(Hauptseite.class.getResource("image/gesichter/" + gesichterbez)));
		lblGesichtsbedeckung.setIcon(new ImageIcon(Hauptseite.class.getResource("image/gesichtsbedeckung/" + gesichtsbedeckungbez)));
		lblKopfbedeckung.setIcon(new ImageIcon(Hauptseite.class.getResource("image/kopfbedeckung/" + kopfbedeckungbez)));
		lblOberteil.setIcon(new ImageIcon(Hauptseite.class.getResource("image/oberteil/" + oberteilbez)));
	}
	
	protected void BtnProfilActionPerformed(ActionEvent e) {
		p = new Profil(benutzer);
		panels.put(Views.PROFIl, p);
		switchTo(Views.PROFIl);
	}
}

