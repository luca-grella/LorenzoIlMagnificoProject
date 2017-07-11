package it.polimi.ingsw.ps18.controller.controllerstatus;

import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class ReceiveNewGameChoice.
 */
public class ReceiveNewGameChoice implements Status {
	
	/** The color. */
	private int color;
	
	/** The index. */
	private int index;

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controllerstatus.Status#act(it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
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

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controllerstatus.Status#setIndex(int)
	 */
	@Override
	public void setIndex(int i) {
		this.index = i;
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.controller.controllerstatus.Status#setColor(int)
	 */
	@Override
	public void setColor(int i) {
		this.color = i;
	}

}
