package it.polimi.ingsw.ps18.model.gamelogic;

import java.util.List;
import java.util.Observable;

import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.*;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.LogMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * The Class ShowBoard.
 */
public class ShowBoard extends Observable {
	private int tester=1;
	
	/**
	 * Instantiates a new show board.
	 *
	 * @param view
	 *            the view
	 */
	public ShowBoard(PBoardView view){
		addObserver(view);
	}
	
	/**
	 * Show market.
	 *
	 * @param market
	 *            the market
	 */
	public void showMarket(Board board){
		StringBuilder builder = new StringBuilder();
		List<MarketCell> market = board.getMarketCells();
		for(int i=0; i<market.size(); i++){
			MarketCell cell = market.get(i);
			builder.append(cell.toString(i));
			builder.append("\n");
		}
		
		if(tester!=999){
		notifyLogView(builder.toString());
		}
	}
	
	/**
	 * Show all towers.
	 *
	 * @param board
	 *            the board
	 */
	public void showAllTowers(Board board) {
		notifyLogView(board.toStringTowers());
		
	}
	
	/**
	 * Show all towerswith zoom.
	 *
	 * @param board
	 *            the board
	 */
	public void showAllTowerswithZoom(Board board){
		notifyLogView(board.toStringTowers());
		notifyStatusView("Tower Choice");
	}
	
	/**
	 * Show tower cell.
	 *
	 * @param board
	 *            the board
	 * @param i
	 *            the i
	 */
	public void showTowerCell(Board board, int i){
		List<Tower> towers = board.getTowers();
		Tower tower = towers.get(i);
		
		if(tester!=999){
			notifyLogView(tower.toString(i));
			}
		
		
	}
	
	/**
	 * Show council.
	 *
	 * @param board
	 *            the board
	 */
	public void showCouncil(Board board){
		notifyLogView(board.toStringCouncil());
	}
	
	/**
	 * Show harvest.
	 *
	 * @param board
	 *            the board
	 */
	public void showHarvest(Board board){
		notifyLogView(board.toStringHarvest());
	}
	
	/**
	 * Show production.
	 *
	 * @param board
	 *            the board
	 */
	public void showProduction(Board board){
		notifyLogView(board.toStringProduction());
	}
	
	public void ShowExcomm(Board board){
		notifyLogView(board.toStringExcomm());
	}
	
	/**
	 * Choose player.
	 */
	public void choosePlayer(){
		notifyStatusView("Player Choice");
	}
	
	/**
	 * Show player.
	 *
	 * @param player
	 *            the player
	 */
	public void showPlayer(PBoard player){
		notifyLogView(player.toStringResources());
		notifyLogView(player.toStringCards());
	}
	public void showServants(PBoard player){
		notifyLogView(player.getResources().toStringServants());
	}
	
	public void showBonusTiles(List<Cards> bonusTiles){
		for(int i=0; i<bonusTiles.size(); i++){
			notifyLogView(bonusTiles.get(i).toString(i));
		}
	}
	
	
	
	/**
	 * Notify log view.
	 *
	 * @param msg
	 *            the msg
	 */
	private void notifyLogView(String msg){
		setChanged();
		notifyObservers(new LogMessage(msg));
	}
	
	/**
	 * Notify status view.
	 *
	 * @param msg
	 *            the msg
	 */
	private void notifyStatusView(String msg){
		setChanged();
		notifyObservers(new StatusMessage(msg));
	}

	/**
	 * @param i
	 */
	public void setTester(int tester) {
		this.tester=tester;
		
	}

}
