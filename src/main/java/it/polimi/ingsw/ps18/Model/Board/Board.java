package it.polimi.ingsw.ps18.model.board;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.ps18.model.board.boardcells.ConcreteTower;
import it.polimi.ingsw.ps18.model.board.boardcells.Tower;
import it.polimi.ingsw.ps18.model.cards.Excommunications;

public class Board {
	private ArrayList<Tower> towers = new ArrayList<>(1);
//	private ArrayList<MarketCell> market = new ArrayList<>();
//	private ArrayList<CouncilCell> council = new ArrayList<>();
//	private ArrayList<ProdCell> production = new ArrayList<>();
//	private ArrayList<HarvCell> harvest = new ArrayList<>();
	private ArrayList<Excommunications> excomm = new ArrayList<>(); 
	
	public Board (){
		this.towers.add(new ConcreteTower());
		this.excomm.add(new Excommunications());
		this.excomm.add(new Excommunications());
		this.excomm.add(new Excommunications());
		
		
	}
	
	public List<Tower> getTowers(){
		return this.towers;
	}
	
	
	

}
