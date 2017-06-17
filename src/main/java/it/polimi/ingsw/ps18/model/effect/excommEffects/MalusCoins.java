package it.polimi.ingsw.ps18.model.effect.excommEffects;



public class MalusCoins implements ExcommEffects {


	private int malusQuantity;
	private String name = "Lose Coins every time you gain Coins";
	
	
	
	@Override
	public void setQuantity(int quantity) {
	
		this.malusQuantity=quantity;
	
}

	/**
	 * @return the malusQuantity
	 */
	public int getMalusQuantity() {
		return malusQuantity;
	}


	public String getName() {
		return name;
	}
	
	
}
