package edu.asu.ser215.pathfinder.gui.map;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.asu.ser215.pathfinder.character.PlayerCharacter;
import edu.asu.ser215.pathfinder.inventory.Inventory;

public class MapPanel extends JPanel
{
	private static final long serialVersionUID = -5815553248180040761L;
	public static final float DEFAULT_GRID_OPACITY = 0.2F;
	public static final Color DEFAULT_GRID_COLOR = Color.black;

	private GridPanel gridPanel;
	
	/**
	 * Constructs a MapPanel object with the specified background image and
	 * grid size.
	 * 
	 * @param backgroundImage	Image to display underneath the grid
	 * @param width				Width of the grid in tiles
	 * @param height			Height of the grid in tiles
	 */
	public MapPanel(Image backgroundImage, Dimension mapPanelDimension, Dimension buttonSize)
	{
		// Construct this panel with border layout
		super(new BorderLayout());
		
		// Construct a base panel with default layout // Preferred sizes are respected
		// This will hold the map and grid
		JPanel mapPanel = new JPanel();
		
		// Construct a control panel to hold misc. buttons and controls
		JPanel controlPanel = new JPanel();
		
		// Construct grid to be the size of mapPanelDimension, with tiles
		// resolved at buttonSize. // GridPanel is auto-populated
		this.gridPanel = new GridPanel(mapPanelDimension, buttonSize, backgroundImage);
		
		//TODO remove test
		try {
			getGridTiles()[5][5].setToken(PlayerCharacter.generateRandomPlayerCharacter().createToken());
			getGridTiles()[5][9].setToken(PlayerCharacter.generateRandomPlayerCharacter().createToken());
			getGridTiles()[5][14].setToken((new Inventory()).createToken());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Populate mapPanel
		mapPanel.add(gridPanel);
		
		// Populate controlPanel
		GridToggleButton gridToggleButton = new GridToggleButton("Toggle Grid", gridPanel, false);
		controlPanel.add(gridToggleButton);
		
		JButton effectToggleButton = gridToggleButton.getEffectToggleButton();
		effectToggleButton.setFocusPainted(false);
		controlPanel.add(effectToggleButton);
		
		// Populate this panel
		this.add(mapPanel, BorderLayout.PAGE_START);
		this.add(controlPanel, BorderLayout.SOUTH);
	}

	public Tile[][] getGridTiles()
	{
		return gridPanel.getGridTiles();
	}
	
	public static class GridToggleButton extends JButton
	{
		private static final long serialVersionUID = -323856403337777142L;
		
		public GridToggleButton(String buttonName, GridPanel associatedPanel, 
				boolean toggleWithEffect)
		{
			super(buttonName);
			this.addActionListener(new GridToggleListener(associatedPanel, toggleWithEffect));
			this.setFocusPainted(false);
		}
		
		public JButton getEffectToggleButton()
		{
			return ((GridToggleListener) this.getActionListeners()[0]).getEffectToggleButton();
		}
		
	}
	
	public static class GridToggleListener implements ActionListener
	{
		GridPanel associatedPanel;
		boolean toggleWithEffect; // If true, grid will dissolve in/out. 
								  // Otherwise, grid will appear/disappear normally.
		
		public GridToggleListener(GridPanel associatedPanel, boolean toggleWithEffect)
		{
			this.associatedPanel = associatedPanel;
			this.toggleWithEffect = toggleWithEffect;
		}
		
		@Override
		public void actionPerformed(ActionEvent event)
		{
			associatedPanel.toggleGridVisability();
			
			// Determine paint style
			if (!toggleWithEffect)
				associatedPanel.repaint();
		}
		
		public JButton getEffectToggleButton()
		{
			JButton button = new JButton("Toggle Grid Effect");
			button.addActionListener(new EffectToggleListener(this));
			
			return button;
		}
		
	}
	
	public static class EffectToggleListener implements ActionListener
	{
		GridToggleListener associatedListener;
		
		public EffectToggleListener(GridToggleListener associatedListener)
		{
			this.associatedListener = associatedListener;
		}
		
		@Override
		public void actionPerformed(ActionEvent event)
		{
			associatedListener.toggleWithEffect = !associatedListener.toggleWithEffect;
		}
		
	}
}
