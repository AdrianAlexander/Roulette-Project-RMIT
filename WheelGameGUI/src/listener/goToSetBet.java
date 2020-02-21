package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import view.PlayerModel;
import view.PutBet;

public class goToSetBet implements ActionListener {
	
	PlayerModel model;
	GameEngine mGameEngine;
	
	
	public goToSetBet(PlayerModel model, GameEngine mGameEngine) {
		this.model = model;
		this.mGameEngine = mGameEngine;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(model.getPlayer() != null) {
			new PutBet(model,mGameEngine).setVisible(true);;
		}else {
			JOptionPane.showMessageDialog(null, "select a player");
			
		}
	
		
	}

}
