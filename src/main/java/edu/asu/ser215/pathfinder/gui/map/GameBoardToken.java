package edu.asu.ser215.pathfinder.gui.map;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import edu.asu.ser215.pathfinder.TokenEntity;

/**
 * Represents a piece on the gameBoard (called a token). Each token is linked 
 * to an entity that it represents (e.g. a Player, and NPC, a Monster, an 
 * Inventory, etc.). Tokens track the entity they are linked to, and the icon for
 * that entity, but do not display or handle MouseEvents directly. Events should
 * be handled by a Tile that holds a token object.
 * 
 * @author Zach Moore
 * @see edu.asu.ser215.pathfinder.gui.map.Tile
 *
 */
public class GameBoardToken<T extends TokenEntity>
{
	public static class DefaultIcons
	{
		public static final String defaultTokenPath = "res/resourcepacks/default/img/defaultToken.png";
		public static final String playerTokenPath = "res/resourcepacks/default/img/defaultPlayerToken.png";
		public static final String monsterTokenPath = "res/resourcepacks/default/img/defaultMonsterToken.png";
		public static final String npcTokenPath = "res/resourcepacks/default/img/defaultNPCToken.png";
		public static final String inventoryTokenPath = "res/resourcepacks/default/img/defaultInventoryToken.png";
		
		public static final ImageIcon defaultToken = loadImageIcon(defaultTokenPath);
		public static final ImageIcon playerToken = loadImageIcon(playerTokenPath);
		public static final ImageIcon monsterToken = loadImageIcon(monsterTokenPath);
		public static final ImageIcon npcToken = loadImageIcon(npcTokenPath);
		public static final ImageIcon inventoryToken = loadImageIcon(inventoryTokenPath);
		
		public static ImageIcon loadImageIcon(String imagePath)
		{
			BufferedImage image = null;
			ImageIcon icon = null;
			
			try
			{
				image = ImageIO.read(new File(imagePath));
				icon = new ImageIcon(image);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			return icon;
		}
	}
	
	protected ImageIcon icon;
	protected T tokenEntity;
	
	public GameBoardToken(T tokenEntity, ImageIcon icon) throws NullPointerException
	{
		if (tokenEntity == null)
			throw new NullPointerException("null tokenEntity passed to constructor");
		this.tokenEntity = tokenEntity;
		this.icon = icon;
	}

	public ImageIcon getIcon()
	{
		return icon;
	}

	public void setIcon(ImageIcon icon)
	{
		this.icon = icon;
	}
	
	public int getHighlightRange()
	{
		//TODO replace with character movement range
		//TODO add support for multiple token types
		//TODO return 0 for immobile and non-ranged tokens
		//TODO convert from feet to grid squares
		return 3;
	}

	public T getTokenEntity() {
		return tokenEntity;
	}
	
	
}
