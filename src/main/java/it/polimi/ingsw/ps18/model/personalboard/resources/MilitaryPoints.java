package it.polimi.ingsw.ps18.model.personalboard.resources;

/**
 * The Class MilitaryPoints.
 */
class MilitaryPoints implements Points{
	
	/**
	 * The quantity.
	 */
	private int quantity;
	
	/**
	 * Instantiates a new military points.
	 *
	 * @param value
	 *            the value
	 */
	public MilitaryPoints(int value){
		this.quantity=value;
	}
	
	/**
	 * Instantiates a new military points.
	 *
	 * @param value
	 *            the value
	 */
	public MilitaryPoints(long value) {
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
