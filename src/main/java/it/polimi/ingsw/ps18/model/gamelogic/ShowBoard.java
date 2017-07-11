package it.polimi.ingsw.ps18.model.gamelogic;

import java.util.List;
import java.util.Observable;

import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.*;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.messagesandlogs.ActionMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.LogMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.ParamMessage;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.view.PBoardView;

/**
 * The Class ShowBoard.
 */
public class ShowBoard extends Observable {
	
	/** The tester. */
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
	 * @param board the board
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
		notifyLogView(board.toString());
		
	}
	
	/**
	 * Show all towerswith zoom.
	 *
	 * @param board            the board
	 * @param playercol the playercol
	 */
	public void showAllTowerswithZoom(Board board, int playercol){
		notifyLogView(board.toString());
		setChanged();
		notifyObservers(new ParamMessage("Show Tower Choice", playercol));
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
	
	/**
	 * Show excomm.
	 *
	 * @param board the board
	 */
	public void ShowExcomm(Board board){
		notifyLogView(board.toStringExcomm());
	}
	
	/**
	 * Choose player.
	 *
	 * @param color the color
	 */
	public void choosePlayer(int color){
		setChanged();
		notifyObservers(new ParamMessage("Player Choice", color));
	}
	
	/**
	 * Show fam.
	 *
	 * @param player the player
	 */
	public void showFam(PBoard player){
		notifyLogView(player.toStringFams());
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
	
	/**
	 * Show servants.
	 *
	 * @param player the player
	 */
	public void showServants(PBoard player){
		notifyLogView(player.getResources().toStringServants());
	}
	
	/**
	 * Show bonus tiles.
	 *
	 * @param bonusTiles the bonus tiles
	 */
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
	 * Sets the tester.
	 *
	 * @param tester the new tester
	 */
	public void setTester(int tester) {
		this.tester=tester;
		
	}

}
