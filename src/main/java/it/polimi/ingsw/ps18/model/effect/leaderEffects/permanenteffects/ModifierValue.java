package it.polimi.ingsw.ps18.model.effect.leaderEffects.permanenteffects;

import java.util.List;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.gamelogic.Dice;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.personalboard.FMember;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;

public class ModifierValue implements LCPermEffect {
	private String name = "ModifierValue";
	private String shortDescription;
	private int quantity;
	
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
	
	public void setParam(JSONArray parameters){
		this.shortDescription = (String) parameters.get(0);
		long temp = (long) parameters.get(1);
		this.quantity = (int) temp;
	}
	
	
	@Override
	public String getShortDescription() {
		return this.shortDescription;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
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


	@Override
	public String getName() {
		return name;
	}

	/**
	 * 
	 */
	public void setShortDescription(String shortDescription) {
		this.shortDescription=shortDescription;
		
	}

	/**
	 * 
	 */
	public void setQuantity(int quantity) {
		this.quantity=quantity;
		
	}
	
	
	

}
