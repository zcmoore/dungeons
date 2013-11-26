package edu.asu.ser215.pathfinder.gui;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Button;

public class CharacterEditor extends JFrame {
	private JTextField textField;

	public CharacterEditor() throws HeadlessException {
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("50dlu"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblName = new JLabel("Name");
		getContentPane().add(lblName, "2, 2, right, default");
		
		textField = new JTextField();
		getContentPane().add(textField, "4, 2, fill, default");
		textField.setColumns(10);
		
		JLabel lblRace = new JLabel("Race");
		getContentPane().add(lblRace, "2, 4, right, default");
		
		JComboBox comboBox = new JComboBox();
		getContentPane().add(comboBox, "4, 4, fill, default");
		
		JLabel lblClass = new JLabel("Class");
		getContentPane().add(lblClass, "2, 6, right, default");
		
		JComboBox comboBox_1 = new JComboBox();
		getContentPane().add(comboBox_1, "4, 6, fill, default");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, "2, 8, 3, 1, fill, fill");
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("General", null, panel_2, null);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Abilities", null, panel, null);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblScore = new JLabel("Score");
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblScore, "6, 2");
		
		JLabel lblModifier = new JLabel("Modifier");
		lblModifier.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblModifier, "12, 2");
		
		JLabel lblCharisma = new JLabel("Charisma");
		lblCharisma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCharisma.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblCharisma, "2, 4");
		
		JButton button = new JButton("-");
		panel.add(button, "4, 4");
		
		JLabel label = new JLabel("1");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label, "6, 4");
		
		JButton button_1 = new JButton("+");
		panel.add(button_1, "8, 4");
		
		JButton button_2 = new JButton("-");
		panel.add(button_2, "10, 4");
		
		JLabel label_1 = new JLabel("1 (+3)");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_1, "12, 4");
		
		JButton button_3 = new JButton("+");
		panel.add(button_3, "14, 4");
		
		JLabel lblConstitution = new JLabel("Constitution");
		lblConstitution.setHorizontalAlignment(SwingConstants.LEFT);
		lblConstitution.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblConstitution, "2, 6");
		
		JButton button_4 = new JButton("-");
		panel.add(button_4, "4, 6");
		
		JLabel label_2 = new JLabel("1");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_2, "6, 6");
		
		JButton button_14 = new JButton("+");
		panel.add(button_14, "8, 6");
		
		JButton button_9 = new JButton("-");
		panel.add(button_9, "10, 6");
		
		JLabel label_7 = new JLabel("1 (+3)");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_7, "12, 6");
		
		JButton button_19 = new JButton("+");
		panel.add(button_19, "14, 6");
		
		JLabel lblDexterity = new JLabel("Dexterity");
		lblDexterity.setHorizontalAlignment(SwingConstants.LEFT);
		lblDexterity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblDexterity, "2, 8");
		
		JButton button_5 = new JButton("-");
		panel.add(button_5, "4, 8");
		
		JLabel label_3 = new JLabel("1");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_3, "6, 8");
		
		JButton button_15 = new JButton("+");
		panel.add(button_15, "8, 8");
		
		JButton button_10 = new JButton("-");
		panel.add(button_10, "10, 8");
		
		JLabel label_8 = new JLabel("1 (+3)");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_8, "12, 8");
		
		JButton button_20 = new JButton("+");
		panel.add(button_20, "14, 8");
		
		JLabel lblIntelligence = new JLabel("Intelligence");
		lblIntelligence.setHorizontalAlignment(SwingConstants.LEFT);
		lblIntelligence.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblIntelligence, "2, 10");
		
		JButton button_6 = new JButton("-");
		panel.add(button_6, "4, 10");
		
		JLabel label_4 = new JLabel("1");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_4, "6, 10");
		
		JButton button_16 = new JButton("+");
		panel.add(button_16, "8, 10");
		
		JButton button_11 = new JButton("-");
		panel.add(button_11, "10, 10");
		
		JLabel label_9 = new JLabel("1 (+3)");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_9, "12, 10");
		
		JButton button_21 = new JButton("+");
		panel.add(button_21, "14, 10");
		
		JLabel lblStrength = new JLabel("Strength");
		lblStrength.setHorizontalAlignment(SwingConstants.LEFT);
		lblStrength.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblStrength, "2, 12");
		
		JButton button_7 = new JButton("-");
		panel.add(button_7, "4, 12");
		
		JLabel label_5 = new JLabel("1");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_5, "6, 12");
		
		JButton button_17 = new JButton("+");
		panel.add(button_17, "8, 12");
		
		JButton button_12 = new JButton("-");
		panel.add(button_12, "10, 12");
		
		JLabel label_10 = new JLabel("1 (+3)");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_10, "12, 12");
		
		JButton button_22 = new JButton("+");
		panel.add(button_22, "14, 12");
		
		JLabel lblWisdom = new JLabel("Wisdom");
		lblWisdom.setHorizontalAlignment(SwingConstants.LEFT);
		lblWisdom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblWisdom, "2, 14");
		
		JButton button_8 = new JButton("-");
		panel.add(button_8, "4, 14");
		
		JLabel label_6 = new JLabel("1");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_6, "6, 14");
		
		JButton button_18 = new JButton("+");
		panel.add(button_18, "8, 14");
		
		JButton button_13 = new JButton("-");
		panel.add(button_13, "10, 14");
		
		JLabel label_11 = new JLabel("1 (+3)");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_11, "12, 14");
		
		JButton button_23 = new JButton("+");
		panel.add(button_23, "14, 14");
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Skills", null, panel_1, null);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblAvailableSkillPoints = new JLabel("Available Skill Points:");
		lblAvailableSkillPoints.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblAvailableSkillPoints, "2, 2");
		
		JLabel label_12 = new JLabel("12");
		panel_1.add(label_12, "4, 2");
		
		JLabel lblCurrent = new JLabel("Current");
		lblCurrent.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblCurrent, "4, 4");
		
		JLabel lblRank = new JLabel("Rank");
		lblRank.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblRank, "6, 4");
		
		JLabel lblAcrobatics = new JLabel("Acrobatics");
		lblAcrobatics.setHorizontalAlignment(SwingConstants.LEFT);
		lblAcrobatics.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblAcrobatics, "2, 6");
		
		JLabel label_15 = new JLabel("1");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_15, "4, 6");
		
		JLabel label_13 = new JLabel("1");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label_13, "6, 6");
		
		JButton btnNewButton = new JButton("Increase");
		panel_1.add(btnNewButton, "8, 6");
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Inventory", null, panel_4, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Notes", null, panel_3, null);
	}

	public CharacterEditor(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public CharacterEditor(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public CharacterEditor(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
