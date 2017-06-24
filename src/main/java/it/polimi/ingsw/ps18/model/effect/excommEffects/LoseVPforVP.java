package it.polimi.ingsw.ps18.model.effect.excommEffects;


// TODO: Auto-generated Javadoc
/**
 * The Class LoseVPforVP.
 */
public class LoseVPforVP implements ExcommEffects {
	
	/**
	 * The name.
	 */
	private String name = "Lose Victory Point for same Victory Point";
	
	/**
	 * The has VP.
	 */
	private long hasVP;
	
	/**
	 * The lose VP.
	 */
	private long loseVP;


	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.excommEffects.ExcommEffects#setQuantity(int)
	 */
	@Override
	public void setQuantity(int quantity) {
		return;
	}
	

	/**
	 * Gets the lose VP.
	 *
	 * @return the loseVP
	 */
	public long getLoseVP() {
		return loseVP;
	}

	/**
	 * Sets the lose VP.
	 *
	 * @param loseVP
	 *            the VP to lose
	 */
	public void setLoseVP(int loseVP) {
		this.loseVP = loseVP;
	}

	/**
	 * Gets the boost action value.
	 *
	 * @return the hasVP
	 */
	public long getBoostActionValue() {
		return hasVP;
	}

	/**
	 * Sets the boost action value.
	 *
	 * @param hasVP
	 *            the number of VP every lose VP to set
	 */
	public void setBoostActionValue(int hasVP) {
		this.hasVP = hasVP;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * Sets the V ex.
	 *
	 * @param hasVP
	 *            the has VP
	 * @param loseVP
	 *            the lose VP
	 */
	public void setVEx(long hasVP, long loseVP) {
		this.hasVP=hasVP;
		this.loseVP=loseVP;
		
		
	}
	

	
}