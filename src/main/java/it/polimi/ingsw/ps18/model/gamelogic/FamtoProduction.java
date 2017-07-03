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
	List<Cards> cardsWithProduction = new ArrayList<>();
	Cards currentcard;
	List<Cards> cardsForActivation = new ArrayList<>();
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
	 * The number of servants to add to the action value 
	 * of the current FMember, chosen by the current player
	 */
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
		this.actionValue = board.getActionValueProd(this.chosenFam) + modifierValue;
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
		game.getTurnplayer().getFams().set(indexFamtoRemove, null);
		game.getBoard().insertFMProd(this.chosenFam);
		(player.getResources()).subStats(totalCostPreview);
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
