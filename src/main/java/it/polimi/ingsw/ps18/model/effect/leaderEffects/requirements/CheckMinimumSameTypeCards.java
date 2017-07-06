package it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class CheckMinimumSameTypeCards implements LCRequirement {
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
		if(green >= minimum){
			return true;
		} else if(blue >= minimum){
			return true;
		} else if(yellow >= minimum){
			return true;
		} else if(purple >= minimum){
			return true;
		}
		return false;
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
