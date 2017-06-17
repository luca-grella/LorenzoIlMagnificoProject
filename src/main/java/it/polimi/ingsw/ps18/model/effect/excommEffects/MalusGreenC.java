package it.polimi.ingsw.ps18.model.effect.excommEffects;

public class MalusGreenC implements ExcommEffects {

	private int gtowerreduction;
	private String name = "Reduces green tower actions value";
	
	
	@Override
	public void setQuantity(int quantity) {

		this.gtowerreduction=quantity;
		
	}
	
	/**
	 * @return the malusQuantity
	 */
	public int getReduction() {
		return gtowerreduction;
	}
	
	public String getName() {
		return name;
	}

}
