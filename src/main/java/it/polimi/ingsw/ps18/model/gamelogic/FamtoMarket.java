package it.polimi.ingsw.ps18.model.gameLogic;

import java.util.ArrayList;
import java.util.Observable;

import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.MarketCell;
import it.polimi.ingsw.ps18.model.messages.ActionMessage;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.view.PBoardView;

public class FamtoMarket extends Observable implements Action {
	FMember chosenFam;
	int chosenCell;

	public FamtoMarket(PBoardView view) {
		addObserver(view);
	}
	
	public void famchoice(){
		notifyActionPBoardView("Fam Choice Market");
	}
	
	public void cellChoice() {
		notifyActionPBoardView("Market Cell Choice");
		
	}
	
	@Override
	public void act(GameLogic game) {
		Board board = game.getBoard();
		ArrayList<MarketCell> marketCells = (ArrayList<MarketCell>) board.getMarketCells();
		MarketCell cell = marketCells.get(chosenCell);
		cell.insertFM(chosenFam, game.getTurnplayer());
	}
	
	private void notifyActionPBoardView(String msg){
		setChanged();
		notifyObservers(new ActionMessage(msg));
	}

	/**
	 * @param chosenFam the chosenFam to set
	 */
	@Override
	public void setChosenFam(FMember chosenFam) {
		this.chosenFam = chosenFam;
	}

	/**
	 * @param chosenCell the chosenCell to set
	 */
	public void setChosenCell(int chosenCell) {
		this.chosenCell = chosenCell;
	}
	
}
