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
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;


public class PurpleC extends Cards {
	private long minMP;
	private List<FinalEffect> fineffect = new ArrayList<>();
	
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
	        this.setCardCost(new Stats(costs));
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
	
	private boolean add(FinalEffect e, long quantity){
		FinalEffect a = e;
		a.setQuantity((int) quantity);
	    return (this.getFineffect()).add(a);	
    }
	
	
	/**
	 * @return the fineffect
	 */
	public List<FinalEffect> getFineffect() {
		return fineffect;
	}
	/**
	 * @param fineffect the fineffect to set
	 */
	public void setFineffect(List<FinalEffect> fineffect) {
		this.fineffect = fineffect;
	}

	/**
	 * @return the minMP
	 */
	public int getMinMP() {
		return (int) minMP;
	}
	
	
	
	

}
