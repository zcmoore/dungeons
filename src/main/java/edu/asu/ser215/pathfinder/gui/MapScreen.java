package edu.asu.ser215.pathfinder.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import edu.asu.ser215.pathfinder.core.GamePanel;
import edu.asu.ser215.pathfinder.core.GamePanel.GamePanelListener;
import edu.asu.ser215.pathfinder.gui.NPCList.NPCListListener;

public class MapScreen extends GamePanel<GamePanelListener> implements
		NPCListListener, MouseListener, MouseMotionListener {

	private static final long serialVersionUID = -6459058384168850722L;

	public MapScreen() {
		super();
		this.setLayout(new BorderLayout(0, 0));

		// Menu Bar
		JMenuBar menuBar = new JMenuBar();
		this.add(menuBar, BorderLayout.NORTH);
		JMenu mnPlayers = new JMenu("Players");
		menuBar.add(mnPlayers);
		JMenuItem mntmNew = new JMenuItem("New");
		mnPlayers.add(mntmNew);
		JMenuItem mntmList = new JMenuItem("List");
		mnPlayers.add(mntmList);

		// Split Pane
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		this.add(splitPane);

		// Left Side
		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		splitPane.setLeftComponent(tabbedPane);

		NPCList npcs_tab = new NPCList(this);
		tabbedPane.addTab("NPCs", null, npcs_tab, null);

		JPanel notes_tab = new JPanel();
		tabbedPane.addTab("Notes", null, notes_tab, null);

		JPanel items_tab = new JPanel();
		tabbedPane.addTab("Items", null, items_tab, null);

		// Right Side
		JLabel lblMapGoesHere = new JLabel("Map Goes Here");
		splitPane.setRightComponent(lblMapGoesHere);
	}

	public MapScreen(MapScreenListener listener) {
		this();
		this.addListener(listener);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand());

	}

	public interface MapScreenListener extends GamePanelListener {
		public void characterInspect(String name);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Create mouseDragged content

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Create mouseMoved content

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Create mouseClicked content

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Create mousePressed content

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Create mouseReleased content

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Create mouseEntered content

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Create mouseExited content

	}

	@Override
	public void characterInspect(String name) {
		JFrame f = new CharacterEditor();
		f.setLocationRelativeTo(null);
		f.pack();
		f.setVisible(true);
	}

}
