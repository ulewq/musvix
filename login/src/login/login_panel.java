package login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import login_window.Logingui;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login_panel {

	private JFrame frame;
	private JTextField login_field;
	private JTextField password_field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_panel window = new login_panel();
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
	public login_panel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(new Color(31, 33, 38));
		frame.setBounds(100, 100, 729, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(660, 800);
		frame.setShape(new RoundRectangle2D.Double(1,1, 660,800, 20,20));
		frame.getContentPane().setLayout(null);
		
		
		
		JButton exit_button = new JButton("");
		exit_button.setIcon(new ImageIcon(login_panel.class.getResource("/login/exit_button.png")));
		exit_button.setBounds(620, 0, 47, 25);
		frame.getContentPane().add(exit_button);
		exit_button.setSize(40, 20);
		exit_button.setBorderPainted(false);
		exit_button.addActionListener(e -> System.exit(0));
		
		JButton minimal_button = new JButton("");
		minimal_button.setIcon(new ImageIcon(login_panel.class.getResource("/login/minimal_button.png")));
		minimal_button.setBounds(579, 0, 97, 25);
		frame.getContentPane().add(minimal_button);
		minimal_button.addActionListener(e -> frame.setState(frame.ICONIFIED));
		minimal_button.setSize(40, 20);
		minimal_button.setBorderPainted(false);
		
		login_field = new JTextField();
		login_field.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(login_field.getText().equals("Username"))
				{
				login_field.setText("");
				}
				}
			});
		login_field.setFont(new Font("Source Sans Pro", Font.PLAIN, 25));
		login_field.setForeground(new Color(240, 255, 255));
		login_field.setText("Username");
		login_field.setBackground(new Color(31, 33, 38));
		login_field.setBounds(150, 305, 376, 20);
		frame.getContentPane().add(login_field);
		login_field.setColumns(10);
		login_field.setSize(360, 25);
		login_field.setOpaque(false);
		login_field.setBorder(null);
		
		JLabel user_ico = new JLabel("");
		user_ico.setBounds(106, 305, 65, 26);
		frame.getContentPane().add(user_ico);
		user_ico.setIcon(new ImageIcon(login_panel.class.getResource("/login/user.png")));
		user_ico.setSize(40,26);
		
		JSeparator separator_login = new JSeparator();
		separator_login.setForeground(Color.WHITE);
		separator_login.setBackground(Color.WHITE);
		separator_login.setBounds(106, 343, 420, 12);
		frame.getContentPane().add(separator_login);
		
		password_field = new JPasswordField();
		password_field.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(password_field.getText().equals("Password"))
				{
				password_field.setText("");
				}
			}
		});
		password_field.setText("Password");
		password_field.setOpaque(false);
		password_field.setForeground(new Color(240, 255, 255));
		password_field.setFont(new Font("Source Sans Pro", Font.PLAIN, 25));
		password_field.setColumns(10);
		password_field.setBorder(null);
		password_field.setBackground(new Color(31, 33, 38));
		password_field.setBounds(151, 388, 360, 25);
	    
		frame.getContentPane().add(password_field);
		
		JLabel pass_ico = new JLabel("");
		pass_ico.setIcon(new ImageIcon(login_panel.class.getResource("/login/password.png")));
		pass_ico.setBounds(107, 385, 40, 26);
		frame.getContentPane().add(pass_ico);
		
		JSeparator separator_password = new JSeparator();
		separator_password.setForeground(Color.WHITE);
		separator_password.setBackground(Color.WHITE);
		separator_password.setBounds(107, 429, 420, 12);
		frame.getContentPane().add(separator_password);
		
		JButton login_button = new JButton("");
		login_button.setIcon(new ImageIcon(login_panel.class.getResource("/login/login_button.png")));
		login_button.setForeground(new Color(0, 51, 102));
		login_button.setBackground(new Color(0, 51, 102));
		login_button.setBounds(106, 479, 420, 65);
		login_button.setBorderPainted(false);
		frame.getContentPane().add(login_button);
		
		JButton login_fb_button = new JButton("");
		login_fb_button.setIcon(new ImageIcon(login_panel.class.getResource("/login/login_fb_button.png")));
		login_fb_button.setForeground(new Color(0, 51, 102));
		login_fb_button.setBackground(new Color(0, 51, 102));
		login_fb_button.setBounds(106, 578, 420, 65);
		login_fb_button.setBorderPainted(false);
		frame.getContentPane().add(login_fb_button);
		
		JButton forgot_pass_button = new JButton("Forgot password?");
		forgot_pass_button.setFont(new Font("Source Sans Pro", Font.PLAIN, 20));
		forgot_pass_button.setBounds(106, 700, 420, 25);
		forgot_pass_button.setSize(420, 25);
		forgot_pass_button.setBorderPainted(false);
		forgot_pass_button.setOpaque(false);
		frame.getContentPane().add(forgot_pass_button);
		
		JLabel photo_panel = new JLabel("");
		photo_panel.setIcon(new ImageIcon(login_panel.class.getResource("/login/jpanel_login.png")));
		photo_panel.setBounds(0, 23, 660, 800);
		frame.getContentPane().add(photo_panel);
		
	
	}
}
