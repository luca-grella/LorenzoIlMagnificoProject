package it.polimi.ingsw.ps18.model.gamelogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.cards.BlueC;
import it.polimi.ingsw.ps18.model.cards.BonusTile;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.cards.YellowC;
import it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects;
import it.polimi.ingsw.ps18.model.effect.excommEffects.MalusValue;
import it.polimi.ingsw.ps18.model.effect.permeffects.Permanenteffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.LogMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * The Class FamtoProduction.
 */
public class FamtoProduction extends Observable implements Action {
	
	/** The cards with production. */
	List<Cards> cardsWithProduction = new ArrayList<>();
	
	/** The currentcard. */
	Cards currentcard;
	
	/** The cards for activation. */
	List<Cards> cardsForActivation = new ArrayList<>();
	
	/** The total cost preview. */
	Stats totalCostPreview;
	
	/**
	 * The chosen fam.
	 */
	private FMember chosenFam;
	
	/**
	 * The chosen production cell.
	 */
	private int chosenCell;
	
	/**
	 * The index famto remove.
	 */
	private int indexFamtoRemove;
	
	/** The number of servants to add to the action value  of the current FMember, chosen by the current player. */
	private int numberOfServants;
	
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
	
	/**
	 * Cell choice.
	 */
	public void cellChoice(){
		notifyActionPBoardView("Cell Choice Production");
	}
	
	/**
	 * Servants choice.
	 *
	 * @param game the game
	 */
	public void servantsChoice(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		ShowBoard showBoard = new ShowBoard(currentplayer.getpBoardView());
		showBoard.showProduction(game.getBoard());
		
		numberOfServants = -1;
		while(this.numberOfServants < 0 || this.numberOfServants > currentplayer.getResources().getServants()){
			notifyActionPBoardView("Servants Choice");
		}
	}

	/**
	 * Act.
	 *
	 * @param game the game
	 * @see it.polimi.ingsw.ps18.model.gamelogic.Action#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		Board board = game.getBoard();
		PBoard currentplayer = game.getTurnplayer();
		int modifierValue = 0;
		for(Cards card: currentplayer.getCards()){
			if(card.hasPermanent()){
				if(card.getColor()==1){
					for(Permanenteffect effect: ((BlueC) card).getPermeffect()){
						if("Production".equals(effect.getName())){
							modifierValue += effect.getQuantity();
						}
					}
				} else if(card.getColor()==-1){
					for(Permanenteffect effect: ((BonusTile) card).getPermeffect()){
						if("Production".equals(effect.getName())){
							modifierValue += effect.getQuantity();
						}
					}
				}
				
			}
		}
		int malusServants = 1;
		for(Excommunications card: currentplayer.getExcommCards()){
			for(ExcommEffects effect: card.getEffects()){
				if("MalusValue".equals(effect.getName())){
					if("Servants".equals(((MalusValue) effect).getPlace())){
						malusServants = ((MalusValue) effect).getMalusValue();
						if(malusServants == 0){
							malusServants = 1;
						}
					}
					
				}
			}
		}
		this.actionValue = board.getActionValueProd(this.chosenFam, this.chosenCell) + modifierValue + (this.numberOfServants / malusServants);
		int malusValue = 0;
		for(int i=0; i<currentplayer.getExcommCards().size(); i++){
			Excommunications card = currentplayer.getExcommCards().get(i);
			for(int j=0; j<card.getEffects().size(); j++){
				if("MalusValue".equals(card.getEffects().get(j).getName())){
					if("Production".equals(((MalusValue) card.getEffects().get(j)).getPlace())){
						malusValue += ((MalusValue) card.getEffects().get(j)).getMalusValue();
					}
				}
			}
		}
		if(actionValue >= malusValue){
			actionValue -= malusValue;
		} else {
			actionValue = 0;
		}
		currentplayer.getResources().addServants(- (this.numberOfServants));
		StringBuilder builder = new StringBuilder();
		builder.append("\n\n-----------------\n");
		builder.append("Player number " + currentplayer.getPlayercol() + " has moved a Family Member\nto the Production Cell ");
		if(chosenCell==1){
			builder.append("without malus");
		}
		builder.append("\n\n-----------------\n");
		game.notifyAll(builder.toString());
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
			if(card.getColor()==2 || card.getColor()==-1){
				if(card.hasProduction()){
					this.cardsWithProduction.add(card);
				}
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
		for(Cards card: cardsWithProduction){
			if(card.getColor()==2){
				if(((YellowC) card).getProductionValue() <= this.actionValue){
					this.currentcard = card;
					notifyLogPBoardView(card.toString());
					notifyLogPBoardView(player.toStringResources());
					notifyLogPBoardView(totalCostPreview.toString());
					notifyStatusPBoardView("Select YC");
				}
			} else if(card.getColor()==-1){
				if(((BonusTile) card).getProductionValue() <= this.actionValue){
					this.currentcard = card;
					notifyLogPBoardView(card.toString());
					notifyLogPBoardView(player.toStringResources());
					notifyLogPBoardView(totalCostPreview.toString());
					notifyStatusPBoardView("Select YC");
				}
			}
		} activateEffects(player, game);
	}
	
	/**
	 * Choose effect.
	 */
	public void ChooseEffect(){
		List<ProductionEffect> effects = new ArrayList<>();
		if(currentcard.getColor()==2){
			effects = ((YellowC)this.currentcard).getProdEffect();
		} else if(currentcard.getColor()==-1){
			effects = ((BonusTile)this.currentcard).getProdEffect();
		}
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
		if(this.indexFamtoRemove!=-1){
			game.getTurnplayer().getFams().set(indexFamtoRemove, null);
			game.getBoard().insertFMProd(this.chosenFam, this.chosenCell, game);
			(player.getResources()).subStats(totalCostPreview);
		}
		for(Cards card: this.cardsForActivation){
			if(card.hasProduction()){
				if(card.getColor()==2){
					if(actionValue >= ((YellowC)card).getProductionValue()){
						for(int i=0; i<((YellowC)card).getProdEffect().size(); i++){
							ProductionEffect peffect = ((YellowC)card).getProdEffect().get(i);
							peffect.activate(player, game);
						}
				    }
				} else if(card.getColor()==-1){
					if(actionValue >= ((BonusTile)card).getProductionValue()){
						for(int i=0; i<((BonusTile)card).getProdEffect().size(); i++){
							ProductionEffect peffect = ((BonusTile)card).getProdEffect().get(i);
							peffect.activate(player, game);
						}
				    }
				}
		    }
		}
	}

	/**
	 * Sets the chosen fam.
	 *
	 * @param chosenFam the new chosen fam
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
	public Cards getCurrentcard() {
		return currentcard;
	}

	/**
	 * Gets the cards for activation.
	 *
	 * @return the cardsForActivation
	 */
	public List<Cards> getCardsForActivation() {
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
	
	
	/**
	 * Gets the number of servants.
	 *
	 * @return the numberOfServants
	 */
	public int getNumberOfServants() {
		return numberOfServants;
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.gamelogic.Action#setNumberOfServants(int)
	 */
	@Override
	public void setNumberOfServants(int numberOfServants) {
		this.numberOfServants = numberOfServants;		
	}

	/**
	 * Gets the chosen cell.
	 *
	 * @return the chosenCell
	 */
	public int getChosenCell() {
		return chosenCell;
	}

	/**
	 * Sets the chosen cell.
	 *
	 * @param chosenCell the chosenCell to set
	 */
	public void setChosenCell(int chosenCell) {
		this.chosenCell = chosenCell;
	}

	/**
	 * Gets the chosen fam.
	 *
	 * @return the chosenFam
	 */
	public FMember getChosenFam() {
		return chosenFam;
	}

	/**
	 * Gets the action value.
	 *
	 * @return the action value
	 */
	public int getActionValue() {
		
		return actionValue;
	}

	/**
	 * Sets the currentcard.
	 *
	 * @param currentcard the new currentcard
	 */
	public void setCurrentcard(Cards currentcard) {
		this.currentcard = currentcard;
		
	}

	/**
	 * Sets the cards for activation.
	 *
	 * @param cardsForActivation the new cards for activation
	 */
	public void setCardsForActivation(List<Cards> cardsForActivation) {
		this.cardsForActivation=cardsForActivation;
		
	}

	/**
	 * Sets the total cost preview.
	 *
	 * @param totalCostPreview the new total cost preview
	 */
	public void setTotalCostPreview(Stats totalCostPreview) {
		this.totalCostPreview=totalCostPreview;
		
	}

	/**
	 * Gets the index famto remove.
	 *
	 * @return the index famto remove
	 */
	public int getIndexFamtoRemove() {
		
		return indexFamtoRemove;
	}
	
	

	
}
