package it.polimi.ingsw.ps18.model.personalboard.resources;

// TODO: Auto-generated Javadoc
/**
 * The Class VictoryPoints.
 */
public class VictoryPoints implements Points{
	
	/**
	 * The quantity.
	 */
	private int quantity;
	
	/**
	 * Instantiates a new victory points.
	 *
	 * @param value
	 *            the value
	 */
	public VictoryPoints(int value){
		this.quantity=value;
	}
	
	/**
	 * Instantiates a new victory points.
	 *
	 * @param value
	 *            the value
	 */
	public VictoryPoints(long value) {
		this.quantity = (int) value;
	}

	/**
	 * @see it.polimi.ingsw.ps18.model.personalboard.resources.Points#getQuantity()
	 */
	public int getQuantity(){
		return this.quantity;
	}
	
	/**
	 * @see it.polimi.ingsw.ps18.model.personalboard.resources.Points#addQuantity(int)
	 */
	public void addQuantity(int value){
		this.quantity= this.quantity+value;
	}

}
