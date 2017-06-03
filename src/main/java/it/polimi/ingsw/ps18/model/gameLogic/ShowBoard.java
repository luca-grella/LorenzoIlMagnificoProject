package it.polimi.ingsw.ps18.model.gameLogic;

import java.util.List;
import java.util.Observable;

import it.polimi.ingsw.ps18.model.board.boardcells.*;
import it.polimi.ingsw.ps18.model.messages.ActionMessage;
import it.polimi.ingsw.ps18.model.messages.LogMessage;
import it.polimi.ingsw.ps18.view.PBoardView;

public class ShowBoard extends Observable {
	
	public ShowBoard(PBoardView view){
		addObserver(view);
	}
	
	public void showMarket(List<MarketCell> market){
		StringBuilder builder = new StringBuilder();
		for(int i=0; i<market.size(); i++){
			MarketCell cell = market.get(i);
			builder.append("Market Cell number " + i + ":\n");
			builder.append(cell.toString());
			builder.append("\n");
		}
		notifyLogView(builder.toString());
		
	}
	
	private void notifyLogView(String msg){
		setChanged();
		notifyObservers(new LogMessage(msg));
	}

}
