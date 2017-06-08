package it.polimi.ingsw.ps18.model.board.boardcells;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import it.polimi.ingsw.ps18.model.cards.Cards;
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
	//private int cellIndex; //Used for toString(index) method
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
		return towerCell.insertFM(pBoardFM);
		
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
	
	/*
	 * Info generali di una torre
	 * DEFINE LATER
	 */
	public String toString(){
		StringBuilder builder = new StringBuilder();

		builder.append("-----------------\n");
		builder.append("Details of tower: \n");
		builder.append("Tower color: " + this.color); //Qui l'ho chiamato Tower color, da altre parti il colore l'ho chiamato numero
		builder.append("Number of cells in tower: " + this.towerCells.size());
		return builder.toString();
	}
	/*
	 * Controlli vari
	 */
	

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
