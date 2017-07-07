package it.polimi.ingsw.ps18.model.gamelogic;

import java.util.Observable;

import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects;
import it.polimi.ingsw.ps18.model.effect.excommEffects.MalusValue;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.LogMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;


/**
 * Support Class that handle the player's turn. It has a specific View and Controller to
 * separate the work on the main ones.
 * @author Francesco-Musio
 *
 */

/*
 * TODO: la classe si potrebbe anche eliminare/modificare per compiere
 * le azioni che accomunano le varie azioni (decorator)
 */
public class TurnHandler extends Observable implements Action {
	
	/**
	 * The current player.
	 */
	PBoard currentPlayer;
	
	/**
	 * Instantiates a new turn handler.
	 *
	 * @param currentplayer
	 *            the currentplayer
	 */
	public TurnHandler(PBoard currentplayer){
		this.currentPlayer = currentplayer;
		addObserver(currentplayer.getpBoardView());
	}
	
	/**
	 * @see it.polimi.ingsw.ps18.model.gamelogic.Action#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	public void act(GameLogic game){
		notifyLogPBoardView("Player color " + currentPlayer.getPlayercol() + " turn");
		PBoard currentplayer = game.getTurnplayer();
		FMember neutralFM = null;
		boolean canActMarket = true;
		for(Excommunications card: game.getTurnplayer().getExcommCards()){
			for(ExcommEffects effect: card.getEffects()){
				if("MalusValue".equals(effect.getName())){
					if("Market".equals(((MalusValue) effect).getPlace())){
						canActMarket = false;
					}
				}
			}
		}
		
		for(int famIndex=0; famIndex<currentplayer.getFams().size(); famIndex++){
			FMember fam = currentplayer.getFams().get(famIndex);
			if(fam!= null){
				if(fam.getColor() != GeneralParameters.neutralFMColor){
					if(canActMarket){
						notifyActionPboardView("Init Player Turn");
					} else {
						notifyParamPboardView("Init Player Turn", 1);
					}
					
					return;
				}
				else{
					neutralFM = fam;
				}
			}
		}
		if(neutralFM != null) {
			if(currentplayer.getResources().getServants() > 0)
				if(canActMarket){
					notifyActionPboardView("Init Player Turn");
				} else {
					notifyParamPboardView("Init Player Turn", 1);
				}
		}
		

		
	}
	
	
	
	/**
	 * Notify log P board view.
	 *
	 * @param msg
	 *            the msg
	 */
	private void notifyLogPBoardView(String msg){
		setChanged();
		notifyObservers(new LogMessage(msg));
	}
	
	/**
	 * Notify action pboard view.
	 *
	 * @param msg
	 *            the msg
	 */
	private void notifyActionPboardView(String msg){
		setChanged();
		notifyObservers(new ActionMessage(msg));
	}
	
	private void notifyParamPboardView(String msg, int i){
		setChanged();
		notifyObservers(new ParamMessage(msg,i));
	}

	/**
	 * @see it.polimi.ingsw.ps18.model.gamelogic.Action#setChosenFam(it.polimi.ingsw.ps18.model.personalboard.FMember)
	 */
	@Override
	public void setChosenFam(FMember chosenFam) {
		return;
		
	}

	@Override
	public void setNumberOfServants(int numberOfServants) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Per test
	 * 
	 */
	public FMember getChosenFam(FMember chosenFam) {
		return chosenFam;
		
	}

	/**
	 * Per test
	 */
	public int getNumberOfServants(int numberOfServants) {
		
		return numberOfServants;
	}

}
