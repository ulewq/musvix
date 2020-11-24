package panel_glowny;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.CardLayout;

public class main_panel {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_panel window = new main_panel();
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

	public main_panel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1300,900);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		JPanel change_panel = new JPanel();
		change_panel.setBounds(0, 70, 1294, 752);
		frame.getContentPane().add(change_panel);
		change_panel.setLayout(new CardLayout(0, 0));
		
		JPanel myacc_panel = new JPanel();
		myacc_panel.setBackground(new Color(204, 204, 204));
		change_panel.add(myacc_panel, "account");
		
		JPanel mymusic_panel = new JPanel();
		mymusic_panel.setBackground(new Color(255, 51, 204));
		change_panel.add(mymusic_panel, "music");
		mymusic_panel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1014, 60);
		mymusic_panel.add(panel);
		panel.setLayout(null);
		
		JButton music_albums_button = new JButton("");
		music_albums_button.setBounds(0, 0, 334, 60);
		music_albums_button.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/albums_l.png")));
		music_albums_button.setOpaque(false);
		music_albums_button.setContentAreaFilled(false);
		music_albums_button.setBorderPainted(false);
		music_albums_button.setRolloverEnabled(true);
		music_albums_button.setRolloverIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/albums_m.png")));
		panel.add(music_albums_button);
		
		JButton music_albums_button_1 = new JButton("");
		music_albums_button_1.setRolloverEnabled(true);
		music_albums_button_1.setOpaque(false);
		music_albums_button_1.setContentAreaFilled(false);
		music_albums_button_1.setBorderPainted(false);
		music_albums_button_1.setBounds(334, 0, 334, 60);
		music_albums_button_1.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/albums_l.png")));
		music_albums_button_1.setRolloverIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/albums_m.png")));
		panel.add(music_albums_button_1);
		
		JButton music_albums_button_1_1 = new JButton("");
		music_albums_button_1_1.setRolloverEnabled(true);
		music_albums_button_1_1.setOpaque(false);
		music_albums_button_1_1.setContentAreaFilled(false);
		music_albums_button_1_1.setBorderPainted(false);
		music_albums_button_1_1.setBounds(680, 0, 334, 60);
		music_albums_button_1_1.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/albums_l.png")));
		music_albums_button_1_1.setRolloverIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/albums_m.png")));
		panel.add(music_albums_button_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 60, 1014, 692);
		mymusic_panel.add(panel_1);
		
		JPanel shop_panel = new JPanel();
		shop_panel.setBackground(new Color(200, 226, 234));
		change_panel.add(shop_panel, "name_22376715666500");
		shop_panel.setLayout(null);
		
		JPanel songalbum_panel = new JPanel();
		songalbum_panel.setBackground(new Color(144, 197, 214));
		songalbum_panel.setBounds(0, 0, 1014, 60);
		shop_panel.add(songalbum_panel);
		songalbum_panel.setLayout(null);
		
		JButton songs_button = new JButton("");
		songs_button.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/song.png")));
		songs_button.setBounds(0, 0, 507, 60);
		songs_button.setOpaque(false);
		songs_button.setContentAreaFilled(false);
		songs_button.setBorderPainted(false);
		songs_button.setRolloverEnabled(true);
		songs_button.setRolloverIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/song-hover.png")));
		songalbum_panel.add(songs_button);
		
		JButton albums_button = new JButton("");
		albums_button.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/albums.png")));
		albums_button.setBounds(507, 0, 507, 60);
		albums_button.setOpaque(false);
		albums_button.setContentAreaFilled(false);
		albums_button.setBorderPainted(false);
		albums_button.setRolloverEnabled(true);
		albums_button.setRolloverIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/albums-hover.png")));
		songalbum_panel.add(albums_button);
		
		JPanel shop_card_panel = new JPanel();
		shop_card_panel.setBounds(0, 59, 1014, 693);
		shop_panel.add(shop_card_panel);
		shop_card_panel.setLayout(new CardLayout(0, 0));
		
		
		JPanel song_panel = new JPanel();
		shop_card_panel.add(song_panel, "name_29342290723900");
		song_panel.setLayout(null);
		
		JLabel lblSongs = new JLabel("songs");
		lblSongs.setFont(new Font("Source Sans Pro", Font.PLAIN, 29));
		lblSongs.setBounds(262, 5, 267, 282);
		song_panel.add(lblSongs);
		
		JPanel albums_panel = new JPanel();
		shop_card_panel.add(albums_panel, "name_29344868776900");
		albums_panel.setLayout(null);
		
		songs_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shop_card_panel.removeAll();
				shop_card_panel.repaint();
				shop_card_panel.revalidate();
				// TODO Auto-generated method stub
				shop_card_panel.add(song_panel);
				shop_card_panel.repaint();
				shop_card_panel.revalidate();
				
			}
		});
		
		albums_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shop_card_panel.removeAll();
				shop_card_panel.repaint();
				shop_card_panel.revalidate();
				// TODO Auto-generated method stub
				shop_card_panel.add(albums_panel);
				shop_card_panel.repaint();
				shop_card_panel.revalidate();
				
			}
		});
		
		JLabel lblAlbums = new JLabel("albums");
		lblAlbums.setFont(new Font("Source Sans Pro", Font.PLAIN, 28));
		lblAlbums.setBounds(298, 193, 337, 173);
		albums_panel.add(lblAlbums);
		
		JPanel settings_panel = new JPanel();
		settings_panel.setBackground(new Color(153, 102, 102));
		change_panel.add(settings_panel, "name_22387308818100");
		
		JPanel player_panel = new JPanel();
		player_panel.setBounds(0, 822, 1294, 43);
		frame.getContentPane().add(player_panel);
		player_panel.setBackground(new Color(152, 209, 238));
		player_panel.setLayout(null);
		
		JButton rewind_button = new JButton("");
		rewind_button.setBounds(49, 3, 37, 37);
		player_panel.add(rewind_button);
		rewind_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		rewind_button.setBorderPainted(false);
		rewind_button.setOpaque(false);
		rewind_button.setContentAreaFilled(false);
		rewind_button.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/back.png")));
		
		JButton playpause_button = new JButton("");
		playpause_button.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/play.png")));
		playpause_button.setOpaque(false);
		playpause_button.setContentAreaFilled(false);
		playpause_button.setBorderPainted(false);
		playpause_button.setBounds(119, 3, 37, 37);
		player_panel.add(playpause_button);
		
		JButton forward_button = new JButton("");
		forward_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		forward_button.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/next.png")));
		forward_button.setOpaque(false);
		forward_button.setContentAreaFilled(false);
		forward_button.setBorderPainted(false);
		forward_button.setBounds(179, 3, 37, 37);
		player_panel.add(forward_button);
		
		JSlider music_time_slider = new JSlider();
		music_time_slider.setBounds(278, 9, 650, 26);
		music_time_slider.setValue(0);
		player_panel.add(music_time_slider);
		
		JLabel time_song_label = new JLabel("0:00/1:00");
		time_song_label.setFont(new Font("Source Sans Pro", Font.BOLD, 13));
		time_song_label.setBounds(940, 8, 67, 22);
		player_panel.add(time_song_label);
		
		JSlider volume_slider = new JSlider();
		volume_slider.setBounds(1082, 8, 200, 26);
		player_panel.add(volume_slider);
		
		JLabel speaker_image = new JLabel("New");
		if (volume_slider.getValue()==0)
		{
		speaker_image.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/unvolume.png")));
		}
		else
		{
		speaker_image.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/volume.png")));
		}
		speaker_image.setBounds(1040, 8, 30, 30);
		player_panel.add(speaker_image);
		
		JPanel menu_panel = new JPanel();
		menu_panel.setBounds(280, 0, 1014, 70);
		frame.getContentPane().add(menu_panel);
		menu_panel.setBackground(new Color(31, 33, 38));
		menu_panel.setLayout(null);
		
		JButton myaccount_button = new JButton("");
		myaccount_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				change_panel.removeAll();
				change_panel.repaint();
				change_panel.revalidate();
				// TODO Auto-generated method stub
				change_panel.add(myacc_panel);
				change_panel.repaint();
				change_panel.revalidate();
				
			}});
		myaccount_button.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/my_account.png")));
		myaccount_button.setBounds(0, 13, 204, 50);
		myaccount_button.setBorderPainted(false);
		myaccount_button.setOpaque(false);
		myaccount_button.setContentAreaFilled(false);
		myaccount_button.setRolloverEnabled(true);
		myaccount_button.setRolloverIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/my_account-hover.png")));
		menu_panel.add(myaccount_button);
		
		JButton mymusic_button = new JButton("");
		mymusic_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change_panel.removeAll();
				change_panel.repaint();
				change_panel.revalidate();
				// TODO Auto-generated method stub
				change_panel.add(mymusic_panel);
				change_panel.repaint();
				change_panel.revalidate();
				
			}
		});
		mymusic_button.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/mymusic.png")));
		mymusic_button.setOpaque(false);
		mymusic_button.setContentAreaFilled(false);
		mymusic_button.setBorderPainted(false);
		mymusic_button.setBounds(230, 13, 204, 50);
		mymusic_button.setRolloverEnabled(true);
		mymusic_button.setRolloverIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/mymusic-hover.png")));
		menu_panel.add(mymusic_button);
		
		JButton shop_button = new JButton("");
		shop_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change_panel.removeAll();
				change_panel.repaint();
				change_panel.revalidate();
				// TODO Auto-generated method stub
				change_panel.add(shop_panel);
				change_panel.repaint();
				change_panel.revalidate();
			}
		});
		shop_button.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/shop.png")));
		shop_button.setOpaque(false);
		shop_button.setContentAreaFilled(false);
		shop_button.setBorderPainted(false);
		shop_button.setBounds(460, 13, 204, 50);
		shop_button.setRolloverEnabled(true);
		shop_button.setRolloverIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/shop-hover.png")));
		menu_panel.add(shop_button);
		
		JButton settings_button = new JButton("");
		settings_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change_panel.removeAll();
				change_panel.repaint();
				change_panel.revalidate();
				// TODO Auto-generated method stub
				change_panel.add(settings_panel);
				change_panel.repaint();
				change_panel.revalidate();
			}
		});
		settings_button.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/settings.png")));
		settings_button.setOpaque(false);
		settings_button.setContentAreaFilled(false);
		settings_button.setBorderPainted(false);
		settings_button.setBounds(647, 13, 204, 50);
		settings_button.setRolloverEnabled(true);
		settings_button.setRolloverIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/settings-hover.png")));
		menu_panel.add(settings_button);
		
		JButton logout_button = new JButton("");
		logout_button.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/logout.png")));
		logout_button.setOpaque(false);
		logout_button.setContentAreaFilled(false);
		logout_button.setBorderPainted(false);
		logout_button.setBounds(810, 13, 204, 50);
		logout_button.setRolloverEnabled(true);
		logout_button.setRolloverIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/logout-hover.png")));
		menu_panel.add(logout_button);
		
		JPanel logo_panel = new JPanel();
		logo_panel.setBackground(new Color(204, 204, 204));
		logo_panel.setBounds(0, 0, 280, 70);
		frame.getContentPane().add(logo_panel);
		logo_panel.setLayout(null);
		
		JLabel musvix_logo = new JLabel("");
		musvix_logo.setBackground(new Color(204, 204, 204));
		musvix_logo.setBounds(-33, 0, 260, 70);
		logo_panel.add(musvix_logo);
		musvix_logo.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/musvix_left_logo.png")));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/logo_left.png")));
		lblNewLabel.setBounds(224, 0, 56, 70);
		logo_panel.add(lblNewLabel);
		
		
	}
}
