package it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class CheckNumberCardType.
 */
public class CheckNumberCardType implements LCRequirement {
	
	/** The typecolor. */
	private int typecolor;
	
	/** The minimum. */
	private int minimum;
	
	/** The typecolorstring. */
	private String typecolorstring;
	
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements.LCRequirement#checkRequirement(it.polimi.ingsw.ps18.model.personalboard.PBoard)
	 */
	@Override
	public boolean checkRequirement(PBoard player){
		int count = 0;
		for(Cards card: player.getCards()){
			if(card.getColor() == typecolor){
				count++;
			}
		}
		if(count>=minimum){
			return true;
		}
		return false;
	}
	
	/**
	 * Sets the param.
	 *
	 * @param details the details
	 * @param minimum the minimum
	 */
	public void setParam(String details, long minimum){
		this.minimum = (int) minimum;
		this.typecolorstring = details;
		if("Green".equals(details)){
			this.typecolor = 0;
		} else if("Blue".equals(details)){
			this.typecolor = 1;
		} else if("Yellow".equals(details)){
			this.typecolor = 2;
		} else if("Purple".equals(details)){
			this.typecolor = 3;
		} else {
			this.typecolor = -3;
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return this.minimum + " " + this.typecolorstring + " cards.";
	}

	/**
	 * Gets the details.
	 *
	 * @return the details
	 */
	public int getDetails() {
		return typecolor;
		
	}
	

	/**
	 * Gets the minimum.
	 *
	 * @return the minimum
	 */
	public int getMinimum() {
		return minimum;
		
	}

	/**
	 * Gets the type color.
	 *
	 * @return the type color
	 */
	public int getTypeColor() {
		return typecolor;
		
	}

}
