package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class Hauptseite extends JFrame {

	private JPanel contentPane;
	private JLabel lblAvatar;
	private JButton btnProfil;
	private JPanel taskbar;
	private JButton btnShop;
	private JButton btnStatistiken;
	private JButton btnAbmelden;
	private JPanel avatarGesamt;
	private JLabel lblGesicht;
	private JLabel lblGesichtsbedeckung;
	private JLabel lblKopfbedeckung;
	private JLabel lblOberteil;
	private JPanel arbeitsflaeche;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hauptseite frame = new Hauptseite();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Hauptseite() {
		initGUI();
	}
	private void initGUI() {
		setTitle("Spielzeitracker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		taskbar = new JPanel();
		taskbar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, Color.DARK_GRAY));
		taskbar.setBounds(0, 0, 270, 711);
		contentPane.add(taskbar);
		taskbar.setLayout(null);
		
		arbeitsflaeche = new JPanel();
		arbeitsflaeche.setBounds(270, 0, 714, 711);
		contentPane.add(arbeitsflaeche);
		arbeitsflaeche.setLayout(null);
		
		avatarGesamt = new JPanel();
		avatarGesamt.setBounds(10, 11, 270, 291);
		taskbar.add(avatarGesamt);
		avatarGesamt.setLayout(null);
		
		initButtons();
		initAvatar();
	}
	
	private void initButtons() {
		btnProfil = new JButton("Profil");
		btnProfil.setBounds(0, 465, 270, 66);
		taskbar.add(btnProfil);
		
		btnShop = new JButton("Shop");
		btnShop.setBounds(0, 390, 270, 66);
		taskbar.add(btnShop);
		
		btnStatistiken = new JButton("Statistiken");
		btnStatistiken.setBounds(0, 313, 270, 66);
		taskbar.add(btnStatistiken);
		
		btnAbmelden = new JButton("Abmelden");
		btnAbmelden.setBounds(10, 677, 89, 23);
		taskbar.add(btnAbmelden);
	}
	
	private void initAvatar() {
		lblGesichtsbedeckung = new JLabel("");
		lblGesichtsbedeckung.setBounds(0, 0, 256, 256);
		avatarGesamt.add(lblGesichtsbedeckung);
		lblGesichtsbedeckung.setIcon(new ImageIcon(Hauptseite.class.getResource("/gesichtsbedeckung/GESICHTSBEDECKUNG_001.png")));

		lblKopfbedeckung = new JLabel("");
		lblKopfbedeckung.setBounds(0, 0, 256, 256);
		avatarGesamt.add(lblKopfbedeckung);
		lblKopfbedeckung.setIcon(new ImageIcon(Hauptseite.class.getResource("/kopfbedeckung/KOPFBEDECKUNG_001.png")));

		lblOberteil = new JLabel("");
		lblOberteil.setBounds(0, 0, 256, 256);
		avatarGesamt.add(lblOberteil);
		lblOberteil.setIcon(new ImageIcon(Hauptseite.class.getResource("/oberteil/OBERTEIL_002.png")));
		
		lblGesicht = new JLabel("");
		lblGesicht.setBounds(0, 0, 256, 256);
		avatarGesamt.add(lblGesicht);
		lblGesicht.setIcon(new ImageIcon(Hauptseite.class.getResource("/gesichter/GESICHT_000.png")));
		
		lblAvatar = new JLabel("");
		lblAvatar.setBounds(0, 0, 256, 256);
		avatarGesamt.add(lblAvatar);
		lblAvatar.setIcon(new ImageIcon(Hauptseite.class.getResource("/avatare/AVATAR_000.png")));
						
	}
}
