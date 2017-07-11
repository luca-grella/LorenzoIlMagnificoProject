package it.polimi.ingsw.ps18.model.cards;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import it.polimi.ingsw.ps18.model.effect.generalEffects.AddVPforMP;
import it.polimi.ingsw.ps18.model.effect.permeffects.*;
import it.polimi.ingsw.ps18.model.effect.quickEffect.HashMapQE;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.effect.generalEffects.*;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * The Class BlueC.
 */
public class BlueC extends Cards {
	
	/**
	 * The permeffect.
	 */
	private List<Permanenteffect> permeffect = new ArrayList<>();

	/**
	 * Instantiates a new blue C.
	 *
	 * @param a the a
	 */
	public BlueC(JSONObject a) {
		HashMapQE mapQE = new HashMapQE(); 

		this.setName((String) a.get("name"));
		this.setID((long) a.get("number"));
		this.setColor((long) a.get("color"));
		this.setPeriod((long) a.get("period"));
		JSONArray cost = (JSONArray) a.get("CardCost");
		this.setCardCost(new Stats(cost));
		JSONArray qeffects = (JSONArray) a.get("QuickEffects");
		JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
		addQEffects(qeffects,qeffectvalues,mapQE);
		JSONArray peffects = (JSONArray) a.get("PermanentEffects");
		JSONArray peffectvalues = (JSONArray) a.get("PermanentEffectsValues");
		addPEffects(peffects,peffectvalues);
	}
	
	/**
	 * Adds the Q effects.
	 *
	 * @param qeffects
	 *            the qeffects
	 * @param qeffectvalues
	 *            the qeffectvalues
	 * @param map
	 *            the map
	 */
	private void addQEffects(JSONArray qeffects, JSONArray qeffectvalues, HashMapQE map) {
	    QuickEffect effect;
		for(int count=0; count<qeffects.size(); count++){
        	if(qeffects.get(count)!=null){
        		if(qeffectvalues.get(count)!=null){
        			if("TakeOneCard".equals((String) qeffects.get(count))){
        				effect = map.geteffect((String) qeffects.get(count));
						JSONArray statseffect = (JSONArray) qeffectvalues.get(count);
						((TakeOneCard) effect).setParameters((long) statseffect.get(1), (String) statseffect.get(0), (JSONArray) statseffect.get(2));
						this.effects.add(effect);
        			} else if("AddPVforMP".equals((String) qeffects.get(count))){
						effect = map.geteffect((String) qeffects.get(count));
						JSONArray statseffect = (JSONArray) qeffectvalues.get(count);
						((AddVPforMP) effect).setQuantity((JSONArray) statseffect.get(0));
						this.effects.add(effect);
					} else {
						this.add(map.geteffect((String) qeffects.get(count)), (long) qeffectvalues.get(count));
					}
        		} else {
        			this.effects.add(map.geteffect((String) qeffects.get(count)));
        		}
        	}
        }	
	}
	
	/**
	 * Adds the.
	 *
	 * @param e
	 *            the e
	 * @param quantity
	 *            the quantity
	 * @return true, if successful
	 */
	private boolean add(QuickEffect e, long quantity){
		QuickEffect a = e;
		a.setQuantity((int) quantity);
	    return (this.getEffects()).add(a);	
    }
	
	/**
	 * Adds the P effects.
	 *
	 * @param peffects
	 *            the peffects
	 * @param peffectvalues
	 *            the peffectvalues
	 */
	private void addPEffects(JSONArray peffects, JSONArray peffectvalues){
		for(int count=0; count<peffects.size(); count++){
			HashMapPermE map = new HashMapPermE();
			if(peffects.get(count)!=null){
				if("IncreaseFMvalueOnAction".equals((String) peffects.get(count))){
					Permanenteffect effect = map.getEffect((String) peffects.get(count));
					JSONArray effectParam = (JSONArray) peffectvalues.get(count);
					((IncreaseFMValueOnAction) effect).setParam((String) effectParam.get(0), (long) effectParam.get(1), (JSONArray) effectParam.get(2));
					this.permeffect.add(effect);
				} else if("IncreaseFMvalueOnActionWR".equals((String) peffects.get(count))){
					Permanenteffect effect = map.getEffect((String) peffects.get(count));
					JSONArray effectParam = (JSONArray) peffectvalues.get(count);
					((IncreaseFMValueOnActionWR) effect).setParam((String) effectParam.get(0), (long) effectParam.get(1), (JSONArray) effectParam.get(2));
					this.permeffect.add(effect);
				} else {
					if(peffectvalues.get(count)!=null){
						this.add(map.getEffect((String) peffects.get(count)), (long) peffectvalues.get(count));
	    		    } else {
	    		    	this.getPermeffect().add(map.getEffect((String) peffects.get(count)));
	    		    }
				}
			}
		}
	}
	
	/**
	 * Adds the.
	 *
	 * @param e
	 *            the e
	 * @param quantity
	 *            the quantity
	 * @return true, if successful
	 */
	private boolean add(Permanenteffect e, long quantity){
		Permanenteffect a = e;
		a.setQuantity((int) quantity);
	    return (this.getPermeffect()).add(a);	
    }

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.cards.Cards#hasHarvest()
	 */
	@Override
	public boolean hasHarvest() {
		return false;
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.cards.Cards#hasProduction()
	 */
	@Override
	public boolean hasProduction() {
		return false;
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.cards.Cards#hasFinal()
	 */
	@Override
	public boolean hasFinal() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.cards.Cards#hasPermanent()
	 */
	@Override
	public boolean hasPermanent() {
		if(this.permeffect.isEmpty()){
			return false;
		} 
		return true;
	}

	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.cards.Cards#toString(int)
	 */
	@Override
	public String toString(int count){
		StringBuilder builder = new StringBuilder();
		builder.append("Card number " + count + ":\n"
				+ "\tName: " + this.getName() + "\n"
				+ "\tID: " + this.getID() + "\n"
				+ "\tColor: " + this.getColor() + "\n"
				+ "\tPeriod: " + this.getPeriod() + "\n"
				);
		if(!((this.getCardCost()).isEmpty())){
			builder.append("\tCost:\n" + (this.getCardCost()).toStringCost() + "\n");
		}
		builder.append("Quick Effects:\n");
		for(int i=0; i<(this.getEffects()).size(); i++){
			builder.append("\t" + i + ": " + ((this.getEffects()).get(i)).toString() + "\n");
		}
		builder.append("\nPermanent Effects:\n");
		for(int i=0;  i<this.permeffect.size(); i++){
			builder.append("\t" + i + ": " + ((this.permeffect).get(i)).toString() + "\n");
		}
		return builder.toString();
	}
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.cards.Cards#toString()
	 */
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Current Card:\n"
				+ "\tName: " + this.getName() + "\n"
				+ "\tID: " + this.getID() + "\n"
				+ "\tColor: " + this.getColor() + "\n"
				+ "\tPeriod: " + this.getPeriod() + "\n"
				);
		if(!((this.getCardCost()).isEmpty())){
			builder.append("\tCost:\n" + (this.getCardCost()).toStringCost() + "\n");
		}
		builder.append("Quick Effects:\n");
		for(int i=0; i<(this.getEffects()).size(); i++){
			builder.append("\t" + i + ": " + ((this.getEffects()).get(i)).toString() + "\n");
		}
		builder.append("\nPermanent Effects:\n");
		for(int i=0;  i<this.permeffect.size(); i++){
			builder.append("\t" + i + ": " + ((this.permeffect).get(i)).toString() + "\n");
		}
		return builder.toString();
	}

	/**
	 * Gets the permeffect.
	 *
	 * @return the permeffect
	 */
	public List<Permanenteffect> getPermeffect() {
		return permeffect;
	}
	
	

}
