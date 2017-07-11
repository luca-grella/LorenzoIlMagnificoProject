package it.polimi.ingsw.ps18.controller.controlleractions.famtoproduction;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.cards.YellowC;
import it.polimi.ingsw.ps18.model.cards.BonusTile;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertResorResinResources;
import it.polimi.ingsw.ps18.model.effect.prodEffect.Converter;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * The Class ReceiveChoseneffect.
 */
public class ReceiveChoseneffect implements ActionChoice {
	
	/**
	 * The index.
	 */
	private int index;

	/**
	 * Act.
	 *
	 * @param game the game
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		Action currentaction = game.getOngoingAction();
		PBoard currentplayer = game.getTurnplayer();
		Stats costPreview = ((FamtoProduction) currentaction).getTotalCostPreview();
		Cards currentcard = ((FamtoProduction) currentaction).getCurrentcard();
		YellowC newcard = new YellowC();
		List<ProductionEffect> peffects = new ArrayList<>();
		if(currentcard.getColor()==2){
			newcard.setProductionValue(((YellowC)currentcard).getProductionValue());
			peffects = ((YellowC)currentcard).getProdEffect();
		} else if(currentcard.getColor()==-1){
			newcard.setProductionValue((int) ((BonusTile)currentcard).getProductionValue());
			peffects = ((BonusTile)currentcard).getProdEffect();
		}
		newcard.setColor(2);
		
		List<ProductionEffect> peffectscopy = newcard.getProdEffect();
		for(int i=0; i<peffects.size(); i++){
			if(!("Convert in Resources".equals((peffects.get(i)).getName()))){
				if(!("Convert in PC".equals((peffects.get(i)).getName()))){
					if(!("Convert WR in Resources".equals((peffects.get(i)).getName()))){
						peffectscopy.add(peffects.get(i));
					}
				}
			}
		} 
		peffectscopy.add(peffects.get(index));
		for(ProductionEffect effect: peffectscopy){
			if(("Convert in Resources".equals(effect.getName()) || "Convert in PC".equals(effect.getName()))){
				Converter ceffect = (Converter) effect;
				costPreview.addStats(ceffect.getCost());
			} else if ("Convert WR in Resources".equals(effect.getName())){
				ConvertResorResinResources ceffect = (ConvertResorResinResources) effect;
				ceffect.WoodorRockChoice(currentplayer, game);
				costPreview.addStats(ceffect.getCost());
			}
		}
		if(!((currentplayer.getResources()).enoughStats(costPreview))){
			((FamtoProduction) currentaction).chooseCards(currentplayer, game);
			return;
		}
		(((FamtoProduction) currentaction).getCardsForActivation()).add(newcard);
	}

	/**
	 * Sets the index.
	 *
	 * @param i the new index
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#setIndex(int)
	 */
	@Override
	public void setIndex(int i) {
		this.index = i;

	}

}
