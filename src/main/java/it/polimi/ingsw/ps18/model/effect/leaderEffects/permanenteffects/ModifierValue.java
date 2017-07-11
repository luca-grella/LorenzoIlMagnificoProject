package it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects;

import java.util.List;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

/**
 * The Class ModifierValue.
 */
public class ModifierValue implements LCPermEffect {
	
	/** The name. */
	private String name = "ModifierValue";
	
	/** The short description. */
	private String shortDescription;
	
	/** The quantity. */
	private int quantity;
	
	/**
	 * Refresh F member.
	 *
	 * @param game the game
	 */
	public void refreshFMember(GameLogic game){
		PBoard player = game.getTurnplayer();
		List<Dice> dice = game.getDices();
		List<FMember> fams = player.getFams();
		int i;
		for(i=0; i<dice.size(); i++){
			if(fams.get(i)!=null){
				fams.set(i, new FMember(dice.get(i), player.getPlayercol(), player));
			}
		} 
		fams.set(i, new FMember(0, player.getPlayercol(), player));
	}
	
	/**
	 * Sets the param.
	 *
	 * @param parameters the new param
	 */
	public void setParam(JSONArray parameters){
		this.shortDescription = (String) parameters.get(0);
		long temp = (long) parameters.get(1);
		this.quantity = (int) temp;
	}
	
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.LCPermEffect#getShortDescription()
	 */
	@Override
	public String getShortDescription() {
		return this.shortDescription;
	}

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		if("BonusDiceValue".equals(shortDescription)){
			builder.append("Add " + this.quantity + " to the Action Value of each of your colored Family Member.");
		} else if("BonusNeutralFam".equals(shortDescription)){
			builder.append("Add " + this.quantity + " to the Action Value of your Neutral Family Member.");
		} else if("BaseFamValueModifier".equals(shortDescription)){
			builder.append("Your colored Family Member have a base value of " + this.quantity + ".");
		}
		return builder.toString();
	}


	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects.LCPermEffect#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Sets the short description.
	 *
	 * @param shortDescription the new short description
	 */
	public void setShortDescription(String shortDescription) {
		this.shortDescription=shortDescription;
		
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity=quantity;
		
	}
	
	
	

}
