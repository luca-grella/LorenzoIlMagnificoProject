package it.polimi.ingsw.ps18.model.gameLogic;

import java.util.ArrayList;

import it.polimi.ingsw.ps18.model.board.Board;
import it.polimi.ingsw.ps18.model.board.boardcells.Tower;
import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.personalBoard.FMember;
import it.polimi.ingsw.ps18.model.personalBoard.PBoard;

public class FamtoTower implements ActionChoice {
	private int towerchoice;
	private int floorchoice;

	public FamtoTower(int torre, int floor) {
		this.towerchoice = torre;
		this.floorchoice = floor;
	}

	@Override
	public void act(FMember fam, Board board, PBoard player) {
		ArrayList<Tower> towers = (ArrayList<Tower>) board.getTowers();
		Tower tower = towers.get(towerchoice);
		Cards newcard = tower.insertFM(fam, floorchoice);
		player.addCard(newcard);
	}

}
