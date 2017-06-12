package it.polimi.ingsw.ps18.model.cards;

import java.util.ArrayList;
import java.util.List;

import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public class YellowC extends Cards {
	private Stats effectCosts = new Stats(0,0,0,0,0,0,0);
	private int productionValue;
	private List<ProductionEffect> prodEffect = new ArrayList<>();
	
	
	public YellowC(String string) {
	}
	
	
	@Override
	public String toString(int count) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean costCheck(Stats playerResources) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
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
	 * @return the value
	 */
	public int getProductionValue() {
		return productionValue;
	}
	/**
	 * @param value the value to set
	 */
	public void setProductionValue(int value) {
		this.productionValue = value;
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



	@Override
	public boolean hasHarvest() {
		return false;
	}



	@Override
	public boolean hasProduction() {
		if(prodEffect.isEmpty()){
			return false;
		}
		return true;
	}



	@Override
	public boolean hasFinal() {
		return false;
	}



	@Override
	public void activateSecondaryEffect(PBoard player, int actionValue) {
	}



	
	
	

}
