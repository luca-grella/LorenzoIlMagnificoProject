package it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class CheckMinimumAllTypeCards.
 */
public class CheckMinimumAllTypeCards implements LCRequirement {
	
	/** The minimum. */
	private int minimum;

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements.LCRequirement#checkRequirement(it.polimi.ingsw.ps18.model.personalboard.PBoard)
	 */
	@Override
	public boolean checkRequirement(PBoard player) {
		int green = 0;
		int blue = 0;
		int yellow = 0;
		int purple = 0;
		for(Cards card: player.getCards()){
			switch((int) card.getColor()){
			case 0:
				green++;
				break;
			case 1:
				blue++;
				break;
			case 2:
				yellow++;
				break;
			case 3:
				purple++;
				break;
			}
		}
		if(green < minimum){
			return false;
		} else if(blue < minimum){
			return false;
		} else if(yellow < minimum){
			return false;
		} else if(purple < minimum){
			return false;
		}
		return true;
	}
	
	/**
	 * Sets the param.
	 *
	 * @param i the new param
	 */
	public void setParam(long i){
		this.minimum = (int) i;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return this.minimum + " of each type of card";
	}

	/**
	 * Gets the param.
	 *
	 * @return the param
	 */
	public int getParam() {
		
		return minimum;
	}

}
