package it.polimi.ingsw.ps18.model.gamelogic;

import java.util.List;
import java.util.Observable;

import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.*;
import it.polimi.ingsw.ps18.model.messages.ActionMessage;
import it.polimi.ingsw.ps18.model.messages.LogMessage;
import it.polimi.ingsw.ps18.model.messages.StatusMessage;
import it.polimi.ingsw.ps18.view.PBoardView;

public class ShowBoard extends Observable {
	
	public ShowBoard(PBoardView view){
		addObserver(view);
	}
	
	public void showMarket(List<MarketCell> market){
		StringBuilder builder = new StringBuilder();
		for(int i=0; i<market.size(); i++){
			MarketCell cell = market.get(i);
			builder.append(cell.toString(i));
			builder.append("\n");
		}
		notifyLogView(builder.toString());
		
	}
	
	public void showAllTowers(Board board) {
		notifyLogView(board.toStringTowers());
		
	}
	
	public void showAllTowerswithZoom(Board board){
		notifyLogView(board.toStringTowers());
		notifyStatusView("Tower Choice");
	}
	
	public void showTowerCell(Board board, int i){
		List<Tower> towers = board.getTowers();
		Tower tower = towers.get(i);
		notifyLogView(tower.toString(i));
	}
	
	public void showCouncil(Board board){
		notifyLogView(board.toStringCouncil());
	}
	
	
	
	
	private void notifyLogView(String msg){
		setChanged();
		notifyObservers(new LogMessage(msg));
	}
	
	private void notifyStatusView(String msg){
		setChanged();
		notifyObservers(new StatusMessage(msg));
	}

}
