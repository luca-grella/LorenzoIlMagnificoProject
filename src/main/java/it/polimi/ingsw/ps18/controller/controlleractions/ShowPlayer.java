package it.polimi.ingsw.ps18.controller.controlleractions;

import java.util.List;

import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.ShowBoard;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ShowPlayer implements ActionChoice {
	private int index;

	@Override
	public void act(GameLogic game) {
		List<PBoard> players = game.getPlayers();
		int i=0;
		while(i<players.size() && (players.get(i)).getPlayercol()!=index){
			i++;
		}
		PBoard chosenPlayer = players.get(i);
		ShowBoard showboard = new ShowBoard(chosenPlayer.getpBoardView());
		showboard.showPlayer(chosenPlayer);

	}

	@Override
	public void setIndex(int i) {
		this.index = i;
	}

}
