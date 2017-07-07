package it.polimi.ingsw.ps18.model.effect.leaderEffects.requirements;

import it.polimi.ingsw.ps18.model.cards.Cards;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class CheckNumberCardType implements LCRequirement {
	private int typecolor;
	private int minimum;
	private String typecolorstring;
	
	
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
	
	@Override
	public String toString(){
		return this.minimum + " " + this.typecolorstring + " cards.";
	}

	/**
	 * @return 
	 * 
	 */
	public int getDetails() {
		return typecolor;
		
	}
	

	/**
	 * @return 
	 * 
	 */
	public int getMinimum() {
		return minimum;
		
	}

}
