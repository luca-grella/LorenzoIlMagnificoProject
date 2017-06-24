package it.polimi.ingsw.ps18.model.effect.excommEffects;

// TODO: Auto-generated Javadoc
/**
 * The Class MalusYellowC.
 */
public class MalusYellowC implements ExcommEffects {

	/**
	 * The ytowerreduction.
	 */
	private int ytowerreduction;
	
	/**
	 * The name.
	 */
	private String name = "Reduces yellow tower actions value";
	
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects#setQuantity(int)
	 */
	@Override
	public void setQuantity(int quantity) {

		this.ytowerreduction=quantity;
		
	}
	
	/**
	 * Gets the reduction.
	 *
	 * @return the malusQuantity
	 */
	public int getReduction() {
		return ytowerreduction;
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
