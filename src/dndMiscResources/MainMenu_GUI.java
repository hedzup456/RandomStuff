/**
 * 
 */
package dndMiscResources;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

/**
 * @author Richard
 *
 */
public class MainMenu_GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu_GUI frame = new MainMenu_GUI();
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
	public MainMenu_GUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenu_GUI.class.getResource("/dndMiscResources/Icon.png")));
		setResizable(false);
		setTitle("Richard's Dungeons and Dragons thing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 424);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHelloWhatWould = new JLabel("Hello! What would you like to do today?");
		lblHelloWhatWould.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelloWhatWould.setIcon(null);
		lblHelloWhatWould.setBounds(27, 13, 553, 54);
		lblHelloWhatWould.setBackground(Color.BLACK);
		lblHelloWhatWould.setForeground(Color.BLACK);
		lblHelloWhatWould.setFont(new Font("Malgun Gothic", Font.BOLD, 17));
		contentPane.add(lblHelloWhatWould);
		
		JButton btnManageCharacters = new JButton("<html>\r\nManage <br>\r\nCharacters\r\n</html>");
		btnManageCharacters.setHorizontalTextPosition(SwingConstants.CENTER);
		btnManageCharacters.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		btnManageCharacters.setBounds(27, 71, 263, 136);
		btnManageCharacters.setBackground(new Color(220, 220, 220));
		btnManageCharacters.setForeground(Color.BLACK);
		contentPane.add(btnManageCharacters);
		
		JButton btnNewButton = new JButton("Roll Die");
		btnNewButton.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		btnNewButton.setBounds(317, 71, 263, 136);
		btnNewButton.setBackground(new Color(220, 220, 220));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setLabelFor(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(MainMenu_GUI.class.getResource("/dndMiscResources/Dungeons_and_Dragons.png")));
		lblNewLabel.setBounds(27, 220, 568, 151);
		contentPane.add(lblNewLabel);
	}
}
