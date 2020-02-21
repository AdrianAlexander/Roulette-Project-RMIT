package view;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToolBar;

import client.SimpleTestClient;
import listener.deletePlayerListener;
import listener.goToAddPlayerListener;
import listener.goToSetBet;
import listener.spinListener;
import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class ToolBar{
	
	JToolBar toolBar;
	JButton spin, addPlayer, deletePlayer, bet;
	JComboBox combo;
	GameEngine mGameEngine; 
	PlayerModel model;
	private List<Player> players = new ArrayList<>();
	
	
	
	public ToolBar(GameEngine mGameEngine, PlayerModel model) {
		
		this.model = model;
		this.mGameEngine = mGameEngine;
		toolBar = new JToolBar();
		mGameEngine = new GameEngineImpl();
		
		
		spin = new JButton("spin");
		spin.addActionListener(new spinListener(this.mGameEngine, this.model));
		
		addPlayer = new JButton("Add Player");
		addPlayer.addActionListener(new goToAddPlayerListener(this.mGameEngine, this.model));
		
		deletePlayer = new JButton("Delete Player");
		deletePlayer.addActionListener(new deletePlayerListener(this.model));
		
		bet = new JButton("Bet");
		bet.addActionListener(new goToSetBet(this.model, this.mGameEngine));
		
		
			
		toolBar.add(spin);
		toolBar.add(addPlayer);
		toolBar.add(deletePlayer);
		toolBar.add(bet);
		
		
	}
	
	public JToolBar getToolBar() {
		return toolBar;
	}
	
	
	public void setEngine(GameEngine mGameEngine) {
		this.mGameEngine = mGameEngine;
	}
	

}
