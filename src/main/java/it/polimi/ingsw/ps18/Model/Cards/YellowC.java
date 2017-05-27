package it.polimi.ingsw.ps18.model.cards;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.personalBoard.resources.Stats;

public class YellowC extends Cards {
	private Stats effectCosts = new Stats(0,0,0,0,0,0,0);
	private int color = 2;
	private int value;
	private List<ProductionEffect> prodEffect = new ArrayList<>();
	/**
	 * @return the effectCosts
	 */
	public Stats getEffectCosts() {
		return effectCosts;
	}
	/**
	 * @param effectCosts the effectCosts to set
	 */
	public void setEffectCosts(Stats effectCosts) {
		this.effectCosts = effectCosts;
	}
	/**
	 * @return the color
	 */
	public int getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(int color) {
		this.color = color;
	}
	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
	/**
	 * @return the prodEffect
	 */
	public List<ProductionEffect> getProdEffect() {
		return prodEffect;
	}
	/**
	 * @param prodEffect the prodEffect to set
	 */
	public void setProdEffect(List<ProductionEffect> prodEffect) {
		this.prodEffect = prodEffect;
	}
	
	

}
