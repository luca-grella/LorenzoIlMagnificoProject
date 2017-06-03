package it.polimi.ingsw.ps18.model.gameLogic;

import java.util.Observable;

import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.messages.ActionMessage;
import it.polimi.ingsw.ps18.model.personalBoard.FMember;
import it.polimi.ingsw.ps18.model.personalBoard.PBoard;
import it.polimi.ingsw.ps18.view.PBoardView;

public class FamtoTower extends Observable {
	
	public FamtoTower(PBoardView view){
		addObserver(view);
	}
	
	public void famchoice(){
		notifyActionPBoardView("Fam Choice");
	}

	public void act(FMember fam, Board board, PBoard player) {
//		ArrayList<Tower> towers = (ArrayList<Tower>) board.getTowers();
//		Tower tower = towers.get(towerchoice);
//		Cards newcard = tower.insertFM(fam, floorchoice);
//		player.addCard(newcard);
	}
	
	private void notifyActionPBoardView(String msg){
		setChanged();
		notifyObservers(new ActionMessage(msg));
	}

}
