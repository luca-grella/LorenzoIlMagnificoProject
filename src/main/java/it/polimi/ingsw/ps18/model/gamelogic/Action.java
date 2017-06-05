package it.polimi.ingsw.ps18.model.gameLogic;

import it.polimi.ingsw.ps18.model.personalboard.FMember;

public interface Action {
	
	public void act(GameLogic game);
	
	public void setChosenFam(FMember chosenFam);

}
