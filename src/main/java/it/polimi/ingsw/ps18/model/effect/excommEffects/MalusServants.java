package it.polimi.ingsw.ps18.model.effect.excommEffects;

public class MalusServants implements ExcommEffects {

	private int malusQuantity;
	
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

}
