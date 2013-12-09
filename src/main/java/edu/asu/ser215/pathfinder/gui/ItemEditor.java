package edu.asu.ser215.pathfinder.gui;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class ItemEditor extends JFrame {
	private static final long serialVersionUID = -6484360824154090738L;
	private JTable table;
	private JTable table_1;

	public ItemEditor() throws HeadlessException {
		this.setTitle("Inventory");

		JSplitPane splitPane = new JSplitPane();
		this.getContentPane().add(splitPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);

		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		panel.add(tabbedPane);

		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Armour", null, scrollPane, null);

		this.table = new JTable();
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.table
				.setModel(new DefaultTableModel(
						new Object[][] {
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null }, }, new String[] { "Name",
								"Type", "Cost", "Weight", "New column",
								"New column", "New column", "New column",
								"New column" }));
		this.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(this.table);

		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("Weapons", null, scrollPane_1, null);

		this.table_1 = new JTable();
		this.table_1.setModel(new DefaultTableModel(new Object[][] {
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null }, }, new String[] {
				"New column", "New column", "New column", "New column",
				"New column" }));
		this.table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_1.setViewportView(this.table_1);
		// TODO Auto-generated constructor stub
	}

	public ItemEditor(GraphicsConfiguration arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ItemEditor(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ItemEditor(String arg0, GraphicsConfiguration arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
