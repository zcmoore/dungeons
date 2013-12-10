package edu.asu.ser215.pathfinder.core;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import edu.asu.ser215.pathfinder.core.GamePanel.GamePanelListener;

/**
 * Base panel in which all displayed game panels should inherit from. GamePanel
 * combines the functionality of JPanel with ActionListener, as well as a custom
 * listener interface to make the creation and implementation of custom panels
 * easier.
 * 
 * @author Moon, Seth
 * 
 * @param <L> The listener interface that is used inside the GamePanel
 */
@SuppressWarnings("serial")
public abstract class GamePanel<L extends GamePanelListener> extends JPanel
		implements ActionListener {
	protected ArrayList<L> listeners;

	public GamePanel() {
		this.listeners = new ArrayList<L>();
	}

	public GamePanel(L listener) {
		this();
		this.addListener(listener);
	}

	public boolean addListener(L listener) {
		return this.listeners.add(listener);
	}

	public boolean removeListener(L listener) {
		return this.listeners.remove(listener);
	}

	/**
	 * Any events that fire notify the GamePanelListeners
	 * 
	 * @author Moon, Seth
	 * 
	 */
	public interface GamePanelListener {}
}
