package it.polimi.ingsw.ps18.model.effect.excommEffects;



public class MalusIncreaseActionValue implements ExcommEffects {

	private int requiredServant;
	private String name = "Required servant to increase action values";
	
	
	@Override
	public void setQuantity(int quantity) {

		this.requiredServant=quantity;
		
	}
	
	/**
	 * @return the malusQuantity
	 */
	public int getRequiredServant() {
		return requiredServant;
	}
	
	public String getName() {
		return name;
	}
	
}
