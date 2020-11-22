package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class udanylogin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					udanylogin window = new udanylogin();
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
	public udanylogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUdaloSieZalogowac = new JLabel("Udalo sie zalogowac");
		lblUdaloSieZalogowac.setFont(new Font("Source Sans Pro", Font.BOLD, 26));
		lblUdaloSieZalogowac.setBounds(24, 24, 321, 146);
		frame.getContentPane().add(lblUdaloSieZalogowac);
	}
}
