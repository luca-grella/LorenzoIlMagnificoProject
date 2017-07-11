package it.polimi.ingsw.ps18.model.gamelogic;

import java.util.ArrayList;
import java.util.Observable;

import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.MarketCell;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * The Class FamtoMarket.
 */
public class FamtoMarket extends Observable implements Action {
	
	/**
	 * The chosen fam.
	 */
	private FMember chosenFam;
	
	/**
	 * The index famto remove.
	 */
	private int indexFamtoRemove; 
	
	/** The number of servants to add to the action value  of the current FMember, chosen by the current player. */
	private int numberOfServants;
	
	/**
	 * The chosen cell.
	 */
	private int chosenCell;

	/**
	 * Instantiates a new famto market.
	 *
	 * @param view
	 *            the view
	 */
	public FamtoMarket(PBoardView view) {
		addObserver(view);
	}
	
	/**
	 * Famchoice.
	 */
	public void famchoice(){
		notifyActionPBoardView("Fam Choice Market");
	}
	
	/**
	 * Cell choice.
	 *
	 * @param game the game
	 */
	public void cellChoice(GameLogic game) {
		PBoard currentplayer = game.getTurnplayer();
		ShowBoard showBoard = new ShowBoard(currentplayer.getpBoardView());
		showBoard.showMarket(game.getBoard());
		
		numberOfServants = -1;
		while(this.numberOfServants < 0 || this.numberOfServants > currentplayer.getResources().getServants()){
			notifyActionPBoardView("Servants Choice");	
		}
		notifyActionPBoardView("Market Cell Choice");
		
	}
	
	
	
	/**
	 * Act.
	 *
	 * @param game the game
	 * @see it.polimi.ingsw.ps18.model.gamelogic.Action#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		Board board = game.getBoard();
		ArrayList<MarketCell> marketCells = (ArrayList<MarketCell>) board.getMarketCells();
		MarketCell cell = marketCells.get(chosenCell);
		cell.insertFM(chosenFam, game);
		game.getTurnplayer().getFams().set(indexFamtoRemove, null);
		game.getTurnplayer().getResources().addServants(- this.numberOfServants);
		game.notifyAll("\n\n-----------------\nPlayer number " + game.getTurnplayer().getPlayercol() + " has moved a Family Member\nto the "
				+ (chosenCell+1) + " cell in the Market.\n-----------------\n\n");
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
	 * Gets the chosen fam.
	 *
	 * @return the chosenFam
	 */
	public FMember getChosenFam() {
		return chosenFam;
	}

	/**
	 * Sets the chosen fam.
	 *
	 * @param chosenFam
	 *            the chosenFam to set
	 */
	public void setChosenFam(FMember chosenFam) {
		this.chosenFam = chosenFam;
	}

	/**
	 * Gets the chosen cell.
	 *
	 * @return the chosenCell
	 */
	public int getChosenCell() {
		return chosenCell;
	}

	/**
	 * Sets the chosen cell.
	 *
	 * @param chosenCell
	 *            the chosenCell to set
	 */
	public void setChosenCell(int chosenCell) {
		this.chosenCell = chosenCell;
	}

	/**
	 * Sets the index famto remove.
	 *
	 * @param indexFamtoRemove
	 *            the indexFamtoRemove to set
	 */
	public void setIndexFamtoRemove(int indexFamtoRemove) {
		this.indexFamtoRemove = indexFamtoRemove;
	}

	
	/**
	 * Gets the number of servants.
	 *
	 * @return the numberOfServants
	 */
	public int getNumberOfServants() {
		return numberOfServants;
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.gamelogic.Action#setNumberOfServants(int)
	 */
	@Override
	public void setNumberOfServants(int numberOfServants) {
			this.numberOfServants = numberOfServants;
	}

	/**
	 * Gets the index famto remove.
	 *
	 * @return the index famto remove
	 */
	public int getIndexFamtoRemove() {
		
		return indexFamtoRemove;
	}

	

	
}
