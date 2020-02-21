package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import model.interfaces.Player;

public class PlayerModel {
	
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	
	private GameEngine mGameEngine;
	
	private Player player;
	
	public PlayerModel(GameEngine mGameEngine) {
		this.mGameEngine = mGameEngine;
	}
	
	
	public void add() {
		propertyChangeSupport.firePropertyChange("add", null, mGameEngine.getAllPlayers());
	}
	
	public Player getPlayer() {
		if(player != null) {
			return player;
		}else {
			return null;
		}
		
		
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void deselectPlayer() {
		player = null;
	}
	
	public void delete() {
		Player remove = getPlayer();
		mGameEngine.removePlayer(remove);
		propertyChangeSupport.firePropertyChange("delete",null, mGameEngine.getAllPlayers());
		
		
		
		
	}
	
	public void addPropertyListener(PropertyChangeListener property) {
		propertyChangeSupport.addPropertyChangeListener(property);
	}
	
	
	
}
