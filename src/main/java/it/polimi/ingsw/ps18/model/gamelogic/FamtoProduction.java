package it.polimi.ingsw.ps18.model.gamelogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.cards.BlueC;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.cards.YellowC;
import it.polimi.ingsw.ps18.model.effect.permeffects.Permanenteffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.messages.ActionMessage;
import it.polimi.ingsw.ps18.model.messages.LogMessage;
import it.polimi.ingsw.ps18.model.messages.StatusMessage;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.view.PBoardView;

// TODO: Auto-generated Javadoc
/**
 * The Class FamtoProduction.
 */
public class FamtoProduction extends Observable implements Action {
	
	/**
	 * The yellow cards.
	 */
	List<YellowC> yellowCards = new ArrayList<>();
	
	/**
	 * The currentcard.
	 */
	YellowC currentcard;
	
	/**
	 * The cards for activation.
	 */
	List<YellowC> cardsForActivation = new ArrayList<>();
	
	/**
	 * The total cost preview.
	 */
	Stats totalCostPreview;
	
	/**
	 * The chosen fam.
	 */
	private FMember chosenFam;
	
	/**
	 * The index famto remove.
	 */
	private int indexFamtoRemove;
	
	/**
	 * The action value.
	 */
	private int actionValue;
	
	/**
	 * Instantiates a new famto production.
	 *
	 * @param view
	 *            the view
	 */
	public FamtoProduction(PBoardView view){
		addObserver(view);
	}
	
	/**
	 * Famchoice.
	 */
	public void famchoice(){
		notifyActionPBoardView("Fam Choice Production");
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.gamelogic.Action#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		Board board = game.getBoard();
		PBoard currentplayer = game.getTurnplayer();
		int modifierValue = 0;
		for(Cards card: currentplayer.getCards()){
			if(card.hasPermanent()){
				for(Permanenteffect effect: ((BlueC) card).getPermeffect()){
					if("Production".equals(effect.getName())){
						modifierValue += effect.getQuantity();
					}
				}
			}
		}
		this.actionValue = board.insertFMProd(this.chosenFam) + modifierValue;
		currentplayer.getFams().set(indexFamtoRemove, null);
		currentplayer.actProduction();
	}
	
	/**
	 * Activate production.
	 *
	 * @param player
	 *            the player
	 * @param game
	 *            the game
	 */
	public void activateProduction(PBoard player, GameLogic game){
		for(Cards card: player.getCards()){
			if(card.getColor()==2){
				this.yellowCards.add((YellowC) card);
			}
		} this.chooseCards(player, game);
	}
	
	/**
	 * Choose cards.
	 *
	 * @param player
	 *            the player
	 * @param game
	 *            the game
	 */
	public void chooseCards(PBoard player, GameLogic game){
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
		} activateEffects(player, game);
	}
	
	/**
	 * Choose effect.
	 */
	public void ChooseEffect(){
		List<ProductionEffect> effects = this.currentcard.getProdEffect();
		notifyLogPBoardView("Scegli quale effetto attivare:\n");
		for(int i=0;  i<effects.size(); i++){
			if("Convert in Resources".equals((effects.get(i)).getName())){
				notifyLogPBoardView("\t" + i + ": " + ((effects.get(i)).toString() + "\n"));
			}
			if("Convert in PC".equals((effects.get(i)).getName())){
				notifyLogPBoardView("\t" + i + ": " + ((effects.get(i)).toString() + "\n"));
			}
			if("Convert WR in Resources".equals((effects.get(i)).getName())){
				notifyLogPBoardView("\t" + i + ": " + ((effects.get(i)).toString() + "\n"));
			}
		}
		notifyStatusPBoardView("Choose Effect");
		
	}
	
	/**
	 * Activate effects.
	 *
	 * @param player
	 *            the player
	 * @param game
	 *            the game
	 */
	public void activateEffects(PBoard player, GameLogic game){
		(player.getResources()).subStats(totalCostPreview);
		for(YellowC card: this.cardsForActivation){
			if(card.hasProduction()){
				if(actionValue >= card.getProductionValue()){
					for(int i=0; i<card.getProdEffect().size(); i++){
						ProductionEffect peffect = card.getProdEffect().get(i);
						peffect.activate(player, game);
					}
			    }
		    }
		}
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.gamelogic.Action#setChosenFam(it.polimi.ingsw.ps18.model.personalboard.FMember)
	 */
	@Override
	public void setChosenFam(FMember chosenFam) {
		this.chosenFam = chosenFam;
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
	 * Notify action P board view.
	 *
	 * @param msg
	 *            the msg
	 */
	private void notifyActionPBoardView(String msg){
		setChanged();
		notifyObservers(new ActionMessage(msg));
	}
	
	/**
	 * Notify status P board view.
	 *
	 * @param msg
	 *            the msg
	 */
	private void notifyStatusPBoardView(String msg){
		setChanged();
		notifyObservers(new StatusMessage(msg));
	}

	/**
	 * Sets the action value.
	 *
	 * @param actionValue
	 *            the actionValue to set
	 */
	public void setActionValue(int actionValue) {
		this.actionValue = actionValue;
	}

	/**
	 * Gets the currentcard.
	 *
	 * @return the currentcard
	 */
	public YellowC getCurrentcard() {
		return currentcard;
	}

	/**
	 * Gets the cards for activation.
	 *
	 * @return the cardsForActivation
	 */
	public List<YellowC> getCardsForActivation() {
		return cardsForActivation;
	}

	/**
	 * Gets the total cost preview.
	 *
	 * @return the totalCostPreview
	 */
	public Stats getTotalCostPreview() {
		return totalCostPreview;
	}

	/**
	 * Sets the index famto remove.
	 *
	 * @param indexFamtoRemove
	 *            the indexFamtoRemove to set
	 */
	public void setIndexFamtoRemove(int indexFamtoRemove) {
		this.indexFamtoRemove = indexFamtoRemove;
	}
	

	
}
