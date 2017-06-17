package it.polimi.ingsw.ps18.controller.controlleractions.famtocouncil;

import java.util.List;

import it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice;
import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.CouncilCell;
import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoCouncil;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ReceiveFamtoCouncil implements ActionChoice {
    int index;

	@Override
	public void act(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		List<FMember> fams = currentplayer.getFams();
		Board gameBoard = game.getBoard();
		List<CouncilCell> councilCells = gameBoard.getCouncilCells();
		FMember chosenfam = fams.set(index, null);
		Action currentaction = game.getOngoingAction();
		
		
		if(councilCells.get(councilCells.size()).isLegalCC(chosenfam) ){
			currentaction.setChosenFam(chosenfam);
			((FamtoCouncil) currentaction).act(game);
		}
		else{
			((FamtoCouncil) currentaction).famchoice();

		}
		/*
		 * 
		 * TODO: Da rivedere in quanto il consiglio e' un ArrayList che si crea a runtime
		 * quando viene inserito un familiare, quindi questo codice genererebbe un IndexOutOfBounds
		 */
//		if( ! (councilCells.isEmpty()) ){
//			for(int councilIndex=0; councilIndex<councilCells.size(); councilIndex++){
//				if( ! (councilCells.get(councilIndex).isLegalCC(chosenfam)) ){ //Se non e' legale esci
//				((FamtoCouncil) currentaction).famchoice();
//				
//				//Qui va bene famchoice perche' l'unica limitazione e' il valore della cella (valore 1)
//				//TODO: sulla base dei controlli che si metteranno a monte 
//				//(per esempio l'accesso alle celle negato se non si ha alcun familiare di valore uguale o maggiore al valore minimo delle celle)
//				//bisogna rivedere questi controlli
//
//				}
//			}
//		}

		
//		if(councilCells.isLegalCC(chosenfam)){
//		currentaction.setChosenFam(chosenfam);
//		((FamtoCouncil) currentaction).act(game);
//	}
//	else{
//		((FamtoCouncil) currentaction).famchoice();
//	}
//}
//else{
//	((FamtoCouncil) currentaction).famchoice();
	}

	/**
	 * @param index the index to set
	 */
	@Override
	public void setIndex(int index) {
		this.index = index;
	}

}
