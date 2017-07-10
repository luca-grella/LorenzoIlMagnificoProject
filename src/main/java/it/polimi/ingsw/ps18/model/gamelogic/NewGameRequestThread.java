package it.polimi.ingsw.ps18.model.gamelogic;

import java.util.Observable;

import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class NewGameRequestThread extends Observable implements Runnable {
	private int color;
	
	public NewGameRequestThread(PBoard player){
		addObserver(player.getpBoardView());
		this.color = player.getPlayercol();
	}

	@Override
	public void run() {
		setChanged();
		notifyObservers(new ParamMessage("NewGameChoice", color));

	}

}
