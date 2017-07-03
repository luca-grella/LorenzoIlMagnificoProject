package it.polimi.ingsw.ps18.controller.controlleractions;

import java.util.List;

import it.polimi.ingsw.ps18.model.gamelogic.Action;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.gamelogic.ShowBoard;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class ShowPlayer.
 */
public class ShowPlayer implements ActionChoice {
	
	/**
	 * The index.
	 */
	private int index;

	/**
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void act(GameLogic game) {
		
		List<PBoard> players = game.getPlayers();
		int i=0;
		while(i<players.size() && (players.get(i)).getPlayercol()!=index){
			i++;
		}
		if(i>=0 && i<players.size()){
			PBoard chosenPlayer = players.get(i);
			ShowBoard showboard = new ShowBoard(chosenPlayer.getpBoardView());
			showboard.showPlayer(chosenPlayer);
		}
	}

	/**
	 * @see it.polimi.ingsw.ps18.controller.controlleractions.ActionChoice#setIndex(int)
	 */
	@Override
	public void setIndex(int i) {
		this.index = i;
	}

}
