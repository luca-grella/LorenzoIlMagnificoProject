package it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects;

/**
 * The Class VariousModifier.
 */
public class VariousModifier implements LCPermEffect {
	
	/** The short description. */
	private String shortDescription;
	
	/**
	 * Sets the param.
	 *
	 * @param shortDescription the new param
	 */
	public void setParam(String shortDescription){
		this.shortDescription = shortDescription;
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.LCPermEffect#getShortDescription()
	 */
	@Override
	public String getShortDescription() {
		return this.shortDescription;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		if("SkipCoinPaymentinTower".equals(shortDescription)){
			builder.append("Skip the tower fee payment even if the tower is already occupied.");
		} else if( "BonusVPVaticanReport".equals(shortDescription)){
			builder.append("Gain 5 VP bonus everytime you support the church");
		} else if("SkipMPCheckGreenCards".equals(shortDescription)){
			builder.append("Ignore the MP limitation when you take a green card.");
		} else if("DoubleBonus".equals(shortDescription)){
			builder.append("Every time you receive a quick bonus from a card, receive it two times.");
		} else if("SkipFullSpaceControl".equals(shortDescription)){
			builder.append("You can place your Family Member even in space that are occupied.");
		} else if("CopyLC".equals(shortDescription)){
			builder.append("Copy the effect of one of the other active cards.");
		}
		return builder.toString();
	}
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.LCPermEffect#getName()
	 */
	@Override
	public String getName(){
		return "VariousModifier";
	}

}
