package projekt_ucz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.geom.RoundRectangle2D;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;



public class Gui {

	private JFrame frame;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
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
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 729, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(1280, 720);
		frame.setShape(new RoundRectangle2D.Double(1,1, 1280,720, 20,20));
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 264, 720);
		panel.setBackground(new Color(230, 233, 237));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton my_account_button = new JButton("");
		my_account_button.setIcon(new ImageIcon(Gui.class.getResource("/projekt_ucz/icons/my_account.png")));
		my_account_button.setBounds(0, 206, 241, 60);
		my_account_button.setSize(258, 60);
		my_account_button.setBorderPainted(false);
		panel.add(my_account_button);
		
		JButton my_music_button = new JButton("");
		my_music_button.setIcon(new ImageIcon(Gui.class.getResource("/projekt_ucz/icons/my_music.png")));
		my_music_button.setBounds(0, 262, 258, 60);
		my_music_button.setBorderPainted(false);
		panel.add(my_music_button);
		
		JButton shop_button = new JButton("");
		shop_button.setIcon(new ImageIcon(Gui.class.getResource("/projekt_ucz/icons/shop.png")));
		shop_button.setBounds(0, 321, 258, 60);
		shop_button.setBorderPainted(false);
		panel.add(shop_button);
		
		JButton settings_button = new JButton("");
		settings_button.setIcon(new ImageIcon(Gui.class.getResource("/projekt_ucz/icons/settings.png")));
		settings_button.setBounds(0, 382, 258, 60);
		settings_button.setBorderPainted(false);
		panel.add(settings_button);
		
		JButton logout_button = new JButton("");
		logout_button.setIcon(new ImageIcon(Gui.class.getResource("/projekt_ucz/icons/logout.png")));
		logout_button.setBounds(0, 443, 258, 60);
		logout_button.setBorderPainted(false);
		panel.add(logout_button);
		
		JLabel lblNewLabel = new JLabel("Leszek Ulewiñski");
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblNewLabel.setBounds(86, 34, 141, 60);
		panel.add(lblNewLabel);
		
		JLabel account_photo = new JLabel("");
		account_photo.setIcon(new ImageIcon(Gui.class.getResource("/projekt_ucz/strzelam.jpg")));
		account_photo.setBounds(12, 34, 62, 60);
		panel.add(account_photo);
		
		JButton online_button = new JButton("");
		online_button.setIcon(new ImageIcon(Gui.class.getResource("/projekt_ucz/icons/online.png")));
		online_button.setBounds(224, 56, 19, 25);
		panel.add(online_button);
		online_button.setSize(15, 15);
		
		JButton exit_button = new JButton("");
		exit_button.setIcon(new ImageIcon(Gui.class.getResource("/projekt_ucz/icons/exit.png")));
		exit_button.setBounds(1230, 0, 97, 25);
		exit_button.setSize(50, 50);
		exit_button.addActionListener(e -> System.exit(0));
		frame.getContentPane().add(exit_button);
		
		JButton minimalise_button = new JButton("");
		minimalise_button.setIcon(new ImageIcon(Gui.class.getResource("/projekt_ucz/icons/minimalise.png")));
		minimalise_button.setBounds(1179, 0, 50, 50);
		minimalise_button.addActionListener(e -> frame.setState(frame.ICONIFIED));
		frame.getContentPane().add(minimalise_button);
	}
}
