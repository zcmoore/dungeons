package edu.asu.ser215.pathfinder.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import edu.asu.ser215.pathfinder.core.GamePanel;
import edu.asu.ser215.pathfinder.core.GamePanel.GamePanelListener;
import edu.asu.ser215.pathfinder.gui.NPCList.NPCListListener;

public class NPCList extends GamePanel<NPCListListener> {
	private static final long serialVersionUID = 6663534601603374402L;
	protected HashMap<String, JPanel> npcs;
	protected JScrollPane scrollPane;
	protected JPanel npc_listing;

	public NPCList() {
		super();
		this.npcs = new HashMap<String, JPanel>();
		this.setLayout(new BorderLayout(0, 0));

		this.scrollPane = new JScrollPane();
		this.add(this.scrollPane, BorderLayout.CENTER);
		this.scrollPane.getVerticalScrollBar().setUnitIncrement(20);

		// NPC toolbar
		JToolBar npc_toolbar = new JToolBar();
		npc_toolbar.setBackground(Color.LIGHT_GRAY);
		npc_toolbar.setEnabled(false);
		npc_toolbar.setFloatable(false);
		this.scrollPane.setColumnHeaderView(npc_toolbar);

		JButton btnDatabase = new JButton("Database");
		btnDatabase.setBackground(Color.LIGHT_GRAY);
		npc_toolbar.add(btnDatabase);
		JButton btnCreateNew = new JButton("Create New");
		btnCreateNew.setBackground(Color.LIGHT_GRAY);
		npc_toolbar.add(btnCreateNew);
		JLabel lblSearch = new JLabel("Search:");
		npc_toolbar.add(lblSearch);
		JTextField txtSearch = new JTextField();
		txtSearch.setToolTipText("Search");
		npc_toolbar.add(txtSearch);
		txtSearch.setColumns(10);

		// NPC Listing
		this.npc_listing = new JPanel();
		this.scrollPane.setViewportView(this.npc_listing);
		this.npc_listing.setLayout(new BoxLayout(this.npc_listing,
				BoxLayout.Y_AXIS));
		this.addNPC("");
		this.addNPC("");
		this.addNPC("");
		this.addNPC("");
		this.addNPC("");
		this.addNPC("");
	}

	public NPCList(NPCListListener listener) {
		this();
		this.addListener(listener);
	}

	public void addNPC(String name) {
		// TODO Add NPC to the list
		JPanel single_npc_listing = new JPanel();
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

		BufferedImage npc_avatar;
		try {
			// Load the BufferedImage
			npc_avatar = ImageIO.read(new File(
					"res/resourcepacks/default/img/orc.png"));
			// Create a new JLabel with a new ImageIcon as the constructor
			// argument
			JLabel picLabel = new JLabel(new ImageIcon(npc_avatar));
			picLabel.setToolTipText("Avatar Tooltip");
			// Add the label to the panel
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
		btnInspect.addActionListener(this);
		single_npc_listing.add(btnInspect, "6, 4");

		JButton btnRemove = new JButton("Loot");
		btnRemove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		single_npc_listing.add(btnRemove, "8, 4");

		JSeparator separator = new JSeparator();
		single_npc_listing.add(separator, "1, 6, 9, 1, fill, center");

		this.npc_listing.add(single_npc_listing);
	}

	public void removeNPC(String name) {
		// TODO Remove NPC from the list
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Create actionPerformed content
		if (e.getActionCommand().equals("Inspect")) {
			for (NPCListListener l : this.listeners) {
				l.characterInspect("");
			}
		}

	}

	public interface NPCListListener extends GamePanelListener {
		public void characterInspect(String name);
	}

}
