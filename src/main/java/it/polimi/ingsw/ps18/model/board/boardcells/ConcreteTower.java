package it.polimi.ingsw.ps18.model.board.boardcells;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.gamelogic.FamtoTower;
import it.polimi.ingsw.ps18.model.gamelogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalboard.FMember;

/**
 * Defines a Tower composed by Cell objects. <br>
 * Inherits and overrides methods from the Tower Interface.
 * @see
 * {@link it.polimi.ingsw.ps18.model.board.boardcells.Cell} 
 * @see
 * {@link it.polimi.ingsw.ps18.model.board.boardcells.Tower}
 */

public class ConcreteTower implements Tower {
	private List<Cell> towerCells = new ArrayList<>(GeneralParameters.numberofCells);
	private int color;
	
	public ConcreteTower (int towerIndex) {
		this.color = towerIndex;
		for(int count=0; count<GeneralParameters.numberofCells; count++){
		      this.towerCells.add(count, new Cell());
		}
	}
	
	/**
	 * Uses the Cell method insertCard, that places a card in a cell
	 * and iterates it for all the cells in a tower
	 */
	public void insertCards (List<Cards> towerCards, int period) {
		Collections.shuffle(towerCards);
		
		for(int i=0; i<GeneralParameters.numberofCells; i++){
			Cell towerCell = this.towerCells.get(i);
			Iterator<Cards> itr = towerCards.iterator();
			Cards cellCard = itr.next();
			while(itr.hasNext() && cellCard.getPeriod() != period){
				cellCard = itr.next();
			}
			towerCell.insertCard(cellCard);
			/*boolean isRemoved = */towerCards.remove(cellCard);

		}
	}
	
	
	/**
	 * Uses the Cell method insertFM, that places a FMember in a cell
	 * after selecting the cell floor in a tower
	 * @param pBoardFM indicates the FM that is going to be used in the action
	 */
	
	public Cards insertFM(FMember pBoardFM, int floor) {
		Cell towerCell = this.towerCells.get(floor);
		return towerCell.insertFM(pBoardFM);  //insertFM chiama isEmpty
	}
	
	
	public boolean isLegalT(FMember pBoardFM) {
		
		if(this.isEmptyT()){
			return true;
		}
		else{
			for(int index=0; index<GeneralParameters.numberofCells; index++){
				Cell towerCell = towerCells.get(index);
				FMember towerCellFM = towerCell.getCellFM();
				if(!(towerCell.isEmptyTC())){ 
					if(towerCellFM.getPlayercol() == pBoardFM.getPlayercol()){
						if(towerCellFM.getColor() != GeneralParameters.neutralFMColor){
							return false;
						}
					}
						/*
						 * Se e' neutro allora cicla alla cella dopo perche' nella torre possono stare un neutro e un
						 * non neutro dello stesso colore. Questo controllo diventa debole se si iniziano a prevedere più familiari neutri
						 * per ogni plancia giocatore.
						 */
						
				}
			}
		}
		
		return true;
	}
	/*
	 * TODO:
	 * PROBABILMENTE NON SERVE AD UN CAZZO
	 * esiste un isEmpty() per gli ArrayList, anche se isEmptyT viene usato da oggetti di tipo ConcreteTower
	 */
	public boolean isEmptyT(){
		if(towerCells.size() == 0){
			return true;
		}
		else{
			for(int index=0; index<GeneralParameters.numberofCells; index++){
				Cell towerCell = towerCells.get(index);
				if( !(towerCell.isEmptyTC()))
					return false;
			}
			return true;
		}
		
	}
	
	
	
	@Override
	public String toString(int index){
		StringBuilder builder = new StringBuilder();

		builder.append("-----------------\n");
		builder.append("Cells in tower number" + index + ":\n");
		
		for(int cellIndex=0; cellIndex<GeneralParameters.numberofCells; cellIndex++){
			Cell towerCell = towerCells.get(cellIndex);
			builder.append(towerCell.toString(cellIndex));
			builder.append("\n-----------------\n");
		}
		
		return builder.toString();
	}
	
	
	 //TODO: Definire Info generali di una torre
	public String toString(){
		StringBuilder builder = new StringBuilder();

		builder.append("-----------------\n");
		builder.append("Details of tower: \n");
		builder.append("\tTower color: " + this.color + "\n");
		builder.append("\tNumber of cells in tower: " + this.towerCells.size());
		return builder.toString();
	}
	

	/**
	 * @return the towerCells
	 */
	public List<Cell> getTowerCells() {
		return towerCells;
	}

	/**
	 * @param towerCells the towerCells to set
	 */
	public void setTowerCells(List<Cell> towerCells) {
		this.towerCells = towerCells;
	}
	

}
