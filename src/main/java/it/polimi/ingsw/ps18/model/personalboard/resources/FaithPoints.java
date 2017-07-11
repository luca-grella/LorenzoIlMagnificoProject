package it.polimi.ingsw.ps18.model.personalboard.resources;


/**
 * The Class FaithPoints.
 */
class FaithPoints implements Points{
    
    /**
	 * The quantity.
	 */
    private int quantity;
	
	/**
	 * Instantiates a new faith points.
	 *
	 * @param value
	 *            the value
	 */
	public FaithPoints(int value){
		this.quantity=value;
	}
	
	/**
	 * Instantiates a new faith points.
	 *
	 * @param value
	 *            the value
	 */
	public FaithPoints(long value) {
		this.quantity = (int) value;
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.personalboard.resources.Points#getQuantity()
	 */
	public int getQuantity(){
		return this.quantity;
	}
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.personalboard.resources.Points#addQuantity(int)
	 */
	public void addQuantity(int value){
		this.quantity= this.quantity+value;
	}

}
