package view;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import listener.addBetListener;
import model.enumeration.BetType;
import model.interfaces.GameEngine;

public class PutBet extends JFrame{
	
	GameEngine mGameEngine;
	PlayerModel model;
	JLabel bet = new JLabel("Bet: ");
	JTextField putBet = new JTextField();
	List<BetType> betType = new ArrayList<>();
	JComboBox type; 
	
	public PutBet(PlayerModel model, GameEngine mGameEngine) {
		this.model = model;
		this.mGameEngine = mGameEngine;
		
		betType.add(BetType.RED);
		betType.add(BetType.BLACK);
		//betType.add(BetType.ZEROS);
		
		GridLayout layout = new GridLayout(4,2, 5, 5);
		setLayout(layout);
		setSize(500,150);
		
		
		add(bet);
		
		add(putBet);
		type = new JComboBox(betType.toArray());
		add(type);
		
		
		JButton betButton = new JButton("Place bet");
		betButton.addActionListener(new addBetListener(this,this.model,this.mGameEngine));
		add(betButton);
	}
	

	public String getTextBet() {
		return putBet.getText();
	}
	
	public BetType getComboBoxText() {
		return (BetType) type.getSelectedItem();
	}


}

