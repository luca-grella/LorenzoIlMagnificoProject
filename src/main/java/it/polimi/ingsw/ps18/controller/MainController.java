package it.polimi.ingsw.ps18.controller;

import java.util.Observable;
import java.util.Observer;

import it.polimi.ingsw.ps18.model.gameLogic.GameLogic;
import it.polimi.ingsw.ps18.model.gameLogic.TurnHandler;
import it.polimi.ingsw.ps18.model.messages.ActionMessage;
import it.polimi.ingsw.ps18.model.messages.Message;

public class MainController implements Observer {
	GameLogic game;
	TurnHandler tHandler;
	
	public MainController(){
		
	}
	
	public MainController(int nplayer){
		game = new GameLogic(nplayer,this);
		game.setup(this);
		game.gameFlow();
	}

	@Override
	public void update(Observable o, Object arg) {
		Message msg = (Message) arg;
		switch(msg.getID()){
		case 2:
			ActionMessage aMessage = (ActionMessage) msg;
			if("Turn Handle Init".equals(aMessage.getMessage())){
				tHandler = new TurnHandler(game.getTurnplayer());
				tHandler.init();
			}
		}
		
	}
}
