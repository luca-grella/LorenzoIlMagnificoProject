package it.polimi.ingsw.ps18.controller.controlleractions.famtoharvest;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.boardcells.HarvCell;
import it.polimi.ingsw.ps18.model.cards.BlueC;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.effect.permeffects.Permanenteffect;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoCouncil;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class FamtoHarvestTrigger implements ActionChoice {

	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		FMember maxFM = new FMember(0, currentplayer.getPlayercol());
		
		//calcola il modificatore dagli effetti permanenti e lo aggiunge al maxValue
		int modifierValue = 0;
		for(Cards card: currentplayer.getCards()){
			if(card.hasPermanent()){
				for(Permanenteffect effect: ((BlueC) card).getPermeffect()){
					if("IncraseFMvalueOnHarvest".equals(effect.getName())){
						modifierValue += effect.getQuantity();
					}
				}
			}
		}
		
		/* TODO: il controllo per vedere se la prima cella e' vuota, va messo SSE non e' consentito al giocatore di piazzare un FMember
		 * in una cella a sua scelta nell'harvest, come nel Council 
		 * e.g. harvest vuoto, ma voglio mettere il mio FMember nelle celle con malus: se fosse consentito, harvest e production cells
		 * andrebbero totalmente ridefiniti
		*/
		
		if(game.getNplayer() > 2){
			int maxValue = 0;
			/*
			 * implementazione nel caso descritto dal primo todo: 
			 * if(harvCells.isEmpty) allora fai i controlli relativi al caso senza malus 
			 * (perche' se l'accesso fosse sequenziale, allora bisognerebbe accedere per forza al primo elemento dell;ArrayList) 
			 * altrimenti il controllo del valore del familiare dovra' tenere conto del malus.
			 * OPPURE risolvere considerando il malus in entrambi i casi, ma nel primo caso settato a zero
			 * TROVATI METODI IN BOARD che prima di inserire i familiari, fa questo controllo
			 */
			
			for(int famIndex=0; famIndex<currentplayer.getFams().size(); famIndex++){
				maxValue = currentplayer.getFams().get(famIndex).getValue() + currentplayer.getResources().getServants();
				if(maxValue > maxFM.getValue()){
					maxFM.setValue(maxValue);
				}
			} int actual = maxFM.getValue();
			maxFM.setValue(actual + modifierValue);
			/*
			 * TODO: Dati i controlli nella classe Board per l'inserimento dei familiari
			 * forse questi controlli relativi al malus sono ridondanti
			 * Inoltre non andrebbero bene se l'accesso all'ArrayList non fosse piu' sequenziale 
			 * (idem in tutti gli altri controlli relativi a harv e prod)
			 */
			if(game.getBoard().getHarvestCells().isEmpty()){
				HarvCell harvCell = new HarvCell(0);
				if(maxFM.getValue() > harvCell.getHarvCellValue()){ 
					Action action = new FamtoHarvest(currentplayer.getpBoardView());
					game.setOngoingAction(action);
					((FamtoHarvest) action).famchoice();
				}
				else{
					Action action = game.getOngoingAction();
					action.act(game); 
				}
			}
			else{
				HarvCell harvCell = new HarvCell(GeneralParameters.baseMalusHarvCells);
				if(maxFM.getValue() > harvCell.getHarvCellValue()){ 
					Action action = new FamtoHarvest(currentplayer.getpBoardView());
					game.setOngoingAction(action);
					((FamtoHarvest) action).famchoice();
				}
				else{
					Action action = game.getOngoingAction();
					action.act(game); 
				}
			}
		}
		else if(game.getNplayer() == 2){
			int maxValue = 0;
			//Se non fosse vuota, essendoci 2 giocatori, nessuno potrebbe piu' accederci
			if((((game.getBoard()).getHarvestCells()).isEmpty())){
				
				for(int famIndex=0; famIndex<currentplayer.getFams().size(); famIndex++){
					maxValue = currentplayer.getFams().get(famIndex).getValue() + currentplayer.getResources().getServants();
					if(maxValue > maxFM.getValue()){
						maxFM.setValue(maxValue);
					}
				} int actual = maxFM.getValue();
				maxFM.setValue(actual + modifierValue);
				if(maxFM.getValue() > GeneralParameters.baseValueHarvCells){
					Action action = new FamtoHarvest(currentplayer.getpBoardView());
					game.setOngoingAction(action);
					((FamtoHarvest) action).famchoice();
				}
				else{
					Action action = game.getOngoingAction();
					action.act(game);
				}
			}
			else{
				Action action = game.getOngoingAction();
				action.act(game); 
				//Negli altri casi l'ongoing action viene settata al valore successivo 
				//mentre qui non essendo ancora stata settata (ha valore di tHandler)
				//e' come se alla fine rifacesse fare l'azione (funziona)
				
			}
		}
	}

	@Override
	public void setIndex(int i) {
		return;
	}

}
