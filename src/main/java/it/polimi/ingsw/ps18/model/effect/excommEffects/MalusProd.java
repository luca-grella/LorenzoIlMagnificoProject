package it.polimi.ingsw.ps18.model.effect.excommEffects;

public class MalusProd implements ExcommEffects {

	private int prodreduction;
	private String name = "Reduces production actions value";
	
	
	@Override
	public void setQuantity(int quantity) {

		this.prodreduction=quantity;
		
	}
	
	/**
	 * @return the malusQuantity
	 */
	public int getReduction() {
		return prodreduction;
	}
	
	public String getName() {
		return name;
	}

}
