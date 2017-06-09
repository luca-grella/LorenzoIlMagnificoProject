package it.polimi.ingsw.ps18.model.gamelogic;

import java.util.Observable;

import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.messages.ActionMessage;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.view.PBoardView;

public class FamtoHarvest extends Observable implements Action {
	private FMember chosenFam;
	private int actionValue;
	
	public FamtoHarvest(PBoardView view){
		addObserver(view);
	}
	
	public void famchoice(){
		notifyActionPBoardView("Fam Choice Harvest");
	}

	@Override
	public void act(GameLogic game) {
		Board board = game.getBoard();
		if((actionValue = board.insertFMHarv(chosenFam))!=-100){
			PBoard currentplayer = game.getTurnplayer();
			currentplayer.actHarvest(actionValue);
		}
	}

	@Override
	public void setChosenFam(FMember chosenFam) {
		this.chosenFam = chosenFam;

	}
	
	private void notifyActionPBoardView(String msg){
		setChanged();
		notifyObservers(new ActionMessage(msg));
	}

}
