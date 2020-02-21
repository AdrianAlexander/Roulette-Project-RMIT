package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.AddPlayer;
import view.PlayerModel;
import view.ToolBar;



public class addPlayerListener implements ActionListener {

	private GameEngine mGameEngine;
	private Player player;
	private AddPlayer addplayer;
	private List<Player> players;
	private ToolBar bar;
	private PlayerModel model;
	
	
	public addPlayerListener(AddPlayer addPlayer, GameEngine mGameEngine, PlayerModel model) {
		this.addplayer = addPlayer;
		this.mGameEngine = mGameEngine;
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String id = addplayer.getTextId();
		String name = addplayer.getTextName();
		int points = Integer.parseInt(addplayer.getTextPoint());
		player = new SimplePlayer(id, name, points);
		mGameEngine.addPlayer(player);
		System.out.println(mGameEngine.getAllPlayers());
		model.add();
		
		
	}

}
