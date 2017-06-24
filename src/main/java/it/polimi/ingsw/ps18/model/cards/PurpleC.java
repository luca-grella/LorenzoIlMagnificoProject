package it.polimi.ingsw.ps18.model.cards;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import it.polimi.ingsw.ps18.model.effect.finalEffect.FinalEffect;
import it.polimi.ingsw.ps18.model.effect.finalEffect.HashMapFE;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HashMapHE;
import it.polimi.ingsw.ps18.model.effect.quickEffect.HashMapQE;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;


// TODO: Auto-generated Javadoc
/**
 * The Class PurpleC.
 */
public class PurpleC extends Cards {
	
	/**
	 * The secondary cost.
	 */
	private Stats secondaryCost;
	
	/**
	 * The min MP.
	 */
	private long minMP;
	
	/**
	 * The fineffect.
	 */
	private List<FinalEffect> fineffect = new ArrayList<>();
	
	/**
	 * Instantiates a new purple C.
	 *
	 * @param i
	 *            the i
	 */
	public PurpleC(Integer i) {
		JSONParser parser = new JSONParser();
		HashMapQE mapQE = new HashMapQE();
		HashMapFE mapFE = new HashMapFE();

	    try {
	    	Object obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/model/cards/PurpleC.json"));
	    	JSONObject jsonObject = (JSONObject) obj;
	        JSONObject a = (JSONObject) jsonObject.get(i.toString());
	        
	        this.setName((String) a.get("name"));
	        this.setID((long) a.get("number"));
	        this.setColor((long) a.get("color"));
	        this.setPeriod((long) a.get("period"));
	        this.minMP = (long) a.get("minPM");
	        JSONArray costs = (JSONArray) a.get("PurpleCardCost");
	        setCosts(costs);
	        JSONArray qeffects = (JSONArray) a.get("QuickEffects");
	        JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
	        addQEffects(qeffects,qeffectvalues,mapQE);
	        JSONArray feffects = (JSONArray) a.get("FinalEffects");
	        JSONArray feffectvalues = (JSONArray) a.get("FinalEffectsValues");
	        addFEffects(feffects,feffectvalues,mapFE);
	        
	    }catch (FileNotFoundException e) {
	        System.out.println("File non trovato.");

	    } catch (IOException e) {
		    System.out.println("IOException");
		} catch (org.json.simple.parser.ParseException e) {
			System.out.println("Problema nel parser");
		}
	}
	
	/**
	 * Adds the F effects.
	 *
	 * @param feffects
	 *            the feffects
	 * @param feffectvalues
	 *            the feffectvalues
	 * @param map
	 *            the map
	 */
	private void addFEffects(JSONArray feffects, JSONArray feffectvalues, HashMapFE map) {
		for(int count=0; count<feffects.size(); count++){
        	if(feffects.get(count)!=null){
        		if(feffectvalues.get(count)!=null){
        			this.add(map.geteffect((String) feffects.get(count)), (long) feffectvalues.get(count));
        		} else {
        			this.fineffect.add(map.geteffect((String) feffects.get(count)));
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
	private boolean add(FinalEffect e, long quantity){
		FinalEffect a = e;
		a.setQuantity((int) quantity);
	    return (this.getFineffect()).add(a);	
    }
	
//	@Override
//	public void activateSecondaryEffect(PBoard player, int actionValue) {
//		for(int i=0; i<fineffect.size(); i++){
//			FinalEffect feffect = fineffect.get(i);
//			feffect.activate(player);
//		}	
//	}
	
	/**
 * Sets the costs.
 *
 * @param costs
 *            the new costs
 */
private void setCosts(JSONArray costs){
		if(this.minMP != 0){
			JSONArray cost1 = new JSONArray();
			JSONArray cost2 = new JSONArray();
			for(int i=0; i<costs.size(); i++){
				if(i==5){
					cost2.add((long) costs.get(5));
					cost1.add((long) 0);
				} else {
					cost1.add((long) costs.get(i));
					cost2.add((long) 0);
				}
			}
			this.setCardCost(new Stats(cost1));
			this.secondaryCost = new Stats(cost2);
		} else {
			this.setCardCost(new Stats(costs));
			this.secondaryCost = new Stats(0,0,0,0,0,0,0);
		}
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
		if(!(this.secondaryCost.isEmpty())){
			builder.append("\tRequired MP: " + this.minMP + "\n"
					+ "\tSecondary Cost:\n" + (this.secondaryCost).toStringCost() + "\n");
		}
		builder.append("Quick Effects:\n");
		for(int i=0; i<(this.getEffects()).size(); i++){
			builder.append("\t" + i + ": " + ((this.getEffects()).get(i)).toString() + "\n");
		}
		builder.append("\nFinal Effects\n");
		for(int i=0;  i<this.fineffect.size(); i++){
			builder.append("\t" + i + ": " + ((this.getFineffect()).get(i)).toString() + "\n");
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
		if(!(this.secondaryCost.isEmpty())){
			builder.append("\tRequired MP: " + this.minMP + "\n"
					+ "\tSecondary Cost:\n" + (this.secondaryCost).toStringCost() + "\n");
		}
		builder.append("Quick Effects:\n");
		for(int i=0; i<(this.getEffects()).size(); i++){
			builder.append("\t" + i + ": " + ((this.getEffects()).get(i)).toString() + "\n");
		}
		builder.append("\nFinal Effects\n");
		for(int i=0;  i<this.fineffect.size(); i++){
			builder.append("\t" + i + ": " + ((this.getFineffect()).get(i)).toString() + "\n");
		}
		return builder.toString();
	}
	
	
	/**
	 * Gets the fineffect.
	 *
	 * @return the fineffect
	 */
	public List<FinalEffect> getFineffect() {
		return fineffect;
	}
	
	/**
	 * Sets the fineffect.
	 *
	 * @param fineffect
	 *            the fineffect to set
	 */
	public void setFineffect(List<FinalEffect> fineffect) {
		this.fineffect = fineffect;
	}

	/**
	 * Gets the min MP.
	 *
	 * @return the minMP
	 */
	public int getMinMP() {
		return (int) minMP;
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
		if(fineffect.isEmpty()){
			return false;
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see it.polimi.ingsw.ps18.model.cards.Cards#hasPermanent()
	 */
	@Override
	public boolean hasPermanent() {
		return false;
	}
	

}
