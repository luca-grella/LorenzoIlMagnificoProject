package it.polimi.ingsw.ps18.model.board.boardcells;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.gameLogic.GeneralParameters;
import it.polimi.ingsw.ps18.model.personalBoard.FMember;

public class ConcreteTower implements Tower {
	
	private List<Cell> towerCells = new ArrayList<>();
	
	
	public ConcreteTower (){
		for(int count=0; count<GeneralParameters.numberofCells; count++){
		      this.towerCells.add(count, new Cell());
			
		      //this.tempCell= insertFM();
		}
		
	}
	
	
	public Cards insertFM(FMember pBoardFM, int floor){
		
		Cell tempCell = this.towerCells.get(floor);
		Cards prova = tempCell.insertFM(pBoardFM);
		return prova;
		
	}
	
	public void insertCards (List<Cards> turnCards){
		
		for(int i=0; i<2; i++){
			Cell cell = this.towerCells.get(i);
			Cards card = turnCards.get(i);
			cell.insertCard(card);
		}
	}

}
