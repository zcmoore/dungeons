package edu.asu.ser215.pathfinder.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class MainMenu extends JPanel implements ActionListener {

	public static final String START_BUTTON = "Start Game",
			OPTIONS_BUTTON = "Options";
	private static final long serialVersionUID = 1459394009293263869L;
	protected ArrayList<MainMenuListener> listeners;

	public MainMenu() {
		super();
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, }, new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, }));

		JLabel lblDungeons = new JLabel("Dungeons");
		lblDungeons.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDungeons.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblDungeons, "4, 2");

		JButton btnStartGame = new JButton(START_BUTTON);
		btnStartGame.addActionListener(this);
		add(btnStartGame, "4, 4");

		JButton btnOptions = new JButton(OPTIONS_BUTTON);
		btnOptions.addActionListener(this);
		add(btnOptions, "4, 6");

		JButton btnCredits = new JButton("Credits");
		add(btnCredits, "4, 8");
		listeners = new ArrayList<MainMenuListener>();

	}

	public MainMenu(MainMenuListener listener) {
		this();
		this.addListener(listener);
	}

	public boolean addListener(MainMenuListener listener) {
		return this.listeners.add(listener);
	}

	public boolean removeListener(MainMenuListener listener) {
		return this.listeners.remove(listener);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Add some kind of notify method to automate this.
		if (e.getActionCommand().equalsIgnoreCase(START_BUTTON)) {
			for (MainMenuListener listener : this.listeners) {
				listener.startButton();
			}
		}
		if (e.getActionCommand().equalsIgnoreCase(OPTIONS_BUTTON)) {
			for (MainMenuListener listener : this.listeners) {
				listener.optionsButton();
			}
		}

	}

	public interface MainMenuListener {
		void startButton();

		void optionsButton();
	}

}
