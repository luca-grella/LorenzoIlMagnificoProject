package it.polimi.ingsw.ps18.controller.controlleractions.famtoproduction;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.boardcells.HarvCell;
import it.polimi.ingsw.ps18.model.board.boardcells.ProdCell;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.gamelogic.TurnHandler;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ReceiveFamtoProduction implements ActionChoice {
	private int index;

	@Override
	public void act(GameLogic game) {
		Action currentaction = game.getOngoingAction();
		PBoard currentplayer = game.getTurnplayer();
		List<FMember> fams = currentplayer.getFams();
		FMember chosenfam = fams.get(index);
		((FamtoProduction) currentaction).setIndexFamtoRemove(index);
		List <ProdCell> prodCells = game.getBoard().getProductionCells();

		if( ! (prodCells.isEmpty()) ){
			if(game.getBoard().isLegalProd(chosenfam)){
				ProdCell prodCell = new ProdCell(GeneralParameters.baseMalusProdCells);
				if(prodCell.isLegalPC(chosenfam)){
					currentaction.setChosenFam(chosenfam);
					((FamtoProduction) currentaction).act(game);
				}
				else{
					//Entra qui soltanto se il familiare era legale, ma il suo valore non era sufficiente rispetto a quello della cella
					Action action = new TurnHandler(currentplayer);
					game.setOngoingAction(action);
				}
			}
			else{
				for(int famIndex=0; famIndex<fams.size(); famIndex++){
					if(chosenfam.getColor() == GeneralParameters.neutralFMColor){
						((FamtoProduction) currentaction).famchoice();
						return;
					}
				}
				Action action = new TurnHandler(currentplayer);
				game.setOngoingAction(action);
			}
		}
		else{
			ProdCell prodCell = new ProdCell(0);
			if(prodCell.isLegalPC(chosenfam)){
				currentaction.setChosenFam(chosenfam);
				((FamtoProduction) currentaction).act(game);
			}
			else{
				//Entra qui soltanto se il familiare era legale, ma il suo valore non era sufficiente rispetto a quello della cella
				Action action = new TurnHandler(currentplayer);
				game.setOngoingAction(action);
			}
		}
		
	}

	@Override
	public void setIndex(int i) {
		this.index = i;
	}

}
