package it.polimi.ingsw.ps18.model.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HashMapHE;
import it.polimi.ingsw.ps18.model.effect.quickEffect.HashMapQE;

public class GreenC extends Cards {
	private int color = 0;
	private int harvValue;
	private List<HarvestEffect> harveffect = new ArrayList<>();
	Scanner input = new Scanner(System.in);
	
	public GreenC(){
		System.out.println("Immetti codice primo effetto");
		String a = input.nextLine();
//		System.out.println("Immetti il moltiplicatore del primo effetto");
//		int b = input.nextInt();
//		this.add(HashMapQE.geteffect(a), b);
		this.effects.add(HashMapQE.geteffect(a));
		System.out.println("Immetti codice secondo effetto");
	    a = input.nextLine();
		this.harveffect.add(HashMapHE.geteffect(a));
	}
	
//	private boolean add(QuickEffect e, int quantity){
//	boolean ris = this.effects.add(e);
//	if(ris){
//		QuickEffect effect = this.effects.get(this.effects.lastIndexOf(e));
//		effect.setQuantity(quantity);
//		return true;
//	}
//	return false;		
//}

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
	 * @return the harvValue
	 */
	public int getHarvValue() {
		return harvValue;
	}

	/**
	 * @param harvValue the harvValue to set
	 */
	public void setHarvValue(int harvValue) {
		this.harvValue = harvValue;
	}

	/**
	 * @return the harveffect
	 */
	public List<HarvestEffect> getHarveffect() {
		return harveffect;
	}

	/**
	 * @param harveffect the harveffect to set
	 */
	public void setHarveffect(List<HarvestEffect> harveffect) {
		this.harveffect = harveffect;
	}
	

	
	

}
