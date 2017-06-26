package it.polimi.ingsw.ps18.model.gamelogic;

import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;

import java.util.List;
import java.util.Observable;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.view.PBoardView;

public class VaticanReport extends Observable implements Action{
	
	public VaticanReport(PBoardView view){
		addObserver(view);
	}
	
	public void reportChoice(){
		notifyActionPBoardView("Choose Church Support");
	}
	

	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		Excommunications excommCard = game.getExcommcards().get(0);
		List<Excommunications> playerExcommCards = currentplayer.getExcommCards();
		playerExcommCards.add(excommCard);	
	}

	@Override
	public void setChosenFam(FMember chosenFam) {
		return;
	}
	
	
	/**
	 * Notify action P board view.
	 *
	 * @param msg
	 *            the msg
	 */
	private void notifyActionPBoardView(String msg){
		setChanged();
		notifyObservers(new ActionMessage(msg));
	}

}
