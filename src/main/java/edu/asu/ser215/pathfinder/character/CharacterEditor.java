package edu.asu.ser215.pathfinder.character;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

@SuppressWarnings("serial")
public class CharacterEditor extends JFrame {
	private JTextField characterName;

	public CharacterEditor() {
		setTitle("Character Editor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(
				new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("75px"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("75px"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("75px"),
						FormFactory.RELATED_GAP_COLSPEC, }, new RowSpec[] {
						FormFactory.NARROW_LINE_GAP_ROWSPEC,
						RowSpec.decode("22px"), FormFactory.LINE_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("2px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("17px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("2px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("20px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("23px"), }));

		JLabel lblCharacterEditor = new JLabel("Character Editor");
		lblCharacterEditor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCharacterEditor.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblCharacterEditor, "2, 2, 5, 1, fill, top");

		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(lblName, "2, 4, right, center");

		characterName = new JTextField();
		getContentPane().add(characterName, "4, 4, 3, 1, fill, top");
		characterName.setColumns(10);

		JLabel lblClass = new JLabel("Class");
		lblClass.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(lblClass, "2, 6, right, center");

		JComboBox characterClass = new JComboBox();
		getContentPane().add(characterClass, "4, 6, 3, 1, fill, top");

		JLabel lblRace = new JLabel("Race");
		lblRace.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(lblRace, "2, 8, right, center");

		JComboBox characterRace = new JComboBox();
		getContentPane().add(characterRace, "4, 8, 3, 1, fill, top");

		JSeparator separator_1 = new JSeparator();
		getContentPane().add(separator_1, "2, 10, 5, 1, fill, top");

		JLabel lblAbilities = new JLabel("Ability");
		lblAbilities.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbilities.setFont(new Font("Arial", Font.PLAIN, 14));
		getContentPane().add(lblAbilities, "2, 12, fill, top");

		JLabel lblScore = new JLabel("Score");
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setFont(new Font("Arial", Font.PLAIN, 14));
		getContentPane().add(lblScore, "4, 12, fill, top");

		JLabel lblModifier = new JLabel("Modifier");
		lblModifier.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifier.setFont(new Font("Arial", Font.PLAIN, 14));
		getContentPane().add(lblModifier, "6, 12, fill, top");

		JLabel lblCharisma = new JLabel("Charisma");
		lblCharisma.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(lblCharisma, "2, 14, right, center");

		JSpinner abilityCharScore = new JSpinner();
		abilityCharScore.setModel(new SpinnerNumberModel(new Integer(0),
				new Integer(0), null, new Integer(1)));
		getContentPane().add(abilityCharScore, "4, 14, fill, top");

		JSpinner spinner_1 = new JSpinner();
		getContentPane().add(spinner_1, "6, 14, fill, top");

		JLabel lblConstitution = new JLabel("Constitution");
		lblConstitution.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(lblConstitution, "2, 16, right, center");

		JSpinner spinner_2 = new JSpinner();
		getContentPane().add(spinner_2, "4, 16, fill, top");

		JSpinner spinner_7 = new JSpinner();
		getContentPane().add(spinner_7, "6, 16, fill, top");

		JLabel lblDexterity = new JLabel("Dexterity");
		lblDexterity.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(lblDexterity, "2, 18, right, center");

		JSpinner spinner_3 = new JSpinner();
		getContentPane().add(spinner_3, "4, 18, fill, top");

		JSpinner spinner_8 = new JSpinner();
		getContentPane().add(spinner_8, "6, 18, fill, top");

		JLabel lblIntelligence = new JLabel("Intelligence");
		lblIntelligence.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(lblIntelligence, "2, 20, right, center");

		JSpinner spinner_4 = new JSpinner();
		getContentPane().add(spinner_4, "4, 20, fill, top");

		JSpinner spinner_9 = new JSpinner();
		getContentPane().add(spinner_9, "6, 20, fill, top");

		JLabel lblStrength = new JLabel("Strength");
		lblStrength.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(lblStrength, "2, 22, right, center");

		JSpinner spinner_5 = new JSpinner();
		getContentPane().add(spinner_5, "4, 22, fill, top");

		JSpinner spinner_10 = new JSpinner();
		getContentPane().add(spinner_10, "6, 22, fill, top");

		JLabel lblWisdom = new JLabel("Wisdom");
		lblWisdom.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(lblWisdom, "2, 24, right, center");

		JSpinner spinner_6 = new JSpinner();
		getContentPane().add(spinner_6, "4, 24, fill, top");

		JSpinner spinner_11 = new JSpinner();
		getContentPane().add(spinner_11, "6, 24, fill, top");

		JSeparator separator = new JSeparator();
		getContentPane().add(separator, "2, 26, 5, 1, fill, top");

		JLabel lblHitPoints = new JLabel("Hit Points");
		lblHitPoints.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(lblHitPoints, "2, 28, fill, center");

		JSpinner spinner_12 = new JSpinner();
		spinner_12.setModel(new SpinnerNumberModel(new Integer(0), new Integer(
				0), null, new Integer(1)));
		getContentPane().add(spinner_12, "4, 28, 3, 1, fill, top");

		JLabel lblExperience = new JLabel("Experience");
		lblExperience.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(lblExperience, "2, 30, fill, center");

		JSpinner spinner_13 = new JSpinner();
		getContentPane().add(spinner_13, "4, 30, 3, 1, fill, top");

		JButton btnReset = new JButton("Reset");
		getContentPane().add(btnReset, "2, 32, fill, top");

		JButton btnRevert = new JButton("Revert");
		getContentPane().add(btnRevert, "4, 32, fill, top");

		JButton btnUpdate = new JButton("Update");
		getContentPane().add(btnUpdate, "6, 32, fill, top");
	}
}
