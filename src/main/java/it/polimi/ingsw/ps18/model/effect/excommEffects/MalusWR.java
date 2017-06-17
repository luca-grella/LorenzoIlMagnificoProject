package it.polimi.ingsw.ps18.model.effect.excommEffects;

public class MalusWR implements ExcommEffects {


	private int malusQuantity;
	private String name = "Lose Woods or Rocks every time you gain Woods or Rocks";
	
	
	
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
