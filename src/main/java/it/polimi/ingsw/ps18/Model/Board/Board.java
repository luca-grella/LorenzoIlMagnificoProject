package it.polimi.ingsw.ps18.Model.Board;

import java.util.ArrayList;

import it.polimi.ingsw.ps18.Model.Board.BoardCells.CouncilCell;
import it.polimi.ingsw.ps18.Model.Board.BoardCells.HarvCell;
import it.polimi.ingsw.ps18.Model.Board.BoardCells.MarketCell;
import it.polimi.ingsw.ps18.Model.Board.BoardCells.ProdCell;
import it.polimi.ingsw.ps18.Model.Board.BoardCells.Tower;
import it.polimi.ingsw.ps18.Model.Cards.Excommunications;

public class Board {
	private ArrayList<Tower> towers = new ArrayList<Tower>();
	private ArrayList<MarketCell> market = new ArrayList<MarketCell>();
	private ArrayList<CouncilCell> council = new ArrayList<CouncilCell>();
	private ArrayList<ProdCell> production = new ArrayList<ProdCell>();
	private ArrayList<HarvCell> harvest = new ArrayList<HarvCell>();
	private ArrayList<Excommunications> excomm = new ArrayList<Excommunications>();

}
