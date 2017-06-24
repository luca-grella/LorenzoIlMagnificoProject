package it.polimi.ingsw.ps18.model.effect.excommEffects;

// TODO: Auto-generated Javadoc
/**
 * The Class MalusPurpleC.
 */
public class MalusPurpleC implements ExcommEffects {

	/**
	 * The ptowerreduction.
	 */
	private int ptowerreduction;
	
	/**
	 * The name.
	 */
	private String name = "Reduces purple tower actions value";
	
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects#setQuantity(int)
	 */
	@Override
	public void setQuantity(int quantity) {

		this.ptowerreduction=quantity;
		
	}
	
	/**
	 * Gets the reduction.
	 *
	 * @return the malusQuantity
	 */
	public int getReduction() {
		return ptowerreduction;
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
