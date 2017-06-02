package it.polimi.ingsw.ps18.controller;

import java.util.Observable;
import java.util.Observer;

import it.polimi.ingsw.ps18.model.gameLogic.GameLogic;

public class MainController implements Observer {
	GameLogic game;
	
	public MainController(){
		
	}
	
	public MainController(int nplayer){
		game = new GameLogic(nplayer,this);
		game.setup(this);
		//game.gameFlow();
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}

}
