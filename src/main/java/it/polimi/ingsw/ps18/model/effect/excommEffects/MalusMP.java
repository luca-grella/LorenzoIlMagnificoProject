package it.polimi.ingsw.ps18.model.effect.excommEffects;

public class MalusMP implements ExcommEffects {

	
	private int malusQuantity;
	private String name = "Lose Military Point every time you gain Military Point";
	
	
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
