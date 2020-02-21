package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.interfaces.Player;

public class ListDisplay extends JLabel implements ListCellRenderer<Player> {
	private PlayerModel model;
	private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
	
	public ListDisplay(PlayerModel model) {
		this.model = model;
		
	}

	@Override
	public Component getListCellRendererComponent(JList list, Player value, int index,
			boolean isSelected, boolean cellHasFocus) {
		
		
		
		setText(value.getPlayerId() +". " + value.getPlayerName());
		
		 if (isSelected) {
		      setBackground(HIGHLIGHT_COLOR);
		      setForeground(Color.blue);
		      model.setPlayer(value);
		    } else {
		      setBackground(Color.white);
		      setForeground(Color.black);
		    }		
		
		return this;
	}
}
