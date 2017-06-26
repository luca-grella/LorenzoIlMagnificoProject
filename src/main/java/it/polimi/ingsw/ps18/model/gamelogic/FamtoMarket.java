package it.polimi.ingsw.ps18.model.gamelogic;

import java.util.ArrayList;
import java.util.Observable;

import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.MarketCell;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.view.PBoardView;

// TODO: Auto-generated Javadoc
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
	 */
	public void cellChoice() {
		notifyActionPBoardView("Market Cell Choice");
		
	}
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.gamelogic.Action#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		Board board = game.getBoard();
		ArrayList<MarketCell> marketCells = (ArrayList<MarketCell>) board.getMarketCells();
		MarketCell cell = marketCells.get(chosenCell);
		cell.insertFM(chosenFam, game);
		game.getTurnplayer().getFams().set(indexFamtoRemove, null);
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

	

	
}
