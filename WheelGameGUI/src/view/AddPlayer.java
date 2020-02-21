package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listener.addPlayerListener;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class AddPlayer extends JFrame {
	
	JButton addPlayer;
	JTextField inputName = new JTextField(10);
	
	JTextField inputPoints = new JTextField(10);
	JTextField inputId = new JTextField(10);
	List<Player> players;
	GameEngine mGameEngine;
	PlayerModel model;
	
	public AddPlayer(GameEngine mGameEngine, PlayerModel model) {
		
		this.mGameEngine = mGameEngine;
		this.model = model;
		
		//GridLayout layout = new GridLayout(4,2, 10, 10);
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.LEFT);
		setLayout(layout);
		setSize(500,150);
		
		JLabel id = new JLabel("Id :");
		add(id);
		
		inputId = new JTextField();
		add(inputId);
		
		JLabel name = new JLabel("Name :");
		add(name);
		
		inputName = new JTextField();
		add(inputName);
		
		JLabel points = new JLabel("Points :");
		add(points);
		
		inputPoints = new JTextField();
		add(inputPoints);
		
	
		addPlayer = new JButton("add");
		add(addPlayer);
		addPlayer.addActionListener(new addPlayerListener(this, this.mGameEngine, this.model));
	}
	
	public String getTextName() {
		return inputName.getText();
		
	}
	
	public String getTextPoint() {
		return inputPoints.getText();
	}
	
	public String getTextId() {
		return inputId.getText();
	}
}
