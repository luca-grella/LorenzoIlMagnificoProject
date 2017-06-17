package it.polimi.ingsw.ps18.model.effect.excommEffects;

public class MalusServants implements ExcommEffects {

	private int malusQuantity;
	private String name = "Lose Servants every time you gain Servants";
	
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
