package it.polimi.ingsw.ps18.model.effect.excommEffects;

public class LoseVPforResources implements ExcommEffects {

	
	private int loseVP;
	private String name = "Lose Victory Point for each resource in your PBoard";
	
	
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
