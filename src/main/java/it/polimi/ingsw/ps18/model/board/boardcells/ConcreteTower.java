package it.polimi.ingsw.ps18.model.board.boardcells;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.gameLogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalBoard.FMember;

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
	private int cellIndex; //Used for toString(index) method
	
	
	public ConcreteTower () {
		for(int count=0; count<GeneralParameters.numberofCells; count++){
		      this.towerCells.add(count, new Cell());
		}
	}
	
	/**
	 * Uses the Cell method insertCard, that places a card in a cell
	 * and iterates it for all the cells in a tower
	 */
	public void insertCards (List<Cards> towerCards, int period) {
		//TODO: riscrivere insertCards. deve togliere dalla lista quelle usate e posizionare solo quelle dell'era giusta
    	
		Collections.shuffle(towerCards);
		
		for(int i=0; i<GeneralParameters.numberofCells; i++){
			Cell towerCell = this.towerCells.get(i);
			Cards cellCard = towerCards.get(i);
			Iterator<Cards> itr = towerCards.iterator();
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
	
	public List<String> toString(int index){
		StringBuilder builder = new StringBuilder();
		List<String> towerStrings = new ArrayList<>(GeneralParameters.numberofCells);
		String towerString = null;
		for(int count=0; count<GeneralParameters.numberofCells; count++){
		      towerStrings.add(count, towerString);
		}
		builder.append("-----------------\n");
	
		builder.append("Cells in tower number" + index + ":\n");
		
		for(cellIndex=0; cellIndex<GeneralParameters.numberofCells; cellIndex++){
			Cell towerCell = towerCells.get(cellIndex);
			//towerString = towerStrings.get(cellIndex);  Sonar says it's a useless assignment	
			towerString = towerCell.toString(cellIndex);	//Ora devo fare in modo che il contenuto di towerString venga stampato
			towerStrings.set(cellIndex, towerString);
		}
		
		return towerStrings;//Dubbio sul tipo di ritorno e sulle modalità di ritorno del metodo
							//(e.g. builder.toString() cosa fa? ritornando towerStrings, è la View a stamparlo in modo iterato?)
		
		
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
