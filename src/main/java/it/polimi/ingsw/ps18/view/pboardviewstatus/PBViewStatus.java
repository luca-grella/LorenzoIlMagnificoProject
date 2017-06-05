package it.polimi.ingsw.ps18.view.pboardviewstatus;

import it.polimi.ingsw.ps18.controller.MainController;

public interface PBViewStatus {
	
	public void setObserver(MainController controller);
	
	public void act();

}
