package it.polimi.ingsw.ps18.model.effect.excommEffects;

public class MalusPurpleC implements ExcommEffects {

	private int ptowerreduction;
	private String name = "Reduces purple tower actions value";
	
	
	@Override
	public void setQuantity(int quantity) {

		this.ptowerreduction=quantity;
		
	}
	
	/**
	 * @return the malusQuantity
	 */
	public int getReduction() {
		return ptowerreduction;
	}
	
	public String getName() {
		return name;
	}

}
