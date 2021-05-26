package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.HashMap;

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
import java.awt.event.ActionListener;
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

	/**
	 * Create the frame.
	 */
	public Hauptseite() {
		Statistiken statistiken = new Statistiken();
		Shop shop = new Shop();
		panels = new HashMap();
		panels.put(Views.STATISTIKEN, statistiken);
		panels.put(Views.SHOP, shop);
		initGUI();
		
	}
	public void switchTo(Views v) {
		panel.getBounds();
		
        this.validate();
        this.repaint();
	}
	private void replacePanel(JPanel p1, Views v) {
		p1.
	}
	private void initGUI() {
		setTitle("Spielzeitracker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1180, 765);
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
		btnAbmelden.setBounds(10, 677, 137, 23);
		taskbar.add(btnAbmelden);

		panel = new JPanel();
		panel.setBounds(302, 0, 859, 725);
		contentPane.add(panel);
	}


	public void actionPerformed(ActionEvent e) {
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
}
