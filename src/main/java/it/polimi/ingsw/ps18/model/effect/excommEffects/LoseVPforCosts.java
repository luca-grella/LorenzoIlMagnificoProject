package it.polimi.ingsw.ps18.model.effect.excommEffects;

// TODO: Auto-generated Javadoc
/**
 * The Class LoseVPforCosts.
 */
public class LoseVPforCosts implements ExcommEffects {

	
	/**
	 * The lose VP.
	 */
	private int loseVP;
	
	/**
	 * The name.
	 */
	private String name = "Lose Victory Point for each wood or rock represented on each yellow card in your PBoard";
	
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects#setQuantity(int)
	 */
	@Override
	public void setQuantity(int quantity) {

		this.loseVP=quantity;
		
	}
	
	/**
	 * Gets the lose VP.
	 *
	 * @return the loseVP
	 */
	public int getLoseVP() {
		return loseVP;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
