package it.polimi.ingsw.ps18.model.gamelogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.cards.BlueC;
import it.polimi.ingsw.ps18.model.cards.BonusTile;
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

public class FamtoProduction extends Observable implements Action {
	List<Cards> cardsWithProduction = new ArrayList<>();
	Cards currentcard;
	List<Cards> cardsForActivation = new ArrayList<>();
	Stats totalCostPreview;
	private FMember chosenFam;
	private int indexFamtoRemove;
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
		this.actionValue = board.insertFMProd(this.chosenFam) + modifierValue;
		currentplayer.getFams().set(indexFamtoRemove, null);
		currentplayer.actProduction();
	}
	
	public void activateProduction(PBoard player, GameLogic game){
		for(Cards card: player.getCards()){
			if(card.getColor()==2 || card.getColor()==-1){
				if(card.hasProduction()){
					this.cardsWithProduction.add(card);
				}
			}
		} this.chooseCards(player, game);
	}
	
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
	
	public void activateEffects(PBoard player, GameLogic game){
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
	public Cards getCurrentcard() {
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

	/**
	 * @param indexFamtoRemove the indexFamtoRemove to set
	 */
	public void setIndexFamtoRemove(int indexFamtoRemove) {
		this.indexFamtoRemove = indexFamtoRemove;
	}
	

	
}
