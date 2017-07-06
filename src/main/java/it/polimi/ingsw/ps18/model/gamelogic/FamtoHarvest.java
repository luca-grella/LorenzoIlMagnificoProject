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
	
	/**
	 * The number of servants to add to the action value 
	 * of the current FMember, chosen by the current player
	 */
	private int numberOfServants;
	
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
	
	public void cellChoice(){
		notifyActionPBoardView("Cell Choice Harvest");
	}
	
	public void servantsChoice(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		ShowBoard showBoard = new ShowBoard(currentplayer.getpBoardView());
		showBoard.showHarvest(game.getBoard());
		
		numberOfServants = -1;
		while(this.numberOfServants < 0 || this.numberOfServants > currentplayer.getResources().getServants()){
			notifyActionPBoardView("Servants Choice");
		}
	}

	/**
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
		board.insertFMHarv(chosenFam, chosenCell);
		currentplayer.getResources().addServants(- (this.numberOfServants));
		currentplayer.actHarvest();
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
	 * @return the chosenFam
	 */
	public FMember getChosenFam() {
		return chosenFam;
	}

	/**
	 * @see it.polimi.ingsw.ps18.model.gamelogic.Action#setChosenFam(it.polimi.ingsw.ps18.model.personalboard.FMember)
	 */
	@Override
	public void setChosenFam(FMember chosenFam) {
		this.chosenFam = chosenFam;

	}
	
	/**
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
	 * @return the numberOfServants
	 */
	public int getNumberOfServants() {
		return numberOfServants;
	}

	@Override
	public void setNumberOfServants(int numberOfServants) {
		this.numberOfServants = numberOfServants;
	}
	
	

}
