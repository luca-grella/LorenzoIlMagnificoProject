package it.polimi.ingsw.ps18.view.pboardviewactions;

import it.polimi.ingsw.ps18.controller.MainController;

// TODO: Auto-generated Javadoc
/**
 * The Interface PBViewAction.
 */
public interface PBViewAction {
	
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

	/**
	 * Sets the index.
	 *
	 * @param number
	 *            the new index
	 */
	public void setIndex(int number);

}
