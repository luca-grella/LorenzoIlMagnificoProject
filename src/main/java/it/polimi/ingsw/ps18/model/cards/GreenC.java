package it.polimi.ingsw.ps18.model.cards;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HashMapHE;
import it.polimi.ingsw.ps18.model.effect.quickEffect.HashMapQE;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

/**
 * The Class GreenC.
 */
public class GreenC extends Cards {
	
	/**
	 * The harv value.
	 */
	private long harvValue;
	
	/**
	 * The harveffect.
	 */
	private List<HarvestEffect> harveffect = new ArrayList<>();
	
	/**
	 * Instantiates a new green C.
	 *
	 * @param a the a
	 */
	public GreenC(JSONObject a){
		HashMapQE mapQE = new HashMapQE();
		HashMapHE mapHE = new HashMapHE();

		this.setName((String) a.get("name"));
		this.setID((long) a.get("number"));
		this.setColor((long) a.get("color"));
		this.setPeriod((long) a.get("period"));
		this.harvValue = (long) a.get("HarvestValue");
		this.setCardCost(new Stats(0,0,0,0,0,0,0));
		JSONArray qeffects = (JSONArray) a.get("QuickEffects");
		JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
		addQEffects(qeffects,qeffectvalues,mapQE);
		JSONArray heffects = (JSONArray) a.get("HarvestEffects");
		JSONArray heffectvalues = (JSONArray) a.get("HarvestEffectsValues");
		addHEffects(heffects,heffectvalues,mapHE);
	}
	
	
	/**
	 * Adds the H effects.
	 *
	 * @param heffects
	 *            the heffects
	 * @param heffectvalues
	 *            the heffectvalues
	 * @param map
	 *            the map
	 */
	private void addHEffects(JSONArray heffects, JSONArray heffectvalues, HashMapHE map) {
		for(int count=0; count<heffects.size(); count++){
        	if(heffects.get(count)!=null){
        		if(heffectvalues.get(count)!=null){
        			this.add(map.geteffect((String) heffects.get(count)), (long) heffectvalues.get(count));
        		} else {
        			this.harveffect.add(map.geteffect((String) heffects.get(count)));
        		}
        	}
		}
		
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
		for(int count=0; count<qeffects.size(); count++){
        	if(qeffects.get(count)!=null){
        		if(qeffectvalues.get(count)!=null){
        			this.add(map.geteffect((String) qeffects.get(count)), (long) qeffectvalues.get(count));
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
	 * Adds the.
	 *
	 * @param e
	 *            the e
	 * @param quantity
	 *            the quantity
	 * @return true, if successful
	 */
	private boolean add(HarvestEffect e, long quantity){
		HarvestEffect a = e;
		a.setQuantity((int) quantity);	
	    return (this.getHarveffect()).add(a);
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
				+ "\tHarvest Value " + this.getHarvValue() + "\n"
				);
		builder.append("Quick Effects:\n");
		for(int i=0; i<(this.getEffects()).size(); i++){
			builder.append("\t" + i + ": " + ((this.getEffects()).get(i)).toString() + "\n");
		}
		builder.append("\nHarvest Effects\n");
		for(int i=0;  i<this.harveffect.size(); i++){
			builder.append("\t" + i + ": " + ((this.getHarveffect()).get(i)).toString() + "\n");
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
				+ "\tHarvest Value " + this.getHarvValue() + "\n"
				);
		builder.append("Quick Effects:\n");
		for(int i=0; i<(this.getEffects()).size(); i++){
			builder.append("\t" + i + ": " + ((this.getEffects()).get(i)).toString() + "\n");
		}
		builder.append("\nHarvest Effects\n");
		for(int i=0;  i<this.harveffect.size(); i++){
			builder.append("\t" + i + ": " + ((this.getHarveffect()).get(i)).toString() + "\n");
		}
		return builder.toString();
	}

	/**
	 * Gets the harv value.
	 *
	 * @return the harvValue
	 */
	public long getHarvValue() {
		return harvValue;
	}

	/**
	 * Sets the harv value.
	 *
	 * @param harvValue
	 *            the harvValue to set
	 */
	public void setHarvValue(long harvValue) {
		this.harvValue = harvValue;
	}

	/**
	 * Gets the harveffect.
	 *
	 * @return the harveffect
	 */
	public List<HarvestEffect> getHarveffect() {
		return harveffect;
	}

	/**
	 * Sets the harveffect.
	 *
	 * @param harveffect
	 *            the harveffect to set
	 */
	public void setHarveffect(List<HarvestEffect> harveffect) {
		this.harveffect = harveffect;
	}


	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.cards.Cards#hasHarvest()
	 */
	@Override
	public boolean hasHarvest() {
		if(harveffect.isEmpty()){
			return false;
		}
		return true;
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
		return false;
	}
	
	
	

}
