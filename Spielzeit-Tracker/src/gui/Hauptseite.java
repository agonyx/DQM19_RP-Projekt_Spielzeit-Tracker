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

public class Hauptseite extends JFrame {

	private JPanel contentPane;
	private JLabel lblAvatar;
	private JButton btnProfil;
	private JPanel taskbar;
	private JButton btnShop;
	private JButton btnStatistiken;
	private JButton btnAbmelden;

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
		taskbar.setBounds(0, 0, 270, 711);
		contentPane.add(taskbar);
		taskbar.setLayout(null);
		
		lblAvatar = new JLabel("");
		lblAvatar.setBounds(10, 27, 256, 256);
		taskbar.add(lblAvatar);
		lblAvatar.setIcon(new ImageIcon("T:\\GitHub\\DQM19_RP-Projekt_Gruppe1_2021\\Spielzeit-Tracker\\resources\\images\\avatare\\AVATAR_000.png"));
		
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
}
