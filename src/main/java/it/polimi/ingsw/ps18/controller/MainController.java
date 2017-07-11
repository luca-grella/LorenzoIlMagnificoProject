package it.polimi.ingsw.ps18.controller;

import java.io.Serializable;
import java.rmi.RemoteException;
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
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusParamMessage;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.rmi.ClientInterface;

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
	
	/**
	 * Start game.
	 *
	 * @param nplayer the nplayer
	 * @param players the players
	 * @return the linked list
	 */
	public LinkedList<ClientInterface> startGame(int nplayer, LinkedList<PBoard> players){;
		game = new GameLogic(nplayer,this, players);
		game.setup(this);
		LinkedList<ClientInterface> playersforNewGame = game.gameFlow();
		return playersforNewGame;
		
	}
	
	/**
	 * Update client.
	 *
	 * @param newclient the newclient
	 * @return true, if successful
	 */
	public boolean updateClient(ClientInterface newclient){
		try {
			for(PBoard player: game.getPlayers()){
				if(player.getPlayer().getName().equals(newclient.getName())){
					player.setPlayer(newclient);
				}
			}
			return true;
		} catch (RemoteException e) {
			return false;
		}
	}

	/**
	 * Update.
	 *
	 * @param o the o
	 * @param arg the arg
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
			show.setColor(-1);
			show.setIndex(-1);
			show.act(game);
		    break;
		case 4:
			ParamMessage pMessage = (ParamMessage) msg;
			ActionChoice ParamAction = HashMapActions.geteffect(pMessage.getMessage());
			ParamAction.setIndex(pMessage.getNumber());
			ParamAction.act(game);
			break;
		case 5:
			StatusParamMessage spMessage = (StatusParamMessage) msg;
			Status statusShow = HashMapStatus.geteffect(spMessage.getMessage());
			statusShow.setColor(spMessage.getColor());
			statusShow.setIndex(spMessage.getNumber());
			statusShow.act(game);
			
		}
		
	}
}
