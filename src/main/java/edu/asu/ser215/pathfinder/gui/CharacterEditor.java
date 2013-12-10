package edu.asu.ser215.pathfinder.gui;

import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class CharacterEditor extends JFrame {
	private static final long serialVersionUID = 7798210462814857748L;
	private JTextField character_name;
	private JTextField character_homeland;
	private JTextField character_age;
	private JTextField character_eyes;
	private JTextField character_hair;
	private JTextField character_weight;
	private JTextField character_height;

	public CharacterEditor() throws HeadlessException {
		this.getContentPane().setLayout(
				new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("50dlu"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_COLSPEC, }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"), }));

		JLabel lblName = new JLabel("Name");
		this.getContentPane().add(lblName, "2, 2, right, default");

		this.character_name = new JTextField();
		this.getContentPane().add(this.character_name, "4, 2, fill, default");
		this.character_name.setColumns(10);

		JLabel lblRace = new JLabel("Race");
		this.getContentPane().add(lblRace, "2, 4, right, default");

		JComboBox character_race = new JComboBox();
		this.getContentPane().add(character_race, "4, 4, fill, default");

		JLabel lblClass = new JLabel("Class");
		this.getContentPane().add(lblClass, "2, 6, right, default");

		JComboBox character_class = new JComboBox();
		this.getContentPane().add(character_class, "4, 6, fill, default");

		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		this.getContentPane().add(tabbedPane, "2, 8, 3, 1, fill, fill");

		JPanel general_tab = new JPanel();
		tabbedPane.addTab("General", null, general_tab, null);
		general_tab
				.setLayout(new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_COLSPEC, }, new RowSpec[] {
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
						FormFactory.DEFAULT_ROWSPEC, }));

		JLabel lblSize = new JLabel("Size");
		lblSize.setHorizontalAlignment(SwingConstants.LEFT);
		lblSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
		general_tab.add(lblSize, "2, 2, right, default");

		JComboBox character_size = new JComboBox();
		general_tab.add(character_size, "4, 2, fill, default");

		JLabel lblHeight = new JLabel("Height");
		lblHeight.setHorizontalAlignment(SwingConstants.LEFT);
		lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		general_tab.add(lblHeight, "2, 4, right, default");

		this.character_height = new JTextField();
		this.character_height.setColumns(10);
		general_tab.add(this.character_height, "4, 4, fill, default");

		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setHorizontalAlignment(SwingConstants.LEFT);
		lblWeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		general_tab.add(lblWeight, "2, 6, right, default");

		this.character_weight = new JTextField();
		this.character_weight.setColumns(10);
		general_tab.add(this.character_weight, "4, 6, fill, default");

		JLabel lblHair = new JLabel("Hair");
		lblHair.setHorizontalAlignment(SwingConstants.LEFT);
		lblHair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		general_tab.add(lblHair, "2, 8, right, default");

		this.character_hair = new JTextField();
		this.character_hair.setColumns(10);
		general_tab.add(this.character_hair, "4, 8, fill, default");

		JLabel lblEyes = new JLabel("Eyes");
		lblEyes.setHorizontalAlignment(SwingConstants.LEFT);
		lblEyes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		general_tab.add(lblEyes, "2, 10, right, default");

		this.character_eyes = new JTextField();
		this.character_eyes.setColumns(10);
		general_tab.add(this.character_eyes, "4, 10, fill, default");

		JLabel lblAge = new JLabel("Age");
		lblAge.setHorizontalAlignment(SwingConstants.LEFT);
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		general_tab.add(lblAge, "2, 12, right, default");

		this.character_age = new JTextField();
		general_tab.add(this.character_age, "4, 12, fill, default");
		this.character_age.setColumns(10);

		JLabel lblHomeland = new JLabel("Homeland");
		lblHomeland.setHorizontalAlignment(SwingConstants.LEFT);
		lblHomeland.setFont(new Font("Tahoma", Font.PLAIN, 14));
		general_tab.add(lblHomeland, "2, 14, right, default");

		this.character_homeland = new JTextField();
		general_tab.add(this.character_homeland, "4, 14, fill, default");
		this.character_homeland.setColumns(10);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setHorizontalAlignment(SwingConstants.LEFT);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		general_tab.add(lblGender, "2, 16, right, default");

		JComboBox character_gender = new JComboBox();
		general_tab.add(character_gender, "4, 16, fill, default");

		JPanel abilities_tab = new JPanel();
		tabbedPane.addTab("Abilities", null, abilities_tab, null);
		abilities_tab
				.setLayout(new FormLayout(new ColumnSpec[] {
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
						FormFactory.RELATED_GAP_COLSPEC, }, new RowSpec[] {
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
						FormFactory.DEFAULT_ROWSPEC, }));

		JLabel lblScore = new JLabel("Score");
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		abilities_tab.add(lblScore, "6, 2");

		JLabel lblModifier = new JLabel("Modifier");
		lblModifier.setHorizontalAlignment(SwingConstants.CENTER);
		abilities_tab.add(lblModifier, "12, 2");

		JLabel lblCharisma = new JLabel("Charisma");
		lblCharisma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCharisma.setHorizontalAlignment(SwingConstants.LEFT);
		abilities_tab.add(lblCharisma, "2, 4");

		JButton button = new JButton("-");
		abilities_tab.add(button, "4, 4");

		JLabel label = new JLabel("1");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		abilities_tab.add(label, "6, 4");

		JButton button_1 = new JButton("+");
		abilities_tab.add(button_1, "8, 4");

		JButton button_2 = new JButton("-");
		abilities_tab.add(button_2, "10, 4");

		JLabel label_1 = new JLabel("1 (+3)");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		abilities_tab.add(label_1, "12, 4");

		JButton button_3 = new JButton("+");
		abilities_tab.add(button_3, "14, 4");

		JLabel lblConstitution = new JLabel("Constitution");
		lblConstitution.setHorizontalAlignment(SwingConstants.LEFT);
		lblConstitution.setFont(new Font("Tahoma", Font.PLAIN, 14));
		abilities_tab.add(lblConstitution, "2, 6");

		JButton button_4 = new JButton("-");
		abilities_tab.add(button_4, "4, 6");

		JLabel label_2 = new JLabel("1");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		abilities_tab.add(label_2, "6, 6");

		JButton button_14 = new JButton("+");
		abilities_tab.add(button_14, "8, 6");

		JButton button_9 = new JButton("-");
		abilities_tab.add(button_9, "10, 6");

		JLabel label_7 = new JLabel("1 (+3)");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		abilities_tab.add(label_7, "12, 6");

		JButton button_19 = new JButton("+");
		abilities_tab.add(button_19, "14, 6");

		JLabel lblDexterity = new JLabel("Dexterity");
		lblDexterity.setHorizontalAlignment(SwingConstants.LEFT);
		lblDexterity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		abilities_tab.add(lblDexterity, "2, 8");

		JButton button_5 = new JButton("-");
		abilities_tab.add(button_5, "4, 8");

		JLabel label_3 = new JLabel("1");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		abilities_tab.add(label_3, "6, 8");

		JButton button_15 = new JButton("+");
		abilities_tab.add(button_15, "8, 8");

		JButton button_10 = new JButton("-");
		abilities_tab.add(button_10, "10, 8");

		JLabel label_8 = new JLabel("1 (+3)");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		abilities_tab.add(label_8, "12, 8");

		JButton button_20 = new JButton("+");
		abilities_tab.add(button_20, "14, 8");

		JLabel lblIntelligence = new JLabel("Intelligence");
		lblIntelligence.setHorizontalAlignment(SwingConstants.LEFT);
		lblIntelligence.setFont(new Font("Tahoma", Font.PLAIN, 14));
		abilities_tab.add(lblIntelligence, "2, 10");

		JButton button_6 = new JButton("-");
		abilities_tab.add(button_6, "4, 10");

		JLabel label_4 = new JLabel("1");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		abilities_tab.add(label_4, "6, 10");

		JButton button_16 = new JButton("+");
		abilities_tab.add(button_16, "8, 10");

		JButton button_11 = new JButton("-");
		abilities_tab.add(button_11, "10, 10");

		JLabel label_9 = new JLabel("1 (+3)");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		abilities_tab.add(label_9, "12, 10");

		JButton button_21 = new JButton("+");
		abilities_tab.add(button_21, "14, 10");

		JLabel lblStrength = new JLabel("Strength");
		lblStrength.setHorizontalAlignment(SwingConstants.LEFT);
		lblStrength.setFont(new Font("Tahoma", Font.PLAIN, 14));
		abilities_tab.add(lblStrength, "2, 12");

		JButton button_7 = new JButton("-");
		abilities_tab.add(button_7, "4, 12");

		JLabel label_5 = new JLabel("1");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		abilities_tab.add(label_5, "6, 12");

		JButton button_17 = new JButton("+");
		abilities_tab.add(button_17, "8, 12");

		JButton button_12 = new JButton("-");
		abilities_tab.add(button_12, "10, 12");

		JLabel label_10 = new JLabel("1 (+3)");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		abilities_tab.add(label_10, "12, 12");

		JButton button_22 = new JButton("+");
		abilities_tab.add(button_22, "14, 12");

		JLabel lblWisdom = new JLabel("Wisdom");
		lblWisdom.setHorizontalAlignment(SwingConstants.LEFT);
		lblWisdom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		abilities_tab.add(lblWisdom, "2, 14");

		JButton button_8 = new JButton("-");
		abilities_tab.add(button_8, "4, 14");

		JLabel label_6 = new JLabel("1");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		abilities_tab.add(label_6, "6, 14");

		JButton button_18 = new JButton("+");
		abilities_tab.add(button_18, "8, 14");

		JButton button_13 = new JButton("-");
		abilities_tab.add(button_13, "10, 14");

		JLabel label_11 = new JLabel("1 (+3)");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		abilities_tab.add(label_11, "12, 14");

		JButton button_23 = new JButton("+");
		abilities_tab.add(button_23, "14, 14");

		JPanel skills_tab = new JPanel();
		tabbedPane.addTab("Skills", null, skills_tab, null);
		skills_tab
				.setLayout(new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_COLSPEC, }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		JLabel lblAvailableSkillPoints = new JLabel("Available Skill Points:");
		lblAvailableSkillPoints.setHorizontalAlignment(SwingConstants.RIGHT);
		skills_tab.add(lblAvailableSkillPoints, "2, 2");

		JLabel available_skill_pts = new JLabel("12");
		skills_tab.add(available_skill_pts, "4, 2");

		JLabel lblCurrent = new JLabel("Current");
		lblCurrent.setHorizontalAlignment(SwingConstants.CENTER);
		skills_tab.add(lblCurrent, "4, 4");

		JLabel lblRank = new JLabel("Rank");
		lblRank.setHorizontalAlignment(SwingConstants.CENTER);
		skills_tab.add(lblRank, "6, 4");

		JLabel lblAcrobatics = new JLabel("Acrobatics");
		lblAcrobatics.setHorizontalAlignment(SwingConstants.LEFT);
		lblAcrobatics.setFont(new Font("Tahoma", Font.PLAIN, 14));
		skills_tab.add(lblAcrobatics, "2, 6");

		JLabel label_15 = new JLabel("1");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		skills_tab.add(label_15, "4, 6");

		JLabel label_13 = new JLabel("1");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		skills_tab.add(label_13, "6, 6");

		JButton btnNewButton = new JButton("Increase");
		skills_tab.add(btnNewButton, "8, 6");

		JPanel inventory_tab = new JPanel();
		tabbedPane.addTab("Inventory", null, inventory_tab, null);

		JPanel character_notes = new JPanel();
		tabbedPane.addTab("Notes", null, character_notes, null);
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
