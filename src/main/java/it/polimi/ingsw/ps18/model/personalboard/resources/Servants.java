package it.polimi.ingsw.ps18.model.personalboard.resources;

/**
 * The Class Servants.
 */
class Servants implements Resources{
	
	/**
	 * The quantity.
	 */
	private int quantity;
	
	/**
	 * Instantiates a new servants.
	 *
	 * @param value
	 *            the value
	 */
	protected Servants(int value){
		this.quantity=value;
	}
	
	/**
	 * Instantiates a new servants.
	 *
	 * @param value
	 *            the value
	 */
	public Servants(long value) {
		this.quantity = (int) value;
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.personalboard.resources.Resources#getQuantity()
	 */
	public int getQuantity(){
		return this.quantity;
	}
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.personalboard.resources.Resources#addQuantity(int)
	 */
	public void addQuantity(int value){
		this.quantity= this.quantity+value;
	}

}
