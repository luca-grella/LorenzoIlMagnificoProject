package it.polimi.ingsw.ps18.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.controller.controlleractions.HashMapActions;
import it.polimi.ingsw.ps18.controller.controllerstatus.HashMapStatus;
import it.polimi.ingsw.ps18.controller.controllerstatus.Status;
import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.Message;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class MainController.
 */
public class MainController implements Observer {
	
	/**
	 * The game.
	 */
	GameLogic game;
	
	/**
	 * The board.
	 */
	Board board;
	
	/**
	 * Instantiates a new main controller.
	 */
	public MainController(){
		HashMapActions.init();
		HashMapStatus.init();
	}
	
	public void startGame(int nplayer, LinkedList<PBoard> players){
		game = new GameLogic(nplayer,this, players);
		game.setup(this);
		game.gameFlow();
	}

	/**
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		Message msg = (Message) arg;
		switch(msg.getID()){
		case 2:
			ActionMessage aMessage = (ActionMessage) msg;
			ActionChoice action = HashMapActions.geteffect(aMessage.getMessage());
			action.act(game);
			break;
		case 3:
			StatusMessage sMessage = (StatusMessage) msg;
			Status show = HashMapStatus.geteffect(sMessage.getMessage());
			show.act(game);
		    break;
		case 4:
			ParamMessage pMessage = (ParamMessage) msg;
			ActionChoice ParamAction = HashMapActions.geteffect(pMessage.getMessage());
			ParamAction.setIndex(pMessage.getNumber());
			ParamAction.act(game);
		}
		
	}
}
