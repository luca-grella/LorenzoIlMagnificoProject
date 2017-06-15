package it.polimi.ingsw.ps18.model.effect.prodEffect;

import java.util.Observable;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.messages.StatusMessage;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public class ConvertinPC extends Observable implements Converter {
	private String name = "Convert in PC";
	private Stats cost;
	private int quantity;

	@Override
	public void activate(PBoard player) {
		addObserver(player.getpBoardView());
		for(int i=0; i<quantity; i++){
			setChanged();
			notifyObservers(new StatusMessage("PrivilegeChoice"));
		}
	}

	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setStats(JSONArray cost, long quantity){
		this.cost = new Stats(cost);
		this.setQuantity((int) quantity);
	}

	/**
	 * @return the cost
	 */
	public Stats getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(Stats cost) {
		this.cost = cost;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	

}
