package view;

import java.awt.Color;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import model.interfaces.GameEngine;
import model.interfaces.Player;

public class ListPlayer extends JPanel implements PropertyChangeListener {

	private GameEngine mGameEngine;
	private PlayerModel model;
	private JList<Player> list;
	private List<Player> players;
	private DefaultListModel<Player> listDefault;
	
	
	public ListPlayer(GameEngine mGameEngine, PlayerModel model) {
		this.mGameEngine = mGameEngine;
		this.model = model;
		model.addPropertyListener(this);
		
		players = new ArrayList<>();
		list = new JList<Player>(new Vector<Player>(players));
		listDefault = new DefaultListModel<Player>();
		
		list.setCellRenderer(new ListDisplay(model));
		list.setModel(listDefault);
		add(list);
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName() == "add"){
			listDefault.clear();
			for(Player player : mGameEngine.getAllPlayers()) {
				listDefault.addElement(player);
			}
			}else if(evt.getPropertyName() == "delete") {
				listDefault.clear();
				model.deselectPlayer();
				for(Player player : mGameEngine.getAllPlayers()) {
					listDefault.addElement(player);
				}
				
				
			
			}
				
	}
	
	



	
}

	