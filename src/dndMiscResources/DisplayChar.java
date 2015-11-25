/**
 * 
 */
package dndMiscResources;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

/**
 * @author Richard
 *
 */
public class DisplayChar extends JFrame {
	private PlayerCharacter pc;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public DisplayChar(PlayerCharacter pc) {
		setAlwaysOnTop(true);
		this.pc = pc;
		setTitle(pc.getPlayerName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 1024);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblName = new JLabel("Name: \t" + pc.getPlayerName());
		lblName.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 99));
		lblName.setMaximumSize(new Dimension(1920, 10));
		lblName.setForeground(Color.GREEN);
		lblName.setBackground(new Color(255, 255, 255));
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblName);
		
		JLabel lblCharacterName = new JLabel("Character name: \t" + pc.getName());
		lblCharacterName.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 99));
		lblCharacterName.setMaximumSize(new Dimension(1920, 10));
		lblCharacterName.setForeground(Color.GREEN);
		lblCharacterName.setBackground(new Color(255, 255, 255));
		lblCharacterName.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblCharacterName);
		
		JLabel lblRace = new JLabel("Race: \t" + pc.getRace());
		lblRace.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 99));
		lblRace.setMinimumSize(new Dimension(102, 0));
		lblRace.setMaximumSize(new Dimension(1920, 10));
		lblRace.setForeground(Color.GREEN);
		lblRace.setBackground(new Color(255, 255, 255));
		lblRace.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblRace);
		
		JLabel lblStrength = new JLabel("Strength: \t" + pc.getStrength());
		lblStrength.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 99));
		lblStrength.setMaximumSize(new Dimension(1920, 10));
		lblStrength.setForeground(Color.GREEN);
		lblStrength.setBackground(new Color(255, 255, 255));
		lblStrength.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblStrength);
		
		JLabel lblDexterity = new JLabel("Dexterity: \t" + pc.getDexterity());
		lblDexterity.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 99));
		lblDexterity.setMaximumSize(new Dimension(1920, 10));
		lblDexterity.setForeground(Color.GREEN);
		lblDexterity.setBackground(new Color(255, 255, 255));
		lblDexterity.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblDexterity);
		
		JLabel lblIntelligence = new JLabel("Intelligence: \t" + pc.getIntelligence());
		lblIntelligence.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 99));
		lblIntelligence.setMaximumSize(new Dimension(1920, 10));
		lblIntelligence.setForeground(Color.GREEN);
		lblIntelligence.setBackground(new Color(255, 255, 255));
		lblIntelligence.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblIntelligence);
		
		JLabel lblWisdom = new JLabel("Wisdom: \t" + pc.getWisdom());
		lblWisdom.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 99));
		lblWisdom.setMaximumSize(new Dimension(1920, 10));
		lblWisdom.setForeground(Color.GREEN);
		lblWisdom.setBackground(new Color(255, 255, 255));
		lblWisdom.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblWisdom);
		
		JLabel lblCharisma = new JLabel("Charisma: \t" + pc.getCharisma());
		lblCharisma.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 99));
		lblCharisma.setMaximumSize(new Dimension(1920, 10));
		lblCharisma.setForeground(Color.GREEN);
		lblCharisma.setBackground(new Color(255, 255, 255));
		lblCharisma.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblCharisma);
		
		JLabel lblConstitution = new JLabel("Constitution: \t" + pc.getConstitution());
		lblConstitution.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 99));
		lblConstitution.setMinimumSize(new Dimension(83, 0));
		lblConstitution.setMaximumSize(new Dimension(1920, 10));
		lblConstitution.setForeground(Color.GREEN);
		lblConstitution.setBackground(new Color(255, 255, 255));
		contentPane.add(lblConstitution);
	}
}
