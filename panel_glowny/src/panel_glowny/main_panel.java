package panel_glowny;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import login.MysqlConnect;

import javax.swing.JProgressBar;

public class main_panel implements ChangeListener {
	private boolean isPaused = false;
	private boolean isFirst = true;
	private int framePos = 0;
	private float volume = -20.0f;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JFrame frame;
	private JTable table;
	private String fullSongPath;
	private Audio song;
	private final JSeparator separator = new JSeparator();
	
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
		
		MysqlConnect mysqlConnect = new MysqlConnect();
		mysqlConnect.connect();
		
		
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
		myacc_panel.setBackground(SystemColor.controlHighlight);
		
		change_panel.add(myacc_panel, "account");
		myacc_panel.setLayout(null);
		
		JLabel author_image = new JLabel("");
		author_image.setBounds(619, 5, 235, 279);
		myacc_panel.add(author_image);
		
		JButton changePhotoButton = new JButton("Zmie\u0144 zdj\u0119cie profilowe");
		changePhotoButton.setFont(new Font("Calibri", Font.BOLD, 14));
		changePhotoButton.setSize(300, 200);
		changePhotoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == changePhotoButton) {
					try {
					JFileChooser selectPhotoChooser = new JFileChooser();
					System.out.println(selectPhotoChooser.showOpenDialog(null));
					int responseFromButton = selectPhotoChooser.showOpenDialog(null);
						if(responseFromButton == JFileChooser.APPROVE_OPTION) 
						{
							File file = new File(selectPhotoChooser.getSelectedFile().getAbsolutePath());
							String userImage = file.toString();
							System.out.println(userImage);
							
							if(file.getName().endsWith(".jpg") || file.getName().endsWith(".png")) { //warunek �e wstawione zostanie tylko zdjecie
								System.out.println("Otworzono zdj�cie");	
								author_image.setIcon(new ImageIcon(userImage));
						}
						else System.out.println("Nieprawid�owy format pliku");
						}
					}
					catch(Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		myacc_panel.add(changePhotoButton);
		
		JPanel mymusic_panel = new JPanel();
		mymusic_panel.setBackground(new Color(255, 51, 204));
		change_panel.add(mymusic_panel, "music");
		mymusic_panel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(280, 0, 1014, 60);
		panel.setBackground(new Color(	65, 69, 80));
		mymusic_panel.add(panel);
		panel.setLayout(null);
		
		JButton music_songs_button = new JButton("");
		music_songs_button.setBounds(0, 0, 338, 60);
		music_songs_button.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/songs_m.png")));
		music_songs_button.setOpaque(false);
		music_songs_button.setContentAreaFilled(false);
		music_songs_button.setBorderPainted(false);
		music_songs_button.setRolloverEnabled(true);
		music_songs_button.setRolloverIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/songs_m-hover.png")));
		panel.add(music_songs_button);
		
		JButton music_albums_button = new JButton("");
		music_albums_button.setBounds(326, 0, 338, 60);
		panel.add(music_albums_button);
		music_albums_button.setRolloverEnabled(true);
		music_albums_button.setOpaque(false);
		music_albums_button.setContentAreaFilled(false);
		music_albums_button.setBorderPainted(false);
		music_albums_button.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/albums_m.png")));
		music_albums_button.setRolloverIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/albums_m-hover.png")));
		
		JButton music_arthist_button = new JButton("");
		music_arthist_button.setBounds(676, 0, 338, 60);
		panel.add(music_arthist_button);
		music_arthist_button.setRolloverEnabled(true);
		music_arthist_button.setOpaque(false);
		music_arthist_button.setContentAreaFilled(false);
		music_arthist_button.setBorderPainted(false);
		music_arthist_button.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/artists_m.png")));
		music_arthist_button.setRolloverIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/artists_m-hover.png")));
		
		JPanel player_panel = new JPanel();
		player_panel.setBounds(0, 822, 1294, 43);
		frame.getContentPane().add(player_panel);
		player_panel.setBackground(new Color(250, 250, 250));
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
		
		JLabel time_song_label = new JLabel("0:00/1:00");
		time_song_label.setFont(new Font("Source Sans Pro", Font.BOLD, 13));
		time_song_label.setBounds(940, 8, 67, 22);
		player_panel.add(time_song_label);
		
		JSlider volume_slider = new JSlider(-75,5,-20);
		volume_slider.setBounds(1082, 8, 200, 26);
		player_panel.add(volume_slider);
		volume_slider.addChangeListener(this);
		
		JLabel speaker_image = new JLabel("");

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
		JButton playpause_button = new JButton("");
		playpause_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isPaused)
				{
					framePos = song.getFramePosition();
					song.stop();
					playpause_button.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/play.png")));
					isPaused = true;
				}
				else
				{
					song.playAfterPause(framePos);
					playpause_button.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/pause.png")));
					isPaused = false;
				}
			}
		});
		playpause_button.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/play.png")));
		playpause_button.setOpaque(false);
		playpause_button.setContentAreaFilled(false);
		playpause_button.setBorderPainted(false);
		playpause_button.setBounds(119, 3, 37, 37);
		player_panel.add(playpause_button);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(261, 8, 654, 27);
		player_panel.add(progressBar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 60, 1294, 692);
		mymusic_panel.add(panel_1);
		
		JButton browse_music = new JButton("browse");
		browse_music.setBounds(591, 234, 75, 25);
		browse_music.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				int rVal = chooser.showOpenDialog(frame);
				if(rVal == JFileChooser.APPROVE_OPTION)
				{
					String path = chooser.getCurrentDirectory().toString();
					String name = chooser.getSelectedFile().getName();
					fullSongPath = path + "\\" + name;				
					System.out.println(fullSongPath);
			
						//song.close();
						//playSong(fullSongPath, 0, 0);
						try {
							song = new Audio(path);
						} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//song.play(0, 0);
				}
			}
		});
		
		JButton play_music = new JButton("play");
		play_music.setBounds(10, 10, 70, 30);
		play_music.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
					if (!isFirst)
					{
					song.close();
					isFirst = false;
					}
					else
					{
					isFirst = false;
					}
					try {
						song = new Audio("C:\\Users\\Leszek\\Music\\POP SMOKE - GOT IT ON ME.mp3");
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					playpause_button.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/pause.png")));
					song.play(volume, framePos);
					
					}
		});
		panel_1.setLayout(null);
		panel_1.add(play_music);
		panel_1.add(browse_music);
		
		JLabel song_name = new JLabel("POP SMOKE - GOT IT ON ME");
		song_name.setFont(new Font("Source Sans Pro", Font.BOLD, 21));
		song_name.setBounds(129, 10, 507, 35);
		
		panel_1.add(song_name);
		
		JLabel song_name2 = new JLabel("Skepta ft. JME - That's Not Me");
		song_name2.setFont(new Font("Source Sans Pro", Font.BOLD, 20));
		song_name2.setBounds(129, 72, 486, 30);
		panel_1.add(song_name2);
		separator.setBackground(Color.BLACK);
		separator.setBounds(0, 50, 1294, 9);
		panel_1.add(separator);
		
		JButton play_music_1 = new JButton("play");
		play_music_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isFirst)
				{
				song.close();
				}
				else
				{
				isFirst = false;
				}
				try {
					song = new Audio("C:\\Users\\Leszek\\Music\\Skepta ft. JME - Thats Not Me.mp3");
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				playpause_button.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/pause.png")));
				song.play(volume, framePos);
				
				}
		});
		play_music_1.setBounds(10, 72, 70, 30);
		panel_1.add(play_music_1);
		
		JSeparator separator2 = new JSeparator();
		separator2.setBackground(Color.BLACK);
		separator2.setBounds(0, 112, 1294, 9);
		panel_1.add(separator2);
		
		JButton play_music_1_1 = new JButton("play");
		play_music_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isFirst)
				{
				song.close();
				}
				else
				{
				isFirst = false;
				}
				try {
					song = new Audio("C:\\Users\\Leszek\\Music\\Dutchavelli - Bando Diaries.mp3");
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				playpause_button.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/pause.png")));
				song.play(volume, framePos);
				
				}
		});
		play_music_1_1.setBounds(10, 134, 70, 30);
		panel_1.add(play_music_1_1);
		
		JSeparator separator3 = new JSeparator();
		separator3.setBackground(Color.BLACK);
		separator3.setBounds(0, 174, 1294, 9);
		panel_1.add(separator3);
		
		JSeparator separator_vertical = new JSeparator();
		separator_vertical.setOrientation(SwingConstants.VERTICAL);
		separator_vertical.setBackground(Color.BLACK);
		separator_vertical.setBounds(92, 0, 25, 175);
		panel_1.add(separator_vertical);
		
		JLabel song_name3 = new JLabel("Dutchavelli - Bando Diaries");
		song_name3.setFont(new Font("Source Sans Pro", Font.BOLD, 20));
		song_name3.setBounds(129, 122, 293, 35);
		panel_1.add(song_name3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 282, 60);
		mymusic_panel.add(panel_2);
		
		JPanel shop_panel = new JPanel();
		shop_panel.setBackground(new Color(200, 226, 234));
		change_panel.add(shop_panel, "name_22376715666500");
		shop_panel.setLayout(null);
		
		JPanel songalbum_panel = new JPanel();
		songalbum_panel.setBackground(new Color(65, 69, 80));
		songalbum_panel.setBounds(276, 0, 1018, 60);
		shop_panel.add(songalbum_panel);
		songalbum_panel.setLayout(null);
		
		JButton songs_button = new JButton("");
		songs_button.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/songs_m.png")));
		songs_button.setBounds(0, 0, 507, 60);
		songs_button.setOpaque(false);
		songs_button.setContentAreaFilled(false);
		songs_button.setBorderPainted(false);
		songs_button.setRolloverEnabled(true);
		songs_button.setRolloverIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/songs_m-hover.png")));
		songalbum_panel.add(songs_button);
		
		JButton albums_button = new JButton("");
		albums_button.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/albums_m.png")));
		albums_button.setBounds(519, 0, 507, 60);
		albums_button.setOpaque(false);
		albums_button.setContentAreaFilled(false);
		albums_button.setBorderPainted(false);
		albums_button.setRolloverEnabled(true);
		albums_button.setRolloverIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/albums_m-hover.png")));
		songalbum_panel.add(albums_button);
		
		JPanel shop_card_panel = new JPanel();
		shop_card_panel.setBounds(0, 58, 1294, 694);
		shop_panel.add(shop_card_panel);
		shop_card_panel.setLayout(new CardLayout(0, 0));
		
		
		JPanel song_panel = new JPanel();
		shop_card_panel.add(song_panel, "name_29342290723900");
		song_panel.setLayout(null);
		
		JLabel lblSongs = new JLabel("songs");
		lblSongs.setFont(new Font("Source Sans Pro", Font.PLAIN, 29));
		lblSongs.setBounds(262, 5, 267, 282);
		song_panel.add(lblSongs);
		
		JList list = new JList();
		list.setBounds(43, 248, 140, 296);
		song_panel.add(list);
		
		table = new JTable();
		table.setBounds(376, 248, 313, 282);
		song_panel.add(table);
		
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 282, 60);
		shop_panel.add(panel_3);
		
		JPanel settings_panel = new JPanel();
		settings_panel.setBackground(new Color(153, 102, 102));
		change_panel.add(settings_panel, "name_22387308818100");
		JLabel chooseThemeLabel = new JLabel("Wybierz motyw aplikacji:");
		chooseThemeLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		settings_panel.add(chooseThemeLabel);
		
		
		
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
		myaccount_button.setBounds(-15, 13, 204, 50);
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
		mymusic_button.setBounds(201, 13, 204, 50);
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
		shop_button.setBounds(417, 13, 204, 50);
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
		settings_button.setBounds(633, 13, 204, 50);
		settings_button.setRolloverEnabled(true);
		settings_button.setRolloverIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/settings-hover.png")));
		menu_panel.add(settings_button);
		
		JButton logout_button = new JButton("");
		logout_button.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/logout.png")));
		logout_button.setOpaque(false);
		logout_button.setContentAreaFilled(false);
		logout_button.setBorderPainted(false);
		logout_button.setBounds(833, 13, 204, 50);
		logout_button.setRolloverEnabled(true);
		logout_button.setRolloverIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/logout-hover.png")));
		menu_panel.add(logout_button);
		
		JPanel logo_panel = new JPanel();
		logo_panel.setBackground(SystemColor.controlHighlight);
		logo_panel.setBounds(0, 0, 280, 70);
		frame.getContentPane().add(logo_panel);
		logo_panel.setLayout(null);
		
		JLabel musvix_logo = new JLabel("");
		musvix_logo.setBackground(new Color(248, 248, 255));
		musvix_logo.setBounds(-33, 0, 260, 70);
		logo_panel.add(musvix_logo);
		musvix_logo.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/musvix_left_logo.png")));
		
		JLabel logo_figure = new JLabel("");
		logo_figure.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/logo_left.png")));
		logo_figure.setBounds(224, 0, 56, 70);
		logo_panel.add(logo_figure);
		
		JRadioButton selectLightThemeButton = new JRadioButton("jasny");
		selectLightThemeButton.addActionListener(new ActionListener() { //zmiana dla jasnego motywu
			public void actionPerformed(ActionEvent e) {
				//zmiana koloru wewnetrznego okna
				chooseThemeLabel.setForeground(new Color(0,0,0));
				settings_panel.setBackground(new Color(189,192,208)); //panel ustawien - LIGHT THEME
				myacc_panel.setBackground(new Color(189,192,208));
				mymusic_panel.setBackground(new Color(189,192,208));
				shop_panel.setBackground(new Color(189,192,208));
				//zmiana koloru zewnetrznego okna
				logo_panel.setBackground(new Color(189,192,208));
				menu_panel.setBackground(new Color(68,97,240));
				player_panel.setBackground(new Color(68,97,240));
				logo_figure.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/logo_right.png")));
			}
		});
		
		buttonGroup.add(selectLightThemeButton);
		settings_panel.add(selectLightThemeButton);
		selectLightThemeButton.setSelected(true);
		
		
		
		//CIEMNY MOTYW
		JRadioButton selectDarkThemeButton = new JRadioButton("ciemny");
		selectDarkThemeButton.addActionListener(new ActionListener() { //zmiana dla ciemnego motywu 
			public void actionPerformed(ActionEvent e) {
				//zmiana koloru wewnetrznego okna
				chooseThemeLabel.setForeground(new Color(255, 255,255));
				settings_panel.setBackground(new Color(88,63,63)); //panel ustawie� - DARK THEME
				myacc_panel.setBackground(new Color(88,63,63));
				mymusic_panel.setBackground(new Color(88,63,63));
				shop_panel.setBackground(new Color(88,63,63));
				//zmiana koloru zewnetrznego okna
				logo_panel.setBackground(new Color(88,63,63));
				menu_panel.setBackground(new Color(31, 33, 38));
				player_panel.setBackground(new Color(192,32,71));
				logo_figure.setIcon(new ImageIcon(main_panel.class.getResource("/panel_glowny/logo_left.png")));
			}
		});
		buttonGroup.add(selectDarkThemeButton);
		settings_panel.add(selectDarkThemeButton);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
       
		JSlider source = (JSlider)e.getSource();
        volume = source.getValue();    
        song.changeVolume(volume);
       
	}
}
