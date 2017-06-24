package it.polimi.ingsw.ps18.model.personalboard.resources;

// TODO: Auto-generated Javadoc
/**
 * The Class Coins.
 */
class Coins implements Resources{
	
	/**
	 * The quantity.
	 */
	private int quantity;
	
	/**
	 * Instantiates a new coins.
	 *
	 * @param value
	 *            the value
	 */
	protected Coins(int value){
		this.quantity=value;
	}
	
	/**
	 * Instantiates a new coins.
	 *
	 * @param value
	 *            the value
	 */
	public Coins(long value) {
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
