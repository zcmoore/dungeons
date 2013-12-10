package edu.asu.ser215.pathfinder.core;

import javax.swing.JFrame;

/**
 * A single window that manages GamePanels.
 * 
 * @author Moon, Seth
 * 
 */
@SuppressWarnings("serial")
public abstract class GameFrame extends JFrame {
	public void changePanel(@SuppressWarnings("rawtypes") GamePanel panel) {
		this.setContentPane(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.repaint();
	}
}
