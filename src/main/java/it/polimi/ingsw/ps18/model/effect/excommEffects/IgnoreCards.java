package it.polimi.ingsw.ps18.model.effect.excommEffects;

/**
 * The Class IgnoreCards.
 */
public class IgnoreCards implements ExcommEffects {
	
	/** The name. */
	private String name;

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects#setQuantity(int)
	 */
	@Override
	public void setQuantity(int quantity) {
		return;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return "Ignore the Victory Points Gain from " + name + "Cards";
	}

	/**
	 * Gets the quantity.
	 *
	 * @param quantity the quantity
	 * @return the quantity
	 */
	public int getQuantity(int quantity) {
		return quantity;
	}

}
