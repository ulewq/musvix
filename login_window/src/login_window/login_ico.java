package login_window;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class login_ico {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_ico window = new login_ico();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login_ico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(new Color(31, 33, 38));
		frame.setBounds(100, 100, 729, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(150, 150);
		frame.getContentPane().setLayout(null);
		
		JLabel icon_label = new JLabel("");
		icon_label.setIcon(new ImageIcon(login_ico.class.getResource("/login_window/m_150x150.png")));
		icon_label.setBounds(0, 0, 56, 16);
		icon_label.setSize(150, 150);
		frame.getContentPane().add(icon_label);
	}
}
