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
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HarvestEffect;
import it.polimi.ingsw.ps18.model.effect.harvestEffect.HashMapHE;
import it.polimi.ingsw.ps18.model.effect.permeffects.HashMapPermE;
import it.polimi.ingsw.ps18.model.effect.permeffects.IncreaseFMValueOnAction;
import it.polimi.ingsw.ps18.model.effect.permeffects.IncreaseFMValueOnActionWR;
import it.polimi.ingsw.ps18.model.effect.permeffects.Permanenteffect;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertResorResinResources;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertinPC;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ConvertinResources;
import it.polimi.ingsw.ps18.model.effect.prodEffect.HashMapPE;
import it.polimi.ingsw.ps18.model.effect.prodEffect.ProductionEffect;
import it.polimi.ingsw.ps18.model.personalboard.resources.Stats;

public class BonusTile extends Cards {
	private long harvValue;
	private List<HarvestEffect> harveffect = new ArrayList<>();
	private long productionValue;
	private List<ProductionEffect> prodEffect = new ArrayList<>(); 
	private List<Permanenteffect> permeffect = new ArrayList<>();
	private List<FinalEffect> fineffect = new ArrayList<>();
	
	public BonusTile(JSONObject a){
		HashMapHE mapHE = new HashMapHE();
		HashMapFE mapFE = new HashMapFE();

		this.setName((String) a.get("Name"));
		this.setID((long) a.get("ID"));
		this.harvValue = (long) a.get("HarvValue");
		this.setColor(-1);
		JSONArray heffects = (JSONArray) a.get("HarvestEffect");
		JSONArray heffectvalues = (JSONArray) a.get("HarvestEffectValue");
		addHEffects(heffects,heffectvalues,mapHE);
		this.productionValue = (long) a.get("ProductionValue");
		JSONArray peffects = (JSONArray) a.get("ProductionEffect");
		JSONArray peffectvalues = (JSONArray) a.get("ProductionEffectValue");
		addPEffects(peffects,peffectvalues);
		JSONArray permeffects = (JSONArray) a.get("PermanentEffect");
		JSONArray permeffectvalues = (JSONArray) a.get("PermanentEffectValue");
		addPermEffects(permeffects,permeffectvalues);
		JSONArray feffects = (JSONArray) a.get("FinalEffect");
		JSONArray feffectvalues = (JSONArray) a.get("FinalEffectValue");
		addFEffects(feffects,feffectvalues,mapFE);
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
	
	private boolean add(HarvestEffect e, long quantity){
		HarvestEffect a = e;
		a.setQuantity((int) quantity);	
	    return (this.getHarveffect()).add(a);
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
	
	private boolean add(ProductionEffect e, long quantity){
		ProductionEffect a = e;
		a.setQuantity((int) quantity);
	    return (this.getProdEffect()).add(a);	
    }
	
	private void addPermEffects(JSONArray peffects, JSONArray peffectvalues){
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
	
	private boolean add(Permanenteffect e, long quantity){
		Permanenteffect a = e;
		a.setQuantity((int) quantity);
	    return (this.getPermeffect()).add(a);	
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
	
	private boolean add(FinalEffect e, long quantity){
		FinalEffect a = e;
		a.setQuantity((int) quantity);
	    return (this.getFineffect()).add(a);	
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
		if(prodEffect.isEmpty()){
			return false;
		}
		return true;
	}

	@Override
	public boolean hasFinal() {
		if(fineffect.isEmpty()){
			return false;
		}
		return true;
	}

	@Override
	public boolean hasPermanent() {
		if(this.permeffect.isEmpty()){
			return false;
		} 
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n"
				+ "Name: " + this.getName() + "\n"
				+ "ID: " + this.getID() + "\n"
				);
		if(!this.harveffect.isEmpty()){
			builder.append("\tHarvest Value " + this.getHarvValue() + "\n");
			builder.append("Quick Effects:\n");
			for(int i=0; i<(this.getEffects()).size(); i++){
				builder.append("\t" + i + ": " + ((this.getEffects()).get(i)).toString() + "\n");
			}
		}
		if(!this.prodEffect.isEmpty()){
			builder.append("\tProduction Value " + this.getProductionValue() + "\n");
			builder.append("\nProduction Effects\n");
			for(int i=0;  i<this.prodEffect.size(); i++){
				builder.append("\t" + i + ": " + ((this.getProdEffect()).get(i)).toString() + "\n");
			}
		}
		if(!this.permeffect.isEmpty()){
			builder.append("\nFinal Effects:\n");
			for(int i=0;  i<this.permeffect.size(); i++){
				builder.append("\t" + i + ": " + ((this.permeffect).get(i)).toString() + "\n");
			}
		}
		if(!this.fineffect.isEmpty()){
			builder.append("\nFinal Effects\n");
			for(int i=0;  i<this.fineffect.size(); i++){
				builder.append("\t" + i + ": " + ((this.getFineffect()).get(i)).toString() + "\n");
			}
		}
		return builder.toString();
	}

	@Override
	public String toString(int count) {
		StringBuilder builder = new StringBuilder();
		builder.append("Card Number " + (count+1) 
				+ "\n\tName: " + this.getName() + "\n"
				+ "\tID: " + this.getID() + "\n"
				);
		if(!this.harveffect.isEmpty()){
			builder.append("\tHarvest Value: " + this.getHarvValue() + "\n");
			builder.append("\tHarvest Effects:\n");
			for(int i=0;  i<this.harveffect.size(); i++){
				builder.append("\t\t" + i + ": " + ((this.getHarveffect()).get(i)).toString() + "\n");
			}
		}
		if(!this.prodEffect.isEmpty()){
			builder.append("\tProduction Value " + this.getProductionValue() + "\n");
			builder.append("\tProduction Effects\n");
			for(int i=0;  i<this.prodEffect.size(); i++){
				builder.append("\t\t" + i + ": " + ((this.getProdEffect()).get(i)).toString() + "\n");
			}
		}
		if(!this.permeffect.isEmpty()){
			builder.append("\nPermanent Effects:\n");
			for(int i=0;  i<this.permeffect.size(); i++){
				builder.append("\t" + i + ": " + ((this.permeffect).get(i)).toString() + "\n");
			}
		}
		if(!this.fineffect.isEmpty()){
			builder.append("\nFinal Effects\n");
			for(int i=0;  i<this.fineffect.size(); i++){
				builder.append("\t" + i + ": " + ((this.getFineffect()).get(i)).toString() + "\n");
			}
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

	/**
	 * @return the productionValue
	 */
	public long getProductionValue() {
		return productionValue;
	}

	/**
	 * @param productionValue the productionValue to set
	 */
	public void setProductionValue(long productionValue) {
		this.productionValue = productionValue;
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

	/**
	 * @return the permeffect
	 */
	public List<Permanenteffect> getPermeffect() {
		return permeffect;
	}

	/**
	 * @param permeffect the permeffect to set
	 */
	public void setPermeffect(List<Permanenteffect> permeffect) {
		this.permeffect = permeffect;
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
	
	

}
