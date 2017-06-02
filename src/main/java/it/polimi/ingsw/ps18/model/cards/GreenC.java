package it.polimi.ingsw.ps18.model.cards;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HashMapHE;
import it.polimi.ingsw.ps18.model.effect.quickEffect.HashMapQE;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;

public class GreenC extends Cards {
	private long harvValue;
	private List<HarvestEffect> harveffect = new ArrayList<>();
	Scanner input = new Scanner(System.in);
	
	public GreenC(Integer i){
		JSONParser parser = new JSONParser();

	    try {
	    	Object obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/Model/Cards/cards.json"));
	    	JSONObject jsonObject = (JSONObject) obj;
	        JSONObject a = (JSONObject) jsonObject.get(i.toString());
	        
	        this.setName((String) a.get("name"));
	        this.setID((long) a.get("number"));
	        this.setColor((long) a.get("color"));
	        this.setPeriod((long) a.get("period"));
	        this.harvValue = (long) a.get("HarvestValue");
	        JSONArray qeffects = (JSONArray) a.get("QuickEffects");
	        JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
	        for(int count=0; count<qeffects.size(); count++){
	        	if(qeffects.get(count)!=null){
	        		if(qeffectvalues.get(count)!=null){
	        			this.add(HashMapQE.geteffect((String) qeffects.get(count)), (long) qeffectvalues.get(count));
	        		} else {
	        			this.effects.add(HashMapQE.geteffect((String) qeffects.get(count)));
	        		}
	        	}
	        }
	        JSONArray heffects = (JSONArray) a.get("HarvestEffects");
	        JSONArray heffectvalues = (JSONArray) a.get("HarvestEffectsValues");
	        for(int count=0; count<heffects.size(); count++){
	        	if(heffects.get(count)!=null){
	        		if(heffectvalues.get(count)!=null){
	        			this.add(HashMapHE.geteffect((String) heffects.get(count)), (long) heffectvalues.get(count));
	        		} else {
	        			this.harveffect.add(HashMapHE.geteffect((String) heffects.get(count)));
	        		}
	        	}
	        }
	        
	        
	    }catch (FileNotFoundException e) {
	        System.out.println("File non trovato.");

	    } catch (IOException e) {
		    System.out.println("IOException");
		} catch (org.json.simple.parser.ParseException e) {
			System.out.println("Problema nel parser");
		}
	}
	
	
	private boolean add(QuickEffect e, long quantity){
	    boolean ris = this.effects.add(e);
	    if(ris){
		    e.setQuantity(Math.toIntExact(quantity));
		    return true;
	    }return false;		
    }
	
	private boolean add(HarvestEffect e, long quantity){
	    boolean ris = this.harveffect.add(e);
	    if(ris){
		    e.setQuantity(Math.toIntExact(quantity));
		    return true;
	    }return false;		
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
	

	
	

}
