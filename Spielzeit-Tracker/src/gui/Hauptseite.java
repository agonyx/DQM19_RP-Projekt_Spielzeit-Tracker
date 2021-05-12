package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Hauptseite extends JFrame {

	private JPanel contentPane;
	private JLabel taskbarlb;
	private JLabel avatarlb;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			taskbarlb = new JLabel("");
			taskbarlb.setForeground(new Color(128, 128, 128));
			taskbarlb.setBackground(Color.WHITE);
			taskbarlb.setBounds(0, 0, 984, 87);
			contentPane.add(taskbarlb);
		}
		{
			avatarlb = new JLabel("");
			avatarlb.setIcon(new ImageIcon("H:\\Sekundi.PNG"));
			avatarlb.setBounds(10, 11, 128, 128);
			contentPane.add(avatarlb);
		}
	}
}
