package it.polimi.ingsw.ps18.model.effect.excommEffects;

public class LoseVPforCosts implements ExcommEffects {

	private int loseVP;
	private String name = "Lose Victory Point for each wood or rock represented on each yellow card in your PBoard";
	
	@Override
	public void setQuantity(int quantity) {

		this.loseVP=quantity;
		
	}
	
	/**
	 * @return the loseVP
	 */
	public int getLoseVP() {
		return loseVP;
	}
	
	public String getName() {
		return name;
	}

}