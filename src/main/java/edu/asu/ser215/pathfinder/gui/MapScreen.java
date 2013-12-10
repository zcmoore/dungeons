package edu.asu.ser215.pathfinder.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import edu.asu.ser215.pathfinder.Game;
import edu.asu.ser215.pathfinder.gui.GamePanel.GamePanelListener;
import edu.asu.ser215.pathfinder.gui.NPCList.NPCListListener;
import edu.asu.ser215.pathfinder.gui.map.MapPanel;

public class MapScreen extends GamePanel<GamePanelListener> implements
		NPCListListener, MouseListener, MouseMotionListener {

	private static final long serialVersionUID = -6459058384168850722L;
	public static final Dimension PREFERRED_RESOLUTION = Game.getPreferredResolution();

	public MapScreen()
	{
		super();
		this.setPreferredSize(PREFERRED_RESOLUTION);
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
		splitPane.setResizeWeight(0); //make left pane as small as possible
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
		//TODO populate right pane
		//TODO replace with constants
		int numberOfTiles = Game.getPreferredResolution().height / 50 - 1;
		MapPanel mapPanel = new MapPanel(null, numberOfTiles, numberOfTiles, 
				new Dimension(50, 50));
		splitPane.setRightComponent(mapPanel);
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
