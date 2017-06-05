package it.polimi.ingsw.ps18.model.gamelogic;

import it.polimi.ingsw.ps18.model.personalBoard.FMember;

public interface Action {
	
	public void act(GameLogic game);
	
	public void setChosenFam(FMember chosenFam);

}
