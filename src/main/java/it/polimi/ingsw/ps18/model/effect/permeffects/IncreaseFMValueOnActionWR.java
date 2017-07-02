package it.polimi.ingsw.ps18.model.effect.permeffects;

import java.util.Observable;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.effect.generalEffects.WoodorRockEffects;
import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public class IncreaseFMValueOnActionWR extends Observable implements Permanenteffect, WoodorRockEffects {
	
	/**
	 * The name.
	 */
	private String name;
	
	/**
	 * The quantity.
	 */
	private int quantity;
	
	private Stats discounts;
	
	private Stats chosenDiscount;
	
	@Override
	public void activate(PBoard player, GameLogic game) {
		addObserver(player.getpBoardView());
		if(player.getResources().getWood() < quantity){
			chosenDiscount = new Stats(0,quantity,0,0,0,0,0);
			return;
		} else if(player.getResources().getRock() < quantity){
			chosenDiscount = new Stats(quantity,0,0,0,0,0,0);
		} else {
			game.setOngoingWREffect((WoodorRockEffects) this);
			setChanged();
			notifyObservers(new StatusMessage("WoodorRockChoice"));
		}
	}
	
	@Override
	public void continueEffect(int index, PBoard player, GameLogic game) {
		if(index==1){
			chosenDiscount = new Stats(discounts.getWood(),0,0,0,0,0,0);
		} else {
			chosenDiscount = new Stats(0,discounts.getRock(),0,0,0,0,0);
		}
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	//TODO: da modificare
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Incrase Permanently the Action Value by " + this.quantity + "\n"
				+ "\t   when you take a card from the " + this.name + " Tower");
		if(! this.discounts.isEmpty()){
			builder.append("\n\t with a discount of:\n" + discounts.toStringCost());
		}
		return builder.toString();
	}
	
	public void setParam(String name, long quantity, JSONArray discounts){
		this.name = name;
		this.quantity = (int) quantity;
		this.discounts = new Stats(discounts);
	}

	@Override
	public int getQuantity() {
		return quantity;
	}

	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String getName() {
		return this.name + "WR";
	}

	/**
	 * @return the discounts
	 */
	public Stats getDiscounts() {
		return discounts;
	}

	/**
	 * @return the chosenDiscount
	 */
	public Stats getChosenDiscount() {
		return chosenDiscount;
	}
	
	
	
}
