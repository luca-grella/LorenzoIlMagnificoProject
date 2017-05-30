package it.polimi.ingsw.ps18.model.cards;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

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
	
	public GreenC(){
		HashMapQE.init();
		JSONParser parser = new JSONParser();
		Iterator iter;

	    try {
	    	
	    	
	        Object obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/Model/Cards/cards.json"));


	        JSONObject jsonObject = (JSONObject) obj;
	        //System.out.println(jsonObject);

	        Integer i=2;
	        JSONObject a = (JSONObject) jsonObject.get(i.toString());
	        this.setName((String) a.get("name"));
	        this.setID((long) a.get("number"));
	        this.setColor((long) a.get("color"));
	        this.setPeriod((long) a.get("period"));
	        this.harvValue = (long) a.get("HarvestValue");
	        JSONArray b = (JSONArray) a.get("QuickEffects");
	        QuickEffect prova = HashMapQE.geteffect((String) b.get(0));
        	this.effects.add(prova);
	        JSONArray c = (JSONArray) a.get("QuickEffectsValues");
	        long value = (long) c.get(0);
	        QuickEffect prova2 = this.effects.get(0);
	        prova2.setQuantity((int) value);
        	
	        
	        
	        
	   

	       
	    }catch (FileNotFoundException e) {
	        System.out.println("File non trovato.");

	    } catch (IOException e) {
		    System.out.println("IOException");
		} catch (org.json.simple.parser.ParseException e) {
			System.out.println("Problema nel parser");
		}
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
