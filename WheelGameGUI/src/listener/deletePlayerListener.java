package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.PlayerModel;

public class deletePlayerListener implements ActionListener{

	private PlayerModel model;
	
	public deletePlayerListener(PlayerModel model) {
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		model.delete();
		
	}

}
