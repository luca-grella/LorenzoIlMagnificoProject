package it.polimi.ingsw.ps18.model.effect.prodEffect;

import java.util.Observable;

import org.json.simple.JSONArray;

import it.polimi.ingsw.ps18.model.gamelogic.GameLogic;
import it.polimi.ingsw.ps18.model.messagesandlogs.StatusMessage;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;


/**
 * The Class ConvertinPC.
 */
public class ConvertinPC extends Observable implements Converter {
	
	/**
	 * The name.
	 */
	private String name = "Convert in PC";
	
	/**
	 * The cost.
	 */
	private Stats cost;
	
	/**
	 * The quantity.
	 */
	private int quantity;

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect#activate(it.polimi.ingsw.ps18.model.personalboard.PBoard, it.polimi.ingsw.ps18.model.gamelogic.GameLogic)
	 */
	@Override
	public void activate(PBoard player, GameLogic game) {
		addObserver(player.getpBoardView());
		for(int i=0; i<quantity; i++){
			setChanged();
			notifyObservers(new StatusMessage("PrivilegeChoice"));
		}
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect#setQuantity(int)
	 */
	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Sets the stats.
	 *
	 * @param cost
	 *            the cost
	 * @param quantity
	 *            the quantity
	 */
	public void setStats(JSONArray cost, long quantity){
		this.cost = new Stats(cost);
		this.setQuantity((int) quantity);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Pay:\n" + this.cost.toStringCost()
				+ "to gain " + this.quantity + "Privileges");
		return builder.toString();
	}

	/**
	 * Gets the cost.
	 *
	 * @return the cost
	 */
	public Stats getCost() {
		return cost;
	}

	/**
	 * Sets the cost.
	 *
	 * @param cost
	 *            the cost to set
	 */
	public void setCost(Stats cost) {
		this.cost = cost;
	}

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	

}
