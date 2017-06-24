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

// TODO: Auto-generated Javadoc
/**
 * The Class FamtoCouncil.
 */
public class FamtoCouncil extends Observable implements Action {
	
	/**
	 * The chosen fam.
	 */
	private FMember chosenFam;
	
	/**
	 * The index famto remove.
	 */
	private int indexFamtoRemove;
	
	/**
	 * The privilege.
	 */
	private Privilege privilege;

	/**
	 * Instantiates a new famto council.
	 *
	 * @param view
	 *            the view
	 */
	public FamtoCouncil(PBoardView view) {
		addObserver(view);
		privilege = new Privilege();
		this.privilege.setQuantity(GeneralParameters.numPrivilegesFromCouncil);
	}
	
	/**
	 * Famchoice.
	 */
	public void famchoice(){
		notifyActionPBoardView("Fam Choice Council");
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.gamelogic.Action#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
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

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.gamelogic.Action#setChosenFam(it.polimi.ingsw.ps18.model.personalboard.FMember)
	 */
	@Override
	public void setChosenFam(FMember chosenFam) {
		this.chosenFam = chosenFam;

	}
	
	/**
	 * Notify action P board view.
	 *
	 * @param msg
	 *            the msg
	 */
	private void notifyActionPBoardView(String msg){
		setChanged();
		notifyObservers(new ActionMessage(msg));
	}

}
