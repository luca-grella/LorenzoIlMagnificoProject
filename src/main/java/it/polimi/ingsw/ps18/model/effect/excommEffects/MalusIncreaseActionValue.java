package it.polimi.ingsw.ps18.model.effect.excommEffects;



// TODO: Auto-generated Javadoc
/**
 * The Class MalusIncreaseActionValue.
 */
public class MalusIncreaseActionValue implements ExcommEffects {

	/**
	 * The required servant.
	 */
	private int requiredServant;
	
	/**
	 * The name.
	 */
	private String name = "Required servant to increase action values";
	
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects#setQuantity(int)
	 */
	@Override
	public void setQuantity(int quantity) {

		this.requiredServant=quantity;
		
	}
	
	/**
	 * Gets the required servant.
	 *
	 * @return the malusQuantity
	 */
	public int getRequiredServant() {
		return requiredServant;
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
