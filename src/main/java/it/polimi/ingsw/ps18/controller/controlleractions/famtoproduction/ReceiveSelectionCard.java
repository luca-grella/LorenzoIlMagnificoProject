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
import it.polimi.ingsw.ps18.model.gamelogic.*;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * The Class ReceiveSelectionCard.
 */
public class ReceiveSelectionCard implements ActionChoice {
	
	/**
	 * The index.
	 */
	private int index;

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		Action currentaction = game.getOngoingAction();
		PBoard currentplayer = game.getTurnplayer();
//		if(index==0){
//			((FamtoProduction) currentaction).famchoice();
//			return;
		/*} else*/ if(index!=2){
			Cards currentcard = ((FamtoProduction) currentaction).getCurrentcard();
			Stats costPreview = ((FamtoProduction) currentaction).getTotalCostPreview();
			List<ProductionEffect> peffects = new ArrayList<>();
			if(currentcard.getColor()==2){
				peffects.addAll(((YellowC)currentcard).getProdEffect());
			} else if(currentcard.getColor()==-1){
				peffects.addAll(((BonusTile)currentcard).getProdEffect());
			}
			int counter = 0;
			for(int i=0; i<peffects.size(); i++){
				if("Convert in Resources".equals((peffects.get(i)).getName())){
					counter++;
				}
				if("Convert in PC".equals((peffects.get(i)).getName())){
					counter++;
				}
				if("Convert WR in Resources".equals((peffects.get(i)).getName())){
					counter++;
				}
			}
			if(counter>=2){
				((FamtoProduction) currentaction).ChooseEffect();
			} else {
				for(ProductionEffect effect: peffects){
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
				(((FamtoProduction) currentaction).getCardsForActivation()).add(currentcard);
			}
			if(index == 3){
				((FamtoProduction) currentaction).activateEffects(currentplayer, game);
			}
		}
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#setIndex(int)
	 */
	@Override
	public void setIndex(int i) {
		this.index = i;;
	}

}
