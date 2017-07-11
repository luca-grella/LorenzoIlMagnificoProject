package it.polimi.ingsw.ps18.model.gamelogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.cards.BlueC;
import it.polimi.ingsw.ps18.model.cards.BonusTile;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.cards.GreenC;
import it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects;
import it.polimi.ingsw.ps18.model.effect.excommEffects.MalusValue;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.permeffects.Permanenteffect;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * The Class FamtoHarvest.
 */
public class FamtoHarvest extends Observable implements Action {
	
	/**
	 * The chosen fam.
	 */
	private FMember chosenFam;
	
	/**
	 * The index of the chosen harvest cell.
	 */
	private int chosenCell;
	
	/**
	 * The index famto remove.
	 */
	private int indexFamtoRemove;
	
	/** The number of servants to add to the action value  of the current FMember, chosen by the current player. */
	private int numberOfServants;
	
	/** tester. */
	private int tester=1;
	
	/**
	 * The action value.
	 */
	private int actionValue;
	
	/**
	 * Instantiates a new famto harvest.
	 *
	 * @param view
	 *            the view
	 */
	public FamtoHarvest(PBoardView view){
		addObserver(view);
	}
	
	/**
	 * Famchoice.
	 */
	public void famchoice(){
		notifyActionPBoardView("Fam Choice Harvest");
	}
	
	/**
	 * Cell choice.
	 */
	public void cellChoice(){
		notifyActionPBoardView("Cell Choice Harvest");
	}
	
	/**
	 * Servants choice.
	 *
	 * @param game the game
	 */
	public void servantsChoice(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		ShowBoard showBoard = new ShowBoard(currentplayer.getpBoardView());
		
		if(tester!=999){
		showBoard.showHarvest(game.getBoard());
		
		numberOfServants = -1;
		
		while(this.numberOfServants < 0 || this.numberOfServants > currentplayer.getResources().getServants()){
			notifyActionPBoardView("Servants Choice");}
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
						if("Harvest".equals(effect.getName())){
							modifierValue += effect.getQuantity();
						}
					}
				} else if(card.getColor()==-1){
					for(Permanenteffect effect: ((BonusTile) card).getPermeffect()){
						if("Harvest".equals(effect.getName())){
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
		
		this.actionValue = board.getActionValueHarv(chosenFam, chosenCell) + modifierValue + (this.numberOfServants / malusServants);
		int malusValue = 0;
		for(int i=0; i<currentplayer.getExcommCards().size(); i++){
			Excommunications card = currentplayer.getExcommCards().get(i);
			for(int j=0; j<card.getEffects().size(); j++){
				if("MalusValue".equals(card.getEffects().get(j).getName())){
					if("Harvest".equals(((MalusValue) card.getEffects().get(j)).getPlace())){
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
		currentplayer.getFams().set(indexFamtoRemove, null);
		board.insertFMHarv(chosenFam, chosenCell, game);
		currentplayer.getResources().addServants(- (this.numberOfServants));
		currentplayer.actHarvest();
		StringBuilder builder = new StringBuilder();
		builder.append("\n\n-----------------\n");
		builder.append("Player number " + currentplayer.getPlayercol() + " has moved a Family Member\nto the Harvest Cell ");
		if(chosenCell==1){
			builder.append("without malus");
		}
		builder.append("\n\n-----------------\n");
		game.notifyAll(builder.toString());
	}
	
	/**
	 * Activate harvest.
	 *
	 * @param player
	 *            the player
	 * @param game
	 *            the game
	 */
	public void activateHarvest(PBoard player, GameLogic game){
		List<Cards> cards = player.getCards();
		List<GreenC> greenc = new ArrayList<>();
		for(Cards card: cards){
			if(card.getColor()==0){
				greenc.add((GreenC) card);
			} else if(card.getColor()==-1){
				BonusTile bonusT = (BonusTile) card;
				if(card.hasHarvest()){
					if(actionValue >= bonusT.getHarvValue()){
						for(int i=0; i<bonusT.getHarveffect().size(); i++){
							HarvestEffect heffect = bonusT.getHarveffect().get(i);
							heffect.activate(player, game);
						}
					}
				}
			}
		}
		for(GreenC card: greenc){
			if(card.hasHarvest()){
				if(actionValue >= card.getHarvValue()){
					for(int i=0; i<card.getHarveffect().size(); i++){
						HarvestEffect heffect = card.getHarveffect().get(i);
						heffect.activate(player, game);
					}
				}
			}
		}
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
	 * Sets the chosen cell.
	 *
	 * @param chosenCell the chosenCell to set
	 */
	public void setChosenCell(int chosenCell) {
		this.chosenCell = chosenCell;
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
	 * Sets the action value.
	 *
	 * @param actionValue
	 *            the actionValue to set
	 */
	public void setActionValue(int actionValue) {
		this.actionValue = actionValue;
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
	 * Sets the tester.
	 *
	 * @param tester the new tester
	 */
	public void setTester(int tester) {
		this.tester=tester;
		
	}

	/**
	 * Gets the chosen cell.
	 *
	 * @return the chosen cell
	 */
	public int getChosenCell() {
		
		return chosenCell;
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
	 * Gets the index famto remove.
	 *
	 * @return the index famto remove
	 */
	public int getIndexFamtoRemove() {
		
		return indexFamtoRemove;
	}
	
	

}
