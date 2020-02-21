package main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import model.GameEngineImpl;
import model.interfaces.GameEngine;
import view.GameEngineCallbackGUI;
import view.GameEngineCallbackImpl;
import view.interfaces.GameEngineCallback;

public class Main implements Runnable {
	
	private GameEngine mGameEngine;
	private GameEngineCallback mGameEngineCallback;
	private boolean check = true;
	
	public static void main(String[] args) {
		GameEngine mgameEngine = new GameEngineImpl();
		GameEngineCallback mgameEngineCallback = new GameEngineCallbackImpl();
		
		SwingUtilities.invokeLater(new Main(mgameEngine, mgameEngineCallback));
		
	}
	public Main(GameEngine mgameEngine,GameEngineCallback mgameEngineCallback) {
		
		this.mGameEngine = mgameEngine;
		this.mGameEngineCallback = mgameEngineCallback;
	}
	
	@Override
	public void run() {
		GameEngineCallbackGUI callback = new GameEngineCallbackGUI(mGameEngine);
		callback.setVisible(check);
		mGameEngine.addGameEngineCallback(mGameEngineCallback);
		mGameEngine.addGameEngineCallback(callback);
		
	}

	
		
}
