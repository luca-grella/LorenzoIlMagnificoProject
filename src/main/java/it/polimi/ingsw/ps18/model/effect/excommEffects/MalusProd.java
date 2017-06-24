package it.polimi.ingsw.ps18.model.effect.excommEffects;

// TODO: Auto-generated Javadoc
/**
 * The Class MalusProd.
 */
public class MalusProd implements ExcommEffects {

	/**
	 * The prodreduction.
	 */
	private int prodreduction;
	
	/**
	 * The name.
	 */
	private String name = "Reduces production actions value";
	
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects#setQuantity(int)
	 */
	@Override
	public void setQuantity(int quantity) {

		this.prodreduction=quantity;
		
	}
	
	/**
	 * Gets the reduction.
	 *
	 * @return the malusQuantity
	 */
	public int getReduction() {
		return prodreduction;
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
