package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.PlayerModel;
import view.PutBet;

public class addBetListener implements ActionListener{

	PutBet bet;
	PlayerModel model;
	GameEngine mGameEngine;
	
	public addBetListener(PutBet bet, PlayerModel model, GameEngine mGameEngine ) {
		this.bet = bet;
		this.model = model;
		this.mGameEngine = mGameEngine;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Player player = model.getPlayer();
		int amountBet = Integer.parseInt(bet.getTextBet());
		BetType betType = bet.getComboBoxText();
		
		if(mGameEngine.placeBet(player, amountBet, betType)) {
			model.add();
		}else {
			JOptionPane.showMessageDialog(null, "Insuficient money");
		}
		
	}

}
