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
import it.polimi.ingsw.ps18.model.effect.prodEffect.*;
import it.polimi.ingsw.ps18.model.effect.quickEffect.HashMapQE;
import it.polimi.ingsw.ps18.model.effect.quickEffect.QuickEffect;
import it.polimi.ingsw.ps18.model.personalboard.PBoard;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public class YellowC extends Cards {
	private long productionValue;
	private List<ProductionEffect> prodEffect = new ArrayList<>();
	
	
	public YellowC(Integer i) {
		JSONParser parser = new JSONParser();
		HashMapQE mapQE = new HashMapQE();

	    try {
	    	Object obj = parser.parse(new FileReader("src/main/java/it/polimi/ingsw/ps18/model/cards/YellowC.json"));
	    	JSONObject jsonObject = (JSONObject) obj;
	        JSONObject a = (JSONObject) jsonObject.get(i.toString());
	        this.setName((String) a.get("name"));
	        this.setID((long) a.get("number"));
	        this.setColor((long) a.get("color"));
	        this.setPeriod((long) a.get("period"));
	        this.productionValue = (long) a.get("ProductionValue");
	        JSONArray cost = (JSONArray) a.get("CardCost");
	        this.setCardCost(new Stats(cost));
	        JSONArray qeffects = (JSONArray) a.get("QuickEffects");
	        JSONArray qeffectvalues = (JSONArray) a.get("QuickEffectsValues");
	        addQEffects(qeffects,qeffectvalues,mapQE);
	        JSONArray peffects = (JSONArray) a.get("ProductionEffects");
	        JSONArray peffectvalues = (JSONArray) a.get("ProductionEffectsValues");
	        addPEffects(peffects,peffectvalues);
	        
	    }catch (FileNotFoundException e) {
	        System.out.println("File non trovato.");

	    } catch (IOException e) {
		    System.out.println("IOException");
		} catch (org.json.simple.parser.ParseException e) {
			System.out.println("Problema nel parser");
		}
	}
	
	/**
	 * Usato per creare una copia di un acarta esistente ma con meno effetti.
	 * Sfruttato solo nella scelta degli effetti produzione da attivare.
	 */
	public YellowC() {
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
	
	private void addPEffects(JSONArray peffects, JSONArray peffectvalues){
		ProductionEffect effect;
		JSONArray statseffect;
		for(int count=0; count<peffects.size(); count++){
			HashMapPE map = new HashMapPE();
			if(peffects.get(count)!=null){
				switch((String) peffects.get(count)){
				case "ConvertResourcesInResources":
					effect = map.geteffect((String) peffects.get(count));
					statseffect = (JSONArray) peffectvalues.get(count);
					((ConvertinResources) effect).setStats((JSONArray) statseffect.get(0), (JSONArray) statseffect.get(1));
					this.prodEffect.add(count, effect);
					break;
				case "ConvertResourcesInPC":
					effect = map.geteffect((String) peffects.get(count));
					statseffect = (JSONArray) peffectvalues.get(count);
					((ConvertinPC) effect).setStats((JSONArray) statseffect.get(0), (long) statseffect.get(1));
					this.prodEffect.add(count, effect);
					break;
				case "ConvertResourcesOrResourcesInResources":
					effect = map.geteffect((String) peffects.get(count));
					statseffect = (JSONArray) peffectvalues.get(count);
					((ConvertResorResinResources) effect).setStats((long) statseffect.get(0), (JSONArray) statseffect.get(1));
					this.prodEffect.add(count, effect);
					break;
				default:
					if(peffectvalues.get(count)!=null){
	        			this.add(map.geteffect((String) peffects.get(count)), (long) peffectvalues.get(count));
	        		} else {
	        			this.prodEffect.add(map.geteffect((String) peffects.get(count)));
	        		}
				}
			}
		}
	}


	private boolean add(QuickEffect e, long quantity){
		QuickEffect a = e;
		a.setQuantity((int) quantity);
	    return (this.getEffects()).add(a);	
    }
	
	private boolean add(ProductionEffect e, long quantity){
		ProductionEffect a = e;
		a.setQuantity((int) quantity);
	    return (this.getProdEffect()).add(a);	
    }
	
	
	@Override
	public String toString(int count) {
		StringBuilder builder = new StringBuilder();
		builder.append("Card number " + count + ":\n"
				+ "\tName: " + this.getName() + "\n"
				+ "\tID: " + this.getID() + "\n"
				+ "\tColor: " + this.getColor() + "\n"
				+ "\tPeriod: " + this.getPeriod() + "\n"
				+ "\tProduction Value: " + this.getProductionValue() + "\n"
				+ "\tCost:\n" + (this.getCardCost()).toStringCost() + "\n"
				);
		builder.append("Quick Effects:\n");
		for(int i=0; i<(this.getEffects()).size(); i++){
			builder.append("\t" + i + ": " + ((this.getEffects()).get(i)).toString() + "\n");
		}
		builder.append("\nProduction Effects\n");
		for(int i=0;  i<this.prodEffect.size(); i++){
			builder.append("\t" + i + ": " + ((this.getProdEffect()).get(i)).toString() + "\n");
		}
		return builder.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Current Card:\n"
				+ "\tName: " + this.getName() + "\n"
				+ "\tID: " + this.getID() + "\n"
				+ "\tColor: " + this.getColor() + "\n"
				+ "\tPeriod: " + this.getPeriod() + "\n"
				+ "\tProduction Value " + this.getProductionValue() + "\n"
				+ "\tCost:\n" + (this.getCardCost()).toStringCost() + "\n"
				);
		builder.append("Quick Effects:\n");
		for(int i=0; i<(this.getEffects()).size(); i++){
			builder.append("\t" + i + ": " + ((this.getEffects()).get(i)).toString() + "\n");
		}
		builder.append("\nProduction Effects\n");
		for(int i=0;  i<this.prodEffect.size(); i++){
			builder.append("\t" + i + ": " + ((this.getProdEffect()).get(i)).toString() + "\n");
		}
		return builder.toString();
	}

	
	/**
	 * @return the value
	 */
	public int getProductionValue() {
		return (int) productionValue;
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

}
