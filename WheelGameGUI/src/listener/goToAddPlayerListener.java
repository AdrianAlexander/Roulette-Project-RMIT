package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import view.AddPlayer;
import view.PlayerModel;
import view.ToolBar;

public class goToAddPlayerListener implements ActionListener{
	
	GameEngine gameEngine;
	PlayerModel model;

	public goToAddPlayerListener(GameEngine gameEngine, PlayerModel model) {
		this.model = model;
		this.gameEngine = gameEngine;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		new AddPlayer(gameEngine, model).setVisible(true);
		
		
	}

}
