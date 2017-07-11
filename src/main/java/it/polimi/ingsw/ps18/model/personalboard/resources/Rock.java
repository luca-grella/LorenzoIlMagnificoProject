package it.polimi.ingsw.ps18.model.personalboard.resources;


/**
 * The Class Rock.
 */
class Rock implements Resources {
	
	/**
	 * The quantity.
	 */
	private int quantity;
	
	/**
	 * Instantiates a new rock.
	 *
	 * @param value
	 *            the value
	 */
	public Rock(int value){
		this.quantity=value;
	}
	
	/**
	 * Instantiates a new rock.
	 *
	 * @param value
	 *            the value
	 */
	public Rock(long value) {
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
