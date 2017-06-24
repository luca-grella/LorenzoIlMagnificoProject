package it.polimi.ingsw.ps18.model.effect.excommEffects;

// TODO: Auto-generated Javadoc
/**
 * The Class MalusGreenC.
 */
public class MalusGreenC implements ExcommEffects {

	/**
	 * The gtowerreduction.
	 */
	private int gtowerreduction;
	
	/**
	 * The name.
	 */
	private String name = "Reduces green tower actions value";
	
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects#setQuantity(int)
	 */
	@Override
	public void setQuantity(int quantity) {

		this.gtowerreduction=quantity;
		
	}
	
	/**
	 * Gets the reduction.
	 *
	 * @return the malusQuantity
	 */
	public int getReduction() {
		return gtowerreduction;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
