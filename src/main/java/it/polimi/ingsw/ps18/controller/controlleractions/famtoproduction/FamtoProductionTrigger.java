package it.polimi.ingsw.ps18.controller.controlleractions.famtoproduction;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.boardcells.ProdCell;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoHarvest;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoProduction;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class FamtoProductionTrigger implements ActionChoice {
	
	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		FMember maxFM = new FMember(0, currentplayer.getPlayercol()); 
		/*
		 * TODO: verificare che mettendo 0 al valore, non mi incasini i controlli
		 * Controllare per tutti i trigger
		 */
		
		if(game.getNplayer() > 2){
			int maxValue = 0;
			for(int famIndex=0; famIndex<currentplayer.getFams().size(); famIndex++){
				maxValue = currentplayer.getFams().get(famIndex).getValue() + currentplayer.getResources().getServants();
				if(maxValue > maxFM.getValue()){
					maxFM.setValue(maxValue);
				}
			}
			if(game.getBoard().getHarvestCells().isEmpty()){
				ProdCell prodCell = new ProdCell(0);
				if(maxFM.getValue() > prodCell.getProdCellValue()){
					Action action = new FamtoProduction(currentplayer.getpBoardView());
					game.setOngoingAction(action);
					((FamtoProduction) action).famchoice();
				}
				else{
					Action action = game.getOngoingAction();
					action.act(game); 
				}
			}
			else{
				ProdCell prodCell = new ProdCell(GeneralParameters.baseMalusProdCells);
				if(maxFM.getValue() > prodCell.getProdCellValue()){
					Action action = new FamtoProduction(currentplayer.getpBoardView());
					game.setOngoingAction(action);
					((FamtoProduction) action).famchoice();
				}
				else{
					Action action = game.getOngoingAction();
					action.act(game); 
				}
			}
		}
		else if(game.getNplayer() == 2){
			int maxValue = 0;
			if((((game.getBoard()).getProductionCells().isEmpty()))){
				
				for(int famIndex=0; famIndex<currentplayer.getFams().size(); famIndex++){
					maxValue = currentplayer.getFams().get(famIndex).getValue() + currentplayer.getResources().getServants();
					if(maxValue > maxFM.getValue()){
						maxFM.setValue(maxValue);
					}
				}
				if(maxFM.getValue() > GeneralParameters.baseValueProdCells){
					Action action = new FamtoProduction(currentplayer.getpBoardView());
					game.setOngoingAction(action);
					((FamtoProduction) action).famchoice();
				}
				else{
					Action action = game.getOngoingAction();
					action.act(game); 
				}
			}
			else{
				Action action = game.getOngoingAction();
				action.act(game); 
			}
		}
	}

	@Override
	public void setIndex(int i) {
		return;
	}

}
