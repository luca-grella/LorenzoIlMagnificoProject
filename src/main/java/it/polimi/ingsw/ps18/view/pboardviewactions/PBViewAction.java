package it.polimi.ingsw.ps18.view.pboardviewactions;

import it.polimi.ingsw.ps18.controller.MainController;

public interface PBViewAction {
	
	public void setObserver(MainController controller);
	
	public void act();

	public void setIndex(int number);

}
