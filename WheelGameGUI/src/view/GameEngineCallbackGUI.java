package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.interfaces.GameEngine;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

public class GameEngineCallbackGUI extends JFrame implements GameEngineCallback{	
	PlayerModel model;
	Log log;
	
	
	public GameEngineCallbackGUI(GameEngine mGameEngine) {
		
		//super(title);
		
		model = new PlayerModel(mGameEngine);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setSize(990, 510);
		
		setLayout(new BorderLayout());
		
		
		add(new ToolBar(mGameEngine, model).getToolBar(), BorderLayout.NORTH);
		log = new Log();
		add(log, BorderLayout.SOUTH);
		add(new WheelPanel());//, BorderLayout.CENTER);
		add(new ListPlayer(mGameEngine, model), BorderLayout.EAST);
		add(new PlayerStatus(model, mGameEngine), BorderLayout.WEST);
		
		
		
	}


	@Override
	public void nextSlot(Slot slot, GameEngine engine) {
		log.setText(slot.toString());
		
	}


	@Override
	public void result(Slot winningSlot, GameEngine engine) {
		log.setText(winningSlot.toString());
		
	}

	
	
	
}
