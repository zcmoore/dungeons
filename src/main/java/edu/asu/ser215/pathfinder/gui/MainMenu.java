package edu.asu.ser215.pathfinder.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import edu.asu.ser215.pathfinder.core.GamePanel;
import edu.asu.ser215.pathfinder.core.GamePanel.GamePanelListener;
import edu.asu.ser215.pathfinder.gui.MainMenu.MainMenuListener;

public class MainMenu extends GamePanel<MainMenuListener> {

	public static final String START_BUTTON = "Start Game",
			OPTIONS_BUTTON = "Options";
	private static final long serialVersionUID = 1459394009293263869L;

	public MainMenu() {
		super();
		this.setLayout(new FormLayout(new ColumnSpec[] {
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
		this.add(lblDungeons, "4, 2");

		JButton btnStartGame = new JButton(MainMenu.START_BUTTON);
		btnStartGame.addActionListener(this);
		this.add(btnStartGame, "4, 4");

		JButton btnOptions = new JButton(MainMenu.OPTIONS_BUTTON);
		btnOptions.addActionListener(this);
		this.add(btnOptions, "4, 6");

		JButton btnCredits = new JButton("Credits");
		this.add(btnCredits, "4, 8");
		this.listeners = new ArrayList<MainMenuListener>();

	}

	public MainMenu(MainMenuListener listener) {
		this();
		this.addListener(listener);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Add some kind of notify method to automate this.
		if (e.getActionCommand().equalsIgnoreCase(MainMenu.START_BUTTON)) {
			for (MainMenuListener listener : this.listeners) {
				listener.startButton();
			}
		}
		if (e.getActionCommand().equalsIgnoreCase(MainMenu.OPTIONS_BUTTON)) {
			for (MainMenuListener listener : this.listeners) {
				listener.optionsButton();
			}
		}
	}

	public interface MainMenuListener extends GamePanelListener {
		void startButton();

		void optionsButton();
	}

}
