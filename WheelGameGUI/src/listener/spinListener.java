package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import view.PlayerModel;

public class spinListener implements ActionListener{
	
	private GameEngine mGameEngine;
	private PlayerModel model;
	
	public spinListener(GameEngine mGameEngine, PlayerModel model) {
		this.mGameEngine = mGameEngine;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		new Thread(){
			@Override
			public void run(){
				mGameEngine.spin(1, 200, 4);
		}}.start();
	}

}
