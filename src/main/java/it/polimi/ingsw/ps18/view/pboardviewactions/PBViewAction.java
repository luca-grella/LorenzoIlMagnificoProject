package it.polimi.ingsw.ps18.view.pboardviewactions;

import it.polimi.ingsw.ps18.rmi.ClientInterface;

/**
 * The Interface PBViewAction.
 */
public interface PBViewAction {
	
	/**
	 * Act.
	 */
	public void act(ClientInterface playerClient);

	/**
	 * Sets the index.
	 *
	 * @param number
	 *            the new index
	 */
	public void setIndex(int number);

}
