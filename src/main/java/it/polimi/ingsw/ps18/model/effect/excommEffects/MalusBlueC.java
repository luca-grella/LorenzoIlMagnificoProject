package it.polimi.ingsw.ps18.model.effect.excommEffects;

public class MalusBlueC implements ExcommEffects {

	private int btowerreduction;
	private String name = "Reduces blue tower actions value";
	
	
	@Override
	public void setQuantity(int quantity) {

		this.btowerreduction=quantity;
		
	}
	
	/**
	 * @return the malusQuantity
	 */
	public int getReduction() {
		return btowerreduction;
	}
	
	public String getName() {
		return name;
	}

}
