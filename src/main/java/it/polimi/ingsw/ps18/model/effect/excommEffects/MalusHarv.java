package it.polimi.ingsw.ps18.model.effect.excommEffects;

// TODO: Auto-generated Javadoc
/**
 * The Class MalusHarv.
 */
public class MalusHarv implements ExcommEffects {


	/**
	 * The harvreduction.
	 */
	private int harvreduction;
	
	/**
	 * The name.
	 */
	private String name = "Reduces harvest actions value";
	
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects#setQuantity(int)
	 */
	@Override
	public void setQuantity(int quantity) {

		this.harvreduction=quantity;
		
	}
	
	/**
	 * Gets the reduction.
	 *
	 * @return the malusQuantity
	 */
	public int getReduction() {
		return harvreduction;
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
