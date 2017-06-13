package it.polimi.ingsw.ps18.model.gamelogic;

import java.util.ArrayList;
import java.util.Observable;

import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.Tower;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.messages.ActionMessage;
import it.polimi.ingsw.ps18.model.messages.ParamMessage;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.view.PBoardView;

public class FamtoTower extends Observable implements Action {
	FMember chosenFam;
	int chosenTower;
	int chosenFloor;
	
	public FamtoTower(PBoardView view){
		addObserver(view);
	}
	
	public void famchoice(){
		notifyActionPBoardView("Fam Choice Tower");
	}
	
	public void towerChoice(){
		notifyActionPBoardView("Tower Choice");
	}
	
	public void floorChoice(){
		notifyParamPBoardView("Floor Choice",this.chosenTower);
	}

	@Override
	public void act(GameLogic game) {
		Board board = game.getBoard();
		ArrayList<Tower> towers = (ArrayList<Tower>) board.getTowers();
		Tower tower = towers.get(this.chosenTower);
		Cards newcard = tower.insertFM(this.chosenFam, this.chosenFloor);
		PBoard currentplayer = game.getTurnplayer();
		currentplayer.addCard(newcard,game);
	}
	

	private void notifyActionPBoardView(String msg){
		setChanged();
		notifyObservers(new ActionMessage(msg));
	}
	
	private void notifyParamPBoardView(String msg,int index){
		setChanged();
		notifyObservers(new ParamMessage(msg,index));
	}

	/**
	 * @return the chosenFam
	 */
	public FMember getChosenFam() {
		return chosenFam;
	}

	/**
	 * @param chosenFam the chosenFam to set
	 */
	public void setChosenFam(FMember chosenFam) {
		this.chosenFam = chosenFam;
	}

	/**
	 * @return the chosenTower
	 */
	public int getChosenTower() {
		return chosenTower;
	}

	/**
	 * @param chosenTower the chosenTower to set
	 */
	public void setChosenTower(int chosenTower) {
		this.chosenTower = chosenTower;
	}

	/**
	 * @return the chosenFloor
	 */
	public int getChosenFloor() {
		return chosenFloor;
	}

	/**
	 * @param chosenFloor the chosenFloor to set
	 */
	public void setChosenFloor(int chosenFloor) {
		this.chosenFloor = chosenFloor;
	}
	
}
