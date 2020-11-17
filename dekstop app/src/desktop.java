import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;

public class desktop {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					desktop window = new desktop();
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
	public desktop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 821, 652);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1300,900);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(31, 33, 38));
		panel.setBounds(0, 0, 135, 853);
		panel.setSize(258,900);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Leszek\\Pictures\\12347839_10207516941498128_659707653499805704_n.jpg"));
		lblNewLabel.setBounds(58, 323, 174, 193);
		panel.add(lblNewLabel);
		
		JLabel lblStaryNajebany = new JLabel("stary najebany");
		lblStaryNajebany.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblStaryNajebany.setForeground(new Color(255, 69, 0));
		lblStaryNajebany.setBounds(73, 257, 154, 27);
		panel.add(lblStaryNajebany);
		
		JLabel lblUstawienia = new JLabel("ustawienia");
		lblUstawienia.setForeground(new Color(255, 255, 255));
		lblUstawienia.setBounds(40, 13, 80, 46);
		panel.add(lblUstawienia);
		
		JLabel lblNazwaStudia = new JLabel("nazwa studia");
		lblNazwaStudia.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNazwaStudia.setForeground(new Color(144, 238, 144));
		lblNazwaStudia.setBounds(46, 111, 200, 82);
		panel.add(lblNazwaStudia);
		
		JLabel lblCosTam = new JLabel("cos tam");
		lblCosTam.setBounds(58, 571, 154, 151);
		panel.add(lblCosTam);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(31, 33, 38));
		panel_1.setBounds(257, 0, 1037, 81);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("muj uzytkownik");
		btnNewButton.setBounds(0, 0, 222, 81);
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(300, 193, 10, 10);
		frame.getContentPane().add(panel_2);
	}
}
