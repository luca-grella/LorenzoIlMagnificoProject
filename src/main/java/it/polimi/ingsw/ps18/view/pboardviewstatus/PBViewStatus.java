package it.polimi.ingsw.ps18.view.pboardviewstatus;

import it.polimi.ingsw.ps18.controller.MainController;

// TODO: Auto-generated Javadoc
/**
 * The Interface PBViewStatus.
 */
public interface PBViewStatus {
	
	/**
	 * Sets the observer.
	 *
	 * @param controller
	 *            the new observer
	 */
	public void setObserver(MainController controller);
	
	/**
	 * Act.
	 */
	public void act();

}
