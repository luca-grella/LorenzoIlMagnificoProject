package it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class CheckMinimumAllTypeCards implements LCRequirement {
	private int minimum;

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
	
	public void setParam(int minimum){
		this.minimum = minimum;
	}
	
	@Override
	public String toString(){
		return "Da Scrivere";
	}

	/**
	 * @return
	 */
	public int getParam() {
		
		return minimum;
	}

}
