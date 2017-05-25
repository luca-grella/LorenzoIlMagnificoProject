package it.polimi.ingsw.ps18.Model.GameLogic;

import java.util.ArrayList;

import it.polimi.ingsw.ps18.Model.Board.Board;
import it.polimi.ingsw.ps18.Model.Board.BoardCells.Tower;
import it.polimi.ingsw.ps18.Model.Cards.Cards;
import it.polimi.ingsw.ps18.Model.PBoard.FMember;
import it.polimi.ingsw.ps18.Model.PBoard.PBoard;

public class FamtoTower implements ActionChoice {
	private int towerchoice;
	private int floorchoice;

	public FamtoTower(int torre, int floor) {
		this.towerchoice = torre;
		this.floorchoice = floor;
	}

	@Override
	public void act(FMember fam, Board board, PBoard player) {
		ArrayList<Tower> towers = board.getTowers();
		Tower tower = towers.get(towerchoice);
		Cards newcard = tower.insertFM(fam, floorchoice);
		player.addCard(newcard);
	}

}
