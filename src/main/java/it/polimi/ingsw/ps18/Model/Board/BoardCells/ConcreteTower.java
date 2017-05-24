package it.polimi.ingsw.ps18.Model.Board.BoardCells;

import java.util.ArrayList;

import it.polimi.ingsw.ps18.Model.Cards.Cards;
/*import java.util.Scanner;*/
import it.polimi.ingsw.ps18.Model.PBoard.FMember;

public class ConcreteTower implements Tower {
	
	private ArrayList<Cell> towerCells = new ArrayList<>();
	
	
	public ConcreteTower (){
		int count;
		int numberOfCells = 4;

		for(count=0; count<numberOfCells; count++){
			
		this.towerCells.add(count, new Cell()); //TowerObj.CellObj.method (TowerObj will be created by Board)
			
		//this.tempCell= insertFM(); // inteso insertFM della cella, non della torre
		}
		
	}
	
	
	public Cards insertFM(FMember pBoardFM, int floor){
		
		Cell tempCell = this.towerCells.get(floor);
		return tempCell.insertFM(pBoardFM);
		
	}
	
	public void insertCards (ArrayList<Cards> turnCards){
		
		for(int i=0; i<turnCards.size(); i++){
			Cell cell = this.towerCells.get(i);
			//aggiungere carta nella cella selezionata
		}
	}

}
