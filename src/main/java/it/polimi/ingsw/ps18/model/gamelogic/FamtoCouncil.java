package it.polimi.ingsw.ps18.model.gamelogic;

import java.util.List;
import java.util.Observable;

import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.CouncilCell;
import it.polimi.ingsw.ps18.model.messages.ActionMessage;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.view.PBoardView;
import it.polimi.ingsw.ps18.model.effect.generalEffects.Privilege;

public class FamtoCouncil extends Observable implements Action {
	private FMember chosenFam;
	private int indexFamtoRemove;
	private Privilege privilege;

	public FamtoCouncil(PBoardView view) {
		addObserver(view);
		privilege = new Privilege();
		this.privilege.setQuantity(GeneralParameters.numPrivilegesFromCouncil);
	}
	
	public void famchoice(){
		notifyActionPBoardView("Fam Choice Council");
	}

	@Override
	public void act(GameLogic game) {
		Board board = game.getBoard();
		List<CouncilCell> cells = board.getCouncilCells();
		cells.add(new CouncilCell(this.chosenFam));
		PBoard currentplayer = game.getTurnplayer();
		currentplayer.getFams().set(indexFamtoRemove, null);
		(currentplayer.getResources()).addCoins(GeneralParameters.coinsFromCouncil); 
		privilege.activate(currentplayer, game);

	}

	@Override
	public void setChosenFam(FMember chosenFam) {
		this.chosenFam = chosenFam;

	}
	
	private void notifyActionPBoardView(String msg){
		setChanged();
		notifyObservers(new ActionMessage(msg));
	}

}
