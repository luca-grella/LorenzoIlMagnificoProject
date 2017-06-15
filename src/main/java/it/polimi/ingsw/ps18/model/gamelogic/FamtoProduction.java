package it.polimi.ingsw.ps18.model.gamelogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.cards.YellowC;
import it.polimi.ingsw.ps18.model.messages.ActionMessage;
import it.polimi.ingsw.ps18.model.messages.LogMessage;
import it.polimi.ingsw.ps18.model.messages.StatusMessage;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.view.PBoardView;

public class FamtoProduction extends Observable implements Action {
	List<YellowC> yellowCards = new ArrayList<>();
	YellowC currentcard;
	List<Cards> cardsForActivation = new ArrayList<>();
	Stats totalCostPreview;
	private FMember chosenFam;
	private int actionValue;
	
	public FamtoProduction(PBoardView view){
		addObserver(view);
	}
	
	public void famchoice(){
		notifyActionPBoardView("Fam Choice Production");
	}

	@Override
	public void act(GameLogic game) {
		Board board = game.getBoard();
		this.actionValue = board.insertFMProd(this.chosenFam);
		PBoard currentplayer = game.getTurnplayer();
		currentplayer.actProduction();
	}
	
	public void activateProduction(PBoard player){
		for(Cards card: player.getCards()){
			if(card.getColor()==2){
				this.yellowCards.add((YellowC) card);
			}
		} this.chooseCards(player);
	}
	
	public void chooseCards(PBoard player){
		cardsForActivation.clear();
		totalCostPreview = new Stats(0,0,0,0,0,0,0);
		for(YellowC card: yellowCards){
			if(card.getProductionValue() <= this.actionValue){
				this.currentcard = card;
				notifyLogPBoardView(card.toString());
				notifyLogPBoardView(player.toStringResources());
				notifyLogPBoardView(totalCostPreview.toString());
				notifyStatusPBoardView("Select YC");
			}
		} activateEffects(player);
	}
	
	public void activateEffects(PBoard player){
		List<Cards> cards = player.getCards();
		(player.getResources()).subStats(totalCostPreview);
		for(Cards card: cards){
			if(card.hasProduction()){
				card.activateSecondaryEffect(player, actionValue);
			}
		}
	}

	@Override
	public void setChosenFam(FMember chosenFam) {
		this.chosenFam = chosenFam;
	}
	
	private void notifyLogPBoardView(String msg){
		setChanged();
		notifyObservers(new LogMessage(msg));
	}
	
	private void notifyActionPBoardView(String msg){
		setChanged();
		notifyObservers(new ActionMessage(msg));
	}
	
	private void notifyStatusPBoardView(String msg){
		setChanged();
		notifyObservers(new StatusMessage(msg));
	}

	/**
	 * @param actionValue the actionValue to set
	 */
	public void setActionValue(int actionValue) {
		this.actionValue = actionValue;
	}

	/**
	 * @return the currentcard
	 */
	public YellowC getCurrentcard() {
		return currentcard;
	}

	/**
	 * @return the cardsForActivation
	 */
	public List<Cards> getCardsForActivation() {
		return cardsForActivation;
	}

	/**
	 * @return the totalCostPreview
	 */
	public Stats getTotalCostPreview() {
		return totalCostPreview;
	}
	

	
}
