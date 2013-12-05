package edu.asu.ser215.pathfinder.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class MapScreen extends JPanel implements ActionListener {

	private static final long serialVersionUID = -6459058384168850722L;
	protected ArrayList<MapScreenListener> listeners;
	private JTextField txtSearch;

	public MapScreen() {
		super();
		this.listeners = new ArrayList<MapScreenListener>();
		setLayout(new BorderLayout(0, 0));

		JMenuBar menuBar = new JMenuBar();
		add(menuBar, BorderLayout.NORTH);

		JMenu mnPlayers = new JMenu("Players");
		menuBar.add(mnPlayers);

		JMenuItem mntmNew = new JMenuItem("New");
		mnPlayers.add(mntmNew);

		JMenuItem mntmList = new JMenuItem("List");
		mnPlayers.add(mntmList);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		add(splitPane);

		JLabel lblMapGoesHere = new JLabel("Map Goes Here");
		splitPane.setRightComponent(lblMapGoesHere);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		splitPane.setLeftComponent(tabbedPane);

		JScrollPane npcs_tab = new JScrollPane();
		tabbedPane.addTab("NPCs", null, npcs_tab, null);

		JToolBar npc_toolbar = new JToolBar();
		npc_toolbar.setBackground(Color.LIGHT_GRAY);
		npc_toolbar.setEnabled(false);
		npc_toolbar.setFloatable(false);
		npcs_tab.setColumnHeaderView(npc_toolbar);

		JButton btnDatabase = new JButton("Database");
		btnDatabase.setBackground(Color.LIGHT_GRAY);
		npc_toolbar.add(btnDatabase);

		JButton btnCreateNew = new JButton("Create New");
		btnCreateNew.setBackground(Color.LIGHT_GRAY);
		npc_toolbar.add(btnCreateNew);

		JLabel lblSearch = new JLabel("Search:");
		npc_toolbar.add(lblSearch);

		txtSearch = new JTextField();
		txtSearch.setToolTipText("Search");
		npc_toolbar.add(txtSearch);
		txtSearch.setColumns(10);

		JPanel npc_listing = new JPanel();
		npcs_tab.setViewportView(npc_listing);
		npc_listing.setLayout(new BoxLayout(npc_listing, BoxLayout.Y_AXIS));

		JPanel single_npc_listing = new JPanel();
		npc_listing.add(single_npc_listing);
		single_npc_listing.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC, ColumnSpec.decode("60px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("57px:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("69px:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("71px:grow"),
				FormFactory.RELATED_GAP_COLSPEC, }, new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC, RowSpec.decode("15dlu"),
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, }));

		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File(
					"res/resourcepacks/default/img/orc.png"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			single_npc_listing.add(picLabel, "2, 2, 1, 3");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JLabel lblJoeSchmoe = new JLabel("Joe Schmoe");
		single_npc_listing.add(lblJoeSchmoe, "4, 2, 3, 1, left, center");

		JButton btnAdd = new JButton("Add");
		single_npc_listing.add(btnAdd, "4, 4");

		JButton btnInspect = new JButton("Inspect");
		single_npc_listing.add(btnInspect, "6, 4");

		JButton btnRemove = new JButton("Loot");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		single_npc_listing.add(btnRemove, "8, 4");

		JSeparator separator = new JSeparator();
		single_npc_listing.add(separator, "1, 6, 9, 1, fill, center");

		JPanel notes_tab = new JPanel();
		tabbedPane.addTab("Notes", null, notes_tab, null);

		JPanel items_tab = new JPanel();
		tabbedPane.addTab("Items", null, items_tab, null);
	}

	public MapScreen(MapScreenListener listener) {
		this();
		this.addListener(listener);
	}

	public boolean addListener(MapScreenListener listener) {
		return this.listeners.add(listener);
	}

	public boolean removeListener(MapScreenListener listener) {
		return this.listeners.remove(listener);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public interface MapScreenListener {

	}

}
