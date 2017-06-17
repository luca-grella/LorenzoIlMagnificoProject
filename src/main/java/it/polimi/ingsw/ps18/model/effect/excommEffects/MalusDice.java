package it.polimi.ingsw.ps18.model.effect.excommEffects;

public class MalusDice implements ExcommEffects {


	private int dicereduction;
	private String name = "Reduces dice value";
	
	
	@Override
	public void setQuantity(int quantity) {

		this.dicereduction=quantity;
		
	}
	
	/**
	 * @return the malusQuantity
	 */
	public int getReduction() {
		return dicereduction;
	}
	
	public String getName() {
		return name;
	}

}
