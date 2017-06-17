package it.polimi.ingsw.ps18.model.effect.excommEffects;

public class MalusHarv implements ExcommEffects {


	private int harvreduction;
	private String name = "Reduces harvest actions value";
	
	
	@Override
	public void setQuantity(int quantity) {

		this.harvreduction=quantity;
		
	}
	
	/**
	 * @return the malusQuantity
	 */
	public int getReduction() {
		return harvreduction;
	}
	
	public String getName() {
		return name;
	}

}
