package it.polimi.ingsw.ps18.model.effect.excommEffects;

public class MalusYellowC implements ExcommEffects {

	private int ytowerreduction;
	private String name = "Reduces yellow tower actions value";
	
	
	@Override
	public void setQuantity(int quantity) {

		this.ytowerreduction=quantity;
		
	}
	
	/**
	 * @return the malusQuantity
	 */
	public int getReduction() {
		return ytowerreduction;
	}
	
	public String getName() {
		return name;
	}

}
