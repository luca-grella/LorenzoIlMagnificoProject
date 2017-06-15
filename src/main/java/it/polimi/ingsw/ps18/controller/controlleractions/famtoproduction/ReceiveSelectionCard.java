package it.polimi.ingsw.ps18.controller.controlleractions.famtoproduction;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.cards.YellowC;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertResorResinResources;
import it.polimi.ingsw.ps18.model.effect.prodEffect.Converter;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.gamelogic.*;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public class ReceiveSelectionCard implements ActionChoice {
	private int index;

	@Override
	public void act(GameLogic game) {
		if(index!=2){
			Action currentaction = game.getOngoingAction();
			PBoard currentplayer = game.getTurnplayer();
			YellowC currentcard = ((FamtoProduction) currentaction).getCurrentcard();
			Stats costPreview = ((FamtoProduction) currentaction).getTotalCostPreview();
			List<ProductionEffect> peffects = currentcard.getProdEffect();
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
						ceffect.WoodorRockChoice(currentplayer);
						costPreview.addStats(ceffect.getCost());
					}
				}
				if(!((currentplayer.getResources()).enoughStats(costPreview))){
					((FamtoProduction) currentaction).chooseCards(currentplayer);
				}
				(((FamtoProduction) currentaction).getCardsForActivation()).add(currentcard);
			}
			//migliorare gestione. se si rimanda a chooseCards avendo premuto 3 diventa un casino
//			if(index == 3){
//				((FamtoProduction) currentaction).activateEffects(currentplayer);
//			}
		}
	}

	@Override
	public void setIndex(int i) {
		this.index = i;;
	}

}
