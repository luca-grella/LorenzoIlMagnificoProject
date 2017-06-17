package it.polimi.ingsw.ps18.controller.controlleractions.famtoharvest;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class FamtoHarvestTrigger implements ActionChoice {

	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		FMember maxFM = new FMember(null, currentplayer.getPlayercol());
		
		//prendo il FM di valore massimo, ci aggiungo tutti i servitori del player e, se maxFM puo' accedere ad almeno una cella
		//allora vado avanti, se no blocco
		if(game.getNplayer() > 2){
			/*
			 * il controllo per vedere se la prima cella e' vuota, va messo SSE non e' consentito al giocatore di piazzare un FMember
			 * in una cella a sua scelta nell'harvest, come nel Council 
			 * e.g. harvest vuoto, ma voglio mettere il mio FMember nelle celle con malus: se fosse consentito, harvest e production cells
			 * andrebbero totalmente ridefiniti
			*/
			
			//TODO: se ho voglia sostituisco con un for each
			for(int famIndex=0; famIndex<currentplayer.getFams().size(); famIndex++){
				maxFM.setValue(currentplayer.getFams().get(famIndex).getValue() + currentplayer.getResources().getServants());
				
				if(maxFM.getValue() > GeneralParameters.baseValueHarvCells){
					Action action = new FamtoHarvest(currentplayer.getpBoardView());
					game.setOngoingAction(action);
					((FamtoHarvest) action).famchoice();
				}
				//else cicla al prossimo FMember
			}
			//Non ha trovato dei FMember del player che possano accedere alle celle, quindi deve uscire
			Action action = game.getOngoingAction();
			action.act(game); 
		}
		else if(game.getNplayer() == 2){
			if((((game.getBoard()).getHarvestCells()).isEmpty())){
				//TODO: se ho voglia sostituisco con un for each
				for(int famIndex=0; famIndex<currentplayer.getFams().size(); famIndex++){
					maxFM.setValue(currentplayer.getFams().get(famIndex).getValue() + currentplayer.getResources().getServants());
					
					if(maxFM.getValue() > GeneralParameters.baseValueHarvCells){
						Action action = new FamtoHarvest(currentplayer.getpBoardView());
						game.setOngoingAction(action);
						((FamtoHarvest) action).famchoice();
					}
					//else cicla al prossimo FMember
				}
				//Non ha trovato dei FMember del player che possano accedere alle celle, quindi deve uscire
				Action action = game.getOngoingAction();
				action.act(game); 
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
