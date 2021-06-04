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
	private long startTime;

	
	public Hauptseite(Benutzer bb) {
		setResizable(false);
		benutzer = bb;
		Statistiken statistiken = new Statistiken();
		Shop shop = new Shop();
		Adminoberflaeche ao = new Adminoberflaeche();
		panels = new HashMap();
		panels.put(Views.STATISTIKEN, statistiken);
		panels.put(Views.SHOP, shop);
		panels.put(Views.ADMIN, ao);
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
		long startTime = System.currentTimeMillis();
		setTitle("Spielzeitracker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                long endTime = System.currentTimeMillis();
                TimeTracking(startTime, endTime, benutzer);
                e.getWindow().dispose();
            }
        });
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
		avatarGesamt.setBounds(10, 11, 270, 291);
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

		panel = new JPanel();
		panel.setBounds(302, 0, 865, 725);
		contentPane.add(panel);
	}


	public void actionPerformed(ActionEvent e) {
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
		switchTo(Views.STATISTIKEN);
	}
	protected void BtnShopActionPerformed(ActionEvent e) {
		switchTo(Views.SHOP);
	}
	protected void ButtonAdminActionPerformed(ActionEvent e) {
		switchTo(Views.ADMIN);
	}
	protected void BtnAbmeldenActionPerformed(ActionEvent e) {
		long endTime = System.nanoTime();
        TimeTracking(startTime, endTime, benutzer);
		Anmeldung a = new Anmeldung();
		a.setVisible(true);
		dispose();
	}
	//Verrechnet End- und Startzeit der App
	public void TimeTracking(long startTime , long endTime, Benutzer bb) {
		long totalTime = endTime - startTime;
        String AppTime = bb.getAppzeit() + (totalTime/1000);
        try {
			d.UpdateAppTime(AppTime);
		} catch (DB_FehlerException e1) {
			e1.printStackTrace();
		}
	}
	
	
	
}

