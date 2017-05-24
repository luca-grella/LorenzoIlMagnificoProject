package it.polimi.ingsw.ps18.Model.Board;

import java.util.ArrayList;

import it.polimi.ingsw.ps18.Model.Board.BoardCells.CouncilCell;
import it.polimi.ingsw.ps18.Model.Board.BoardCells.HarvCell;
import it.polimi.ingsw.ps18.Model.Board.BoardCells.MarketCell;
import it.polimi.ingsw.ps18.Model.Board.BoardCells.ProdCell;
import it.polimi.ingsw.ps18.Model.Board.BoardCells.Tower;
import it.polimi.ingsw.ps18.Model.Cards.Excommunications;

public class Board {
	private ArrayList<Tower> towers = new ArrayList<>();
	private ArrayList<MarketCell> market = new ArrayList<>();
	private ArrayList<CouncilCell> council = new ArrayList<>();
	private ArrayList<ProdCell> production = new ArrayList<>();
	private ArrayList<HarvCell> harvest = new ArrayList<>();
	private ArrayList<Excommunications> excomm = new ArrayList<>(); 
	
	public Board (){
		this.excomm.add(new Excommunications());
		this.excomm.add(new Excommunications());
		this.excomm.add(new Excommunications());
		
		
	}
	
	public ArrayList<Tower> getTowers(){
		return this.towers;
	}
	
	
	

}
