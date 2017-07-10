package it.polimi.ingsw.ps18.controller.controllerstatus;

import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ReceiveNewGameChoice implements Status {
	private int color;
	private int index;

	@Override
	public void act(GameLogic game) {
		if(index==1){
			for(PBoard player: game.getPlayers()){
				if(player.getPlayercol()==color){
					game.getPlayerforNewGame().add(player.getPlayer());
				}
			}
		}
	}

	@Override
	public void setIndex(int i) {
		this.index = i;
	}

	@Override
	public void setColor(int i) {
		this.color = i;
	}

}
