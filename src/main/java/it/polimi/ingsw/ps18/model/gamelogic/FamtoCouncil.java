package it.polimi.ingsw.ps18.model.gamelogic;

import java.util.List;
import java.util.Observable;

import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.CouncilCell;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.view.PBoardView;
import it.polimi.ingsw.ps18.model.effect.generalEffects.Privilege;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;

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
	 * The number of servants to add to the action value 
	 * of the current FMember, chosen by the current player
	 */
	private int numberOfServants;
	
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
	
	public void servantsChoice(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		ShowBoard showBoard = new ShowBoard(currentplayer.getpBoardView());
		showBoard.showCouncil(game.getBoard());
		
		numberOfServants = -1;
		while(this.numberOfServants < 0 || this.numberOfServants > currentplayer.getResources().getServants()){
			notifyActionPBoardView("Servants Choice");
		}
	}

	/**
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
		currentplayer.getResources().addServants(- (this.numberOfServants));
		privilege.activate(currentplayer, game);

	}

	/**
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
	
	

	/**
	 * @return the numberOfServants
	 */
	public int getNumberOfServants() {
		return numberOfServants;
	}

	@Override
	public void setNumberOfServants(int numberOfServants) {
		this.numberOfServants = numberOfServants;
	}

	/**
	 * @param indexFamtoRemove the indexFamtoRemove to set
	 */
	public void setIndexFamtoRemove(int indexFamtoRemove) {
		this.indexFamtoRemove = indexFamtoRemove;
	}
	

}
