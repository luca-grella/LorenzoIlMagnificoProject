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

public class GreenC extends Cards {
	private long harvValue;
	private List<HarvestEffect> harveffect = new ArrayList<>();
	
	public GreenC(Integer i){
		JSONParser parser = new JSONParser();
		HashMapQE mapQE = new HashMapQE();
		HashMapHE mapHE = new HashMapHE();

	    try {
	    	Object obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/model/cards/GreenC.json"));
	    	JSONObject jsonObject = (JSONObject) obj;
	        JSONObject a = (JSONObject) jsonObject.get(i.toString());
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
	        
	    }catch (FileNotFoundException e) {
	        System.out.println("File non trovato.");

	    } catch (IOException e) {
		    System.out.println("IOException");
		} catch (org.json.simple.parser.ParseException e) {
			System.out.println("Problema nel parser");
		}
	}
	
	
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


	private boolean add(QuickEffect e, long quantity){
		QuickEffect a = e;
		a.setQuantity((int) quantity);
	    return (this.getEffects()).add(a);	
    }
	
	private boolean add(HarvestEffect e, long quantity){
		HarvestEffect a = e;
		a.setQuantity((int) quantity);	
	    return (this.getHarveffect()).add(a);
    }
	
	@Override
	public void activateSecondaryEffect(PBoard player, int actionValue) {
		if(actionValue >= this.harvValue){
			for(int i=0; i<harveffect.size(); i++){
				HarvestEffect heffect = harveffect.get(i);
				heffect.activate(player);
			}
		}
		
	}
	
	@Override
	public boolean costCheck(Stats playerResources){
		return true;
	}
	
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
			builder.append("\t" + i + ": " + ((this.getEffects()).get(i)).toString());
		}
		builder.append("\nHarvest Effects\n");
		for(int i=0;  i<this.harveffect.size(); i++){
			builder.append("\t" + i + ": " + ((this.getHarveffect()).get(i)).toString());
		}
		return builder.toString();
	}

	/**
	 * @return the harvValue
	 */
	public long getHarvValue() {
		return harvValue;
	}

	/**
	 * @param harvValue the harvValue to set
	 */
	public void setHarvValue(long harvValue) {
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


	@Override
	public boolean hasHarvest() {
		if(harveffect.isEmpty()){
			return false;
		}
		return true;
	}


	@Override
	public boolean hasProduction() {
		return false;
	}


	@Override
	public boolean hasFinal() {
		return false;
	}
	
	
	

}
