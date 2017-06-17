package it.polimi.ingsw.ps18.model.effect.excommEffects;


public class LoseVPforVP implements ExcommEffects {
	private String name = "Lose Victory Point for same Victory Point";
	private long hasVP;
	private long loseVP;


	@Override
	public void setQuantity(int quantity) {
		return;
	}
	

	/**
	 * @return the loseVP
	 */
	public long getLoseVP() {
		return loseVP;
	}

	/**
	 * @param loseVP the VP to lose
	 */
	public void setLoseVP(int loseVP) {
		this.loseVP = loseVP;
	}

	/**
	 * @return the hasVP
	 */
	public long getBoostActionValue() {
		return hasVP;
	}

	/**
	 * @param hasVP the number of VP every lose VP to set
	 */
	public void setBoostActionValue(int hasVP) {
		this.hasVP = hasVP;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	public void setVEx(long hasVP, long loseVP) {
		this.hasVP=hasVP;
		this.loseVP=loseVP;
		
		
	}
	

	
}