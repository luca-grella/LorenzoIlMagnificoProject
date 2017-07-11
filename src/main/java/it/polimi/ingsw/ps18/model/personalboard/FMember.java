package it.polimi.ingsw.ps18.model.personalboard;

import it.polimi.ingsw.ps18.model.cards.Excommunications;
import it.polimi.ingsw.ps18.model.cards.LeaderCards;
import it.polimi.ingsw.ps18.model.effect.excommEffects.MalusValue;
import it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.*;
import it.polimi.ingsw.ps18.model.gamelogic.Dice;

/**
 * The Class FMember.
 */
public class FMember {
	
	/**
	 * The playercol.
	 */
	private int playercol;
	
	/**
	 * The color.
	 */
	private int color;
	
	/**
	 * The value.
	 */
	private int value;
	
	/**
	 * Instantiates a new f member.
	 *
	 * @param dice
	 *            the dice
	 * @param playercol
	 *            the playercol
	 */
	public FMember(Dice dice, int playercol){
		this.value = dice.getValue();
		this.color = dice.getColor();
		this.playercol = playercol;
	}
	
	/**
	 * Instantiates a new f member.
	 *
	 * @param value the value
	 * @param playercol the playercol
	 */
	public FMember(int value, int playercol){
		this.value = value;
		this.color = -1;
		this.playercol = playercol;
	}
	
	/**
	 * Instantiates a new f member.
	 *
	 * @param dice the dice
	 * @param playercol the playercol
	 * @param player the player
	 */
	public FMember(Dice dice, int playercol, PBoard player){
		int malusValue = 0;
		for(int i=0; i<player.getExcommCards().size(); i++){
			Excommunications card = player.getExcommCards().get(i);
			for(int j=0; j<card.getEffects().size(); j++){
				if("MalusValue".equals(card.getEffects().get(j).getName())){
					if("Dice".equals(((MalusValue) card.getEffects().get(j)).getPlace())){
						malusValue += ((MalusValue) card.getEffects().get(j)).getMalusValue();
					}
				}
			}
		}
		int bonusValue = 0;
		boolean isThereBaseValue = false;
		int baseValue = 0;
		for(LeaderCards card: player.getLeadercards()){
			if(card.isActive()){
				for(LCPermEffect effect: card.getPermEffects()){
					if("BonusDiceValue".equals(effect.getShortDescription())){
						bonusValue += ((ModifierValue) effect).getQuantity();
					}
					if("BaseFamValueModifier".equals(effect.getShortDescription())){
						baseValue = ((ModifierValue) effect).getQuantity();
						isThereBaseValue = true;
					}
				}
			}
		}
		if(isThereBaseValue){
			if(baseValue + bonusValue >= malusValue){
				this.value = baseValue + bonusValue - malusValue;
			} else {
				this.value = 0;
			}
		} else {
			if(dice.getValue() + bonusValue >= malusValue){
				this.value = dice.getValue() + bonusValue - malusValue;
			} else {
				this.value = 0;
			}
		}
		this.color = dice.getColor();
		this.playercol = playercol;
	}
	
	/**
	 * Instantiates a new f member.
	 *
	 * @param value            the value
	 * @param playercol            the playercol
	 * @param player the player
	 */
	public FMember(int value, int playercol, PBoard player){
		int bonusValue = 0;
		for(LeaderCards card: player.getLeadercards()){
			if(card.isActive()){
				for(LCPermEffect effect: card.getPermEffects()){
					if("BonusNeutralFam".equals(effect.getShortDescription())){
						bonusValue += ((ModifierValue) effect).getQuantity();
					}
				}
			}
		}
		this.value = value + bonusValue;
		this.color = -1;
		this.playercol = playercol;
	}
	
	/**
	 * Fmember farlocco per prendere la carta da effetto di un'altra carta.
	 *
	 * @param value
	 *            the value
	 */
	public FMember(int value){
		this.value = value;
		this.color = -2;
		this.playercol = -2;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("\n   Owner's Color: " + this.playercol);
		builder.append("\n   Member's color: " + this.color);
		builder.append("\n   Member's value: " + this.value);
		return builder.toString();
	}

	/**
	 * Gets the playercol.
	 *
	 * @return the playercol
	 */
	public int getPlayercol() {
		return playercol;
	}



	/**
	 * Sets the playercol.
	 *
	 * @param playercol
	 *            the playercol to set
	 */
	public void setPlayercol(int playercol) {
		this.playercol = playercol;
	}



	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value) {
		if(value>=0){
			this.value = value;
			return;
		}
		value = 0;
	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public int getColor() {
		return color;
	}

	/**
	 * Sets the color.
	 *
	 * @param color
	 *            the color to set
	 */
	public void setColor(int color) {
		this.color = color;
	}
	
	
	
	

}
