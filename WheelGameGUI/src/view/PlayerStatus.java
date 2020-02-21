package view;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.interfaces.GameEngine;
import model.interfaces.Player;

public class PlayerStatus extends JPanel implements PropertyChangeListener {

	JLabel name = new JLabel("name");
	JLabel nameValue = new JLabel();
	JLabel point = new JLabel("points");
	JLabel pointValue = new JLabel();
	JLabel bet = new JLabel("bet points");
	JLabel betValue = new JLabel();
	JLabel betType = new JLabel("bet type");
	JLabel betTypeValue = new JLabel();
	Player player;
	List<Player> players;
	
	private GameEngine mGameEngine;
	private PlayerModel model;
	
	public PlayerStatus(PlayerModel model, GameEngine mGameEngine) {
		this.mGameEngine = mGameEngine;
		this.model = model;
		
		this.model.addPropertyListener(this);
		
		players =(List) mGameEngine.getAllPlayers();
		
		
		
		
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName() == "add") {
			removeAll();
			
			for(int i = 0; i<mGameEngine.getAllPlayers().size(); i++) {
				add(name);
				nameValue = new JLabel(players.get(i).getPlayerName());
				add(nameValue);
				add(point);
				pointValue = new JLabel(Integer.toString(players.get(i).getPoints()));
				add(pointValue);
				add(bet);
				betValue = new JLabel(Integer.toString(players.get(i).getBet()));
				add(betValue);
				add(betType);
				if(players.get(i).getBetType() != null) {
					betTypeValue = new JLabel(players.get(i).getBetType().toString());
					add(betTypeValue);
				}else {
					betTypeValue = new JLabel("no type");
					add(betTypeValue);
				}
				
			}
			
			repaint();
			
		}else if(evt.getPropertyName() == "delete") {
			removeAll();
			
			for(int i = 0; i<mGameEngine.getAllPlayers().size(); i++) {
				add(name);
				nameValue = new JLabel(players.get(i).getPlayerName());
				add(nameValue);
				add(point);
				pointValue = new JLabel(Integer.toString(players.get(i).getPoints()));
				add(pointValue);
				add(bet);
				betValue = new JLabel(Integer.toString(players.get(i).getBet()));
				add(betValue);
				add(betType);
				if(players.get(i).getBetType() != null) {
					betTypeValue = new JLabel(players.get(i).getBetType().toString());
					add(betTypeValue);
				}else {
					betTypeValue = new JLabel("no type");
					add(betTypeValue);
				}
				
			}
			
			repaint();
		}
		
	}
}
