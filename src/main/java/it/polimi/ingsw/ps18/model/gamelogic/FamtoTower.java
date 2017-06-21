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
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;
import it.polimi.ingsw.ps18.view.PBoardView;

public class FamtoTower extends Observable implements Action {
	FMember chosenFam;
	private int indexFamtoRemove;
	int chosenTower;
	int chosenFloor;
	Stats totalCostPreview = new Stats(0,0,0,0,0,0,0);
	
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
//		currentplayer.getResources().addCoins( -(GeneralParameters.towerFee)); 
		
		//TODO: verificare che il pagamento delle 3 monete sia qui e non in ReceiveTowertoTower
		/*
		 * Questo perche' quando il controller va a ReceiveFloortoTower, verifica se si hanno le risorse per pagare la carta
		 * ma se prima non sono state pagate le 3 monete per la torre, allora quel controllo sarebbe errato
		 * CONTROLLO AGGIUNTO A RECEIVETOWERTOTOWER
		 */
		currentplayer.getFams().set(indexFamtoRemove, null);
		//riattivare gli effetti della cella sul giocatore
		tower.getTowerCells().get(chosenFloor).activateQEffects(currentplayer, game);
		if(currentplayer.getResources().enoughStats(totalCostPreview)){
			currentplayer.getResources().subStats(totalCostPreview);
			currentplayer.addCard(newcard,game);
		} else {
			this.famchoice();
		}
		

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

	/**
	 * @return the totalCostPreview
	 */
	public Stats getTotalCostPreview() {
		return totalCostPreview;
	}

	/**
	 * @param indexFamtoRemove the indexFamtoRemove to set
	 */
	public void setIndexFamtoRemove(int indexFamtoRemove) {
		this.indexFamtoRemove = indexFamtoRemove;
	}
	
	
	
}
